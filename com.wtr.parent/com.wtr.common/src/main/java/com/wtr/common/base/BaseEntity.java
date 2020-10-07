package com.wtr.common.base;

import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Getter;
import lombok.Setter;

public class BaseEntity {

	@Getter
	@Setter
	@TableId(value = "id")
	protected String id;
	
}
