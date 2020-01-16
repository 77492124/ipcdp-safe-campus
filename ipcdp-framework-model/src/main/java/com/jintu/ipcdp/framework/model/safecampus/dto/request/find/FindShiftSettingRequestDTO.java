package com.jintu.ipcdp.framework.model.safecampus.dto.request.find;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/15 14:46
 * @Version 1.0
 */
@Data
public class FindShiftSettingRequestDTO {
    /**
     * 护学岗时间id
     */
    @NotNull(message = "护学岗时间id不能为空")
    @ApiModelProperty("护学岗时间id")
    private Long nursingPostTimeId;

    /**
     * 工作日期 开始日期
     */
    @ApiModelProperty("开始日期(日历显示使用) yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate beginDate;

    /**
     * 工作日期 结束日期
     */
    @ApiModelProperty("结束日期(日历显示使用) yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
}
