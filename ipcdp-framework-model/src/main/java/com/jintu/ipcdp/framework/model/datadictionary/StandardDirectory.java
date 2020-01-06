package com.jintu.ipcdp.framework.model.datadictionary;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description  
 * @Author  Hunter
 * @Date 2019-04-02 
 */

@ToString
@Entity
@Data
@Table( name ="standard_directory" )
public class StandardDirectory  implements Serializable {

	private static final long serialVersionUID =  6414410955977330950L;

	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   	@Column(name = "standard_flag" )
	private Integer standardFlag;

	/**
	 * 数据种类
	 */
   	@Column(name = "standard_name" )
	private String standardName;

}
