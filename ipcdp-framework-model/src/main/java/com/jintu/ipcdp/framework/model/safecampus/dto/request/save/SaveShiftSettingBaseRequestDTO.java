package com.jintu.ipcdp.framework.model.safecampus.dto.request.save;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.jintu.ipcdp.framework.util.LocalDateDeserializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/14 11:34
 * @Version 1.0
 */
@Data
public class SaveShiftSettingBaseRequestDTO {

    /**
     * 单位id 单位id
     */
    @NotNull(message = "单位id不能为空")
    @ApiModelProperty("单位id")
    private Long unitInfoId;

    /**
     * 护学岗时间id 护学岗时间id
     */
    @NotNull(message = "护学岗时间id不能为空")
    @ApiModelProperty("护学岗时间id")
    private Long nursingPostTimeId;

    /**
     * 工作日期 工作日期
     */
    @NotEmpty(message = "工作日期不能为空")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @ApiModelProperty("工作日期集合 yyyy-MM-dd")
    private List<LocalDate> workingDates;

    /**
     * 创建人id 创建人id（员工id）
     */
    @NotNull(message = "创建人id不能为空")
    @ApiModelProperty("创建人id(当前登录用户id)")
    private Long createdId;

    /**
     * 点位需求集合
     */
    @NotEmpty(message = "点位需求集合不能为空")
    @ApiModelProperty("点位需求集合")
    private List<SaveShiftSettingRequestDTO>  shiftSettings;
}
