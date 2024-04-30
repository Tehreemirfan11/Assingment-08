import java.time.LocalDateTime;
import java.time.Duration;

public class duration{
    public static void main(String[] args) {
        LocalDateTime startTime = LocalDateTime.of(2024, 4, 30, 10, 0); 
        LocalDateTime endTime = LocalDateTime.of(2024, 4, 30, 12, 30); 
        Duration duration = calculateDuration(startTime, endTime);
        System.out.println("Duration of the event: " + duration.toHours() + " hours and " + duration.toMinutesPart() + " minutes.");
    }
    public static Duration calculateDuration(LocalDateTime start, LocalDateTime end) {
        return Duration.between(start, end);
    }
}
