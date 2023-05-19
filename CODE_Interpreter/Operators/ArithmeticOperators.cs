namespace CODE_Interpreter.Operators;

public class ArithmeticOperators
{
    public  object? VisitMultiply(object? left, object? right)
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
                Console.Error.WriteLine(" ERR! Cannot perform multiplication of incompatible data type values.");
                Environment.Exit(1);
                break;
        }

        return null;
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
                Console.Error.WriteLine(" ERR! Cannot perform division of incompatible data type values.");
                Environment.Exit(1);
                break;
        }

        return null;
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
                Console.Error.WriteLine(" ERR! Cannot perform modulo of incompatible data type values.");
                Environment.Exit(1);
                break;
        }

        return null;
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
                Console.Error.WriteLine(" ERR! Cannot perform addition of incompatible data type values.");
                Environment.Exit(1);
                break;
        }

        return null;
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
                Console.Error.WriteLine(" ERR! Cannot perform subtraction of incompatible data type values.");
                Environment.Exit(1);
                break;
        }

        return null;
    }
}