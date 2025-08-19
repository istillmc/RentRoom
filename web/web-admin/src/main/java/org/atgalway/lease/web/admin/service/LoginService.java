package org.atgalway.lease.web.admin.service;

import org.atgalway.lease.web.admin.vo.login.CaptchaVo;
import org.atgalway.lease.web.admin.vo.login.LoginVo;
import org.atgalway.lease.web.admin.vo.system.user.SystemUserInfoVo;

public interface LoginService {

    CaptchaVo getCaptcha();

    String login(LoginVo loginVo);

    SystemUserInfoVo getUserInfoById(Long userId);
}
