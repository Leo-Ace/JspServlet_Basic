create database ProductBKAP;
go
use ProductBKAP;
go

create table products(
	productId varchar(10) primary key,
	productName nvarchar(150) not null,
	price int ,
	quantity int,
	description nvarchar(255) ,
	status bit
)
go

insert into products values('id1', 'name1', 1, 1, 'description1', 1),
('id2', 'name2', 2, 2, 'description2', 2),
('id3', 'name3', 3, 3, 'description3', 3),
('id4', 'name4', 4, 4, 'description4', 4),
('id5', 'name5', 5, 5, 'description5', 5);