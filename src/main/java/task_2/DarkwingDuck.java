package task_2;

public class DarkwingDuck extends Duck{
    DarkwingDuck(){
        flyBehavior = new CapeFloating();
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
