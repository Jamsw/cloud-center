//package com.sparticles.common.response;
//
//
//public class SuccessResponse<T> extends ResponseEntity<T> {
//
//    public SuccessResponse() {
//        super();
//        this.status = HttpStatusEnums.BIZ_SUCCESS.name();
//    }
//
//    @Override
//    public String getStatus() {
//        return status;
//    }
//
//    public SuccessResponse<T> addData(T data) {
//        super.data = data;
//        return this;
//    }
//}
