package com.jintu.safecampus.dal.model;

import com.baomidou.mybatisplus.annotation.TableName;
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
 * 护学岗人员上班记录 
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("nursing_post_person_work_record")
public class NursingPostPersonWorkRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识ID 唯一标识ID
     */
    @TableId("id")
    private Long id;

    /**
     * 护学岗人员Id 护学岗人员Id
     */
    @TableField("nursing_post_person_id")
    private Long nursingPostPersonId;

    /**
     * 记录类型 0：下班；1：上班；2：脱岗；
     */
    @TableField("record_type")
    private Integer recordType;

    /**
     * 值班表id 值班表id
     */
    @TableField("watch_list_id")
    private Long watchListId;

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
