package com.jintu.safecampus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jintu.ipcdp.framework.model.response.CommonResponseResult;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditNursingPostPersonRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindNursingPostPersonListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindWorkInRealTimeStaffListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.NursingPostPersonLoginRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveNursingPostPersonRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindNursingPostPersonListResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.NursingPostPersonLoginResponseDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.WorkInRealTimeStaffDTO;
import com.jintu.safecampus.dal.model.NursingPostPerson;

/**
 * <p>
 * 护学岗人员 护学岗人员表 服务类
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
public interface INursingPostPersonService extends IService<NursingPostPerson> {
    /**
     * 查询单位护学岗人员列表
     * @param requestDTO 查询条件
     * @return 护学岗人员列表
     */
    QueryResponseResult<FindNursingPostPersonListResponseDTO> findNursingPostPersonList(FindNursingPostPersonListRequestDTO requestDTO);
    /**
     * 添加护学岗人员
     * @param requestDTO 护学岗人员
     * @return 是否成功
     */
    ResponseResult saveNursingPostPerson(SaveNursingPostPersonRequestDTO requestDTO);
    /**
     * 编辑护学岗人员
     * @param requestDTO 护学岗人员
     * @return 是否成功
     */
    ResponseResult editNursingPostPerson(EditNursingPostPersonRequestDTO requestDTO);
    /**
     * 根据id删除护学岗人员
     * @param nursingPostPersonId 护学岗人员ID
     * @return 是否成功
     */
    ResponseResult delNursingPostPerson(Long nursingPostPersonId);

    /**
     * 护学岗人员APP登录
     * @param requestDTO
     * @return
     */
    CommonResponseResult<NursingPostPersonLoginResponseDTO> nursingPostPersonLogin(NursingPostPersonLoginRequestDTO requestDTO);

    /**
     * 查询今日护学岗人员信息
     * @param requestDTO
     * @return
     */
    QueryResponseResult<WorkInRealTimeStaffDTO> findWorkInRealTimeStaff(FindWorkInRealTimeStaffListRequestDTO requestDTO);
}
