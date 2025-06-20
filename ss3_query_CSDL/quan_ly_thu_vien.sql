

-- + Lấy ra toàn bộ sách có trong thư viện, cùng với tên thể loại và tác giả					
select b.title, a.name_authors,c.name_category  from books b join authors a on b.id_authors=a.id_authors
join categories c on b.id_category=c.id_category;

-- + Lấy ra danh sách các học viên đã từng mượn sách và sắp xếp danh sách theo theo tên từ a->z						
select distinct s.id_student, s.name_student
from students s join borrows b on s.id_student=b.id_student
order by s.name_student;

-- + Lấy ra  2 quyển sách được mượn nhiều nhất				
select count(bor.id_book) as so_lan_muon, b.title
 from borrows bor join books b on bor.id_book=b.id_book
 group by bor.id_book
 order by so_lan_muon desc
 limit 2;
 


  
