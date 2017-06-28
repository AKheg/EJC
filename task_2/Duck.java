
public abstract class Duck {
    FlyBehavior flyBehavior;
    int duck_speed;

    public abstract int getSpeed();
    public abstract void setSpeed(int speed);

    public void performFly() {
        flyBehavior.fly();
    }
}

