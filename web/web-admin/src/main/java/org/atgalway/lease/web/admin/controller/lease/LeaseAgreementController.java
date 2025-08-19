package org.atgalway.lease.web.admin.controller.lease;


import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.atgalway.lease.common.result.Result;
import org.atgalway.lease.model.entity.LeaseAgreement;
import org.atgalway.lease.model.enums.LeaseStatus;
import org.atgalway.lease.web.admin.service.LeaseAgreementService;
import org.atgalway.lease.web.admin.vo.agreement.AgreementQueryVo;
import org.atgalway.lease.web.admin.vo.agreement.AgreementVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Tag(name = "Lease Agreement Management")
@RestController
@RequestMapping("/admin/agreement")
public class LeaseAgreementController {

    @Autowired
    private LeaseAgreementService service;

    @Operation(summary = "Create Or Update Lease Agreement")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdate(@RequestBody LeaseAgreement leaseAgreement) {
        service.saveOrUpdate(leaseAgreement);
        return Result.ok();
    }

    @Operation(summary = "Paginated Lease Agreements (by Filters)")
    @GetMapping("page")
    public Result<IPage<AgreementVo>> page(@RequestParam long current, @RequestParam long size, AgreementQueryVo queryVo) {
        IPage<AgreementVo> page = new Page<>(current, size);
        IPage<AgreementVo> list = service.pageAgreementByQuery(page, queryVo);
        return Result.ok(list);
    }

    @Operation(summary = "Lease Agreement (by ID)")
    @GetMapping(name = "getById")
    public Result<AgreementVo> getById(@RequestParam Long id) {
        AgreementVo apartment = service.getAgreementById(id);
        return Result.ok(apartment);
    }

    @Operation(summary = "Delete Lease Agreement (by ID)")
    @DeleteMapping("removeById")
    public Result removeById(@RequestParam Long id) {
        service.removeById(id);
        return Result.ok();
    }

    @Operation(summary = "Update Lease Agreement Status (by ID)")
    @PostMapping("updateStatusById")
    public Result updateStatusById(@RequestParam Long id, @RequestParam LeaseStatus status) {
        LambdaUpdateWrapper<LeaseAgreement> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(LeaseAgreement::getId, id);
        updateWrapper.set(LeaseAgreement::getStatus, status);
        service.update(updateWrapper);
        return Result.ok();
    }

}

