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
 * @Date 2020/1/13 13:59
 * @Version 1.0
 */
@Data
public class SaveShiftSettingRequestDTO {
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
     * 单位点位id 单位点位id
     */
    @NotNull(message = "点位id不能为空")
    @ApiModelProperty("点位id")
    private Long unitPointId;

    /**
     * 点位需求设置id 点位需求设置id
     */
    @NotNull(message = "点位需求设置id不能为空")
    @ApiModelProperty("点位需求设置id")
    private Long pointRequirementsSettingId;

    /**
     * 工作日期 工作日期
     */
    @NotNull(message = "工作日期不能为空")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @ApiModelProperty("工作日期 yyyy-MM-dd")
    private LocalDate workingDate;


    /**
     * 护学岗人员id 护学岗人员id
     */
    @NotEmpty(message = "护学岗人员id集合不能为空")
    @ApiModelProperty("护学岗人员id集合")
    private List<Long> nursingPostPersonIds;

    /**
     * 创建人id 创建人id（员工id）
     */
    @NotNull(message = "创建人id不能为空")
    @ApiModelProperty("创建人id(当前登录用户id)")
    private Long createdId;
}
