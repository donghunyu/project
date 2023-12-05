
DROP TABLE BACR10110;



DROP TABLE BACR10100;



DROP TABLE BACR10020;



DROP TABLE BACR10011;



DROP TABLE BACR10010;



CREATE TABLE BACR10010
(
	PVL_ID               VARCHAR(5) NOT NULL,
	PVL_NM               VARCHAR(100) NULL,
	ZIP_NUM              VARCHAR(5) NULL,
	ADDR                 VARCHAR(200) NULL,
	DTL_ADDR             VARCHAR(200) NULL,
	PVL_GRP_CD           CHAR(18) NULL,
	EFF_STA_DT           VARCHAR(8) NULL,
	EFF_END_DT           VARCHAR(8) NULL,
	DEL_YN               VARCHAR(1) NULL,
	REG_USER_NUM         VARCHAR(10) NULL,
	REG_IP               VARCHAR(20) NULL,
	REG_DTM              VARCHAR(14) NULL,
	UPD_USER_NUM         VARCHAR(10) NULL,
	UPD_IP               VARCHAR(20) NULL,
	UPD_DTM              VARCHAR(14) NULL
);



CREATE UNIQUE INDEX BACR10010_PK ON BACR10010
(
	PVL_ID
);



ALTER TABLE BACR10010
ADD PRIMARY KEY (PVL_ID);



CREATE TABLE BACR10011
(
	PVL_ID               VARCHAR(5) NOT NULL,
	GRP_SER_NUM          NUMERIC(3) NOT NULL,
	GRP_NM               VARCHAR(100) NULL,
	EFF_STA_DT           VARCHAR(8) NULL,
	EFF_END_DT           VARCHAR(8) NULL,
	DEL_YN               VARCHAR(1) NULL,
	REG_USER_NUM         VARCHAR(10) NULL,
	REG_IP               VARCHAR(20) NULL,
	REG_DTM              VARCHAR(14) NULL,
	UPD_USER_NUM         VARCHAR(10) NULL,
	UPD_IP               VARCHAR(20) NULL,
	UPD_DTM              VARCHAR(14) NULL
);



CREATE UNIQUE INDEX BACR10011_PK ON BACR10011
(
	PVL_ID,
	GRP_SER_NUM
);



ALTER TABLE BACR10011
ADD PRIMARY KEY (PVL_ID,GRP_SER_NUM);



CREATE TABLE BACR10020
(
	PVL_ID               VARCHAR(5) NOT NULL,
	SER_NUM              NUMERIC(3) NOT NULL,
	TG_NM                VARCHAR(100) NULL,
	EFF_STA_DT           VARCHAR(8) NULL,
	EFF_END_DT           VARCHAR(8) NULL,
	DEL_YN               VARCHAR(1) NULL,
	REG_USER_NUM         VARCHAR(10) NULL,
	REG_IP               VARCHAR(20) NULL,
	REG_DTM              VARCHAR(14) NULL,
	UPD_USER_NUM         VARCHAR(10) NULL,
	UPD_IP               VARCHAR(20) NULL,
	UPD_DTM              VARCHAR(14) NULL
);



CREATE UNIQUE INDEX BACR10020_PK ON BACR10020
(
	PVL_ID,
	SER_NUM
);



ALTER TABLE BACR10020
ADD PRIMARY KEY (PVL_ID,SER_NUM);



CREATE TABLE BACR10100
(
	PVL_ID               VARCHAR(5) NOT NULL,
	MB_NUM               VARCHAR(10) NOT NULL,
	MB_ID                VARCHAR(100) NULL,
	MB_NM                VARCHAR(40) NULL,
	MB_PWD               VARCHAR(20) NULL,
	BTD                  VARCHAR(8) NULL,
	MBL_NUM              VARCHAR(20) NULL,
	MAIL_ADDR            VARCHAR(200) NULL,
	GD_CD                VARCHAR(5) NULL,
	EFF_STA_DT           VARCHAR(8) NULL,
	EFF_END_DT           VARCHAR(8) NULL,
	DEL_YN               VARCHAR(1) NULL,
	REG_USER_NUM         VARCHAR(10) NULL,
	REG_IP               VARCHAR(20) NULL,
	REG_DTM              VARCHAR(14) NULL,
	UPD_USER_NUM         VARCHAR(10) NULL,
	UPD_IP               VARCHAR(20) NULL,
	UPD_DTM              VARCHAR(14) NULL
);



