CREATE TABLE t_user
(
    f_id                 bigint UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
    f_version            bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '乐观锁主键',
    f_created_at         bigint UNSIGNED NOT NULL default 0 COMMENT '创建时间',
    f_updated_at         bigint UNSIGNED NOT NULL default 0 COMMENT '更新时间',
    f_avatar             varchar(255) NOT NULL DEFAULT '' COMMENT '用户头像URL',
    f_nick_name          varchar(255) NOT NULL DEFAULT '' COMMENT '昵称',
    f_cell_phone         varchar(255) NOT NULL DEFAULT '' COMMENT '手机号',
    f_password           varchar(255) NOT NULL DEFAULT '' COMMENT '登录密码',
    f_kyc_status        tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '实名状态（0：未审核；1：审核中；2：已通过）',
    f_type               tinyint      NOT NULL DEFAULT 1 COMMENT '用户类型 1:普通 2:系统手续费接收人',
    unique uniq_cell_phone (f_cell_phone)
) ENGINE = innodb CHARSET = utf8mb4 COMMENT '用户表';