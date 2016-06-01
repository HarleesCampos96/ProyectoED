-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-06-2016 a las 18:55:03
-- Versión del servidor: 5.6.21
-- Versión de PHP: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `liga-completa`
--

GRANT ALL PRIVILEGES ON *.* TO 'gerente'@'localhost' IDENTIFIED BY PASSWORD '*0381DB54C17BCCAF6D415B04196018275B1950A6' WITH GRANT OPTION;

GRANT ALL PRIVILEGES ON `liga-completa`.* TO 'gerente'@'localhost' WITH GRANT OPTION;

CREATE DATABASE IF NOT EXISTS `liga-completa` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish2_ci;
USE `liga-completa`;

DELIMITER $$
--
-- Procedimientos
--
DROP PROCEDURE IF EXISTS `AgregarUsuarios`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `AgregarUsuarios`(IN `nom_usu` VARCHAR(20), IN `contraseña` VARCHAR(20), IN `cargo` VARCHAR(15))
    NO SQL
INSERT INTO usuarios VALUES (nom_usu, contraseña, cargo)$$

DROP PROCEDURE IF EXISTS `CrearLiga`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `CrearLiga`(IN `nomLiga` VARCHAR(25), IN `pais` VARCHAR(20))
    NO SQL
INSERT INTO liga VALUES (nomLiga, pais)$$

DROP PROCEDURE IF EXISTS `InsertarEntrenador`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertarEntrenador`(IN `DNI` VARCHAR(9), IN `nomEnt` VARCHAR(20), IN `apeEnt` VARCHAR(20), IN `sueldo` INT, IN `edad` INT)
    NO SQL
INSERT INTO entrenador values (DNI, nomEnt, apeEnt, sueldo, edad)$$

DROP PROCEDURE IF EXISTS `InsertarEquipo`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertarEquipo`(IN `nomEqui` VARCHAR(25), IN `localidad` VARCHAR(20), IN `nomEst` VARCHAR(25), IN `presupuesto` INT, IN `nomLiga` VARCHAR(25), IN `dniEnt` VARCHAR(9), IN `dniPre` VARCHAR(9))
    NO SQL
INSERT INTO equipo VALUES (nomEqui, localidad, nomEst, presupuesto, nomLiga, dniEnt, dniPre)$$

DROP PROCEDURE IF EXISTS `InsertarEstadio`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertarEstadio`(IN `nomEst` VARCHAR(25), IN `aforo` INT)
    NO SQL
INSERT INTO estadio VALUES (nomEst, aforo)$$

DROP PROCEDURE IF EXISTS `InsertarJugador`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertarJugador`(IN `dni` VARCHAR(9), IN `nomJug` VARCHAR(20), IN `apeJug` VARCHAR(20), IN `valor` INT, IN `edad` INT, IN `nomEqu` VARCHAR(25))
    NO SQL
INSERT INTO jugador VALUES(dni, nomJug, apeJug, valor, edad, nomEqu)$$

DROP PROCEDURE IF EXISTS `InsertarPresidente`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertarPresidente`(IN `DNI` VARCHAR(9), IN `nomPre` VARCHAR(20), IN `apePre` VARCHAR(20), IN `edad` INT)
    NO SQL
INSERT INTO presidente VALUES (DNI, nomPre, apePre, edad)$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrenador`
--

