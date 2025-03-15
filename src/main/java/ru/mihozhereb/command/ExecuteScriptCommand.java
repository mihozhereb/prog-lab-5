package ru.mihozhereb.command;

import ru.mihozhereb.control.Handler;
import ru.mihozhereb.control.Request;
import ru.mihozhereb.control.Response;
import ru.mihozhereb.io.ConsoleWorker;
import ru.mihozhereb.io.FileWorker;

public class ExecuteScriptCommand implements Command {
    @Override
    public Response execute(Request r) {
        StringBuilder outputText = new StringBuilder();
        try (FileWorker f = new FileWorker(r.argument(), true)) {
            String line;
            while ((line = f.read()) != null) {
                outputText.append(line).append("\n");
                if (line.contains("execute_script")) {
                    outputText.append("execute_script is banned inside the script!").append("\n");
                }

                outputText.append(Handler.handle(line));
            }
        } catch (Exception e) {
            return new Response("Error. " + e.getLocalizedMessage(), null);
        }

        return new Response(outputText + "Done.", null);
    }

    @Override
    public String getHelp() {
        return "execute_script file_name | read and execute a script from a file";
    }
}
