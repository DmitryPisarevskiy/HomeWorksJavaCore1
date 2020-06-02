package lesson6;

public class Cat extends Animal {
    static final int MAX_DISTANCE_TO_RUN=200;
    private static int numberOfCats=0;


    public Cat(String name) {
        super(name);
        System.out.println("Создана кот с именем " + name);
        this.setMaxDistanceOfRun(MAX_DISTANCE_TO_RUN);
        numberOfCats++;
    }

    public Cat(String name, int maxDistanceToRun) {
        super(name);
        this.setMaxDistanceOfRun(maxDistanceToRun);
        System.out.printf("Создан кот с именем %s. Это необычный кот. Вообще кошки бегают до %d метров. А %s бегает до %d метров\n", name, MAX_DISTANCE_TO_RUN, name, maxDistanceToRun);
        numberOfCats++;
    }

    @Override
    public void swim(int distance){
        System.out.printf("%s не может проплыть %d метров. Кошки вообще не плавают\n",this.getName(),distance);
    }

    public static int getNumberOfCats() {
        return numberOfCats;
    }
}
