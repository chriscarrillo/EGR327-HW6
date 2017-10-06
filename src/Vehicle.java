import java.io.Serializable;
import java.text.NumberFormat;

public class Vehicle implements Serializable {
    private String make;
    private String model;
    private String makeModel;
    private int modelYear;
    private int retailPrice;
    private int mpg;
    private boolean isFourWD;

    // Default constructor
    public Vehicle() {
        this("", "", 0, 0, 0, false);
    }

    public Vehicle(String make, String model, int modelYear, int retailPrice, int mpg, boolean isFourWD) {
        this.make = make;
        this.model = model;
        this.modelYear = modelYear;
        this.retailPrice = retailPrice;
        this.mpg = mpg;
        this.isFourWD = isFourWD;
    }

    public Vehicle(String makeModel, int modelYear, int retailPrice, boolean isFourWD) {
        this.makeModel = makeModel;
        this.modelYear = modelYear;
        this.retailPrice = retailPrice;
        this.isFourWD = isFourWD;
    }

    // Getter methods
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getMakeModel() { return makeModel; }

    public int getModelYear() {
        return modelYear;
    }

    public int getRetailPrice() {
        return retailPrice;
    }

    public int getMPG() {
        return mpg;
    }

    public boolean isFourWD() {
        return isFourWD;
    }

    // Setter methods
    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setMakeModel(String makeModel) { this.makeModel = makeModel; }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public void setRetailPrice(int retailPrice) {
        this.retailPrice = retailPrice;
    }

    public void setMPG(int mpg) {
        this.mpg = mpg;
    }

    public void setFourWD(boolean fourWD) {
        isFourWD = fourWD;
    }

    /**
     * Prints out the vehicle characteristics in a user-friendly format.
     */
    public void printVehicle() {
        System.out.println(this.modelYear + " " + this.make + " " + this.model);
        if (this.isFourWD) System.out.println("4WD");
        System.out.println(NumberFormat.getCurrencyInstance().format(this.retailPrice).replaceAll("\\.00", "")
                + "\n" + this.mpg + "MPG");
    }

    public void printVehicleMM() {
        System.out.println(this.makeModel + "\nYear: " + this.modelYear + "\nPrice: " +
                NumberFormat.getCurrencyInstance().format(this.retailPrice).replaceAll("\\.00", "") +
        "\n4WD: " + this.isFourWD);
    }

    @Override
    public String toString() {
        return this.makeModel + "," + this.modelYear + "," + this.retailPrice + "," +
                (this.isFourWD ? Boolean.toString(this.isFourWD).toUpperCase() : "") + "\n";
    }
}
