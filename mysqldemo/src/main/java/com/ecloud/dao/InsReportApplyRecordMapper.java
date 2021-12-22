package com.ecloud.dao;

import com.ecloud.entity.InsReportApplyRecord;
//import com.ecloudtime.bean.ConditionBean;
//import com.ecloudtime.model.InsReportApplyRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 申请社保凭证记录
 *
 * @author eric
 */
@Mapper
@Component
public interface InsReportApplyRecordMapper {

    /**
     * 添加 申请社保凭证记录
     *
     * @param insReportApplyRecord
     * @return
     */
    int insert(InsReportApplyRecord insReportApplyRecord);

    /**
     * 查询 申请社保凭证记录
     *
     * @param sqlsh
     * @return
     */
    InsReportApplyRecord getOneBySqlsh(@Param("sqlsh") String sqlsh);

    /**
     * 根据条件获取 申请社保凭证记录
     *
     * @param conditionBean
     * @return
     */
//    List<InsReportApplyRecord> selectInsReportApplyRecordByCondition(ConditionBean conditionBean);

    /**
     * 根据条件获取 申请社保凭证记录 数量
     *
     * @param conditionBean
     * @return
     */
//    Integer selectInsReportApplyRecordNumByCondition(ConditionBean conditionBean);

    /**
     * 更新 申请社保凭证记录
     *
     * @param insReportApplyRecord
     * @return
     */
    int update(InsReportApplyRecord insReportApplyRecord);

}
