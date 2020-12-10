-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-12-2020 a las 21:19:43
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
('9cc29489-e829-4da5-a3da-84bd0c1a8efc', 'TORTILLA DE PATATAS Y ZANAHORIA', 'media', '5979e22e-529e-42a8-be35-72ba72b5a7f5_tortillasPatataZanah.jpg', '3 Patatas medianas\r\n3 Zanahorias grandes\r\n1 Cebolla\r\n6 Huevos\r\nAceite de oliva virgen extra\r\nSal rosa', 'Pelamos y cortamos en daditos las patatas y llevamos a un recipiente para cocinar en el microondas o en un plato hondo que taparemos con film.\r\nCocinamos a máxima potencia entre 10-20min dependiendo del microondas y del grosor de la patata.\r\nRallamos la zanahoria con un rallador de agujero grueso y reservamos.\r\nMientras ponemos la sartén al fuego con un chorrito de aceite y pochamos la cebolla hasta que se dore un poquito.\r\nBatimos los huevos con una pizca de sal.\r\nAñadimos las patatas, la cebolla y la zanahoria cruda al bol con los huevos.\r\nIntegramos bien los ingredientes con los huevos.\r\nVertemos la mezcla y cocinamos a fuego bajo por ambos lados hasta que quede cuajada a tu gusto.\r\n¡Listo! Ya podemos disfrutar de nuestra TORTILLA DE PATATAS Y ZANAHORIA', '2020-12-06', '4', 'Publicada', 'En esta tortilla añade una pizca más de sal pues la zanahoria es dulce.\r\nAl rallarla se cocina sola con la cocción y NO QUEDA CRUDA pero puedes pocharla con la cebolla si quieres.\r\nSi no tienes microondas puedes hacerla con patatas asadas o al vapor.\r\n', '40 min', '5a1c6752-b9da-4018-bd38-f3411c9c039e'),
('3781df44-cc17-4155-a42a-b89b4c155977', 'TORTITAS CON MERMELADA DE FRESA Y YOGUR', 'facil', '00a40a47-01b7-4702-8af1-8b336160e60c_tortitas.jpg', '80g de preparado para tortitas “Protein Pancakes” de Body Genius\r\n160ml de bebida vegetal sin azúcares añadidos\r\nYogur skyr natural\r\nMermelada “express” de fresas', 'Proceso para la mermelada:\r\nAñadimos las fresas en un recipiente con tapa en el microondas y cocinamos hasta que se deshagan por completo.\r\nTrituramos con un tenedor y llevamos a un recipiente de cristal hasta que enfríe y guardamos en la nevera.\r\nProceso:\r\nMezclamos el preparado Protein pancake con la bebida vegetal hasta que no queden grumos.\r\nLlevamos a una sartén antiadherente pequeñita a fuego medio bajo y cocinamos tapadas.\r\nRepetimos el proceso con toda la mezcla.\r\nMontamos la torre: tortita, yogur, tortuta mermelada, tortita, yogur, tortita, mermelada y así hasta terminar.\r\nCoronamos con un trozo de donut de chocolate saludable y con unas fresas trituradas.\r\n¡Listo! Ya podemos disfrutar de nuestras TORTITAS CON MERMELADA DE FRESA Y YOGUR', '2020-12-09', '1', 'Publicada', 'Puedes hacer esta misma mermelada con otras frutas que te gusten.\r\nPuedes añadir a estas tortitas cualquier topping al gusto', '10 min', '23a65890-3f48-439f-b43e-b9459619b3fd'),
('da435920-0ebc-46d8-bb16-cc6bfecef349', 'MENESTRA DE VERDURAS CON HUEVO Y JAMÓN', 'facil', '5cd4921f-c9e5-4ea4-a8c8-bc610e2777c8_guisantes.jpg', '1 Bolsa de preparado menestra\r\n1 huevo cocido\r\n80g de jamón serrano picadito\r\nAceite de oliva virgen extra\r\nSal rosa del Himalaya', 'En una sartén añadimos el preparado para menestra y le añadimos un buen chorro de aceite de oliva.\r\nCocinamos hasta que queden bien pochadas las verduras.\r\nSeguidamente añadimos un huevo bien picadito y el jamón.\r\nAñadimos otro chorrito de aceite, mezclamos bien y probamos.\r\nAñadimos sal si creemos necesario.\r\n¡Listo! Ya podemos disfrutar de nuestra MENESTRA DE VERDURAS CON HUEVO Y JAMÓN', '2020-11-13', '2', 'Publicada', NULL, '25', '5a1c6752-b9da-4018-bd38-f3411c9c039e'),
('d3d296d9-1c0d-4d0f-b93c-510400692015', 'REJOS CON PATATAS', 'media', '09a30697-edcd-462e-95dc-aaf660136076_rejosPapas.jpg', '2 Patatas grandes\r\n100g de sepia fresca limpia\r\n100g de calamares frescos limpios\r\n400g de rejos limpios\r\n200g de carne de vieiras (opcional)\r\n2 Cucharadas de tomate concentrado\r\n1 cucharadita de pimentón dulce\r\n3 dientes de ajo\r\n2 cebollas\r\n2 hojas de laurel\r\nSal rosa del Himalaya\r\nPimienta en grano\r\nPerejil\r\nAceite de oliva virgen extra\r\nAgua\r\nVaso de vino blanco', 'Añadimos la sepia, los calamares y los rejos cortaditos en la olla con un chorrito de aceite de oliva y cocinamos para que suelten el agua.\r\nMientras picamos bien la cebolla.\r\nUna vez cocinada la sepia, los calamares y los rejos los retiramos a un plato y cocinamos la cebolla junto a otro chorrito de aceite hasta que se poche bien.\r\nCuando esté doradita añadimos los ajos picados, el tomate concentrado, el pimentón, el laurel y rehogamos.\r\nAñadimos el vaso de vino y seguimos rehogando.\r\nAñadimos añadimos la sepia, el calamar y los rejos reservados.\r\nAñadimos las patatas previamente peladas y cortadas.\r\nCubrimos con agua, añadimos la carne de las vieiras, sal y pimienta.\r\nCocinamos a fuego lento y tapando la olla durante 15-20min (dependerá del tipo de patata)\r\nDestapamos probamos el punto de sal y miramos la cocción de la patata. Si está listo añadimos el perejil bien picadito.\r\n¡Listo! Ya podemos disfrutar de nuestros REJOS CON PATATAS', '2020-11-18', '2', 'Publicada', NULL, '30 min', '5a1c6752-b9da-4018-bd38-f3411c9c039e'),
('2b154813-1efb-471a-a3fc-5791542d53e1', 'BARRITAS DE CHOCOLATE Y MANTECA DE CACAHUETE', 'Fácil', 'bcffa22c-05da-4b64-ab55-2da24efa4548_barritasdechocolate.jpg', 'Estos son los ingredientes que necesitas:\n8 Dátiles\n100g de copos de avena suaves sin gluten\n2 Cucharadas soperas colmadas de manteca de cacahuete crujiente\nCobertura:\n1 tableta de cacao puro 100% de Body Genius\n1 cucharadita de aceite de coco', 'En un bol con agua caliente ponemos a remojar los dátiles durante mínimo 15mim.\nMientras en una procesadora, molemos bien los copos de avena.\nSeguidamente cuando los dátiles estén bien hidratados, los escurrimos y las incorporamos a la procesadora.\nTrituramos bien hasta que forme una pasta.\nCubrimos una bandeja o recipiente con papel de hornear y ponemos la masa de base apretándola bien con los dedos.\nLlevamos al congelador mínimo 30mim.\nSeguidamente sacamos del congelador y cubrimos con manteca de cacahuete.\nCortamos en forma de barritas y llevamos al congelador de 2 a 3h\nFundimos el cacao junto al aceite de coco y cubrimos las barritas con la ayuda de. una cucharita.\nCuando esté fría la cobertura, podemos guardarlas en un recipiente hermético en la nevera.\n¡Listo! Ya podemos disfrutar de nuestras BARRITAS DE CHOCOLATE Y MANTECA DE CACAHUETE', '2020-12-02', '6', 'Publicada', NULL, '30 min', '5a1c6752-b9da-4018-bd38-f3411c9c039e'),
('4e3f3aff-33a6-4cf8-b953-ad6884d05ff4', 'TARTA DE QUESO Y FRESAS CON CHOCOLATE', 'media', '19d2190e-b053-42a6-b066-35cd65c28c61_fresasqueso.jpg', '400g de queso fresco batido 0%\r\n3 Huevos\r\n4 Cucharadas de maicena\r\n3 Cucharadas de cremoso de dátiles\r\nCrema de avellanas y chocolate saludable\r\nFresas', 'Batimos bien los huevos con el cremoso de dátiles, el queso fresco batido y la maicena.\r\nLlevamos a un molde en el que pondremos papel de hornear.\r\nCon el horno precalentado horneamos unos 50-60min a 180grados.\r\nDejamos enfriar.\r\nUntamos con la crema de chocolate.\r\nLavamos, cortamos y colocamos las láminas de fresas por encima.\r\n¡Listo! Ya podemos disfrutar de nuestra TARTA DE QUESO Y FRESAS CON CHOCOLATE', '2020-11-13', '6', 'Publicada', NULL, '60 min', '5a1c6752-b9da-4018-bd38-f3411c9c039e'),
('9a2259bf-83cf-45de-8229-1ce561815a28', 'ARROZ MELOSO CON CALAMARES', 'media', 'e1cf9aa0-5b99-404e-9dc7-24eff1ce0e38_arrozMelo.jpg', '1kg de calamares limpios\r\n 300g de arroz redondo\r\n 1 Puñado de guisantes\r\n 1 Cebolla grande\r\n 2 Zanahorias\r\n 3 Dientes de ajo\r\n 3-4 Cucharadas de tomate natural triturado\r\n Aceite de oliva virgen extra\r\n Pimento?n dulce de la vera\r\n Sal rosa\r\n 1600ml de Caldo de pescado', 'Cortamos la cebolla en trozos pequeños y la llevamos a la paellera con un buen chorro de aceite de oliva hasta que empiece a dorar.\r\nAñadimos los guisantes y la zanahoria cortadita también, pochamos ligeramente.\r\nAn?adimos los ajitos picados dejamos que se cocinen sin quemarse y an?adimos el tomate natural triturado.\r\nDejamos que se cocine el tomate y cuando empiece a estar sofrito agregamos pimento?n al gusto.\r\nIncorporamos los calamares cortados en trozos, mezclamos bien y cocinamos hasta que los calamares reduzcan de tamaño.\r\nAñadimos el arroz y lo sofreímos ligeramente.\r\nCubrimos con el caldo ya caliente.\r\nLlevamos a ebullicio?n y bajamos el fuego para que se cocine durante 18min.\r\nApagamos el fuego y dejamos reposar 5min\r\n¡Listo! Ya tenemos nuestros ARROZ MELOSO CON CALAMARES', '2020-11-18', '4', 'Publicada', NULL, '30 min', '43f67cbf-e8e2-4c92-a1f1-c0307dcd888f'),
('dd7cf7e2-e925-4148-aa6f-cd218fa893c6', 'BAGELS CASEROS EXPRESS Y PATE DE SARDINAS', 'Media', 'a0e7d3c2-81d7-4434-9d9b-0a8fedbe03b8_bagels.jpg', 'Estos son los ingredientes que necesitas para el paté:\n2 Aguacates maduros\n1 Lata de sardinas en aceite de oliva virgen extra\nZumo de medio limo?n\nPizca de sal rosa\nEstos son los ingredientes que necesitas para los bagels:\n360g de harina de trigo\n300ml de yogur griego ligero\nPizca de sal\nAceite de oliva virgen extra en spray\nClara de huevo\nSemillas de se?samo', 'Llevamos los ingredientes del pate al vaso de la batidora y procesamos bien hasta obtener una mezcla homoge?nea.\nGuardamos a un recipiente herme?tico y conservamos en la nevera para consumir en fri?o.\nPrecalentamos el horno a 200grados.\nMezclamos la harina con el yogur griego y una pizca de sal.\nCuando tengamos la masa lista, dividimos en 4 porciones y hacemos cuatro churros que posteriormente enrollaremos en forma de donut.\nLlevamos a una bandeja de hornear que engrasaremos ligeramente con el aceite en spray.\nPintamos con clara de huevo los bagels y an?adimos las semillas de se?samo.\nHorneamos durante 20-25min a 180grados\nDejamos enfriar, los abrimos por la mitad, los untamos de pate? de sardinas, an?adimos unas hojas de brotes verdes, unos tomates y aquello que te apetezca.\n¡Listo! Ya tenemos nuestros BAGELS CASEROS EXPRESS Y PATE? DE SARDINAS', '2020-12-06', '6', 'Publicada', 'No son esponjosos. Son una version rapida y sin complicaciones.\nNo llevan levadura pero puedes ponerla si quieres.\nLos bagels sera?n lo gorditos que hagas los churros antes de darles forma.', '40 min', '5a1c6752-b9da-4018-bd38-f3411c9c039e'),
('d4bc0a6b-dfbf-48a9-9630-81d082b3b08e', 'PIZZA DE ESPELTA INTEGRAL CON PERAS Y QUESO DE CABRA', 'Media', 'd4358b9a-38e3-461a-aad5-d915ecaa7f05_pizzapera.jpg', 'Para la masa:\n225 de harina de espelta integral\n175ml de agua\n1/2 sobre de levadura de panadero\n1/2 cucharada de aceite de oliva virgen extra\n2 cucharaditas de sal rosa del Himalaya\nPara el topping:\nSalsa de tomate casera\nQueso proteínico Eatlean\nCebolla Morada\n1 Pera\nQueso de cabra\nTomillo', 'Mezcla los ingredientes\nAmasa durante 10min\nDeja reposar la masa en un bol cubierto con un trapo durante 1h para que duplique su tamaño\nPasado el tiempo volvemos a amasar y damos forma a la pizza.\nPonemos el topping al gusto y horneamos a 180grados durante 20min\n¡Listo! Ya tenemos nuestra Pizza de espelta integral con peras y queso de cabra', '2020-12-06', '4', 'Publicada', 'Cortar la pera muy finita o si está muy madura en daditos', '50 min', '5a1c6752-b9da-4018-bd38-f3411c9c039e'),
('f3e4f958-9ec2-47bf-b98d-ad8ebe8cfbf9', 'DONUTS SALUDABLES VEGANOS', 'Media', '430edba3-fb62-4651-a452-f12bd2ad48b8_donutsveganos.png', 'Estos son los ingredientes que necesitas para esta receta:\n300g de harina de almendra\n40g harina de coco\n250ml de bebida vegetal\n80g de aceite de oliva\n70g de sirope de dátiles casero (receta en mi blog)\n1 cdta de levadura en polvo\nUnas gotas de esencia de vainilla\n1 pizca de sal\nTopping:\n100g de chocolate negro al 80%\n1 cucharadita de aceite de coco\n1 cucharadita de leche de coco\nFrutos secos picados, crema de cacahuete, coco deshidratado\nMermelada casera de frutos rojos', 'Proceso:\n Precalentamos el horno a 200ºC.\n Mezclamos en un bol los ingredientes secos y en otro los húmedos.\n Seguidamente mezclamos ambos hasta que nos quede una masa bien homogénea.\n Repartimos la masa en el molde de rosquillas que untaremos previamente con un poquito de aceite.\n Horneamos a 180grados durante 20min aproximadamente.\n Sacamos los donuts del horno, los dejamos reposar y desmoldamos.\n Dejamos enfriar sobre una rejilla.\n Para la cobertura de chocolate derretimos el chocolate con el aceite de coco al baño maría.\n Pasamos los donuts por el chocolate derretido y seguidamente le añadimos el topping que hayamos elegido.\n Para la cobertura de frutos rojos mezclamos la leche de coco con la mermelada y pasamos los donuts por la misma.\nSeguidamente le añadimos el topping que hayamos elegido.\n Antes de servirlos los metemos 15-20 minutos en la nevera para que la cobertura solidifique.\n¡Listo! Ya tenemos nuestros Donuts saludables veganos', NULL, '6', 'Borrador', NULL, '40 min', '5a1c6752-b9da-4018-bd38-f3411c9c039e'),
('942eb09c-ad13-49d9-80a3-bf634997eaff', 'CREPES DE AVENA CON MERMELADA DE ARÁNDANOS', 'Fácil', 'fe209820-59eb-46b6-b4c9-c5ed80283b5c_crepess.jpg', 'Estos son los ingredientes que necesitas para esta receta:\n40gr de Harina de avena integral\n120gr / 4 claras\n1 Chorrito de bebida vegetal (la que uséis)\nTopping\n1 Puñado de arándanos\nEdulcorante stevia (opcional)', 'En un bol apto para el microondas ponemos los arándanos, el edulcorante y un chorrito de agua (a más agua quedará como sirope)\nCocinamos a máxima potencia durante 1min.\nPasado ese tiempo retiramos y procesamos con la batidora de mano, reservamos la mezcla.\nEn un shaker ponemos la harina de avena, las claras y el chorrito de bebida vegetal.\nAgitamos bien para que no queden grumos.\nLlevamos la mezcla del shaker a una sartén antiadherente a fuego lento dando forma a nuestras crepes.\nUna vez cocinada la doblamos por la mitad, retiramos y continuamos con la mezcla hasta terminar.\nRetiramos y decoramos al gusto con la mermelada casera de arándanos.\n¡Listo! Ya tenemos nuestras Crepes de avena con mermelada de arándanos', '2020-12-09', '1', 'Publicada', NULL, '30 min', '23a65890-3f48-439f-b43e-b9459619b3fd'),
('5567e18b-0ae4-4ace-9ff7-2a2f61a5b52b', 'BURGERS DE LENTEJAS Y ARROZ CON KETCHUP CASERO', 'Media', 'a6780145-ea39-4cfe-9eae-cbe161f69936_hamburlentej.jpg', 'BURGERS DE LENTEJAS Y ARROZ CON KETCHUP CASERO\nDESTACADAS, COMIDAS, HAMBURGUESAS, RECETAS SALADAS, SALSAS-ALIÑOS, TODAS LAS RECETAS\n\nBURGERS DE LENTEJAS Y ARROZ CON KETCHUP CASERO\n¿Te gusta mi trabajo? ¡Compártelo con tus amigos! ?\n93\nVISTA\nPinea\nComparte\nImprime\nWhatsapea\nBURGERS DE LENTEJAS Y ARROZ CON KETCHUP CASERO\nEstos son los ingredientes que necesitas para el ketchup al curry casero:\n50g tomate frito casero (tomate y cebolla)\n40g agua\n20ml de vinagre de manzana\n1 cucharada de dulce de da?tiles\n1 pizca de clavo molido\n1 Cucharadita de canela en polvo\n1 Cucharadita de curry en polvo\n1 pizca de nuez moscada\nSal rosa\n1 cucharada de maicena\nEstos son los ingredientes que necesitas para las burgers:\n200g de lentejas cocidas (pueden ser de bote)\n200g de arroz integral cocido\n100g de calabaza asada\n1 Huevo\nComino', 'BURGERS DE LENTEJAS Y ARROZ CON KETCHUP CASERO\nDESTACADAS, COMIDAS, HAMBURGUESAS, RECETAS SALADAS, SALSAS-ALIÑOS, TODAS LAS RECETAS\n\nBURGERS DE LENTEJAS Y ARROZ CON KETCHUP CASERO\n¿Te gusta mi trabajo? ¡Compártelo con tus amigos! ?\n93\nVISTA\nPinea\nComparte\nImprime\nWhatsapea\nBURGERS DE LENTEJAS Y ARROZ CON KETCHUP CASERO\nEstos son los ingredientes que necesitas para el ketchup al curry casero:\n50g tomate frito casero (tomate y cebolla)\n40g agua\n20ml de vinagre de manzana\n1 cucharada de dulce de da?tiles\n1 pizca de clavo molido\n1 Cucharadita de canela en polvo\n1 Cucharadita de curry en polvo\n1 pizca de nuez moscada\nSal rosa\n1 cucharada de maicena\nEstos son los ingredientes que necesitas para las burgers:\n200g de lentejas cocidas (pueden ser de bote)\n200g de arroz integral cocido\n100g de calabaza asada\n1 Huevo\nComino\nProceso:\nMezclamos la maicena con el agua hasta que se disuelva bien y no queden grumos.\nSeguidamente an?adimos todos los ingredientes en una ollita y cocinamos sin dejar de remover hasta obtener una textura homoge?nea.\nDejamos templar y trituramos bien con la batidora hasta que nos quede una mezcla fina.\nLlevamos a un tarrito de cristal y guardamos en la nevera.\n¡Listo! Ya tenemos nuestro KETCHUP CASERO\nProceso:\nEn un bol mezclamos todos los ingredientes.\nCon la ayuda de una batidora de mano trituramos ligeramente (deben quedar trozos sin triturar para aportar textura)\nLlevamos la mezcla a una sarte?n antiadherente y vamos haciendo montan?itas que posteriormente con la ayuda de una cuchara daremos forma de hamburguesa.\nCocinamos a fuego medio/bajo hasta que les podamos dar la vuelta (ojo son delicadas).\nUna vez cocinadas por ambas caras podemos montar nuestra hamburguesa con su ketchup casero, queso, aguacate, jalapen?os y pan (como la mi?a)\n¡Listo! Ya tenemos nuestras BURGERS DE LENTEJAS Y ARROZ CON KETCHUP CASERO', '2020-12-09', '8', 'Publicada', NULL, '30 min', '23a65890-3f48-439f-b43e-b9459619b3fd'),
('c46fba11-ff3c-476d-aea7-119b382fecdd', 'QUESADILLAS VEGETARIANAS', 'Media', 'd170a6b5-7984-45c5-a3a7-c20713773287_quesadilla.jpg', 'Estos son los ingredientes que necesitas:\n175g de harina de espelta integral\n 20ml de aceite de oliva virgen extra\n 110ml de agua templada\n 1 Pizca de sal rosa del Himalaya\nIngredientes para el relleno:\nEspárragos trigueros\nTomate\nMaíz cocido\nQueso proteínico rallado Eatlean\nQueso Tasty Eatlean\nPimienta\nOrégano', 'Mezclamos los ingredientes de las tortillas.\nAmasamos bien hasta que ya no se nos pegue en las manos la masa.\nVamos tomando trocitos de masa y aplanamos con un rodillo.\n Con la ayuda de un plato les damos forma redonda y con el cuchillo recortamos.\nCocinamos la tortilla por ambos lados en una sartén.\nCuando hemos terminado de hacer todas las tortillas procedemos a rellenarlas.\nLavamos los espárragos, los cortamos y partimos por la mitad.\nLos llevamos al microondas durante 2min aprox.\n Cortamos el tomate en rodajas bien finas.\n Rellenamos las tortillas: queso, tomate, espárragos, queso, pimienta, orégano y otras igual pero con maíz.\n Llevamos a una sartén y cocinamos vuelta y vuelta presionando hasta que funda el queso.\n Cortamos por la mitad y servimos.\n¡Listo! Ya podemos disfrutar de nuestras QUESADILLAS VEGETARIANAS', '2020-12-09', '1', 'Publicada', NULL, '30 min', '23a65890-3f48-439f-b43e-b9459619b3fd'),
('94827c17-9fa4-4b75-83a9-b93bfaaf7d3e', 'ALUBIAS CON ALMEJAS EXPRESS', 'Fácil', 'd129d89c-b6f1-484f-869b-048a7f9dee1d_alubialmejas.jpg', '1 Bote de alubias blancas\n20 Almejas\n1 Cebolla grande\n2 Dientes de ajo\nSal rosa del Himalaya\nPimienta negra\nPerejil\nAceite de oliva virgen extra\n1 Vaso de agua', 'Cortamos la cebolla y la llevamos a una sartén con un buen chorrito de aceite de oliva.\nCuando empiece a dorarse añadimos los ajos bien picaditos y rehogamos.\nMientras ponemos las judías en un colador y las enjuagamos bien bajo el grifo de agua fría y las dejamos escurrir.\nAñadimos las almejas (que abremos tenido previamente la noche anterior en remojo con agua y sal) y dejamos que se abran.\nUna vez abiertas añadimos las alubias, el agua, una pizca de sal, pimienta y el perejil muy picadito.\nCocinamos a fuego medio/bajo hasta que quede medio dedo de caldo.\n¡Listo! Ya podemos disfrutar de nuestras ALUBIAS CON ALMEJAS EXPRESS', '2020-12-09', '4', 'Publicada', NULL, '60 min', '23a65890-3f48-439f-b43e-b9459619b3fd');

