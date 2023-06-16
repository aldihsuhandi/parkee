package id.parkee.test.web.callback;

import id.parkee.test.common.context.TracerContextHolder;
import id.parkee.test.common.exception.ParkeeException;
import id.parkee.test.common.model.constant.HeaderConst;
import id.parkee.test.common.model.constant.LoggerConstant;
import id.parkee.test.common.model.enums.ParkeeErrorCode;
import id.parkee.test.common.model.request.BaseRequest;
import id.parkee.test.common.model.result.BaseResult;
import id.parkee.test.common.util.LoggerUtil;
import id.parkee.test.web.form.BaseForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

public class ControllerCallbackSupport {
    public static final Logger LOGGER = LoggerFactory.getLogger(LoggerConstant.CONTROLLER_LOGGER);

    public static <T extends BaseRequest, R extends BaseResult> ResponseEntity<R> process(
            String processType, BaseForm baseForm, ControllerCallback<T, R> callback) {
        TracerContextHolder.initialize();

        LoggerUtil.info(LOGGER, String.format("controller invoke request[form=%s]", baseForm));

        R result = callback.initResult();

        HttpHeaders headers = new HttpHeaders();
        headers.set(HeaderConst.TRACE_ID, TracerContextHolder.getTraceId());

        try {
            T request = callback.composeRequest();

            callback.process(processType, request, result);

        } catch (Exception e) {
            result.setSuccess(false);
            result.setResultCode(ParkeeErrorCode.SYSTEM_ERROR.getErrorCode());
            result.setResultMessage(ParkeeErrorCode.SYSTEM_ERROR.getErrorMessage());

            if (e instanceof ParkeeException) {
                ParkeeException pe = (ParkeeException) e;
                result.setResultCode(pe.getErrorCode().getErrorCode());
                result.setResultMessage(pe.getErrorCode().getErrorMessage());
            }

            LoggerUtil.exception(e.getMessage(), e);
        }

        ResponseEntity<R> response = ResponseEntity
                .ok()
                .headers(headers)
                .body(result);

        LoggerUtil.info(LOGGER, String.format("controller invoke response[response=%s]", response));

        TracerContextHolder.removeTracer();
        return response;
    }
}
