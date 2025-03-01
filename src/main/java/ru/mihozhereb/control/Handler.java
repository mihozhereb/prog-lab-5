package ru.mihozhereb.control;

import ru.mihozhereb.collection.model.MusicBand;
import ru.mihozhereb.io.JsonWorker;

import java.util.Arrays;
import java.util.Optional;

// TODO
/**
 * Handler class
 */
public class Handler {
    public static String handle(String row) {
        String[] args = row.split(" ", 2);

        InputHelper inputHelper = new InputHelper(new MusicBand());
        Optional<MusicBand> element = Optional.empty();

        if (row.contains("{element}")) {
            try {
                element = Optional.ofNullable(inputHelper.input());
            } catch (InputCancelledException e) {
                return e.getLocalizedMessage();
            }
        }

        Request req = new Request(args[0], args.length == 2 ? args[1] : null, element.orElse(null));
        Response resp = Router.route(req);

        String responseText = resp.response() + System.lineSeparator();

        if (resp.elements() != null) {
            responseText += JsonWorker.toJsonFormat(resp.elements()) + System.lineSeparator();
        }

        return responseText;
    }
}
