public class Car {
    String brand;
    String model;
    double price;
    String engine;
    double combustion;
    int year;
    int day;
    boolean available;

    public Car(String br, String model, double pr, String en, double com, int ye, boolean aval) {

        this.brand = br;
        this.model = model;
        this.price = pr;
        this.engine = en;
        this.combustion = com;
        this.year = ye;
        this.available = aval;
    }

    @Override
    public String toString(){

        String str = this.brand + " " + this.model + " " + this.engine + " " + this.combustion + " " + this.year + "   cost: " + this.price;

        return str;
    }

    public void startRent(){

        this.available = false;
    }

    public void endRent(){
        this.available = true;
    }

    public static void main(String[] args) {

    }
}
