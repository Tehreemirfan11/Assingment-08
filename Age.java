import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Age {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your birth date (YYYY-MM-DD): ");
        String birthDateStr = scanner.nextLine();
        LocalDate birthDate;
        try {
            birthDate = LocalDate.parse(birthDateStr);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use the format (YYYY-MM-DD).");
            return;
        }
        int age = calculateAge(birthDate);
        System.out.println("You are " + age + " years old.");
        
        scanner.close();
    }
    
    public static int calculateAge(LocalDate birthDate) {
        LocalDate today = LocalDate.now();
        int age = today.getYear() - birthDate.getYear();
        if (today.getMonthValue() < birthDate.getMonthValue() ||
            (today.getMonthValue() == birthDate.getMonthValue() && today.getDayOfMonth() < birthDate.getDayOfMonth())) {
            age--;
        }
        return age;
    }
}
