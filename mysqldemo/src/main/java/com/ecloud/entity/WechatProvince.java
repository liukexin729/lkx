package com.ecloud.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 省编码 表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "kx_wechat_provinces")
public class WechatProvince implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String createTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String updateTime;

    /**
     * 省编码
     */
    private String provinceCode;

    /**
     * 省名称
     */
    private String provinceName;

    private Integer ready;

    private Integer queryType;

    private Integer weight;

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
//    public Integer getReady() {
//        return ready;
//    }
//
//    public void setReady(Integer ready) {
//        this.ready = ready;
//    }
//
//    public Integer getQueryType() {
//        return queryType;
//    }
//
//    public void setQueryType(Integer queryType) {
//        this.queryType = queryType;
//    }
//
//    public Integer getWeight() {
//        return weight;
//    }
//
//    public void setWeight(Integer weight) {
//        this.weight = weight;
//    }
//
//    public String getRemark() {
//        return remark;
//    }
//
//    public void setRemark(String remark) {
//        this.remark = remark;
//    }
//
//    @Override
//    public String toString() {
//        return "WechatUserInfo{" +
//                " provinceCode=" + provinceCode +
//                " provinceName=" + provinceName +
//                " ready=" + ready +
//                " queryType=" + queryType +
//                "}";
//    }
}
