package ru.mihozhereb.control;

import ru.mihozhereb.collection.model.*;
import ru.mihozhereb.io.ConsoleWorker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * Builder class of {@code MusicBand} object
 * <p>
 * Collect user input and validate the data
 */
public class InputHelper {
    private final ConsoleWorker consoleWorker = new ConsoleWorker();
    private final MusicBand musicBand;

    InputHelper(MusicBand musicBand) {
        this.musicBand = musicBand;
        this.musicBand.setCoordinates(new Coordinates());
        this.musicBand.setFrontMan(new Person());
    }

    private String getConsoleInput() throws InputCancelledException {
        String text = consoleWorker.read();
        if (text == null) {
            throw new InputCancelledException("Input is cancelled.");
        }
        return text;
    }

    private void inputName() throws InputCancelledException {
        while (true) {
            consoleWorker.writeLn("Enter MusicBand's name: ");
            try {
                musicBand.setName(getConsoleInput());
            } catch (IllegalArgumentException e) {
                consoleWorker.writeLn("Invalid argument. " + e.getLocalizedMessage());
                continue;
            }
            break;
        }
    }

    private void inputX() throws InputCancelledException {
        while (true) {
            consoleWorker.writeLn("Enter MusicBand's X coordinate: ");
            try {
                musicBand.getCoordinates().setX(Double.valueOf(getConsoleInput()));
            } catch (IllegalArgumentException e) {
                consoleWorker.writeLn("Invalid argument. " + e.getLocalizedMessage());
                continue;
            }
            break;
        }
    }

    private void inputY() throws InputCancelledException {
        while (true) {
            consoleWorker.writeLn("Enter MusicBand's Y coordinate: ");
            try {
                musicBand.getCoordinates().setY(Float.valueOf(getConsoleInput()));
            } catch (IllegalArgumentException e) {
                consoleWorker.writeLn("Invalid argument. " + e.getLocalizedMessage());
                continue;
            }
            break;
        }
    }

    private void inputCreationDate() throws InputCancelledException {
        while (true) {
            consoleWorker.writeLn("Enter MusicBand's creation date (format 2007-12-03T10:15:30): ");
            try {
                musicBand.setCreationDate(LocalDateTime.parse(getConsoleInput()));
            } catch (IllegalArgumentException e) {
                consoleWorker.writeLn("Invalid argument. " + e.getLocalizedMessage());
                continue;
            }
            break;
        }
    }

    private void inputNumberOfParticipants() throws InputCancelledException {
        while (true) {
            consoleWorker.writeLn("Enter MusicBand's number of participants: ");
            try {
                musicBand.setNumberOfParticipants(Long.parseLong(getConsoleInput()));
            } catch (IllegalArgumentException e) {
                consoleWorker.writeLn("Invalid argument. " + e.getLocalizedMessage());
                continue;
            }
            break;
        }
    }

    private void inputGenre() throws InputCancelledException {
        while (true) {
            String options = Arrays.toString(MusicGenre.values());
            consoleWorker.writeLn("Enter MusicBand's genre " + options + ": ");
            try {
                musicBand.setGenre(MusicGenre.valueOf(getConsoleInput()));
            } catch (IllegalArgumentException e) {
                consoleWorker.writeLn("Invalid argument. " + e.getLocalizedMessage());
                continue;
            }
            break;
        }
    }

    private void inputFrontManName() throws InputCancelledException {
        while (true) {
            consoleWorker.writeLn("Enter FrontMan's name: ");
            try {
                musicBand.getFrontMan().setName(getConsoleInput());
            } catch (IllegalArgumentException e) {
                consoleWorker.writeLn("Invalid argument. " + e.getLocalizedMessage());
                continue;
            }
            break;
        }
    }

    private void inputBirthday() throws InputCancelledException {
        while (true) {
            consoleWorker.writeLn("Enter FrontMan's birthday (format 2007-12-03): ");
            try {
                musicBand.getFrontMan().setBirthday(LocalDate.parse(getConsoleInput()));
            } catch (IllegalArgumentException e) {
                consoleWorker.writeLn("Invalid argument. " + e.getLocalizedMessage());
                continue;
            }
            break;
        }
    }

    private void inputHeight() throws InputCancelledException {
        while (true) {
            consoleWorker.writeLn("Enter FrontMan's height: ");
            try {
                musicBand.getFrontMan().setHeight(Double.valueOf(getConsoleInput()));
            } catch (IllegalArgumentException e) {
                consoleWorker.writeLn("Invalid argument. " + e.getLocalizedMessage());
                continue;
            }
            break;
        }
    }

    private void inputWeight() throws InputCancelledException {
        while (true) {
            consoleWorker.writeLn("Enter FrontMan's weight: ");
            try {
                musicBand.getFrontMan().setWeight(Integer.parseInt(getConsoleInput()));
            } catch (IllegalArgumentException e) {
                consoleWorker.writeLn("Invalid argument. " + e.getLocalizedMessage());
                continue;
            }
            break;
        }
    }

    private void inputHairColor() throws InputCancelledException {
        while (true) {
            String options = Arrays.toString(Color.values());
            consoleWorker.writeLn("Enter FrontMan's hair color " + options + ": ");
            try {
                musicBand.getFrontMan().setHairColor(Color.valueOf(getConsoleInput()));
            } catch (IllegalArgumentException e) {
                consoleWorker.writeLn("Invalid argument. " + e.getLocalizedMessage());
                continue;
            }
            break;
        }
    }

    /**
     * Collect all data from user
     *
     * @return built MusicBand object
     * @throws InputCancelledException If user cancel input
     */
    public MusicBand input() throws InputCancelledException {
        inputName();
        inputX();
        inputY();
        inputCreationDate();
        inputNumberOfParticipants();
        inputGenre();
        inputFrontManName();
        inputBirthday();
        inputHeight();
        inputWeight();
        inputHairColor();

        return musicBand;
    }
}
