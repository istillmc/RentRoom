package org.atgalway.lease.web.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.atgalway.lease.model.entity.CityInfo;
import org.atgalway.lease.web.admin.service.CityInfoService;
import org.atgalway.lease.web.admin.mapper.CityInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author xiaoyang
* @description 针对表【city_info】的数据库操作Service实现
* @createDate 2025-07-24 15:48:00
*/
@Service
public class CityInfoServiceImpl extends ServiceImpl<CityInfoMapper, CityInfo>
    implements CityInfoService{

}




