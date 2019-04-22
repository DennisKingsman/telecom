create table client(
	order_id SERIAL,
	given_name varchar(30) not null,
	sur_name varchar(30) not null,
	patronymic varchar(30) not null,
	OGRN_num bigint,
	passport_num int,
	primary key(order_id)
);