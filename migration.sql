DROP DATABASE IF EXISTS parkee;

CREATE DATABASE parkee;
use parkee;

CREATE TABLE tickets (
    id INT AUTO_INCREMENT,
    plate VARCHAR(20) NOT NULL,
    status VARCHAR(32) NOT NULL DEFAULT "INSIDE",
    check_in DATE NOT NULL DEFAULT NOW(),
    check_out DATE,
    gmt_create TIMESTAMP NOT NULL DEFAULT NOW(),
    gmt_modified TIMESTAMP NOT NULL DEFAULT NOW() ON UPDATE NOW(),
    PRIMARY KEY (id)
);
