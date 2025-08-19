package org.atgalway.lease.web.admin.controller.lease;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.atgalway.lease.common.result.Result;
import org.atgalway.lease.model.enums.AppointmentStatus;
import org.atgalway.lease.web.admin.service.ViewAppointmentService;
import org.atgalway.lease.web.admin.vo.appointment.AppointmentQueryVo;
import org.atgalway.lease.web.admin.vo.appointment.AppointmentVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Tag(name = "Book Viewing Management")
@RequestMapping("/admin/appointment")
@RestController
public class ViewAppointmentController {
    @Autowired
    private ViewAppointmentService service;

    @Operation(summary = "Paginated Appointment List")
    @GetMapping("page")
    public Result<IPage<AppointmentVo>> page(@RequestParam long current, @RequestParam long size, AppointmentQueryVo queryVo) {
        IPage<AppointmentVo> page = new Page<>(current, size);
        IPage<AppointmentVo> list = service.pageAppointmentByQuery(page, queryVo);
        return Result.ok(list);
    }

    @Operation(summary = "Update AppointmentStatus (by ID)")
    @PostMapping("updateStatusById")
    public Result updateStatusById(@RequestParam Long id, @RequestParam AppointmentStatus status) {
        return Result.ok();
    }

}
