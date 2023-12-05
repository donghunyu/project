
DROP TABLE APRJ20010;

DROP TABLE APRJ20011;

DROP TABLE APRJ20020;

DROP TABLE APRJ20021;

DROP TABLE APRJ20029;

DROP TABLE APRJ20030;

DROP TABLE APRJ20031;

DROP TABLE APRJ20032;

DROP TABLE APRJ20033;

DROP TABLE APRJ20034;

DROP TABLE APRJ20035;

DROP TABLE APRJ20036;

DROP TABLE APRJ20038;

DROP TABLE APRJ20039;

DROP TABLE APRJ20040;

DROP TABLE APRJ20041;

DROP TABLE APRJ20050;

DROP TABLE APRJ20051;

DROP TABLE APRJ20052;

DROP TABLE APRJ20053;

CREATE TABLE APRJ20010
(
    CO_ID                VARCHAR(10) NOT NULL,
    PRJ_ID               VARCHAR(10) NOT NULL,
    PRJ_NM               VARCHAR(100) NULL,
    PRJ_VER              VARCHAR(10) NULL,
    PRJ_CTT              VARCHAR(200) NULL,
    EFF_STA_DT           VARCHAR(8) NULL,
    EFF_END_DT           VARCHAR(8) NULL,
    PROC_ST_CD           VARCHAR(4) NULL,
    DEL_YN               VARCHAR(1) NULL,
    RGST_ID              VARCHAR(20) NULL,
    RGST_IP              VARCHAR(20) NULL,
    RGST_DTM             VARCHAR(14) NULL,
    UPDT_ID              VARCHAR(20) NULL,
    UPDT_IP              VARCHAR(20) NULL,
    UPDT_DTM             VARCHAR(14) NULL
);

CREATE UNIQUE INDEX APRJ20010_PK ON APRJ20010
(
    CO_ID ASC,
    PRJ_ID ASC
);


CREATE TABLE APRJ20011
(
    CO_ID                VARCHAR(10) NOT NULL,
    FILE_SER_NUM         NUMERIC(5) NOT NULL,
    PRJ_ID               VARCHAR(10) NULL,
    OP_ID                VARCHAR(10) NULL,
    OP_SER_NUM           NUMERIC(5) NULL,
    LGC_FILE_NM          VARCHAR(100) NULL,
    PSC_FILE_NM          VARCHAR(100) NULL,
    FILE_PATH            VARCHAR(200) NULL,
    FILE_SIZE            NUMERIC(15) NULL,
    DLOAD_CNT            NUMERIC(5) NULL,
    DEL_YN               VARCHAR(1) NULL,
    RGST_ID              VARCHAR(20) NULL,
    RGST_IP              VARCHAR(20) NULL,
    RGST_DTM             VARCHAR(14) NULL,
    UPDT_ID              VARCHAR(20) NULL,
    UPDT_IP              VARCHAR(20) NULL,
    UPDT_DTM             VARCHAR(14) NULL
);

CREATE UNIQUE INDEX APRJ20011_PK ON APRJ20011
(
    CO_ID ASC,
    FILE_SER_NUM ASC
);

CREATE TABLE APRJ20020
(
    CO_ID                VARCHAR(10) NOT NULL,
    PRJ_ID               VARCHAR(10) NOT NULL,
    CTRL_NUM             VARCHAR(20) NOT NULL,
    CTRL_NM              VARCHAR(100) NULL,
    CTRL_CTT             VARCHAR(200) NULL,
    DEL_YN               VARCHAR(1) NULL,
    RGST_ID              VARCHAR(20) NULL,
    RGST_IP              VARCHAR(20) NULL,
    RGST_DTM             VARCHAR(14) NULL,
    UPDT_ID              VARCHAR(20) NULL,
    UPDT_IP              VARCHAR(20) NULL,
    UPDT_DTM             VARCHAR(14) NULL
);

CREATE UNIQUE INDEX APRJ20020_PK ON APRJ20020
(
    CO_ID ASC,
    PRJ_ID ASC,
    CTRL_NUM ASC
);

