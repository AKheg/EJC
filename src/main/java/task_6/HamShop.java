package task_6;

/**
 * Multithreading task. We create several threads to buy hum
 */
public class HamShop {
    private int hamAmount = 100;

    public static void main(String[] args) {
        new HamShop().createCustomers(11);

    }

    private void createCustomers(int amount) {
         int cost = 10;
        for (int i = 0; i < amount; i++) {
            new Thread(() -> buyHam(cost)).start();
        }
    }

    private synchronized void buyHam(int requestedAmount){
        if (requestedAmount <= hamAmount) {
            hamAmount -= requestedAmount;
            System.err.println(Thread.currentThread().getName() + ": Hum remains: " + hamAmount);
        } else {
            System.err.println(Thread.currentThread().getName() + ": Not enough ham to sell");
        }
    }
}
