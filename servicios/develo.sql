
CREATE DATABASE IF NOT EXISTS `develo` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `developeru_bd`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `usu_usuario` varchar(50) NOT NULL,
  `usu_password` varchar(12) NOT NULL,
  `usu_nombres` varchar(50) NOT NULL,
  `usu_apellidos` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`usu_usuario`, `usu_password`, `usu_nombres`, `usu_apellidos`) VALUES
('aroncal@gmail.com', '12345678', 'Edgar', 'Roncal Tafur'),
('egarcia@outlook.com', 'eduardo2019', 'Eduardo', 'Garcia Lopez'),
('mromero@gmail.com', 'melina2019', 'Melina', 'Romero Torres');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`usu_usuario`);
COMMIT;