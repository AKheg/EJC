package task_2;

public class RubberDuck extends Duck {

    RubberDuck(){
        flyBehavior = new FlyNoWay();
    }

    public void display(){
    }

    public int getSpeed(){
        return flyBehavior.getSpeed();
    }

    public void setSpeed(int value){
        this.speed = value;
    }
}

