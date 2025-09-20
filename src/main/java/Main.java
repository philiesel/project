import java.util.ArrayList;
import java.util.List;

public class Main {
    private List<Car> carCollection = new ArrayList<>();

    public Main() {
        this.carCollection.add(new Aurus("Aurus", "V234", 2004, "Механика", "Зеленый цвет", "Бензиновый", 4, 4));
        this.carCollection.add(new Aurus("Aurus", "V674", 2010, "Автомат", "Зеленый цвет", "Дизельный", 2, 2));
        this.carCollection.add(new Suzuki("Suzuki", "N324", 2006, "Механика", "Синий цвет", "Бензиновый", 2, 2));
        this.carCollection.add(new Aurus("Aurus", "G342", 2014, "Механика", "Желтый цвет", "Бензиновый", 4, 4));
        this.carCollection.add(new Changan("Changan", "B654", 2001, "Автомат", "Красный цвет", "Дизельный", 4, 4));
        this.carCollection.add(new Suzuki("Suzuki", "X127", 2000, "Механика", "Белый цвет", "Дизельный", 4, 4));
        this.carCollection.add(new Lada("Lada", "K897", 2001, "Автомат", "Черный цвет", "Бензиновый", 2, 2));
        this.carCollection.add(new Lada("Lada", "F789", 2002, "Автомат", "Розовый цвет", "Бензиновый", 4, 4));
        this.carCollection.add(new Suzuki("Suzuki", "R466", 2005, "Механика", "Оранжевый цвет", "Бензиновый", 2, 2));
        this.carCollection.add(new Toyota("Toyota", "L976", 2003, "Механика", "Коричневый цвет", "Дизельный", 2, 2));
        this.carCollection.add(new Toyota("Toyota", "V764", 2010, "Механика", "Зеленый цвет", "Бензиновый", 4, 4));
    }

    public void getInfoCar() {
        int countCar = 0;
        for (Car car : carCollection) {
            countCar++;
            System.out.println("Автомобиль номер: " + countCar);
            if (car.getYearMake() > 2006) {
                car.printInfo();
            } else {
                System.out.println("устаревший авто");
            }
        }
    }

    public void changeColorCar() {
        for (Car car : carCollection) {
            if (car.getColor().equalsIgnoreCase("Зеленый цвет")) {
                car.setColor("Красный цвет");
            }
        }
    }
    public void changeMotor(){
        for (Car car : carCollection) {
            if(car.getMotor().equalsIgnoreCase("Дизельный")) {
                car.setMotor("Электрический");
            }
        }
    }

    //it's Main origin
    public static void main(String[] args) {
        Main main = new Main();
        main.changeColorCar();
        main.changeMotor();
        main.getInfoCar();
    }
}
