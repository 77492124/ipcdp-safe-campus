package com.jintu.ipcdp.framework.model.safecampus.dto.request.find;

import com.jintu.ipcdp.framework.model.BaseRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/13 17:17
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class FindWatchListRequestDTO extends BaseRequest {

    /**
     * 单位id 单位id
     */
    @NotNull(message = "单位ID不能为空")
    @ApiModelProperty("单位id")
    private Long unitInfoId;

    /**
     * 工作日期 开始日期
     */
    @ApiModelProperty("开始日期 yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate beginDate;

    /**
     * 工作日期 结束日期
     */
    @ApiModelProperty("结束日期 yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;


}