CREATE TABLE APRJ20021
(
    CO_ID                VARCHAR(10) NOT NULL,
    PRJ_ID               VARCHAR(10) NOT NULL,
    CTRL_NUM             VARCHAR(20) NOT NULL,
    AST_CL_ID            VARCHAR(10) NOT NULL,
    DEL_YN               VARCHAR(1) NULL,
    RGST_ID              VARCHAR(20) NULL,
    RGST_IP              VARCHAR(20) NULL,
    RGST_DTM             VARCHAR(14) NULL,
    UPDT_ID              VARCHAR(20) NULL,
    UPDT_IP              VARCHAR(20) NULL,
    UPDT_DTM             VARCHAR(14) NULL
);

CREATE UNIQUE INDEX APRJ20021_PK ON APRJ20021
(
    CO_ID ASC,
    PRJ_ID ASC,
    CTRL_NUM ASC,
    AST_CL_ID ASC
);

CREATE TABLE APRJ20029
(
    CO_ID                VARCHAR(10) NOT NULL,
    OP_ID                VARCHAR(10) NOT NULL,
    OP_NM                VARCHAR(40) NULL,
    OP_CTT               VARCHAR(200) NULL,
    PRJ_ID               VARCHAR(10) NULL,
    PRJ_NM               VARCHAR(100) NULL,
    DEL_YN               VARCHAR(1) NULL,
    RGST_ID              VARCHAR(20) NULL,
    RGST_IP              VARCHAR(20) NULL,
    RGST_DTM             VARCHAR(14) NULL,
    UPDT_ID              VARCHAR(20) NULL,
    UPDT_IP              VARCHAR(20) NULL,
    UPDT_DTM             VARCHAR(14) NULL
);

CREATE UNIQUE INDEX APRJ20029_PK ON APRJ20029
(
    CO_ID ASC,
    OP_ID ASC
);

CREATE TABLE APRJ20030
(
    CO_ID                VARCHAR(10) NOT NULL,
    OP_ID                VARCHAR(10) NOT NULL,
    OP_SER_NUM           NUMERIC(5) NOT NULL,
    OP_NM                VARCHAR(40) NULL,
    OP_CTT               VARCHAR(200) NULL,
    OP_VER               VARCHAR(10) NULL,
    PRJ_ID               VARCHAR(10) NULL,
    PRJ_NM               VARCHAR(100) NULL,
    DRFT_DEPT_ID         VARCHAR(10) NULL,
    DRFT_DEPT_NM         VARCHAR(40) NULL,
    DRFT_OP_CHRG_ID      VARCHAR(10) NULL,
    DRFT_OP_CHRG_NM      VARCHAR(40) NULL,
    DRFT_USER_ID         VARCHAR(20) NULL,
    DRFT_USER_NM         VARCHAR(40) NULL,
    CYCL_ID              VARCHAR(10) NULL,
    PRD_CNT              NUMERIC(5) NULL,
    CYCL_CL_CD           VARCHAR(4) NULL,
    STD_DT               VARCHAR(8) NULL,
    STM_ID               VARCHAR(10) NULL,
    EFF_STA_DT           VARCHAR(8) NULL,
    EFF_END_DT           VARCHAR(8) NULL,
    TRAN_DT              VARCHAR(8) NULL,
    TRAN_ST_CD           VARCHAR(4) NULL,
    AUTO_CL_CD           VARCHAR(4) NULL,
    DEL_YN               VARCHAR(1) NULL,
    RGST_ID              VARCHAR(20) NULL,
    RGST_IP              VARCHAR(20) NULL,
    RGST_DTM             VARCHAR(14) NULL,
    UPDT_ID              VARCHAR(20) NULL,
    UPDT_IP              VARCHAR(20) NULL,
    UPDT_DTM             VARCHAR(14) NULL
);

CREATE UNIQUE INDEX APRJ20030_PK ON APRJ20030
(
    CO_ID ASC,
    OP_ID ASC,
    OP_SER_NUM ASC
);

