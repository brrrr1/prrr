insert into empleado (id, nombre, apellido, sueldo, foto, fecha_ingreso, fecha_salida) values (1, 'Rosario', 'Parrales', '200', 'https://i.imgur.com/UhWAG9g.png', '2010-08-02', '2014-03-10');
insert into empleado (id, nombre, apellido, sueldo, foto, fecha_ingreso, fecha_salida) values (2, 'Coque', 'Calatrava', '300', 'https://pbs.twimg.com/profile_images/3680406347/2dbbdb6aee547a6a800c5ef6b07be668_400x400.jpeg', '2011-05-05', '2018-06-15');

ALTER SEQUENCE empleado_seq RESTART WITH (52);

insert into producto (id, nombre, descripcion, likes, foto, precio, stock, dtype) values (1, 'Camiseta Mariscos Recio', 'Camiseta de hombre talla M con el logo de la empresa para demostrar al mundo que comes el mejor marisco.', 500, 'https://d2j6dbq0eux0bg.cloudfront.net/images/48014374/2085608477.jpg', 15, 300, 'MER');
insert into producto (id, nombre, descripcion, likes, foto, precio, stock, dtype) values (2, 'Taza Mariscos Recio', 'Brillante y resistente taza de porcelana para disfrutar de un ColaCao con magdalenas como dios manda.', 234, 'https://i.ebayimg.com/images/g/CLEAAOSwyeRk~jxq/s-l1600.jpg', 6, 60, 'MER');
insert into producto (id, nombre, descripcion, likes, foto, precio, stock, dtype) values (3, 'Llavero Mariscos Recio', 'Llavero de acero inoxidable con algunas de las frases celebres del comercio.', 112, 'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.ebay.es%2Fitm%2F132907495777&psig=AOvVaw1wedIKcPWggLWVxOGiQn_p&ust=1715243332305000&source=images&cd=vfe&opi=89978449&ved=0CBAQjRxqFwoTCJiKw7_R_YUDFQAAAAAdAAAAABAI', 3, 100, 'M');
insert into producto (id, nombre, descripcion, likes, foto, precio, stock, dtype) values (4, 'Imán Nevera Mariscos Recio', 'Imán decorativo con el logo de la empresa que le hará recordar nuestro delicioso género siempre que abra la nevera', 80, 'https://i.ebayimg.com/images/g/zXUAAOSwy69iMOvP/s-l1200.webp', 2, 45, 'MER');
insert into producto (id, nombre, descripcion, likes, foto, precio, stock, dtype) values (5, 'Cena de Gala', 'Si quiere una cena de gala, llévese una cigala. Este lote contiene 4kg de cigala que le permitirán alimentar a hasta 5 personas.', 37, 'http://dummyimage.com/243x100.png/dddddd/000000', 150, 3, 'L');


insert into producto (id, nombre, descripcion, likes, foto, precio, stock, dtype) values (6, 'Lubina', 'Si quiere una cena muy fina...¡Llévese una lubina!', 75, 'https://www.lavanguardia.com/files/article_main_microformat/uploads/2018/12/14/5e9981374ee6b.jpeg', 22, 100, 'PESC');
insert into producto (id, nombre, descripcion, likes, foto, precio, stock, dtype) values (7, 'Bogavante', 'Si quiere una cena elegante... ¡Llévese un bogavante!', 120, 'https://www.gastronomiavasca.net/uploads/image/file/3235/w700_bogavante.jpg', 75, 130, 'MAR');

ALTER SEQUENCE producto_seq RESTART WITH (57);

<<<<<<< HEAD
insert into usuario (id, nombre, apellido, dni, email, contrasenia, num_pedidos, direccion, es_admin, es_empleado) values (1, 'Antonio', 'Recio', '12345678A', 'antonio@mariscosrecio.es', '{bcrypt}$2y$10$wpXa1B8IRW0d/1..KPY5/.B2O8ZMa1GiRh.Zl1H/OpTLjDV0Ul3WC', '0', 'Mirador de Montepinar 7 1ºC', true, false);
insert into usuario (id, nombre, apellido, dni, email, contrasenia, num_pedidos, direccion, es_admin, es_empleado) values (2, 'Fermín', 'Trujillo', '12345678B', 'ferminespetos69@gmail.com', '{bcrypt}$2y$10$2iYT.xzHjlcDAE28.74YneNx52704u1/N88bgrqcZUN.6cSkmUPS.', '6', 'Mirador de Montepinar 7 2ºB', false, false);
=======



insert into usuario (id, username, nombre, apellido, dni, email, password, num_pedidos, direccion, es_admin, es_empleado) values (1, 'admin', 'Antonio','Recio', '12345678A', 'antonio@mariscosrecio.es', '{bcrypt}$2y$10$wpXa1B8IRW0d/1..KPY5/.B2O8ZMa1GiRh.Zl1H/OpTLjDV0Ul3WC', '0', 'Mirador de Montepinar 7 1ºC', true, false);
insert into usuario (id, username, nombre, apellido, dni, email, password, num_pedidos, direccion, es_admin, es_empleado) values (2, 'user', 'Fermín','Trujillo', '12345678B', 'ferminespetos69@gmail.com', '{bcrypt}$2y$10$2iYT.xzHjlcDAE28.74YneNx52704u1/N88bgrqcZUN.6cSkmUPS.', '0', 'Mirador de Montepinar 7 2ºB', false, true);
>>>>>>> 816c37d10c81ccb8fea96f1ad25a823773200cc4

ALTER SEQUENCE usuario_seq RESTART WITH (52);