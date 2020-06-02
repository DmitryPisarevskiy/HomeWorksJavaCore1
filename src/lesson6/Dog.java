package lesson6;

public class Dog extends Animal{
    static final int MAX_DISTANCE_TO_RUN=500;
    static final int MAX_DISTANCE_TO_SWIM=10;
    private static int numberOfDogs=0;

    public Dog(String name) {
        super(name);
        System.out.println("Создана собака с именем " + name);
        this.setMaxDistanceOfRun(MAX_DISTANCE_TO_RUN);
        numberOfDogs++;
    }

    public Dog(String name,int maxDistanceToRun) {
        super(name);
        this.setMaxDistanceOfRun(maxDistanceToRun);
        System.out.printf("Создана собака с именем %s. Это необычная собака. Вообще собаки бегают до %d метров. А %s бегает до %d метров\n", name, MAX_DISTANCE_TO_RUN, name, maxDistanceToRun);
        numberOfDogs++;
    }

    @Override
    public void swim(int distance){
        if (distance>MAX_DISTANCE_TO_SWIM) {
            System.out.printf("%s не может проплыть  %d метров. Собаки плавают максимум %d метров.\n",this.getName(),distance,MAX_DISTANCE_TO_SWIM);
        } else {
            System.out.printf("%s проплыл %d метров\n", this.getName(), distance);
        }
    }

    public static int getNumberOfDogs() {
        return numberOfDogs;
    }
}
