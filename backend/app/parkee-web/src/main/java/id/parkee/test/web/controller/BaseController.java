package id.parkee.test.web.controller;

import id.parkee.test.common.model.request.BaseRequest;
import id.parkee.test.common.model.result.BaseResult;
import id.parkee.test.core.processor.BaseProcessor;
import id.parkee.test.core.validator.BaseValidator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class BaseController {
    @Autowired
    private Map<String, BaseProcessor> processorMap;

    @Autowired
    private Map<String, BaseValidator> validatorMap;

    protected void doProcess(String processType, BaseRequest baseRequest, BaseResult baseResult) {
        validatorMap.get(processType).validate(baseRequest);
        processorMap.get(processType).process(baseRequest, baseResult);
    }
}
