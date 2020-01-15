package com.jintu.safecampus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jintu.safecampus.dal.dao.UnitCameraListMapper;
import com.jintu.safecampus.dal.model.UnitCameraList;
import com.jintu.safecampus.service.IUnitCameraListService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 单位摄像头列表 单位摄像头列表 服务实现类
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Service
public class UnitCameraListServiceImpl extends ServiceImpl<UnitCameraListMapper, UnitCameraList> implements IUnitCameraListService {

    @Resource
    private UnitInfoMapper unitInfoMapper;

    @Override
    public QueryResponseResult<FindUnitCameraListResponseDTO> findUnitCameraList(FindUnitPointListRequestDTO requestDTO) {
        UnitInfo unitInfo = unitInfoMapper.selectById(requestDTO.getUnitInfoId());
        if(ObjectUtils.isEmpty(unitInfo)){
            ExceptionCast.cast("找不到单位信息");
        }

        Page<FindUnitCameraListResponseDTO> page = new Page<>(requestDTO.getCurrent(),requestDTO.getSize());
        IPage<FindUnitCameraListResponseDTO> iPage = baseMapper.findUnitCameraList(page,requestDTO);
        QueryResult<FindUnitCameraListResponseDTO> queryResult = new QueryResult<>(iPage.getRecords(),iPage.getTotal());
        return new QueryResponseResult<>(queryResult);
    }

    @Override
    public ResponseResult saveUnitPoint(SaveUnitCameraRequestDTO requestDTO) {
        UnitInfo unitInfo = unitInfoMapper.selectById(requestDTO.getUnitInfoId());
        if(ObjectUtils.isEmpty(unitInfo)){
            ExceptionCast.cast("找不到单位信息");
        }
        UnitCameraList unitCameraList = new UnitCameraList();
        BeanUtils.copyProperties(requestDTO,unitCameraList);
        boolean save = this.save(unitCameraList);
        if (!save) {
            ExceptionCast.cast("添加单位摄像头信息失败");
        }
        return ResponseResult.SUCCESS();
    }

    @Override
    public ResponseResult editUnitCamera(EditUnitCameraRequestDTO requestDTO) {
        boolean update = new LambdaUpdateChainWrapper<>(baseMapper)
                .eq(UnitCameraList::getId, requestDTO.getId())
                .set(UnitCameraList::getCameraName, requestDTO.getCameraName())
                .set(UnitCameraList::getCameraType, requestDTO.getCameraType())
                .set(UnitCameraList::getLongitude, requestDTO.getLongitude())
                .set(UnitCameraList::getLatitude, requestDTO.getLatitude())
                .set(UnitCameraList::getThreshold, requestDTO.getThreshold())
                .update();
        if (!update) {
            ExceptionCast.cast("修改单位摄像头信息失败");
        }
        return ResponseResult.SUCCESS();
    }

    @Override
    public ResponseResult delUnitCamera(Long unitCameraId) {
        int count = this.count(Wrappers.<UnitCameraList>lambdaQuery().eq(UnitCameraList::getId, unitCameraId));
        if (count<=0) {
            ExceptionCast.cast("摄像头信息不存在！");
        }
        boolean b = this.removeById(unitCameraId);
        if (!b) {
            ExceptionCast.cast("删除失败");
        }
        return ResponseResult.SUCCESS();
    }
}
