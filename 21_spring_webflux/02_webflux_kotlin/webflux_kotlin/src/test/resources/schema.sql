CREATE TABLE IF NOT EXISTS member
(
    id       bigint auto_increment primary key,
    name     varchar(255) null,
    email    varchar(255) null,
    password varchar(255) null
);

CREATE TABLE IF NOT EXISTS car (
    id       		bigint auto_increment primary key,
    name     		varchar(255) null,
    manufacturer 	varchar(255) null
);