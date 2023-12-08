drop table if exists characters;
drop table if exists called_tables;
drop table if exists system_errors;

create table characters (
    ch_id int auto_increment primary key,
    ch_name varchar(50) not null,
    ch_picture varchar(1000) not null,
    ch_gender varchar(10) not null,
    ch_state varchar(10) null
);

create table system_errors (
    se_id int auto_increment primary key,
    se_code varchar(10) not null,
    se_status varchar(50) not null,
    se_message varchar(100) not null
);

create table called_tables (
    ct_id int auto_increment primary key,
    ct_registration_date date not null,
    ct_type_request varchar(4) not null,
    ct_login_information varchar(1000) not null,
    ct_error_id int null
);


alter table called_tables add foreign key (ct_error_id) references system_errors(se_id);

insert into characters (ch_id,ch_name,ch_picture,ch_gender,ch_state) values (124,'Father Bob','https://rickandmortyapi.com/api/character/avatar/124.jpeg,','Male','Alive');
insert into characters (ch_id,ch_name,ch_picture,ch_gender,ch_state) values (472,'Baby Rick','https://rickandmortyapi.com/api/character/avatar/472.jpeg','Male','Alive');
insert into characters (ch_id,ch_name,ch_picture,ch_gender,ch_state) values (580,'Secret Service Snake','https://rickandmortyapi.com/api/character/avatar/580.jpeg','Male','Alive');
insert into characters (ch_id,ch_name,ch_picture,ch_gender,ch_state) values (592,'Phoenixperson','https://rickandmortyapi.com/api/character/avatar/592.jpeg','Male','Dead');
insert into characters (ch_id,ch_name,ch_picture,ch_gender,ch_state) values (635,'Darth Poopybutthole','https://rickandmortyapi.com/api/character/avatar/635.jpeg','Male','Alive');
insert into characters (ch_id,ch_name,ch_picture,ch_gender,ch_state) values (700,'Wicker Summer','https://rickandmortyapi.com/api/character/avatar/700.jpeg','Female','Dead');