CREATE TABLE APRJ20031
(
    CO_ID                VARCHAR(10) NOT NULL,
    OP_ID                VARCHAR(10) NOT NULL,
    OP_SER_NUM           NUMERIC(5) NOT NULL,
    PRJ_ID               VARCHAR(10) NOT NULL,
    CTRL_NUM             VARCHAR(20) NOT NULL,
    CTRL_NM              VARCHAR(100) NULL,
    DEL_YN               VARCHAR(1) NULL,
    RGST_ID              VARCHAR(20) NULL,
    RGST_IP              VARCHAR(20) NULL,
    RGST_DTM             VARCHAR(14) NULL,
    UPDT_ID              VARCHAR(20) NULL,
    UPDT_IP              VARCHAR(20) NULL,
    UPDT_DTM             VARCHAR(14) NULL
);

CREATE UNIQUE INDEX APRJ20031_PK ON APRJ20031
(
    CO_ID ASC,
    OP_ID ASC,
    OP_SER_NUM ASC,
    PRJ_ID ASC,
    CTRL_NUM ASC
);

CREATE TABLE APRJ20032
(
    CO_ID                VARCHAR(10) NOT NULL,
    OP_ID                VARCHAR(10) NOT NULL,
    OP_SER_NUM           NUMERIC(5) NOT NULL,
    STM_SER_NUM          NUMERIC(5) NOT NULL,
    STM_SEQ_NUM          NUMERIC(5) NULL,
    STM_CL_CD            VARCHAR(4) NULL,
    STM_AUTH_CD          VARCHAR(4) NULL,
    STM_OP_CHRG_ID       VARCHAR(10) NULL,
    STM_OP_CHRG_NM       VARCHAR(40) NULL,
    DEL_YN               VARCHAR(1) NULL,
    RGST_ID              VARCHAR(20) NULL,
    RGST_IP              VARCHAR(20) NULL,
    RGST_DTM             VARCHAR(14) NULL,
    UPDT_ID              VARCHAR(20) NULL,
    UPDT_IP              VARCHAR(20) NULL,
    UPDT_DTM             VARCHAR(14) NULL
);

CREATE UNIQUE INDEX APRJ20032_PK ON APRJ20032
(
    CO_ID ASC,
    OP_ID ASC,
    OP_SER_NUM ASC,
    STM_SER_NUM ASC
);

CREATE TABLE APRJ20033
(
    CO_ID                VARCHAR(10) NOT NULL,
    OP_ID                VARCHAR(10) NOT NULL,
    OP_SER_NUM           NUMERIC(5) NOT NULL,
    PRJ_ID               VARCHAR(10) NOT NULL,
    CTRL_NUM             VARCHAR(20) NOT NULL,
    AST_CL_ID            VARCHAR(10) NOT NULL,
    OP_CHRG_ID           VARCHAR(10) NOT NULL,
    AST_CL_NM            VARCHAR(40) NULL,
    OP_CHRG_NM           VARCHAR(100) NULL,
    DEL_YN               VARCHAR(1) NULL,
    RGST_ID              VARCHAR(20) NULL,
    RGST_IP              VARCHAR(20) NULL,
    RGST_DTM             VARCHAR(14) NULL,
    UPDT_ID              VARCHAR(20) NULL,
    UPDT_IP              VARCHAR(20) NULL,
    UPDT_DTM             VARCHAR(14) NULL
);

CREATE UNIQUE INDEX APRJ20033_PK ON APRJ20033
(
    CO_ID ASC,
    OP_ID ASC,
    OP_SER_NUM ASC,
    PRJ_ID ASC,
    CTRL_NUM ASC,
    AST_CL_ID ASC,
    OP_CHRG_ID ASC
);

