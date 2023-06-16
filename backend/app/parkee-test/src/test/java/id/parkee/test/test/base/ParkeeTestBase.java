package id.parkee.test.test.base;

import id.parkee.test.core.configuration.ParkeeConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

@ActiveProfiles("test")
@Sql(scripts = "classpath:data.sql")
@SpringBootTest(classes = ParkeeConfiguration.class)
public class ParkeeTestBase {
}
