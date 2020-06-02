package lesson6;


import com.sun.jmx.snmp.SnmpUnknownAccContrModelException;

public abstract class Animal {

    private static int number=0;
    private String name;
    private int maxDistanceOfRun;

    public Animal(String name) {
        number++;
        this.name=name;
    }

    public void run(int distance){
        if (this.maxDistanceOfRun<distance) {
            System.out.printf("%s не может пробежать %d метров. %s бегает максимум %d метров\n", this.name, distance, this.name, this.maxDistanceOfRun);
        } else {
            System.out.printf("%s пробежал %d метров\n", this.name, distance);
        }
    }

    public abstract void swim(int distance);

    public String getName() {
        return name;
    }

    public static int getNumber() {
        return number;
    }

    public int getMaxDistanceOfRun() {
        return maxDistanceOfRun;
    }

    public void setMaxDistanceOfRun(int maxDistanceOfRun) {
        this.maxDistanceOfRun = maxDistanceOfRun;
    }
}

