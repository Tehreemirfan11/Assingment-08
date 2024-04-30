import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimeZoneConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter date and time (YYYY-MM-DD HH:MM): ");
        String dateTimeStr = scanner.nextLine();
        System.out.print("Enter source time zone (e.g., America/New_York): ");
        String sourceTimeZone = scanner.nextLine();
        System.out.print("Enter target time zone (e.g., Europe/London): ");
        String targetTimeZone = scanner.nextLine();

        scanner.close();
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        ZonedDateTime sourceZonedDateTime = ZonedDateTime.of(dateTime, ZoneId.of(sourceTimeZone));
        ZonedDateTime targetZonedDateTime = sourceZonedDateTime.withZoneSameInstant(ZoneId.of(targetTimeZone));
        System.out.println("Converted date and time to " + targetTimeZone + ": " + targetZonedDateTime);
    }
}
