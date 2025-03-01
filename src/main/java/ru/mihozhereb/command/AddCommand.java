package ru.mihozhereb.command;

import ru.mihozhereb.control.Request;
import ru.mihozhereb.control.Response;

public class AddCommand implements Command {
    // TODO
    /**
     *
     */
    @Override
    public Response execute(Request r) {
        return new Response(null, null);
    }

    /**
     * @return
     */
    @Override
    public String getHelp() {
        return "add {element} | add element in collection";
    }
}
