create table book (id int8 not null, name varchar(255), author varchar(255), release varchar(255), private_catalog boolean not null, primary key (id));

insert into book (id, name, author, release, private_catalog) values 
(1, 'Капитанская дочка', 'А. С. Пушкин', '1836', false),
(2, 'Дубровский', 'А. С. Пушкин', '1841', false),
(3, 'Сто лет одиночества', 'Габриэль Гарсия Маркес', '1982', true),
(4, 'Алые Паруса', 'А. Грин', '1923', true),
(5, 'Java. Полное руководство', 'Герберт Шилдт', '2018', true),
(6, 'Java. Справочник разработчика', 'Бенджамин Дж. Эванс', '2019', true),
(7, 'Философия Java Java', 'Брюс Эккель', '2015', false),
(8, 'Spring в действии 6', 'Крейг Уоллс', '2022', true);

create sequence hibernate_sequence start 9 increment 1;