package org.atgalway.lease.web.admin.controller.system;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.codec.digest.DigestUtils;
import org.atgalway.lease.common.result.Result;
import org.atgalway.lease.model.entity.SystemPost;
import org.atgalway.lease.model.entity.SystemUser;
import org.atgalway.lease.model.enums.BaseStatus;
import org.atgalway.lease.web.admin.service.SystemPostService;
import org.atgalway.lease.web.admin.service.SystemUserService;
import org.atgalway.lease.web.admin.vo.system.user.SystemUserItemVo;
import org.atgalway.lease.web.admin.vo.system.user.SystemUserQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Tag(name = "Backend User Info Management")
@RestController
@RequestMapping("/admin/system/user")
public class SystemUserController {
    @Autowired
    private SystemUserService service;

    @Operation(summary = "Paginated Backend Users")
    @GetMapping("page")
    public Result<IPage<SystemUserItemVo>> page(@RequestParam long current, @RequestParam long size, SystemUserQueryVo queryVo) {
        IPage<SystemUser> page = new Page<>(current, size);
        IPage<SystemUserItemVo> result = service.pageSystemUserByQuery(page, queryVo);
        return Result.ok(result);
    }

    @Operation(summary = "Apartment Backend Users Info (by ID)")
    @GetMapping("getById")
    public Result<SystemUserItemVo> getById(@RequestParam Long id) {
        SystemUserItemVo systemUserItemVo = service.getDetailById(id);
        return Result.ok(systemUserItemVo);
    }

    @Operation(summary = "保存或更新后台用户信息")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdate(@RequestBody SystemUser systemUser) {

        if (systemUser.getPassword() != null) {
            systemUser.setPassword(DigestUtils.md5Hex(systemUser.getPassword()));
        }
        service.saveOrUpdate(systemUser);
        return Result.ok();
    }

    @Operation(summary = "判断后台用户名是否可用")
    @GetMapping("isUserNameAvailable")
    public Result<Boolean> isUsernameExists(@RequestParam String username) {
        LambdaQueryWrapper<SystemUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SystemUser::getUsername, username);
        long count = service.count(queryWrapper);
        return Result.ok(count == 0);
    }

    @DeleteMapping("deleteById")
    @Operation(summary = "根据ID删除后台用户信息")
    public Result removeById(@RequestParam Long id) {
        service.removeById(id);
        return Result.ok();
    }

    @Operation(summary = "根据ID修改后台用户状态")
    @PostMapping("updateStatusByUserId")
    public Result updateStatusByUserId(@RequestParam Long id, @RequestParam BaseStatus status) {
        LambdaUpdateWrapper<SystemUser> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(SystemUser::getId, id);
        updateWrapper.set(SystemUser::getStatus, status);
        service.update(updateWrapper);
        return Result.ok();
    }
}
