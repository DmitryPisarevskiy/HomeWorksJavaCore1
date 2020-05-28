package lesson5;

import com.sun.org.apache.xpath.internal.objects.XString;

import java.util.Scanner;

public class College {
    private String fio;
    private String position;
    private String eMail;
    private long phone;
    private int salary;
    private byte age;
    private static Scanner sc=new Scanner(System.in);



    public College(String fio, String position, String eMail, long phone, int salary, byte age) {
        this.fio = fio;
        this.position = position;
        this.seteMail(eMail);
        this.setPhone(phone);
        this.salary = salary;
        this.setAge(age);
    }

    public String getFio() {
        return fio;
    }

    public String getPosition() {
        return position;
    }

    public String geteMail() {
        return eMail;
    }

    public long getPhone() {
        return phone;
    }

    public int getSalary() {
        return salary;
    }

    public byte getAge() {
        return age;
    }

    public void printCollege() {
        System.out.println("ФИО - " + fio);
        System.out.println("Должность - " + position);
        System.out.println("email - " + eMail);
        System.out.println("Телефон - " + phone);
        System.out.println("Зарплата, рублей - " + salary);
        System.out.println("Возраст, лет - " + age + "\n");
    }

    public void seteMail(String eMail) {
        do {
            if (!eMail.contains("@")) {
                System.out.println("Введите электронный адрес, содержащий символ @, для сотрудника " + this.fio);
                eMail=sc.nextLine();
            } else {
                break;
            }
        } while (true);
        this.eMail = eMail;
    }

    public void setAge(byte age) {
        do {
            if (age<1) {
                System.out.println("Введите корректный возраст для сотрудника " + this.fio);
                age=sc.nextByte();
            } else {
                break;
            }
        } while (true);
        this.age = age;
    }

    public void setPhone(long phone) {
        do {
            if (phone>100000000000L || phone<10000000000L) {
                System.out.println("Введите номер телефона из 11 цифрф без знака + для сотрудника " + this.fio);
                phone=sc.nextLong();
            } else {
                break;
            }
        } while (true);
        this.phone = phone;
    }
}
