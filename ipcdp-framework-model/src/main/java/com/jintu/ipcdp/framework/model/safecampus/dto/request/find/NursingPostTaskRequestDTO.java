package com.jintu.ipcdp.framework.model.safecampus.dto.request.find;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.jintu.ipcdp.framework.util.LocalDateDeserializer;
import com.jintu.ipcdp.framework.util.LocalDateTimeDeserializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Classname
 * @Description 护学岗任务入参
 * @Date 2020/1/16 16:03
 * @Created by lyx
 */
@Data
public class NursingPostTaskRequestDTO {

    @NotNull(message = "护学岗人员id不能为空")
    @ApiModelProperty("护学岗人员id")
    private Long nursingPostPersonId;

    @NotNull(message = "单位id不能为空")
    @ApiModelProperty("单位id")
    private Long unitInfoId;

    @NotNull(message = "工作日期不能为空")
    @ApiModelProperty("工作日期 yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate workingDate;
}
