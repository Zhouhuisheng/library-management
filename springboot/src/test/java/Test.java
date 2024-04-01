import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test {
    @org.junit.jupiter.api.Test
    public void test1() {
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(currentTime);
    }
}
