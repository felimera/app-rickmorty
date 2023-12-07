drop table if exists characters;
drop table if exists called_tables;

CREATE TABLE characters (
    ch_id int auto_increment  primary key,
    ch_name varchar(50) not null,
    ch_picture varchar(50) not null,
    ch_gender varchar(2) not null,
    ch_state varchar(2) null
);

CREATE TABLE called_tables (
    ct_id int auto_increment  primary key,
    ct_date date not null,
    ct_type_request varchar(4) not null,
    ct_login_information varchar(1000) not null,
    ct_error varchar(50) null
);