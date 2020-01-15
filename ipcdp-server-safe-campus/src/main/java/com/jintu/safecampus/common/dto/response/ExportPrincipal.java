package com.jintu.safecampus.common.dto.response;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author Parker
 * @Description: 描述
 * @Date 2020/1/14 16:46
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
public class ExportPrincipal {
    /**
     * 唯一标识ID 唯一标识ID
     */
    private Long id;

    /**
     * 人员姓名 人员姓名
     */
    @Excel(name = "人员姓名", width=15)
    private String personName;

    /**
     * 人员类型 人员类型（0：公安；1：交警；2：城管；3：特警；4：保安）
     */
    @Excel(name = "人员类型", replace = { "公安_0", "交警_1", "城管_2", "特警_3", "保安_4" }, width=15)
    private Integer personType;
}
