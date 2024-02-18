import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //Create a new ArrayListInOrder
        ArrayListInOrder<Coordinates> arr = new ArrayListInOrder<>();

        //Create a new Coordinate with default value set to favorite city
        Coordinates c1 = new Coordinates();

        //Set the range of latitude and longitude
        double startLatitude = -90;
        double endLatitude = 90;
        double startLongtitude = -180;
        double endLongtitude = 180;

        //add the coordinate c1 to the arraylist
        arr.add(c1);
        System.out.println(arr);

        //Generate coordinates based on random latitude and longitude within the set range
        //First to occupy all the space of the array(initially set to 10)
        for (int i = 1; i < arr.getCapability(); i++) {
            double random = new Random().nextDouble();
            double randomLatitude = startLatitude + (random * (endLatitude - startLatitude));
            random = new Random().nextDouble();
            double randomLongtitude = startLongtitude + (random * (endLongtitude - startLongtitude));
            arr.add(new Coordinates(randomLatitude,randomLongtitude));
        }
        System.out.println(arr);

        //Create a new Coordinate with default value set to favorite city
        Coordinates c2 = new Coordinates();
        //add the coordinate c2 to the arraylist
        arr.add(c2);

        System.out.println(arr);
    }
}