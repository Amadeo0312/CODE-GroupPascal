using System.Runtime.CompilerServices;

namespace CODE_Interpreter;

public class Visitor : SimpleBaseVisitor<object?>
{   
    public Dictionary<string, object?> Functions { get; } = new();
    public Dictionary<string, object?> CharVar { get; } = new();
    public Dictionary<string, object?> IntVar { get; } = new();
    public Dictionary<string, object?> FloatVar { get; } = new();
    public Dictionary<string, object?> BoolVar { get; } = new();
    
    
    public Visitor()
    {
        Functions["DISPLAY"] = new Func<object?[], object?>(Display);
    }

    private object? Display(object?[] args)
    {
        foreach (var arg in args)
        {
            if (arg == null)
            {
                Console.Error.WriteLine("Error: incompatible type null.");
            }
            Console.WriteLine(arg);
        }

        return null;
    }

    public void DefaultDeclaration(string varDatatype, string varName)
    {
        MultipleDeclaration(varName);
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
    
    public void MultipleDeclaration(string varName)
    {
        bool hasSame = CharVar.ContainsKey(varName) || IntVar.ContainsKey(varName) || FloatVar.ContainsKey(varName) || BoolVar.ContainsKey(varName);

        if (hasSame)
            throw new Exception($"Multiple declaration of Variable {varName}");
    }

    public override object? VisitStatement(SimpleParser.StatementContext context)
    {
        var newLine = context.NEWLINE().GetText();

        if (newLine != "\r\n")
        {
            throw new Exception("Invalid Code Format");
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
        
        foreach (string s in ass)
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
                if (value is int)
                {
                    IntVar[s] = value;
                }
                else
                {if (value == null)
                    {
                        Console.Error.WriteLine( s + " is not initialized");

                    }
                    else
                    {
                        throw new Exception($"Invalid assignment! Expected to be INT");
                    }
                }
            }
            else if (FloatVar.ContainsKey(s))
            {
                if (value is float)
                {
                    FloatVar[s] = value;
                }
                else
                {
                    if (value == null)
                    {
                        Console.Error.WriteLine( s + " is not initialized");

                    }
                    else
                    {
                        throw new Exception($"Invalid assignment! Expected to be  FLOAT");
                    }
                }
            }
            else if (BoolVar.ContainsKey(s))
            {
                if (value is "TRUE" || value is "FALSE")
                {
                    BoolVar[s] = value;
                }
                else
                {
                    if (value == null)
                    {
                        Console.Error.WriteLine( s + " is not initialized");

                    }
                    else
                    {
                        throw new Exception($"Invalid assignment! Expected to be  BOOL");
                    }
                }
            }
        }
        return null;
    }
    public override object? VisitVardec(SimpleParser.VardecContext context)
    {
        var varDatatype = context.DATATYPE().GetText();
        var varDeclarator = context.declaratorlist().GetText();
        string[] variableList = varDeclarator.Split(',');
        int variableCount = variableList.Length;

        foreach (string variable in variableList)
        {
            if (variable.Contains('='))
            {
                string[] var = variable.Split('=');
                var varName = var[0];
                var value = var[var.Length - 1];
                int intValue;
                float floatValue;
                bool isNum = int.TryParse(value, out intValue), isFloat = float.TryParse(value, out floatValue);

                if (!isNum || !isFloat)
                    value = value[1..^1];

                MultipleDeclaration(varName);
                if (varDatatype == "CHAR" && !isNum)
                {
                    CharVar[varName] = value;
                }
                else if (varDatatype == "INT" && isNum)
                {
                    IntVar[varName] = intValue;
                }
                else if (varDatatype == "FLOAT" && isFloat)
                {
                    FloatVar[varName] = floatValue;
                }
                else if (varDatatype == "BOOL" && (value == "TRUE" || value == "FALSE"))
                {
                    BoolVar[varName] = value;
                }
                else
                {
                    throw new Exception($"Invalid assignment! expected to be {varDatatype}");
                }

                DefaultDeclaration(varDatatype, variable);
            }
            else
            {
                DefaultDeclaration(varDatatype, variable);

            }
             
        }

        return null;
    }

    public override object? VisitVariablenameExpression(SimpleParser.VariablenameExpressionContext context)
    {
        var varName = context.VARIABLENAME().GetText();

        if (CharVar.ContainsKey(varName))
        {
            return CharVar[varName];
        }
        if (IntVar.ContainsKey(varName))
        {
            return IntVar[varName];
        }
        if (FloatVar.ContainsKey(varName))
        {
            return FloatVar[varName];
        }
        if (BoolVar.ContainsKey(varName))
        {
            return BoolVar[varName];
        }

        throw new Exception($"Variable {varName} is not defined");
    }

    public override object? VisitConstant(SimpleParser.ConstantContext context)
    {
        if (context.INTEGERVAL() != null)
        {
            return int.Parse(context.INTEGERVAL().GetText());
        }
        if (context.FLOATVAL() != null)
        {
            return float.Parse(context.FLOATVAL().GetText());
        }
        if (context.CHARVAL() is {} c)
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

    // public override object? VisitAdditiveExpression(SimpleParser.AdditiveExpressionContext context)
    // {
    //     var left = Visit(context.value(0));
    //     var right = Visit(context.value(1));
    //
    //     var op = context.addMinOp().GetText();
    //
    //     return op switch
    //     {
    //         "+" => Add(left, right),
    //         //"-" => Subtract(left, right),
    //         _ => throw new NotImplementedException()
    //     };
    // }
    //
    // private object? Add(object? left, object? right)
    // {
    //     if (left is int l && right is int r)
    //     {
    //         return l + r;
    //     }
    //
    //     if (left is float lf && right is float rf)
    //     {
    //         return lf + rf;
    //     }
    //
    //     if (left is int lInt && right is float rFloat)
    //     {
    //         return lInt + rFloat;
    //     }
    //     
    //     if (left is float lFloat && right is int rInt)
    //     {
    //         return lFloat + rInt;
    //     }
    //
    //     if (left is string)
    //     {
    //         return $"{left}{right}";
    //     }
    //
    //     if (left is string || right is string)
    //     {
    //         return $"{left}{right}";
    //     }
    //
    //     throw new NotImplementedException($"Cannot add values of types {left?.GetType()} and {right?.GetType()}");
    // }
}