CREATE UNIQUE INDEX BACR10100_PK ON BACR10100
(
	PVL_ID,
	MB_NUM
);



ALTER TABLE BACR10100
ADD PRIMARY KEY (PVL_ID,MB_NUM);



CREATE TABLE BACR10110
(
	PVL_ID               VARCHAR(5) NOT NULL,
	MB_NUM               VARCHAR(10) NOT NULL,
	SER_NUM              NUMERIC(3) NOT NULL,
	EFF_STA_DT           VARCHAR(8) NULL,
	EFF_END_DT           VARCHAR(8) NULL,
	DEL_YN               VARCHAR(1) NULL,
	REG_USER_NUM         VARCHAR(10) NULL,
	REG_IP               VARCHAR(20) NULL,
	REG_DTM              VARCHAR(14) NULL,
	UPD_USER_NUM         VARCHAR(10) NULL,
	UPD_IP               VARCHAR(20) NULL,
	UPD_DTM              VARCHAR(14) NULL
);



CREATE UNIQUE INDEX BACR10110_PK ON BACR10110
(
	PVL_ID,
	MB_NUM,
	SER_NUM
);



ALTER TABLE BACR10110
ADD PRIMARY KEY (PVL_ID,MB_NUM,SER_NUM);



ALERT TABLE BACR10010 COMMENT = '기본정보_정';

    ALTER TABLE BACR10010 MODIFY COLUMN PVL_ID VARCHAR(5) NOT NULL COMMENT '정 ID';
    ALTER TABLE BACR10010 MODIFY COLUMN PVL_NM VARCHAR(100) NULL COMMENT '정 명';
    ALTER TABLE BACR10010 MODIFY COLUMN ZIP_NUM VARCHAR(5) NULL COMMENT '우편번호';
    ALTER TABLE BACR10010 MODIFY COLUMN ADDR VARCHAR(200) NULL COMMENT '주소';
    ALTER TABLE BACR10010 MODIFY COLUMN DTL_ADDR VARCHAR(200) NULL COMMENT '상세 주소';
    ALTER TABLE BACR10010 MODIFY COLUMN PVL_GRP_CD CHAR(18) NULL COMMENT '정 그룹 코드';
    ALTER TABLE BACR10010 MODIFY COLUMN EFF_STA_DT VARCHAR(8) NULL COMMENT '유효 시작 일자';
    ALTER TABLE BACR10010 MODIFY COLUMN EFF_END_DT VARCHAR(8) NULL COMMENT '유효 종료 일자';
    ALTER TABLE BACR10010 MODIFY COLUMN DEL_YN VARCHAR(1) NULL COMMENT '삭제 여부';
    ALTER TABLE BACR10010 MODIFY COLUMN REG_USER_NUM VARCHAR(10) NULL COMMENT '등록 사용자 번호';
    ALTER TABLE BACR10010 MODIFY COLUMN REG_IP VARCHAR(20) NULL COMMENT '등록 IP';
    ALTER TABLE BACR10010 MODIFY COLUMN REG_DTM VARCHAR(14) NULL COMMENT '등록 일시';
    ALTER TABLE BACR10010 MODIFY COLUMN UPD_USER_NUM VARCHAR(10) NULL COMMENT '수정 사용자 번호';
    ALTER TABLE BACR10010 MODIFY COLUMN UPD_IP VARCHAR(20) NULL COMMENT '수정 IP';
    ALTER TABLE BACR10010 MODIFY COLUMN UPD_DTM VARCHAR(14) NULL COMMENT '수정 일시';
    
