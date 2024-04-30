import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Parser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a date in the format 'yyyy-MM-dd': ");
        String dateString = scanner.nextLine();
        LocalDate date;
        try {
            date = LocalDate.parse(dateString);
            System.out.println("Parsed date: " + date);
        } catch (DateTimeParseException e) {
            System.out.println("Error: Invalid date format. Please use the format 'yyyy-MM-dd'.");
        }

        scanner.close();
    }
}
