package org.atgalway.lease.web.admin.mapper;

import org.atgalway.lease.model.entity.SystemUser;
import org.atgalway.lease.web.admin.vo.system.user.SystemUserItemVo;
import org.atgalway.lease.web.admin.vo.system.user.SystemUserQueryVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
* @author xiaoyang
* @description 针对表【system_user(员工信息表)】的数据库操作Mapper
* @createDate 2025-07-24 15:48:00
* @Entity org.atgalway.lease.model.SystemUser
*/
public interface SystemUserMapper extends BaseMapper<SystemUser> {

    IPage<SystemUserItemVo> pageSystemUserByQuery(IPage<SystemUser> page, SystemUserQueryVo queryVo);

    SystemUser selectOneByUsername(String username);
}




