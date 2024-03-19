회원가입 디비
CREATE TABLE users (
    num NUMBER PRIMARY KEY,
    id VARCHAR2(50) UNIQUE,
    username VARCHAR2(50),
    email VARCHAR2(100),
    password VARCHAR2(100),
    registration_date DATE,
    is_admin CHAR(1) DEFAULT 'N' CHECK (is_admin IN ('Y', 'N'))
);

회원가입 시퀀스
CREATE SEQUENCE users_seq START WITH 1 INCREMENT BY 1;

스케줄 디비
CREATE TABLE schedule (
    num NUMBER PRIMARY KEY,
    id VARCHAR2(50),
    title VARCHAR2(50),
    content VARCHAR2(500),
    start1 DATE,
    end1 DATE,
    color VARCHAR2(50),
    writer VARCHAR2(50),
    groupnum NUMBER(10),
    CONSTRAINT fk_users FOREIGN KEY (id) REFERENCES users(id) //이거는 회원가입테이블과 연동
);

스케즐 시퀀스 (num)
CREATE SEQUENCE schedule_seq START WITH 1 INCREMENT BY 1;

commit;