create database book_management;
use book_management;

create table books(
id int primary key not null auto_increment,
name varchar(100),
page_size int,
author varchar(200)
);

insert into books(id,name,page_size,author) values(1,"Toán",45,"Nguyễn Thái Học");
insert into books(id,name,page_size,author) values(2,"Văn",34,"Trần Minh Hoàng");
insert into books(id,name,page_size,author) values(3,"Sử",56,"Dương Trung Quốc");
insert into books(id,name,page_size,author) values(4,"Địa",76,"Lê Văn Hiến");
insert into books(id,name,page_size,author) values(5,"Hóa",32,"Hà Văn Minh");
select* from books;
SET SQL_SAFE_UPDATES = 0;
SET SQL_SAFE_UPDATES = 1;
update books  set page_size=50 where name='Sử';
delete from books where id=5;
truncate table books;
drop table books;