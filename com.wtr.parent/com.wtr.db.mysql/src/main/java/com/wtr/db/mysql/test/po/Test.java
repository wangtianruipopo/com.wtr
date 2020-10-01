package com.wtr.db.mysql.test.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("test")
public class Test {
	@TableId(value = "id", type = IdType.ASSIGN_UUID)
	private String id;
	private String name;
}
