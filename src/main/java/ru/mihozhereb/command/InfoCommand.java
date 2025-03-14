package ru.mihozhereb.command;

import ru.mihozhereb.collection.CollectionManager;
import ru.mihozhereb.control.Request;
import ru.mihozhereb.control.Response;

public class InfoCommand implements Command {
    @Override
    public Response execute(Request r) {
        StringBuilder b = new StringBuilder();
        CollectionManager c = CollectionManager.getInstance();
        b.append("Type: ").append(c.getCollection().getClass()).append(System.lineSeparator());
        b.append("Creation datetime: ").append(c.getCreationDateTime()).append(System.lineSeparator());
        b.append("Size: ").append(c.getCollection().size());
        return new Response(b.toString(), null);
    }

    @Override
    public String getHelp() {
        return "info | print type, date of initialization, number of elements";
    }
}
