package org.atgalway.lease.web.admin.mapper;

import org.atgalway.lease.model.entity.LabelInfo;
import org.atgalway.lease.model.enums.ItemType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author xiaoyang
* @description 针对表【label_info(标签信息表)】的数据库操作Mapper
* @createDate 2025-07-24 15:48:00
* @Entity org.atgalway.lease.model.LabelInfo
*/
public interface LabelInfoMapper extends BaseMapper<LabelInfo> {

    List<LabelInfo> selectListByApartmentId(Long id);

    List<LabelInfo> selectListByRoomId(Long id);
}




