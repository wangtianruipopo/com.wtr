package com.wtr.cultivate.entity.master.user;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import com.wtr.cultivate.entity.base.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@TableName("user")
public class User extends BaseEntity {
	private static final long serialVersionUID = -8955300761914873573L;
	protected String username;
	protected String password;
	protected String nickname;
	protected Date createDate;
	protected Date lastLoginTime;
	protected String lastLoginAdress;
	protected boolean accountNonExpired;
	protected boolean accountNonLocked;
	protected boolean credentialsNonExpired;
	protected boolean enabled;
}
