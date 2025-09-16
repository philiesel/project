public abstract class Car {
    private String name;
    private String model;
    private int yearMake;
    private String transmission;
    private String color;
    private String motor;
    private int door;
    private int carSeat;

    public Car(String name, String model, int yearMake, String transmission, String color, String motor, int door, int carSeat) {
        this.name = name;
        this.model = model;
        this.yearMake = yearMake;
        this.transmission = transmission;
        this.color = color;
        this.motor = motor;
        this.door = door;
        this.carSeat = carSeat;
    }

    abstract void drive();

    abstract void stop();

    public String getModel() {
        return model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearMake() {
        return yearMake;
    }

    public void setYearMake(int yearMake) {
        this.yearMake = yearMake;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public int getDoor() {
        return door;
    }

    public void setDoor(int door) {
        this.door = door;
    }

    public int getCarSeat() {
        return carSeat;
    }

    public void setCarSeat(int carSeat) {
        this.carSeat = carSeat;
    }


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
