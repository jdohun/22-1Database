drop database cafe;
create database cafe; 
use cafe;

create table cafeMenus ( /* m : menu*/
	category varchar(20) not null,
    mNum char(4) primary key,
    mName varchar(20) not null,
	mPrice int not null
);

create table cafeOptions ( /* op : option */
	opNum char(4) not null primary key,
    opName varchar(10) not null,
    opPrice int not null,
    required char(1) not null
);

create table cart ( 
	mNum char(4) not null,
    cOptions varchar(40) not null, /* choiced Options */
    cQuantity int not null, /* cart Quantity */
    cPrice int not null, /* cart Price */
    foreign key(mNum) references cafeMenus(mNum),
    primary key(mNum, cOptions)
);

create table membership (
	phoneNumber char(11) primary key,
	memberName varchar(10) not null,
    birth char(8) not null,
    mileage int default 0 not null
);

create table orderHistory(
	odNum char(13) not null,
	consumer char(11), /* 비회원 null 입력 받음*/
    totalPrice int not null,
    odTime timestamp default current_timestamp not null,
    foreign key(consumer) references membership(phoneNumber),
    primary key(odNum)
);

create table orderDetail ( /* od : order */
	odNum char(13) not null,
	mNum char(4) not null,
    cOptions varchar(40) not null,
    odQuantity int not null,
    odPrice int not null,
    foreign key(mNum) references cafeMenus(mNum),
    foreign key(odNum) references orderHistory(odNum),
    primary key(odNum, mNum)
);

insert into cafemenus values('커피', 'M001', '에스프레소', 1500);
insert into cafemenus values('커피', 'M002', '아메리카노', 1500);
insert into cafemenus values('커피', 'M003', '카푸치노', 2700);
insert into cafemenus values('커피', 'M004', '카페라떼', 2700);
insert into cafemenus values('커피', 'M005', '바닐라라떼', 3000);
insert into cafemenus values('커피', 'M006', '카페모카', 3300);

insert into cafemenus values('논커피', 'M007', '더블초코라떼', 3500);
insert into cafemenus values('논커피', 'M008', '쿠키초코라떼', 3500);
insert into cafemenus values('논커피', 'M009', '민트초코오레오라떼', 3500);
insert into cafemenus values('논커피', 'M010', '그린티라떼', 3500);
insert into cafemenus values('논커피', 'M011', '곡물라떼', 3000);
insert into cafemenus values('논커피', 'M012', '고구마라떼', 3300);

insert into cafemenus values('에이드/주스', 'M013', '레몬에이드', 3500);
insert into cafemenus values('에이드/주스', 'M014', '자몽에이드', 3500);
insert into cafemenus values('에이드/주스', 'M015', '망고에이드', 3500);
insert into cafemenus values('에이드/주스', 'M016', '유자에이드', 3500);
insert into cafemenus values('에이드/주스', 'M017', '청포도에이드', 3500);
insert into cafemenus values('에이드/주스', 'M018', '블루레몬에이드', 3500);

insert into cafeoptions values("O001", '핫', 0, 'Y');
insert into cafeoptions values("O002", '아이스', 0, 'Y');
insert into cafeoptions values("O003", '바닐라시럽', 500, 'N');
insert into cafeoptions values("O004", '헤이즐넛시럽', 500, 'N');
insert into cafeoptions values("O005", '휘핑크림', 500, 'N');
insert into cafeoptions values("O006", '샷추가', 500, 'N');
insert into cafeoptions values("O007", '펄추가', 700, 'N');

insert into membership values("01012345678", "정도훈", "19970416", 0);