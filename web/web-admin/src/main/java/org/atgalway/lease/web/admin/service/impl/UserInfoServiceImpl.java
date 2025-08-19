package org.atgalway.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.atgalway.lease.model.entity.UserInfo;
import org.atgalway.lease.web.admin.service.UserInfoService;
import org.atgalway.lease.web.admin.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author xiaoyang
* @description 针对表【user_info(用户信息表)】的数据库操作Service实现
* @createDate 2025-07-24 15:48:00
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService{

}




