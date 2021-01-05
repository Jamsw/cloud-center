SET NAMES utf8;

DROP DATABASE IF EXISTS auth;
CREATE DATABASE auth DEFAULT CHARSET utf8mb4;
USE auth;

-- client用户表
DROP TABLE IF EXISTS oauth_client_details;
CREATE TABLE oauth_client_details
(
    client_id               VARCHAR(256) NOT NULL COMMENT '客户端ID',
    resource_ids            VARCHAR(256) COMMENT '资源ID集合,多个资源时用逗号(,)分隔',
    client_secret           VARCHAR(256) COMMENT '客户端密匙',
    scope                   VARCHAR(256) COMMENT '客户端申请的权限范围',
    authorized_grant_types  VARCHAR(256) COMMENT '客户端支持的grant_type',
    web_server_redirect_uri VARCHAR(256) COMMENT '重定向URI',
    authorities             VARCHAR(256) COMMENT '客户端所拥有的Spring Security的权限值，多个用逗号(,)分隔',
    access_token_validity   INTEGER COMMENT '访问令牌有效时间值(单位:秒)',
    refresh_token_validity  INTEGER COMMENT '更新令牌有效时间值(单位:秒)',
    additional_information  VARCHAR(4096) COMMENT '预留字段',
    autoapprove             VARCHAR(256) COMMENT '用户是否自动Approval操作',
    CONSTRAINT pk_oauth_client_details_client_id PRIMARY KEY (client_id)
) COMMENT '客户端信息';

-- DML数据准备

INSERT INTO oauth_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove)
VALUES ('test_client', NULL, '$2a$10$2szDKjvKHJCWE6YQNznogOeQF3USZHmCYj1fG7YbfK.vnTgNKLzri', 'read', 'client_credentials,authorization_code,mobile,password,refresh_token', 'http://127.0.0.1:8000/cc/ceshi', NULL, 7200, 108000, NULL, NULL);


