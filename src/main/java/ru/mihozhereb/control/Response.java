package ru.mihozhereb.control;

import ru.mihozhereb.collection.model.MusicBand;

/**
 * Response text and a list of {@link MusicBand} objects.
 *
 * @param response
 * @param elements
 */
public record Response(String response, MusicBand[] elements) {

}
