drop table if exists contact;
create table contact(id int not null auto_increment,
firstName varchar(200),
lastName varchar(200),
primary key (id)
);