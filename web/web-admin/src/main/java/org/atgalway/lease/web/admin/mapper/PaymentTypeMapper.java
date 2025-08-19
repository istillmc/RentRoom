package org.atgalway.lease.web.admin.mapper;

import org.atgalway.lease.model.entity.PaymentType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author xiaoyang
 * @description 针对表【payment_type(支付方式表)】的数据库操作Mapper
 * @createDate 2025-07-24 15:48:00
 * @Entity org.atgalway.lease.model.PaymentType
 */
public interface PaymentTypeMapper extends BaseMapper<PaymentType> {

    List<PaymentType> selectListByRoomId(Long id);
}




