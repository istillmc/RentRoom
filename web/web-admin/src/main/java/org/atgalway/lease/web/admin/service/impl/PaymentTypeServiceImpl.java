package org.atgalway.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.atgalway.lease.model.entity.PaymentType;
import org.atgalway.lease.web.admin.service.PaymentTypeService;
import org.atgalway.lease.web.admin.mapper.PaymentTypeMapper;
import org.springframework.stereotype.Service;

/**
* @author xiaoyang
* @description 针对表【payment_type(支付方式表)】的数据库操作Service实现
* @createDate 2025-07-24 15:48:00
*/
@Service
public class PaymentTypeServiceImpl extends ServiceImpl<PaymentTypeMapper, PaymentType>
    implements PaymentTypeService{

}




