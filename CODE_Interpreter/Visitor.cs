namespace CODE_Interpreter;

public class Visitor : SimpleBaseVisitor<object?>
{
    private Dictionary<string, object?> Functions { get; } = new();
    private Dictionary<string, object?> CharVar { get; } = new();
    private Dictionary<string, object?> IntVar { get; } = new();
    private Dictionary<string, object?> FloatVar { get; } = new();
    private Dictionary<string, object?> BoolVar { get; } = new();

    private readonly ArithmeticOperators _arithmeticOperators = new();

    private readonly List<string?> _compareOperators = new List<string?> { ">", "<", ">=", "<=", "==", "<>", "AND", "OR", "NOT" };
    
    public Visitor()
    {
        Functions["DISPLAY"] = new Func<object?[], object?>(VisitDisplay);
        Functions["SCAN"] = new Func<object?[], object?>(VisitScan);
    }
    
    private object? VisitDisplay(object?[] args)
    {
        foreach (var arg in args)
        {
            if (arg == null)
            {
                Console.Error.WriteLine("Error: Incompatible type null.");
            }
            Console.Write(arg);
        }

        return null;
    }
    
    private object? VisitScan(object?[] args)
    {
        Console.Write("SCAN: ");
        var input = Console.ReadLine() ?? throw new InvalidOperationException();
        var userVariables = input.Split(',');
        var countVariables = 0;
        
        foreach (var arg in args)
        {
            if (CharVar.ContainsKey(arg!.ToString()!))
            {
                var str = userVariables[countVariables].Trim();
                var userInput = Convert.ToChar(str);
                CharVar[arg.ToString()!] = userInput;
            }else if (IntVar.ContainsKey(arg.ToString()!))
            {
                var str = userVariables[countVariables].Trim();
                var userInput = Convert.ToInt32(str);
                IntVar[arg.ToString()!] = userInput;
            }else if (FloatVar.ContainsKey(arg.ToString()!))
            {
                var str = userVariables[countVariables].Trim();
                var userInput = float.Parse(str);
                FloatVar[arg.ToString()!] = userInput;
            }else if (BoolVar.ContainsKey(arg.ToString()!))
            {
                var str = userVariables[countVariables].Trim();
                var userInput = str;
                if(userInput is "TRUE" or "FALSE")
                    BoolVar[arg.ToString()!] = userInput;
                else
                    throw new Exception("Error: Expected a boolean value.");
            }
            else
                throw new Exception("Error: Identifier is not declared.");
            
            countVariables++;
        }  
        return null;
    }

    private void VisitDefaultDeclaration(string varDatatype, string varName)
    {
        VisitMultipleDeclaration(varName);
        switch (varDatatype)
        {
            case "CHAR":
                CharVar[varName] = null;
                break;
            case "INT":
                IntVar[varName] = null;
                break;
            case "FLOAT":
                FloatVar[varName] = null;
                break;
            case "BOOL":
                BoolVar[varName] = null;
                break;
            default:
                throw new Exception($"Invalid assignment for variable {varName}: expected to be {varDatatype}");
        }
    }

    private void VisitMultipleDeclaration(string varName)
    {
        var hasSame = CharVar.ContainsKey(varName) || IntVar.ContainsKey(varName) || FloatVar.ContainsKey(varName) || BoolVar.ContainsKey(varName);

        if (hasSame)
            throw new Exception($"Multiple declaration of Variable {varName}");
    }

    public override object? VisitStatement(SimpleParser.StatementContext context)
    {
        var newLine = context.NEWLINE().ToString();

        if (!newLine!.Contains(Environment.NewLine))
        {
            throw new Exception("Syntax Error: Invalid Code Format");
        }
        
        return base.VisitStatement(context);
    }

