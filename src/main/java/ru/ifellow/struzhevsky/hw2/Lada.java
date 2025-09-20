package ru.ifellow.struzhevsky.hw2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Lada extends Car {
    private int countMirror;

    public Lada(String name, String model, int yearMake, String transmission, String color, String motor, int door, int carSeat, int countMirror) {
        super(name, model, yearMake, transmission, color, motor, door, carSeat);
        this.countMirror = countMirror;
    }

    @Override
    public void drive() {
        System.out.println("ru.ifellow.struzhevsky.hw2.Lada поехала");
    }

    @Override
    public void stop() {
        System.out.println("ru.ifellow.struzhevsky.hw2.Lada остановилась");
    }

    public void turnOnMusic() {
        System.out.println("Музыка включилась");
    }

    public void turnOfMusic() {
        System.out.println("Музыка выключилась");
    }
}
