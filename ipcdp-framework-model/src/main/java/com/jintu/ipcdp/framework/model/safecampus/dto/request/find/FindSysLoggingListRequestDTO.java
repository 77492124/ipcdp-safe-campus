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
 * @Date 2020/1/7 16:48
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class FindSysLoggingListRequestDTO extends BaseRequest {

    /**
     * 操作类型 1、添加 2、修改 3、删除 4、查询 5：其他操作
     */
    @ApiModelProperty("操作类型 1、添加 2、修改 3、删除 4、查询 5：其他操作")
    private Integer actionType;

    /**
     * 操作来源 用户来源 1:管理员端；2：学校端；3：平安办端
     */
    @ApiModelProperty("操作来源 1:管理员端；2：学校端；3：平安办端")
    private Integer operationSource;

    /**
     * 是否运行错误 是否运行错误；0：正常；1：出错；
     */
    @ApiModelProperty("是否运行错误；0：正常；1：出错；")
    private Boolean errorMark;

    /**
     * 创建时间 创建时间
     */
    @ApiModelProperty("发布日期 yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate createdTime;
}