ALERT TABLE BACR10011 COMMENT = '기본정보 그룹';

    ALTER TABLE BACR10011 MODIFY COLUMN PVL_ID VARCHAR(5) NOT NULL COMMENT '정 ID';
    ALTER TABLE BACR10011 MODIFY COLUMN GRP_SER_NUM NUMERIC(3) NOT NULL COMMENT '그룹 일련번호';
    ALTER TABLE BACR10011 MODIFY COLUMN GRP_NM VARCHAR(100) NULL COMMENT '그룹 명';
    ALTER TABLE BACR10011 MODIFY COLUMN EFF_STA_DT VARCHAR(8) NULL COMMENT '유효 시작 일자';
    ALTER TABLE BACR10011 MODIFY COLUMN EFF_END_DT VARCHAR(8) NULL COMMENT '유효 종료 일자';
    ALTER TABLE BACR10011 MODIFY COLUMN DEL_YN VARCHAR(1) NULL COMMENT '삭제 여부';
    ALTER TABLE BACR10011 MODIFY COLUMN REG_USER_NUM VARCHAR(10) NULL COMMENT '등록 사용자 번호';
    ALTER TABLE BACR10011 MODIFY COLUMN REG_IP VARCHAR(20) NULL COMMENT '등록 IP';
    ALTER TABLE BACR10011 MODIFY COLUMN REG_DTM VARCHAR(14) NULL COMMENT '등록 일시';
    ALTER TABLE BACR10011 MODIFY COLUMN UPD_USER_NUM VARCHAR(10) NULL COMMENT '수정 사용자 번호';
    ALTER TABLE BACR10011 MODIFY COLUMN UPD_IP VARCHAR(20) NULL COMMENT '수정 IP';
    ALTER TABLE BACR10011 MODIFY COLUMN UPD_DTM VARCHAR(14) NULL COMMENT '수정 일시';
    
ALERT TABLE BACR10020 COMMENT = '기본정보 과녁';

    ALTER TABLE BACR10020 MODIFY COLUMN PVL_ID VARCHAR(5) NOT NULL COMMENT '정 ID';
    ALTER TABLE BACR10020 MODIFY COLUMN SER_NUM NUMERIC(3) NOT NULL COMMENT '일련번호';
    ALTER TABLE BACR10020 MODIFY COLUMN TG_NM VARCHAR(100) NULL COMMENT '과녁 명';
    ALTER TABLE BACR10020 MODIFY COLUMN EFF_STA_DT VARCHAR(8) NULL COMMENT '유효 시작 일자';
    ALTER TABLE BACR10020 MODIFY COLUMN EFF_END_DT VARCHAR(8) NULL COMMENT '유효 종료 일자';
    ALTER TABLE BACR10020 MODIFY COLUMN DEL_YN VARCHAR(1) NULL COMMENT '삭제 여부';
    ALTER TABLE BACR10020 MODIFY COLUMN REG_USER_NUM VARCHAR(10) NULL COMMENT '등록 사용자 번호';
    ALTER TABLE BACR10020 MODIFY COLUMN REG_IP VARCHAR(20) NULL COMMENT '등록 IP';
    ALTER TABLE BACR10020 MODIFY COLUMN REG_DTM VARCHAR(14) NULL COMMENT '등록 일시';
    ALTER TABLE BACR10020 MODIFY COLUMN UPD_USER_NUM VARCHAR(10) NULL COMMENT '수정 사용자 번호';
    ALTER TABLE BACR10020 MODIFY COLUMN UPD_IP VARCHAR(20) NULL COMMENT '수정 IP';
    ALTER TABLE BACR10020 MODIFY COLUMN UPD_DTM VARCHAR(14) NULL COMMENT '수정 일시';
    
