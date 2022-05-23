create table 회원 (
	이름 varchar(8),
    핸드폰번호 int(11) primary key,
    나이 int(3),
    직업 varchar(20),
    적립금 int(8)
);

create table 카테고리 (
 카테고리번호 int(3) primary key,
 카테고리이름 varchar(20)
);

create table 온도(
	온도번호 int(1) primary key,
    온도 varchar(10)
);

create table 메뉴 (
	카테고리번호 int(3),
    메뉴번호 int(3) primary key,
    이름 varchar(20),
    온도번호 int(1),
    가격 int(5),
    foreign key(카테고리번호) references 카테고리(카테고리번호),
    foreign key(온도번호) references 온도(온도번호)
);

create table 옵션(
  옵션번호 int(3),
  이름 varchar(20),
  가격 int(5)
);

create table 주문기록(
	주문번호 int(12) primary key,
    주문자 int(11),
    메뉴번호 int(3),
    옵션번호 int(3),
    주문시각 date default sysdate,
    foreign key(주문자) references 회원(핸드폰번호),
    foreign key(메뉴번호) references 메뉴(메뉴번호),
    foreign key(옵션번호) references 옵션(옵션번호)
);
