package racingCar;

import java.util.ArrayList;
import java.util.List;

public class Referee {
    public static List<Car> generateCar(String carName) {
        List<Car> listOfCar = new ArrayList<Car>();

        String[] listOfCarName = carName.split(",");
        for (String name : listOfCarName) {
            try {
                Car car = new Car(name);
                listOfCar.add(car);
            } catch (Exception e) {
                System.out.println("1234");
            }
        }
        return listOfCar;
    }

    public static List<String> findWinners(List<Car> listOfCar) {
        int maxPosition = 0;
        List<String> winners = new ArrayList<String>();

        for (Car car : listOfCar) {
            if (car.getPosition() > maxPosition) {
                winners = new ArrayList<String>();
                winners.add(car.getCarName());
                maxPosition = car.getPosition();
            }

            if (car.getPosition() == maxPosition) {
                winners.add(car.getCarName());
            }
        }
        return winners;
    }
}
