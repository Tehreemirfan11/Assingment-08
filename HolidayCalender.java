import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HolidayCalendar {

    private static final Map<String, Integer> holidays = new HashMap<>();

    static {
        holidays.put("New Year's Day", 1); 
        holidays.put("Independence Day", 7); 
        holidays.put("Christmas", 12);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();
        scanner.close();

        System.out.println("Major holidays for the year " + year + ":");
        for (Map.Entry<String, Integer> entry : holidays.entrySet()) {
            LocalDate holidayDate = LocalDate.of(year, entry.getValue(), 1);
            if (holidayDate.getMonthValue() != entry.getValue()) { 
                holidayDate = holidayDate.withDayOfMonth(holidayDate.getMonth().length(holidayDate.isLeapYear()));
            }
            System.out.println(entry.getKey() + ": " + holidayDate);
        }
    }
}
