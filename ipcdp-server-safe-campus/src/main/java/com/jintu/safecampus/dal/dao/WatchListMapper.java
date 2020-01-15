package com.jintu.safecampus.dal.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.ExportWatchListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.request.find.FindWatchListRequestDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindWatchListDTO;
import com.jintu.ipcdp.framework.model.safecampus.dto.response.find.FindWatchListResponseDTO;
import com.jintu.safecampus.common.dto.response.ExportPrincipal;
import com.jintu.safecampus.common.dto.response.ExportWatchListDTO;
import com.jintu.safecampus.dal.model.WatchList;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 值班表 值班表信息 Mapper 接口
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
public interface WatchListMapper extends BaseMapper<WatchList> {
    /**
     * 查询删除的人员是否还有值班安排
     *
     * @param nursingPostPersonId 护学岗人员Id
     * @param localDate
     * @return int
     */
    int countDutyArrangement(@Param("nursingPostPersonId") Long nursingPostPersonId, @Param("localDate") LocalDate localDate);
    /**
     * 查询值班列表
     * @param page 分页
     * @param requestDTO 查询条件
     * @return 值班列表
     */
    IPage<FindWatchListResponseDTO> findWatchList(Page<FindWatchListResponseDTO> page, @Param("dto") FindWatchListRequestDTO requestDTO);

    /**
     * 根据值班id查询负责人列表
     * @param id 值班id
     * @return 负责人列表
     */
    List<FindWatchListDTO> findPrincipalList(Long id);

    /**
     * 查询导出列表
     * @param requestDTO 查询条件
     * @return 导出列表
     */
    List<ExportWatchListDTO> findExportWatchList(@Param("dto") ExportWatchListRequestDTO requestDTO);

    /**
     * 根据值班id查询负责人列表(导出使用，解决只写xml异常)
     * @param id 值班id
     * @return 负责人列表
     */
    List<ExportPrincipal> findExportPrincipal(Long id);
}
