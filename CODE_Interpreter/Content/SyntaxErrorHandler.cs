using Antlr4.Runtime;
namespace CODE_Interpreter.Content;

public class SyntaxErrorHandler : BaseErrorListener
{
    public override void SyntaxError(IRecognizer recognizer, IToken offendingSymbol, int line, int charPositionInLine, string msg, RecognitionException e)
    {
        Console.Error.WriteLine($" ERR! line {line}:{charPositionInLine} {msg}");
        Environment.Exit(1);
    }
}