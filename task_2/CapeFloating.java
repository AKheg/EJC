public class CapeFloating implements FlyBehavior {
    private int speed;

    public int getSpeed(){
        return speed;
    }

    public void fly(){
        int random_number = 5 + (int)(Math.random() * 26);
        int shift = (int)(Math.random() * 2);
        switch(shift){
            case 0: speed = random_number >> 1; break;
            case 1: speed = random_number << 3; break;
            default: speed = random_number; break;
        }
    }
}
