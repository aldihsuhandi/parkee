package id.parkee.test.core.configuration;

import id.parkee.test.common.model.enums.ProcessTypeEnum;
import id.parkee.test.core.validator.BaseValidator;
import id.parkee.test.core.validator.ticket.CheckInRequestValidator;
import id.parkee.test.core.validator.ticket.CheckOutRequestValidator;
import id.parkee.test.core.validator.ticket.TicketInfoRequestValidator;
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

    @Autowired
    private CheckOutRequestValidator checkOutRequestValidator;

    @Autowired
    private TicketInfoRequestValidator ticketInfoRequestValidator;

    @Bean
    @Qualifier("validatorMap")
    public Map<String, BaseValidator> validatorMap() {
        Map<String, BaseValidator> validatorMap = new HashMap<>();
        validatorMap.put(ProcessTypeEnum.CHECKED_IN.getCode(), checkInRequestValidator);
        validatorMap.put(ProcessTypeEnum.CHECKED_OUT.getCode(), checkOutRequestValidator);
        validatorMap.put(ProcessTypeEnum.TICKET_INFO.getCode(), ticketInfoRequestValidator);

        return validatorMap;
    }
}
