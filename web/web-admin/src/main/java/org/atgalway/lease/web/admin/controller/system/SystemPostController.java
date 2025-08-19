package org.atgalway.lease.web.admin.controller.system;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.atgalway.lease.common.result.Result;
import org.atgalway.lease.model.entity.SystemPost;
import org.atgalway.lease.model.enums.BaseStatus;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.atgalway.lease.web.admin.service.SystemPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Tag(name = "Backend User Position Management")
@RequestMapping("/admin/system/post")
public class SystemPostController {
    @Autowired
    private SystemPostService service;

    @Operation(summary = "Paginated List )")
    @GetMapping("page")
    private Result<IPage<SystemPost>> page(@RequestParam long current, @RequestParam long size) {
        IPage<SystemPost> page = new Page<>(current, size);
        IPage<SystemPost> systemPostPage = service.page(page);
        return Result.ok(systemPostPage);
    }

    @Operation(summary = "Create Or Update Backend User Position")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdate(@RequestBody SystemPost systemPost) {
        service.saveOrUpdate(systemPost);
        return Result.ok();
    }

    @DeleteMapping("deleteById")
    @Operation(summary = "Delete Apartment Backend User Position (by ID)")
    public Result removeById(@RequestParam Long id) {
        service.removeById(id);
        return Result.ok();
    }

    @GetMapping("getById")
    @Operation(summary = "Apartment Backend User Position (by ID)")
    public Result<SystemPost> getById(@RequestParam Long id) {
        SystemPost post = service.getById(id);
        return Result.ok(post);
    }

    @Operation(summary = "All Apartment Backend User Positions")
    @GetMapping("list")
    public Result<List<SystemPost>> list() {
        List<SystemPost> list = service.list();
        return Result.ok(list);
    }

    @Operation(summary = "Update Apartment Backend User Position (by ID)")
    @PostMapping("updateStatusByPostId")
    public Result updateStatusByPostId(@RequestParam Long id, @RequestParam BaseStatus status) {
        LambdaUpdateWrapper<SystemPost> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(SystemPost::getId, id);
        updateWrapper.set(SystemPost::getStatus, status);
        service.update(updateWrapper);
        return Result.ok();
    }
}
