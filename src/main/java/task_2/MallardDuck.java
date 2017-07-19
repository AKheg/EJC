package task_2;

public class MallardDuck extends Duck {

    MallardDuck(){
        flyBehavior = new FlyWithWings();
    }

    public void display(){
        System.out.println("i am wild duck");
    }

    public int getSpeed(){
        return flyBehavior.getSpeed();
    }

    public void setSpeed(int value){
        this.speed = value;
    }
}
