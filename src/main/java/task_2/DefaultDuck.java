package task_2;

public class DefaultDuck extends Duck{

    DefaultDuck(){
        flyBehavior = new FlyWithWings();
    }

    public void display(){
        System.out.println("i am nothing but a duck");
    }

    public int getSpeed(){
        return flyBehavior.getSpeed();
    }

    public void setSpeed(int value){
        this.speed = value;
    }
}
