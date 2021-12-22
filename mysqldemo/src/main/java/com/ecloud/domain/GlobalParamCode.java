package com.ecloud.domain;

public class GlobalParamCode {

    /**
     * 通用响应码
     */
    public static final String REQUEST_ERROR = "9999"; //请求失败
    public static final String REQUEST_SUCCESS = "1000"; //请求成功
    public static final String MISS_PARAM = "501"; //缺少请求参数
    public static final String SIGN_ERROR = "502";

    public static final String MSWEB_MISS_PARAM = "601";
    public static final String MSWEB_SIGN_ERROR = "602";
    /**
     * 渠道号
     * 1：微信小程序
     */
    public static final int WX_XCX = 1;

    /**
     * 用户状态
     */
    public static final int USER_STATUS_NORMAL = 20;

    /**
     * 网关相关响应码
     */
    public static final String TOKEN_ERROR = "500";

    /**
     * 理财钱包交易码
     */
    public static final String GET_TOKEN = "TMRI_GET_TOKEN"; //获取token
    public static final String GET_URL = "TMRI_GET_URL"; //获取链接
    public static final String ACC_OPEN_STATUS = "TMRI_GET_STATUS"; //获取开户状态

    /**
     * 雪花算法分布式项目序号
     */
    public static final long CEBBANK_NUM = 1;
    public static final long KAIXIN_NUM = 2;
    public static final long MSWEB_NUM = 3;

    /**
     * 总行开薪宝编号
     */
    public static final String HEAD_KX_UNION_ID = "20210701";
}
