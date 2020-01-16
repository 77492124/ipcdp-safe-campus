package com.jintu.ipcdp.framework.model.safecampus.dto.response.find;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/15 14:39
 * @Version 1.0
 */
@Data
public class FindShiftSettingBaseResponseDTO {
    /**
     * 点位值班日期
     */
    @ApiModelProperty("点位值班日期（日历回显）")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    List<LocalDate> pointDutyDates;

    /**
     * 详细列表
     */
    @ApiModelProperty("详细列表")
    private List<FindShiftSettingResponseDTO> settingResponseList;
}
