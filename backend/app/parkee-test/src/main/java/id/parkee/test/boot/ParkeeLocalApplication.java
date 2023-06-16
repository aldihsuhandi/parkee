package id.parkee.test.boot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("id.parkee.test")
@ComponentScan("id.parkee.test")
public class ParkeeLocalApplication {
}