CREATE TABLE APRJ20034
(
    CO_ID                VARCHAR(10) NOT NULL,
    OP_ID                VARCHAR(10) NOT NULL,
    OP_SER_NUM           NUMERIC(5) NOT NULL,
    OP_CHRG_ID           VARCHAR(10) NOT NULL,
    USER_ID              VARCHAR(20) NOT NULL,
    OP_CHRG_NM           VARCHAR(40) NULL,
    USER_NM              VARCHAR(40) NULL,
    RES_ST_CD            VARCHAR(4) NULL,
    RES_DT               VARCHAR(8) NULL,
    SIGN_CL_CD           VARCHAR(4) NULL,
    SIGN_DTM             VARCHAR(14) NULL,
    DEL_YN               VARCHAR(1) NULL,
    RGST_ID              VARCHAR(20) NULL,
    RGST_IP              VARCHAR(20) NULL,
    RGST_DTM             VARCHAR(14) NULL,
    UPDT_ID              VARCHAR(20) NULL,
    UPDT_IP              VARCHAR(20) NULL,
    UPDT_DTM             VARCHAR(14) NULL
);

CREATE UNIQUE INDEX APRJ20034_PK ON APRJ20034
(
    CO_ID ASC,
    OP_ID ASC,
    OP_SER_NUM ASC,
    OP_CHRG_ID ASC,
    USER_ID ASC
);

CREATE TABLE APRJ20035
(
    CO_ID                VARCHAR(10) NOT NULL,
    OP_ID                VARCHAR(10) NOT NULL,
    OP_SER_NUM           NUMERIC(5) NOT NULL,
    TRNSF_SER_NUM        NUMERIC(5) NOT NULL,
    OP_CHRG_ID           VARCHAR(10) NOT NULL,
    OP_CHRG_NM           VARCHAR(40) NULL,
    USER_ID              VARCHAR(20) NOT NULL,
    USER_NM              VARCHAR(40) NULL,
    TRNSF_OP_CHRG_ID     VARCHAR(20) NULL,
    TRNSF_OP_CHRG_NM     VARCHAR(40) NULL,
    TRNSF_USER_ID        VARCHAR(20) NULL,
    TRNSF_USER_NM        VARCHAR(40) NULL,
    TRNSF_CTT            VARCHAR(200) NULL,
    TRNSF_TRAN_CD        VARCHAR(1) NULL,
    TRNSF_TRAN_CTT       VARCHAR(200) NULL,
    TRNSF_DTM            VARCHAR(14) NULL,
    DEL_YN               VARCHAR(1) NULL,
    RGST_ID              VARCHAR(20) NULL,
    RGST_IP              VARCHAR(20) NULL,
    RGST_DTM             VARCHAR(14) NULL,
    UPDT_ID              VARCHAR(20) NULL,
    UPDT_IP              VARCHAR(20) NULL,
    UPDT_DTM             VARCHAR(14) NULL
);

CREATE UNIQUE INDEX APRJ20035_PK ON APRJ20035
(
    CO_ID ASC,
    OP_ID ASC,
    OP_SER_NUM ASC,
    TRNSF_SER_NUM ASC
);

CREATE TABLE APRJ20036
(
    CO_ID                VARCHAR(10) NOT NULL,
    OP_ID                VARCHAR(10) NOT NULL,
    OP_SER_NUM           NUMERIC(5) NOT NULL,
    OP_CHRG_ID           VARCHAR(10) NOT NULL,
    USER_ID              VARCHAR(20) NOT NULL,
    STM_SEQ_NUM          NUMERIC(5) NOT NULL,
    STM_SER_NUM          NUMERIC(5) NOT NULL,
    STM_CL_CD            VARCHAR(4) NULL,
    STM_AUTH_CD          VARCHAR(4) NULL,
    STM_DEPT_ID          VARCHAR(10) NULL,
    STM_DEPT_NM          VARCHAR(40) NULL,
    STM_OP_CHRG_ID       VARCHAR(10) NULL,
    STM_OP_CHRG_NM       VARCHAR(40) NULL,
    STM_USER_ID          VARCHAR(20) NULL,
    STM_USER_NM          VARCHAR(40) NULL,
    DEL_YN               VARCHAR(1) NULL,
    RGST_ID              VARCHAR(20) NULL,
    RGST_IP              VARCHAR(20) NULL,
    RGST_DTM             VARCHAR(14) NULL,
    UPDT_ID              VARCHAR(20) NULL,
    UPDT_IP              VARCHAR(20) NULL,
    UPDT_DTM             VARCHAR(14) NULL
);

