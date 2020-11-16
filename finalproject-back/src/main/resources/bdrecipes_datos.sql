-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-11-2020 a las 22:38:20
-- Versión del servidor: 10.4.6-MariaDB
-- Versión de PHP: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdrecipes`
--

--
-- Volcado de datos para la tabla `label`
--

INSERT INTO `label` (`id`, `name`) VALUES
('1', 'Pollo'),
('45656', 'Acompañamiento'),
('b6fdfe2a-8b2f-48cf-9985-9c966f0fa8d8', 'Secundario'),
('3c78aa85-e999-4997-8b6f-e60cdffaf654', 'Pescado'),
('e02d0680-ff8e-41f0-b82a-f83781188a72', 'Entrantes'),
('b5cb21a3-b091-499d-ac79-5d7d83aa8de7', 'Vegetariano'),
('4fe4bc67-0de1-42c5-b394-26a474e9c883', 'Vegano'),
('5275f2b4-3bc5-4aed-a3a6-5e760b68785d', 'Sopas'),
('0e69723f-89b7-4691-a311-5199ed74ca19', 'Bebidas'),
('fc5f2269-e1d9-4c8f-9ee0-38c9025321e3', 'Pan'),
('cfb95baa-105a-465f-a369-e26999b4e589', 'Repostería');

--
-- Volcado de datos para la tabla `menu`
--

INSERT INTO `menu` (`id`, `name`, `date`, `menu`, `id_saved_recipes`) VALUES
('d201d6a6-e0d5-4aa9-9a59-3b492ef6473d', '', '2020-09-16', 'comida', '123456');

--
-- Volcado de datos para la tabla `recipes`
--

INSERT INTO `recipes` (`id`, `name`, `difficulty`, `img`, `ingredients`, `preparation`, `publication_date`, `ration`, `state`, `suggestions`, `time`, `id_owner`) VALUES
('d3da512d-7e3e-4e36-8524-d067bb5ecc6c', 'COLIFLOR ASADA CON HUEVOS Y QUESO', 'media', 'c14ec2fa-33b1-47c1-8e21-88cf616ee751_coli.jpg', '1/2 Coliflor\r\n2 Huevos\r\nAceite de oliva virgen extra\r\nQueso rallado bajo en grasa Eatlean\r\nSal rosa', 'Asamos la coliflor previamente cortada en trozos en el horno durante 35min a 200grados y reservamos.\r\nBatimos los huevos con una pizca de sal.\r\nLlevamos la coliflor a la sartén junto a un chorrito de aceite de oliva.\r\nAñadimos los huevos.\r\nDejamos que se cocinen y cuando empiecen a estar cocinados añadimos queso al gusto.\r\nDejamos que funda el queso.\r\n¡Listo! Ya tenemos nuestra COLIFLOR ASADA CON HUEVOS Y QUESO', '2020-11-04', '2', 'Publicada', NULL, '30 min', '5a1c6752-b9da-4018-bd38-f3411c9c039e'),
('9cc29489-e829-4da5-a3da-84bd0c1a8efc', 'TORTILLA DE PATATAS Y ZANAHORIA', 'media', '5979e22e-529e-42a8-be35-72ba72b5a7f5_tortillasPatataZanah.jpg', '3 Patatas medianas\r\n3 Zanahorias grandes\r\n1 Cebolla\r\n6 Huevos\r\nAceite de oliva virgen extra\r\nSal rosa', 'Pelamos y cortamos en daditos las patatas y llevamos a un recipiente para cocinar en el microondas o en un plato hondo que taparemos con film.\r\nCocinamos a máxima potencia entre 10-20min dependiendo del microondas y del grosor de la patata.\r\nRallamos la zanahoria con un rallador de agujero grueso y reservamos.\r\nMientras ponemos la sartén al fuego con un chorrito de aceite y pochamos la cebolla hasta que se dore un poquito.\r\nBatimos los huevos con una pizca de sal.\r\nAñadimos las patatas, la cebolla y la zanahoria cruda al bol con los huevos.\r\nIntegramos bien los ingredientes con los huevos.\r\nVertemos la mezcla y cocinamos a fuego bajo por ambos lados hasta que quede cuajada a tu gusto.\r\n¡Listo! Ya podemos disfrutar de nuestra TORTILLA DE PATATAS Y ZANAHORIA', '2020-11-04', '4', 'Borrador', 'En esta tortilla añade una pizca más de sal pues la zanahoria es dulce.\r\nAl rallarla se cocina sola con la cocción y NO QUEDA CRUDA pero puedes pocharla con la cebolla si quieres.\r\nSi no tienes microondas puedes hacerla con patatas asadas o al vapor.\r\n', '40 min', '5a1c6752-b9da-4018-bd38-f3411c9c039e'),
('3781df44-cc17-4155-a42a-b89b4c155977', 'TORTITAS CON MERMELADA DE FRESA Y YOGUR', 'facil', '00a40a47-01b7-4702-8af1-8b336160e60c_tortitas.jpg', '80g de preparado para tortitas “Protein Pancakes” de Body Genius\r\n160ml de bebida vegetal sin azúcares añadidos\r\nYogur skyr natural\r\nMermelada “express” de fresas', 'Proceso para la mermelada:\r\nAñadimos las fresas en un recipiente con tapa en el microondas y cocinamos hasta que se deshagan por completo.\r\nTrituramos con un tenedor y llevamos a un recipiente de cristal hasta que enfríe y guardamos en la nevera.\r\nProceso:\r\nMezclamos el preparado Protein pancake con la bebida vegetal hasta que no queden grumos.\r\nLlevamos a una sartén antiadherente pequeñita a fuego medio bajo y cocinamos tapadas.\r\nRepetimos el proceso con toda la mezcla.\r\nMontamos la torre: tortita, yogur, tortuta mermelada, tortita, yogur, tortita, mermelada y así hasta terminar.\r\nCoronamos con un trozo de donut de chocolate saludable y con unas fresas trituradas.\r\n¡Listo! Ya podemos disfrutar de nuestras TORTITAS CON MERMELADA DE FRESA Y YOGUR', '2020-11-04', '1', 'Borrador', 'Puedes hacer esta misma mermelada con otras frutas que te gusten.\r\nPuedes añadir a estas tortitas cualquier topping al gusto', '10 min', '23a65890-3f48-439f-b43e-b9459619b3fd');

--
-- Volcado de datos para la tabla `recipes_label`
--

INSERT INTO `recipes_label` (`recipe_id`, `label_id`) VALUES
('9cc29489-e829-4da5-a3da-84bd0c1a8efc', '5275f2b4-3bc5-4aed-a3a6-5e760b68785d'),
('9cc29489-e829-4da5-a3da-84bd0c1a8efc', 'b6fdfe2a-8b2f-48cf-9985-9c966f0fa8d8'),
('d3da512d-7e3e-4e36-8524-d067bb5ecc6c', 'b5cb21a3-b091-499d-ac79-5d7d83aa8de7'),
('d3da512d-7e3e-4e36-8524-d067bb5ecc6c', 'b6fdfe2a-8b2f-48cf-9985-9c966f0fa8d8'),
('3781df44-cc17-4155-a42a-b89b4c155977', 'cfb95baa-105a-465f-a369-e26999b4e589'),
('3781df44-cc17-4155-a42a-b89b4c155977', 'b5cb21a3-b091-499d-ac79-5d7d83aa8de7'),
('9cc29489-e829-4da5-a3da-84bd0c1a8efc', 'b5cb21a3-b091-499d-ac79-5d7d83aa8de7');

--
-- Volcado de datos para la tabla `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
('1', 'ROLE_ADMIN'),
('2', 'ROLE_CREATOR'),
('3', 'ROLE_READER');

