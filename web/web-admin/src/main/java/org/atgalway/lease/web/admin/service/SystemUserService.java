package org.atgalway.lease.web.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.atgalway.lease.model.entity.SystemUser;
import org.atgalway.lease.web.admin.vo.system.user.SystemUserItemVo;
import org.atgalway.lease.web.admin.vo.system.user.SystemUserQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author xiaoyang
* @description 针对表【system_user(员工信息表)】的数据库操作Service
* @createDate 2025-07-24 15:48:00
*/
public interface SystemUserService extends IService<SystemUser> {

    SystemUserItemVo getSystemUserById(Long id);

    IPage<SystemUserItemVo> pageSystemUserByQuery(IPage<SystemUser> page, SystemUserQueryVo queryVo);

    SystemUserItemVo getDetailById(Long id);
}
