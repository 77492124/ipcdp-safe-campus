package com.jintu.ipcdp.framework.model.safecampus.dto.request.find;

import com.jintu.ipcdp.framework.model.BaseRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Classname
 * @Description 护学岗脱岗记录入参
 * @Date 2020/1/17 10:19
 * @Created by lyx
 */
@Data
public class NursingPostPersonUnWorkRecordRequestDTO extends BaseRequest {

    @NotNull(message = "护学岗人员id不能为空")
    @ApiModelProperty("护学岗人员id")
    private Long nursingPostPersonId;
}
