package com.company;

import com.company.classes.Passenger;
import com.company.classes.PassengerListWrapper;
import javafx.scene.control.Alert;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileOutputStream;
import java.text.Format;
import java.util.*;

public class Main {
    ArrayList<Passenger> passengerList = new ArrayList<Passenger>();
    public static void main(String[] args) {

        Main m = new Main();
        m.loadDataToLists();
        m.OutputInfo("1");
        m.AddPassenger();
        m.OutputInfo("1");
    }

    public void OutputInfo(String option) {
        if (passengerList.size() > 0 && option == "1") {
            System.out.println("List of all passengers:");
            for (int i = 0; i < passengerList.size(); i++){
                Passenger pass = passengerList.get(i);
                Calendar cal = pass.getDateOfBirth();
                System.out.printf("%s %s, %d/%d/%d %s", pass.getFirstName(),
                        pass.getLastName(), cal.get(Calendar.DAY_OF_MONTH),
                        cal.get(Calendar.MONTH),
                        cal.get(Calendar.YEAR), pass.getPassport());
            }

        }
    }

    public void AddPassenger() {
        Scanner in = new Scanner(System.in);
        System.out.println("Input name:");
        String name = in.nextLine();
        System.out.println("Input surname:");
        String surname = in.nextLine();

        Calendar cal = Calendar.getInstance();
        System.out.println("Input year of birth:");
        cal.set(Calendar.YEAR, in.nextInt());
        System.out.println("Input month of birth:");
        cal.set(Calendar.MONTH, in.nextInt());
        System.out.println("Input day of birth:");
        cal.set(Calendar.DAY_OF_MONTH, in.nextInt());
        in.nextLine();
        System.out.println("Passport no:");
        String passport = in.nextLine();

        Passenger pass = new Passenger(name, surname, cal, passport);
        passengerList.add(pass);
        savePassDataToFile(new File("passengers.xml"));
    }

    public void loadDataToLists() {
        loadPassDataFromFile(new File("passengers.xml"));
    }

    public void loadPassDataFromFile(File file) {
        try {
            JAXBContext context = JAXBContext.newInstance(PassengerListWrapper.class);
            Unmarshaller um = context.createUnmarshaller();

            // Чтение XML из файла и демаршализация.
            PassengerListWrapper wrapper = (PassengerListWrapper) um.unmarshal(file);

            passengerList.clear();
            passengerList.addAll(wrapper.getPassengers());

        } catch (Exception e) { // catches ANY exception
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not load data");
            alert.setContentText("Could not load data from file:\n" + file.getPath());

            alert.showAndWait();
        }
    }

    public void savePassDataToFile(File file) {
        try {
            JAXBContext context = JAXBContext.newInstance(PassengerListWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Обёртываем наши данные об адресатах.
            PassengerListWrapper wrapper = new PassengerListWrapper();
            wrapper.setPassengers(passengerList);

            // Маршаллируем и сохраняем XML в файл.
            m.marshal(wrapper, file);
        } catch (Exception e) { // catches ANY exception
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not save data");
            alert.setContentText("Could not save data to file:\n" + file.getPath());

            alert.showAndWait();
        }
    }
}
