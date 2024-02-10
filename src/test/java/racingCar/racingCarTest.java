package racingCar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class racingCarTest {

// - 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
// - 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
// - 자동차 이름은 쉼표(,)를 기준으로 구분한다.
// - 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
// - 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.
    @Test
    void test_자동차_이름은_5글자_초과시_실패() {
        String carName = "genesis";
        assertThatThrownBy(() -> new Car(carName)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void test_자동차_이름은_5글자_이내시_생성() {
        String carName = "sport";
        assertThat(new Car(carName)).isInstanceOf(Car.class);
    }

    @Test
    void test_자동차_이름_쉼표로_구분시_다중_생성() {
        String listOfCarName = "sport,boom,good";
        List<Car> listOfGeneratedCar = Referee.generateCar(listOfCarName);
        assertThat(listOfGeneratedCar.size()).isEqualTo(3);

        for (Car car : listOfGeneratedCar) {
            assertThat(car).isInstanceOf(Car.class);
        }
    }

    @Test
    void test_자동차는_0_9_사이의_랜덤값을_구한다() {
        List<Car> car = Referee.generateCar("test, good");

        for (Car c : car) {
            int randomNumber = c.generateRandomNumber();
            assertThat(randomNumber).isBetween(0, 9);
        }
    }

    @Test
    void test_3_이하일_경우_전진하지않는다() {
        List<Car> car = Referee.generateCar("test, good");

        for (Car c : car) {
            int randomNumber = 3;

            if (c.canMove(randomNumber)) {
                c.moveForward();
            }
            assertThat(c.getPosition()).isEqualTo(0);
        }
    }

    @Test
    void test_4_이상의_값일_경우_전진한다() {
        List<Car> car = Referee.generateCar("test, good");

        for (Car c : car) {
            int randomNumber = 4;

            if (c.canMove(randomNumber)) {
                c.moveForward();
                assertThat(c.getPosition()).isEqualTo(1);
            }
        }
    }

    @Test
    void test_가장_많이_전진한_자동차가_우승한다() {
        List<Car> cars = Referee.generateCar("test, boom");

        for (Car car : cars) {
            int randomNumber = 3;
            if (car.getCarName().equals("test")) {
                randomNumber = 4;
            }

            if (car.canMove(randomNumber)) {
                car.moveForward();
            }
        }

        List<String> winners = Referee.findWinners(cars);
        assertThat(winners.get(0)).isEqualTo("test");
    }
}
