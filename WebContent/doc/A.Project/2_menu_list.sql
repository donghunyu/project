TRUNCATE TABLE ZCOM99020;
INSERT INTO ZCOM99020 VALUES ('99'      , '관리자'        , 1, 1001, '00', ''               , '', '', '20180101', '99991231', '', '','','','','','');
INSERT INTO ZCOM99020 VALUES ('99010010', '코드관리'      , 2, 1002, '99', 'zcom99010_40.do', '', '', '20180101', '99991231', '', '','','','','','');
INSERT INTO ZCOM99020 VALUES ('99020010', '메뉴관리'      , 2, 1003, '99', 'zcom99020_40.do', '', '', '20180101', '99991231', '', '','','','','','');
INSERT INTO ZCOM99020 VALUES ('99020020', '메뉴권한관리'  , 2, 1004, '99', 'zcom99021_40.do', '', '', '20180101', '99991231', '', '','','','','','');
INSERT INTO ZCOM99020 VALUES ('99030010', '사용자관리'    , 2, 1005, '99', 'zcom99030_40.do', '', '', '20180101', '99991231', '', '','','','','','');
INSERT INTO ZCOM99020 VALUES ('99031010', '업체'          , 2, 1006, '99', 'zcom99031_40.do', '', '', '20180101', '99991231', '', '','','','','','');
INSERT INTO ZCOM99020 VALUES ('99040010', '임시로그인'    , 2, 1008, '99', 'zcom99040_40.do', '', '', '20180101', '99991231', '', '','','','','','');
INSERT INTO ZCOM99020 VALUES ('10'      , '설정'          , 1, 1009, '00', ''               , '', '', '20180101', '99991231', '', '','','','','','');
INSERT INTO ZCOM99020 VALUES ('10010010', '자산 구분'     , 2, 1010, '10', 'aprj10010_40.do', '', '', '20180101', '99991231', '', '','','','','','');
INSERT INTO ZCOM99020 VALUES ('10010012', '자산'          , 2, 1010, '10', 'aprj10012_40.do', '', '', '20180101', '99991231', '', '','','','','','');
INSERT INTO ZCOM99020 VALUES ('10020010', '프로젝트'      , 2, 1021, '10', 'aprj20010_40.do', '', '', '20180101', '99991231', '', '','','','','','');
INSERT INTO ZCOM99020 VALUES ('10030010', '업무 담당'     , 2, 1011, '10', 'aprj10020_40.do', '', '', '20180101', '99991231', '', '','','','','','');
INSERT INTO ZCOM99020 VALUES ('10040010', '업무 주기'     , 2, 1015, '10', 'aprj10040_40.do', '', '', '20180101', '99991231', '', '','','','','','');
INSERT INTO ZCOM99020 VALUES ('10050010', '결제 라인'     , 2, 1014, '10', 'aprj10030_40.do', '', '', '20180101', '99991231', '', '','','','','','');
INSERT INTO ZCOM99020 VALUES ('20'      , '프로젝트'      , 1, 1020, '00', ''               , '', '', '20180101', '99991231', '', '','','','','','');
INSERT INTO ZCOM99020 VALUES ('20030010', '업무 등록'     , 2, 1025, '20', 'aprj20030_40.do', '', '', '20180101', '99991231', '', '','','','','','');
INSERT INTO ZCOM99020 VALUES ('20031010', '업무'          , 2, 1026, '20', 'aprj20030_50.do', '', '', '20180101', '99991231', '', '','','','','','');
INSERT INTO ZCOM99020 VALUES ('20032011', '결제'          , 2, 1026, '20', 'aprj20036_50.do', '', '', '20180101', '99991231', '', '','','','','','');
INSERT INTO ZCOM99020 VALUES ('20040010', '부서'          , 2, 1007, '20', 'zcom99032_40.do', '', '', '20180101', '99991231', '', '','','','','','');
INSERT INTO ZCOM99020 VALUES ('20050010', '업체담당자'    , 2, 1005, '20', 'zcom99030_60.do', '', '', '20180101', '99991231', '', '','','','','','');
INSERT INTO ZCOM99020 VALUES ('30'      , '보고서'        , 1, 1030, '00', ''               , '', '', '20180101', '99991231', '', '','','','','','');
INSERT INTO ZCOM99020 VALUES ('30010010', '프로젝트 현황' , 2, 1031, '30', 'aprj30010_40.do', '', '', '20180101', '99991231', '', '','','','','','');
INSERT INTO ZCOM99020 VALUES ('30020010', '업무 현황'     , 2, 1032, '30', 'aprj30020_40.do', '', '', '20180101', '99991231', '', '','','','','','');
INSERT INTO ZCOM99020 VALUES ('30030010', '부서 현황'     , 2, 1034, '30', 'aprj30030_40.do', '', '', '20180101', '99991231', '', '','','','','','');
INSERT INTO ZCOM99020 VALUES ('30040010', '담당자 현황'   , 2, 1033, '30', 'aprj30040_40.do', '', '', '20180101', '99991231', '', '','','','','','');




