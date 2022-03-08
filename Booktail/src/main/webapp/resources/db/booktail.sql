create database booktail;
use booktail;
create table member(
	id varchar(15) primary key,  -- 아이디
    password varchar(30) not null, -- 비밀번호
    name varchar(10) not null, -- 이름
    birth date not null, -- 생년월일 날짜
    gender varchar(2) not null,  -- 성별
    email varchar(30) not null,  -- 이메일
    phone varchar(15) not null,  -- 휴대폰 번호
    regdata datetime default now() -- 등록날짜
);
select * from member;
create table bookItem(
	gdsNum int primary key auto_increment,
    title varchar(100) not null,
    isbn varchar(30) not null,
    datetime varchar(30) not null,
    regdate datetime,
    thumbnail varchar(1000),
    authors varchar(100) not null,
    translators varchar(100),
    contents varchar(1000),
    publisher varchar(30),
    price int,
    salePrice int
);
drop table bookItem;
select * from bookItem;

create table bookCart (
	cartNum int auto_increment,
	userId varchar(50) not null,
	gdsNum int not null,
	cartStock int not null,
	addDate datetime default now(),
	primary key(cartNum, userId) 
);
select * from bookCart;
drop table bookCart;
alter table bookCart
    add constraint bookCart_userId foreign key(userId)
    references member(id);

alter table bookCart
    add constraint bookCart_gdsNum foreign key(gdsNum)
    references bookItem(gdsNum);
drop table bookCart;
delete from bookItem where ino=2;