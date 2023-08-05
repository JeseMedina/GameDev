-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-08-2023 a las 16:06:08
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `game-dev`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `desarrolladores`
--

CREATE TABLE `desarrolladores` (
  `id` int(11) NOT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `rol` tinyint(4) DEFAULT NULL,
  `juego_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `desarrolladores`
--

INSERT INTO `desarrolladores` (`id`, `correo`, `nombre`, `rol`, `juego_id`) VALUES
(1, 'juan@example.com', 'Juan Perez', 0, 2),
(2, 'juanmessi@example.com', 'Juan Carlos messi', 1, 7),
(3, 'jese@gmail.com', 'Jesé', 2, 8),
(4, 'jose@gmail.com', 'Jose', 1, 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `juegos`
--

CREATE TABLE `juegos` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `fecha_lanzamiento` date DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `juegos`
--

INSERT INTO `juegos` (`id`, `descripcion`, `fecha_lanzamiento`, `titulo`) VALUES
(1, 'Un emocionante juego de aventuras', '2023-07-22', 'Mi Juego'),
(2, 'Un emocionante juego de aventuras', '2023-08-22', 'meu jogo'),
(4, 'Un emocionante juego de aventuras', '2023-07-22', 'My game'),
(5, 'Meu Deus', '2023-07-22', 'Meu Deus'),
(7, 'piu piu', '2024-06-01', 'Carlos Duty'),
(8, 'Link ncq', '2023-08-10', 'Zelda'),
(9, 'Link ncq2', '2025-08-10', 'Zelda2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tareas`
--

CREATE TABLE `tareas` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `estado` tinyint(4) DEFAULT NULL,
  `fecha_limite` date DEFAULT NULL,
  `desarrollador_id` int(11) DEFAULT NULL,
  `juego_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tareas`
--

INSERT INTO `tareas` (`id`, `descripcion`, `estado`, `fecha_limite`, `desarrollador_id`, `juego_id`) VALUES
(1, 'Descripción de la tarea', 0, '2023-08-02', 1, 1),
(7, 'Detectar bugs', 1, '2023-08-03', 2, 7),
(8, 'Levantar servidor de Produccion', 2, '2023-08-09', 3, 8),
(9, 'reverificar bug id001', 0, '2023-08-07', 4, 8);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `desarrolladores`
--
ALTER TABLE `desarrolladores`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKpo14kxyfsn4x0nnfyc2mywf1u` (`juego_id`);

--
-- Indices de la tabla `juegos`
--
ALTER TABLE `juegos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tareas`
--
ALTER TABLE `tareas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKsjvhpemsvvvwgqn1v252xhptg` (`desarrollador_id`),
  ADD KEY `FK524xo3n798ni7y19nl3c03ttg` (`juego_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `desarrolladores`
--
ALTER TABLE `desarrolladores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `juegos`
--
ALTER TABLE `juegos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `tareas`
--
ALTER TABLE `tareas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `desarrolladores`
--
ALTER TABLE `desarrolladores`
  ADD CONSTRAINT `FKpo14kxyfsn4x0nnfyc2mywf1u` FOREIGN KEY (`juego_id`) REFERENCES `juegos` (`id`);

--
-- Filtros para la tabla `tareas`
--
ALTER TABLE `tareas`
  ADD CONSTRAINT `FK524xo3n798ni7y19nl3c03ttg` FOREIGN KEY (`juego_id`) REFERENCES `juegos` (`id`),
  ADD CONSTRAINT `FKsjvhpemsvvvwgqn1v252xhptg` FOREIGN KEY (`desarrollador_id`) REFERENCES `desarrolladores` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