    public override object? VisitFunctionCall(SimpleParser.FunctionCallContext context)
    {
        var funcName = context.FUNCTIONNAME().GetText();
        var args = context.value().Select(Visit).ToArray();
        
        if(args.Length == 0)
            throw new Exception($"Display has no input");
        
        var argType = context.value(0).GetType().ToString();
        if (argType == "CODE_Interpreter.GrammarParser+ConstantExpressionContext" &&
            (args[0] is int || args[0] is float))
        {
            throw new Exception($"Invalid operands for concatenation");
        }

        if (!Functions.ContainsKey(funcName))
        {
            throw new Exception($"Function {funcName} is not defined");
        }

        if (Functions[funcName] is not Func<object?[], object?> func)
        {
            throw new Exception($"{funcName} is not a function");
        }
        
        return func(args);
    }

    public override object? VisitAssignList(SimpleParser.AssignListContext context)
    {
        var varName = context.VARIABLENAME().Select(Visit).ToArray();
        return varName;
    }

    public override object? VisitAssign(SimpleParser.AssignContext context)
    {
        var varName = context.assignList().GetText();
        var ass = varName.Split('=');
        var value = Visit(context.value());
        
        foreach (var s in ass)
        {
            if (CharVar.ContainsKey(s))
            {
                if (value is string | value is char)
                {
                    CharVar[s] = value;
                }
                else
                {
                    if (value == null)
                    {
                        Console.Error.WriteLine("Error: The " + s + " is not initialized");

                    }
                    else
                    {
                        throw new Exception($"Invalid assignment for variable {varName}: expected to be CHAR");
                    }
                }
            }
            else if (IntVar.ContainsKey(s))
            {
                switch (value)
                {
                    case int intValue:
                        IntVar[s] = intValue;
                        break;
                    case null:
                        Console.Error.WriteLine( s + " is not initialized");
                        break;
                    default:
                        throw new Exception($"Invalid assignment! Expected to be INT");
                }
            }
            else if (FloatVar.ContainsKey(s))
            {
                switch (value)
                {
                    case float floatValue:
                        FloatVar[s] = floatValue;
                        break;
                    case null:
                        Console.Error.WriteLine( s + " is not initialized");
                        break;
                    default:
                        throw new Exception($"Invalid assignment! Expected to be  FLOAT");
                }
            }
            else if (BoolVar.ContainsKey(s))
            {
                switch (value)
                {
                    case "TRUE":
                    case "FALSE":
                        BoolVar[s] = value;
                        break;
                    case null:
                        Console.Error.WriteLine( s + " is not initialized");
                        break;
                    default:
                        throw new Exception($"Invalid assignment! Expected to be  BOOL");
                }
            }
            else
            {
                throw new Exception($"Error: Unknown symbol {s}");
            }
        }
        return null;
    }
    public override object? VisitVardec(SimpleParser.VardecContext context)
    {
        var varDatatype = context.DATATYPE().GetText();
        var varDeclarator = context.declaratorlist().GetText();
        var variableList = varDeclarator.Split(',');

        foreach (var variable in variableList)
        {
            if (variable.Contains('='))
            {
                var var = variable.Split('=');
                
                for(var i =0; i < var.Length; i++)
                {
                    //ex: a = 1>=5   =>    {"a", "1>", "5"}
                    //so we need to check the last character in each string to identify the compare operators ">=, <=, =="
                    if (_compareOperators.Contains(var[i][^1].ToString()))
                    {
                        var[i] += "=" + var[i + 1];
                        Array.Resize(ref var, var.Length - 1);
                    }
                    //if "==", it will create a string with empty string
                    //ex "a = 1==1" => var = { "a", "1", "", "2"}
                    else if (i+1 < var.Length && var[i + 1] == "")
                    {
                        //1 == 2
                        var[i] += "==" + var[i + 2];
                        Array.Resize(ref var, var.Length - 2);
                    }
                    
                }

                var variableName = var[0];
                
                if (char.IsDigit(variableName[0]))
                {
                    throw new Exception($"Syntax Error: {variableName } is invalid variable name.");
                }
                
                var variableValue = var[^1];
                
                //if the value string contains any of the compare operators
                if (_compareOperators.Any(variableValue.Contains!))
                {
                    var decList = context.declaratorlist();
                    for (int i = 0; i < decList.ChildCount; i++)
                    {
                        var declarator = decList.declarator().value();
                        if (declarator.GetType() == typeof(SimpleParser.ComparisonExpressionContext))
                        {
                            variableValue = VisitComparisonExpression((SimpleParser.ComparisonExpressionContext)declarator)
                                ?.ToString();
                        }
                        if (declarator.GetType() == typeof(SimpleParser.LogicalExpressionContext))
                        {
                            variableValue = VisitLogicalExpression((SimpleParser.LogicalExpressionContext)declarator)
                                ?.ToString();
                        }
                    }
                }
                
                VisitMultipleDeclaration(variableName);
                
                switch (varDatatype)
                {
                    case "CHAR" when variableValue!.Length > 3:
                        throw new Exception($"Error: {variableValue} is not a valid character value.");
                    case "CHAR":
                        CharVar[variableName] = variableValue[1..^1];
                        break;
                    case "INT":
                    {
                        var isInteger = int.TryParse(variableValue, out var intValue);
                        if (isInteger)
                            IntVar[variableName] = intValue;
                        else   
                            throw new Exception($"Error: {variableValue} is not a valid integer value.");
                        break;
                    }
                    case "FLOAT":
                    {
                        var isFloat = float.TryParse(variableValue, out var floatValue);
                        if (isFloat)
                            FloatVar[variableName] = floatValue;
                        else
                            throw new Exception($"Error: {variableValue} is not a valid floating value.");
                        break;
                    }
                    case "BOOL" when variableValue is "\"TRUE\"" or "\"FALSE\"":
                        BoolVar[variableName] = variableValue[1..^1];
                        break;
                    case "BOOL":
                        throw new Exception($"Error: {variableValue} is not a valid boolean value.");
                    default:
                        throw new Exception($"Error: {varDatatype} is not recognized as a data type. ");
                }

                VisitDefaultDeclaration(varDatatype, variable);
            }
            else
            { 
                if (char.IsDigit(variable[0]))
                {
                    throw new Exception($"Syntax Error: {variable} is invalid variable name.");
                }
                VisitDefaultDeclaration(varDatatype, variable);

            }
        }
        return null;
    }

