DROP DATABASE IF EXISTS parkee;

CREATE DATABASE parkee;
use parkee;

CREATE TABLE tickets (
    id INT AUTO_INCREMENT,
    ticket_number VARCHAR(30) NOT NULL,
    area_code VARCHAR(32) NOT NULL,
    plate_number VARCHAR(32) NOT NULL,
    plate_code VARCHAR(32) NOT NULL,
    status VARCHAR(32) DEFAULT "CHECKED_IN",
    check_in DATE DEFAULT NOW(),
    check_out DATE,
    gmt_create TIMESTAMP NOT NULL DEFAULT NOW(),
    gmt_modified TIMESTAMP NOT NULL DEFAULT NOW() ON UPDATE NOW(),
    PRIMARY KEY (id)
);
