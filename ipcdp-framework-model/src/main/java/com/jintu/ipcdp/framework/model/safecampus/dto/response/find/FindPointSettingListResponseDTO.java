package com.jintu.ipcdp.framework.model.safecampus.dto.response.find;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/13 9:06
 * @Version 1.0
 */
@Data
public class FindPointSettingListResponseDTO {

    /**
     * 唯一标识ID 唯一标识ID
     */
    @ApiModelProperty("唯一标识ID")
    private Long id;

    /**
     * 点位ID
     */
    @ApiModelProperty("点位ID")
    private String unitPointId;

    /**
     * 点位名称 点位名称
     */
    @ApiModelProperty("点位名称")
    private String pointName;

    /**
     * 人员类型 人员类型（0：公安；1：交警；2：城管；3：特警；4：保安）
     */
    @ApiModelProperty("人员类型（0：公安；1：交警；2：城管；3：特警；4：保安）")
    private Integer personType;

    /**
     * 人员数量 人员数量
     */
    @ApiModelProperty("人员数量")
    private Integer numberOfPersonnel;

    /**
     * 区域半径 区域半径/米
     */
    @ApiModelProperty("区域半径/米")
    private BigDecimal areaRadius;
}
