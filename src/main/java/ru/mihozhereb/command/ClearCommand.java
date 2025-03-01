package ru.mihozhereb.command;

import ru.mihozhereb.collection.CollectionManager;
import ru.mihozhereb.control.Request;
import ru.mihozhereb.control.Response;

public class ClearCommand implements Command {
    /**
     * @param r
     * @return
     */
    @Override
    public Response execute(Request r) {
        CollectionManager.getInstance().getCollection().clear();

        return new Response("Done.", null);
    }

    /**
     * @return
     */
    @Override
    public String getHelp() {
        return "clear | clear collection";
    }
}
