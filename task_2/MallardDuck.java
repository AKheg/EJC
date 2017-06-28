
public class MallardDuck extends Duck{
    MallardDuck(){
        flyBehavior = new FlyWithWings();
    }
    public void display(){
        System.out.println("i am wild duck");
    }
    public int getSpeed(){
        return flyBehavior.getspeed();
    }
    public void setSpeed(int value){
        this.speed = value;
    }
}
