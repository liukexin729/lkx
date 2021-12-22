package com.ecloud.server;

import com.ecloud.entity.InsReportApplyRecord;
//import com.ecloudtime.bean.ConditionBean;
//import com.ecloudtime.model.InsReportApplyRecord;

import java.util.List;

/**
 * @author eric
 */
public interface IInsReportApplyRecordService {

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
    InsReportApplyRecord getOneBySqlsh(String sqlsh);

    /**
     * 更新 申请社保凭证记录
     *
     * @param insReportApplyRecord
     * @return
     */
    int update(InsReportApplyRecord insReportApplyRecord);

}
