package com.ecloud.rabbitmq_ttl_receive.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ecloud.entity.OrderMaster;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 */
@Mapper
@Component
public interface OrderMasterMapper extends BaseMapper<OrderMaster> {

}
