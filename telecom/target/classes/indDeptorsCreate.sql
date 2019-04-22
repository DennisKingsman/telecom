create table individual_debtors(
	individ_id SERIAL,
	given_name varchar(30) not null,
	sur_name varchar(30) not null,
	patronymic varchar(30) not null,
	passport_seria integer not null,
	passport_num integer not null
);