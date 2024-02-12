package racingCar;

import java.util.ArrayList;
import java.util.List;

public class RacingPlay {
    public static int generateRandomNum() {
        return (int) Math.random() * 9 + 1;
    }

    public List<Car> register(String participant) {
        List<Car> carList = new ArrayList<Car>();
        for (String name : participant.split(",")) {
            try {
                carList.add(new Car(name, 0));
            } catch (Exception e) {
                throw new IllegalStateException(e.getMessage());
            }
        }
        return carList;
    }

    public List<Car> findWinners(List<Car> participants) {
        int maxPosition = 0;
        List<Car> winners = new ArrayList<Car>();

        for (Car participant : participants) {
            if (participant.getPosition().largerThan(maxPosition)) {
                maxPosition = participant.getPositionValue();
            }
        }

        System.out.println("maxPosition: " + maxPosition);
        for (Car car : participants) {
            if (car.getPositionValue() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }
}
