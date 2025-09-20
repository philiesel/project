package ru.ifellow.struzhevsky.hw2;

public class Toyota extends Car{
    public Toyota(String name, String model, int yearMake, String transmission, String color, String motor, int door, int carSeat) {
        super(name, model, yearMake, transmission, color, motor, door, carSeat);
    }

    @Override
    public void drive() {
        System.out.println("Toyota поехала");
    }

    @Override
    public void stop() {
        System.out.println("Toyota остановилась");
    }


}
