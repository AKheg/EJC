package task_2;

public abstract class Duck {
    FlyBehavior flyBehavior;
    int speed;

    Duck(){

    }

    public abstract int getSpeed();

    public abstract void setSpeed(int speed_value);

    public abstract void display();

     void performFly() {
        flyBehavior.fly();
    }
}

