-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 20, 2021 at 10:21 PM
-- Server version: 8.0.13-4
-- PHP Version: 7.2.24-0ubuntu0.18.04.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `BH2l2SghdC`
--

-- --------------------------------------------------------

--
-- Table structure for table `ciclo`
--

CREATE TABLE `ciclo` (
  `nombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `plazas` int(2) NOT NULL,
  `anno` int(1) NOT NULL,
  `instituto` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `ciclo`
--

INSERT INTO `ciclo` (`nombre`, `plazas`, `anno`, `instituto`) VALUES
('ASIR', 30, 1, 'camino'),
('Carro', 20, 1, 'camino'),
('Chapa y pintura', 20, 1, 'camino'),
('Ciencias', 20, 1, 'camino'),
('DAW', 20, 1, 'camino'),
('diseño', 2, 1, 'camino'),
('ESO', 22, 2, 'camino'),
('ESO', 1, 3, 'camino'),
('esso', 1, 2, 'camino'),
('esso', 4, 4, 'camino'),
('Farmacia', 33, 1, 'camino'),
('Mecanica', 20, 1, 'camino'),
('pelu', 1, 2, 'camino'),
('SMR', 22, 1, 'camino'),
('SMR', 33, 2, 'camino'),
('Stock', 1, 1, 'camino');

-- --------------------------------------------------------

--
-- Table structure for table `Eventos`
--

CREATE TABLE `Eventos` (
  `Mensaje` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `Fecha` date NOT NULL,
  `Modulo` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Ciclo` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Anno` int(11) NOT NULL,
  `Instituto` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `Eventos`
--

INSERT INTO `Eventos` (`Mensaje`, `Fecha`, `Modulo`, `Ciclo`, `Anno`, `Instituto`) VALUES
('Examen programacion', '2021-06-16', 'Programacion', 'DAW', 1, 'camino'),
('Fiesta fin de curso', '2021-06-18', 'Entornos', 'DAW', 1, 'camino'),
('Nombre del evento', '2021-06-17', 'Programacion', 'DAW', 1, 'camino'),
('Nombre del evento', '2021-06-16', 'Programacion', 'DAW', 1, 'camino'),
('Nombre del evento', '2021-06-16', 'Programacion', 'DAW', 1, 'camino'),
('control', '2021-09-01', 'Programacion', 'DAW', 1, 'camino'),
('a clase', '2021-10-07', 'Carroceria', 'Chapa y pintura', 1, 'camino');

-- --------------------------------------------------------

--
-- Table structure for table `instituto`
--

CREATE TABLE `instituto` (
  `nombre` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `direccion` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `tlfn` varchar(9) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `instituto`
--

INSERT INTO `instituto` (`nombre`, `direccion`, `tlfn`) VALUES
('camino', 'Calle miranda 29', '979745672');

-- --------------------------------------------------------

--
-- Table structure for table `modulo`
--

CREATE TABLE `modulo` (
  `nombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `codigoAula` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `horas_semana` int(2) NOT NULL,
  `ciclo` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `anno` int(11) NOT NULL,
  `profesor` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Instituto` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `modulo`
--

INSERT INTO `modulo` (`nombre`, `codigoAula`, `horas_semana`, `ciclo`, `anno`, `profesor`, `Instituto`) VALUES
('Carroceria', '03', 10, 'Chapa y pintura', 1, 'jero', 'camino'),
('coche', '02', 11, 'Carro', 1, '', 'camino'),
('corstesito', '02', 2, 'pelu', 1, '', 'camino'),
('Drogas', '03', 2, 'Farmacia', 1, '', 'camino'),
('Electromecanica', '03', 3, 'Chapa y pintura', 1, '', 'camino'),
('Entornos', '01', 3, 'DAW', 1, '', 'camino'),
('FOL', '01', 4, 'DAW', 1, 'Cesar', 'camino'),
('interiores', '', 23, 'diseño', 1, '', 'camino'),
('LEngua', '01', 30, 'ESO', 3, 'Marcos', 'camino'),
('LEngua', '02', 30, 'esso', 2, 'Marcos', 'camino'),
('mate', '01', 30, 'ESO', 1, '', 'camino'),
('Mate', '01', 4, 'Eso', 1, 'Pedro', 'Trini'),
('MATE', '01', 30, 'ESO', 2, '', 'camino'),
('mate', '4', 30, 'esso', 4, '', 'camino'),
('Musi', '12', 1, 'ESO', 2, '', 'camino'),
('Programacion', '01', 8, 'DAW', 1, 'jero', 'camino');

-- --------------------------------------------------------

--
-- Table structure for table `nota`
--

CREATE TABLE `nota` (
  `alumno` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `modulo` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `nota` int(2) NOT NULL,
  `instituto` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `nota`
--

INSERT INTO `nota` (`alumno`, `modulo`, `nota`, `instituto`) VALUES
('Dani', 'Entornos', 1, 'camino'),
('Dani', 'Entornos', 2, 'camino'),
('Dani', 'Entornos', 1, 'camino'),
('miguel', 'Programacion', 4, 'camino'),
('miguel', 'Programacion', 5, 'camino'),
('miguel', 'Programacion', 10, 'camino'),
('miguel', 'Entornos', 2, 'camino'),
('miguel', 'Entornos', 8, 'camino'),
('miguel', 'Entornos', 4, 'camino'),
('fer', 'Entornos', 4, 'camino'),
('fer', 'Entornos', 6, 'camino'),
('fer', 'Entornos', 1, 'camino'),
('fer', 'Programacion', 9, 'camino'),
('fer', 'Programacion', 6, 'camino'),
('fer', 'Programacion', 5, 'camino'),
('miguel', 'FOL', 7, 'camino'),
('miguel', 'FOL', 4, 'camino'),
('miguel', 'FOL', 5, 'camino'),
('Dani', 'Programacion', 1, 'camino'),
('Dani', 'Programacion', 2, 'camino'),
('Dani', 'Programacion', 1, 'camino');

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE `usuario` (
  `nombre` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `contra` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DNI` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fechaNac` date DEFAULT NULL,
  `tipo` varchar(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `ciclo` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ano` int(11) NOT NULL,
  `nombreInsti` varchar(10) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`nombre`, `contra`, `DNI`, `fechaNac`, `tipo`, `ciclo`, `ano`, `nombreInsti`) VALUES
