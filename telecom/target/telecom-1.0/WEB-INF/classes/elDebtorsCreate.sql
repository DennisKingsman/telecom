create table le_debtors(
	le_d_id SERIAL,
	given_name varchar(30) not null,
	sur_name varchar(30) not null,
	patronymic varchar(30) not null,
	ogrn_num bigint not null
);