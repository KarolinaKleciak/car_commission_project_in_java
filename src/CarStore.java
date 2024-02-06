import java.awt.image.AreaAveragingScaleFilter;
import java.util.Scanner;
import java.util.ArrayList;


public class CarStore {

    public ArrayList<Car> cars;

    public CarStore() {

        this.cars = new ArrayList<>();
    }

    static int Menu() {
        int choice;
        Scanner scan = new Scanner(System.in);

        System.out.println("CAR STORE\nMENU:\n" + "1.Buy car\n" + "2.Sell\n" + "3.Rent");
        choice = scan.nextInt();

        scan.close();
        return choice;
    }

    public void sellCar() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the brand of car: ");
        String brand = scan.nextLine();
        System.out.println("Enter the model of car: ");
        String model = scan.nextLine();
        System.out.println("Enter the price of the car: ");
        String price_str = scan.nextLine();
        System.out.println("Enter the engine of the car: ");
        String engine = scan.nextLine();
        System.out.println("Enter the combustion of the car: ");
        String combustion_str = scan.nextLine();
        System.out.println("Enter the year of the car: ");
        String year_str = scan.nextLine();

        double price = Double.parseDouble(price_str);
        double combustion = Double.parseDouble(combustion_str);
        int year = Integer.parseInt(year_str);

        this.addCar(brand, model, price, engine, combustion, year);
    }

    public void addCar(String brand, String model, double price, String engine, double combustion, int year) {

        this.cars.add(new Car(brand.toLowerCase(), model.toLowerCase(), price, engine.toLowerCase(), combustion, year, true));

    }

    public void buyCar() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the brand of car: ");
        String brand = scan.nextLine();
        System.out.println("Enter the model of car: ");
        String model = scan.nextLine();


        printCars(brand, model);

        System.out.println("Do you want to buy one of these cars?: [Y/y] ");
        char letter = scan.next().charAt(0);
        if ((letter == 'Y') || (letter == 'y')) {
            this.removeCar();
        }
    }

    public void removeCar() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the brand of car: ");
        String brand = scan.nextLine().toLowerCase();
        System.out.println("Enter the model of car: ");
        String model = scan.nextLine().toLowerCase();
        System.out.println("Enter the engine of the car: ");
        String engine = scan.nextLine().toLowerCase();
        System.out.println("Enter the year of the car: ");
        String year_str = scan.nextLine().toLowerCase();

        int year = Integer.parseInt(year_str);

        Car carToRemove = null;

        for (Car car : cars) {
            if (brand.equals(car.brand) && model.equals(car.model) && engine.equals(car.engine) && year == car.year) {
                carToRemove = car;
                break;
            }
        }

        if (carToRemove != null) cars.remove(carToRemove);
    }

    public void rentCar(){
        Scanner scan = new Scanner(System.in);

        this.printCars("", "");

        System.out.print("Enter the car which you wnat to rent:\nEnter the brand of car: ");
        String brand = scan.nextLine().toLowerCase();
        System.out.println("Enter the model of car: ");
        String model = scan.nextLine().toLowerCase();
        System.out.println("Enter the engine of the car: ");
        String engine = scan.nextLine().toLowerCase();
        System.out.println("Enter the year of the car: ");
        String year_str = scan.nextLine().toLowerCase();


        int year = Integer.parseInt(year_str);

        for (Car car: cars){

            if(brand.equals(car.brand) && model.equals(car.model) && engine.equals(car.engine) && year == car.year);
            car.startRent();
            break;
        }
    }

    public void endRent(){
        Scanner scan = new Scanner(System.in);

        this.printCars("", "");

        System.out.print("Enter the car which you wnat to end rent:\nEnter the brand of car: ");
        String brand = scan.nextLine().toLowerCase();
        System.out.println("Enter the model of car: ");
        String model = scan.nextLine().toLowerCase();
        System.out.println("Enter the engine of the car: ");
        String engine = scan.nextLine().toLowerCase();
        System.out.println("Enter the year of the car: ");
        String year_str = scan.nextLine().toLowerCase();


        int year = Integer.parseInt(year_str);

        for (Car car: cars){

            if(brand.equals(car.brand) && model.equals(car.model) && engine.equals(car.engine) && year == car.year);
            car.endRent();
            break;
        }
    }



    public void printCars(String brand, String model) {
        ArrayList<Car> availableCars = new ArrayList<Car>();
        ArrayList<Car> notavailableCars = new ArrayList<Car>();



        brand = brand.toLowerCase();
        model = model.toLowerCase();



        for (Car car : this.cars) {
            boolean czy_printowac = false;

            if (!brand.isEmpty() && !model.isEmpty())
            {
                if (brand.equals(car.brand) && model.equals(car.model)) czy_printowac = true;
            }
            else if (!brand.isEmpty())
            {
                if (brand.equals(car.brand)) czy_printowac = true;
            }
            else if (!model.isEmpty())
            {
                if (model.equals(car.model)) czy_printowac = true;
            }
            else czy_printowac = true;

            if (czy_printowac)
            {
                if (car.available) availableCars.add(car);
                else notavailableCars.add(car);
            }
        }

        if(!(availableCars.isEmpty())) System.out.println("Available car are: ");

        for (Car car: availableCars) {
            System.out.println(car.toString());
        }

        if(!(notavailableCars.isEmpty())) System.out.println("Not available car are: ");

        for(Car car: notavailableCars){
            System.out.println(car.toString());
        }
    }

    public static void main(String[] args) {

        CarStore store = new CarStore();
        store.addCar("Audi", "a5", 200000, "2.0 TDCI", 8.5, 2023);
        store.addCar("Audi", "q7", 200000, "2.0 TDCI", 8.5, 2017);
        store.addCar("Opel", "vectra", 19000, "6.7 TDI", 6.7, 2013);
        store.addCar("Opel", "astar", 500000, "5.5 TDCI", 3.6, 2002);
        store.addCar("Bmw", "rs3", 2000000, "5.6 TDCI", 6.7, 2023);
        store.addCar("Audi", "q7", 250000, "3.0 TDCI", 10.5, 2021);

        store.cars.getFirst().startRent();
        store.cars.getLast().startRent();

        store.printCars("", "");
        store.buyCar();
        System.out.println("Rent car");
       // store.printCars("", "");
        store.rentCar();
        System.out.println("End rent car");

       // store.printCars("", "");
        store.endRent();
        store.printCars("", "");

        //store.sellCar();
        // System.out.println(store.cars.toString());
    }
}