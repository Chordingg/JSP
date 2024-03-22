package com.pro.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
CREATE TABLE users (
    num NUMBER PRIMARY KEY,
    id VARCHAR2(50) UNIQUE,
    username VARCHAR2(50),
    email VARCHAR2(100),
    password VARCHAR2(100),
    registration_date DATE,
    is_admin CHAR(1) DEFAULT 'N' CHECK (is_admin IN ('Y', 'N'))
);
*/
@Setter
@Getter
@ToString 
public class UsersVO {
	private Integer num;
	private String id;
	private String username;
	private String email;
	private String pass;
	private Date registration_date;
	private String is_admin;
}
