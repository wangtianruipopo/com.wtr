package com.wtr.cultivate.entity.master.test;

import com.baomidou.mybatisplus.annotation.TableName;
import com.wtr.common.base.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@TableName("abc")
public class Abc extends BaseEntity {

	private String name;
	
}
