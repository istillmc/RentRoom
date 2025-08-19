package org.atgalway.lease.web.admin.mapper;

import org.atgalway.lease.model.entity.GraphInfo;
import org.atgalway.lease.model.enums.ItemType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.atgalway.lease.web.admin.vo.graph.GraphVo;

import java.util.List;

/**
* @author xiaoyang
* @description 针对表【graph_info(图片信息表)】的数据库操作Mapper
* @createDate 2025-07-24 15:48:00
* @Entity org.atgalway.lease.model.GraphInfo
*/
public interface GraphInfoMapper extends BaseMapper<GraphInfo> {

    List<GraphVo> selectListByItemTypeAndId(ItemType itemType, Long id);
}




