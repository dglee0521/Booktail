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

update bookCart
set cartStock=cartStock+1
where cartNum=10;

drop table bookCart;
alter table bookCart
    add constraint bookCart_userId foreign key(userId)
    references member(id);

alter table bookCart
    add constraint bookCart_gdsNum foreign key(gdsNum)
    references bookItem(gdsNum);
drop table bookCart;
delete from bookItem where ino=2;

select
     row_number() over(order by c.cartNum desc) as num,
     c.cartNum, c.userId, c.gdsNum, c.cartStock, c.addDate,
     g.title, g.price, g.salePrice,g.thumbnail
 from bookCart c inner join bookItem g on c.gdsNum = g.gdsNum where c.userId = 'ehdrb0457';
 
 create table bookOrder (
    orderId     varchar(50) not null, -- 주문고유번호
    userId      varchar(50) not null, -- 주문자
    orderRec    varchar(50) not null, -- 수신자
    userAddr1   varchar(20) not null, -- 우편번호
    userAddr2   varchar(50) not null, -- 기본주소
    userAddr3   varchar(50) not null, -- 상세주소
    orderPhone   varchar(30) not null,  
    amount      int      not null, -- 총 가격
    orderDate   datetime default now(),   -- 주문날짜
    primary key(orderId)
);
drop table bookOrder;
select * from bookOrder;
-- 하나의 주문에 여러 상품이 들어갈 수 있기 때문에 
create table bookOrder_details (
    orderDetailsNum int auto_increment,
    orderId         varchar(50) not null,
    gdsNum          int          not null,
    cartStock       int          not null,
    primary key(orderDetailsNum)
);
drop table bookOrder_details;
 insert into bookOrder_details(orderId, gdsNum, cartStock)
     select bookOrder_details_seq.nextval, #{orderId}, gdsNum, cartStock from bookCart   