CREATE UNIQUE INDEX APRJ20036_PK ON APRJ20036
(
    CO_ID ASC,
    OP_ID ASC,
    OP_SER_NUM ASC,
    OP_CHRG_ID ASC,
    USER_ID ASC,
    STM_SEQ_NUM ASC,
    STM_SER_NUM ASC
);

CREATE TABLE APRJ20038
(
    OP_ID                VARCHAR(10) NOT NULL,
    CO_ID                VARCHAR(10) NOT NULL,
    OP_SER_NUM           NUMERIC(5) NOT NULL,
    PRJ_ID               VARCHAR(10) NOT NULL,
    CTRL_NUM             VARCHAR(20) NOT NULL,
    AST_CL_ID            VARCHAR(10) NOT NULL,
    AST_CL_NM            VARCHAR(40) NULL,
    DEL_YN               VARCHAR(1) NULL,
    RGST_ID              VARCHAR(20) NULL,
    RGST_IP              VARCHAR(20) NULL,
    RGST_DTM             VARCHAR(14) NULL,
    UPDT_ID              VARCHAR(20) NULL,
    UPDT_IP              VARCHAR(20) NULL,
    UPDT_DTM             VARCHAR(14) NULL
);

CREATE UNIQUE INDEX APRJ20038_PK ON APRJ20038
(
    OP_ID ASC,
    CO_ID ASC,
    OP_SER_NUM ASC,
    PRJ_ID ASC,
    CTRL_NUM ASC,
    AST_CL_ID ASC
);

CREATE TABLE APRJ20039
(
    OP_ID                VARCHAR(10) NOT NULL,
    CO_ID                VARCHAR(10) NOT NULL,
    OP_SER_NUM           NUMERIC(5) NOT NULL,
    PRJ_ID               VARCHAR(10) NOT NULL,
    CTRL_NUM             VARCHAR(20) NOT NULL,
    AST_CL_ID            VARCHAR(10) NOT NULL,
    AST_ID               VARCHAR(10) NOT NULL,
    AST_CL_NM            VARCHAR(40) NULL,
    AST_NM               VARCHAR(40) NULL,
    DEL_YN               VARCHAR(1) NULL,
    RGST_ID              VARCHAR(20) NULL,
    RGST_IP              VARCHAR(20) NULL,
    RGST_DTM             VARCHAR(14) NULL,
    UPDT_ID              VARCHAR(20) NULL,
    UPDT_IP              VARCHAR(20) NULL,
    UPDT_DTM             VARCHAR(14) NULL
);

CREATE UNIQUE INDEX APRJ20039_PK ON APRJ20039
(
    OP_ID ASC,
    CO_ID ASC,
    OP_SER_NUM ASC,
    PRJ_ID ASC,
    CTRL_NUM ASC,
    AST_CL_ID ASC,
    AST_ID ASC
);

CREATE TABLE APRJ20040
(
    CO_ID                VARCHAR(10) NOT NULL,
    OP_ID                VARCHAR(10) NOT NULL,
    OP_SER_NUM           NUMERIC(5) NOT NULL,
    REQ_SER_NUM          NUMERIC(5) NOT NULL,
    REQ_SEQ_NUM          NUMERIC(5) NULL,
    REQ_TYP_CD           NUMERIC(5) NULL,
    REQ_CTT              VARCHAR(200) NULL,
    DEL_YN               VARCHAR(1) NULL,
    RGST_ID              VARCHAR(20) NULL,
    RGST_IP              VARCHAR(20) NULL,
    RGST_DTM             VARCHAR(14) NULL,
    UPDT_ID              VARCHAR(20) NULL,
    UPDT_IP              VARCHAR(20) NULL,
    UPDT_DTM             VARCHAR(14) NULL
);

