package com.ecloud.springbootsender.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ecloud.common_l.entity.TLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 */
@Component
@Mapper
public interface TLogMapper extends BaseMapper<TLog> {

}
