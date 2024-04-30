import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PersonalCalendar {
    private static final Map<LocalDateTime, String> events = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nPersonal Calendar");
            System.out.println("1. Add Event");
            System.out.println("2. Edit Event");
            System.out.println("3. Delete Event");
            System.out.println("4. View Events");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addEvent();
                    break;
                case 2:
                    editEvent();
                    break;
                case 3:
                    deleteEvent();
                    break;
                case 4:
                    viewEvents();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addEvent() {
        System.out.print("Enter event description: ");
        String description = scanner.nextLine();
        System.out.print("Enter event date and time (YYYY-MM-DD HH:MM): ");
        String dateTimeStr = scanner.nextLine();
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr.replace(" ", "T"));
        events.put(dateTime, description);
        System.out.println("Event added successfully.");
    }

    private static void editEvent() {
        System.out.print("Enter event date and time to edit (YYYY-MM-DD HH:MM): ");
        String dateTimeStr = scanner.nextLine();
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr.replace(" ", "T"));
        if (events.containsKey(dateTime)) {
            System.out.print("Enter new event description: ");
            String description = scanner.nextLine();
            events.put(dateTime, description);
            System.out.println("Event edited successfully.");
        } else {
            System.out.println("Event not found.");
        }
    }

    private static void deleteEvent() {
        System.out.print("Enter event date and time to delete (YYYY-MM-DD HH:MM): ");
        String dateTimeStr = scanner.nextLine();
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr.replace(" ", "T"));
        if (events.containsKey(dateTime)) {
            events.remove(dateTime);
            System.out.println("Event deleted successfully.");
        } else {
            System.out.println("Event not found.");
        }
    }

    private static void viewEvents() {
        if (events.isEmpty()) {
            System.out.println("No events to display.");
        } else {
            System.out.println("Events:");
            for (Map.Entry<LocalDateTime, String> entry : events.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
