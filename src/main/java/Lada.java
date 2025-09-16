public class Lada extends Car {
    private int countMirror;

    public Lada(String name, String model, int yearMake, String transmission, String color, String motor, int door, int carSeat, int countMirror) {
        super(name, model, yearMake, transmission, color, motor, door, carSeat);
        this.countMirror = countMirror;
    }

    public int getCountMirror() {
        return countMirror;
    }

    public void setCountMirror(int countMirror) {
        this.countMirror = countMirror;
    }

    @Override
    public void drive() {
        System.out.println("Lada поехала");
    }

    @Override
    public void stop() {
        System.out.println("Lada остановилась");
    }

    public void turnOnMusic() {
        System.out.println("Музыка включилась");
    }

    public void turnOfMusic() {
        System.out.println("Музыка выключилась");
    }
}
