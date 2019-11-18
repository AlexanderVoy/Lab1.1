package by.bsuir.autobase.presentation;

import by.bsuir.autobase.controller.CRUD;
import by.bsuir.autobase.controller.Comparerer;
import by.bsuir.autobase.controller.Controller;
import by.bsuir.autobase.controller.Compare.*;
import by.bsuir.autobase.entity.*;

import java.util.Comparator;

/**
 * The type View.
 */
public class View {

    /**
     * Get user data object [ ].
     *
     * @return the object [ ]
     */
    public static Object[] getUserData(){
        String name, password;

        System.out.println("\n1. Manager\n2. Customer");
        int res = ConsoleReader.getInt();
        System.out.print("\nEnter your name :");
        ConsoleReader.getString();
        name = ConsoleReader.getString();
        System.out.print("Enter your password :");
        password = ConsoleReader.getString();
        return new Object[] {res, name, password};
    }

    /**
     * Get vehicle data object [ ].
     *
     * @return the object [ ]
     */
    public static Object[] getVehicleData(){
        String make, model;
        double price, fuelConsumption;
        int power, year;
        FuelType fuelType;

        System.out.println("\n1. Car\n2. Truck");
        int res = ConsoleReader.getInt();
        System.out.print("\nEnter make :");
        ConsoleReader.getString();
        make = ConsoleReader.getString();
        System.out.print("Enter model :");
        model = ConsoleReader.getString();
        System.out.print("Enter price($) :");
        price = Double.parseDouble(ConsoleReader.getString());
        System.out.print("Enter fuelConsumption(l) :");
        fuelConsumption = Double.parseDouble(ConsoleReader.getString());
        System.out.print("Enter power(kW) :");
        power = ConsoleReader.getInt();
        System.out.print("Enter year :");
        year = ConsoleReader.getInt();
        System.out.print("Enter fuelType :\n");

        FuelType[] fuelTypes = FuelType.values();
        for(int i = 0; i < fuelTypes.length; i++){
            System.out.print("   " + i + ". " + fuelTypes[i].toString() + "\n");
        }
        fuelType = FuelType.valueOf((fuelTypes[ConsoleReader.getInt()]).toString());

        if (res == 1){
            int seatCount, doorCount;
            BodyType bodyType;

            System.out.print("Enter seatCount :");
            seatCount = ConsoleReader.getInt();
            System.out.print("Enter doorCount :\n");
            doorCount = ConsoleReader.getInt();

            BodyType[] bodyTypes = BodyType.values();
            for(int i = 0; i < bodyTypes.length; i++){
                System.out.print("   " + i + ". " + bodyTypes[i].toString() + "\n");
            }
            bodyType = BodyType.valueOf((bodyTypes[ConsoleReader.getInt()]).toString());

            return new Object[] {res, make, model, price, fuelConsumption,
                    power, year, fuelType, seatCount, doorCount, bodyType};
        }else {
            int capacity;
            TruckCategory truckCategory;

            System.out.print("Enter capacity :");
            capacity = ConsoleReader.getInt();

            TruckCategory[] truckCategories = TruckCategory.values();
            for (int i = 0; i < truckCategories.length; i++) {
                System.out.print("   " + i + ". " + truckCategories[i].toString() + "\n");
            }
            truckCategory = TruckCategory.valueOf((truckCategories[ConsoleReader.getInt()]).toString());

            return new Object[]{res, make, model, price, fuelConsumption,
                    power, year, fuelType, capacity, truckCategory};
        }
    }

    /**
     * Show message.
     *
     * @param message the message
     */
    public static void showMessage(String message){
        System.out.println(message);
    }

    /**
     * Get action int.
     *
     * @return the int
     */
    public static int getAction(){
        System.out.print("\nInput command: ");
        return ConsoleReader.getInt();
    }

    /**
     * Get index int.
     *
     * @return the int
     */
    public static int getIndex(){
        System.out.print("\nInput index of vehicle: ");
        return ConsoleReader.getInt();
    }

    /**
     * Print available actions.
     */
    public static void printAvailableActions(){
        System.out.println("1. Exit");
        System.out.println("2. Show vehicles");
        System.out.println("3. Find by make");
        System.out.println("4. Find by year");
        System.out.println("5. Alphabet sort");
        System.out.println("6. Year sort");
        System.out.println("7. Add vehicle");
        System.out.println("8. Delete vehicle");
        System.out.println("9. Update");
    }

    public static void chooseActionLoop(){
        boolean flag = true;
        Comparator<Vehicle> pcomp;

        while (flag) {
            View.printAvailableActions();
            int action = View.getAction();

            switch (action) {
                case 1:
                    System.exit(0);
                    break;
                case 2:
                    CRUD.getVehicles();
                    break;
                case 3:
                    Controller.printListRequest(Comparerer.findByMake());
                    break;
                case 4:
                    Controller.printListRequest(Comparerer.findByYear());
                    break;
                case 5:
                    System.out.println("Sort by?(1 - Model, 2 - Make): ");
                    int choose = ConsoleReader.getInt();

                    switch (choose){
                        case 1:
                            pcomp = new CompareByMake().thenComparing(new CompareByModel());
                            Comparerer.sort(pcomp);
                            break;
                        case 2:
                            pcomp = new CompareByMake().thenComparing(new CompareByMake());
                            Comparerer.sort(pcomp);
                            break;
                        default:
                            break;
                    }

                    CRUD.getVehicles();
                    break;
                case 6:
                    pcomp = new CompareByYear();
                    Comparerer.sort(pcomp);
                    CRUD.getVehicles();
                    break;
                case 7:
                    CRUD.addVehicle();
                    break;
                case 8:
                    CRUD.deleteVehicle();
                    break;
                case 9:
                    CRUD.updateVehicle();
                    break;
            }
        }
    }
}
