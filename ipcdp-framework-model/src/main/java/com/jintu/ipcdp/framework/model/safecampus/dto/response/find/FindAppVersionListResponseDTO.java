package com.jintu.ipcdp.framework.model.safecampus.dto.response.find;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/7 16:10
 * @Version 1.0
 */
@Data
public class FindAppVersionListResponseDTO {

    /**
     * 唯一标识ID 唯一标识ID
     */
    @ApiModelProperty("版本id")
    private Long id;

    /**
     * 版本文件 版本文件
     */
    @ApiModelProperty("版本文件")
    private String versionFile;

    /**
     * 版本编号 版本编号
     */
    @ApiModelProperty("版本编号")
    private String versionNumber;

    /**
     * 版本说明 版本说明
     */
    @ApiModelProperty("版本说明")
    private String releaseNotes;

    /**
     * 创建时间 创建时间
     */
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime createdTime;

}