ALERT TABLE BACR10100 COMMENT = '기본정보_회원';

    ALTER TABLE BACR10100 MODIFY COLUMN PVL_ID VARCHAR(5) NOT NULL COMMENT '정 ID';
    ALTER TABLE BACR10100 MODIFY COLUMN MB_NUM VARCHAR(10) NOT NULL COMMENT '회원 번호';
    ALTER TABLE BACR10100 MODIFY COLUMN MB_ID VARCHAR(100) NULL COMMENT '회원 ID';
    ALTER TABLE BACR10100 MODIFY COLUMN MB_NM VARCHAR(40) NULL COMMENT '회원 명';
    ALTER TABLE BACR10100 MODIFY COLUMN MB_PWD VARCHAR(20) NULL COMMENT '회원 비밀번호';
    ALTER TABLE BACR10100 MODIFY COLUMN BTD VARCHAR(8) NULL COMMENT '생년월일';
    ALTER TABLE BACR10100 MODIFY COLUMN MBL_NUM VARCHAR(20) NULL COMMENT '모바일 번호';
    ALTER TABLE BACR10100 MODIFY COLUMN MAIL_ADDR VARCHAR(200) NULL COMMENT '메일 주소';
    ALTER TABLE BACR10100 MODIFY COLUMN GD_CD VARCHAR(5) NULL COMMENT '성별 코드';
    ALTER TABLE BACR10100 MODIFY COLUMN EFF_STA_DT VARCHAR(8) NULL COMMENT '유효 시작 일자';
    ALTER TABLE BACR10100 MODIFY COLUMN EFF_END_DT VARCHAR(8) NULL COMMENT '유효 종료 일자';
    ALTER TABLE BACR10100 MODIFY COLUMN DEL_YN VARCHAR(1) NULL COMMENT '삭제 여부';
    ALTER TABLE BACR10100 MODIFY COLUMN REG_USER_NUM VARCHAR(10) NULL COMMENT '등록 사용자 번호';
    ALTER TABLE BACR10100 MODIFY COLUMN REG_IP VARCHAR(20) NULL COMMENT '등록 IP';
    ALTER TABLE BACR10100 MODIFY COLUMN REG_DTM VARCHAR(14) NULL COMMENT '등록 일시';
    ALTER TABLE BACR10100 MODIFY COLUMN UPD_USER_NUM VARCHAR(10) NULL COMMENT '수정 사용자 번호';
    ALTER TABLE BACR10100 MODIFY COLUMN UPD_IP VARCHAR(20) NULL COMMENT '수정 IP';
    ALTER TABLE BACR10100 MODIFY COLUMN UPD_DTM VARCHAR(14) NULL COMMENT '수정 일시';
    
ALERT TABLE BACR10110 COMMENT = '기본정보_회원정';

    ALTER TABLE BACR10110 MODIFY COLUMN PVL_ID VARCHAR(5) NOT NULL COMMENT '정 ID';
    ALTER TABLE BACR10110 MODIFY COLUMN MB_NUM VARCHAR(10) NOT NULL COMMENT '회원 번호';
    ALTER TABLE BACR10110 MODIFY COLUMN SER_NUM NUMERIC(3) NOT NULL COMMENT '일련번호';
    ALTER TABLE BACR10110 MODIFY COLUMN EFF_STA_DT VARCHAR(8) NULL COMMENT '유효 시작 일자';
    ALTER TABLE BACR10110 MODIFY COLUMN EFF_END_DT VARCHAR(8) NULL COMMENT '유효 종료 일자';
    ALTER TABLE BACR10110 MODIFY COLUMN DEL_YN VARCHAR(1) NULL COMMENT '삭제 여부';
    ALTER TABLE BACR10110 MODIFY COLUMN REG_USER_NUM VARCHAR(10) NULL COMMENT '등록 사용자 번호';
    ALTER TABLE BACR10110 MODIFY COLUMN REG_IP VARCHAR(20) NULL COMMENT '등록 IP';
    ALTER TABLE BACR10110 MODIFY COLUMN REG_DTM VARCHAR(14) NULL COMMENT '등록 일시';
    ALTER TABLE BACR10110 MODIFY COLUMN UPD_USER_NUM VARCHAR(10) NULL COMMENT '수정 사용자 번호';
    ALTER TABLE BACR10110 MODIFY COLUMN UPD_IP VARCHAR(20) NULL COMMENT '수정 IP';
    ALTER TABLE BACR10110 MODIFY COLUMN UPD_DTM VARCHAR(14) NULL COMMENT '수정 일시';
    


