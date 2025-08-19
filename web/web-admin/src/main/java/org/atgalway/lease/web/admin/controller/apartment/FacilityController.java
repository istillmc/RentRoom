package org.atgalway.lease.web.admin.controller.apartment;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.atgalway.lease.common.result.Result;
import org.atgalway.lease.model.entity.FacilityInfo;
import org.atgalway.lease.model.entity.LabelInfo;
import org.atgalway.lease.model.enums.ItemType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.atgalway.lease.web.admin.service.FacilityInfoService;
import org.atgalway.lease.web.admin.service.LabelInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "Facility Management")
@RestController
@RequestMapping("/admin/facility")
public class FacilityController {
    @Autowired
    private FacilityInfoService service;
    @Operation(summary = "List Facilities (by Type)")
    @GetMapping("list")
    public Result<List<FacilityInfo>> listFacility(@RequestParam(required = false) ItemType type) {
        LambdaQueryWrapper<FacilityInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(type != null, FacilityInfo::getType, type);
        List<FacilityInfo> result = service.list(wrapper);
        return Result.ok(result);
    }

    @Operation(summary = "Create/Update Facility")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdate(@RequestBody FacilityInfo facilityInfo) {
        service.saveOrUpdate(facilityInfo);
        return Result.ok();
    }

    @Operation(summary = "Delete Facility (by ID)")
    @DeleteMapping("deleteById")
    public Result removeFacilityById(@RequestParam Long id) {
        service.removeById(id);
        return Result.ok();
    }

}
