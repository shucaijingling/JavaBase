ALTER TABLE `user` ADD COLUMN `VERSION` INT(10) AFTER `email`;

UPDATE `user` SET `version` = 1 ;