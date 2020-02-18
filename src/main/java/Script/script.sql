#
# TABLE STRUCTURE FOR: cliente
#


CREATE TABLE `cliente` IF NOT EXISTS (
  `id` int(9) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  UNIQUE KEY `cpf_2` (`cpf`),
  KEY `id` (`id`),
  KEY `cpf` (`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

INSERT INTO `cliente` ( `nome`, `cpf`) VALUES ( 'Kennedy Blanda', '10781284003');
INSERT INTO `cliente` ( `nome`, `cpf`) VALUES ('Micaela Kassulke', '15631831019');
INSERT INTO `cliente` ( `nome`, `cpf`) VALUES ('Emilie Denesik', '18855196750');
INSERT INTO `cliente` ( `nome`, `cpf`) VALUES ( 'Jackeline White', '32803258440');
INSERT INTO `cliente` ( `nome`, `cpf`) VALUES ( 'Sabrina Schmitt V', '37662620191');
INSERT INTO `cliente` ( `nome`, `cpf`) VALUES ( 'Prof. Olen Kautzer Jr.', '57084893016');
INSERT INTO `cliente` ( `nome`, `cpf`) VALUES ( 'Ansley Reichel', '62710092449');
INSERT INTO `cliente` ( `nome`, `cpf`) VALUES ( 'Bettye Schowalter', '67736990610');
INSERT INTO `cliente` ( `nome`, `cpf`) VALUES ( 'Dr. Hellen Conn', '73253778554');
INSERT INTO `cliente` ( `nome`, `cpf`) VALUES ( 'Rahsaan Cole PhD', '92757064430');


#
# TABLE STRUCTURE FOR: produto
#

DROP TABLE IF EXISTS `produto`;

CREATE TABLE `produto` (
  `idProduto` varchar(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `preco` decimal(10,2) unsigned NOT NULL,
  `estoqueAtual` int(11) unsigned,
  `estoqueMinimo` int(11) unsigned,
  KEY `idProduto` (`idProduto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

