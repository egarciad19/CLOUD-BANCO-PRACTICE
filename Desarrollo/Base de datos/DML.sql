-- INSERT DE BASE DE DATOS DE PRESTAMO
-- TIPO DE BASE DE DATOS POSTGRES SQL
-- TIPO DE SCRIPT  DML

-- CATALOGOS PADRE
INSERT INTO banco.catalogos
(codigo_catalogo, nombre, descripcion, fecha_creacion, usuario_creacion, ip_usuario_creacion, fecha_modificacion, usuario_modificacion, ip_usuario_modificacion)
VALUES(1, 'ESTADOS', 'ESTADOS', now(), 'FERNANDO', '1.1.1.1', null, null, null);
INSERT INTO banco.catalogos
(codigo_catalogo, nombre, descripcion, fecha_creacion, usuario_creacion, ip_usuario_creacion, fecha_modificacion, usuario_modificacion, ip_usuario_modificacion)
VALUES(2, 'ESTADOS SOLICITUD', 'ESTADOS SOLICITUD', now(), 'FERNANDO', '1.1.1.1', null, null, null);
INSERT INTO banco.catalogos
(codigo_catalogo, nombre, descripcion, fecha_creacion, usuario_creacion, ip_usuario_creacion, fecha_modificacion, usuario_modificacion, ip_usuario_modificacion)
VALUES(3, 'ESTADOS DE PRESTAMO', 'ESTADOS DE PRESTAMO', now(), 'FERNANDO', '1.1.1.1', null, null, null);

-- CATALOGO DE ESTADO ACTIVO/INACTIVO
INSERT INTO banco.datos_catalogos
(codigo_dato_catalogo, codigo_catalogo, nombre, descripcion, fecha_creacion, usuario_creacion, ip_usuario_creacion, fecha_modificacion, usuario_modificacion, ip_usuario_modificacion)
VALUES(1, 1, 'ACTIVO', 'ACTIVO', now(), 'FERNANDO', '1.1.1.1', null, null, null);
INSERT INTO banco.datos_catalogos
(codigo_dato_catalogo, codigo_catalogo, nombre, descripcion, fecha_creacion, usuario_creacion, ip_usuario_creacion, fecha_modificacion, usuario_modificacion, ip_usuario_modificacion)
VALUES(2, 1, 'INACTIVO', 'INACTIVO', now(), 'FERNANDO', '1.1.1.1', null, null, null);

-- CATALOGO DE ESTADO DE SOLICITUD
INSERT INTO banco.datos_catalogos
(codigo_dato_catalogo, codigo_catalogo, nombre, descripcion, fecha_creacion, usuario_creacion, ip_usuario_creacion, fecha_modificacion, usuario_modificacion, ip_usuario_modificacion)
VALUES(4, 2, 'APROBADA', 'APROBADA', now(), 'FERNANDO', '1.1.1.1', null, null, null);
INSERT INTO banco.datos_catalogos
(codigo_dato_catalogo, codigo_catalogo, nombre, descripcion, fecha_creacion, usuario_creacion, ip_usuario_creacion, fecha_modificacion, usuario_modificacion, ip_usuario_modificacion)
VALUES(5, 2, 'RECHAZADA', 'RECHAZADA', now(), 'FERNANDO', '1.1.1.1', null, null, null);
INSERT INTO banco.datos_catalogos
(codigo_dato_catalogo, codigo_catalogo, nombre, descripcion, fecha_creacion, usuario_creacion, ip_usuario_creacion, fecha_modificacion, usuario_modificacion, ip_usuario_modificacion)
VALUES(6, 2, 'EN PROCESO', 'EN PROCESO', now(), 'FERNANDO', '1.1.1.1', null, null, null);

-- CATALOGO DE ESTADO DE PAGO
INSERT INTO banco.datos_catalogos
(codigo_dato_catalogo, codigo_catalogo, nombre, descripcion, fecha_creacion, usuario_creacion, ip_usuario_creacion, fecha_modificacion, usuario_modificacion, ip_usuario_modificacion)
VALUES(7, 3, 'PAGO COMPLETO', 'PAGO COMPLETO', now(), 'FERNANDO', '1.1.1.1', null, null, null);
INSERT INTO banco.datos_catalogos
(codigo_dato_catalogo, codigo_catalogo, nombre, descripcion, fecha_creacion, usuario_creacion, ip_usuario_creacion, fecha_modificacion, usuario_modificacion, ip_usuario_modificacion)
VALUES(8, 3, 'PENDIENTE DE PAGO', 'PENDIENTE DE PAGO', now(), 'FERNANDO', '1.1.1.1', null, null, null);