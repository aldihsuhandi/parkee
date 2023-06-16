package id.parkee.test.common.util;

import id.parkee.test.common.context.TracerContextHolder;
import id.parkee.test.common.model.constant.LoggerConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtil {
    private static final Logger EXCEPTION_LOGGER = LoggerFactory.getLogger(LoggerConstant.EXCEPTION_LOGGER);

    public static void info(Logger logger, String message) {
        message = appendTraceId(message);
        logger.info(message);
    }

    public static void exception(String message, Exception cause) {
        message = appendTraceId(message);
        EXCEPTION_LOGGER.error(message, cause);
    }

    private static String appendTraceId(String message) {
        return TracerContextHolder.getTraceId() +
                " - " + message;
    }
}
