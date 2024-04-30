import java.util.Scanner;

public class TimeConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the time in 24-hour format (e.g., 14:23): ");
        String time24 = scanner.nextLine();
        scanner.close();
        String[] parts = time24.split(":");
        int hours24 = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        String period;
        if (hours24 >= 12) {
            period = "PM";
            if (hours24 > 12) {
                hours24 -= 12;
            }
        } else {
            period = "AM";
            if (hours24 == 0) {
                hours24 = 12;
            }
        }
        System.out.println("The time in 12-hour format is: " + hours24 + ":" + String.format("%02d", minutes) + " " + period);
    }
}