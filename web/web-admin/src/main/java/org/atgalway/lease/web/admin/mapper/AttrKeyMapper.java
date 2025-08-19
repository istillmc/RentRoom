package org.atgalway.lease.web.admin.mapper;

import org.atgalway.lease.model.entity.AttrKey;
import org.atgalway.lease.web.admin.vo.attr.AttrKeyVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author xiaoyang
* @description 针对表【attr_key(房间基本属性表)】的数据库操作Mapper
* @createDate 2025-07-24 15:48:00
* @Entity org.atgalway.lease.model.AttrKey
*/
public interface AttrKeyMapper extends BaseMapper<AttrKey> {

    List<AttrKeyVo> listAttrInfo();
}




