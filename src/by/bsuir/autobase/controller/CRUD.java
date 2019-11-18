package by.bsuir.autobase.controller;

import by.bsuir.autobase.dao.DaoFactory;
import by.bsuir.autobase.entity.*;

import java.util.ArrayList;

public class CRUD {
    /**
     * Add vehicle.
     */
    public static void addVehicle() {
        Vehicle vehicle;
        Object[] answer = Controller.addVehicleRequest();

        if ((int)answer[0] == 1){
            vehicle = new Car((String)answer[1], (String)answer[2], (double)answer[3],
                    (double)answer[4], (int)answer[5], (int)answer[6], (FuelType)answer[7],
                    (int)answer[8], (int)answer[9], (BodyType)answer[10]);
        }else{
            vehicle = new Truck((String)answer[1], (String)answer[2], (double)answer[3],
                    (double)answer[4], (int)answer[5], (int)answer[6], (FuelType)answer[7],
                    (int)answer[8], (TruckCategory)answer[9]);
        }

        DaoFactory.getVehicleDAO().insert(vehicle);
    }

    /**
     * Delete vehicle.
     *
     * @return the vehicle
     */
    public static Vehicle deleteVehicle(){
        Vehicle vehicle = null;
        int index = Controller.getVehicleRequest();
        ArrayList<Vehicle> vehicles = DaoFactory.getVehicleDAO().getVehicles();

        if (vehicles != null && index <= vehicles.size()){
            vehicle = DaoFactory.getVehicleDAO().getVehicles().get(index - 1);
            DaoFactory.getVehicleDAO().delete(index - 1);
        }

        return vehicle;
    }

    /**
     * Update vehicle.
     */
    public static void updateVehicle(){
        int index = Controller.getVehicleRequest();
        ArrayList<Vehicle> vehicles = DaoFactory.getVehicleDAO().getVehicles();


        if (vehicles != null && index <= vehicles.size()){
            DaoFactory.getVehicleDAO().delete(index - 1);
            addVehicle();
        }
    }

    /**
     * Get vehicles.
     */
    public static void getVehicles(){
        ArrayList<Object> vehicles = new ArrayList<Object>();
        if (DaoFactory.getVehicleDAO().getVehicles() != null){
            vehicles.addAll(DaoFactory.getVehicleDAO().getVehicles());
            Controller.printListRequest(vehicles);
        }else{System.out.println("There are no any vehicles...");}
    }
}
