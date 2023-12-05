
DROP TABLE ZCOM99010;

DROP TABLE ZCOM99011;

DROP TABLE ZCOM99020;

DROP TABLE ZCOM99021;

DROP TABLE ZCOM99022;

DROP TABLE ZCOM99030;

DROP TABLE ZCOM99031;

DROP TABLE ZCOM99040;

CREATE TABLE ZCOM99010
(
    GRP_CD               VARCHAR(10) NOT NULL,
    GRP_CD_NM            VARCHAR(40) NULL,
    GRP_CD_CTT           VARCHAR(1000) NULL,
    EFF_STA_DT           VARCHAR(8) NULL,
    EFF_END_DT           VARCHAR(8) NULL,
    DEL_YN               VARCHAR(1) NULL,
    RGST_ID              VARCHAR(20) NULL,
    RGST_IP              VARCHAR(20) NULL,
    RGST_DTM             VARCHAR(14) NULL,
    UPDT_ID              VARCHAR(20) NULL,
    UPDT_IP              VARCHAR(20) NULL,
    UPDT_DTM             VARCHAR(14) NULL
);

CREATE UNIQUE INDEX ZCOM99010_PK ON ZCOM99010
(
    GRP_CD ASC
);

CREATE TABLE ZCOM99011
(
    GRP_CD               VARCHAR(10) NOT NULL,
    CD                   VARCHAR(10) NOT NULL,
    CD_NM                VARCHAR(40) NULL,
    SEQ_NUM              NUMERIC(5) NULL,
    CD_CTT               VARCHAR(1000) NULL,
    EFF_STA_DT           VARCHAR(8) NULL,
    EFF_END_DT           VARCHAR(8) NULL,
    DEL_YN               VARCHAR(1) NULL,
    RGST_ID              VARCHAR(20) NULL,
    RGST_IP              VARCHAR(20) NULL,
    RGST_DTM             VARCHAR(14) NULL,
    UPDT_ID              VARCHAR(20) NULL,
    UPDT_IP              VARCHAR(20) NULL,
    UPDT_DTM             VARCHAR(14) NULL
);

CREATE UNIQUE INDEX ZCOM99011_PK ON ZCOM99011
(
    GRP_CD ASC,
    CD ASC
);

CREATE TABLE ZCOM99020
(
    MENU_ID              VARCHAR(8) NOT NULL,
    MENU_NM              VARCHAR(40) NULL,
    MENU_LEV_VAL         NUMERIC(5) NULL,
    SEQ_NUM              NUMERIC(5) NULL,
    SUP_MENU_ID          VARCHAR(8) NULL,
    ACT_ID               VARCHAR(20) NULL,
    URL                  VARCHAR(200) NULL,
    MENU_CTT             VARCHAR(1000) NULL,
    EFF_STA_DT           VARCHAR(8) NULL,
    EFF_END_DT           VARCHAR(8) NULL,
    DEL_YN               VARCHAR(1) NULL,
    RGST_ID              VARCHAR(20) NULL,
    RGST_IP              VARCHAR(20) NULL,
    RGST_DTM             VARCHAR(14) NULL,
    UPDT_ID              VARCHAR(20) NULL,
    UPDT_IP              VARCHAR(20) NULL,
    UPDT_DTM             VARCHAR(14) NULL
);

CREATE UNIQUE INDEX ZCOM99020_PK ON ZCOM99020
(
    MENU_ID ASC
);

CREATE TABLE ZCOM99021
(
    SER_NUM              NUMERIC(5) NOT NULL,
    MENU_AUTH_CD         VARCHAR(4) NULL,
    USER_AUTH_CD         VARCHAR(8) NULL,
    USER_ID              VARCHAR(20) NOT NULL,
    EFF_STA_DT           VARCHAR(8) NULL,
    EFF_END_DT           VARCHAR(8) NULL,
    DEL_YN               VARCHAR(1) NULL,
    RGST_ID              VARCHAR(20) NULL,
    RGST_IP              VARCHAR(20) NULL,
    RGST_DTM             VARCHAR(14) NULL,
    UPDT_ID              VARCHAR(20) NULL,
    UPDT_IP              VARCHAR(20) NULL,
    UPDT_DTM             VARCHAR(14) NULL
);

CREATE UNIQUE INDEX ZCOM99021_PK ON ZCOM99021
(
    SER_NUM ASC
);

