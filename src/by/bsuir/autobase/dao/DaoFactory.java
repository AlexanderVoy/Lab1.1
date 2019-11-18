package by.bsuir.autobase.dao;

import by.bsuir.autobase.dao.VehicleDao.VehicleDAO;

/**
 * The type Dao factory.
 */
public class DaoFactory {


    private static VehicleDAO vehicleDAO = new VehicleDAO();

    /**
     * Gets vehicle dao.
     *
     * @return the vehicle dao
     */
    public static VehicleDAO getVehicleDAO()
    {
        return vehicleDAO;
    }
}
