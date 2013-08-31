-- vaps 계정 생성 , sys나 system계정에서 수행
CREATE USER vaps IDENTIFIED BY 1111
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp;
-- 권한 부여 ( 뷰 생성, 시노민 etc)
GRANT connect, resource, create synonym, create view to vaps; 

-- vaps 계정에 접속해서 DB구축

-- MEMBERS(회원) 테이블 정의
CREATE TABLE MEMBERS(
  M_ID NVARCHAR2(20),
  M_NICK NVARCHAR2(20),
  M_PWD NVARCHAR2(20) NOT NULL, --암호화(DB암호화)
  M_PHONE NVARCHAR2(20),
  M_ADDR NVARCHAR2(20),
  M_POINT NUMBER(20) DEFAULT '0',
  M_AUTH NUMBER DEFAULT '0', -- 일반 사용자 0 관리자 1로 권한 구분
  PRIMARY KEY(M_ID,M_NICK) -- PK지정
);
 -- MEMBERS를 M으로 줄여서(별명)
 CREATE OR REPLACE SYNONYM M FOR MEMBERS;
