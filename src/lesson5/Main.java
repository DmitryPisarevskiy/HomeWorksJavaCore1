package lesson5;

public class Main {
    public static void main(String[] args) {
        College[] colleges = new College[5];
        colleges[0] = new College("Петров Петр Петрович", "главный специалист", "petro@xmail.ru", 89756541541L, 45231, (byte)(55));
        colleges[1] = new College("Иванов Иван Иванович", "начальник отдела", "ivan@xmail.ru", 83456255999L, 100000, (byte)(46));
        colleges[2] = new College("Сидоров Сидор Сидорович", "ведущий специалист", "sidor@xmail.ru", 81239875495L, 35231, (byte)(23));
        colleges[3] = new College("Анжеликова Анжела Варумовна", "младший специалист", "angi@xmail.ru", 83476595123L, 25231, (byte)(23));
        colleges[4] = new College("Пугачев Максим Киркорович", "заместитель начальника отдела", "max@xmail.ru", 87896548789L, 75231, (byte)(42));
        for (int i = 0; i < colleges.length; i++) {
            if (colleges[i].getAge()>40){
                colleges[i].printCollege();
            }
        }
    }
}
