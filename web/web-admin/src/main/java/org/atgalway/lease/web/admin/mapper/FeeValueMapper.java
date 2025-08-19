package org.atgalway.lease.web.admin.mapper;

import org.atgalway.lease.model.entity.FeeValue;
import org.atgalway.lease.web.admin.vo.fee.FeeValueVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author xiaoyang
* @description 针对表【fee_value(杂项费用值表)】的数据库操作Mapper
* @createDate 2025-07-24 15:48:00
* @Entity org.atgalway.lease.model.FeeValue
*/
public interface FeeValueMapper extends BaseMapper<FeeValue> {

    List<FeeValueVo> selectListByApartmentId(Long id);
}




