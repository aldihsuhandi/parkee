package id.parkee.test.core.configuration;

import id.parkee.test.core.processor.BaseProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProcessorConfiguration {
    @Bean
    public Map<String, BaseProcessor> processorMap() {
        Map<String, BaseProcessor> processorMap = new HashMap<>();

        return processorMap;
    }
}
