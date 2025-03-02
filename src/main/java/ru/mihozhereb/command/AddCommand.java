package ru.mihozhereb.command;

import ru.mihozhereb.collection.CollectionManager;
import ru.mihozhereb.control.Request;
import ru.mihozhereb.control.Response;

public class AddCommand implements Command {
    // TODO
    /**
     * @param r
     * @return
     */
    @Override
    public Response execute(Request r) {
        CollectionManager.getInstance().getCollection().add(r.element());

        return new Response("Done.", null);
    }

    /**
     * @return
     */
    @Override
    public String getHelp() {
        return "add {element} | add element in collection";
    }
}
