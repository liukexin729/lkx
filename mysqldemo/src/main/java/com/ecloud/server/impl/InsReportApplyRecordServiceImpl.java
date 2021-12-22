package com.ecloud.server.impl;

import com.ecloud.dao.InsReportApplyRecordMapper;
import com.ecloud.entity.InsReportApplyRecord;
import com.ecloud.server.IInsReportApplyRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author Administrator
 */
@Service
public class InsReportApplyRecordServiceImpl implements IInsReportApplyRecordService {

    private static final Logger logger = LoggerFactory.getLogger(InsReportApplyRecordServiceImpl.class);

    @Autowired
    InsReportApplyRecordMapper insReportApplyRecordMapper;

    /**
     * 添加 申请社保凭证记录
     *
     * @param insReportApplyRecord
     * @return
     */
    @Override
    public int insert(InsReportApplyRecord insReportApplyRecord) {
        return insReportApplyRecordMapper.insert(insReportApplyRecord);
    }

    /**
     * 查询 申请社保凭证记录(cong ku)
     *
     * @param sqlsh
     * @return
     */
    @Override
    public InsReportApplyRecord getOneBySqlsh(String sqlsh) {
        return insReportApplyRecordMapper.getOneBySqlsh(sqlsh);
    }

    /**
     * 更新 申请社保凭证记录
     *
     * @param insReportApplyRecord
     * @return
     */
    @Override
    public int update(InsReportApplyRecord insReportApplyRecord) {
        return insReportApplyRecordMapper.update(insReportApplyRecord);
    }

}
