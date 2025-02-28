package ru.mihozhereb.collection.model;

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


    // TODO: закончить сеттеры и геттеры и прочую хуйню
}
