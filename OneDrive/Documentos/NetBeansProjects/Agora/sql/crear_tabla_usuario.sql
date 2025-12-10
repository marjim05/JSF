-- Script SQL para crear la tabla de usuarios
-- Ejecutar este script en la base de datos 'prueba'

CREATE TABLE IF NOT EXISTS usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    rol VARCHAR(50) DEFAULT 'usuario'
);

-- Insertar usuario de ejemplo (admin/admin)
-- NOTA: En producción, las contraseñas deben estar encriptadas
INSERT INTO usuario (nombre, email, password, rol) 
VALUES ('Administrador', 'admin@agora.com', 'admin', 'admin')
ON DUPLICATE KEY UPDATE nombre=nombre;

-- Insertar usuario de ejemplo (usuario/usuario)
INSERT INTO usuario (nombre, email, password, rol) 
VALUES ('Usuario Test', 'usuario@agora.com', 'usuario', 'usuario')
ON DUPLICATE KEY UPDATE nombre=nombre;



