alter table `user`
add column `deleted` int(1) NULL default 0 comment '1代表删除，0代表未删除' after `version`;