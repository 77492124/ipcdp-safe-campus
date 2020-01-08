package com.jintu.ipcdp.framework.model.safecampus.dto.response.find;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/8 10:08
 * @Version 1.0
 */
@Data
public class GetUploadTokenResponseDTO {

    /**
     * token
     */
    @ApiModelProperty("token")
    private String token;

    /**
     * 文件名称
     */
    @ApiModelProperty("文件名称")
    private String fileName;




}
