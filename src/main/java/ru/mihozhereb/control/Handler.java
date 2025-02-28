package ru.mihozhereb.control;

import java.util.Arrays;

// TODO
/**
 * Handler class
 */
public class Handler {
    public static String handle(String row) {
        String[] args = row.split(" ");

        Request req;
        if (args.length == 1) {
            req = new Request(args[0], null, null);
        } else if (args.length == 2 && args[1].equals("{element}")) {
            req = new Request(args[0], null, null);
        } else if (args.length == 3 && args[2].equals("{element}")) {
            req = new Request(args[0], args[1], null);
        } else if (args.length == 2) {
            req = new Request(args[0], args[1], null);
        } else {
            // error
            return "";
        }

        Response resp = Router.route(req);

        return resp.response() + System.lineSeparator() + Arrays.toString(resp.elements()) + System.lineSeparator();
    }
}
