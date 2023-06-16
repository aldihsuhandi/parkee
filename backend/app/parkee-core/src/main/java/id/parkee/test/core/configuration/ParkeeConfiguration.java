package id.parkee.test.core.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("id.parkee.test")
@ComponentScan("id.parkee.test")
@EnableJpaRepositories(basePackages = "id.parkee.test")
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
public class ParkeeConfiguration {
}
