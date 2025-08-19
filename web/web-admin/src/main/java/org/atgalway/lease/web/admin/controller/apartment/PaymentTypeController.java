package org.atgalway.lease.web.admin.controller.apartment;


import org.atgalway.lease.common.result.Result;
import org.atgalway.lease.model.entity.PaymentType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.atgalway.lease.web.admin.service.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "Payment Type Management")
@RequestMapping("/admin/payment")
@RestController
public class PaymentTypeController {

    @Autowired
    private PaymentTypeService service;
    @Operation(summary = "Get All Payment Methods")
    @GetMapping("list")
    public Result<List<PaymentType>> listPaymentType() {
        List<PaymentType> list = service.list();
        return Result.ok(list);
    }

    @Operation(summary = "Save or Update Payment Method")
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdatePaymentType(@RequestBody PaymentType paymentType) {
        service.saveOrUpdate(paymentType);
        return Result.ok();
    }

    @Operation(summary = "Delete Payment Method by ID")
    @DeleteMapping("deleteById")
    public Result deletePaymentById(@RequestParam Long id) {
        service.removeById(id);
        return Result.ok();
    }

}















