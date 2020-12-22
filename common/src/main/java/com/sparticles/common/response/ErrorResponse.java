//package com.sparticles.common.response;
//
//
//import com.sparticles.common.exceptions.BizErrorEnums;
//
//public class ErrorResponse extends ResponseEntity {
//    private Object bizError;
//    /**
//     * 业务错误信息
//     */
//    private String message;
//
//    public ErrorResponse() {
//        super();
//    }
//
//    public ErrorResponse addMessage(String message) {
//        this.message = message;
//        return this;
//    }
//
//    public Object getBizError() {
//        return bizError;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public ErrorResponse addStatus(String status) {
//        this.status = status;
//        return this;
//    }
//
//    public ErrorResponse addBizError(BizErrorEnums bizError) {
//        this.bizError = bizError.getJson();
//        return this;
//    }
//}