CREATE UNIQUE INDEX APRJ20040_PK ON APRJ20040
(
    CO_ID ASC,
    OP_ID ASC,
    OP_SER_NUM ASC,
    REQ_SER_NUM ASC
);

CREATE TABLE APRJ20041
(
    CO_ID                VARCHAR(10) NOT NULL,
    OP_ID                VARCHAR(10) NOT NULL,
    OP_SER_NUM           NUMERIC(5) NOT NULL,
    REQ_SER_NUM          NUMERIC(5) NOT NULL,
    ITM_SER_NUM          NUMERIC(5) NOT NULL,
    ITM_VAL              VARCHAR(200) NULL,
    ITM_CTT              VARCHAR(200) NULL,
    DEL_YN               VARCHAR(1) NULL,
    RGST_ID              VARCHAR(20) NULL,
    RGST_IP              VARCHAR(20) NULL,
    RGST_DTM             VARCHAR(14) NULL,
    UPDT_ID              VARCHAR(20) NULL,
    UPDT_IP              VARCHAR(20) NULL,
    UPDT_DTM             VARCHAR(14) NULL
);

CREATE UNIQUE INDEX APRJ20041_PK ON APRJ20041
(
    CO_ID ASC,
    OP_ID ASC,
    OP_SER_NUM ASC,
    REQ_SER_NUM ASC,
    ITM_SER_NUM ASC
);

CREATE TABLE APRJ20050
(
    CO_ID                VARCHAR(10) NOT NULL,
    OP_ID                VARCHAR(10) NOT NULL,
    OP_SER_NUM           NUMERIC(5) NOT NULL,
    OP_CHRG_ID           VARCHAR(10) NOT NULL,
    USER_ID              VARCHAR(20) NOT NULL,
    RES_SER_NUM          NUMERIC(5) NOT NULL,
    USER_NM              VARCHAR(40) NULL,
    DEPT_ID              VARCHAR(10) NULL,
    DEPT_NM              VARCHAR(40) NULL,
    RES_ST_CD            VARCHAR(4) NULL,
    RES_DT               VARCHAR(8) NULL,
    SIGN_CL_CD           VARCHAR(4) NULL,
    SIGN_DTM             VARCHAR(14) NULL,
    DEL_YN               VARCHAR(1) NULL,
    RGST_ID              VARCHAR(20) NULL,
    RGST_IP              VARCHAR(20) NULL,
    RGST_DTM             VARCHAR(14) NULL,
    UPDT_ID              VARCHAR(20) NULL,
    UPDT_IP              VARCHAR(20) NULL,
    UPDT_DTM             VARCHAR(14) NULL
);

CREATE UNIQUE INDEX APRJ20050_PK ON APRJ20050
(
    CO_ID ASC,
    OP_ID ASC,
    OP_SER_NUM ASC,
    OP_CHRG_ID ASC,
    USER_ID ASC,
    RES_SER_NUM ASC
);

CREATE TABLE APRJ20051
(
    CO_ID                VARCHAR(10) NOT NULL,
    OP_ID                VARCHAR(10) NOT NULL,
    OP_SER_NUM           NUMERIC(5) NOT NULL,
    OP_CHRG_ID           VARCHAR(10) NOT NULL,
    USER_ID              VARCHAR(20) NOT NULL,
    RES_SER_NUM          NUMERIC(5) NOT NULL,
    REQ_SER_NUM          NUMERIC(5) NOT NULL,
    ITM_SER_NUM          NUMERIC(5) NOT NULL,
    RGST_CL_CD           VARCHAR(4) NULL,
    RES_ID               VARCHAR(200) NULL,
    RES_CTT              VARCHAR(1000) NULL,
    DEL_YN               VARCHAR(1) NULL,
    RGST_ID              VARCHAR(20) NULL,
    RGST_IP              VARCHAR(20) NULL,
    RGST_DTM             VARCHAR(14) NULL,
    UPDT_ID              VARCHAR(20) NULL,
    UPDT_IP              VARCHAR(20) NULL,
    UPDT_DTM             VARCHAR(14) NULL
);

