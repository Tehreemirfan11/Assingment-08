import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class ReminderSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the date and time for the reminder (yyyy-MM-dd HH:mm:ss):");
        String dateTimeStr = scanner.nextLine();
        System.out.println("Enter the reminder message:");
        String reminderMessage = scanner.nextLine();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date reminderDateTime = dateFormat.parse(dateTimeStr);
            Timer timer = new Timer();
            timer.schedule(new ReminderTask(reminderMessage), reminderDateTime);

            System.out.println("Reminder scheduled for " + dateTimeStr + ".");
        } catch (ParseException e) {
            System.out.println("Invalid date and time format. Please enter in yyyy-MM-dd HH:mm:ss format.");
        }
    }

    static class ReminderTask extends TimerTask {
        private String message;

        public ReminderTask(String message) {
            this.message = message;
        }

        @Override
        public void run() {
            // Display the reminder message when the reminder time arrives
            System.out.println("Reminder: " + message);
        }
    }
}
