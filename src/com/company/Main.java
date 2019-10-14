package com.company;

import com.company.classes.Passenger;
import com.company.classes.PassengerListWrapper;
import javafx.scene.control.Alert;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.*;

public class Main {
    ArrayList<Passenger> passengerList = new ArrayList<Passenger>();
    public static void main(String[] args) {
        Main m = new Main();
        m.loadDataToLists();
        m.outputMenu();
    }

    public void outputMenu() {
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("Input a to add a new passenger,\n" +
                    "input d to delete a passenger,\n" +
                    "input r to show all passengers,\n" +
                    "input s to search for passengers,\n" +
                    "input o to sort passengers,\n" +
                    "input e to edit passenger,\n" +
                    "press enter to exit.");
            String command = in.nextLine();
            if (command.equals("a")) {
                AddPassenger();
            }
            else if (command.equals("d")) {
                OutputInfo("1");
                DeletePassenger();
            }
            else if (command.equals("e")) {
                OutputInfo("1");
                EditPassenger();
            }
            else if  (command.equals("r")) {
                OutputInfo("1");
            }
            else if  (command.equals("s")) {
                Search(1);
            }
            else if  (command.equals("o")) {
                Sort(1);
            }
            else
                break;
        }
    }

    public void OutputInfo(String option) {
        if (passengerList.size() > 0 && option == "1") {
            System.out.println("List of all passengers:");
            for (int i = 0; i < passengerList.size(); i++){
                Passenger pass = passengerList.get(i);
                System.out.printf("%d) %s %s, %s\n", (i+1), pass.getFirstName(),
                        pass.getLastName(), pass.getPassport());
            }

        }
    }

    public void Search(int option) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your search query:");
        String str =  in.nextLine();

        if (option == 1) {
            for (int i = 0; i < passengerList.size(); i++){
                Passenger pass = passengerList.get(i);
                if (pass.getFirstName().contains(str) || pass.getLastName().contains(str) || pass.getPassport().contains(str)) {
                    System.out.printf("%d) %s %s, %s\n", (i + 1), pass.getFirstName(), pass.getLastName(), pass.getPassport());
                }
            }
        }
    }

    public void Sort(int option) {
        passengerList.sort(Passenger.PassComparator);
        OutputInfo("1");
    }

    public void EditPassenger() {
        Scanner in = new Scanner(System.in);
        System.out.println("Input number of passenger to edit:");
        int num =  in.nextInt();
        in.nextLine();
        System.out.println("Input new data:");
        System.out.println("Input name:");
        String name = in.nextLine();
        System.out.println("Input surname:");
        String surname = in.nextLine();

        System.out.println("Passport no:");
        String passport = in.nextLine();
        passengerList.remove(num - 1);
        Passenger pass = new Passenger(name, surname, passport);
        passengerList.add(num - 1, pass);
        savePassDataToFile(new File("passengers.xml"));
    }

    public void DeletePassenger() {
        Scanner in = new Scanner(System.in);
        OutputInfo("1");
        System.out.println("Input number of passenger to delete:");
        int num =  in.nextInt();
        in.nextLine();
        passengerList.remove(num - 1);
        savePassDataToFile(new File("passengers.xml"));
    }

    public void AddPassenger() {
        Scanner in = new Scanner(System.in);
        System.out.println("Input name:");
        String name = in.nextLine();
        System.out.println("Input surname:");
        String surname = in.nextLine();
        System.out.println("Passport no:");
        String passport = in.nextLine();

        Passenger pass = new Passenger(name, surname, passport);
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

            PassengerListWrapper wrapper = (PassengerListWrapper) um.unmarshal(file);

            passengerList.clear();
            passengerList.addAll(wrapper.getPassengers());

        } catch (Exception e) {
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
            PassengerListWrapper wrapper = new PassengerListWrapper();
            wrapper.setPassengers(passengerList);

            m.marshal(wrapper, file);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not save data");
            alert.setContentText("Could not save data to file:\n" + file.getPath());

            alert.showAndWait();
        }
    }
}
