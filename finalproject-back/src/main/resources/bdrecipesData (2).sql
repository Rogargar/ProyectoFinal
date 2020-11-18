-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-11-2020 a las 21:18:13
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
('3781df44-cc17-4155-a42a-b89b4c155977', 'TORTITAS CON MERMELADA DE FRESA Y YOGUR', 'facil', '00a40a47-01b7-4702-8af1-8b336160e60c_tortitas.jpg', '80g de preparado para tortitas “Protein Pancakes” de Body Genius\r\n160ml de bebida vegetal sin azúcares añadidos\r\nYogur skyr natural\r\nMermelada “express” de fresas', 'Proceso para la mermelada:\r\nAñadimos las fresas en un recipiente con tapa en el microondas y cocinamos hasta que se deshagan por completo.\r\nTrituramos con un tenedor y llevamos a un recipiente de cristal hasta que enfríe y guardamos en la nevera.\r\nProceso:\r\nMezclamos el preparado Protein pancake con la bebida vegetal hasta que no queden grumos.\r\nLlevamos a una sartén antiadherente pequeñita a fuego medio bajo y cocinamos tapadas.\r\nRepetimos el proceso con toda la mezcla.\r\nMontamos la torre: tortita, yogur, tortuta mermelada, tortita, yogur, tortita, mermelada y así hasta terminar.\r\nCoronamos con un trozo de donut de chocolate saludable y con unas fresas trituradas.\r\n¡Listo! Ya podemos disfrutar de nuestras TORTITAS CON MERMELADA DE FRESA Y YOGUR', '2020-11-04', '1', 'Borrador', 'Puedes hacer esta misma mermelada con otras frutas que te gusten.\r\nPuedes añadir a estas tortitas cualquier topping al gusto', '10 min', '23a65890-3f48-439f-b43e-b9459619b3fd'),
('da435920-0ebc-46d8-bb16-cc6bfecef349', 'MENESTRA DE VERDURAS CON HUEVO Y JAMÓN', 'facil', '5cd4921f-c9e5-4ea4-a8c8-bc610e2777c8_guisantes.jpg', '1 Bolsa de preparado menestra\r\n1 huevo cocido\r\n80g de jamón serrano picadito\r\nAceite de oliva virgen extra\r\nSal rosa del Himalaya', 'En una sartén añadimos el preparado para menestra y le añadimos un buen chorro de aceite de oliva.\r\nCocinamos hasta que queden bien pochadas las verduras.\r\nSeguidamente añadimos un huevo bien picadito y el jamón.\r\nAñadimos otro chorrito de aceite, mezclamos bien y probamos.\r\nAñadimos sal si creemos necesario.\r\n¡Listo! Ya podemos disfrutar de nuestra MENESTRA DE VERDURAS CON HUEVO Y JAMÓN', '2020-11-13', '2', 'Publicada', NULL, '25', '5a1c6752-b9da-4018-bd38-f3411c9c039e'),
('d3d296d9-1c0d-4d0f-b93c-510400692015', 'REJOS CON PATATAS', 'media', '09a30697-edcd-462e-95dc-aaf660136076_rejosPapas.jpg', '2 Patatas grandes\r\n100g de sepia fresca limpia\r\n100g de calamares frescos limpios\r\n400g de rejos limpios\r\n200g de carne de vieiras (opcional)\r\n2 Cucharadas de tomate concentrado\r\n1 cucharadita de pimentón dulce\r\n3 dientes de ajo\r\n2 cebollas\r\n2 hojas de laurel\r\nSal rosa del Himalaya\r\nPimienta en grano\r\nPerejil\r\nAceite de oliva virgen extra\r\nAgua\r\nVaso de vino blanco', 'Añadimos la sepia, los calamares y los rejos cortaditos en la olla con un chorrito de aceite de oliva y cocinamos para que suelten el agua.\r\nMientras picamos bien la cebolla.\r\nUna vez cocinada la sepia, los calamares y los rejos los retiramos a un plato y cocinamos la cebolla junto a otro chorrito de aceite hasta que se poche bien.\r\nCuando esté doradita añadimos los ajos picados, el tomate concentrado, el pimentón, el laurel y rehogamos.\r\nAñadimos el vaso de vino y seguimos rehogando.\r\nAñadimos añadimos la sepia, el calamar y los rejos reservados.\r\nAñadimos las patatas previamente peladas y cortadas.\r\nCubrimos con agua, añadimos la carne de las vieiras, sal y pimienta.\r\nCocinamos a fuego lento y tapando la olla durante 15-20min (dependerá del tipo de patata)\r\nDestapamos probamos el punto de sal y miramos la cocción de la patata. Si está listo añadimos el perejil bien picadito.\r\n¡Listo! Ya podemos disfrutar de nuestros REJOS CON PATATAS', '2020-11-18', '2', 'Publicada', NULL, '30 min', '5a1c6752-b9da-4018-bd38-f3411c9c039e'),
('a675045a-cbd3-4ad8-8c98-c0bec695cd60', 'BIZCOCHO DE FRESAS Y YOGUR SIN GLUTEN Y SIN AZÚCARES AÑADIDOS', 'media', '9dfc909d-e38d-4b2c-8027-18b3faa813fd_yogurBizco.jpg', 'Estos son los ingredientes que necesitas:\r\n250g de harina de avena\r\n75g de maicena\r\n1/2 sobre de levadura en polvo\r\n1/2 cucharadita de bicarbonato sódico\r\n2 Huevos medianos\r\n3 Cucharadas de dulce de dátiles casero\r\n140ml de leche\r\n50ml de aceite de oliva\r\n1 Chorrito de esencia de vainilla\r\nTopping:\r\nFresones\r\n2 Yogures skyr naturales', 'Mezclamos los ingredientes secos en un bol\r\nMezclamos los ingredientes hu?medos en un bol\r\nUnimos todos los ingredientes\r\nLlevamos a un bol que habremos aceitado y forrado con papel de hornear\r\nHorneamos a 180 durante 35-40min calor arriba y abajo\r\nMientras trituramos algunos fresnos junto a los yogures y reservamos Sacamos el bizcocho del horno y dejamos templar\r\nDesmoldamos con cuidado y cortamos por la mitad\r\nRellenamos con la mezcla de yogur de fresa que teni?amos reservada Coronamos con ma?s yogur y decoramos con fresones.\r\n¡Listo! Ya podemos disfrutar de nuestro BIZCOCHO DE FRESAS Y YOGUR SIN GLUTEN Y SIN AZÚCARES AÑADIDOS', NULL, '4', 'Borrador', 'Puedes usar otra harina\r\nPuedes utilizar aceite suave\r\nPuedes utilizar solo levadura o solo bicarbonato\r\nPuedes usar edulcorante o miel si no tienes da?tiles\r\nPuedes usar chia para remplazar los huevos\r\nPuedes utilizar frutos rojos en lugar de fresas\r\nPue', '50 min', '5a1c6752-b9da-4018-bd38-f3411c9c039e'),
('4e3f3aff-33a6-4cf8-b953-ad6884d05ff4', 'TARTA DE QUESO Y FRESAS CON CHOCOLATE', 'media', '19d2190e-b053-42a6-b066-35cd65c28c61_fresasqueso.jpg', '400g de queso fresco batido 0%\r\n3 Huevos\r\n4 Cucharadas de maicena\r\n3 Cucharadas de cremoso de dátiles\r\nCrema de avellanas y chocolate saludable\r\nFresas', 'Batimos bien los huevos con el cremoso de dátiles, el queso fresco batido y la maicena.\r\nLlevamos a un molde en el que pondremos papel de hornear.\r\nCon el horno precalentado horneamos unos 50-60min a 180grados.\r\nDejamos enfriar.\r\nUntamos con la crema de chocolate.\r\nLavamos, cortamos y colocamos las láminas de fresas por encima.\r\n¡Listo! Ya podemos disfrutar de nuestra TARTA DE QUESO Y FRESAS CON CHOCOLATE', '2020-11-13', '6', 'Publicada', NULL, '60 min', '5a1c6752-b9da-4018-bd38-f3411c9c039e'),
('9a2259bf-83cf-45de-8229-1ce561815a28', 'ARROZ MELOSO CON CALAMARES', 'media', 'e1cf9aa0-5b99-404e-9dc7-24eff1ce0e38_arrozMelo.jpg', '1kg de calamares limpios\r\n 300g de arroz redondo\r\n 1 Puñado de guisantes\r\n 1 Cebolla grande\r\n 2 Zanahorias\r\n 3 Dientes de ajo\r\n 3-4 Cucharadas de tomate natural triturado\r\n Aceite de oliva virgen extra\r\n Pimento?n dulce de la vera\r\n Sal rosa\r\n 1600ml de Caldo de pescado', 'Cortamos la cebolla en trozos pequeños y la llevamos a la paellera con un buen chorro de aceite de oliva hasta que empiece a dorar.\r\nAñadimos los guisantes y la zanahoria cortadita también, pochamos ligeramente.\r\nAn?adimos los ajitos picados dejamos que se cocinen sin quemarse y an?adimos el tomate natural triturado.\r\nDejamos que se cocine el tomate y cuando empiece a estar sofrito agregamos pimento?n al gusto.\r\nIncorporamos los calamares cortados en trozos, mezclamos bien y cocinamos hasta que los calamares reduzcan de tamaño.\r\nAñadimos el arroz y lo sofreímos ligeramente.\r\nCubrimos con el caldo ya caliente.\r\nLlevamos a ebullicio?n y bajamos el fuego para que se cocine durante 18min.\r\nApagamos el fuego y dejamos reposar 5min\r\n¡Listo! Ya tenemos nuestros ARROZ MELOSO CON CALAMARES', '2020-11-18', '4', 'Publicada', NULL, '30 min', '43f67cbf-e8e2-4c92-a1f1-c0307dcd888f');

