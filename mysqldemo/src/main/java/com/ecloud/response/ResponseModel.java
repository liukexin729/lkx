package com.ecloud.response;

import java.io.Serializable;

/**
 * 标准化前端应答
 * @author Administrator
 * @param <T>
 */
public class ResponseModel<T> implements Serializable {
    /** 错误码 */
    private String respCode;
    /** 提示信息 */
    private String respMsg;
    /** 返回的具体内容 */
    private T respData;

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }

    public T getRespData() {
        return respData;
    }

    public void setRespData(T respData) {
        this.respData = respData;
    }

    @Override
    public String toString() {
        return "Response返回参数{" +
                "respCode=" + respCode +
                ", respMsg=" + respMsg +
                ", respData=" + respData +
                "}";
    }
}
