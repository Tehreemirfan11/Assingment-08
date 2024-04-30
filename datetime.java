import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class datetime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first date (YYYY-MM-DD): ");
        String dateString1 = scanner.nextLine();
        System.out.print("Enter the second date (YYYY-MM-DD): ");
        String dateString2 = scanner.nextLine();
        scanner.close();
        LocalDate date1 = LocalDate.parse(dateString1, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate date2 = LocalDate.parse(dateString2, DateTimeFormatter.ISO_LOCAL_DATE);
        long differenceInDays = Math.abs(ChronoUnit.DAYS.between(date1, date2));

        System.out.println("The difference between the two dates is " + differenceInDays + " days.");
    }
}