package com.jintu.ipcdp.framework.model.datadictionary;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description
 * @Author Hunter
 * @Date 2019-04-02
 */

@Setter
@Getter
@ToString
@Entity
@Table(name = "dprocityregion")
public class Dprocityregion implements Serializable {

    private static final long serialVersionUID = 1798977216335928173L;

    /**
     * DID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "d_id")
    private Long dId;

    /**
     * 省市区名称
     */
    @Column(name = "d_name")
    private String dName;

    /**
     * 上级ID
     */
    @Column(name = "d_parentid")
    private Long dParentid;

    /**
     * 简称
     */
    @Column(name = "d_simple_name")
    private String dSimpleName;

    /**
     * 级别:0,中国；1，省分；2，市；3，区、县
     */
    @Column(name = "d_level")
    private Integer dLevel;

    /**
     * 城市代码
     */
    @Column(name = "d_city_code")
    private String dCityCode;

    /**
     * 邮编
     */
    @Column(name = "d_post_code")
    private String dPostCode;

    /**
     * 经度
     */
    @Column(name = "d_lng")
    private String dLng;

    /**
     * 纬度
     */
    @Column(name = "d_lat")
    private String dLat;

    /**
     * 拼音
     */
    @Column(name = "d_pinyin")
    private String dPinyin;

    @Column(name = "d_status")
    private String dStatus;

}
