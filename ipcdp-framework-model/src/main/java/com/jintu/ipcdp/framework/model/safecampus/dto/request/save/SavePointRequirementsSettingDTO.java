package com.jintu.ipcdp.framework.model.safecampus.dto.request.save;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/13 9:32
 * @Version 1.0
 */
@Data
public class SavePointRequirementsSettingDTO {
    /**
     * 人员类型 人员类型（0：公安；1：交警；2：城管；3：特警；4：保安）
     */
    @NotNull(message = "人员类型不能为空")
    @ApiModelProperty("人员类型（0：公安；1：交警；2：城管；3：特警；4：保安）")
    private Integer personType;

    /**
     * 人员数量 人员数量
     */
    @NotNull(message = "人员数量不能为空")
    @ApiModelProperty("人员数量")
    private Integer numberOfPersonnel;

    /**
     * 区域半径 区域半径/米
     */
    @NotNull(message = "区域半径不能为空")
    @ApiModelProperty("区域半径/米")
    private BigDecimal areaRadius;
}
