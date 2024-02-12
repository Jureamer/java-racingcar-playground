package racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarTest {
    private RacingPlay racingPlay;
    @BeforeEach
    void setUp() throws Exception {
        this.racingPlay = new RacingPlay();
    }
    @Test
    void test_자동차_이름은_5글자_초과시_생성_실패() {
        assertThatThrownBy(() -> new Car("juhyeong", 0)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void test_자동차_이름_5글자_이내시_생성_성공() {
        assertThat(new Car("han", 0)).isInstanceOf(Car.class);
    }

    @Test
    void test_자동차_이름_여러개_등록() {
        String participant = "han, dong, su";
        List<Car> cars = racingPlay.register(participant);
        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    void test_1_9_사이_랜덤_값_생성() {

        for (int i = 0; i < 100; i++) {
            int randomNum = RacingPlay.generateRandomNum();
            assertThat(randomNum).isBetween(1, 9);
        }
    }

    @Test
    void test_랜덤값이_4_이상일_경우_이동() {
        int randomNum = 4;
        Car car = new Car("han", 0);
        car.move(randomNum);
        assertThat(car.getPosition().equals(new Position(1))).isTrue();
    }

    @Test
    void test_우승자_출력() {
        List<Car> participants = racingPlay.register("han,pobi,alpha");

        for (Car participant : participants) {
            System.out.println("participant.getNameValue() + " + participant.getNameValue());
            if (participant.getNameValue().equals("han")) {
                participant.move(4);
            } else {
                participant.move(3);
            }
        }
        List<Car> winners = racingPlay.findWinners(participants);
        assertThat(winners.size()).isEqualTo(1);
    }
}
