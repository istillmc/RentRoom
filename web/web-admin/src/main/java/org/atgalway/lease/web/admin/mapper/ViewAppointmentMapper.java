package org.atgalway.lease.web.admin.mapper;

import org.atgalway.lease.model.entity.ViewAppointment;
import org.atgalway.lease.web.admin.vo.appointment.AppointmentQueryVo;
import org.atgalway.lease.web.admin.vo.appointment.AppointmentVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
* @author xiaoyang
* @description 针对表【view_appointment(预约看房信息表)】的数据库操作Mapper
* @createDate 2025-07-24 15:48:00
* @Entity org.atgalway.lease.model.ViewAppointment
*/
public interface ViewAppointmentMapper extends BaseMapper<ViewAppointment> {

    IPage<AppointmentVo> pageAppointmentByQuery(IPage<AppointmentVo> page, AppointmentQueryVo queryVo);
}




