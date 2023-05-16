namespace CODE_Interpreter.Content;

public class FileChecker
{
    public FileChecker() { }

    public void Checker(string content)
    {
        bool beginExist = false;
        bool endExist = false;
        string[] program = content.Split("\n");


        foreach (string line in program)
        {

            if (line.Length == 1 || line[0].Equals('#'))
            {
                continue;
            }

            if (!line[0].Equals('#') && beginExist && endExist)
            {
                throw new Exception("Error: Defined outside the program.");
            }

            if (line.Length >= 10 && line.Substring(0, 10).Equals("BEGIN CODE"))
            {

                if (beginExist)
                {
                    throw new Exception("Error: Multiple BEGIN CODE exists.");
                }
                beginExist = true;

            }
            else if (line.Length >= 8 && beginExist && line.Substring(0, 8).Equals("END CODE"))
            {

                if (endExist)
                {
                    throw new Exception("Error: Multiple END CODE exists.");
                }

                endExist = true;
            }

        }

        if (beginExist == false)
        {
            throw new Exception("Error: No BEGIN CODE exists.");
        }
        else if (beginExist && endExist == false)
        {
            throw new Exception("Error: No END CODE exists.");
        }
    }
}