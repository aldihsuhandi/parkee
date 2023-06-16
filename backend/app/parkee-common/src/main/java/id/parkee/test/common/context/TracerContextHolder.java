package id.parkee.test.common.context;

import id.parkee.test.common.model.constant.CommonConst;

import java.util.UUID;

public class TracerContextHolder {
    private static TracerContextHolder instance;
    private final String traceId;

    private TracerContextHolder(String traceId) {
        this.traceId = traceId;
    }

    private static String generateTraceId() {
        return CommonConst.TRACE_PREPEND +
                UUID.randomUUID().toString().replace("-", "")
                        .substring(0, 20);
    }

    public static void initialize() {
        if (instance == null) {
            synchronized (TracerContextHolder.class) {
                if (instance == null) {
                    String traceId = generateTraceId();
                    instance = new TracerContextHolder(traceId);
                }
            }
        }
    }

    public static String getTraceId() {
        if (instance == null) {
            synchronized (TracerContextHolder.class) {
                if (instance == null) {
                    String traceId = generateTraceId();
                    instance = new TracerContextHolder(traceId);
                }
            }
        }

        return instance.getterTraceId();
    }

    public static void removeTracer() {
        if (instance == null) {
            synchronized (TracerContextHolder.class) {
                if (instance == null) {
                    String traceId = generateTraceId();
                    instance = new TracerContextHolder(traceId);
                }
            }
        }
        instance = null;
    }

    private String getterTraceId() {
        return this.traceId;
    }
}
