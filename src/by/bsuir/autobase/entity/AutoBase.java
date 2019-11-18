package by.bsuir.autobase.entity;

import java.util.ArrayList;

/**
 * The type Auto base.
 */
public class AutoBase implements java.io.Serializable{

    private static double money;
    private static ArrayList<Vehicle> carList;

    /**
     * Gets money.
     *
     * @return the money
     */
    public static double getMoney() {
        return money;
    }

    /**
     * Sets money.
     *
     * @param money the money
     */
    public static void setMoney(double money) {
        AutoBase.money = money;
    }

    /**
     * Gets car list.
     *
     * @return the car list
     */
    public static ArrayList<Vehicle> getCarList() {
        return carList;
    }

    /**
     * Sets car list.
     *
     * @param carList the car list
     */
    public static void setCarList(ArrayList<Vehicle> carList) {
        AutoBase.carList = carList;
    }


    /**
     * Instantiates a new Auto base.
     */
    public AutoBase() {
    }
}

