package ru.mihozhereb.collection.model;

import java.util.Objects;

/**
 * Coordinates class
 */
public class Coordinates {
    /**
     * X coordinate
     *
     * @restriction Значение поля должно быть больше -823
     * @restriction Поле не может быть null
     */
    private Double x;

    /**
     * Y coordinate
     *
     * @restriction Максимальное значение поля: 752
     * @restriction Поле не может быть null
     */
    private Float y;


    /**
     * get X coordinate
     *
     * @return X coordinate
     */
    public Double getX() {
        return x;
    }

    /**
     * set X coordinate
     *
     * @param x X coordinate
     * @throws IllegalArgumentException X can't be null and less or equal than -823
     */
    public void setX(Double x) {
        if (x == null) {
            throw new IllegalArgumentException("X can't be null");
        } else if (x <= -823) {
            throw new IllegalArgumentException("X can't be less or equal than -823");
        }
        this.x = x;
    }

    /**
     * get Y coordinate
     *
     * @return Y coordinate
     */
    public Float getY() {
        return y;
    }

    /**
     * set Y coordinate
     * @param y Y coordinate
     * @throws IllegalArgumentException X can't be null and greater than 752
     */
    public void setY(Float y) {
        if (y == null) {
            throw new IllegalArgumentException("Y can't be null");
        } else if (y > 752) {
            throw new IllegalArgumentException("Y can't be greater than 752");
        }
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(x, that.x) && Objects.equals(y, that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    /**
     * Returns a string representation of the {@code Coordinates} object.
     * <p>
     * The string includes the {@code x} and {@code y} coordinates, formatted in a compact style.
     * </p>
     *
     * @return a string representation of the {@code Coordinates} object
     */
    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
