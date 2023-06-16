package id.parkee.test.core.processor;

import id.parkee.test.common.model.request.BaseRequest;
import id.parkee.test.common.model.result.BaseResult;

public interface BaseProcessor {
    void process(BaseRequest baseRequest, BaseResult baseResult);
}
