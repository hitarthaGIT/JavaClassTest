// Age calculator to print age on any date given by user.

//Solution:
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

public class AgeCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your Birthdate (dd-MM-yyyy):");
        String in1 = scan.next().toUpperCase();  

        System.out.println("Enter the Date you want to calculate the age on (dd-MM-yyyy):");
        String in2 = scan.next().toUpperCase();  

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            Date birth = dateFormat.parse(in1);
            Date targetDate = dateFormat.parse(in2);

         
            long diffInMillies = Math.abs(targetDate.getTime() - birth.getTime());

            
            long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            int years = (int) (diffInDays / 365);
            int months = (int) ((diffInDays % 365) / 30);
            int days = (int) ((diffInDays % 365) % 30);

            System.out.println("The age on the date given is: " + years + " years, " + months + " months, and " + days + " days.");

        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use the format: dd-MM-yyyy (e.g., 15-09-2024)");
        }
    }
}
