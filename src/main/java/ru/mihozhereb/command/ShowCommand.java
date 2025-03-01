package ru.mihozhereb.command;

import ru.mihozhereb.collection.CollectionManager;
import ru.mihozhereb.collection.model.MusicBand;
import ru.mihozhereb.control.Request;
import ru.mihozhereb.control.Response;

public class ShowCommand implements Command {
    /**
     * @param r
     * @return
     */
    @Override
    public Response execute(Request r) {
        return new Response("Done.", CollectionManager.getInstance().getCollection().toArray(new MusicBand[0]));
    }

    /**
     * @return
     */
    @Override
    public String getHelp() {
        return "show | show all elements in collection";
    }
}
