package id.parkee.test.test.boot;

import id.parkee.test.core.configuration.ParkeeConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ActiveProfiles("test")
@EnableTransactionManagement
@EntityScan("id.parkee.test")
@ComponentScan("id.parkee.test")
@EnableJpaRepositories(basePackages = "id.parkee.test")
public class ParkeeLocalApplication {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ParkeeConfiguration.class);
        ApplicationContext context = springApplication.run(args);
    }
}
