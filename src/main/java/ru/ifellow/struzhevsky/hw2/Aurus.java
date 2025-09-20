package ru.ifellow.struzhevsky.hw2;

public class Aurus extends Car{
    public Aurus(String name, String model, int yearMake, String transmission, String color, String motor, int door, int carSeat) {
        super(name, model, yearMake, transmission, color, motor, door, carSeat);
    }

    @Override
    public void drive() {
        System.out.println("Aurus поехала");
    }

    @Override
    public void stop() {
        System.out.println("Aurus остановился");
    }
}
