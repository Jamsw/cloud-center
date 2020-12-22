//package com.sparticles.common.response;
//
//
//import com.sparticles.common.exceptions.BizErrorEnums;
//
//public class ResponseHelper {
//
//    private ResponseHelper() {
//    }
//
//    public static ErrorResponse failed(String message) {
//        return new ErrorResponse().addStatus(HttpStatusEnums.BIZ_ERROR.name()).addMessage(message);
//    }
//
//    public static ErrorResponse failed(HttpStatusEnums status, String message) {
//        return new ErrorResponse().addStatus(status.name()).addMessage(message);
//    }
//
//    public static ErrorResponse failed(HttpStatusEnums status, String message, BizErrorEnums bizErrorCode) {
//        return new ErrorResponse().addStatus(status.name()).addMessage(message).addBizError(bizErrorCode);
//    }
//
//    public static <T> SuccessResponse<T> success(T data) {
//        return new SuccessResponse<T>().addData(data);
//    }
//
//    public static SuccessResponse success() {
//        return new SuccessResponse().addData("Successfully!");
//    }
//}
