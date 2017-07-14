package task_2;

public interface FlyBehavior {
    /**
     * Инкапсулируем сюда способность утки к полету
     * и собственно способ его осуществления.
     * Метод getSpeed() возвращает скорость утки.
     */
    int getSpeed();

    void fly();
}