--
-- Volcado de datos para la tabla `saved_recipes`
--

INSERT INTO `saved_recipes` (`id`, `name`, `id_recipes`, `id_user`) VALUES
('a9b08cbe-80b1-4eac-a2fb-93ff71347018', '', 'd3da512d-7e3e-4e36-8524-d067bb5ecc6c', 'e88cce16-dd81-4ce3-a753-e8e148f73da6'),
('51aef5e2-9504-4064-ac7b-abdaeb26a326', '', '9cc29489-e829-4da5-a3da-84bd0c1a8efc', 'e88cce16-dd81-4ce3-a753-e8e148f73da6');

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `pass`, `surnames`) VALUES
('7cc744f7-1b8e-4343-8375-327395ee6fa1', 'Rocío', 'rocio@pruff.com', 'e10adc3949ba59abbe56e057f20f883e', 'García'),
('e88cce16-dd81-4ce3-a753-e8e148f73da6', 'Sara', 'sara@pruff.com', 'e10adc3949ba59abbe56e057f20f883e', 'Sobrino'),
('1fa7934d-ad91-477a-b379-015bf0acb8a0', 'Alberto', 'alberto@pruff.com', 'e10adc3949ba59abbe56e057f20f883e', 'Perez'),
('5a1c6752-b9da-4018-bd38-f3411c9c039e', 'Felipe', 'felipe@pruff.com', 'e35cf7b66449df565f93c607d5a81d09', 'Pipe Marin'),
('23a65890-3f48-439f-b43e-b9459619b3fd', 'Conchi', 'conchi@pruff.com', '6ebe76c9fb411be97b3b0d48b791a7c9', 'García García'),
('43f67cbf-e8e2-4c92-a1f1-c0307dcd888f', 'Pepe', 'pepe@pruff.com', 'e10adc3949ba59abbe56e057f20f883e', 'López Martin');

--
-- Volcado de datos para la tabla `users_roles`
--

INSERT INTO `users_roles` (`usuers_id`, `roles_id`) VALUES
('43f67cbf-e8e2-4c92-a1f1-c0307dcd888f', '2'),
('7cc744f7-1b8e-4343-8375-327395ee6fa1', '1'),
('e88cce16-dd81-4ce3-a753-e8e148f73da6', '3'),
('1fa7934d-ad91-477a-b379-015bf0acb8a0', '3'),
('5a1c6752-b9da-4018-bd38-f3411c9c039e', '2'),
('23a65890-3f48-439f-b43e-b9459619b3fd', '2');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
