insert into client (id, name) values (1, 'José Silva');
insert into client (id, name) values (2, 'Ana Maria');

insert into product (id, name, price) values (1, 'Maquina de Lavar', 1100.0);
insert into product (id, name, price) values (2, 'SmartTV 32 Led', 1500.0);
insert into product (id, name, price) values (3, 'SmartPhone ', 1200.0);

insert into sale (id, client_id, freight, total, register) values (1, 1, 15.0, 1150.0, sysdate());

insert into item (id, sale_id, product_id, amount) values (1, 1, 1, 1);

