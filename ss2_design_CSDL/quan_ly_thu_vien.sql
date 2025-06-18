create database quan_ly_thu_vien;
use quan_ly_thu_vien;

create table students(
id_student int  auto_increment primary key,
name_student varchar(100) not null,
birthday varchar(15) not null,
class_name varchar(50) not null
);
create table categories(
id_category int  auto_increment primary key,
name_category varchar(100) not null
);
create table authors(
id_author int auto_increment primary key,
name_author varchar(100) not null
);
create table books(
id_book int  auto_increment primary key,
title varchar(100) not null,
page_size int not null,
id_category int ,
id_author int ,
foreign key (id_category) references category(id_category),
foreign key (id_author) references authors(id_author)
);
create table borrows(
id_borow int auto_increment primary key,
id_student int ,
id_book int ,
borrow_date varchar(50) not null,
return_date varchar(50) not null,
foreign key (id_student) references students(id_student),
foreign key (id_book) references books(id_book)
);