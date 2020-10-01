package com.wtr.db.mysql.model;

import lombok.Data;

@Data
public class DataSourceConnectionProperties {
	private String url;
	private String username;
	private String password;
}
