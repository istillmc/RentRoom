package org.atgalway.lease.web.admin.controller.apartment;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.atgalway.lease.common.result.Result;
import org.atgalway.lease.model.entity.LabelInfo;
import org.atgalway.lease.model.enums.ItemType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.atgalway.lease.web.admin.service.LabelInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Label Management")
@RestController
@RequestMapping("/admin/label")
public class LabelController {
    @Autowired
    private LabelInfoService service;

    @Operation(summary = "List Labels (by Type)")
    @GetMapping("list")
    public Result<List<LabelInfo>> labelList(@RequestParam(required = false) ItemType type) {
        LambdaQueryWrapper<LabelInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(type != null, LabelInfo::getType, type);
        List<LabelInfo> result = service.list(wrapper);
        return Result.ok(result);
    }

    @Operation(summary = "Create/Update Label")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdateLabel(@RequestBody LabelInfo labelInfo) {
        service.saveOrUpdate(labelInfo);
        return Result.ok();
    }

    @Operation(summary = "Delete Label (by ID)")
    @DeleteMapping("deleteById")
    public Result deleteLabelById(@RequestParam Long id) {
        service.removeById(id);
        return Result.ok();
    }
}