--
-- Volcado de datos para la tabla `recipes_label`
--

INSERT INTO `recipes_label` (`recipe_id`, `label_id`) VALUES
('9cc29489-e829-4da5-a3da-84bd0c1a8efc', '5275f2b4-3bc5-4aed-a3a6-5e760b68785d'),
('9cc29489-e829-4da5-a3da-84bd0c1a8efc', 'b6fdfe2a-8b2f-48cf-9985-9c966f0fa8d8'),
('d3da512d-7e3e-4e36-8524-d067bb5ecc6c', 'b6fdfe2a-8b2f-48cf-9985-9c966f0fa8d8'),
('d3da512d-7e3e-4e36-8524-d067bb5ecc6c', 'b5cb21a3-b091-499d-ac79-5d7d83aa8de7'),
('3781df44-cc17-4155-a42a-b89b4c155977', 'cfb95baa-105a-465f-a369-e26999b4e589'),
('3781df44-cc17-4155-a42a-b89b4c155977', 'b5cb21a3-b091-499d-ac79-5d7d83aa8de7'),
('9cc29489-e829-4da5-a3da-84bd0c1a8efc', 'b5cb21a3-b091-499d-ac79-5d7d83aa8de7'),
('da435920-0ebc-46d8-bb16-cc6bfecef349', 'b5cb21a3-b091-499d-ac79-5d7d83aa8de7'),
('da435920-0ebc-46d8-bb16-cc6bfecef349', '4fe4bc67-0de1-42c5-b394-26a474e9c883'),
('da435920-0ebc-46d8-bb16-cc6bfecef349', 'e02d0680-ff8e-41f0-b82a-f83781188a72'),
('4e3f3aff-33a6-4cf8-b953-ad6884d05ff4', 'cfb95baa-105a-465f-a369-e26999b4e589'),
('d3d296d9-1c0d-4d0f-b93c-510400692015', '5275f2b4-3bc5-4aed-a3a6-5e760b68785d'),
('2b154813-1efb-471a-a3fc-5791542d53e1', '4fe4bc67-0de1-42c5-b394-26a474e9c883'),
('89e963ae-1d6c-48e5-bd16-e73e3c794bf0', 'cfb95baa-105a-465f-a369-e26999b4e589'),
('89e963ae-1d6c-48e5-bd16-e73e3c794bf0', 'b5cb21a3-b091-499d-ac79-5d7d83aa8de7'),
('89e963ae-1d6c-48e5-bd16-e73e3c794bf0', '1'),
('89e963ae-1d6c-48e5-bd16-e73e3c794bf0', 'fc5f2269-e1d9-4c8f-9ee0-38c9025321e3'),
('dd7cf7e2-e925-4148-aa6f-cd218fa893c6', 'e02d0680-ff8e-41f0-b82a-f83781188a72'),
('dd7cf7e2-e925-4148-aa6f-cd218fa893c6', 'fc5f2269-e1d9-4c8f-9ee0-38c9025321e3'),
('dd7cf7e2-e925-4148-aa6f-cd218fa893c6', '3c78aa85-e999-4997-8b6f-e60cdffaf654'),
('05dd048b-f7cb-4c3c-b28b-69f679fcafdc', 'b6fdfe2a-8b2f-48cf-9985-9c966f0fa8d8'),
('d741e900-4ce5-4823-8d6d-8152f01bc213', '3c78aa85-e999-4997-8b6f-e60cdffaf654'),
('364a390b-0196-4c9f-b4bb-f919221bbbb2', '3c78aa85-e999-4997-8b6f-e60cdffaf654'),
('c0efda57-8351-43ab-9fdb-fc84d65f47ac', '3c78aa85-e999-4997-8b6f-e60cdffaf654'),
('ae0ba63b-d26b-442b-8d4c-25b9be5cf26a', '1'),
('2439f1b9-4f70-4cc7-b541-010ed0d72967', '3c78aa85-e999-4997-8b6f-e60cdffaf654'),
('2b154813-1efb-471a-a3fc-5791542d53e1', 'b5cb21a3-b091-499d-ac79-5d7d83aa8de7'),
('2b154813-1efb-471a-a3fc-5791542d53e1', 'cfb95baa-105a-465f-a369-e26999b4e589'),
('d4bc0a6b-dfbf-48a9-9630-81d082b3b08e', 'fc5f2269-e1d9-4c8f-9ee0-38c9025321e3'),
('d4bc0a6b-dfbf-48a9-9630-81d082b3b08e', 'b5cb21a3-b091-499d-ac79-5d7d83aa8de7'),
('f3e4f958-9ec2-47bf-b98d-ad8ebe8cfbf9', 'cfb95baa-105a-465f-a369-e26999b4e589'),
('f3e4f958-9ec2-47bf-b98d-ad8ebe8cfbf9', '4fe4bc67-0de1-42c5-b394-26a474e9c883'),
('f3e4f958-9ec2-47bf-b98d-ad8ebe8cfbf9', 'b5cb21a3-b091-499d-ac79-5d7d83aa8de7'),
('942eb09c-ad13-49d9-80a3-bf634997eaff', 'e02d0680-ff8e-41f0-b82a-f83781188a72'),
('942eb09c-ad13-49d9-80a3-bf634997eaff', 'b5cb21a3-b091-499d-ac79-5d7d83aa8de7'),
('942eb09c-ad13-49d9-80a3-bf634997eaff', 'cfb95baa-105a-465f-a369-e26999b4e589'),
('5567e18b-0ae4-4ace-9ff7-2a2f61a5b52b', 'b5cb21a3-b091-499d-ac79-5d7d83aa8de7'),
('5567e18b-0ae4-4ace-9ff7-2a2f61a5b52b', '4fe4bc67-0de1-42c5-b394-26a474e9c883'),
('5567e18b-0ae4-4ace-9ff7-2a2f61a5b52b', 'b6fdfe2a-8b2f-48cf-9985-9c966f0fa8d8'),
('c46fba11-ff3c-476d-aea7-119b382fecdd', 'e02d0680-ff8e-41f0-b82a-f83781188a72'),
('c46fba11-ff3c-476d-aea7-119b382fecdd', 'b5cb21a3-b091-499d-ac79-5d7d83aa8de7'),
('c46fba11-ff3c-476d-aea7-119b382fecdd', 'b6fdfe2a-8b2f-48cf-9985-9c966f0fa8d8'),
('c46fba11-ff3c-476d-aea7-119b382fecdd', 'fc5f2269-e1d9-4c8f-9ee0-38c9025321e3'),
('c46fba11-ff3c-476d-aea7-119b382fecdd', '45656'),
('94827c17-9fa4-4b75-83a9-b93bfaaf7d3e', '3c78aa85-e999-4997-8b6f-e60cdffaf654'),
('94827c17-9fa4-4b75-83a9-b93bfaaf7d3e', 'e02d0680-ff8e-41f0-b82a-f83781188a72');

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
('45b7ab32-98de-4f21-bb6e-156de0d4890d', ' ', 'd3d296d9-1c0d-4d0f-b93c-510400692015', 'e88cce16-dd81-4ce3-a753-e8e148f73da6'),
('4b3e9dc6-b969-4d43-9640-190b56a0e2a6', ' ', '9cc29489-e829-4da5-a3da-84bd0c1a8efc', '6e1a5371-27f9-4d23-918a-aa75a4168261'),
('94ce972a-5ed3-44fb-9e72-9d899738ed5b', ' ', '2b154813-1efb-471a-a3fc-5791542d53e1', '8af7f277-ba87-466d-a8fe-2dc6c29d13cf'),
('af2d7817-f8b3-46b7-be61-411a73b0fccb', ' ', '4e3f3aff-33a6-4cf8-b953-ad6884d05ff4', '8af7f277-ba87-466d-a8fe-2dc6c29d13cf'),
('f9ef2e9f-d30e-4bb6-9ac5-7cf0939d3c9d', ' ', '9a2259bf-83cf-45de-8229-1ce561815a28', '8af7f277-ba87-466d-a8fe-2dc6c29d13cf'),
('0f7040ab-b6de-497d-aae1-999beea84bae', ' ', 'd3da512d-7e3e-4e36-8524-d067bb5ecc6c', '8af7f277-ba87-466d-a8fe-2dc6c29d13cf'),
('5f356588-75a2-4e12-91e2-892e462054ac', ' ', 'd4bc0a6b-dfbf-48a9-9630-81d082b3b08e', '8af7f277-ba87-466d-a8fe-2dc6c29d13cf');

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
('c4b4b504-df69-4890-a0d8-f9f4047db652', 'maria', 'maria@pruff.com', '71b3b26aaa319e0cdf6fdb8429c112b0', 'perez'),
('8af7f277-ba87-466d-a8fe-2dc6c29d13cf', 'Lola', 'lolag@pruff.com', '4648f011b776dd6d9100a9679118315d', 'Gomez');

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
('6e1a5371-27f9-4d23-918a-aa75a4168261', '2'),
('c4b4b504-df69-4890-a0d8-f9f4047db652', '2'),
('8af7f277-ba87-466d-a8fe-2dc6c29d13cf', '3');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
