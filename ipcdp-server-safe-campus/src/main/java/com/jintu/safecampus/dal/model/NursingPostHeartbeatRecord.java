package com.jintu.safecampus.dal.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 *  护学岗人员心跳记录
 * </p>
 *
 * @author 常培兵
 * @since 2020-01-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("nursing_post_heartbeat_record")
public class NursingPostHeartbeatRecord implements Serializable {

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
     * 经度 经度
     */
    @TableField("longitude")
    private BigDecimal longitude;

    /**
     * 纬度 纬度
     */
    @TableField("latitude")
    private BigDecimal latitude;

    /**
     * 值班表id 值班表id
     */
    @TableField("watch_list_id")
    private Long watchListId;

    /**
     * 距离（米） 距离（米），距上班点位距离
     */
    @TableField("distance")
    private BigDecimal distance;

    /**
     * 是否脱岗 0：否；1：是；
     */
    @TableField("out_of_post_mark")
    private Boolean outOfPostMark;

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
