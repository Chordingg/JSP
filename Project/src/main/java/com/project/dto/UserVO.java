package com.project.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
CREATE TABLE member(
admin NUMBER (1) PRIMARY KEY,
name VARCHAR2(5),
id VARCHAR2(10),
pass VARCHAR2(20),
phone CHAR(13),
email VARCHAR2(30));
*/

@Setter
@Getter
@ToString
public class UserVO {
	private int admin;
	private String name;
	private String id;
	private String pass;
	private String phone;
	private String email;

}
