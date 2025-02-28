package ru.mihozhereb.control;

import ru.mihozhereb.command.AddCommand;
import ru.mihozhereb.command.Command;

import java.util.HashMap;

// TODO
/**
 * Router class
 */
public class Router {
    static HashMap<String, Command> commands = new HashMap<>();

    static {
        commands.put("add", new AddCommand());
    }


    public static Response route(Request r) {
        Command command = commands.get(r.command());
        command.execute();
        return new Response("test message", null);
    }

    private String HelpCommand() {
        return "";
    }
}
