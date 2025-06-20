select* from category;
select* from authors;
select* from students;
select* from books;
select* from borrows;

-- - Thông kê các đầu sách được mượn nhiều nhất				
select count(b.id_book) as so_luong ,b.title
 from borrows bor join books b on bor.id_book=b.id_book
 group by b.id_book
 having so_luong =(select  count(b.id_book) as so_luong  from borrows bor join books b on bor.id_book=b.id_book
group by b.id_book  order by count(b.id_book) desc limit 1 );

	-- - Thông kê các đầu sách chưa được mượn				
select b.id_book, b.title from books b  left join borrows bor on b.id_book=bor.id_book 
 where b.id_book not in
 (select bor.id_book from books b join borrows bor on b.id_book=bor.id_book );
 	
    -- - Lấy ra danh sách các học viên đã từng mượn sách và sắp xếp  theo số lượng mượn sách từ lớn đến nhỏ					
select count(s.id_student) as so_luong, s.name_student
 from borrows bor join students s  on s.id_student=bor.id_student
 group by s.id_student
 order by so_luong desc;

--  - Lấy ra các học viên mượn sách nhiều nhất của thư viện				
 select s.name_student , count(s.id_student) as so_luong from borrows bor join students s  on s.id_student=bor.id_student
  group by s.id_student
  having so_luong=( select count(s.id_student) as so_luong
 from borrows bor join students s  on s.id_student=bor.id_student
 group by s.id_student
 order by so_luong desc
 limit 1);

 

