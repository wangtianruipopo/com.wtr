package com.wtr.db.mysql.model;

import lombok.Data;

@Data
public class DataSourceOperationProperties {
	private Integer initialSize;
	private Integer minIdle;
	private Integer maxActive;
	private Integer maxWait;
	private Integer timeBetweenEvictionRunsMillis;
	private Integer minEvictableIdleTimeMillis;
	private String validationQuery;
	private Boolean testWhileIdle;
	private Boolean testOnBorrow;
	private Boolean testOnReturn;
	private Boolean poolPreparedStatements;
	private Integer maxPoolPreparedStatementPerConnectionSize;
	private String filters;
	private String loginUsername;
	private String loginPassword;
}
