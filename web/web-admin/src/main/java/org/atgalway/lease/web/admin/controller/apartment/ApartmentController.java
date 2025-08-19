package org.atgalway.lease.web.admin.controller.apartment;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.atgalway.lease.common.result.Result;
import org.atgalway.lease.model.entity.ApartmentInfo;
import org.atgalway.lease.model.enums.ReleaseStatus;
import org.atgalway.lease.web.admin.service.ApartmentInfoService;
import org.atgalway.lease.web.admin.vo.apartment.ApartmentDetailVo;
import org.atgalway.lease.web.admin.vo.apartment.ApartmentItemVo;
import org.atgalway.lease.web.admin.vo.apartment.ApartmentQueryVo;
import org.atgalway.lease.web.admin.vo.apartment.ApartmentSubmitVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "Apartment Info Management")
@RestController
@RequestMapping("/admin/apartment")
public class ApartmentController {
    @Autowired
    private ApartmentInfoService service;

    @Operation(summary = "Create Or Update Apartment Info")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdate(@RequestBody ApartmentSubmitVo apartmentSubmitVo) {
        service.saveOrUpdateAllVo(apartmentSubmitVo);
        return Result.ok();
    }

    @Operation(summary = "Paginated Apartment List (by Filters)")
    @GetMapping("pageItem")
    public Result<IPage<ApartmentItemVo>> pageItem(
            @RequestParam long current, @RequestParam long size, ApartmentQueryVo queryVo) {
        Page<ApartmentItemVo> page = new Page<>(current, size);
        IPage<ApartmentItemVo> result = service.pageItemVo(page, queryVo);
        return Result.ok(result);
    }

    @Operation(summary = "Apartment Detailed Info (by ID)")
    @GetMapping("getDetailById")
    public Result<ApartmentDetailVo> getDetailById(@RequestParam Long id) {
        ApartmentDetailVo apartmentInfo = service.getApartmentDetailById(id);
        return Result.ok(apartmentInfo);
    }

    @Operation(summary = "Delete Apartment Info (by ID)")
    @DeleteMapping("removeById")
    public Result removeById(@RequestParam Long id) {
        service.removeApartmentById(id);
        return Result.ok();
    }

    @Operation(summary = "Update Apartment Release Status (by ID)")
    @PostMapping("updateReleaseStatusById")
    public Result updateReleaseStatusById(@RequestParam Long id, @RequestParam ReleaseStatus status) {

        LambdaUpdateWrapper<ApartmentInfo> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(ApartmentInfo::getId, id);
        updateWrapper.set(ApartmentInfo::getIsRelease, status);
        service.update(updateWrapper);
        return Result.ok();
    }

    @Operation(summary = "Apartment Info List (by District ID)")
    @GetMapping("listInfoByDistrictId")
    public Result<List<ApartmentInfo>> listInfoByDistrictId(@RequestParam Long id) {
        LambdaQueryWrapper<ApartmentInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ApartmentInfo::getDistrictId, id);
        List<ApartmentInfo> list = service.list(queryWrapper);
        return Result.ok(list);
    }
}














