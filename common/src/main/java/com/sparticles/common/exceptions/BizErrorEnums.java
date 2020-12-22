//package com.sparticles.common.exceptions;
//
//import com.alibaba.fastjson.JSONObject;
//
//
//public enum BizErrorEnums {
//
//    TEST_ERROR("BIZ_0001", "创建失败");
//
//    private String bizErrNum;
//    private String bizErrContent;
//
//    BizErrorEnums(String bizErrNum, String bizErrContent) {
//        this.bizErrNum = bizErrNum;
//        this.bizErrContent = bizErrContent;
//    }
//
//    public String bizErrNum() {
//        return bizErrNum;
//    }
//
//    public String bizErrContent() {
//        return bizErrContent;
//    }
//
//    public JSONObject getJson() {
//        JSONObject json = new JSONObject();
//        json.put("bizErrType", this.name());
//        json.put("bizErrContent", this.bizErrContent);
//        json.put("bizErrNum", this.bizErrNum);
//        return json;
//    }
//
//}