    public override object? VisitVariablenameExpression(SimpleParser.VariablenameExpressionContext context)
    {
        var varName = context.VARIABLENAME().GetText();
        if (context.parent.GetChild(0).ToString() == "SCAN")
        {
            return varName;
        }

        if (VisitVariableValueChecker(varName) != null)
            return VisitVariableValueChecker(varName);
        else
           throw new Exception($"Variable {varName} is not defined");
    }

    public override object? VisitConstant(SimpleParser.ConstantContext context)
    {
        if (context.INTEGERVAL() != null)
        {
            return int.Parse(context.parent.GetText());
        }

        if (context.FLOATVAL() != null)
        {
            return float.Parse(context.parent.GetText());
        }

        if (context.CHARVAL() is { } c)
        {
            return c.GetText()[1..^1];
        }

        if (context.BOOLVAL() != null)
        {
            return context.BOOLVAL().GetText() == "TRUE";
        }

        if (context.STRINGVAL() is { } s)
        {
            return s.GetText()[1..^1];
        }
        
        return null;
    }

    public override object? VisitNewlineopExpression(SimpleParser.NewlineopExpressionContext context)
    {
        if (context.NEWLINEOP() != null)
            return "\n";
        
        return null;
    }

    public override object? VisitConcatenateExpression(SimpleParser.ConcatenateExpressionContext context)
    {
        var left = Visit(context.value(0))?.ToString();
        var right = Visit(context.value(1))?.ToString();
        var op = context.concOp().GetText();

        var leftValType = Visit(context.value(0));
        var rightValType = Visit(context.value(1));
        var leftType = context.value(0).GetType().ToString();
        var rightType = context.value(1).GetType().ToString();

        if(leftType == "CODE_Interpreter.GrammarParser+ConstantExpressionContext" && (leftValType is int || leftValType is float))
            throw new Exception($"Invalid operands for concatenation");
        if(rightType == "CODE_Interpreter.GrammarParser+ConstantExpressionContext" && (rightValType is int || rightValType is float)) 
            throw new Exception($"Invalid operands for concatenation");
        
        if (op == "&")
        {
            if (!string.IsNullOrEmpty(left) && !string.IsNullOrEmpty(right))
            {
                return left + right;
            }
            throw new Exception($"Invalid operands for concatenation: {(string.IsNullOrEmpty(left) ? "left" : "right")} operand is null or empty.");
        }

        throw new Exception($"Invalid concatenation operator: '{op}'");
    }
    
