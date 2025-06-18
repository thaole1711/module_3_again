create database quan_ly_thu_vien;
use quan_ly_thu_vien;

create table students(
id_student int  auto_increment primary key,
name_student varchar(100),
birthday varchar(100),
class_name varchar(50)
);
create table category(
id_category int  auto_increment primary key,
name_category varchar(100)
);
create table authors(
id_authors int auto_increment primary key,
name_authors varchar(100)
);
create table books(
id_book int  auto_increment primary key,
title varchar(100),
page_size int,
id_category int,
id_authors int ,
foreign key (id_category) references category(id_category),
foreign key (id_authors) references authors(id_authors)
);
create table borrows(
id_borow int auto_increment primary key,
id_student int,
id_book int,
borrow_date varchar(50),
return_date varchar(50),
foreign key (id_student) references students(id_student),
foreign key (id_book) references books(id_book)
);