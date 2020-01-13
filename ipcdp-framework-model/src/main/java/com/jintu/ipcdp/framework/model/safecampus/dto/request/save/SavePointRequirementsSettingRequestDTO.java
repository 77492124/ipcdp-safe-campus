package com.jintu.ipcdp.framework.model.safecampus.dto.request.save;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/13 9:25
 * @Version 1.0
 */
@Data
public class SavePointRequirementsSettingRequestDTO {

    /**
     * 护学岗时间id 护学岗时间id
     */
    @NotNull(message = "护学岗时间id不能为空")
    @ApiModelProperty("护学岗时间id")
    private Long nursingPostTimeId;

    /**
     * 单位点位id 单位点位id
     */
    @NotNull(message = "单位点位id不能为空")
    @ApiModelProperty("单位点位id")
    private Long unitPointId;


    /**
     * 创建人id 创建人id（员工id）
     */
    @NotNull(message = "登录用户id不能为空")
    @ApiModelProperty("当前登录用户id")
    private Long createdId;

    /**
     * 设置集合
     */
    @NotEmpty(message = "设置集合不能为空")
    @ApiModelProperty("设置集合")
    List<SavePointRequirementsSettingDTO> settings;
}
