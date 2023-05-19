using CODE_Interpreter.Operators;
namespace CODE_Interpreter.Grammar;

public class GrammarVisitor : GrammarBaseVisitor<object?>
{
    private Dictionary<string, object?> Functions { get; } = new();
    private Dictionary<string, object?> CharVar { get; } = new();
    private Dictionary<string, object?> IntVar { get; } = new();
    private Dictionary<string, object?> FloatVar { get; } = new();
    private Dictionary<string, object?> BoolVar { get; } = new();

    private readonly ArithmeticOperators _arithmeticOperators = new();

    private readonly List<string?> _compareOperators = new List<string?> { ">", "<", ">=", "<=", "==", "<>", "AND", "OR", "NOT" };

    public GrammarVisitor()
    {
        Functions["DISPLAY"] = new Func<object?[], object?>(VisitDisplay);
        Functions["SCAN"] = new Func<object?[], object?>(VisitScan);
    }

    private static object? VisitDisplay(object?[] args)
    {
        foreach (var arg in args)
        {
            if (arg == null)
            {
                Console.Error.WriteLine(" ERR! Incompatible type.");
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
            }
            else if (IntVar.ContainsKey(arg.ToString()!))
            {
                var str = userVariables[countVariables].Trim();
                var userInput = Convert.ToInt32(str);
                IntVar[arg.ToString()!] = userInput;
            }
            else if (FloatVar.ContainsKey(arg.ToString()!))
            {
                var str = userVariables[countVariables].Trim();
                var userInput = float.Parse(str);
                FloatVar[arg.ToString()!] = userInput;
            }
            else if (BoolVar.ContainsKey(arg.ToString()!))
            {
                var str = userVariables[countVariables].Trim();
                if (str is "TRUE" or "FALSE")
                    BoolVar[arg.ToString()!] = str;
                else
                {
                    Console.Error.WriteLine(" ERR! Expected a boolean value.");
                    Environment.Exit(1);
                }
            }
            else
            {
                Console.Error.WriteLine(" ERR! Identifier is not declared.");
                Environment.Exit(1);
            }
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
                Console.Error.WriteLine($" ERR! Invalid assignment! Expected to be {varDatatype}");
                Environment.Exit(1);
                break;
        }
    }

    private void VisitMultipleDeclaration(string varName)
    {
        var hasSame = CharVar.ContainsKey(varName) || IntVar.ContainsKey(varName) || FloatVar.ContainsKey(varName) || BoolVar.ContainsKey(varName);

        if (hasSame)
        {
            Console.Error.WriteLine($" ERR! Multiple declaration of Variable {varName}");
            Environment.Exit(1);
        }
    }

    public override object? VisitStatement(GrammarParser.StatementContext context)
    {
        var newLine = context.NEWLINE().ToString();

        if (!newLine!.Contains(Environment.NewLine))
        {
            Console.Error.WriteLine(" ERR! Invalid Code Format");
            Environment.Exit(1);
        }

        return base.VisitStatement(context);
    }

    public override object? VisitFunctionCall(GrammarParser.FunctionCallContext context)
    {
        var funcName = context.FUNCTIONNAME().GetText();
        var args = context.value().Select(Visit).ToArray();

        if (args.Length == 0)
        {
            Console.Error.WriteLine(" ERR! Display has no input");
            Environment.Exit(1);
        }
        
        var argType = context.value(0).GetType().ToString();
        if (argType == "CODE_Interpreter.GrammarParser+ConstantExpressionContext" &&
            (args[0] is int || args[0] is float))
        {
            Console.Error.WriteLine(" ERR! Invalid operands for concatenation");
            Environment.Exit(1);
        }

        if (!Functions.ContainsKey(funcName))
        {
            Console.Error.WriteLine($" ERR! Function {funcName} is not defined");
            Environment.Exit(1);
        }

        if (Functions[funcName] is Func<object?[], object?> func)
        {
            return func(args);
        }
        else
        {
            Console.Error.WriteLine($" ERR! {funcName} is not a function");
            Environment.Exit(1);
        }
        
        return null;
    }

