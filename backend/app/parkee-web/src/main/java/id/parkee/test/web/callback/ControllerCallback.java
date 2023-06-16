package id.parkee.test.web.callback;

import id.parkee.test.common.model.request.BaseRequest;
import id.parkee.test.common.model.result.BaseResult;

public interface ControllerCallback<T extends BaseRequest, R extends BaseResult> {

    R initResult();

    T composeRequest();

    void process(String processType, T request, R result);
}
