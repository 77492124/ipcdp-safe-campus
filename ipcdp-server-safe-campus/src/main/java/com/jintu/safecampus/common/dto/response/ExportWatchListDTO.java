package com.jintu.safecampus.common.dto.response;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.List;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/13 18:06
 * @Version 1.0
 */
@Data
@ExcelTarget("exportWatchListDTO")
@Accessors(chain = true)
public class ExportWatchListDTO {
    /**
     * 唯一标识ID 唯一标识ID 值班id
     */
    private Long id;

    /**
     * 工作日期 工作日期
     * yyyy-MM-dd
     */
    @Excel(name = "工作日期", orderNum = "1",format = "yyyy-MM-dd",needMerge = true, width=15)
    private LocalDate workingDate;

    /**
     * HH:mm:ss
     * 时间名称 时间名称+开始时间 - 结束时间
     */
    @Excel(name = "工作时间", orderNum = "2",needMerge = true, width=25)
    private String timeName;

    /**
     * 点位名称 点位名称
     */
    @Excel(name = "地点", orderNum = "3",needMerge = true, width=15)
    private String pointName;

    /**
     * 负责人列表
     */
    @ExcelCollection(name = "负责人", orderNum = "4")
    private List<ExportPrincipal> principalList;
}
