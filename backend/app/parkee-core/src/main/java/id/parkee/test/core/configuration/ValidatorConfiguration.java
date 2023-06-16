package id.parkee.test.core.configuration;

import id.parkee.test.core.validator.BaseValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ValidatorConfiguration {
    @Bean
    public Map<String, BaseValidator> validatorMap() {
        Map<String, BaseValidator> validatorMap = new HashMap<>();

        return validatorMap;
    }
}
