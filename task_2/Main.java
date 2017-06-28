
public class Main {

    public static void main(String[] args) {
        Duck[] ducks = new Duck[5];
        for (int i = 0; i < 5; i++){
            Duck duck;
            int rnd = (int)(Math.random() * 3);
            switch(rnd){
                case 0: duck = new RubberDuck(); break;
                case 1: duck = new MallardDuck(); break;
                case 2: duck = new DarkwingDuck(); break;
                default: duck = new DefaultDuck(); break;
            }
            ducks[i] = duck;
            ducks[i].performFly();
        }

     MallardDuck MD = new MallardDuck();
     MD.performFly();
     int a = MD.getSpeed();
     for (int i = 0; i < 5; i++){
         System.out.println(ducks[i].getSpeed());
     }
    }
}
