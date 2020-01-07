package com.jintu.ipcdp.framework.model.safecampus.dto.request.find;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.jintu.ipcdp.framework.model.BaseRequest;
import com.jintu.ipcdp.framework.util.LocalDateDeserializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/7 16:08
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class FindAppVersionListRequestDTO extends BaseRequest {
    /**
     * 版本编号 版本编号
     */
    @ApiModelProperty("版本编号")
    private String versionNumber;

    /**
     * 发布日期
     */
    @ApiModelProperty("发布日期 yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate createdTime;
}
