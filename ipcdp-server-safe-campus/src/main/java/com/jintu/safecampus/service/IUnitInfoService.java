package com.jintu.safecampus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditUnitInfoRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindUnitInfoListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveUnitInfoRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.edit.EditUnitInfoResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindSchoolListResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindUnitInfoListResponseDTO;
import com.jintu.safecampus.dal.model.UnitInfo;

/**
 * <p>
 * 单位信息表 单位信息表 服务类
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
public interface IUnitInfoService extends IService<UnitInfo> {
    /**
     * 查询单位信息列表
     * @param requestDTO 查询信息
     * @return 列表
     */
    QueryResponseResult<FindUnitInfoListResponseDTO> findUnitInfoList(FindUnitInfoListRequestDTO requestDTO);
    /**
     * 新增单位
     * @param requestDTO 单位信息
     * @return 是否成功
     */
    ResponseResult saveUnitInfo(SaveUnitInfoRequestDTO requestDTO);
    /**
     * 编辑单位
     * @param requestDTO 单位信息
     * @return 编辑后的信息
     */
    CommonResponseResult<EditUnitInfoResponseDTO> editUnitInfo(EditUnitInfoRequestDTO requestDTO);
    /**
     * 根据单位id查询单位信息
     * @param unitInfoId 单位id
     * @return 单位信息
     */
    CommonResponseResult<EditUnitInfoResponseDTO> findUnitInfoById(Long unitInfoId);
    /**
     * 根据单位id删除单位
     * @param unitInfoId 单位id
     * @return 是否成功
     */
    ResponseResult delUnitInfo(Long unitInfoId);

    /**
     * 查询学校列表
     * @return
     */
    QueryResponseResult<FindSchoolListResponseDTO> findSchoolList();
}
