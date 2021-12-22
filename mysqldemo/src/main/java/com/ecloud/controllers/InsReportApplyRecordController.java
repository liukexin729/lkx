package com.ecloud.controllers;


import com.alibaba.fastjson.JSON;
import com.ecloud.domain.GlobalParamCode;
import com.ecloud.entity.InsReportApplyRecord;
import com.ecloud.response.ResponseModel;
import com.ecloud.server.IInsReportApplyRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.Map;

/**
 * 本地社保凭据申请记录
 *
 * @author kaijieguo
 */
@RestController
public class InsReportApplyRecordController {

    @Autowired
    IInsReportApplyRecordService insReportApplyRecordService;

    private static final Logger logger = LoggerFactory.getLogger(InsReportApplyRecordController.class);
    /**
     * 社保记录下载申请
     *
     * @param params
     * @return
     */
    @RequestMapping("/ins/report/apply/getOne")
    public ResponseModel applyInsReport(@RequestParam Map<String, String> params) {

        logger.info("请求报文:{}", JSON.toJSONString(params));

        ResponseModel rs = new ResponseModel();

        InsReportApplyRecord insReportApplyRecord = insReportApplyRecordService.getOneBySqlsh(params.get("sqlsh"));

        rs.setRespCode(GlobalParamCode.REQUEST_SUCCESS);
        rs.setRespMsg("请求成功");
        rs.setRespData(insReportApplyRecord);

        logger.info("响应报文:{}",rs.toString());

        return rs;
    }

    /**
     * 更新 申请社保凭证记录
     *
     * @param
     * @return
     */
    @PostMapping("/ins/report/update")
    public String update() {

        InsReportApplyRecord insReportApplyRecord = new InsReportApplyRecord();
        insReportApplyRecord.setSqlsh("45cc0cb063aa44249093869ea00bd163");
        insReportApplyRecord.setStatus(-3);

        logger.info("请求报文:{}", insReportApplyRecord);

        int update = insReportApplyRecordService.update(insReportApplyRecord);

        if (update == 0) {
            return null;
        }

        logger.info("修改成功");
        return null;
    }

}
