namespace CODE_Interpreter;

public class ArithmeticOperators
{
    public object? VisitMultiply(object? left, object? right)
    {
        switch (left)
        {
            case int leftInteger when right is int rightInteger:
                return leftInteger * rightInteger;
            case float leftFloat when right is float rightFloat:
                return leftFloat * rightFloat;
            case float leftIsInt when right is float rightIsFloat:
                return leftIsInt * rightIsFloat;
            case float leftIsFloat when right is float rightIsInt:
                return leftIsFloat * rightIsInt;
            default:
                throw new NotImplementedException($"Syntax Error: Cannot perform multiplication of {left?.GetType()} and {right?.GetType()} values.");
        }
    }
    
    public object? VisitDivide(object? left, object? right)
    {
        switch (left)
        {
            case int leftInteger when right is int rightInteger:
                return leftInteger / rightInteger;
            case float leftFloat when right is float rightFloat:
                return leftFloat / rightFloat;
            case float leftIsInt when right is float rightIsFloat:
                return leftIsInt / rightIsFloat;
            case float leftIsFloat when right is float rightIsInt:
                return leftIsFloat / rightIsInt;
            default:
                throw new NotImplementedException($"Syntax Error: Cannot perform division of {left?.GetType()} and {right?.GetType()} values.");
        }
    }
    
    public object? VisitModulo(object? left, object? right)
    {
        switch (left)
        {
            case int leftInteger when right is int rightInteger:
                return leftInteger % rightInteger;
            case float leftFloat when right is float rightFloat:
                return leftFloat % rightFloat;
            case float leftIsInt when right is float rightIsFloat:
                return leftIsInt % rightIsFloat;
            case float leftIsFloat when right is float rightIsInt:
                return leftIsFloat % rightIsInt;
            default:
                throw new NotImplementedException($"Syntax Error: Cannot perform modulo of {left?.GetType()} and {right?.GetType()} values.");
        }
    }
    
    public object? VisitAdd(object? left, object? right)
    {
        switch (left)
        {
            case int leftInteger when right is int rightInteger:
                return leftInteger + rightInteger;
            case float leftFloat when right is float rightFloat:
                return leftFloat + rightFloat;
            case int leftIsInt when right is float rightIsFloat:
                return leftIsInt + rightIsFloat;
            case float leftIsFloat when right is int rightIsInt:
                return leftIsFloat + rightIsInt;
            default:
                throw new NotImplementedException(
                    $"Syntax Error: Cannot perform addition of {left?.GetType()} and {right?.GetType()} values.");
        }
    }
    
    public object? VisitSubtract(object? left, object? right)
    {
        switch (left)
        {
            case int leftInteger when right is int rightInteger:
                return leftInteger - rightInteger;
            case float leftFloat when right is float rightFloat:
                return leftFloat - rightFloat;
            case float leftIsInt when right is float rightIsFloat:
                return leftIsInt - rightIsFloat;
            case float leftIsFloat when right is float rightIsInt:
                return leftIsFloat - rightIsInt;
            default:
                throw new NotImplementedException($"Syntax Error: Cannot perform subtraction of {left?.GetType()} and {right?.GetType()} values.");
        }
    }
}