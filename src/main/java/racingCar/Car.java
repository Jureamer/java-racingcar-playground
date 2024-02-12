package racingCar;

public class Car {
    private Name carName;
    private Position position;

    public Car(String name, int position) {
        this.carName = new Name(name);
        this.position = new Position(position);
    }

    public void move(int randomNum) {
        if (isMovable(randomNum)) {
            this.position.move();
        }
    }

    public Position getPosition() {
        return this.position;
    }

    public int getPositionValue() {
        return this.position.getPosition();
    }

    public Name getName() {
        return this.carName;
    }

    public String getNameValue() {
        return this.carName.getName();
    }

    public static boolean isMovable(int randomNum) {
        return randomNum >= 4;
    }
}
