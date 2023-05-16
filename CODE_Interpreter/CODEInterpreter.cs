using Antlr4.Runtime;
using CODE_Interpreter.Content;
using CODE_Interpreter.Grammar;

var path = Path.Combine(Directory.GetCurrentDirectory(), "../../..");
Directory.SetCurrentDirectory(Path.GetFullPath(path));
var fileContent = File.ReadAllText(Path.Combine(Directory.GetCurrentDirectory(), "Content/Test.txt"));

//var file = new FileChecker();
//file.Checker(fileContent);

var inputStream = new AntlrInputStream(fileContent);
var grammarLexer = new GrammarLexer(inputStream);
var commonTokenStream = new CommonTokenStream(grammarLexer);
var grammarParser = new GrammarParser(commonTokenStream);

SyntaxErrorHandler syntaxError = new();
grammarParser.AddErrorListener(syntaxError);

var simpleContext = grammarParser.program();
var visitor = new GrammarVisitor();

visitor.Visit(simpleContext);