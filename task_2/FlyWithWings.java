public class FlyWithWings implements FlyBehavior{

    private int speed;

    public int getSpeed(){
        return speed;
    }
    public void fly(){
        int random_number = 10 + (int)(Math.random() * 91);
        int shift = (int)(Math.random() * 2);
        switch(shift){
            case 0: speed = random_number >> 1; break;
            case 1: speed = random_number << 1; break;
            default: speed = random_number; break;
        }
    }
}
