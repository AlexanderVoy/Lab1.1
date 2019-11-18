package by.bsuir.autobase.dao.VehicleDao;

import by.bsuir.autobase.entity.AutoBase;
import by.bsuir.autobase.entity.Vehicle;
import by.bsuir.autobase.dao.DaoFactory;
import by.bsuir.Serialize.Serialize;

import java.io.*;
import java.util.ArrayList;

/**
 * The type Vehicle dao.
 */
public class VehicleDAO implements IVehicleDAO {

    private static Serialize<Vehicle> serializer = new Serialize<Vehicle>();
    private static String filePath = getDatabasePath();

    /**
     * Save.
     *
     * @param vehicles the vehicles
     */
    public void save(ArrayList<Vehicle> vehicles){
        serializer.serialize(filePath, vehicles);
    }

    public void delete(int index){
        ArrayList<Vehicle> vehicles = getVehicles();
        if (vehicles != null){
            vehicles.remove(index);
            AutoBase.setCarList(vehicles);
            save(vehicles);
        }
    }

    public void insert(Vehicle vehicle){
        ArrayList<Vehicle> vehicles = getVehicles();
        if (vehicles == null) {
            vehicles = new ArrayList<Vehicle>();
        }
        vehicles.add(vehicle);
        AutoBase.setCarList(vehicles);
        save(vehicles);
    }

    public ArrayList<Vehicle> getVehicles(){
        return serializer.deserialize(filePath);
    }

    /**
     * Get vehicles by year array list.
     *
     * @param year the year
     * @return the array list
     */
    public ArrayList<Vehicle> getVehiclesByYear(int year){
        ArrayList<Vehicle> vehicles = DaoFactory.getVehicleDAO().getVehicles();
        ArrayList<Vehicle> resVehicles = new ArrayList<Vehicle>();
        for (Vehicle vehicle:
             vehicles) {
            if (vehicle.getYear() == year)
                resVehicles.add(vehicle);
        }
        return resVehicles;
    }

    /**
     * Get vehicles by make array list.
     *
     * @param make the make
     * @return the array list
     */
    public ArrayList<Vehicle> getVehiclesByMake(String make){
        ArrayList<Vehicle> vehicles = DaoFactory.getVehicleDAO().getVehicles();
        ArrayList<Vehicle> resVehicles = new ArrayList<Vehicle>();
        for (Vehicle vehicle:
                vehicles) {
            if (vehicle.getMake().toLowerCase().equals(make.toLowerCase()))
                resVehicles.add(vehicle);
        }
        return resVehicles;
    }

    private static String getDatabasePath(){
        return new File("").getAbsolutePath()+"\\data\\cars.dat";
    }
}
