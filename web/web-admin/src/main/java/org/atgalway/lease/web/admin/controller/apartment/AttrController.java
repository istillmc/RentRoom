package org.atgalway.lease.web.admin.controller.apartment;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.atgalway.lease.common.result.Result;
import org.atgalway.lease.model.entity.AttrKey;
import org.atgalway.lease.model.entity.AttrValue;
import org.atgalway.lease.web.admin.service.AttrKeyService;
import org.atgalway.lease.web.admin.service.AttrValueService;
import org.atgalway.lease.web.admin.vo.attr.AttrKeyVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "Room Attr Management")
@RestController
@RequestMapping("/admin/attr")
public class AttrController {

    @Autowired
    private AttrKeyService attrKeyService;

    @Autowired
    private AttrValueService attrValueService;

    @Operation(summary = "Create/Update Attr Name")
    @PostMapping("key/saveOrUpdate")
    public Result saveOrUpdateAttrKey(@RequestBody AttrKey attrKey) {
        attrKeyService.saveOrUpdate(attrKey);
        return Result.ok();
    }

    @Operation(summary = "Create/Update Attr Value")
    @PostMapping("value/saveOrUpdate")
    public Result saveOrUpdateAttrValue(@RequestBody AttrValue attrValue) {
        attrValueService.saveOrUpdate(attrValue);
        return Result.ok();
    }


    @Operation(summary = "List Attr Name and Attr Value")
    @GetMapping("list")
    public Result<List<AttrKeyVo>> listAttrInfo() {
        List<AttrKeyVo> list = attrKeyService.listAttrInfo();
        return Result.ok(list);
    }

    @Operation(summary = "Delete Attr Name (by ID)")
    @DeleteMapping("key/deleteById")
    public Result removeAttrKeyById(@RequestParam Long attrKeyId) {
        attrKeyService.removeById(attrKeyId);
        //delete related value
        LambdaQueryWrapper<AttrValue> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(AttrValue::getId, attrKeyId);
        attrValueService.remove(wrapper);
        return Result.ok();
    }

    @Operation(summary = "Delete Attr Value (by ID)")
    @DeleteMapping("value/deleteById")
    public Result removeAttrValueById(@RequestParam Long id) {
        attrValueService.removeById(id);
        return Result.ok();
    }

}
