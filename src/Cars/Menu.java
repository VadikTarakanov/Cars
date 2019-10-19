package Cars;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu extends Cars implements Serializable {

    List<Cars> carsList = new ArrayList<>();

    Scanner sc = new Scanner(System.in);


    public void defaultCars() {
        Cars object1 = new Cars("Lada", "911", "1998", "Sidan");
        Cars object2 = new Cars("Porshe", "Macan", "2000", "Jeep");
        Cars object3 = new Cars("BMV", "Alpina", "2010", "Sidan");
        carsList.add(object1);
        carsList.add(object2);
        carsList.add(object3);


    }

    public void createCar() throws IndexOutOfBoundsException, IOException, ClassNotFoundException {
        int a;
        System.out.println("Для создания добавления новой машины в справочник нажмите 1 :");
        System.out.println("Для просмотра всех машин в справочнике нажмите 2 :");
        System.out.println("Для удаления машины из справочника нажмите 3");
        System.out.println("Для перезаписи данных из справочника нажмите 4");
        System.out.println("Для сохранения данных в файл нажмите 5 ");
        System.out.println("Для чтения сохраненных данных из файла нажмите 6 ");
        a = sc.nextInt();
        String str = sc.nextLine();


        if (a == 1) {

            System.out.println("Введите производителя машины :");
            String nameCar = sc.nextLine();

            System.out.println("Введите модель машины :");
            String model = sc.nextLine();

            System.out.println("Введите год машины :");
            String year = sc.nextLine();

            System.out.println("Введите тип кузова машины :");
            String type = sc.nextLine();


            carsList.add(new Cars(nameCar, model, year, type));

            System.out.println("Всего машин в справочнике :");
            System.out.println(carsList.size());
            createCar();

        }
        if (a == 2) {
            System.out.println(carsList);
            createCar();
        }

        if (a == 3) {
            System.out.println("Введите индекс удаляемого объекта :");

            try {
                int b = sc.nextInt();
                carsList.remove(b);
                System.out.println("Объект успешно удален");

            } catch (IndexOutOfBoundsException e) {

                System.out.println("Объекта с таким индексом не существует.");
            }

        }

        if (a == 4) {
            int val;
            int valcase;
            System.out.println("Введите индекс редактируемого объекта :");
            val = sc.nextInt();
            String str2 = sc.nextLine();
            System.out.println("Для изменения производителя нажмите 1" + "\n" + "Для изменения наименования модели нажмите 2" +
                    "\n" + "Для изменения года выпуска автомобиля нажмите 3" + "\n" + "Для типа кузова автомобиля нажмите 4" + "\n");
            valcase = sc.nextInt();
            String str3 = sc.nextLine();

            if (valcase == 1) {
                System.out.println("Введите новое имя производителя :");
                String name = sc.nextLine();
                carsList.get(val).setNameCar(name);
            }

            if (valcase == 2) {
                System.out.println("Введите новое наименование модели :");
                String model = sc.nextLine();
                carsList.get(val).setModel(model);
            }
            if (valcase == 3) {
                System.out.println("Введите новый года выпуска автомобиля :");
                String year = sc.nextLine();
                carsList.get(val).setYear(year);
            }
            if (valcase == 4) {
                System.out.println("Введите новый тип кузова :");
                String type = sc.nextLine();
                carsList.get(val).setType(type);
            }
            if (valcase > 4) {
                System.out.println("Вы ввели неверное значение несуществующей операции, попробуйте ввести значение снова. ");
            }

        }
        if (a == 5) {
            Menu.super.writeObj(carsList);

        }
        if (a == 6) {

                Menu.super.read(carsList);



        }
        if(a < 0 | a > 6){
            System.out.println("Вы ввели неверное значение несуществующей операции, попробуйте ввести значение снова.  ");
        }

        createCar();
    }

}
