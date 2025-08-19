package org.atgalway.lease.web.admin.mapper;

import org.atgalway.lease.model.entity.LeaseAgreement;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.atgalway.lease.web.admin.vo.agreement.AgreementQueryVo;
import org.atgalway.lease.web.admin.vo.agreement.AgreementVo;

/**
* @author xiaoyang
* @description 针对表【lease_agreement(租约信息表)】的数据库操作Mapper
* @createDate 2025-07-24 15:48:00
* @Entity org.atgalway.lease.model.LeaseAgreement
*/
public interface LeaseAgreementMapper extends BaseMapper<LeaseAgreement> {

    IPage<AgreementVo> pageAgreementByQuery(IPage<AgreementVo> page, AgreementQueryVo queryVo);
}