TRUNCATE TABLE ZCOM99021;
INSERT INTO ZCOM99021 VALUES (1, '1000', '1000', '', '20180101', '99991231', '', '','','','','','');




TRUNCATE TABLE ZCOM99022;
INSERT INTO ZCOM99022 VALUES (1, '99020010', '20180101', '99991231', '', '','','','','','');
INSERT INTO ZCOM99022 VALUES (1, '99020020', '20180101', '99991231', '', '','','','','','');




TRUNCATE TABLE ZCOM99030;
INSERT INTO ZCOM99030 (USER_ID, USER_NM, USER_PWD, USER_AUTH_CD, CO_ID, EFF_STA_DT, EFF_END_DT) VALUES ('admin',  '관리자'  , 'c0abc4071d59b25a532436d2ffd00ec6fe02031366c0fb78f1d65f4ac6a2517d', '1000', '0000000000', '20180101', '99991231');
INSERT INTO ZCOM99030 (USER_ID, USER_NM, USER_PWD, USER_AUTH_CD, CO_ID, EFF_STA_DT, EFF_END_DT) VALUES ('user1',  '사용자1' , 'user1', '2000', '0000000001', '20180101', '99991231');
INSERT INTO ZCOM99030 (USER_ID, USER_NM, USER_PWD, USER_AUTH_CD, CO_ID, EFF_STA_DT, EFF_END_DT) VALUES ('user2',  '사용자2' , 'user2', '2000', '0000000001', '20180101', '99991231');
INSERT INTO ZCOM99030 (USER_ID, USER_NM, USER_PWD, USER_AUTH_CD, CO_ID, EFF_STA_DT, EFF_END_DT) VALUES ('user3',  '사용자3' , 'user3', '2000', '0000000001', '20180101', '99991231');
INSERT INTO ZCOM99030 (USER_ID, USER_NM, USER_PWD, USER_AUTH_CD, CO_ID, EFF_STA_DT, EFF_END_DT) VALUES ('user4',  '사용자4' , 'user4', '2000', '0000000001', '20180101', '99991231');
INSERT INTO ZCOM99030 (USER_ID, USER_NM, USER_PWD, USER_AUTH_CD, CO_ID, EFF_STA_DT, EFF_END_DT) VALUES ('user5',  '사용자5' , 'user5', '2000', '0000000001', '20180101', '99991231');
INSERT INTO ZCOM99030 (USER_ID, USER_NM, USER_PWD, USER_AUTH_CD, CO_ID, EFF_STA_DT, EFF_END_DT) VALUES ('user6',  '사용자6' , 'user6', '2000', '0000000001', '20180101', '99991231');
INSERT INTO ZCOM99030 (USER_ID, USER_NM, USER_PWD, USER_AUTH_CD, CO_ID, EFF_STA_DT, EFF_END_DT) VALUES ('user7',  '사용자7' , 'user7', '2000', '0000000001', '20180101', '99991231');
INSERT INTO ZCOM99030 (USER_ID, USER_NM, USER_PWD, USER_AUTH_CD, CO_ID, EFF_STA_DT, EFF_END_DT) VALUES ('user8',  '사용자8' , 'user8', '2000', '0000000001', '20180101', '99991231');
INSERT INTO ZCOM99030 (USER_ID, USER_NM, USER_PWD, USER_AUTH_CD, CO_ID, EFF_STA_DT, EFF_END_DT) VALUES ('user9',  '사용자9' , 'user9', '2000', '0000000001', '20180101', '99991231');



TRUNCATE TABLE ZCOM99031;
INSERT INTO ZCOM99031 VALUES ('0000000000',  '관리자업체', '1111111118', '', '', '', '20180101', '99991231', '', '', '', '', '', '', '');
INSERT INTO ZCOM99031 VALUES ('0000000001',  '사용자업체', '1111111118', '', '', '', '20180101', '99991231', '', '', '', '', '', '', '');

