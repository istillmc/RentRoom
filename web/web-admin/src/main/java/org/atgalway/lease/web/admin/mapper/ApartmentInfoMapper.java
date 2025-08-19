package org.atgalway.lease.web.admin.mapper;

import org.atgalway.lease.model.entity.ApartmentInfo;
import org.atgalway.lease.model.enums.LeaseStatus;
import org.atgalway.lease.web.admin.vo.apartment.ApartmentItemVo;
import org.atgalway.lease.web.admin.vo.apartment.ApartmentQueryVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
* @author xiaoyang
* @description 针对表【apartment_info(公寓信息表)】的数据库操作Mapper
* @createDate 2025-07-24 15:48:00
* @Entity org.atgalway.lease.model.ApartmentInfo
*/
public interface ApartmentInfoMapper extends BaseMapper<ApartmentInfo> {

    IPage<ApartmentItemVo> page(Page<ApartmentItemVo> page, ApartmentQueryVo queryVo);
}




