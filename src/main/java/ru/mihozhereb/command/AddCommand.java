package ru.mihozhereb.command;

import ru.mihozhereb.control.Request;
import ru.mihozhereb.control.Response;

public class AddCommand implements Command {
    // TODO
    /**
     *
     */
    @Override
    public Response execute() {
        return new Response(null, null);
    }

    /**
     * @return
     */
    @Override
    public String getHelp() {
        return "";
    }
}
