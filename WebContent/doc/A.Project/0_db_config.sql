카페24
ID : gadian2018
PW : 가다안!2g(rkeldks!2g)


mysql -u root -p 
admin

show databases;

drop database gadian2018;

create database gadian2018 default character set utf8;

CREATE USER 'gadian2018'@'localhost' IDENTIFIED BY 'rkeldks!2';
GRANT EXECUTE, PROCESS, SELECT, SHOW DATABASES, SHOW VIEW, ALTER, ALTER ROUTINE, CREATE, CREATE ROUTINE, CREATE TABLESPACE, CREATE TEMPORARY TABLES, CREATE VIEW, DELETE, DROP, EVENT, INDEX, INSERT, REFERENCES, TRIGGER, UPDATE, CREATE USER, FILE, LOCK TABLES, RELOAD, REPLICATION CLIENT, REPLICATION SLAVE, SHUTDOWN, SUPER  ON *.* TO 'gadian2018'@'localhost' WITH GRANT OPTION;
FLUSH PRIVILEGES;
SHOW GRANTS FOR 'gadian2018'@'localhost';

use gadian2018;
 
show tables;


show tables;

mysql -u gadian2018 -p
rkeldks!2
use gadian2018;




SET SQL_SAFE_UPDATES = 0;