('alex', 'elcapo', '67548768K', '1987-08-07', 'adm', '', 0, 'camino'),
('Cesar', 'acdc', '71942231', '2003-03-12', 'prof', '', 0, 'camino'),
('Dani', 'Negro', '54789875T', '2001-08-05', 'alu', 'DAW', 1, 'camino'),
('fernando', 'cabeza', '29784673F', '2001-03-25', 'prof', '', 0, 'camino'),
('Jaime', 'thor', '71955523X', '2001-02-01', 'alu', 'Carro', 1, 'camino'),
('jero', 'cerveza', '71547584D', '1987-02-14', 'prof', '', 0, 'camino'),
('Jorge', 'jorge', '7687212', '2002-07-09', 'alu', 'DAW', 1, 'camino'),
('josele', '123', '45654654M', '2000-02-02', 'alu', 'Farmacia', 1, 'camino'),
('Lola', '1254', 'lola', '2021-06-13', 'alu', 'Chapa y pintura', 1, 'camino'),
('Marcos', 'marcos', '38987297H', '1997-07-07', 'prof', '', 0, 'camino'),
('miguel', 'miguel', '71972414D', '1999-09-17', 'alu', 'DAW', 1, 'camino'),
('nana', '71245747D', 'nana', '1987-05-12', 'alu', 'Carro', 1, 'camino'),
('olga', 'maraton', '715533Y', '2003-05-23', 'alu', 'DAW', 1, 'camino');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ciclo`
--
ALTER TABLE `ciclo`
  ADD PRIMARY KEY (`nombre`,`anno`,`instituto`);

--
-- Indexes for table `instituto`
--
ALTER TABLE `instituto`
  ADD PRIMARY KEY (`nombre`);

--
-- Indexes for table `modulo`
--
ALTER TABLE `modulo`
  ADD PRIMARY KEY (`nombre`,`ciclo`,`anno`,`Instituto`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`nombre`,`nombreInsti`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
