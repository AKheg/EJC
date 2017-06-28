import sun.plugin2.liveconnect.JSExceptions;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        System.out.println("Welcome to DuckCasino1");

        int Cash = 500;

        while (Cash > 0) {
            System.out.println("choose your duck from 0 to 4:");

            int chosenOne;
            Scanner in = new Scanner(System.in);
            chosenOne = in.nextInt();

            Duck[] ducks = new Duck[5];
            for (int i = 0; i < 5; i++) {
                Duck duck;
                int rnd = (int) (Math.random() * 3);
                switch (rnd) {
                    case 0:
                        duck = new RubberDuck();
                        break;
                    case 1:
                        duck = new MallardDuck();
                        break;
                    case 2:
                        duck = new DarkwingDuck();
                        break;
                    default:
                        duck = new DefaultDuck();
                        break;
                }
                ducks[i] = duck;
                ducks[i].performFly();
            }

            int speedMax = 0;

            for (int i = 0; i < 5; i++) {
                int CurrentSpeed = ducks[i].flyBehavior.getSpeed();
                if (speedMax < CurrentSpeed) {
                    speedMax = CurrentSpeed;
                }
            }
            if (ducks[chosenOne].flyBehavior.getSpeed() < speedMax) {
                System.out.println("you lost!");
                Cash -= 200;
            } else {
                System.out.println("Congratulations! You win!");
                Cash += 200;
            }

            /*for (int i = 0; i < 5; i++) {
                System.out.println(ducks[i].getSpeed());
            }*/
           // System.out.println(chosenOne);
            //System.out.println(speedMax);
            System.out.println("Your balance now: "+Cash);
        }
    }
}