package com.jintu.safecampus.dal.model;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 值班表 值班表信息
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("watch_list")
public class WatchList implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识ID 唯一标识ID
     */
    @TableId("id")
    private Long id;

    /**
     * 单位id 单位id
     */
    @TableField("unit_info_id")
    private Long unitInfoId;

    /**
     * 护学岗时间id 护学岗时间id
     */
    @TableField("nursing_post_time_id")
    private Long nursingPostTimeId;

    /**
     * 单位点位id 单位点位id
     */
    @TableField("unit_point_id")
    private Long unitPointId;

    /**
     * 点位需求设置id 点位需求设置id
     */
    @TableField("point_requirements_setting_id")
    private Long pointRequirementsSettingId;

    /**
     * 工作日期 工作日期
     */
    @TableField("working_date")
    private LocalDate workingDate;

    /**
     * 创建人id 创建人id（员工id）
     */
    @TableField("created_id")
    private Long createdId;

    /**
     * 是否删除 0：未删除；1：已删除
     */
    @TableField(value = "deleted", fill = FieldFill.INSERT)
    @TableLogic
    private Integer deleted;

    /**
     * 创建时间 创建时间
     */
    @TableField(value = "created_time", fill = FieldFill.INSERT)
    private LocalDateTime createdTime;

    /**
     * 更新时间 更新时间
     */
    @TableField(value = "updated_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedTime;


}
