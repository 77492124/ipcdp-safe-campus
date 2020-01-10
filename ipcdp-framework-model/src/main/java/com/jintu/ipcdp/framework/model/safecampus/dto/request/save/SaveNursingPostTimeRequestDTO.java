package com.jintu.ipcdp.framework.model.safecampus.dto.request.save;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.jintu.ipcdp.framework.util.LocalTimeDeserializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/10 17:02
 * @Version 1.0
 */
@Data
public class SaveNursingPostTimeRequestDTO {

    /**
     * 单位id 单位id
     */
    @NotNull(message = "单位id不能为空")
    @ApiModelProperty("单位id")
    private Long unitInfoId;

    /**
     * 时间名称 时间名称
     */
    @NotBlank(message = "时间名称不能为空")
    @ApiModelProperty("时间名称")
    private String timeName;

    /**
     * 开始时间 开始时间
     */
    @NotNull(message = "开始时间不能为空")
    @ApiModelProperty("开始时间 HH:mm:ss")
    @JsonDeserialize(using = LocalTimeDeserializer.class)
    private LocalTime startingTime;

    /**
     * 结束时间 结束时间
     */
    @NotNull(message = "结束时间不能为空")
    @ApiModelProperty("结束时间 HH:mm:ss")
    @JsonDeserialize(using = LocalTimeDeserializer.class)
    private LocalTime endTime;

    /**
     * 创建人id 创建人id（员工id）
     */
    @NotNull(message = "登录用户id不能为空")
    @ApiModelProperty("当前登录用户id")
    private Long createdId;
}
