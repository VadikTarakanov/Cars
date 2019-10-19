package Cars;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class  Cars implements Serializable {
    private String nameCar;
    private String model;
    private String year;
    private String type;



    Cars(String nameCar, String model, String year, String type) {
        this.nameCar = nameCar;
        this.model = model;
        this.year = year;
        this.type = type;
    }
    Cars ()
    {

    }

    public void setNameCar(String nameCar) {
        this.nameCar = nameCar;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Производитель :" + this.nameCar + "\n" + " Тип кузова : " + this.type + "\n"
                + " Модель : " + this.model + "\n" + " Год выпуска : " + this.year + "\n";
    }

    public void writeObj (List<Cars> carsList){

        try {
            FileOutputStream fos = new FileOutputStream ("CarsData");
            ObjectOutputStream oos = new ObjectOutputStream(fos);


                oos.writeObject(carsList);

            fos.close();
            System.out.println(" \t Файл успешно записан ");

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }



    public List<Cars> read (List<Cars> list) throws ClassNotFoundException, IOException, EOFException {

        try {

            FileInputStream fis = new FileInputStream("CarsData");
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = ((List<Cars>) ois.readObject());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(list);


        System.out.println("\t Прочитана запись файла ");

        return list ;
    }

}