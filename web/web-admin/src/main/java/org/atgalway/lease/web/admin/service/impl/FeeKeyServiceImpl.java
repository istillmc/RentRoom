package org.atgalway.lease.web.admin.service.impl;

import org.atgalway.lease.model.entity.FeeKey;
import org.atgalway.lease.web.admin.mapper.FeeKeyMapper;
import org.atgalway.lease.web.admin.service.FeeKeyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.atgalway.lease.web.admin.vo.fee.FeeKeyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author xiaoyang
* @description 针对表【fee_key(杂项费用名称表)】的数据库操作Service实现
* @createDate 2025-07-24 15:48:00
*/
@Service
public class FeeKeyServiceImpl extends ServiceImpl<FeeKeyMapper, FeeKey>
    implements FeeKeyService{
    @Autowired
    private FeeKeyMapper feeKeyMapper;
    @Override
    public List<FeeKeyVo> feeInfoList() {
        return feeKeyMapper.feeInfoList();
    }
}




