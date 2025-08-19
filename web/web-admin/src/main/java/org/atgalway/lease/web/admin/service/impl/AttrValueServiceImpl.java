package org.atgalway.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.atgalway.lease.model.entity.AttrValue;
import org.atgalway.lease.web.admin.service.AttrValueService;
import org.atgalway.lease.web.admin.mapper.AttrValueMapper;
import org.springframework.stereotype.Service;

/**
* @author xiaoyang
* @description 针对表【attr_value(房间基本属性值表)】的数据库操作Service实现
* @createDate 2025-07-24 15:48:00
*/
@Service
public class AttrValueServiceImpl extends ServiceImpl<AttrValueMapper, AttrValue>
    implements AttrValueService{

}




