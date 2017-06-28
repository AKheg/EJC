
public abstract class Duck {
    FlyBehavior flyBehavior;
    int speed;

    public abstract int getSpeed();

    public abstract void setSpeed(int speed_value);

    public abstract void display();

     Duck(){

    }

     void performFly() {
        flyBehavior.fly();
    }
}

