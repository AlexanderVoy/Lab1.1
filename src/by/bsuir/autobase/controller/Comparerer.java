package by.bsuir.autobase.controller;

import by.bsuir.autobase.dao.DaoFactory;
import by.bsuir.autobase.entity.Vehicle;
import by.bsuir.autobase.presentation.ConsoleReader;
import by.bsuir.autobase.presentation.View;

import java.util.ArrayList;
import java.util.Collections;

public class Comparerer {
    /**
     * Find by make array list.
     *
     * @return the array list
     */
    public static ArrayList<Object> findByMake(){
        ArrayList<Object> vehicles;
        View.showMessage("Input make");
        ConsoleReader.getString();
        String answer = ConsoleReader.getString();

        vehicles = new ArrayList<Object>(DaoFactory.getVehicleDAO().getVehiclesByMake(answer));
        return vehicles;
    }

    /**
     * Find by year array list.
     *
     * @return the array list
     */
    public static ArrayList<Object> findByYear(){
        ArrayList<Object> vehicles;
        View.showMessage("Input year");
        int answer = ConsoleReader.getInt();

        vehicles = new ArrayList<Object>(DaoFactory.getVehicleDAO().getVehiclesByYear(answer));
        return vehicles;
    }

    /**
     * Sort array list.
     *
     * @param cmp the cmp
     * @return the array list
     */
    public static void sort(java.util.Comparator<Vehicle> cmp){
        ArrayList<Vehicle> vehicles = DaoFactory.getVehicleDAO().getVehicles();
        Collections.sort(vehicles, cmp);
        DaoFactory.getVehicleDAO().save(vehicles);
    }
}
