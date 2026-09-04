insert into Bodegas(nombre, ubicacion, capacidad) values
("BucaraLogi", "Bucaramanga", 15000);

insert into Empleados(nombre, email, tipo_documento, documento, cargo, bodega_id)
values
('Admin', 'admind@admin.com', 'Cedula', 1099744303, 'Admin', 1);

insert into Usuarios(empleado_id, usuario, contrasenia)
values
(1, 'Admin', 'PasswordIsIncorrect');

insert into Productos(nombre, descripcion, stock, precio_compra, precio_venta) values
("Televisor", "Televisor de 80 pulgadas ultra hd 4K", 2, 3000, 6000, 1),
("Swith 2", "Nintendo swith 2", 500, 1000, 2000, 1),
("Nevera", "Nevera increible que funciona", 1000, 2000, 4000, 1);

// Contiene la informacion pedida en el examen
