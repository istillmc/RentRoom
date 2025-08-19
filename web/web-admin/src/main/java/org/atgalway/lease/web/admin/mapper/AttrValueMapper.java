package org.atgalway.lease.web.admin.mapper;

import org.atgalway.lease.model.entity.AttrValue;
import org.atgalway.lease.web.admin.vo.attr.AttrValueVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author xiaoyang
* @description 针对表【attr_value(房间基本属性值表)】的数据库操作Mapper
* @createDate 2025-07-24 15:48:00
* @Entity org.atgalway.lease.model.AttrValue
*/
public interface AttrValueMapper extends BaseMapper<AttrValue> {

    List<AttrValueVo> selectListByRoomId(Long id);
}