DROP TABLE IF EXISTS `entrenador`;
CREATE TABLE IF NOT EXISTS `entrenador` (
  `dni_entre` varchar(9) COLLATE utf8_spanish2_ci NOT NULL,
  `nom_entre` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `ape_entre` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `sueldo` int(11) NOT NULL,
  `edad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `entrenador`
--

INSERT INTO `entrenador` (`dni_entre`, `nom_entre`, `ape_entre`, `sueldo`, `edad`) VALUES
('12345678Y', 'PEDRO', 'TORRES', 35000, 39),
('32514132V', 'ADRIAN', 'JEDI', 36985, 85),
('52874132L', 'DAVID', 'OSOREZ', 25852, 58),
('64825347P', 'LUIS', 'ENRIQUE', 45620, 49),
('96258741V', 'ISRAEL', 'MARTINEZ', 65800, 35);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipo`
--

DROP TABLE IF EXISTS `equipo`;
CREATE TABLE IF NOT EXISTS `equipo` (
  `nom_equi` varchar(25) COLLATE utf8_spanish2_ci NOT NULL,
  `localidad` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `nom_estadio` varchar(25) COLLATE utf8_spanish2_ci NOT NULL,
  `presupuesto` int(11) NOT NULL,
  `nom_liga` varchar(25) COLLATE utf8_spanish2_ci NOT NULL,
  `dni_entre` varchar(9) COLLATE utf8_spanish2_ci NOT NULL,
  `dni_presi` varchar(9) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `equipo`
--

INSERT INTO `equipo` (`nom_equi`, `localidad`, `nom_estadio`, `presupuesto`, `nom_liga`, `dni_entre`, `dni_presi`) VALUES
('BARCELONA', 'CATALUÑA', 'NOU CAMP', 85218524, 'LigaBBVA', '64825347P', '96385214P'),
('F.C. BETIS', 'BETIS', 'LA PERLA', 562135421, 'LigaBBVA', '32514132V', '21219852K'),
('F.C. RAYO', 'BETIS', 'ANOETA', 851232500, 'LigaBBVA', '96258741V', '96385214P'),
('REAL MADRID', 'MADRID', 'SANTIAGO BERNABEU', 500000000, 'LigaBBVA', '12345678Y', '52463274U');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estadio`
--

DROP TABLE IF EXISTS `estadio`;
CREATE TABLE IF NOT EXISTS `estadio` (
  `nom_estadio` varchar(25) COLLATE utf8_spanish2_ci NOT NULL,
  `aforo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `estadio`
--

INSERT INTO `estadio` (`nom_estadio`, `aforo`) VALUES
('ANOETA', 69820),
('LA PERLA', 58000),
('NACIONAL', 85300),
('NOU CAMP', 75350),
('SANTIAGO BERNABEU', 75000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugador`
--

DROP TABLE IF EXISTS `jugador`;
CREATE TABLE IF NOT EXISTS `jugador` (
  `dni` varchar(9) COLLATE utf8_spanish2_ci NOT NULL,
  `nom_juga` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `ape_juga` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `valor` int(11) NOT NULL,
  `edad` int(11) NOT NULL,
  `nom_equi` varchar(25) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `jugador`
--

INSERT INTO `jugador` (`dni`, `nom_juga`, `ape_juga`, `valor`, `edad`, `nom_equi`) VALUES
('32548236Y', 'JUNIOR', 'NEYMAR', 100152201, 26, 'BARCELONA'),
('36521864Q', 'AMADOR', 'LECCA', 35000252, 21, 'F.C. BETIS'),
('52874136P', 'CRISTIANO', 'RONALDO', 250300000, 31, 'REAL MADRID'),
('63258741Z', 'MARCELO', 'GARCIA', 85125456, 26, 'REAL MADRID'),
('85214745H', 'MIGUEL', 'PEDRO', 72252201, 27, 'BARCELONA'),
('85236541L', 'KEVIN', 'LLORENTE', 12000521, 33, 'F.C. BETIS'),
('85246574A', 'IGNACIO', 'VARGAS', 2012201, 32, 'F.C. BETIS'),
('87125864G', 'FRANCIS', 'RILLOS', 35000111, 30, 'F.C. BETIS');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `liga`
--

DROP TABLE IF EXISTS `liga`;
CREATE TABLE IF NOT EXISTS `liga` (
  `nom_Liga` varchar(25) COLLATE utf8_spanish2_ci NOT NULL,
  `pais` varchar(20) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `liga`
--

INSERT INTO `liga` (`nom_Liga`, `pais`) VALUES
('LigaBBVA', 'ESPAÑA'),
('LigaFrancesa', 'FRANCIA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `presidente`
--

DROP TABLE IF EXISTS `presidente`;
CREATE TABLE IF NOT EXISTS `presidente` (
  `dni_presi` varchar(9) COLLATE utf8_spanish2_ci NOT NULL,
  `nom_presi` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `ape_presi` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `edad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `presidente`
--

INSERT INTO `presidente` (`dni_presi`, `nom_presi`, `ape_presi`, `edad`) VALUES
('21219852K', 'LUISA', 'MARTINEZ', 48),
('52463274U', 'CARLOS', 'PEREZ', 63),
('85214752K', 'MARIANO', 'SANCHEZ', 39),
('96385214P', 'GERSON', 'CONDE', 54);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `usuario` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `contraseña` varchar(20) COLLATE utf8_spanish2_ci NOT NULL,
  `cargo` varchar(15) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`usuario`, `contraseña`, `cargo`) VALUES
('ALEX', 'ABcd_12$', 'GERENTE'),
('GIAN', 'ABcd_13$', 'GERENTE'),
('JESUS', 'ABcd_1234$', 'SECRETARIO'),
('JUAN', 'CDef.12$', 'SECRETARIO'),
('LUIS', 'ABcd_56$', 'SECRETARIO'),
('MARIA', 'ABcd.12$', 'SECRETARIO'),
('MESSI', 'ABcd-12$', 'GERENTE'),
('QUIQUE', 'ABcd_12$', 'GERENTE');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `entrenador`
--
ALTER TABLE `entrenador`
 ADD PRIMARY KEY (`dni_entre`);

--
-- Indices de la tabla `equipo`
--
ALTER TABLE `equipo`
 ADD PRIMARY KEY (`nom_equi`), ADD KEY `nom_estadio` (`nom_estadio`), ADD KEY `nom_liga` (`nom_liga`), ADD KEY `dni_entre` (`dni_entre`), ADD KEY `dni_presi` (`dni_presi`);

--
-- Indices de la tabla `estadio`
--
ALTER TABLE `estadio`
 ADD PRIMARY KEY (`nom_estadio`);

--
-- Indices de la tabla `jugador`
--
ALTER TABLE `jugador`
 ADD PRIMARY KEY (`dni`), ADD KEY `nom_equi` (`nom_equi`);

--
-- Indices de la tabla `liga`
--
ALTER TABLE `liga`
 ADD PRIMARY KEY (`nom_Liga`);

--
-- Indices de la tabla `presidente`
--
ALTER TABLE `presidente`
 ADD PRIMARY KEY (`dni_presi`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
 ADD PRIMARY KEY (`usuario`), ADD UNIQUE KEY `nom_usu` (`usuario`,`contraseña`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `equipo`
--
ALTER TABLE `equipo`
ADD CONSTRAINT `equipo_ibfk_1` FOREIGN KEY (`nom_estadio`) REFERENCES `estadio` (`nom_estadio`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `equipo_ibfk_2` FOREIGN KEY (`nom_liga`) REFERENCES `liga` (`nom_Liga`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `equipo_ibfk_3` FOREIGN KEY (`dni_entre`) REFERENCES `entrenador` (`dni_entre`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `equipo_ibfk_4` FOREIGN KEY (`dni_presi`) REFERENCES `presidente` (`dni_presi`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `jugador`
--
ALTER TABLE `jugador`
ADD CONSTRAINT `jugador_ibfk_1` FOREIGN KEY (`nom_equi`) REFERENCES `equipo` (`nom_equi`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
