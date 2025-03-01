package ru.mihozhereb.control;

import ru.mihozhereb.collection.model.*;
import ru.mihozhereb.io.ConsoleWorker;

import java.time.LocalDate;
import java.util.Arrays;

public class InputHelper {
    private final ConsoleWorker consoleWorker = new ConsoleWorker();
    private final MusicBand musicBand;

    InputHelper(MusicBand musicBand) {
        this.musicBand = musicBand;
        this.musicBand.setCoordinates(new Coordinates());
        this.musicBand.setFrontMan(new Person());
    }

    private void inputName() {
        while (true) {
            consoleWorker.writeLn("Enter MusicBand's name: ");
            String name = consoleWorker.read();
            try {
                musicBand.setName(name);
            } catch (IllegalArgumentException e) {
                consoleWorker.writeLn("Invalid argument. " + e.getLocalizedMessage());
                continue;
            }
            break;
        }
    }

    private void inputX() {
        while (true) {
            consoleWorker.writeLn("Enter MusicBand's X coordinate: ");
            String x = consoleWorker.read();
            try {
                musicBand.getCoordinates().setX(Double.valueOf(x));
            } catch (IllegalArgumentException e) {
                consoleWorker.writeLn("Invalid argument. " + e.getLocalizedMessage());
                continue;
            }
            break;
        }
    }

    private void inputY() {
        while (true) {
            consoleWorker.writeLn("Enter MusicBand's Y coordinate: ");
            String y = consoleWorker.read();
            try {
                musicBand.getCoordinates().setY(Float.valueOf(y));
            } catch (IllegalArgumentException e) {
                consoleWorker.writeLn("Invalid argument. " + e.getLocalizedMessage());
                continue;
            }
            break;
        }
    }

    private void inputNumberOfParticipants() {
        while (true) {
            consoleWorker.writeLn("Enter MusicBand's number of participants: ");
            String numberOfParticipant = consoleWorker.read();
            try {
                musicBand.setNumberOfParticipants(Long.parseLong(numberOfParticipant));
            } catch (IllegalArgumentException e) {
                consoleWorker.writeLn("Invalid argument. " + e.getLocalizedMessage());
                continue;
            }
            break;
        }
    }

    private void inputGenre() {
        while (true) {
            String options = Arrays.toString(MusicGenre.values());
            consoleWorker.writeLn("Enter MusicBand's genre " + options + ": ");
            String genre = consoleWorker.read();
            try {
                musicBand.setGenre(MusicGenre.valueOf(genre));
            } catch (IllegalArgumentException e) {
                consoleWorker.writeLn("Invalid argument. " + e.getLocalizedMessage());
                continue;
            }
            break;
        }
    }

    private void inputFrontManName() {
        while (true) {
            consoleWorker.writeLn("Enter FrontMan's name: ");
            String name = consoleWorker.read();
            try {
                musicBand.getFrontMan().setName(name);
            } catch (IllegalArgumentException e) {
                consoleWorker.writeLn("Invalid argument. " + e.getLocalizedMessage());
                continue;
            }
            break;
        }
    }

    private void inputBirthday() {
        while (true) {
            consoleWorker.writeLn("Enter FrontMan's birthday (format year-month-day xxxx-xx-xx): ");
            String birthday = consoleWorker.read();
            try {
                musicBand.getFrontMan().setBirthday(LocalDate.parse(birthday));
            } catch (IllegalArgumentException e) {
                consoleWorker.writeLn("Invalid argument. " + e.getLocalizedMessage());
                continue;
            }
            break;
        }
    }

    private void inputHeight() {
        while (true) {
            consoleWorker.writeLn("Enter FrontMan's height: ");
            String height = consoleWorker.read();
            try {
                musicBand.getFrontMan().setHeight(Double.valueOf(height));
            } catch (IllegalArgumentException e) {
                consoleWorker.writeLn("Invalid argument. " + e.getLocalizedMessage());
                continue;
            }
            break;
        }
    }

    private void inputWeight() {
        while (true) {
            consoleWorker.writeLn("Enter FrontMan's weight: ");
            String weight = consoleWorker.read();
            try {
                musicBand.getFrontMan().setWeight(Integer.parseInt(weight));
            } catch (IllegalArgumentException e) {
                consoleWorker.writeLn("Invalid argument. " + e.getLocalizedMessage());
                continue;
            }
            break;
        }
    }

    private void inputHairColor() {
        while (true) {
            String options = Arrays.toString(Color.values());
            consoleWorker.writeLn("Enter FrontMan's hair color " + options + ": ");
            String hairColor = consoleWorker.read();
            try {
                musicBand.getFrontMan().setHairColor(Color.valueOf(hairColor));
            } catch (IllegalArgumentException e) {
                consoleWorker.writeLn("Invalid argument. " + e.getLocalizedMessage());
                continue;
            }
            break;
        }
    }

    public MusicBand input() {
        inputName();
        inputX();
        inputY();
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
