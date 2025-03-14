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
        COMMANDS.put("save", new SaveCommand());
        COMMANDS.put("execute_script", new ExecuteScriptCommand());
        COMMANDS.put("exit", new ExitCommand());
        COMMANDS.put("add_if_max", new AddIfMaxCommand());
        COMMANDS.put("remove_greater", new RemoveGreaterCommand());
        COMMANDS.put("remove_lower", new RemoveLowerCommand());
        COMMANDS.put("count_less_than_genre", new CountLessThanGenreCommand());
        COMMANDS.put("filter_contains_name", new FilterContainsNameCommand());
        COMMANDS.put("print_field_ascending_number_of_participants",
                new PrintFieldAscendingNumberOfParticipantsCommand());
    }

    /**
     * Define the command and start execution
     *
     * @param r {@code Request} object
     * @return {@code Response} object
     */
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

    /**
     * Collects help information about all commands in the router
     *
     * @return full help text for user
     */
    private static String helpCommand() {
        StringBuilder helpText = new StringBuilder();

        helpText.append("HELP | COMMANDS:").append(System.lineSeparator());

        for (Command i : COMMANDS.values()) {
            helpText.append(i.getHelp()).append(System.lineSeparator());
        }

        return helpText.toString();
    }
}
