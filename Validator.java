import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Validator {

    public static boolean validateDateTime(String inputStr, boolean futureOnly) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        try {
            LocalDateTime inputDateTime = LocalDateTime.parse(inputStr, formatter);
            if (futureOnly && inputDateTime.compareTo(LocalDateTime.now()) <= 0) {
                System.out.println("Please enter a future date and time.");
                return false;
            }
            return true;
        } catch (DateTimeParseException e) {
            System.out.println("Please enter the date and time in the format YYYY-MM-DD HH:MM:SS.");
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter date and time (YYYY-MM-DD HH:MM:SS): ");
            String userInput = scanner.nextLine();
            if (validateDateTime(userInput, true)) {
                System.out.println("Input is valid: " + userInput);
                break;
            } else {
                System.out.println("Invalid input.");
            }
        }
        scanner.close();
    }
}
