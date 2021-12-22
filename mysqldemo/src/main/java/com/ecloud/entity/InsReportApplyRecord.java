package com.ecloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 社保凭据申请记录表
 *
 * @author eric
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsReportApplyRecord {


    private Integer id;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 更新时间
     */
    private String updateTime;

    private String appId;
    private String openId;
    private String phone;


    /**
     * '缴费信息记录ID'
     */
    private String jfxxlistid;
    /**
     * '终端流水号'
     */
    private String sqlsh;
    /**
     * '身份证号'
     */
    private String zjhm;
    /**
     * '姓名'
     */
    private String xm;

    private String provinceCode;
    private String provinceName;

    /**
     * '缴费金额'
     */
    private String jfje;
    /**
     * '费款所属期起'
     */
    private String fkssqq;
    /**
     * '费款所属期止'
     */
    private String fkssqz;
    /**
     * '缴费日期'
     */
    private String jfrq;
    /**
     * 入库日期
     */
    private String rkrq;
    /**
     * '征收项目名称'
     */
    private String jfxmmc;
    /**
     * '征收品目名称'
     */
    private String jfpmmc;
    /**
     * '征收子目名称'
     */
    private String jfzmmc;
    /**
     * '经办机构名称'
     */
    private String jbjgmc;
    /**
     * '税款所属机关代码'
     */
    private String skssjgdm;
    /**
     * '税款所属机关名称'
     */
    private String skssjgmc;

    private Integer sourceType;
    private String sourceUrl;

    private Long exNum;
    private String exData;

    /**
     * '状态，-1:申请中,0:成功,1:失败,2:受理成功,3:过期'
     */
    private Integer status;

    private String remark;

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(String createTime) {
//        this.createTime = createTime;
//    }
//
//    public String getUpdateTime() {
//        return updateTime;
//    }
//
//    public void setUpdateTime(String updateTime) {
//        this.updateTime = updateTime;
//    }
//
//    public String getAppId() {
//        return appId;
//    }
//
//    public void setAppId(String appId) {
//        this.appId = appId;
//    }
//
//    public String getOpenId() {
//        return openId;
//    }
//
//    public void setOpenId(String openId) {
//        this.openId = openId;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public String getJfxxlistid() {
//        return jfxxlistid;
//    }
//
//    public void setJfxxlistid(String jfxxlistid) {
//        this.jfxxlistid = jfxxlistid;
//    }
//
//    public String getSqlsh() {
//        return sqlsh;
//    }
//
//    public void setSqlsh(String sqlsh) {
//        this.sqlsh = sqlsh;
//    }
//
//    public String getZjhm() {
//        return zjhm;
//    }
//
//    public void setZjhm(String zjhm) {
//        this.zjhm = zjhm;
//    }
//
//    public String getXm() {
//        return xm;
//    }
//
//    public void setXm(String xm) {
//        this.xm = xm;
//    }
//
//    public String getProvinceCode() {
//        return provinceCode;
//    }
//
//    public void setProvinceCode(String provinceCode) {
//        this.provinceCode = provinceCode;
//    }
//
//    public String getProvinceName() {
//        return provinceName;
//    }
//
//    public void setProvinceName(String provinceName) {
//        this.provinceName = provinceName;
//    }
//
//    public String getJfje() {
//        return jfje;
//    }
//
//    public void setJfje(String jfje) {
//        this.jfje = jfje;
//    }
//
//    public String getFkssqq() {
//        return fkssqq;
//    }
//
//    public void setFkssqq(String fkssqq) {
//        this.fkssqq = fkssqq;
//    }
//
//    public String getFkssqz() {
//        return fkssqz;
//    }
//
//    public void setFkssqz(String fkssqz) {
//        this.fkssqz = fkssqz;
//    }
//
//    public String getJfrq() {
//        return jfrq;
//    }
//
//    public void setJfrq(String jfrq) {
//        this.jfrq = jfrq;
//    }
//
//    public String getRkrq() {
//        return rkrq;
//    }
//
//    public void setRkrq(String rkrq) {
//        this.rkrq = rkrq;
//    }
//
//    public String getJfxmmc() {
//        return jfxmmc;
//    }
//
//    public void setJfxmmc(String jfxmmc) {
//        this.jfxmmc = jfxmmc;
//    }
//
//    public String getJfpmmc() {
//        return jfpmmc;
//    }
//
//    public void setJfpmmc(String jfpmmc) {
//        this.jfpmmc = jfpmmc;
//    }
//
//    public String getJfzmmc() {
//        return jfzmmc;
//    }
//
//    public void setJfzmmc(String jfzmmc) {
//        this.jfzmmc = jfzmmc;
//    }
//
//    public String getJbjgmc() {
//        return jbjgmc;
//    }
//
//    public void setJbjgmc(String jbjgmc) {
//        this.jbjgmc = jbjgmc;
//    }
//
//    public String getSkssjgdm() {
//        return skssjgdm;
//    }
//
//    public void setSkssjgdm(String skssjgdm) {
//        this.skssjgdm = skssjgdm;
//    }
//
//    public String getSkssjgmc() {
//        return skssjgmc;
//    }
//
//    public void setSkssjgmc(String skssjgmc) {
//        this.skssjgmc = skssjgmc;
//    }
//
//    public Integer getSourceType() {
//        return sourceType;
//    }
//
//    public void setSourceType(Integer sourceType) {
//        this.sourceType = sourceType;
//    }
//
//    public String getSourceUrl() {
//        return sourceUrl;
//    }
//
//    public void setSourceUrl(String sourceUrl) {
//        this.sourceUrl = sourceUrl;
//    }
//
//    public Long getExNum() {
//        return exNum;
//    }
//
//    public void setExNum(Long exNum) {
//        this.exNum = exNum;
//    }
//
//    public String getExData() {
//        return exData;
//    }
//
//    public void setExData(String exData) {
//        this.exData = exData;
//    }
//
//    public Integer getStatus() {
//        return status;
//    }
//
//    public void setStatus(Integer status) {
//        this.status = status;
//    }
//
//    public String getRemark() {
//        return remark;
//    }
//
//    public void setRemark(String remark) {
//        this.remark = remark;
//    }
}
