package com.jintu.ipcdp.framework.model.datadictionary;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description  
 * @Author  Hunter
 * @Date 2019-04-02 
 */

@Setter
@Getter
@ToString
@Entity
@Table( name ="standard" )
public class Standard  implements Serializable {

	private static final long serialVersionUID =  1404596371684126667L;

	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   	@Column(name = "standard_id" )
	private Integer standardId;

	/**
	 * 编码
	 */
   	@Column(name = "standard_code" )
	private String standardCode;

   	@Column(name = "standard_code1" )
	private String standardCode1;

	/**
	 * 名称
	 */
	@Column(name = "standard_content" )
	private String standardContent;

   	@Column(name = "standard_content1" )
	private String standardContent1;

	/**
	 * 数据种类
	 */
	@Column(name = "standard_flag" )
	private Integer standardFlag;

	/**
	 * 父ID
	 */
   	@Column(name = "standard_pid" )
	private Integer standardPid;

   	@Column(name = "standard_text" )
	private String standardText;

}
