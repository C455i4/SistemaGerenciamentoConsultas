-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 26-Ago-2022 às 01:03
-- Versão do servidor: 10.4.22-MariaDB
-- versão do PHP: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `consultorio`
--

DELIMITER $$
--
-- Procedimentos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `pesquisar_funcionario_sp` (IN `nome` VARCHAR(30))  BEGIN
	SELECT f.idfunc, f.nome, f.cpf, f.email, f.telefone, f.dataadmissao, f.sexo
    FROM funcionario AS f
    WHERE f.nome LIKE concat(nome, '%');
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `pesquisar_medico_sp` (IN `nome` VARCHAR(30))  BEGIN
	SELECT m.idmedico, m.nome, m.crm, m.email, m.telefone, m.especializacao
    FROM medico AS m
    WHERE m.nome LIKE concat(nome, '%');
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `pesquisar_pacientes_sp` (IN `nome` VARCHAR(30))  BEGIN
       	SELECT p.idpaciente, p.nome, p.cpf, p.email, p.sexo, p.telefone, p.datanasc
        FROM paciente AS p
        WHERE p.nome LIKE concat(nome, '%');
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `consulta`
--

CREATE TABLE `consulta` (
  `idconsulta` int(100) NOT NULL,
  `dataatend` varchar(20) NOT NULL,
  `horario` varchar(20) NOT NULL,
  `idpaciente` int(11) NOT NULL,
  `idmedico` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `consulta`
--

INSERT INTO `consulta` (`idconsulta`, `dataatend`, `horario`, `idpaciente`, `idmedico`) VALUES
(1, '12/09/2022', '14:30', 4, 2),
(3, '23/08/2022', '13:30', 3, 3),
(4, '09/09/2022', '12:30', 3, 3),
(5, '25/08/2022', '16:00', 8, 2),
(6, '12/09/2022', '14:50', 3, 2),
(7, '24/09/2022', '09:30', 6, 4),
(8, '14/08/2022', '12:00', 7, 4),
(9, '30/10/2022', '14:00', 9, 6),
(10, '12/06/2023', '14:30', 1, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `idfunc` int(100) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `cpf` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `telefone` varchar(100) NOT NULL,
  `dataadmissao` varchar(100) NOT NULL,
  `sexo` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`idfunc`, `nome`, `cpf`, `email`, `telefone`, `dataadmissao`, `sexo`) VALUES
(1, 'Dalila Junia Ferreira', '213.213.133-13', 'dalila@gmail.com', '(038)32432-4223', '12/09/2009', 'feminino'),
(2, 'Fábio Silva Nunes', '213.213.132-13', 'fabio@gmail.com', '(038)32432-4242', '19/07/2000', 'masculino'),
(3, 'Maria Souza de Fátima', '123.123.213-32', 'maria@gmail.com', '(038)32432-4242', '23/05/2016', 'feminino');

-- --------------------------------------------------------

--
-- Estrutura da tabela `medico`
--

CREATE TABLE `medico` (
  `idmedico` int(150) NOT NULL,
  `nome` varchar(150) NOT NULL,
  `crm` varchar(150) NOT NULL,
  `email` varchar(150) NOT NULL,
  `telefone` varchar(150) NOT NULL,
  `especializacao` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `medico`
--

INSERT INTO `medico` (`idmedico`, `nome`, `crm`, `email`, `telefone`, `especializacao`) VALUES
(2, 'Sarah Fortune', '123957/RR', 'sarah@gmail.com', '(038)77777-7777', 'cirurgia plastica'),
(3, 'Agostinho Pires', '123343/MG', 'agostinho@gmail.com', '(123)42424-3242', 'cirurgia plastica'),
(4, 'Gabriel Costa Duarte', '123456/SP', 'gabriel@gmail.com', '(038)77777-7777', 'ortopedista'),
(6, 'Pedro Suzano Bertolino', '837362/ES', 'pedro@gmail.com', '(039)63437-8333', 'cardiologista'),
(7, 'Joao Silva', '223', 'joaos@gmail.com', '(389)89999-9999', 'pediatra');

-- --------------------------------------------------------

--
-- Estrutura da tabela `paciente`
--

CREATE TABLE `paciente` (
  `idpaciente` int(100) NOT NULL,
  `nome` varchar(150) NOT NULL,
  `cpf` varchar(150) NOT NULL,
  `email` varchar(150) NOT NULL,
  `sexo` varchar(150) NOT NULL,
  `telefone` varchar(150) NOT NULL,
  `datanasc` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `paciente`
--

INSERT INTO `paciente` (`idpaciente`, `nome`, `cpf`, `email`, `sexo`, `telefone`, `datanasc`) VALUES
(1, 'Cassia Pires', '123.456.789-99', 'cassia@gmail.com', 'feminino', '(038)74667-4637', '26/06/2000'),
(3, 'Aguinele Queiroz Silva', '234.564.432-22', 'aguinele@gmail.com', 'masculino', '(038)99999-9999', '04/08/2003'),
(4, 'Patrick de Paula Barroso', '877.686.757-45', 'patrickdepaula@gmail.com', 'masculino', '(038)77777-7777', '05/07/2008'),
(6, 'Ana Silva', '224.324.234-23', 'ana@gmail.com', 'feminino', '(123)44443-3333', '12/03/2002'),
(7, 'Joao Costa ', '212.343.243-24', 'joao@gmail.com', 'masculino', '(242)34234-2342', '12/07/2005'),
(8, 'Hugo Leonardo Ribeiro Roquette', '432.353.453-54', 'hugo@gmail.com', 'masculino', '(038)99999-9999', '12/04/2001'),
(9, 'Yuri Tamashida', '343.242.432-42', 'yurikamikaze@gmail.com', 'masculino', '(038)63267-4743', '12/09/2004'),
(10, 'Angela Souza Vieira', '234.234.324-32', 'angela@gmail.com', 'feminino', '(038)76732-7637', '01/07/2001'),
(12, 'Maria Silva', '123.456.789-99', 'maria@gmail.com', 'feminino', '(   )     -    ', '12/06/2001');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `consulta`
--
ALTER TABLE `consulta`
  ADD PRIMARY KEY (`idconsulta`),
  ADD KEY `fk_paciente_consulta` (`idpaciente`),
  ADD KEY `fk_medico_consulta` (`idmedico`);

--
-- Índices para tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`idfunc`);

--
-- Índices para tabela `medico`
--
ALTER TABLE `medico`
  ADD PRIMARY KEY (`idmedico`);

--
-- Índices para tabela `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`idpaciente`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `consulta`
--
ALTER TABLE `consulta`
  MODIFY `idconsulta` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de tabela `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `idfunc` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `medico`
--
ALTER TABLE `medico`
  MODIFY `idmedico` int(150) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `paciente`
--
ALTER TABLE `paciente`
  MODIFY `idpaciente` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `consulta`
--
ALTER TABLE `consulta`
  ADD CONSTRAINT `fk_medico_consulta` FOREIGN KEY (`idmedico`) REFERENCES `medico` (`idmedico`),
  ADD CONSTRAINT `fk_paciente_consulta` FOREIGN KEY (`idpaciente`) REFERENCES `paciente` (`idpaciente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