--
-- Volcado de datos para la tabla `recipes_label`
--

INSERT INTO `recipes_label` (`recipe_id`, `label_id`) VALUES
('9cc29489-e829-4da5-a3da-84bd0c1a8efc', 'b5cb21a3-b091-499d-ac79-5d7d83aa8de7'),
('9cc29489-e829-4da5-a3da-84bd0c1a8efc', 'b6fdfe2a-8b2f-48cf-9985-9c966f0fa8d8'),
('d3da512d-7e3e-4e36-8524-d067bb5ecc6c', 'b5cb21a3-b091-499d-ac79-5d7d83aa8de7'),
('d3da512d-7e3e-4e36-8524-d067bb5ecc6c', 'b6fdfe2a-8b2f-48cf-9985-9c966f0fa8d8'),
('3781df44-cc17-4155-a42a-b89b4c155977', 'b5cb21a3-b091-499d-ac79-5d7d83aa8de7'),
('3781df44-cc17-4155-a42a-b89b4c155977', 'cfb95baa-105a-465f-a369-e26999b4e589'),
('9cc29489-e829-4da5-a3da-84bd0c1a8efc', '5275f2b4-3bc5-4aed-a3a6-5e760b68785d'),
('da435920-0ebc-46d8-bb16-cc6bfecef349', 'b5cb21a3-b091-499d-ac79-5d7d83aa8de7'),
('da435920-0ebc-46d8-bb16-cc6bfecef349', '4fe4bc67-0de1-42c5-b394-26a474e9c883'),
('da435920-0ebc-46d8-bb16-cc6bfecef349', 'e02d0680-ff8e-41f0-b82a-f83781188a72'),
('4e3f3aff-33a6-4cf8-b953-ad6884d05ff4', 'cfb95baa-105a-465f-a369-e26999b4e589'),
('d3d296d9-1c0d-4d0f-b93c-510400692015', '5275f2b4-3bc5-4aed-a3a6-5e760b68785d'),
('a675045a-cbd3-4ad8-8c98-c0bec695cd60', 'cfb95baa-105a-465f-a369-e26999b4e589');

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
('a47055e2-e93b-4bf1-997b-fe20ff825372', ' ', 'd3d296d9-1c0d-4d0f-b93c-510400692015', 'e88cce16-dd81-4ce3-a753-e8e148f73da6'),
('4b3e9dc6-b969-4d43-9640-190b56a0e2a6', ' ', '9cc29489-e829-4da5-a3da-84bd0c1a8efc', '6e1a5371-27f9-4d23-918a-aa75a4168261');

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `pass`, `surnames`) VALUES
('7cc744f7-1b8e-4343-8375-327395ee6fa1', 'Rocío', 'rocio@pruff.com', 'e10adc3949ba59abbe56e057f20f883e', 'García'),
('e88cce16-dd81-4ce3-a753-e8e148f73da6', 'Sara', 'sara@pruff.com', 'e10adc3949ba59abbe56e057f20f883e', 'Sobrino'),
('1fa7934d-ad91-477a-b379-015bf0acb8a0', 'Alberto', 'alberto@pruff.com', 'e10adc3949ba59abbe56e057f20f883e', 'Perez'),
('5a1c6752-b9da-4018-bd38-f3411c9c039e', 'Felipe', 'felipe@pruff.com', 'e35cf7b66449df565f93c607d5a81d09', 'Pipe Marin'),
('23a65890-3f48-439f-b43e-b9459619b3fd', 'Conchi', 'conchi@pruff.com', '6ebe76c9fb411be97b3b0d48b791a7c9', 'García García'),
('43f67cbf-e8e2-4c92-a1f1-c0307dcd888f', 'Pepe', 'pepe@pruff.com', 'e10adc3949ba59abbe56e057f20f883e', 'López Martin'),
('6e1a5371-27f9-4d23-918a-aa75a4168261', 'Pedro', 'pedro@pruff.com', '771233c24564b1e518de1e9b38c0de80', 'Ordax'),
('aaeb49c3-3ad0-4c05-ab78-c9b9174ab7f2', 'prueba', 'pruff@gmail.com', '250cf8b51c773f3f8dc8b4be867a9a02', 'pruff');

--
-- Volcado de datos para la tabla `users_roles`
--

INSERT INTO `users_roles` (`usuers_id`, `roles_id`) VALUES
('43f67cbf-e8e2-4c92-a1f1-c0307dcd888f', '2'),
('7cc744f7-1b8e-4343-8375-327395ee6fa1', '1'),
('e88cce16-dd81-4ce3-a753-e8e148f73da6', '3'),
('1fa7934d-ad91-477a-b379-015bf0acb8a0', '3'),
('5a1c6752-b9da-4018-bd38-f3411c9c039e', '2'),
('23a65890-3f48-439f-b43e-b9459619b3fd', '2'),
('6e1a5371-27f9-4d23-918a-aa75a4168261', '2');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
