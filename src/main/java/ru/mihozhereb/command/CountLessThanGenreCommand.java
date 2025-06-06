package ru.mihozhereb.command;

import ru.mihozhereb.collection.CollectionManager;
import ru.mihozhereb.collection.model.MusicBand;
import ru.mihozhereb.collection.model.MusicGenre;
import ru.mihozhereb.control.Request;
import ru.mihozhereb.control.Response;

public class CountLessThanGenreCommand implements Command {
    @Override
    public Response execute(Request r) {
        MusicGenre genre;
        try {
            genre = MusicGenre.valueOf(r.argument());
        } catch (IllegalArgumentException e) {
            return new Response("Error. Invalid genre.", null);
        }

        int counter = 0;

        for (MusicBand i : CollectionManager.getInstance().getCollection()) {
            if (i.getGenre() != null && i.getGenre().toString().compareTo(genre.toString()) < 0) {
                counter++;
            }
        }

        return new Response("Done. " + counter + " elements.", null);
    }

    @Override
    public String getHelp() {
        return "count_less_than_genre genre | print the number of items whose genre field value is less than " +
                "the specified value";
    }
}
