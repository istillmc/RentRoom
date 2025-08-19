package org.atgalway.lease.web.admin.service;

import org.atgalway.lease.model.entity.RoomInfo;
import org.atgalway.lease.web.admin.vo.room.RoomDetailVo;
import org.atgalway.lease.web.admin.vo.room.RoomItemVo;
import org.atgalway.lease.web.admin.vo.room.RoomQueryVo;
import org.atgalway.lease.web.admin.vo.room.RoomSubmitVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author xiaoyang
* @description 针对表【room_info(房间信息表)】的数据库操作Service
* @createDate 2025-07-24 15:48:00
*/
public interface RoomInfoService extends IService<RoomInfo> {

    void saveOrUpdateRoom(RoomSubmitVo roomSubmitVo);

    IPage<RoomItemVo> pageRoomItemByQuery(IPage<RoomItemVo> page, RoomQueryVo queryVo);

    RoomDetailVo getRoomDetailById(Long id);

    void removeRoomById(Long id);
}
