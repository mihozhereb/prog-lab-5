package ru.mihozhereb.control;

import ru.mihozhereb.collection.model.MusicBand;

/**
 * Command name, optional arguments, and a list of {@link MusicBand} objects.
 *
 * @param command
 * @param args
 * @param elements
 * @see MusicBand
 */
public record Request(String command, String[] args, MusicBand[] elements) {
}
