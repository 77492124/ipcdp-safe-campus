package com.jintu.safecampus.common.aop;

import lombok.Data;

import java.util.Date;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2019/12/30 18:03
 * @Version 1.0
 */
@Data
public class SysLog {
    private Integer id;
    private String username;
    private String operation;
    private Integer time;
    private String method;
    private String params;
    private String ip;
    private Date createTime;

}
