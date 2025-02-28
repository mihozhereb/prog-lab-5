package ru.mihozhereb.collection.model;

import ru.mihozhereb.collection.utils.IdGenerator;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * MusicBand class
 */
public class MusicBand implements Comparable<MusicBand> {
    /**
     * MusicBand's id
     *
     * @restriction Поле не может быть null
     * @restriction Значение поля должно быть больше 0
     * @restriction Значение этого поля должно быть уникальным
     * @restriction Значение этого поля должно генерироваться автоматически
     */
    private Integer id;

    /**
     * MusicBand's name
     *
     * @restriction Поле не может быть null
     * @restriction Строка не может быть пустой
     */
    private String name;

    /**
     * MusicBand's coordinates
     *
     * @restriction Поле не может быть null
     */
    private Coordinates coordinates;

    /**
     * MusicBand's creation date
     *
     * @restriction Поле не может быть null,
     * @restriction Значение этого поля должно генерироваться автоматически
     */
    private final java.time.LocalDateTime creationDate;

    /**
     * MusicBand's number of participants
     *
     * @restriction Значение поля должно быть больше 0
     */
    private long numberOfParticipants;

    /**
     * MusicBand's music genre
     *
     * @restriction Поле может быть null
     */
    private MusicGenre genre;

    /**
     * MusicBand's frontMan
     *
     * @restriction Поле не может быть null
     */
    private Person frontMan;

    {
        creationDate = LocalDateTime.now();
    }

    /**
     * Get MusicBand's ID
     *
     * @return MusicBand's ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set MusicBand's ID
     */
    public void setId() {
        id = IdGenerator.getInstance().getNewId();
    }

    /**
     * Get MusicBand's name
     *
     * @return MusicBand's name
     */
    public String getName() {
        return name;
    }

    /**
     * Set MusicBand's name
     *
     * @param name MusicBand's name
     * @throws IllegalArgumentException MusicBand's name can't be null and blank
     */
    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("MusicBand's name can't be null");
        } else if (name.isBlank()) {
            throw new IllegalArgumentException("MusicBand's name can't be blank");
        }
        this.name = name;
    }

    /**
     * Get MusicBand's coordinates
     *
     * @return MusicBand's coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Set MusicBand's coordinates
     *
     * @param coordinates MusicBand's coordinates
     * @throws IllegalArgumentException MusicBand's coordinates can't be null
     */
    public void setCoordinates(Coordinates coordinates) {
        if (coordinates == null) {
            throw new IllegalArgumentException("MusicBand's coordinates can't be null");
        }
        this.coordinates = coordinates;
    }

    /**
     * Get MusicBand's creation date
     *
     * @return MusicBand's creation date
     */
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * Get MusicBand's number of participants
     *
     * @return MusicBand's number of participants
     */
    public long getNumberOfParticipants() {
        return numberOfParticipants;
    }

    /**
     * Set MusicBand's number of participants
     *
     * @param numberOfParticipants MusicBand's number of participants
     * @throws IllegalArgumentException MusicBand's number of participants can be greater than 0
     */
    public void setNumberOfParticipants(long numberOfParticipants) {
        if (numberOfParticipants <= 0) {
            throw new IllegalArgumentException("MusicBand's number of participants can be greater than 0");
        }
        this.numberOfParticipants = numberOfParticipants;
    }

    /**
     * Get MusicBand's genre
     *
     * @return MusicBand's genre
     */
    public MusicGenre getGenre() {
        return genre;
    }

    /**
     * Set MusicBand's genre
     *
     * @param genre MusicBand's genre
     */
    public void setGenre(MusicGenre genre) {
        this.genre = genre;
    }

    /**
     * Get MusicBand's frontman
     *
     * @return MusicBand's frontman
     */
    public Person getFrontMan() {
        return frontMan;
    }

    /**
     * Set MusicBand's frontman
     *
     * @param frontMan MusicBand's frontman
     * @throws IllegalArgumentException MusicBand's frontman can't be null
     */
    public void setFrontMan(Person frontMan) {
        if (frontMan == null) {
            throw new IllegalArgumentException("MusicBand's frontman can't be null");
        }
        this.frontMan = frontMan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MusicBand musicBand = (MusicBand) o;
        return numberOfParticipants == musicBand.numberOfParticipants && Objects.equals(id, musicBand.id) &&
                Objects.equals(name, musicBand.name) && Objects.equals(coordinates, musicBand.coordinates) &&
                Objects.equals(creationDate, musicBand.creationDate) && genre == musicBand.genre &&
                Objects.equals(frontMan, musicBand.frontMan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, numberOfParticipants, genre, frontMan);
    }

    @Override
    public String toString() {
        return "MusicBand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", numberOfParticipants=" + numberOfParticipants +
                ", genre=" + genre +
                ", frontMan=" + frontMan +
                '}';
    }

    /**
     * Compares MusicBand's objects in alphabetical order
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to,
     *         or greater than the specified object.
     */
    @Override
    public int compareTo(MusicBand o) {
        return this.name.compareTo(o.name);
    }
}
