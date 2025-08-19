package org.atgalway.lease.web.admin.mapper;

import org.atgalway.lease.model.entity.FeeKey;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.atgalway.lease.web.admin.vo.fee.FeeKeyVo;

import java.util.List;

/**
* @author xiaoyang
* @description 针对表【fee_key(杂项费用名称表)】的数据库操作Mapper
* @createDate 2025-07-24 15:48:00
* @Entity org.atgalway.lease.model.FeeKey
*/
public interface FeeKeyMapper extends BaseMapper<FeeKey> {

    List<FeeKeyVo> feeInfoList();
}




