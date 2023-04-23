namespace CODE_Interpreter;

public class ArithmeticOperators
{
    public object? VisitMultiply(object? left, object? right)
    {
        return left switch
        {
            int leftInteger when right is int rightInteger => leftInteger * rightInteger,
            float leftFloat when right is float rightFloat => leftFloat * rightFloat,
            int leftIsInt when right is float rightIsFloat => leftIsInt * rightIsFloat,
            float leftIsFloat when right is int rightIsInt => leftIsFloat * rightIsInt,
            _ => throw new Exception($"Syntax Error: Cannot perform multiplication of {left?.GetType()} and {right?.GetType()} values.")
        };
    }

    public object? VisitModulo(object? left, object? right)
    {
        return left switch
        {
            int leftInteger when right is int rightInteger => leftInteger % rightInteger,
            float leftFloat when right is float rightFloat => leftFloat % rightFloat,
            int leftIsInt when right is float rightIsFloat => leftIsInt % rightIsFloat,
            float leftIsFloat when right is int rightIsInt => leftIsFloat % rightIsInt,
            _ => throw new Exception(
                $"Syntax Error: Cannot perform modulo of {left?.GetType()} and {right?.GetType()} values.")
        };
    }

    public object? VisitDivide(object? left, object? right)
    {
        return left switch
        {
            int leftInteger when right is int rightInteger => Convert.ToInt32(leftInteger / rightInteger),
            float leftFloat when right is float rightFloat => leftFloat / rightFloat,
            int leftIsInt when right is float rightIsFloat => leftIsInt / rightIsFloat,
            float leftIsFloat when right is int rightIsInt => leftIsFloat / rightIsInt,
            _ => throw new Exception(
                $"Syntax Error: Cannot perform division of {left?.GetType()} and {right?.GetType()} values.")
        };
    }

    public object? VisitAdd(object? left, object? right)
    {
        return left switch
        {
            int leftInteger when right is int rightInteger => leftInteger + rightInteger,
            float leftFloat when right is float rightFloat => leftFloat + rightFloat,
            int leftIsInt when right is float rightIsFloat => leftIsInt + rightIsFloat,
            float leftIsFloat when right is int rightIsInt => leftIsFloat + rightIsInt,
            _ => throw new Exception(
                $"Syntax Error: Cannot perform addition of {left?.GetType()} and {right?.GetType()} values.")
        };
    }

    public object? VisitSubtract(object? left, object? right)
    {
        return left switch
        {
            int leftInteger when right is int rightInteger => leftInteger - rightInteger,
            float leftFloat when right is float rightFloat => leftFloat - rightFloat,
            int leftIsInt when right is float rightIsFloat => leftIsInt - rightIsFloat,
            float leftIsFloat when right is int rightIsInt => leftIsFloat - rightIsInt,
            _ => throw new Exception(
                $"Syntax Error: Cannot perform subtraction of {left?.GetType()} and {right?.GetType()} values.")
        };
    }
}