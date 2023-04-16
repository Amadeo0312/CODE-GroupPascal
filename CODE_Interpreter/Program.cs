using Antlr4.Runtime;
using CODE_Interpreter;
//using CODE_Interpreter.Content; 

// var fileName = "D:/School/Code/CODE-GroupPascal/CODE_Interpreter/Content/Test.ss";
// var fileContent = File.ReadAllText(fileName);

var path = Path.Combine(Directory.GetCurrentDirectory(), "../../..");
Directory.SetCurrentDirectory(Path.GetFullPath(path));
var fileContent = File.ReadAllText(Path.Combine(Directory.GetCurrentDirectory(), "Content/Test.ss"));

FileChecker file = new FileChecker();
file.Checker(fileContent);
/*
if (fileContent.Substring(0, 10) != "BEGIN CODE" || fileContent.Substring(fileContent.Length - 8, 8) != "END CODE")
{
    throw new Exception("No BEGIN CODE or END CODE");
}
*/

var inputStream = new AntlrInputStream(fileContent);
var simpleLexer = new SimpleLexer(inputStream);
var commonTokenStream = new CommonTokenStream(simpleLexer);
var simpleParser = new SimpleParser(commonTokenStream);

var simpleContext = simpleParser.program();
var visitor = new Visitor();

visitor.Visit(simpleContext);

// foreach(KeyValuePair<string, object?> kvp in visitor.CharVar)
// {
//     Console.Write("CharVariable name: " + kvp.Key + ", Variable value: " + kvp.Value + "\n");
// }
// foreach(KeyValuePair<string, object?> kvp in visitor.IntVar)
// {
//     Console.Write("IntVariable name: " + kvp.Key + ", Variable value: " + kvp.Value + "\n");
// }
// foreach(KeyValuePair<string, object?> kvp in visitor.FloatVar)
// {
//     Console.Write("FlatVariable name: " + kvp.Key + ", Variable value: " + kvp.Value + "\n");
// }
// foreach(KeyValuePair<string, object?> kvp in visitor.BoolVar)
// {
//     Console.Write("BoolVariable name: " + kvp.Key + ", Variable value: " + kvp.Value + "\n");
// }