    public override object? VisitParenthesisExpression(SimpleParser.ParenthesisExpressionContext context)
    {
        return Visit(context.value());
    }

    public override object? VisitAdditiveExpression(SimpleParser.AdditiveExpressionContext context)
    {
        var leftValue = Visit(context.value(0));
        var rightValue = Visit(context.value(1));
        var operators = context.addMinOp().GetText();
        return operators switch
        {
            "+" => _arithmeticOperators.VisitAdd(leftValue, rightValue),
            "-" => _arithmeticOperators.VisitSubtract(leftValue, rightValue),
            _ => throw new Exception($"Error: {operators} is not recognized as an additive operator.")
        };
    }

    public override object? VisitMultiplicativeExpression(SimpleParser.MultiplicativeExpressionContext context)
    {
        var leftValue = Visit(context.value(0));
        var rightValue = Visit(context.value(1));
        var operators = context.mulDivOp().GetText();
        return operators switch
        {
            "*" => _arithmeticOperators.VisitMultiply(leftValue, rightValue),
            "/" => _arithmeticOperators.VisitDivide(leftValue, rightValue),
            "%" => _arithmeticOperators.VisitModulo(leftValue, rightValue),
            _ => throw new Exception($"Error: {operators} is not recognized as an multiplicative operator.")
        };
    }
    
    public override object? VisitComparisonExpression(SimpleParser.ComparisonExpressionContext context)
    {
        var leftVal = Visit(context.value(0))?.ToString();
        var rightVal = Visit(context.value(1))?.ToString();
        var op = context.compareOp().GetText();
        
        float floatValue;

        //">", "<", ">=", "<=", "==", "<>"
        if (op == ">")
        {
            if (float.TryParse(leftVal, out floatValue) && float.TryParse(rightVal, out floatValue))
            {
                return float.Parse(leftVal) > float.Parse(rightVal) ? "TRUE" : "FALSE";
            }

            throw new Exception("Incompatible data types");
        }else if (op == "<")
        {
            if (float.TryParse(leftVal, out floatValue) && float.TryParse(rightVal, out floatValue))
            {
                return float.Parse(leftVal) < float.Parse(rightVal) ? "TRUE" : "FALSE";
            }

            throw new Exception("Incompatible data types");
        }else if (op == ">=")
        {
            if (float.TryParse(leftVal, out floatValue) && float.TryParse(rightVal, out floatValue))
            {
                return float.Parse(leftVal) >= float.Parse(rightVal) ? "TRUE" : "FALSE";
            }

            throw new Exception("Incompatible data types");
        }else if (op == "<=")
        {
            if (float.TryParse(leftVal, out floatValue) && float.TryParse(rightVal, out floatValue))
            {
                return float.Parse(leftVal) <= float.Parse(rightVal) ? "TRUE" : "FALSE";
            }

            throw new Exception("Incompatible data types");
        }else if (op == "==")
        {
            if (float.TryParse(leftVal, out floatValue) && float.TryParse(rightVal, out floatValue))
            {
                return EqualityComparer<float>.Default.Equals(float.Parse(leftVal), float.Parse(rightVal)) ? "TRUE" : "FALSE";
            }
            else
            {
                if (leftVal == null) throw new Exception("Nothing to compare");
                
                return leftVal.Equals(rightVal) ? "TRUE" : "FALSE";
            }
        }else if (op == "<>")
        {
            if (float.TryParse(leftVal, out floatValue) && float.TryParse(rightVal, out floatValue))
            {
                return !EqualityComparer<float>.Default.Equals(float.Parse(leftVal), float.Parse(rightVal)) ? "TRUE" : "FALSE";
            }
            else
            {
                if (leftVal == null) throw new Exception("Nothing to compare");
                
                return !leftVal.Equals(rightVal) ? "TRUE" : "FALSE";
            }
        }
        return null;
    }

