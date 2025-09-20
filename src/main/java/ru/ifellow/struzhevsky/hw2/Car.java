package ru.ifellow.struzhevsky.hw2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Car {
    private String name;
    private String model;
    private int yearMake;
    private String transmission;
    private String color;
    private String motor;
    private int door;
    private int carSeat;

    abstract void drive();

    abstract void stop();

    public void printInfo() {
        System.out.printf("""
                 Инф. об автомобиле: 
                 Название: %s
                 Модель: %s
                 Год выпуска: %d
                 Трансмиссия: %s
                 Цвет автомобиля: %s
                 Мотор: %s
                 Кол-во дверей: %d
                 Кол-во сидений: %d
                """,name, model, yearMake, transmission, color, motor, door, carSeat);
    }
}
