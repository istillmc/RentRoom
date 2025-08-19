package org.atgalway.lease.web.admin.controller.apartment;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.atgalway.lease.common.result.Result;
import org.atgalway.lease.model.entity.FeeKey;
import org.atgalway.lease.model.entity.FeeValue;
import org.atgalway.lease.web.admin.service.FeeKeyService;
import org.atgalway.lease.web.admin.service.FeeValueService;
import org.atgalway.lease.web.admin.vo.fee.FeeKeyVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "Room Utility Management")
@RestController
@RequestMapping("/admin/fee")
public class FeeController {

    @Autowired
    private FeeKeyService feeKeyService;

    @Autowired
    private FeeValueService feeValueService;
    @Operation(summary = "Create/Update Utility Name")
    @PostMapping("key/saveOrUpdate")
    public Result saveOrUpdateFeeKey(@RequestBody FeeKey feeKey) {
        feeKeyService.saveOrUpdate(feeKey);
        return Result.ok();
    }

    @Operation(summary = "Create/Update Utility Value")
    @PostMapping("value/saveOrUpdate")
    public Result saveOrUpdateFeeValue(@RequestBody FeeValue feeValue) {
        feeValueService.saveOrUpdate(feeValue);
        return Result.ok();
    }


    @Operation(summary = "List Utility Name and Utility Value")
    @GetMapping("list")
    public Result<List<FeeKeyVo>> feeInfoList() {
        List<FeeKeyVo> list = feeKeyService.feeInfoList();
        return Result.ok(list);
    }

    @Operation(summary = "Delete Utility Name (by ID)")
    @DeleteMapping("key/deleteById")
    public Result deleteFeeKeyById(@RequestParam Long feeKeyId) {

        feeKeyService.removeById(feeKeyId);

        LambdaQueryWrapper<FeeValue> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(FeeValue::getFeeKeyId, feeKeyId);
        feeValueService.remove(queryWrapper);
        return Result.ok();
    }

    @Operation(summary = "Delete Utility Value (by ID)")
    @DeleteMapping("value/deleteById")
    public Result deleteFeeValueById(@RequestParam Long id) {
        feeValueService.removeById(id);
        return Result.ok();
    }
}
