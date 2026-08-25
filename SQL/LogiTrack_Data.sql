USE LogiTrack;

insert into Empleados(nombre, email, tipo_documento, documento, cargo)
values
('Admin', 'admin@admin.com', 'Cedula', 1099744304, 'Admin');

insert into Usuarios(empleado_id, usuario, contrasenia)
values
(1, 'Admin', '[YOUR_PASSWORD_HERE]');
