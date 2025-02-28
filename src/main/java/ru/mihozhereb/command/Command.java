package ru.mihozhereb.command;

import ru.mihozhereb.control.Response;

public interface Command {
    Response execute();

    String getHelp();
}
