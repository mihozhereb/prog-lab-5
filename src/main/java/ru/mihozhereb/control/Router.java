package ru.mihozhereb.control;

import ru.mihozhereb.command.*;

import java.util.HashMap;
import java.util.Map;

// TODO
/**
 * Router class
 */
public class Router {
    private static final Map<String, Command> COMMANDS = new HashMap<>();

    static {
        COMMANDS.put("add", new AddCommand());
        COMMANDS.put("show", new ShowCommand());
        COMMANDS.put("info", new InfoCommand());
        COMMANDS.put("update", new UpdateCommand());
        COMMANDS.put("remove_by_id", new RemoveByIdCommand());
        COMMANDS.put("clear", new ClearCommand());
    }


    public static Response route(Request r) {
        Command command = COMMANDS.get(r.command());

        if (r.command().equals("help")) {
            return new Response(helpCommand(), null);
        }

        if (command == null) {
            return new Response("Command not found.", null);
        }

        return command.execute(r);
    }

    private static String helpCommand() {
        StringBuilder helpText = new StringBuilder();

        helpText.append("HELP | COMMANDS:").append(System.lineSeparator());

        for (Command i : COMMANDS.values()) {
            helpText.append(i.getHelp()).append(System.lineSeparator());
        }

        return helpText.toString();
    }
}
