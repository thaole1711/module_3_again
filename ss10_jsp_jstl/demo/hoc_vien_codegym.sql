create database hoc_vien_codegym;
 use hoc_vien_codegym;

 create table xep_loai(
  ma_loai int primary key auto_increment,
  ten_loai varchar(50) not null
  );
  create table hoc_sinh(
   ma_hs int primary key auto_increment,
   ten_hs varchar(200) not null,
   gioi_tinh varchar(10),
   diem double not null,
   ma_loai int,
   foreign key (ma_loai) references xep_loai(ma_loai)
   );
   INSERT INTO xep_loai (ten_loai) VALUES
('Giỏi'),
('Khá'),
('Trung bình'),
('Yếu');
INSERT INTO hoc_sinh (ten_hs, gioi_tinh, diem, ma_loai) VALUES
('Nguyễn Văn A', 'Nam', 9.0, 1),     -- Giỏi
('Trần Thị B', 'Nữ', 8.2, 1),        -- Giỏi
('Lê Văn C', 'Nam', 7.0, 2),         -- Khá
('Phạm Thị D', 'Nữ', 6.2, 2),        -- Khá
('Vũ Văn E', 'Nam', 5.0, 3),         -- Trung bình
('Ngô Thị F', 'Nữ', 3.5, 4);         -- Yếu
