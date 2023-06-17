package id.parkee.test.core.configuration;

import id.parkee.test.common.model.enums.ProcessTypeEnum;
import id.parkee.test.core.processor.BaseProcessor;
import id.parkee.test.core.processor.ticket.CheckInProcessor;
import id.parkee.test.core.processor.ticket.CheckOutProcessor;
import id.parkee.test.core.processor.ticket.TicketInfoProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProcessorConfiguration {

    @Autowired
    private CheckInProcessor checkInProcessor;

    @Autowired
    private CheckOutProcessor checkOutProcessor;

    @Autowired
    private TicketInfoProcessor ticketInfoProcessor;

    @Bean
    @Qualifier("processorMap")
    public Map<String, BaseProcessor> processorMap() {
        Map<String, BaseProcessor> processorMap = new HashMap<>();
        processorMap.put(ProcessTypeEnum.CHECKED_IN.getCode(), checkInProcessor);
        processorMap.put(ProcessTypeEnum.CHECKED_OUT.getCode(), checkOutProcessor);
        processorMap.put(ProcessTypeEnum.TICKET_INFO.getCode(), ticketInfoProcessor);

        return processorMap;
    }
}
