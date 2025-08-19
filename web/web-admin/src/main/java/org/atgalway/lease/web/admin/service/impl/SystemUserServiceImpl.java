package org.atgalway.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.atgalway.lease.model.entity.SystemPost;
import org.atgalway.lease.model.entity.SystemUser;
import org.atgalway.lease.web.admin.mapper.SystemPostMapper;
import org.atgalway.lease.web.admin.mapper.SystemUserMapper;
import org.atgalway.lease.web.admin.service.SystemUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.atgalway.lease.web.admin.vo.system.user.SystemUserItemVo;
import org.atgalway.lease.web.admin.vo.system.user.SystemUserQueryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiaoyang
 * @description 针对表【system_user(员工信息表)】的数据库操作Service实现
 * @createDate 2025-07-24 15:48:00
 */
@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser>
        implements SystemUserService {
    @Autowired
    private SystemUserMapper systemUserMapper;
    @Autowired
    private SystemPostMapper systemPostMapper;

    @Override
    public SystemUserItemVo getSystemUserById(Long id) {
        SystemUser systemUser = systemUserMapper.selectById(id);

        SystemPost systemPost = systemPostMapper.selectById(systemUser.getPostId());

        SystemUserItemVo systemUserItemVo = new SystemUserItemVo();
        BeanUtils.copyProperties(systemUser, systemUserItemVo);
        systemUserItemVo.setPostName(systemPost.getName());

        return systemUserItemVo;
    }

    @Override
    public IPage<SystemUserItemVo> pageSystemUserByQuery(IPage<SystemUser> page, SystemUserQueryVo queryVo) {
        return systemUserMapper.pageSystemUserByQuery(page, queryVo);
    }

    @Override
    public SystemUserItemVo getDetailById(Long id) {
        SystemUser systemUser = systemUserMapper.selectById(id);

        SystemPost systemPost = systemPostMapper.selectById(systemUser.getPostId());

        SystemUserItemVo systemUserItemVo = new SystemUserItemVo();
        BeanUtils.copyProperties(systemPost, systemUserItemVo);
        systemUserItemVo.setPostName(systemUserItemVo.getPostName());

        return systemUserItemVo;
    }


}




