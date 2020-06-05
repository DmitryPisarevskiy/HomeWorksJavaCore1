package lesson7;
//Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль.

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        final int numOfCats=5;
        final String[] namesOfCats=new String[] {"Barsik", "Murzik", "Tom", "Kesha", "Malysh"};
        Cat[] cats=new Cat[numOfCats];
        Plate plate = new Plate(75);
        System.out.println();
        for (int i = 0; i < numOfCats; i++) {
            cats[i]=new Cat(namesOfCats[i], 10+i*5);
            cats[i].eat(plate);
            plate.info();
            System.out.println();
        }
        for (Cat cat:cats) {
            cat.info();
        }
    }
}