    public override object VisitAssignList(GrammarParser.AssignListContext context)
    {
        var varName = context.VARIABLENAME().Select(Visit).ToArray();
        return varName;
    }

    public override object? VisitAssign(GrammarParser.AssignContext context)
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
                        Console.Error.WriteLine(" ERR! Error: The " + s + " is not initialized");
                        Environment.Exit(1);
                    }
                    else
                    {
                        Console.Error.WriteLine($" ERR! Invalid assignment! Expected to be CHAR");
                        Environment.Exit(1);
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
                        Console.Error.WriteLine($" ERR! {s} is not initialized");
                        Environment.Exit(1);
                        break;
                    default:
                        Console.Error.WriteLine(" ERR! Invalid assignment! Expected to be INT");
                        Environment.Exit(1);
                        break;
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
                        Console.Error.WriteLine($" ERR! {s} is not initialized");
                        Environment.Exit(1);
                        break;
                    default:
                        Console.Error.WriteLine(" ERR! Invalid assignment! Expected to be  FLOAT");
                        Environment.Exit(1);
                        break;
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
                        Console.Error.WriteLine($" ERR! {s} is not initialized");
                        Environment.Exit(1);
                        break;
                    default:
                        Console.Error.WriteLine(" ERR! Invalid assignment! Expected to be  BOOL");
                        Environment.Exit(1);
                        break;
                }
            }
            else
            {
                Console.Error.WriteLine($" ERR! Unknown symbol {s}");
                Environment.Exit(1);
            }
        }
        
        return null;
    }

    public override object? VisitVariableDeclaration(GrammarParser.VariableDeclarationContext context)
    {
        var varDatatype = context.DATATYPE().GetText();
        var varDeclarator = context.declaratorlist().GetText();
        var variableList = varDeclarator.Split(',');

        foreach (var variable in variableList)
        {
            if (variable.Contains('='))
            {
                var var = variable.Split('=');

                for (var i = 0; i < var.Length; i++)
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
                    else if (i + 1 < var.Length && var[i + 1] == "")
                    {
                        //1 == 2
                        var[i] += "==" + var[i + 2];
                        Array.Resize(ref var, var.Length - 2);
                    }

                }

                var variableName = var[0];

                if (char.IsDigit(variableName[0]))
                {
                    Console.Error.WriteLine($" ERR! {variableName} is invalid variable name.");
                    Environment.Exit(1);
                }

                var variableValue = var[^1];

                //if the value string contains any of the compare operators
                if (_compareOperators.Any(variableValue.Contains!))
                {
                    var decList = context.declaratorlist();
                    for (var i = 0; i < decList.ChildCount; i++)
                    {
                        var declarator = decList.declarator().value();
                        if (declarator.GetType() == typeof(GrammarParser.ComparisonExpressionContext))
                        {
                            variableValue = VisitComparisonExpression((GrammarParser.ComparisonExpressionContext)declarator)
                                ?.ToString();
                        }
                        if (declarator.GetType() == typeof(GrammarParser.LogicalExpressionContext))
                        {
                            variableValue = VisitLogicalExpression((GrammarParser.LogicalExpressionContext)declarator)
                                ?.ToString();
                        }
                    }
                }

                VisitMultipleDeclaration(variableName);

                switch (varDatatype)
                {
                    case "CHAR" when variableValue!.Length > 3:
                        Console.Error.WriteLine($" ERR! Expected a valid {varDatatype} value for {variableName}.");
                        Environment.Exit(1);
                        break;
                    case "CHAR":
                        CharVar[variableName] = variableValue[1..^1];
                        break;
                    case "INT":
                        {
                            var isInteger = int.TryParse(variableValue, out var intValue);
                            if (isInteger)
                                IntVar[variableName] = intValue;
                            else
                            {
                                Console.Error.WriteLine($" ERR! Expected a valid {varDatatype} value for {variableName}.");
                                Environment.Exit(1);
                            }
                            break;  
                        }
                    case "FLOAT":
                        {
                            var isFloat = float.TryParse(variableValue, out var floatValue);
                            if (isFloat)
                                FloatVar[variableName] = floatValue;
                            else
                            {
                                Console.Error.WriteLine($" ERR! Expected a valid {varDatatype} value for {variableName}.");
                                Environment.Exit(1);
                            }
                            break;
                        }
                    case "BOOL":
                        if (variableValue is "\"TRUE\"" or "\"FALSE\"")
                        {
                            BoolVar[variableName] = variableValue[1..^1];
                        }
                        else
                        {
                            Console.Error.WriteLine($" ERR! Expected a valid {varDatatype} value for {variableName}.");
                            Environment.Exit(1);
                        }
                        break;
                    default:
                        Console.Error.WriteLine($" ERR! {varDatatype} is not recognized as a data type. ");
                        Environment.Exit(1);
                        break;
                }

                VisitDefaultDeclaration(varDatatype, variable);
            }
            else
            {
                if (char.IsDigit(variable[0]))
                {
                    Console.Error.WriteLine($" ERR! {variable} is invalid variable name.");
                    Environment.Exit(1);
                    break;
                }
                
                VisitDefaultDeclaration(varDatatype, variable);
            }
        }
        return null;
    }

    public override object? VisitVariableNameExpression(GrammarParser.VariableNameExpressionContext context)
    {
        var varName = context.VARIABLENAME().GetText();
        
        if (context.parent.GetChild(0).ToString() == "SCAN")
            return varName;
        
        if (VisitVariableValueChecker(varName) != null)
            return VisitVariableValueChecker(varName);
        
        if (VisitVariableValueChecker(varName) == null)
        {
            Console.Error.WriteLine($" ERR! Variable {varName} is not defined");
            Environment.Exit(1);
        }

        return null;
    }

    public override object? VisitConstant(GrammarParser.ConstantContext context)
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
    
    public override object? VisitNewlineOperatorExpression(GrammarParser.NewlineOperatorExpressionContext context)
    {
        return context.NEWLINEOPERATOR() != null ? "\n" : null;
    }

    public override object VisitConcatenateExpression(GrammarParser.ConcatenateExpressionContext context)
    {
        var left = Visit(context.value(0))?.ToString();
        var right = Visit(context.value(1))?.ToString();
        var op = context.concatOperator().GetText();

        var leftValType = Visit(context.value(0));
        var rightValType = Visit(context.value(1));
        var leftType = context.value(0).GetType().ToString();
        var rightType = context.value(1).GetType().ToString();

        if (leftType == "CODE_Interpreter.GrammarParser+ConstantExpressionContext" &&
            (leftValType is int || leftValType is float))
        {
            Console.Error.WriteLine(" ERR! Invalid operands for concatenation");
            Environment.Exit(1);
        }

        if (rightType == "CODE_Interpreter.GrammarParser+ConstantExpressionContext" &&
            (rightValType is int || rightValType is float))
        {
            Console.Error.WriteLine("Invalid operands for concatenation");
            Environment.Exit(1);
        }
        
        if (op == "&")
        {
            if (!string.IsNullOrEmpty(left) && !string.IsNullOrEmpty(right))
            {
                return left + right;
            }
            Console.Error.WriteLine($" ERR! Invalid operands for concatenation: {(string.IsNullOrEmpty(left) ? "left" : "right")} " +
                                    "operand is null or empty.");
            Environment.Exit(1);
        }

        Console.Error.WriteLine($" ERR! Invalid concatenation operator: '{op}'");
        Environment.Exit(1);

        return null;
    }

    public override object? VisitParenthesisExpression(GrammarParser.ParenthesisExpressionContext context)
    {
        return Visit(context.value());
    }

    public override object? VisitAdditiveExpression(GrammarParser.AdditiveExpressionContext context)
    {
        var leftValue = Visit(context.value(0));
        var rightValue = Visit(context.value(1));
        var operators = context.addMinOperators().GetText();
        switch(operators)
        {
            case "+": 
                return _arithmeticOperators.VisitAdd(leftValue, rightValue);
            case "-":
                return _arithmeticOperators.VisitSubtract(leftValue, rightValue);
            default:    
                 Console.Error.WriteLine($" ERR! {operators} is not recognized as an additive operator.");
                 Environment.Exit(1);
                 break;
        }

        return null;
    }

    public override object? VisitMultiplicativeExpression(GrammarParser.MultiplicativeExpressionContext context)
    {
        var leftValue = Visit(context.value(0));
        var rightValue = Visit(context.value(1));
        var operators = context.mulDivOperators().GetText();
        switch (operators)
        { 
                case "*": 
                    return _arithmeticOperators.VisitMultiply(leftValue, rightValue);
                case "/": 
                    return _arithmeticOperators.VisitDivide(leftValue, rightValue);
                case "%": 
                    return _arithmeticOperators.VisitModulo(leftValue, rightValue);
                default:
                    Console.Error.WriteLine($" ERR! {operators} is not recognized as an multiplicative operator.");
                    Environment.Exit(1);
                    break;
        }

        return null;
    }

    public override object? VisitComparisonExpression(GrammarParser.ComparisonExpressionContext context)
    {
        var leftVal = Visit(context.value(0))?.ToString();
        var rightVal = Visit(context.value(1))?.ToString();
        var op = context.compareOperators().GetText();

        float floatValue;

        //">", "<", ">=", "<=", "==", "<>"
        if (op == ">")
        {
            if (float.TryParse(leftVal, out floatValue) && float.TryParse(rightVal, out floatValue))
            {
                return float.Parse(leftVal) > float.Parse(rightVal) ? "TRUE" : "FALSE";
            }

            Console.Error.WriteLine(" ERR! Incompatible data types");
            Environment.Exit(1);
        }
        else if (op == "<")
        {
            if (float.TryParse(leftVal, out floatValue) && float.TryParse(rightVal, out floatValue))
            {
                return float.Parse(leftVal) < float.Parse(rightVal) ? "TRUE" : "FALSE";
            }

            Console.Error.WriteLine(" ERR! Incompatible data types");
            Environment.Exit(1);
        }
        else if (op == ">=")
        {
            if (float.TryParse(leftVal, out floatValue) && float.TryParse(rightVal, out floatValue))
            {
                return float.Parse(leftVal) >= float.Parse(rightVal) ? "TRUE" : "FALSE";
            }

            Console.Error.WriteLine(" ERR! Incompatible data types");
            Environment.Exit(1);
        }
        else if (op == "<=")
        {
            if (float.TryParse(leftVal, out floatValue) && float.TryParse(rightVal, out floatValue))
            {
                return float.Parse(leftVal) <= float.Parse(rightVal) ? "TRUE" : "FALSE";
            }

            Console.Error.WriteLine(" ERR! Incompatible data types");
            Environment.Exit(1);
        }
        else if (op == "==")
        {
            if (float.TryParse(leftVal, out floatValue) && float.TryParse(rightVal, out floatValue))
            {
                return EqualityComparer<float>.Default.Equals(float.Parse(leftVal), float.Parse(rightVal)) ? "TRUE" : "FALSE";
            }
            else
            {
                if (leftVal == null)
                {
                    Console.Error.WriteLine(" ERR! Nothing to compare");
                    Environment.Exit(1);
                    return null; 
                }

                return !leftVal.Equals(rightVal) ? "TRUE" : "FALSE";
            }
        }
        else if (op == "<>")
        {
            if (float.TryParse(leftVal, out floatValue) && float.TryParse(rightVal, out floatValue))
            {
                return !EqualityComparer<float>.Default.Equals(float.Parse(leftVal), float.Parse(rightVal)) ? "TRUE" : "FALSE";
            }
            else
            {
                if (leftVal == null)
                {
                    Console.Error.WriteLine(" ERR! Nothing to compare");
                    Environment.Exit(1);
                    return null; 
                }

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

    public override object? VisitLogicalExpression(GrammarParser.LogicalExpressionContext context)
    {
        var leftVal = Visit(context.value(0))?.ToString();
        var logOp = context.logicalOperators().GetText();
        var rightVal = "";
        if (logOp != "NOT")
        {
            try
            {
                rightVal = Visit(context.value(1))?.ToString();
            }
            catch (Exception e)
            {
                Console.Error.WriteLine(" ERR! Invalid logical operation statement.");
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

    public override object? VisitConditionalStatement(GrammarParser.ConditionalStatementContext context)
    {
        var checker = false;
        for (var i = 0; i < context.ChildCount; i++)
        {
            if (context.GetChild(i).GetChild(0).GetText() == "IF")
            {
                var res = VisitIfStatement((GrammarParser.IfStatementContext)context.GetChild(i));
                if (res != null)
                {
                    break;
                }
            }
            else if (context.GetChild(i).GetChild(0).GetText() == "ELSE IF")
            {
                var res = VisitElseifStatement((GrammarParser.ElseifStatementContext)context.GetChild(i));
                if (res != null)
                {
                    break;
                }
            }
            else if (context.GetChild(i).GetChild(0).GetText() == "ELSE")
            {
                return VisitElseStatement((GrammarParser.ElseStatementContext)context.GetChild(i));
            }
        }
        return null;
    }


    public override object? VisitIfStatement(GrammarParser.IfStatementContext context)
    {
        var value = Visit(context.value());

        if (value?.ToString() == "TRUE")
        {
            base.VisitIfStatement(context);
            return true;
        }
        else if (value?.ToString() == "FALSE")
        {
            return null;
        }
        else
        {
            Console.Error.WriteLine(" ERR! Invalid boolean expression on IF statement");
            Environment.Exit(1);
            return null;
        }
    }

    public override object? VisitElseifStatement(GrammarParser.ElseifStatementContext context)
    {
        var value = Visit(context.value());

        if (value?.ToString() == "TRUE")
        {
            base.VisitElseifStatement(context);
            return true;
        }
        if (value?.ToString() == "FALSE")
        {
            return null;
        }
        
        Console.Error.WriteLine(" ERR! Invalid boolean expression on ELSE IF statement");
        Environment.Exit(1);
        return null;
    
    }

    public override object? VisitWhileBlock(GrammarParser.WhileBlockContext context)
    {
        base.VisitWhileBlock(context);
        return true;
    }

    public override object? VisitWhileCondition(GrammarParser.WhileConditionContext context)
    {
        var state = Visit(context.value());
        while (state is string and "TRUE")
        {
            Visit(context.whileBlock());
            state = Visit(context.value());
        }
        return null;
    }

    public override object? VisitSwitchCondition(GrammarParser.SwitchConditionContext context)
    {
        var valueContext = Visit(context.value());
        var switchValue = valueContext!.ToString();
        Console.WriteLine(switchValue);
        VisitSwitchBlock(context.switchBlock(), switchValue!);
        return null;
    }

    private object? VisitSwitchBlock(GrammarParser.SwitchBlockContext context, string switchValue)
    {
        var visited = false;
        foreach (var caseContext in context.caseBlock())
        {
            if (caseContext.value().GetText() == switchValue)
            {
                VisitCaseBlock(caseContext);
                visited = true;
                break;
            }
        }

        if (!visited && context.defaultBlock() != null)
        {
            VisitDefaultBlock(context.defaultBlock());
        }
        return null;
    }

    public override object? VisitCaseBlock(GrammarParser.CaseBlockContext context)
    {
        base.VisitCaseBlock(context);
        return true;
    }

    public override object? VisitDefaultBlock(GrammarParser.DefaultBlockContext context)
    {
        base.VisitDefaultBlock(context);
        return true;
    }

    public override object? VisitElseStatement(GrammarParser.ElseStatementContext context)
    {
        return base.VisitElseStatement(context);
    }
}