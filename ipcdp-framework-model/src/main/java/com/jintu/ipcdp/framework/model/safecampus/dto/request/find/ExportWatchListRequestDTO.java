package com.jintu.ipcdp.framework.model.safecampus.dto.request.find;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/13 17:58
 * @Version 1.0
 */
@Data
public class ExportWatchListRequestDTO {

    /**
     * 单位id 单位id
     */
    @NotNull(message = "单位ID不能为空")
    @ApiModelProperty("单位id")
    private Long unitInfoId;

    /**
     * 工作日期 开始日期 yyyy-MM-dd
     */
    @ApiModelProperty("忽略此字段 ")
    private LocalDate beginDate;

    /**
     * 工作日期 结束日期 yyyy-MM-dd
     * #@JsonDeserialize(using = LocalDateDeserializer.class)
     */
    @ApiModelProperty("忽略此字段")
    private LocalDate endDate;

}
