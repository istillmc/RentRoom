package org.atgalway.lease.web.admin.service;

import org.atgalway.lease.model.entity.ViewAppointment;
import org.atgalway.lease.web.admin.vo.appointment.AppointmentQueryVo;
import org.atgalway.lease.web.admin.vo.appointment.AppointmentVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author xiaoyang
* @description 针对表【view_appointment(预约看房信息表)】的数据库操作Service
* @createDate 2025-07-24 15:48:00
*/
public interface ViewAppointmentService extends IService<ViewAppointment> {

    IPage<AppointmentVo> pageAppointmentByQuery(IPage<AppointmentVo> page, AppointmentQueryVo queryVo);
}
