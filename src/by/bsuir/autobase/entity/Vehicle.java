package by.bsuir.autobase.entity;


/**
 * The type Vehicle.
 */
public abstract class Vehicle implements java.io.Serializable{

    private String make;
    private String model;
    private double price;
    private double fuelConsumption;
    private int power;
    private int year;
    private FuelType fuelType;


    /**
     * Instantiates a new Vehicle.
     *
     * @param _make            the make
     * @param _model           the model
     * @param _price           the price
     * @param _fuelConsumption the fuel consumption
     * @param _power           the power
     * @param _year            the year
     * @param _fuelType        the fuel type
     */
    public Vehicle(String _make, String _model, double _price, double _fuelConsumption,
                   int _power, int _year, FuelType _fuelType){
        make = _make;
        model = _model;
        price = _price;
        fuelConsumption =_fuelConsumption;
        power = _power;
        year = _year;
        fuelType = _fuelType;
    }

    /**
     * Instantiates a new Vehicle.
     */
    public Vehicle() {
    }

    /**
     * Gets make.
     *
     * @return the make
     */
    public String getMake() {
        return make;
    }

    /**
     * Sets make.
     *
     * @param make the make
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * Gets model.
     *
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets model.
     *
     * @param model the model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets fuel consumption.
     *
     * @return the fuel consumption
     */
    public double getFuelConsumption() {
        return fuelConsumption;
    }

    /**
     * Sets fuel consumption.
     *
     * @param fuelConsumption the fuel consumption
     */
    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    /**
     * Gets power.
     *
     * @return the power
     */
    public int getPower() {
        return power;
    }

    /**
     * Sets power.
     *
     * @param power the power
     */
    public void setPower(int power) {
        this.power = power;
    }

    /**
     * Gets year.
     *
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets year.
     *
     * @param year the year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Gets fuel type.
     *
     * @return the fuel type
     */
    public FuelType getFuelType() {
        return fuelType;
    }

    /**
     * Sets fuel type.
     *
     * @param fuelType the fuel type
     */
    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return  "\n  Make: " + make +
                "\n  Model: " + model +
                "\n  Price: "+ price +
                "\n  Feul Consumption: "+ fuelConsumption +
                "\n  Power: "+ power +
                "\n  Year: "+ year +
                "\n  Feul Type: "+ fuelType.toString();
    }
}