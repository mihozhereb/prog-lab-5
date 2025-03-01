package ru.mihozhereb.control;

import ru.mihozhereb.collection.model.MusicBand;

/**
 * Command name, optional arguments, and a list of {@link MusicBand} objects.
 *
 * @param command
 * @param argument
 * @param element
 * @see MusicBand
 */
public record Request(String command, String argument, MusicBand element) {
}
