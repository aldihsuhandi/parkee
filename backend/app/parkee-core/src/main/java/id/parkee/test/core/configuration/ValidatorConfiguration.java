package id.parkee.test.core.configuration;

import id.parkee.test.common.model.enums.ProcessTypeEnum;
import id.parkee.test.core.validator.BaseValidator;
import id.parkee.test.core.validator.ticket.CheckInRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ValidatorConfiguration {

    @Autowired
    private CheckInRequestValidator checkInRequestValidator;

    @Bean
    @Qualifier("validatorMap")
    public Map<String, BaseValidator> validatorMap() {
        Map<String, BaseValidator> validatorMap = new HashMap<>();
        validatorMap.put(ProcessTypeEnum.CHECKED_IN.getCode(), checkInRequestValidator);

        return validatorMap;
    }
}
