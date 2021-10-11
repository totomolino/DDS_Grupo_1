-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-10-2021 a las 23:11:31
-- Versión del servidor: 10.4.19-MariaDB
-- Versión de PHP: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `mascotas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador_bd`
--

CREATE TABLE `administrador_bd` (
  `admin_id` bigint(20) NOT NULL,
  `id_org` bigint(20) DEFAULT NULL,
  `admin_usuario_usu_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `caracteristica_mascota`
--

CREATE TABLE `caracteristica_mascota` (
  `carmas_id` bigint(20) NOT NULL,
  `carmas_clave` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `caracteristica_org`
--

CREATE TABLE `caracteristica_org` (
  `caor_id` bigint(20) NOT NULL,
  `clave` varchar(255) DEFAULT NULL,
  `org_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carac_org_xmascota`
--

CREATE TABLE `carac_org_xmascota` (
  `caorXmas_id` bigint(20) NOT NULL,
  `caorXmas_valor` varchar(255) DEFAULT NULL,
  `caor_id` bigint(20) DEFAULT NULL,
  `masc_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `car_mas_x_mas`
--

CREATE TABLE `car_mas_x_mas` (
  `carMasMas_id` bigint(20) NOT NULL,
  `carMasMas_valor` varchar(255) DEFAULT NULL,
  `carmas_id` bigint(20) DEFAULT NULL,
  `masc_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comodidadesbd`
--

CREATE TABLE `comodidadesbd` (
  `como_id` bigint(20) NOT NULL,
  `como_clave` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comodidades_xadoptante`
--

CREATE TABLE `comodidades_xadoptante` (
  `comoXado_id` bigint(20) NOT NULL,
  `comXado_valor` varchar(255) DEFAULT NULL,
  `pers_id` bigint(20) DEFAULT NULL,
  `como_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contacto_bd`
--

CREATE TABLE `contacto_bd` (
  `cont_id` bigint(20) NOT NULL,
  `cont_apellido` varchar(255) DEFAULT NULL,
  `cont_email` varchar(255) DEFAULT NULL,
  `cont_nombre` varchar(255) DEFAULT NULL,
  `cont_telefono` varchar(255) DEFAULT NULL,
  `pers_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `contacto_bd`
--

INSERT INTO `contacto_bd` (`cont_id`, `cont_apellido`, `cont_email`, `cont_nombre`, `cont_telefono`, `pers_id`) VALUES
(1, 'Guillan', 'camiguillan@gmail.com', 'Camila', '123456789', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `forma_notif_cont`
--

CREATE TABLE `forma_notif_cont` (
  `fonoc_id` bigint(20) NOT NULL,
  `fonoc_forma` varchar(255) DEFAULT NULL,
  `cont_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `forma_notif_cont`
--

INSERT INTO `forma_notif_cont` (`fonoc_id`, `fonoc_forma`, `cont_id`) VALUES
(1, 'EMAIL', 1),
(2, 'WHATSAPP', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `forma_notif_pers`
--

CREATE TABLE `forma_notif_pers` (
  `fonop_id` bigint(20) NOT NULL,
  `fonop_forma` varchar(255) DEFAULT NULL,
  `pers_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `forma_notif_pers`
--

INSERT INTO `forma_notif_pers` (`fonop_id`, `fonop_forma`, `pers_id`) VALUES
(1, 'WHATSAPP', 1),
(2, 'EMAIL', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `foto_animales`
--

CREATE TABLE `foto_animales` (
  `fani_id` bigint(20) NOT NULL,
  `fani_direccion` varchar(255) DEFAULT NULL,
  `masc_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `foto_rescate`
--

CREATE TABLE `foto_rescate` (
  `fore_id` bigint(20) NOT NULL,
  `fore_direccion` varchar(255) DEFAULT NULL,
  `resc_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mascota_bd`
--

CREATE TABLE `mascota_bd` (
  `masc_id` bigint(20) NOT NULL,
  `masc_apodo` varchar(255) DEFAULT NULL,
  `masc_descripcion` varchar(255) DEFAULT NULL,
  `masc_edad` int(11) NOT NULL,
  `masc_especie` varchar(255) DEFAULT NULL,
  `masc_nombre` varchar(255) DEFAULT NULL,
  `masc_sexo` varchar(255) DEFAULT NULL,
  `masc_tieneChapita` bit(1) DEFAULT NULL,
  `pers_id` bigint(20) DEFAULT NULL,
  `org_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `organizacion`
--

CREATE TABLE `organizacion` (
  `orga_id` bigint(20) NOT NULL,
  `orga_posX` float NOT NULL,
  `orga_posY` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `DTYPE` varchar(31) NOT NULL,
  `pers_id` bigint(20) NOT NULL,
  `pers_apellido` varchar(255) DEFAULT NULL,
  `pers_documento` int(11) NOT NULL,
  `pers_fechaNacimiento` varchar(255) DEFAULT NULL,
  `pers_nombre` varchar(255) DEFAULT NULL,
  `pers_telefono` varchar(255) DEFAULT NULL,
  `pers_tipoDocumento` varchar(255) DEFAULT NULL,
  `pers_usuario_usu_id` bigint(20) DEFAULT NULL,
  `orga_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`DTYPE`, `pers_id`, `pers_apellido`, `pers_documento`, `pers_fechaNacimiento`, `pers_nombre`, `pers_telefono`, `pers_tipoDocumento`, `pers_usuario_usu_id`, `orga_id`) VALUES
('DuenioBD', 1, 'molino', 43386355, '16/04/2001', 'tomas', '1166070996', 'DNI', 16, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preferencia_bd`
--

CREATE TABLE `preferencia_bd` (
  `pref_id` bigint(20) NOT NULL,
  `pref_clave` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preferencia_x_adoptante`
--

CREATE TABLE `preferencia_x_adoptante` (
  `prefXado_id` bigint(20) NOT NULL,
  `prefXado_valor` varchar(255) DEFAULT NULL,
  `pers_id` bigint(20) DEFAULT NULL,
  `pref_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preguntas_obligatorias`
--

CREATE TABLE `preguntas_obligatorias` (
  `prob_id` bigint(20) NOT NULL,
  `prob_pregunta` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pregunta_org`
--

CREATE TABLE `pregunta_org` (
  `preg_id` bigint(20) NOT NULL,
  `clave` varchar(255) DEFAULT NULL,
  `org_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `preg_org_xmascota`
--

CREATE TABLE `preg_org_xmascota` (
  `pregOrg_id` bigint(20) NOT NULL,
  `pregOrg_valor` varchar(255) DEFAULT NULL,
  `masc_id` bigint(20) DEFAULT NULL,
  `preg_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rescate_bd`
--

CREATE TABLE `rescate_bd` (
  `resc_id` bigint(20) NOT NULL,
  `resc_descripcionEstado` varchar(255) DEFAULT NULL,
  `resc_lugarEncuentroX` float NOT NULL,
  `resc_lugarEncuentroY` float NOT NULL,
  `masc_id` bigint(20) DEFAULT NULL,
  `pers_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `usu_id` bigint(20) NOT NULL,
  `usu_contrasena` varchar(255) DEFAULT NULL,
  `usu_email` varchar(255) DEFAULT NULL,
  `usu_nombre` varchar(255) DEFAULT NULL,
  `usu_tipo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`usu_id`, `usu_contrasena`, `usu_email`, `usu_nombre`, `usu_tipo`) VALUES
(16, 'Totoeslaonda12', 'totomolino@hotmail.com', 'totomolino', 'ADMIN');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `voluntario_bd`
--

CREATE TABLE `voluntario_bd` (
  `volu_id` bigint(20) NOT NULL,
  `volu_tamFotos` int(11) NOT NULL,
  `orga_id` bigint(20) DEFAULT NULL,
  `volu_usuario_usu_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrador_bd`
--
ALTER TABLE `administrador_bd`
  ADD PRIMARY KEY (`admin_id`),
  ADD KEY `FK5iy3y5jaf3ewggatqnwfysvwm` (`id_org`),
  ADD KEY `FK8jsepvfw6ci3mg2ki3xfyyerd` (`admin_usuario_usu_id`);

--
-- Indices de la tabla `caracteristica_mascota`
--
ALTER TABLE `caracteristica_mascota`
  ADD PRIMARY KEY (`carmas_id`);

--
-- Indices de la tabla `caracteristica_org`
--
ALTER TABLE `caracteristica_org`
  ADD PRIMARY KEY (`caor_id`),
  ADD KEY `FKbwwimlq6wicymfxcwmwhrhkhy` (`org_id`);

--
-- Indices de la tabla `carac_org_xmascota`
--
ALTER TABLE `carac_org_xmascota`
  ADD PRIMARY KEY (`caorXmas_id`),
  ADD KEY `FK2girv4057c5w7nyi89wxystjg` (`caor_id`),
  ADD KEY `FKncyx1nr2qwq5pntvnjuc9h09e` (`masc_id`);

--
-- Indices de la tabla `car_mas_x_mas`
--
ALTER TABLE `car_mas_x_mas`
  ADD PRIMARY KEY (`carMasMas_id`),
  ADD KEY `FKbs1ium1xvy33r8h08mb3mft9r` (`carmas_id`),
  ADD KEY `FKpy5a6j1ppr435pepg94nayepq` (`masc_id`);

--
-- Indices de la tabla `comodidadesbd`
--
ALTER TABLE `comodidadesbd`
  ADD PRIMARY KEY (`como_id`);

--
-- Indices de la tabla `comodidades_xadoptante`
--
ALTER TABLE `comodidades_xadoptante`
  ADD PRIMARY KEY (`comoXado_id`),
  ADD KEY `FKgr46wmu8v7insqtcebcs55vn0` (`pers_id`),
  ADD KEY `FKpv3r9mcu1wl23ubhi03ihfcvc` (`como_id`);

--
-- Indices de la tabla `contacto_bd`
--
ALTER TABLE `contacto_bd`
  ADD PRIMARY KEY (`cont_id`),
  ADD KEY `FK9gf326o4wrnwcis11uqb9y1py` (`pers_id`);

--
-- Indices de la tabla `forma_notif_cont`
--
ALTER TABLE `forma_notif_cont`
  ADD PRIMARY KEY (`fonoc_id`),
  ADD KEY `FKfk38hovhe8grmpg2yxdhuxshe` (`cont_id`);

--
-- Indices de la tabla `forma_notif_pers`
--
ALTER TABLE `forma_notif_pers`
  ADD PRIMARY KEY (`fonop_id`),
  ADD KEY `FKarfch11lm5f79qh8i1myvi7wb` (`pers_id`);

--
-- Indices de la tabla `foto_animales`
--
ALTER TABLE `foto_animales`
  ADD PRIMARY KEY (`fani_id`),
  ADD KEY `FKquxl5bkthgvp74c2i1ye6x5f8` (`masc_id`);

--
-- Indices de la tabla `foto_rescate`
--
ALTER TABLE `foto_rescate`
  ADD PRIMARY KEY (`fore_id`),
  ADD KEY `FKk94gpc6xmv1mj9ixltpknajtr` (`resc_id`);

--
-- Indices de la tabla `mascota_bd`
--
ALTER TABLE `mascota_bd`
  ADD PRIMARY KEY (`masc_id`),
  ADD KEY `FKlnhuutirng9m408me4ktflxt9` (`pers_id`),
  ADD KEY `FKnsh7vl1e2cbaxd2exphti0hua` (`org_id`);

--
-- Indices de la tabla `organizacion`
--
ALTER TABLE `organizacion`
  ADD PRIMARY KEY (`orga_id`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`pers_id`),
  ADD KEY `FK7wb8e1fy0g9pym1b76ghx1rbf` (`pers_usuario_usu_id`),
  ADD KEY `FKtdeewr42xct6l4os0cprr7uub` (`orga_id`);

--
-- Indices de la tabla `preferencia_bd`
--
ALTER TABLE `preferencia_bd`
  ADD PRIMARY KEY (`pref_id`);

--
-- Indices de la tabla `preferencia_x_adoptante`
--
ALTER TABLE `preferencia_x_adoptante`
  ADD PRIMARY KEY (`prefXado_id`),
  ADD KEY `FKkw0a2iqr7uosxlon19p59sqo7` (`pers_id`),
  ADD KEY `FKdw3vu4jd4maxfj54i0t6km2w9` (`pref_id`);

--
-- Indices de la tabla `preguntas_obligatorias`
--
ALTER TABLE `preguntas_obligatorias`
  ADD PRIMARY KEY (`prob_id`);

--
-- Indices de la tabla `pregunta_org`
--
ALTER TABLE `pregunta_org`
  ADD PRIMARY KEY (`preg_id`),
  ADD KEY `FKceufhi8aruvri4h2jq45xvl4r` (`org_id`);

--
-- Indices de la tabla `preg_org_xmascota`
--
ALTER TABLE `preg_org_xmascota`
  ADD PRIMARY KEY (`pregOrg_id`),
  ADD KEY `FKm77hp582ioxyt093cx0sgnpq4` (`masc_id`),
  ADD KEY `FKbtsnf5lats6kil8gdvp8mtkhm` (`preg_id`);

--
-- Indices de la tabla `rescate_bd`
--
ALTER TABLE `rescate_bd`
  ADD PRIMARY KEY (`resc_id`),
  ADD KEY `FKfx21rvvsdjh02u4we07anth3u` (`masc_id`),
  ADD KEY `FKfvx2tshekbid2jjag3kyxrdds` (`pers_id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`usu_id`);

--
-- Indices de la tabla `voluntario_bd`
--
ALTER TABLE `voluntario_bd`
  ADD PRIMARY KEY (`volu_id`),
  ADD KEY `FKcjq4ifr3x27p0a4xc3m8moklq` (`orga_id`),
  ADD KEY `FKjw8lmwapkheb8iwnk40e8md6i` (`volu_usuario_usu_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `administrador_bd`
--
ALTER TABLE `administrador_bd`
  MODIFY `admin_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `caracteristica_mascota`
--
ALTER TABLE `caracteristica_mascota`
  MODIFY `carmas_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `caracteristica_org`
--
ALTER TABLE `caracteristica_org`
  MODIFY `caor_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `carac_org_xmascota`
--
ALTER TABLE `carac_org_xmascota`
  MODIFY `caorXmas_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `car_mas_x_mas`
--
ALTER TABLE `car_mas_x_mas`
  MODIFY `carMasMas_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `comodidadesbd`
--
ALTER TABLE `comodidadesbd`
  MODIFY `como_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `comodidades_xadoptante`
--
ALTER TABLE `comodidades_xadoptante`
  MODIFY `comoXado_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `contacto_bd`
--
ALTER TABLE `contacto_bd`
  MODIFY `cont_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `forma_notif_cont`
--
ALTER TABLE `forma_notif_cont`
  MODIFY `fonoc_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `forma_notif_pers`
--
ALTER TABLE `forma_notif_pers`
  MODIFY `fonop_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `foto_animales`
--
ALTER TABLE `foto_animales`
  MODIFY `fani_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `foto_rescate`
--
ALTER TABLE `foto_rescate`
  MODIFY `fore_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `mascota_bd`
--
ALTER TABLE `mascota_bd`
  MODIFY `masc_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `organizacion`
--
ALTER TABLE `organizacion`
  MODIFY `orga_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `pers_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `preferencia_bd`
--
ALTER TABLE `preferencia_bd`
  MODIFY `pref_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `preferencia_x_adoptante`
--
ALTER TABLE `preferencia_x_adoptante`
  MODIFY `prefXado_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `preguntas_obligatorias`
--
ALTER TABLE `preguntas_obligatorias`
  MODIFY `prob_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pregunta_org`
--
ALTER TABLE `pregunta_org`
  MODIFY `preg_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `preg_org_xmascota`
--
ALTER TABLE `preg_org_xmascota`
  MODIFY `pregOrg_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `rescate_bd`
--
ALTER TABLE `rescate_bd`
  MODIFY `resc_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `usu_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `voluntario_bd`
--
ALTER TABLE `voluntario_bd`
  MODIFY `volu_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `administrador_bd`
--
ALTER TABLE `administrador_bd`
  ADD CONSTRAINT `FK5iy3y5jaf3ewggatqnwfysvwm` FOREIGN KEY (`id_org`) REFERENCES `organizacion` (`orga_id`),
  ADD CONSTRAINT `FK8jsepvfw6ci3mg2ki3xfyyerd` FOREIGN KEY (`admin_usuario_usu_id`) REFERENCES `usuarios` (`usu_id`);

--
-- Filtros para la tabla `caracteristica_org`
--
ALTER TABLE `caracteristica_org`
  ADD CONSTRAINT `FKbwwimlq6wicymfxcwmwhrhkhy` FOREIGN KEY (`org_id`) REFERENCES `organizacion` (`orga_id`);

--
-- Filtros para la tabla `carac_org_xmascota`
--
ALTER TABLE `carac_org_xmascota`
  ADD CONSTRAINT `FK2girv4057c5w7nyi89wxystjg` FOREIGN KEY (`caor_id`) REFERENCES `caracteristica_org` (`caor_id`),
  ADD CONSTRAINT `FKncyx1nr2qwq5pntvnjuc9h09e` FOREIGN KEY (`masc_id`) REFERENCES `mascota_bd` (`masc_id`);

--
-- Filtros para la tabla `car_mas_x_mas`
--
ALTER TABLE `car_mas_x_mas`
  ADD CONSTRAINT `FKbs1ium1xvy33r8h08mb3mft9r` FOREIGN KEY (`carmas_id`) REFERENCES `caracteristica_mascota` (`carmas_id`),
  ADD CONSTRAINT `FKpy5a6j1ppr435pepg94nayepq` FOREIGN KEY (`masc_id`) REFERENCES `mascota_bd` (`masc_id`);

--
-- Filtros para la tabla `comodidades_xadoptante`
--
ALTER TABLE `comodidades_xadoptante`
  ADD CONSTRAINT `FKgr46wmu8v7insqtcebcs55vn0` FOREIGN KEY (`pers_id`) REFERENCES `persona` (`pers_id`),
  ADD CONSTRAINT `FKpv3r9mcu1wl23ubhi03ihfcvc` FOREIGN KEY (`como_id`) REFERENCES `comodidadesbd` (`como_id`);

--
-- Filtros para la tabla `contacto_bd`
--
ALTER TABLE `contacto_bd`
  ADD CONSTRAINT `FK9gf326o4wrnwcis11uqb9y1py` FOREIGN KEY (`pers_id`) REFERENCES `persona` (`pers_id`);

--
-- Filtros para la tabla `forma_notif_cont`
--
ALTER TABLE `forma_notif_cont`
  ADD CONSTRAINT `FKfk38hovhe8grmpg2yxdhuxshe` FOREIGN KEY (`cont_id`) REFERENCES `contacto_bd` (`cont_id`);

--
-- Filtros para la tabla `forma_notif_pers`
--
ALTER TABLE `forma_notif_pers`
  ADD CONSTRAINT `FKarfch11lm5f79qh8i1myvi7wb` FOREIGN KEY (`pers_id`) REFERENCES `persona` (`pers_id`);

--
-- Filtros para la tabla `foto_animales`
--
ALTER TABLE `foto_animales`
  ADD CONSTRAINT `FKquxl5bkthgvp74c2i1ye6x5f8` FOREIGN KEY (`masc_id`) REFERENCES `mascota_bd` (`masc_id`);

--
-- Filtros para la tabla `foto_rescate`
--
ALTER TABLE `foto_rescate`
  ADD CONSTRAINT `FKk94gpc6xmv1mj9ixltpknajtr` FOREIGN KEY (`resc_id`) REFERENCES `rescate_bd` (`resc_id`);

--
-- Filtros para la tabla `mascota_bd`
--
ALTER TABLE `mascota_bd`
  ADD CONSTRAINT `FKlnhuutirng9m408me4ktflxt9` FOREIGN KEY (`pers_id`) REFERENCES `persona` (`pers_id`),
  ADD CONSTRAINT `FKnsh7vl1e2cbaxd2exphti0hua` FOREIGN KEY (`org_id`) REFERENCES `organizacion` (`orga_id`);

--
-- Filtros para la tabla `persona`
--
ALTER TABLE `persona`
  ADD CONSTRAINT `FK7wb8e1fy0g9pym1b76ghx1rbf` FOREIGN KEY (`pers_usuario_usu_id`) REFERENCES `usuarios` (`usu_id`),
  ADD CONSTRAINT `FKtdeewr42xct6l4os0cprr7uub` FOREIGN KEY (`orga_id`) REFERENCES `organizacion` (`orga_id`);

--
-- Filtros para la tabla `preferencia_x_adoptante`
--
ALTER TABLE `preferencia_x_adoptante`
  ADD CONSTRAINT `FKdw3vu4jd4maxfj54i0t6km2w9` FOREIGN KEY (`pref_id`) REFERENCES `preferencia_bd` (`pref_id`),
  ADD CONSTRAINT `FKkw0a2iqr7uosxlon19p59sqo7` FOREIGN KEY (`pers_id`) REFERENCES `persona` (`pers_id`);

--
-- Filtros para la tabla `pregunta_org`
--
ALTER TABLE `pregunta_org`
  ADD CONSTRAINT `FKceufhi8aruvri4h2jq45xvl4r` FOREIGN KEY (`org_id`) REFERENCES `organizacion` (`orga_id`);

--
-- Filtros para la tabla `preg_org_xmascota`
--
ALTER TABLE `preg_org_xmascota`
  ADD CONSTRAINT `FKbtsnf5lats6kil8gdvp8mtkhm` FOREIGN KEY (`preg_id`) REFERENCES `pregunta_org` (`preg_id`),
  ADD CONSTRAINT `FKm77hp582ioxyt093cx0sgnpq4` FOREIGN KEY (`masc_id`) REFERENCES `mascota_bd` (`masc_id`);

--
-- Filtros para la tabla `rescate_bd`
--
ALTER TABLE `rescate_bd`
  ADD CONSTRAINT `FKfvx2tshekbid2jjag3kyxrdds` FOREIGN KEY (`pers_id`) REFERENCES `persona` (`pers_id`),
  ADD CONSTRAINT `FKfx21rvvsdjh02u4we07anth3u` FOREIGN KEY (`masc_id`) REFERENCES `mascota_bd` (`masc_id`);

--
-- Filtros para la tabla `voluntario_bd`
--
ALTER TABLE `voluntario_bd`
  ADD CONSTRAINT `FKcjq4ifr3x27p0a4xc3m8moklq` FOREIGN KEY (`orga_id`) REFERENCES `organizacion` (`orga_id`),
  ADD CONSTRAINT `FKjw8lmwapkheb8iwnk40e8md6i` FOREIGN KEY (`volu_usuario_usu_id`) REFERENCES `usuarios` (`usu_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
