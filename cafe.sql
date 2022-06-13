drop database cafe;
create database cafe; 
use cafe;

create table cafeMenus ( /* m : menu*/
	category varchar(20) not null,
    mNum int primary key,
    mName varchar(20) not null,
	mPrice int not null
);

create table cafeOptions ( /* op : option */
	opNum int not null primary key,
    opName varchar(10) not null,
    opPrice int not null,
    required char(1) not null
);

create table cart ( 
	mNum int not null,
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
	odNum char(11) not null,
	consumer char(11) not null,
    totalPrice int not null,
    odTime timestamp default current_timestamp not null,
    foreign key(consumer) references membership(phoneNumber),
    primary key(odNum)
);

create table orderDetail ( /* od : order */
	odNum char(11) not null,
	mNum int not null,
    cOptions varchar(40) not null,
    odQuantity int not null,
    odPrice int not null,
    foreign key(mNum) references cafeMenus(mNum),
    foreign key(odNum) references orderHistory(odNum),
    primary key(odNum, mNum)
);