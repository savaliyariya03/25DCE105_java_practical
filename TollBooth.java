import java.util.Scanner;
record Vehicle(String number, String type) {}
public class TollBooth {
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int total = 0;
        int bike = 0;
        int car = 0;
        int truck = 0;
        while (true) 
        {
            System.out.print("Enter vehicle number (or 'done'): ");
            String number = sc.next();
            if (number.equalsIgnoreCase("done")) 
            {
                break;
            }
            System.out.print("Enter vehicle type (bike, car, truck): ");
            String type = sc.next().toLowerCase();
            Vehicle vehicle = new Vehicle(number, type);
            int toll = switch (vehicle.type()) 
            {
                case "bike" -> 
                {
                    bike++;
                    yield 20;
                }
                case "car" -> 
                {
                    car++;
                    yield 50;
                }
                case "truck" -> 
                {
                    truck++;
                    yield 150;
                }
                default -> 
                {
                    System.out.println("Invalid vehicle type.");
                    yield 0;
                }
            };
            total += toll;
        }
        String mostFrequent = "none";
        if (car >= bike && car >= truck && car > 0) 
        {
            mostFrequent = "car";
        } 
        else if (bike >= car && bike >= truck && bike > 0) 
        {
            mostFrequent = "bike";
        } else if (truck >= car && truck >= bike && truck > 0) 
        {
            mostFrequent = "truck";
        }
        System.out.println("Total toll: " + total);
        System.out.println("Most frequent: " + mostFrequent);
        sc.close();
    }
}