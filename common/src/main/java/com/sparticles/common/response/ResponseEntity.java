//package com.sparticles.common.response;
//
//import org.slf4j.MDC;
//
//public class ResponseEntity<T> {
//    protected T data;
//    /**
//     * 处理状态
//     * 成功：BIZ_SUCCESS
//     * 失败：业务处理异常-BIZ_ERROR
//     * 其他未知异常-HTTP_500
//     */
//    String status;
//    /**
//     * 请求跟踪id
//     */
//    private String traceId;
//
//    public ResponseEntity() {
//        this.traceId = MDC.get("traceId");
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public String getTraceId() {
//        return traceId;
//    }
//
//    public T getData() {
//        return data;
//    }
//}
