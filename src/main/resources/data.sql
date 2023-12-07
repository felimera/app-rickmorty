drop table if exists characters;
drop table if exists called_tables;
drop table if exists system_errors;

create table characters (
    ch_id int auto_increment primary key,
    ch_name varchar(50) not null,
    ch_picture varchar(50) not null,
    ch_gender varchar(2) not null,
    ch_state varchar(2) null
);

create table system_errors (
    se_id int auto_increment primary key,
    se_code varchar(10) not null,
    se_message varchar(50) not null
);

create table called_tables (
    ct_id int auto_increment primary key,
    ct_registration_date date not null,
    ct_type_request varchar(4) not null,
    ct_login_information varchar(1000) not null,
    ct_error_id int null
);


alter table called_tables add foreign key (ct_error_id) references system_errors(se_id);

insert into characters (ch_name,ch_picture,ch_gender,ch_state) values ('name_test','picture_test','M','V');