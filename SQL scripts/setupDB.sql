CREATE DATABASE "DBfoRESTful"
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Russian_Russia.1251'
    LC_CTYPE = 'Russian_Russia.1251'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

CREATE TABLE customer(
   customer_id serial PRIMARY KEY,
   lastname VARCHAR (50) NOT NULL,
   district VARCHAR (50) NOT NULL,
   discount NUMERIC (5, 2)
);

select * from customer;

insert into customer (lastname, district, discount) values ('Фильченко', 'Сормовский', 12.5);
insert into customer (lastname, district, discount) values ('Котов', 'Автозаводский', 1);
insert into customer (lastname, district, discount) values ('Витальев', 'Сормовский', 10);
insert into customer (lastname, district, discount) values ('Никанорченко', 'Нижегородский', 14);
insert into customer (lastname, district, discount) values ('Лукоев', 'Автозаводский', 30);