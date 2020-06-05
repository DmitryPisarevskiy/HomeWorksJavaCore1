package lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
        System.out.println("Создана тарелка. В ней находится " +food +" еды");
    }

    public void increaseFood(int n) {
        food += n;
        System.out.printf("В тарелку добавили еды. Сейчас там %d еды\n", food);
    }

    public void decreaseFood(int n) {
        if (food-n<=0){
            food = 0;
        } else {
            food -= n;
        }
    }

    public void info() {
        System.out.printf("В тарелке находится %d еды\n", food);
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }
}
