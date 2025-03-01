package ru.mihozhereb.command;

import ru.mihozhereb.control.Request;
import ru.mihozhereb.control.Response;

public interface Command {
    Response execute(Request r);

    String getHelp();
}
