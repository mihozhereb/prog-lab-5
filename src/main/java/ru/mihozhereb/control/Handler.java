package ru.mihozhereb.control;

import ru.mihozhereb.collection.model.MusicBand;

import java.util.Arrays;

// TODO
/**
 * Handler class
 */
public class Handler {
    public static String handle(String row) {
        String[] args = row.split(" ");

        InputHelper inputHelper = new InputHelper(new MusicBand());

        Request req;
        if (args.length == 1) {
            req = new Request(args[0], null, null);
        } else if (args.length == 2 && args[1].equals("{element}")) {
            MusicBand element = inputHelper.input();
            req = new Request(args[0], null, element);
        } else if (args.length == 3 && args[2].equals("{element}")) {
            MusicBand element = inputHelper.input();
            req = new Request(args[0], args[1], element);
        } else if (args.length == 2) {
            req = new Request(args[0], args[1], null);
        } else {
            return "Invalid command input.";
        }

        Response resp = Router.route(req);

        String responseText = resp.response() + System.lineSeparator();

        if (resp.elements() != null) {
            responseText += Arrays.toString(resp.elements()) + System.lineSeparator();
        }

        return responseText;
    }
}
