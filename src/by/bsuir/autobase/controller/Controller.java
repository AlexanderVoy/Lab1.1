package by.bsuir.autobase.controller;

import by.bsuir.autobase.entity.AutoBase;
import by.bsuir.autobase.dao.DaoFactory;
import by.bsuir.autobase.presentation.View;

import java.util.ArrayList;


/**
 * The type Controller.
 */
public class Controller {

    /**
     * Initialize autobase.
     */
    public static void initializeAutobase(){
        AutoBase.setCarList(DaoFactory.getVehicleDAO().getVehicles());
    }

    /**
     * Authorize request object [ ].
     *
     * @return the object [ ]
     */
    public static Object[] authorizeRequest(){
        return View.getUserData();
    }

    /**
     * Add vehicle request object [ ].
     *
     * @return the object [ ]
     */
    public static Object[] addVehicleRequest(){
        return View.getVehicleData();
    }

    /**
     * Print list request.
     *
     * @param list the list
     */
    public static void printListRequest(ArrayList<Object> list){
        int counter = 1;

        if (list != null && list.size() != 0){
            for (Object object : list) {
                View.showMessage(counter+":\n"+object.toString());
                counter++;
            }
        }else {
            View.showMessage("Empty list");
        }
    }

    /**
     * Get vehicle request int.
     *
     * @return the int
     */
    public static int getVehicleRequest(){
        return View.getIndex();
    }
}