    private object? VisitVariableValueChecker(string varName)
    {
        if (CharVar.TryGetValue(varName, out var checker))
        {
            return checker;
        }
        if (IntVar.TryGetValue(varName, out var valueChecker))
        {
            return valueChecker;
        }
        if (FloatVar.TryGetValue(varName, out var variableValueChecker))
        {
            return variableValueChecker;
        }
        return BoolVar.TryGetValue(varName, out var checker1) ? checker1 : null;
    }

    public override object? VisitLogicalExpression(SimpleParser.LogicalExpressionContext context)
    {
        var leftVal = Visit(context.value(0))?.ToString();
        var logOp = context.logicalOp().GetText();
        string? rightVal = "";
        if (logOp != "NOT")
        {
            try
            {
                rightVal = Visit(context.value(1))?.ToString();
            }
            catch (Exception e)
            {
                Console.Error.WriteLine("System Error: Invalid logical operation statement.");
                Environment.Exit(1);
            }
        }

        switch (logOp)
        {
            case "AND":
                return leftVal == "TRUE" && rightVal == "TRUE" ? "TRUE" : "FALSE";
            case "OR":
                return leftVal == "TRUE" || rightVal == "TRUE" ? "TRUE" : "FALSE";
            case "NOT":
                return leftVal == "TRUE" ? "FALSE" : "TRUE";
            default:
                return base.VisitLogicalExpression(context);
        }
    }

    public override object? VisitCondstmt(SimpleParser.CondstmtContext context)
    {
        bool checker = false;
        for (int i = 0; i < context.ChildCount; i++)
        {
            if (context.GetChild(i).GetChild(0).GetText() == "IF")
            {
                var res = VisitIfstmt((SimpleParser.IfstmtContext)context.GetChild(i));
                if (res != null)
                {
                    break;
                }
            }
            else if (context.GetChild(i).GetChild(0).GetText() == "ELSE IF")
            {
                var res = VisitElseifstmt((SimpleParser.ElseifstmtContext)context.GetChild(i));
                if (res != null)
                {
                    break;
                }
            }
            else if (context.GetChild(i).GetChild(0).GetText() == "ELSE" )
            {
                return VisitElsestmt((SimpleParser.ElsestmtContext)context.GetChild(i));
            }
        }
        return null;
    }


    public override object? VisitIfstmt(SimpleParser.IfstmtContext context)
    {
        var value = Visit(context.value());

        if (value?.ToString() == "TRUE")
        {
            base.VisitIfstmt(context);
            return true;
        }
        else if (value?.ToString() == "FALSE")
        {
            return null;
        }
        else
        {
            Console.Error.WriteLine("Invalid boolean expression on IF statement");
            Environment.Exit(1);
            return null;
        }
    }

    public override object? VisitElseifstmt(SimpleParser.ElseifstmtContext context)
    {
        var value = Visit(context.value());

        if (value?.ToString() == "TRUE" || value?.ToString() == "FALSE")
        {
            base.VisitElseifstmt(context);
            return true;
        }
        else if (value?.ToString() == "FALSE")
        {
            return null;
        }
        else
        {
            Console.Error.WriteLine("Invalid boolean expression on ELSE IF statement");
            Environment.Exit(1);
            return null;
        }
    }

    public override object? VisitElsestmt(SimpleParser.ElsestmtContext context)
    {
        return base.VisitElsestmt(context);
    }
}