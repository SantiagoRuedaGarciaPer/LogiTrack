USE LogiTrack;

insert into Empleados(nombre, email, tipo_documento, documento, cargo)
values
('Admin', 'admin@admin.com', 'Cedula', 1099744304, 'Admin');

insert into Usuarios(empleado_id, usuario, contrasenia)
values
(1, 'Admin', 'PasswordIsIncorrect');

-- Triggers empleado
create trigger Insercion_empleados
AFTER INSERT on Empleados
FOR EACH ROW
BEGIN
	insert into Logs(mensaje)
	values
	(CONCAT('Nuevo empleado registrado ',NEW.nombre,'. con el cargo de ',NEW.cargo));
END

create trigger Actualizacion_empleados
AFTER UPDATE on Empleados
FOR EACH ROW
BEGIN
	insert into Logs(mensaje)
	values
	(CONCAT('Empleado actualizado con id ',OLD.id ,' Con nombre',NEW.nombre,'. con el cargo de ',NEW.cargo));
END

create trigger Eliminacion_empleados
AFTER DELETE on Empleados
FOR EACH ROW
BEGIN
	insert into Logs(mensaje)
	values
	(CONCAT('Empleado eliminado ',old.id, ' ', old.nombre,'. con el cargo de ',old.cargo));
END

-- Triggers usuarios
create trigger Insercion_usuario
AFTER INSERT on Usuarios
FOR EACH ROW
BEGIN
	insert into Logs(mensaje)
	values
	(CONCAT('Nuevo usuario registrado ',NEW.usuario));
END

create trigger Actualizacion_usuario
AFTER UPDATE on Usuarios
FOR EACH ROW
BEGIN
	insert into Logs(mensaje)
	values
	(CONCAT('Usuario actualizado con id ',OLD.id));
END

create trigger Eliminacion_usuario
AFTER DELETE on Usuarios
FOR EACH ROW
BEGIN
	insert into Logs(mensaje)
	values
	(CONCAT('Usuario eliminado ',old.id));
END

-- Triggers Productos
create trigger Insercion_productos
AFTER INSERT on Productos
FOR EACH ROW
BEGIN
	insert into Logs(mensaje)
	values
	(CONCAT('Nuevo producto registrado ',NEW.nombre, ' ', NEW.descripcion));
END

create trigger Actualizacion_productos
AFTER UPDATE on Productos
FOR EACH ROW
BEGIN
	insert into Logs(mensaje)
	values
	(CONCAT('Producto actualizado con id ',OLD.id , ' ', new.nombre));
END

create trigger Eliminacion_productos
AFTER DELETE on Productos
FOR EACH ROW
BEGIN
	insert into Logs(mensaje)
	values
	(CONCAT('Producto eliminado ',old.id, ' ', old.nombre));
END

-- Triggers bodegas
create trigger Insercion_bodegas
AFTER INSERT on Bodegas
FOR EACH ROW
BEGIN
	insert into Logs(mensaje)
	values
	(CONCAT('Nuevo bodega registrada ',NEW.nombre,' ',NEW.ubicacion));
END

create trigger Actualizacion_bodegas
AFTER UPDATE on Bodegas
FOR EACH ROW
BEGIN
	insert into Logs(mensaje)
	values
	(CONCAT('Bodega actualizada con id ',OLD.id ,' Con nombre',NEW.nombre,' ubicada en ',NEW.ubicacion));
END

create trigger Eliminacion_bodegas
AFTER DELETE on Bodegas
FOR EACH ROW
BEGIN
	insert into Logs(mensaje)
	values
	(CONCAT('Bodega eliminada ',old.id, ' ', old.nombre,'. Ubicada en ',old.ubicacion));
END


