public class Changan extends Car{
    public Changan(String name, String model, int yearMake, String transmission, String color, String motor, int door, int carSeat) {
        super(name, model, yearMake, transmission, color, motor, door, carSeat);
    }
    @Override
    public void drive() {
        System.out.println("Changan поехала");
    }

    @Override
    public void stop() {
        System.out.println("Changan остановилась");
    }
}
