public class Toyota extends Car{
    public Toyota(String name, String model, int yearMake, String transmission, String color, String motor, int door, int carSeat) {
        super(name, model, yearMake, transmission, color, motor, door, carSeat);
    }

    @Override
    void drive() {
        System.out.println("Toyota поехала");
    }

    @Override
    void stop() {
        System.out.println("Toyota остановилась");
    }


}
