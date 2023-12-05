
DROP TABLE APRJ10010;

DROP TABLE APRJ10011;

DROP TABLE APRJ10012;

DROP TABLE APRJ10013;

DROP TABLE APRJ10020;

DROP TABLE APRJ10021;

DROP TABLE APRJ10030;

DROP TABLE APRJ10031;

DROP TABLE APRJ10040;

DROP TABLE APRJ10050;

DROP TABLE APRJ10051;

DROP TABLE APRJ10052;


CREATE TABLE APRJ10010
(
    CO_ID                VARCHAR(10) NOT NULL,
    AST_CL_ID            VARCHAR(10) NOT NULL,
    AST_CL_NM            VARCHAR(40) NULL,
    AST_CL_CTT           VARCHAR(200) NULL,
    DEL_YN               VARCHAR(1) NULL,
    RGST_ID              VARCHAR(20) NULL,
    RGST_IP              VARCHAR(20) NULL,
    RGST_DTM             VARCHAR(14) NULL,
    UPDT_ID              VARCHAR(20) NULL,
    UPDT_IP              VARCHAR(20) NULL,
    UPDT_DTM             VARCHAR(14) NULL
);

CREATE UNIQUE INDEX APRJ10010_PK ON APRJ10010
(
    CO_ID ASC,
    AST_CL_ID ASC
);

CREATE TABLE APRJ10011
(
    CO_ID                VARCHAR(10) NOT NULL,
    OP_CHRG_ID           VARCHAR(10) NOT NULL,
    OP_CHRG_NM           VARCHAR(40) NULL,
    OP_CHRG_CTT          VARCHAR(200) NULL,
    DEL_YN               VARCHAR(1) NULL,
    RGST_ID              VARCHAR(20) NULL,
    RGST_IP              VARCHAR(20) NULL,
    RGST_DTM             VARCHAR(14) NULL,
    UPDT_ID              VARCHAR(20) NULL,
    UPDT_IP              VARCHAR(20) NULL,
    UPDT_DTM             VARCHAR(14) NULL
);

CREATE UNIQUE INDEX APRJ10011_PK ON APRJ10011
(
    CO_ID ASC,
    OP_CHRG_ID ASC
);

CREATE TABLE APRJ10012
(
    CO_ID                VARCHAR(10) NOT NULL,
    OP_CHRG_ID           VARCHAR(10) NOT NULL,
    AST_CL_ID            VARCHAR(10) NOT NULL,
    DEL_YN               VARCHAR(1) NULL,
    RGST_ID              VARCHAR(20) NULL,
    RGST_IP              VARCHAR(20) NULL,
    RGST_DTM             VARCHAR(14) NULL,
    UPDT_ID              VARCHAR(20) NULL,
    UPDT_IP              VARCHAR(20) NULL,
    UPDT_DTM             VARCHAR(14) NULL
);

CREATE UNIQUE INDEX APRJ10012_PK ON APRJ10012
(
    CO_ID ASC,
    OP_CHRG_ID ASC,
    AST_CL_ID ASC
);

CREATE TABLE APRJ10013
(
    CO_ID                VARCHAR(10) NOT NULL,
    AST_CL_ID            VARCHAR(10) NOT NULL,
    AST_ID               VARCHAR(10) NOT NULL,
    AST_NM               VARCHAR(40) NULL,
    AST_CTT              VARCHAR(200) NULL,
    DEL_YN               VARCHAR(1) NULL,
    RGST_ID              VARCHAR(20) NULL,
    RGST_IP              VARCHAR(20) NULL,
    RGST_DTM             VARCHAR(14) NULL,
    UPDT_ID              VARCHAR(20) NULL,
    UPDT_IP              VARCHAR(20) NULL,
    UPDT_DTM             VARCHAR(14) NULL
);

CREATE UNIQUE INDEX APRJ10013_PK ON APRJ10013
(
    CO_ID ASC,
    AST_CL_ID ASC,
    AST_ID ASC
);

