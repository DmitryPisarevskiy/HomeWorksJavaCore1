package lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean isFull;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        isFull=false;
        System.out.printf("Создан кот %s с аппетитом %d. %s голодный как зверь! \n", name, appetite, name);
    }

    public boolean isFull() {
        return isFull;
    }

    public void info(){
        System.out.printf("Это кот %s. У него аппетит %d. Сейчас он %s \n", name, appetite, isFull? "сытый":"голодный");
    }


    public void eat(Plate p) {
        if (p.getFood()>=appetite) {
            System.out.printf("Кот %s покушал из тарелки %d еды. Он теперь сытый \n", name, appetite);
            p.decreaseFood(appetite);
            isFull=true;
        } else {
            System.out.printf("Кот %s не будет кушать, так как в тарелке %d еды, а аппетит кота %d. Он остался голодный\n", name, p.getFood(), appetite);
            isFull=false;
        }

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }
}
