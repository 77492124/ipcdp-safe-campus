package com.jintu.safecampus.dal.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindNursingPostPersonListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.NursingPostPersonUnWorkRecordRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindNursingPostPersonListResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindShiftSettingDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.NursingPostPersonUnWorkRecordResponseDTO;
import com.jintu.safecampus.dal.model.NursingPostPerson;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 护学岗人员 护学岗人员表 Mapper 接口
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
public interface NursingPostPersonMapper extends BaseMapper<NursingPostPerson> {
    /**
     * 查询单位护学岗人员列表
     *
     * @param page       分页
     * @param requestDTO 查询条件
     * @return 护学岗人员列表
     */
    IPage<FindNursingPostPersonListResponseDTO> findNursingPostPersonList(Page<FindNursingPostPersonListResponseDTO> page, @Param("dto") FindNursingPostPersonListRequestDTO requestDTO);

    /**
     * 根据单位id和人员类型查询护学岗人员列表
     *
     * @param unitInfoId 单位id
     * @param personType 人员类型
     * @return 护学岗人员列表
     */
    List<FindShiftSettingDTO> findNursingPostPersonLists(@Param("unitInfoId") Long unitInfoId, @Param("personType") Integer personType);

    /**
     * 查询护学岗人员脱岗记录
     * @param page
     * @param requestDTO
     * @return
     */
    IPage<NursingPostPersonUnWorkRecordResponseDTO> findNursingPostPersonUnWorkRecord(Page page, @Param("requestDTO") NursingPostPersonUnWorkRecordRequestDTO requestDTO);
}
