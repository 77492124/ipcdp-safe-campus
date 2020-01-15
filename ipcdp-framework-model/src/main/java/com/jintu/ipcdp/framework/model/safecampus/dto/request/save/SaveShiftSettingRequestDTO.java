package com.jintu.ipcdp.framework.model.safecampus.dto.request.save;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
     * 护学岗人员id 护学岗人员id
     */
    @NotEmpty(message = "护学岗人员id集合不能为空")
    @ApiModelProperty("护学岗人员id集合")
    private List<Long> nursingPostPersonIds;

}