CREATE TABLE ZCOM99022
(
    SER_NUM              NUMERIC(5) NOT NULL,
    MENU_ID              VARCHAR(8) NOT NULL,
    EFF_STA_DT           VARCHAR(8) NULL,
    EFF_END_DT           VARCHAR(8) NULL,
    DEL_YN               VARCHAR(1) NULL,
    RGST_ID              VARCHAR(20) NULL,
    RGST_IP              VARCHAR(20) NULL,
    RGST_DTM             VARCHAR(14) NULL,
    UPDT_ID              VARCHAR(20) NULL,
    UPDT_IP              VARCHAR(20) NULL,
    UPDT_DTM             VARCHAR(14) NULL
);

CREATE UNIQUE INDEX ZCOM99022_PK ON ZCOM99022
(
    SER_NUM ASC,
    MENU_ID ASC
);

CREATE TABLE ZCOM99030
(
    USER_ID              VARCHAR(20) NOT NULL,
    USER_NM              VARCHAR(40) NULL,
    USER_PWD             VARCHAR(100) NULL,
    PWD_UPDT_DT          VARCHAR(8) NULL,
    USER_AUTH_CD         VARCHAR(4) NULL,
    SUP_USER_ID          VARCHAR(20) NULL,
    CO_ID                VARCHAR(10) NULL,
    DEPT_ID              VARCHAR(10) NULL,
    PHON_NUM             VARCHAR(60) NULL,
    MAIL_ADDR            VARCHAR(100) NULL,
    INI_SCR_URL          VARCHAR(200) NULL,
    EFF_STA_DT           VARCHAR(8) NULL,
    EFF_END_DT           VARCHAR(8) NULL,
    DEL_YN               VARCHAR(1) NULL,
    RGST_ID              VARCHAR(20) NULL,
    RGST_IP              VARCHAR(20) NULL,
    RGST_DTM             VARCHAR(14) NULL,
    UPDT_ID              VARCHAR(20) NULL,
    UPDT_IP              VARCHAR(20) NULL,
    UPDT_DTM             VARCHAR(14) NULL
);

CREATE UNIQUE INDEX ZCOM99030_PK ON ZCOM99030
(
    USER_ID ASC
);

CREATE TABLE ZCOM99031
(
    CO_ID                VARCHAR(10) NOT NULL,
    CO_NM                VARCHAR(40) NULL,
    CO_BIZ_NUM           VARCHAR(10) NULL,
    CO_PHON_NUM          VARCHAR(60) NULL,
    CO_ADDR              VARCHAR(200) NULL,
    CO_CTT               VARCHAR(200) NULL,
    EFF_STA_DT           VARCHAR(8) NULL,
    EFF_END_DT           VARCHAR(8) NULL,
    DEL_YN               VARCHAR(1) NULL,
    RGST_ID              VARCHAR(20) NULL,
    RGST_IP              VARCHAR(20) NULL,
    RGST_DTM             VARCHAR(14) NULL,
    UPDT_ID              VARCHAR(20) NULL,
    UPDT_IP              VARCHAR(20) NULL,
    UPDT_DTM             VARCHAR(14) NULL
);

CREATE UNIQUE INDEX ZCOM99031_PK ON ZCOM99031
(
    CO_ID ASC
);

CREATE TABLE ZCOM99032
(
    CO_ID                VARCHAR(10) NOT NULL,
    DEPT_ID              VARCHAR(10) NOT NULL,
    DEPT_NM              VARCHAR(40) NULL,
    DEPT_CTT             VARCHAR(200) NULL,
    SUP_DEPT_ID          VARCHAR(10) NULL,
    EFF_STA_DT           VARCHAR(8) NULL,
    EFF_END_DT           VARCHAR(8) NULL,
    DEL_YN               VARCHAR(1) NULL,
    RGST_ID              VARCHAR(20) NULL,
    RGST_IP              VARCHAR(20) NULL,
    RGST_DTM             VARCHAR(14) NULL,
    UPDT_ID              VARCHAR(20) NULL,
    UPDT_IP              VARCHAR(20) NULL,
    UPDT_DTM             VARCHAR(14) NULL
);

CREATE UNIQUE INDEX ZCOM99032_PK ON ZCOM99032
(
    CO_ID ASC,
    DEPT_ID ASC
);

CREATE TABLE ZCOM99040
(
    TMP_LOGIN_ID         VARCHAR(100) NOT NULL,
    USER_ID              VARCHAR(20) NOT NULL,
    SCR_URL              VARCHAR(200) NULL,
    EFF_STA_DT           VARCHAR(8) NULL,
    EFF_END_DT           VARCHAR(8) NULL,
    DEL_YN               VARCHAR(1) NULL,
    RGST_ID              VARCHAR(20) NULL,
    RGST_IP              VARCHAR(20) NULL,
    RGST_DTM             VARCHAR(14) NULL
);

CREATE UNIQUE INDEX ZCOM99040_PK ON ZCOM99040
(
    TMP_LOGIN_ID ASC
);

