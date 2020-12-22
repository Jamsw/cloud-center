package com.sparticles.common.response;

public enum HttpStatusEnums {
    /**
     * 业务处理错误
     */
    BIZ_ERROR("业务错误"),
    /**
     * 未知的系统异常
     */
    HTTP_500("未知的系统异常"),
    /**
     * 业务处理成功
     */
    BIZ_SUCCESS("业务处理成功"),
    /**
     * 无菜单权限访问
     */
    BIZ_FORBID_URL("无菜单权限访问"),
    /**
     * 无数据访问权限
     */
    BIZ_FORBID_DATA("无数据访问权限"),
    /**
     * 请求参数不支持
     */
    HTTP_400("请求参数不支持");

    private String description;

    HttpStatusEnums(String description) {
        this.description = description;
    }

    public String description() {
        return this.description;
    }
}