CREATE UNIQUE INDEX APRJ20051_PK ON APRJ20051
(
    CO_ID ASC,
    OP_ID ASC,
    OP_SER_NUM ASC,
    OP_CHRG_ID ASC,
    USER_ID ASC,
    RES_SER_NUM ASC,
    REQ_SER_NUM ASC,
    ITM_SER_NUM ASC
);

CREATE TABLE APRJ20052
(
    CO_ID                VARCHAR(10) NOT NULL,
    OP_ID                VARCHAR(10) NOT NULL,
    OP_SER_NUM           NUMERIC(5) NOT NULL,
    FILE_SER_NUM         NUMERIC(5) NOT NULL,
    OP_CHRG_ID           VARCHAR(10) NULL,
    USER_ID              VARCHAR(20) NULL,
    RES_SER_NUM          NUMERIC(5) NULL,
    REQ_SER_NUM          NUMERIC(5) NULL,
    ITM_SER_NUM          NUMERIC(5) NULL,
    LGC_FILE_NM          VARCHAR(100) NULL,
    PSC_FILE_NM          VARCHAR(100) NULL,
    FILE_PATH            VARCHAR(200) NULL,
    FILE_SIZE            NUMERIC(15) NULL,
    DLOAD_CNT            NUMERIC(5) NULL,
    DEL_YN               VARCHAR(1) NULL,
    RGST_ID              VARCHAR(20) NULL,
    RGST_IP              VARCHAR(20) NULL,
    RGST_DTM             VARCHAR(14) NULL,
    UPDT_ID              VARCHAR(20) NULL,
    UPDT_IP              VARCHAR(20) NULL,
    UPDT_DTM             VARCHAR(14) NULL
);

CREATE UNIQUE INDEX APRJ20052_PK ON APRJ20052
(
    CO_ID ASC,
    OP_ID ASC,
    OP_SER_NUM ASC,
    OP_CHRG_ID ASC,
    USER_ID ASC,
    RES_SER_NUM ASC,
    REQ_SER_NUM ASC,
    ITM_SER_NUM ASC,
    FILE_SER_NUM ASC
);

CREATE TABLE APRJ20053
(
    CO_ID                VARCHAR(10) NOT NULL,
    OP_ID                VARCHAR(10) NOT NULL,
    OP_SER_NUM           NUMERIC(5) NOT NULL,
    OP_CHRG_ID           VARCHAR(10) NOT NULL,
    USER_ID              VARCHAR(20) NOT NULL,
    RES_SER_NUM          NUMERIC(5) NOT NULL,
    STM_SEQ_NUM          NUMERIC(5) NOT NULL,
    SIGN_CL_CD           VARCHAR(4) NULL,
    SIGN_DTM             VARCHAR(14) NULL,
    BLCIN_VAL            VARCHAR(200) NULL,
    SIGN_FILE_PATH       VARCHAR(200) NULL,
    SIGN_CTT             VARCHAR(200) NULL,
    DEL_YN               VARCHAR(1) NULL,
    RGST_ID              VARCHAR(20) NULL,
    RGST_IP              VARCHAR(20) NULL,
    RGST_DTM             VARCHAR(14) NULL,
    UPDT_ID              VARCHAR(20) NULL,
    UPDT_IP              VARCHAR(20) NULL,
    UPDT_DTM             VARCHAR(14) NULL
);

CREATE UNIQUE INDEX APRJ20053_PK ON APRJ20053
(
    CO_ID ASC,
    OP_ID ASC,
    OP_SER_NUM ASC,
    OP_CHRG_ID ASC,
    USER_ID ASC,
    RES_SER_NUM ASC,
    STM_SEQ_NUM ASC
);

