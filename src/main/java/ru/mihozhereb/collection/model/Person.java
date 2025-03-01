package ru.mihozhereb.collection.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Person class
 */
public class Person {
    /**
     * Person's name
     *
     * @restriction Поле не может быть null
     * @restriction Строка не может быть пустой
     */
    private String name;

    /**
     * Person's birthday
     *
     * @restriction Поле не может быть null
     */
    private java.time.LocalDate birthday;

    /**
     * Person's height
     *
     * @restriction Поле может быть null
     * @restriction Значение поля должно быть больше 0
     */
    private Double height;

    /**
     * Person's weight
     *
     * @restriction Значение поля должно быть больше 0
     */
    private int weight;

    /**
     * Person's hairColor
     *
     * @restriction Поле может быть null
     */
    private Color hairColor;

    /**
     * Get Person's name
     *
     * @return Person's name
     */
    public String getName() {
        return name;
    }

    /**
     * Set Person's name
     *
     * @param name Person's name
     * @throws IllegalArgumentException Person's name can't be null and blank
     */
    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Person's name can't be null");
        } else if (name.isBlank()) {
            throw new IllegalArgumentException("Person's name can't be blank");
        }
        this.name = name;
    }

    // TODO: закончить сеттеры и геттеры

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return weight == person.weight && Objects.equals(name, person.name) &&
                Objects.equals(birthday, person.birthday) &&
                Objects.equals(height, person.height) && hairColor == person.hairColor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday, height, weight, hairColor);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", height=" + height +
                ", weight=" + weight +
                ", hairColor=" + hairColor +
                '}';
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        if (birthday == null) {
            throw new IllegalArgumentException("Person's birthday can't be null");
        }
        this.birthday = birthday;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        if (height == null) {
            throw new IllegalArgumentException("Height can't be null");
        } else if (height > 0) {
            throw new IllegalArgumentException("Height can't be greater than 0");
        }
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (weight > 0) {
            throw new IllegalArgumentException("Weight can't be greater than 0");
        }
        this.weight = weight;
    }

    public Color getHairColor() {
        return hairColor;
    }

    public void setHairColor(Color hairColor) {
        this.hairColor = hairColor;
    }
}
