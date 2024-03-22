package com.project.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
create table login(
    id varchar2 (30) primary key,
    password varchar2 (30),
    name varchar2 (30),
    email varchar2 (50),
    phone char (13)
);
*/

@Setter
@Getter
@ToString
public class UserVO {
	private String id;
	private String pass;
	private String name;
	private String email;
	private String phone;
}