CREATE TABLE APRJ10020
(
    CO_ID                VARCHAR(10) NOT NULL,
    PRJ_ID               VARCHAR(10) NOT NULL,
    PRJ_NM               VARCHAR(100) NULL,
    PRJ_CTT              VARCHAR(200) NULL,
    DEL_YN               VARCHAR(1) NULL,
    RGST_ID              VARCHAR(20) NULL,
    RGST_IP              VARCHAR(20) NULL,
    RGST_DTM             VARCHAR(14) NULL,
    UPDT_ID              VARCHAR(20) NULL,
    UPDT_IP              VARCHAR(20) NULL,
    UPDT_DTM             VARCHAR(14) NULL
);

CREATE UNIQUE INDEX APRJ10020_PK ON APRJ10020
(
    CO_ID ASC,
    PRJ_ID ASC
);

CREATE TABLE APRJ10021
(
    CO_ID                VARCHAR(10) NOT NULL,
    CTRL_ID              VARCHAR(10) NOT NULL,
    CTRL_NUM             VARCHAR(20) NULL,
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

CREATE UNIQUE INDEX APRJ10021_PK ON APRJ10021
(
    CO_ID ASC,
    CTRL_ID ASC
);

CREATE TABLE APRJ10022
(
    CO_ID                VARCHAR(10) NOT NULL,
    CTRL_ID              VARCHAR(10) NOT NULL,
    AST_ID               VARCHAR(10) NOT NULL,
    DEL_YN               VARCHAR(1) NULL,
    RGST_ID              VARCHAR(20) NULL,
    RGST_IP              VARCHAR(20) NULL,
    RGST_DTM             VARCHAR(14) NULL,
    UPDT_ID              VARCHAR(20) NULL,
    UPDT_IP              VARCHAR(20) NULL,
    UPDT_DTM             VARCHAR(14) NULL
);

CREATE UNIQUE INDEX APRJ10022_PK ON APRJ10022
(
    CO_ID ASC,
    CTRL_ID ASC,
    AST_ID ASC
);

CREATE TABLE APRJ10030
(
    CO_ID                VARCHAR(10) NOT NULL,
    STM_ID               VARCHAR(10) NOT NULL,
    STM_NM               VARCHAR(40) NULL,
    STM_CTT              VARCHAR(200) NULL,
    DEL_YN               VARCHAR(1) NULL,
    RGST_ID              VARCHAR(20) NULL,
    RGST_IP              VARCHAR(20) NULL,
    RGST_DTM             VARCHAR(14) NULL,
    UPDT_ID              VARCHAR(20) NULL,
    UPDT_IP              VARCHAR(20) NULL,
    UPDT_DTM             VARCHAR(14) NULL
);

CREATE UNIQUE INDEX APRJ10030_PK ON APRJ10030
(
    CO_ID ASC,
    STM_ID ASC
);

CREATE TABLE APRJ10031
(
    CO_ID                VARCHAR(10) NOT NULL,
    STM_ID               VARCHAR(10) NOT NULL,
    STM_SER_NUM          NUMERIC(5) NOT NULL,
    STM_CL_CD            VARCHAR(4) NULL,
    OP_ID                VARCHAR(10) NULL,
    STM_AUTH_CD          VARCHAR(4) NULL,
    DEL_YN               VARCHAR(1) NULL,
    RGST_ID              VARCHAR(20) NULL,
    RGST_IP              VARCHAR(20) NULL,
    RGST_DTM             VARCHAR(14) NULL,
    UPDT_ID              VARCHAR(20) NULL,
    UPDT_IP              VARCHAR(20) NULL,
    UPDT_DTM             VARCHAR(14) NULL
);

CREATE UNIQUE INDEX APRJ10031_PK ON APRJ10031
(
    CO_ID ASC,
    STM_ID ASC,
    STM_SER_NUM ASC
);

CREATE TABLE APRJ10040
(
    CO_ID                VARCHAR(10) NOT NULL,
    CYCL_ID              VARCHAR(10) NOT NULL,
    CYCL_NM              VARCHAR(40) NULL,
    PRD_CNT              NUMERIC(5) NULL,
    CYCL_CL_CD           VARCHAR(4) NULL,
    STD_DT               VARCHAR(8) NULL,
    STD_H                VARCHAR(2) NULL,
    DEL_YN               VARCHAR(1) NULL,
    RGST_ID              VARCHAR(20) NULL,
    RGST_IP              VARCHAR(20) NULL,
    RGST_DTM             VARCHAR(14) NULL,
    UPDT_ID              VARCHAR(20) NULL,
    UPDT_IP              VARCHAR(20) NULL,
    UPDT_DTM             VARCHAR(14) NULL
);

CREATE UNIQUE INDEX APRJ10040_PK ON APRJ10040
(
    CO_ID ASC,
    CYCL_ID ASC
);

CREATE TABLE APRJ10050
(
    CO_ID                VARCHAR(10) NOT NULL,
    FORM_ID              VARCHAR(10) NOT NULL,
    FORM_NM              VARCHAR(100) NULL,
    FORM_VER             VARCHAR(10) NULL,
    FORM_CTT             VARCHAR(200) NULL,
    DEL_YN               VARCHAR(1) NULL,
    RGST_ID              VARCHAR(20) NULL,
    RGST_IP              VARCHAR(20) NULL,
    RGST_DTM             VARCHAR(14) NULL,
    UPDT_ID              VARCHAR(20) NULL,
    UPDT_IP              VARCHAR(20) NULL,
    UPDT_DTM             VARCHAR(14) NULL
);

CREATE UNIQUE INDEX APRJ10050_PK ON APRJ10050
(
    CO_ID ASC,
    FORM_ID ASC
);

CREATE TABLE APRJ10051
(
    CO_ID                VARCHAR(10) NOT NULL,
    FORM_ID              VARCHAR(10) NOT NULL,
    REQ_SER_NUM          NUMERIC(5) NOT NULL,
    REQ_SEQ_NUM          NUMERIC(5) NULL,
    REQ_TYP_CD           VARCHAR(4) NULL,
    REQ_CTT              VARCHAR(200) NULL,
    DEL_YN               VARCHAR(1) NULL,
    RGST_ID              VARCHAR(20) NULL,
    RGST_IP              VARCHAR(20) NULL,
    RGST_DTM             VARCHAR(14) NULL,
    UPDT_ID              VARCHAR(20) NULL,
    UPDT_IP              VARCHAR(20) NULL,
    UPDT_DTM             VARCHAR(14) NULL
);

CREATE UNIQUE INDEX APRJ10051_PK ON APRJ10051
(
    CO_ID ASC,
    FORM_ID ASC,
    REQ_SER_NUM ASC
);

CREATE TABLE APRJ10052
(
    CO_ID                VARCHAR(10) NOT NULL,
    FORM_ID              VARCHAR(10) NOT NULL,
    REQ_SER_NUM          NUMERIC(5) NOT NULL,
    ITM_SER_NUM          NUMERIC(5) NOT NULL,
    ITM_VAL              VARCHAR(10) NULL,
    ITM_CTT              VARCHAR(200) NULL,
    DEL_YN               VARCHAR(1) NULL,
    RGST_ID              VARCHAR(20) NULL,
    RGST_IP              VARCHAR(20) NULL,
    RGST_DTM             VARCHAR(14) NULL,
    UPDT_ID              VARCHAR(20) NULL,
    UPDT_IP              VARCHAR(20) NULL,
    UPDT_DTM             VARCHAR(14) NULL
);

CREATE UNIQUE INDEX APRJ10052_PK ON APRJ10052
(
    CO_ID ASC,
    FORM_ID ASC,
    REQ_SER_NUM ASC,
    ITM_SER_NUM ASC
);

