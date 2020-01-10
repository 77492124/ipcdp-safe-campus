package com.jintu.safecampus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jintu.ipcdp.framework.model.response.QueryResponseResult;
import com.jintu.ipcdp.framework.model.response.ResponseResult;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.edit.EditNursingPostTimeRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindNursingPostTimeListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.save.SaveNursingPostTimeRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindNursingPostTimeListResponseDTO;
import com.jintu.safecampus.dal.model.NursingPostTime;

/**
 * <p>
 * 护学岗时间 护学岗时间表 服务类
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
public interface INursingPostTimeService extends IService<NursingPostTime> {
    /**
     * 查询单位护学岗时间列表
     * @param requestDTO 查询条件
     * @return  护学岗时间列表
     */
    QueryResponseResult<FindNursingPostTimeListResponseDTO> findNursingPostTimeList(FindNursingPostTimeListRequestDTO requestDTO);
    /**
     * 添加单位护学岗时间
     * @param requestDTO 护学岗时间
     * @return 是否成功
     */
    ResponseResult saveNursingPostTime(SaveNursingPostTimeRequestDTO requestDTO);
    /**
     * 编辑单位护学岗时间
     * @param requestDTO 护学岗时间
     * @return 是否成功
     */
    ResponseResult editNursingPostTime(EditNursingPostTimeRequestDTO requestDTO);
    /**
     * 根据id删除单位护学岗时间
     * @param nursingPostTimeId 单位护学岗时间Id
     * @return 是否成功
     */
    ResponseResult delNursingPostTime(Long nursingPostTimeId);
}
