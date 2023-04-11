﻿namespace CODE_Interpreter;

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
            Console.WriteLine(arg);
        }

        return null;
    }
    
    public override object? VisitFunctionCall(SimpleParser.FunctionCallContext context)
    {
        var name = context.FUNCTIONNAME().GetText();
        var args = context.value().Select(Visit).ToArray();
        //var args = context.argList()?.value()?.Select(x => Visit(x)).ToArray();

        if (!Functions.ContainsKey(name))
        {
            throw new Exception($"Function {name} is not defined");
        }

        if (Functions[name] is not Func<object?[], object?> func)
        {
            throw new Exception($"Variable {name} is not a function");
        }
        
        return func(args);
    }
    
    public override object? VisitAssign(SimpleParser.AssignContext context)
    {
        var varName = context.VARIABLENAME().GetText();
        var value = Visit(context.value());

        if (CharVar.ContainsKey(varName))
        {
            if (value is string | value is char)
            {
                CharVar[varName] = value;
            }
            else
            {
                throw new Exception("Value is not Char");
            }
        }
        else if (IntVar.ContainsKey(varName))
        {
            if (value is int)
            {
                IntVar[varName] = value;
            }
            else
            {
                throw new Exception("Value is not Int");
            }
        }
        else if (FloatVar.ContainsKey(varName))
        {
            if (value is float)
            {
                FloatVar[varName] = value;
            }
            else
            {
                throw new Exception("Value is not Float");
            }
        }
        else if (BoolVar.ContainsKey(varName))
        {
            if (value is "TRUE" || value is "FALSE")
            {
                BoolVar[varName] = value;
            }
            else
            {
                throw new Exception("Value is not Bool");
            }
        }
        
        return null;
    }
    
    public override object? VisitVardec(SimpleParser.VardecContext context)
    {   
        
        var varDatatype = context.DATATYPE().GetText();
        var varName = context.declaratorlist().declarator().VARIABLENAME().GetText();
        if (varDatatype == "")
        {
            throw new Exception($"{varName} not declared");
        }
        else
        {
            
            var valueText = context.declaratorlist().declarator().value();
            if (valueText != null)
            {
                var value = context.declaratorlist().declarator().value().GetText();
                switch (varDatatype)
                {
                    case "CHAR":
                        try
                        {
                            CharVar[varName] = value[1..^1];
                        }
                        catch(Exception e)
                        {
                            throw new Exception($"Invalid value for variable {varName}: expected a character");
                        }
                         
                        break;
                    case "INT":
                        try
                        {
                            IntVar[varName] = Convert.ToInt32(value);
                        }
                        catch (Exception e)
                        {
                            throw new Exception($"Invalid value for variable {varName} : expected a integer");
                        }
                        break;
                    case "FLOAT":
                        try
                        {
                            FloatVar[varName] = Convert.ToDouble(value);
                        }
                        catch (Exception e)
                        {
                            throw new Exception($"Invalid value for variable {varName}: expected a floating point");
                        }
                        
                        break;
                    case "BOOL":
                        try
                        {
                            BoolVar[varName] = Convert.ToBoolean(value);
                        }
                        catch (Exception e)
                        {
                            throw new Exception($"Invalid value for variable {varName}: expected a boolean");
                        }
                        
                        break;
                    default:
                        throw new Exception($"Data Type {varDatatype} is not defined");
                }
            }
            else
            {
                switch (varDatatype)
                {
                    case "CHAR":
                        CharVar[varName] = ' '; 
                        break;
                    case "INT":
                        IntVar[varName] = 0;
                        break;
                    case "FLOAT":
                        FloatVar[varName] = 0.0;
                        break;
                    case "BOOL":
                        BoolVar[varName] = null;
                        break;
                    default:
                        throw new Exception($"Data Type {varDatatype} is not defined");
                }
            }

        }
        return null;
    }
    
    public override object? VisitDeclaratorlist(SimpleParser.DeclaratorlistContext context)
    {
        var varName = context.declarator().VARIABLENAME().GetText();
        var value = Visit(context.declarator().value());

        Functions[varName] = value;
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
        if (context.CHARVAL() != null)
        {
            return context.CHARVAL().GetText();
        }
        if (context.BOOLVAL() != null)
        {
            return context.BOOLVAL().GetText() == "TRUE";
        }
        
        return null;
    }
    
    public override object? VisitConcatenateExpression(SimpleParser.ConcatenateExpressionContext context)
    {
        var left = Visit(context.value(0))?.ToString();
        var right = Visit(context.value(1))?.ToString();

        var op = context.concOp().GetText();

        
        if (op == "&")
        {
            if (!string.IsNullOrEmpty(left) && !string.IsNullOrEmpty(right))
            {
                return left + right;
            }
            else
            {
                throw new Exception($"Invalid operands for concatenation: {(string.IsNullOrEmpty(left) ? "left" : "right")} operand is null or empty.");
            }
        }

        throw new Exception($"Invalid concatenation operator: '{op}'");

    }
    
    public override object? VisitAdditiveExpression(SimpleParser.AdditiveExpressionContext context)
    {
        var left = Visit(context.value(0));
        var right = Visit(context.value(1));

        var op = context.addMinOp().GetText();

        return op switch
        {
            "+" => Add(left, right),
            //"-" => Subtract(left, right),
            _ => throw new NotImplementedException()
        };
    }

    private object? Add(object? left, object? right)
    {
        if (left is int l && right is int r)
        {
            return l + r;
        }

        if (left is float lf && right is float rf)
        {
            return lf + rf;
        }

        if (left is int lInt && right is float rFloat)
        {
            return lInt + rFloat;
        }
        
        if (left is float lFloat && right is int rInt)
        {
            return lFloat + rInt;
        }

        if (left is string)
        {
            return $"{left}{right}";
        }

        if (left is string || right is string)
        {
            return $"{left}{right}";
        }

        throw new NotImplementedException($"Cannot add values of types {left?.GetType()} and {right?.GetType()}");
    }
}