package ru.mihozhereb.control;

import ru.mihozhereb.command.AddCommand;
import ru.mihozhereb.command.Command;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// TODO
/**
 * Router class
 */
public class Router {
    private static final Map<String, Command> COMMANDS = new HashMap<>();

    static {
        COMMANDS.put("add", new AddCommand());
    }


    public static Response route(Request r) {
        Command command = COMMANDS.get(r.command());

        if (r.command().equals("help")) {
            return new Response(helpCommand(), null);
        } else if (command == null) {
            return new Response("Command not found.", null);
        }

        Response resp = command.execute(r);
        return resp;
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
