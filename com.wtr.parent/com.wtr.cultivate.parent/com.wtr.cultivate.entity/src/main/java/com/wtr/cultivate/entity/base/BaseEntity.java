package com.wtr.cultivate.entity.base;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Getter;
import lombok.Setter;

public class BaseEntity implements Serializable{
	private static final long serialVersionUID = 5787362068116292917L;
	@Getter
	@Setter
	@TableId(value = "id")
	protected String id;
	
}
