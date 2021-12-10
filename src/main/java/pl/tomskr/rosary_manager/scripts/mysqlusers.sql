drop database if exists rosarydb;
drop user if exists `rosaryadmin`@`%`;
drop user if exists `rosaryuser`@`%`;
create database if not exists rosarydb character set  utf8mb4 collate utf8mb4_polish_ci;
CREATE USER IF NOT EXISTS `rosaryadmin`@`%`  IDENTIFIED WITH mysql_native_password BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, REFERENCES, INDEX, ALTER, EXECUTE, CREATE VIEW, SHOW VIEW,
CREATE ROUTINE, ALTER ROUTINE, EVENT, TRIGGER ON `rosarydb`.* TO `rosaryadmin`@`%`;
CREATE USER IF NOT EXISTS `rosaryuser`@`%` IDENTIFIED WITH mysql_native_password BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE, SHOW VIEW ON `rosarydb`.* TO `rosaryuser`@`%`;
FLUSH PRIVILEGES;