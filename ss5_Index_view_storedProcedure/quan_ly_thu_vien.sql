use quan_ly_thu_vien;
select * from books;
select * from borrows;

-- - Tao index cho cột  title của bảng books			
create index i_title on books(title); 
select count(*) from books;

-- alter table books add index i_title(title);-- 
-- explain select count(*) from books;
-- drop index i_title on books;

-- - Tạo 1 view để lấy ra danh sách các quyển sách đã được mượn, có hiển thị thêm cột số lần đã được mượn					
create view v_book as 
select  b.title,count(b.id_book) as so_luong
 from books b join borrows bor on b.id_book= bor.id_book
 group by b.id_book;
 select * from v_book;
 
--  - Viết 1 stored procedure thêm mới book trong database với tham số kiểu IN	
DELIMITER //
create procedure add_book( IN p_id_book int,p_title varchar(100),p_page_size int,p_id_category int,p_id_authors int)	
begin 
insert into books(id_book,title,page_size,id_category,id_authors)
values(p_id_book,p_title,p_page_size,p_id_category,p_id_authors);
end//
DELIMITER ;	

call add_book(8,"GDCD",40,1,2);

 