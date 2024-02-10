package racingCar;

public class Car {
    private String carName;
    private int position = 0;

    public Car(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }

        this.carName = carName;
    }


    public int generateRandomNumber() {
        int randomNumber = (int) Math.round(Math.random() * 100 / 10);
        return randomNumber;
    }

    public void moveForward() {
        this.position++;
    }

    public int getPosition() {
        return this.position;
    }

    public String getCarName() {
        return this.carName;
    }
    public boolean canMove(int number) {
        return number >= 4;
    }
}
