-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 13-Jun-2017 às 22:05
-- Versão do servidor: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `biblintelligence`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `listaAutoresAtivos` ()  NO SQL
SELECT * FROM autores WHERE desativado=false$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `listaAutoresDesativados` ()  NO SQL
SELECT * FROM autores WHERE desativado=true$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `listaBaixa` (IN `idLivro` INT, IN `livro` VARCHAR(100), IN `tombo` VARCHAR(10))  NO SQL
BEGIN
DECLARE livroID,livroID2,livroID3 INT;

IF (idLivro is null) and (livro is null) and (tombo is null) THEN
	select emprestimos.idEmprestimo, emprestimos.dataRetirada, emprestimos.dataEstDevolucao,livros.nome "livro", usuarios.nome "responsavel",emprestimos.atrasado from emprestimos
	join livros on emprestimos.livro=livros.idLivro
	join usuarios on emprestimos.respEmprestimo=usuarios.idUsuario
	where emprestimos.devolvido=true and emprestimos.baixa=false and emprestimos.desativado=false;

ELSEIF (idLivro is null) and (livro is null) THEN
SELECT idLivro INTO livroID FROM livros where livros.tombo = tombo;
	select emprestimos.idEmprestimo, emprestimos.dataRetirada, emprestimos.dataEstDevolucao,livros.nome "livro", usuarios.nome "responsavel",emprestimos.atrasado from emprestimos
	join livros on emprestimos.livro=livros.idLivro
	join usuarios on emprestimos.respEmprestimo=usuarios.idUsuario
	where emprestimos.devolvido=true and emprestimos.baixa=false and emprestimos.desativado=false and emprestimos.livro = livroID;

ELSEIF (idLivro is null) and (tombo is null) THEN
SELECT idLivro INTO livroID FROM livros where livros.nome = livro;
	select emprestimos.idEmprestimo, emprestimos.dataRetirada, emprestimos.dataEstDevolucao,livros.nome "livro", usuarios.nome "responsavel",emprestimos.atrasado from emprestimos
	join livros on emprestimos.livro=livros.idLivro
	join usuarios on emprestimos.respEmprestimo=usuarios.idUsuario
	where emprestimos.devolvido=true and emprestimos.baixa=false and emprestimos.desativado=false and emprestimos.livro = livroID;

ELSEIF (idLivro is null) THEN
	SELECT idLivro INTO livroID FROM livros where livros.nome = livro;
	SELECT idLivro INTO livroID2 FROM livros where livros.tombo = tombo;
		IF (livroID is null) THEN
			IF(livroID2 is null) THEN
				select emprestimos.idEmprestimo, emprestimos.dataRetirada, emprestimos.dataEstDevolucao,livros.nome "livro", usuarios.nome "responsavel",emprestimos.atrasado from emprestimos
				join livros on emprestimos.livro=livros.idLivro
				join usuarios on emprestimos.respEmprestimo=usuarios.idUsuario
				where emprestimos.devolvido=true and emprestimos.baixa=false and emprestimos.desativado=false and emprestimos.livro = NULL;
			ELSE
				IF(livroID=livroID2) THEN
					select emprestimos.idEmprestimo, emprestimos.dataRetirada, emprestimos.dataEstDevolucao,livros.nome "livro", usuarios.nome "responsavel",emprestimos.atrasado from emprestimos
					join livros on emprestimos.livro=livros.idLivro
					join usuarios on emprestimos.respEmprestimo=usuarios.idUsuario
					where emprestimos.devolvido=true and emprestimos.baixa=false and emprestimos.desativado=false and emprestimos.livro = livroID;
				ELSE
					select emprestimos.idEmprestimo, emprestimos.dataRetirada, emprestimos.dataEstDevolucao,livros.nome "livro", usuarios.nome "responsavel",emprestimos.atrasado from emprestimos
					join livros on emprestimos.livro=livros.idLivro
					join usuarios on emprestimos.respEmprestimo=usuarios.idUsuario
					where emprestimos.devolvido=true and emprestimos.baixa=false and emprestimos.desativado=false and emprestimos.livro = NULL;
				END IF;
			END IF;
		END IF;

ELSEIF (livro is null) and (tombo is null) THEN
	select emprestimos.idEmprestimo, emprestimos.dataRetirada, emprestimos.dataEstDevolucao,livros.nome "livro", usuarios.nome "responsavel",emprestimos.atrasado from emprestimos
	join livros on emprestimos.livro=livros.idLivro
	join usuarios on emprestimos.respEmprestimo=usuarios.idUsuario
	where emprestimos.devolvido=true and emprestimos.baixa=false and emprestimos.desativado=false and emprestimos.livro = idLivro;

ELSEIF (livro is null) THEN
	SELECT idLivro INTO livroID FROM livros where livros.tombo = tombo;
		IF(livroID=idLivro) THEN
			select emprestimos.idEmprestimo, emprestimos.dataRetirada, emprestimos.dataEstDevolucao,livros.nome "livro", usuarios.nome "responsavel",emprestimos.atrasado from emprestimos
			join livros on emprestimos.livro=livros.idLivro
			join usuarios on emprestimos.respEmprestimo=usuarios.idUsuario
			where emprestimos.devolvido=true and emprestimos.baixa=false and emprestimos.desativado=false and emprestimos.livro = livroID;
		ELSE
			select emprestimos.idEmprestimo, emprestimos.dataRetirada, emprestimos.dataEstDevolucao,livros.nome "livro", usuarios.nome "responsavel",emprestimos.atrasado from emprestimos
			join livros on emprestimos.livro=livros.idLivro
			join usuarios on emprestimos.respEmprestimo=usuarios.idUsuario
			where emprestimos.devolvido=true and emprestimos.baixa=false and emprestimos.desativado=false and emprestimos.livro = NULL;
		END IF;

ELSEIF (tombo is null) THEN
	SELECT idLivro INTO livroID FROM livros where livros.nome = livro;
		IF(livroID=idLivro) THEN
			select emprestimos.idEmprestimo, emprestimos.dataRetirada, emprestimos.dataEstDevolucao,livros.nome "livro", usuarios.nome "responsavel",emprestimos.atrasado from emprestimos
			join livros on emprestimos.livro=livros.idLivro
			join usuarios on emprestimos.respEmprestimo=usuarios.idUsuario
			where emprestimos.devolvido=true and emprestimos.baixa=false and emprestimos.desativado=false and emprestimos.livro = livroID;
		ELSE
			select emprestimos.idEmprestimo, emprestimos.dataRetirada, emprestimos.dataEstDevolucao,livros.nome "livro", usuarios.nome "responsavel",emprestimos.atrasado from emprestimos
			join livros on emprestimos.livro=livros.idLivro
			join usuarios on emprestimos.respEmprestimo=usuarios.idUsuario
			where emprestimos.devolvido=true and emprestimos.baixa=false and emprestimos.desativado=false and emprestimos.livro = NULL;
		END IF;

ELSE
	SELECT idLivro INTO livroID FROM livros where livros.nome = livro;
	SELECT idLivro INTO livroID2 FROM livros where livros.tombo = tombo;
	IF (livroID=livroID2=idLivro) THEN
		select emprestimos.idEmprestimo, emprestimos.dataRetirada, emprestimos.dataEstDevolucao,livros.nome "livro", usuarios.nome "responsavel",emprestimos.atrasado from emprestimos
		join livros on emprestimos.livro=livros.idLivro
		join usuarios on emprestimos.respEmprestimo=usuarios.idUsuario
		where emprestimos.devolvido=true and emprestimos.baixa=false and emprestimos.desativado=false and emprestimos.livro = IDlivro;
	ELSE
		select emprestimos.idEmprestimo, emprestimos.dataRetirada, emprestimos.dataEstDevolucao,livros.nome "livro", usuarios.nome "responsavel",emprestimos.atrasado from emprestimos
		join livros on emprestimos.livro=livros.idLivro
		join usuarios on emprestimos.respEmprestimo=usuarios.idUsuario
		where emprestimos.devolvido=true and emprestimos.baixa=false and emprestimos.desativado=false and emprestimos.livro = NULL;		
	END IF;

END IF;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `listaDevolucao` (IN `user` INT)  NO SQL
select emprestimos.idEmprestimo, emprestimos.dataRetirada, emprestimos.dataEstDevolucao,livros.nome "livro", usuarios.nome "responsavel",emprestimos.atrasado from emprestimos
join livros on emprestimos.livro=livros.idLivro
join usuarios on emprestimos.respEmprestimo=usuarios.idUsuario
where emprestimos.usuario=user and emprestimos.devolvido=false and emprestimos.desativado=false$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `listaEditorasAtivas` ()  NO SQL
SELECT * FROM editoras WHERE desativado=false$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `listaEditorasDesativadas` ()  NO SQL
SELECT * FROM editoras WHERE desativado=true$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `listaEventos` (IN `oper` INT, IN `dataInicial` DATE, IN `dataFinal` DATE, IN `evento` INT)  NO SQL
if oper=0 THEN
select log.idEvento,log.dataEvento,usuarios.nome "usuarioLogado",log.ref,codigoevento.descricao "evento" from log
join usuarios on idUsuario = log.usuarioLogado
join codigoevento on idCodEvento = log.evento;

ELSEIF oper=1 then
select log.idEvento,log.dataEvento,usuarios.nome "usuarioLogado",log.ref,codigoevento.descricao "evento" from log
join usuarios on idUsuario = log.usuarioLogado
join codigoevento on idCodEvento = log.evento
where dataEvento BETWEEN dataInicial AND dataFinal;

ELSE
select log.idEvento,log.dataEvento,usuarios.nome "usuarioLogado",log.ref,codigoevento.descricao "evento" from log
join usuarios on idUsuario = log.usuarioLogado
join codigoevento on idCodEvento = log.evento
where dataEvento BETWEEN dataInicial AND dataFinal and log.evento=evento;

end if$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `listaGruposSegAtivos` ()  NO SQL
SELECT * FROM gruposeg where desativado=false$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `listaGruposSegDesativados` ()  NO SQL
SELECT * FROM gruposeg where desativado=true$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `listaLivrosAtivos` ()  NO SQL
SELECT * FROM livros WHERE desativado=false$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `listaLivrosDesativados` ()  NO SQL
SELECT * FROM livros WHERE desativado=true$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `listaLivrosPEmprestimo` (IN `tombo` VARCHAR(10), IN `livro` VARCHAR(100), IN `aut` VARCHAR(50), IN `edit` VARCHAR(50), IN `ano` INT)  NO SQL
BEGIN
DECLARE editora,autor INT;

SELECT idEditora INTO editora FROM editoras where editoras.nome = edit;
IF (editora is null) and (edit is not null) THEN
   set editora=-1;
END IF;
SELECT idAutor INTO autor FROM autores where autores.nome = aut;
IF (autor is null) and (aut is not null) THEN
   set autor=-1;
END IF;

IF (tombo is null) and (livro is null) and (autor is null) and (editora is null) and (ano is null) then
	SELECT livros.idLivro, livros.tombo, livros.isbn, livros.nome, livros.edicao,editoras.nome "editora", autores.nome "autor", livros.ano, livros.paginas, livros.estado, livros.descricao, livros.emprestado, livros.desativado from livros
	join editoras on editoras.idEditora = livros.editora
	join autores on autores.idAutor = livros.autor
	where livros.emprestado=false and livros.desativado=false;

ELSEIF (tombo is null) and (livro is null) and (autor is null) and (editora is null) then
	SELECT livros.idLivro, livros.tombo, livros.isbn, livros.nome, livros.edicao,editoras.nome "editora", autores.nome "autor", livros.ano, livros.paginas, livros.estado, livros.descricao, livros.emprestado, livros.desativado from livros
	join editoras on editoras.idEditora = livros.editora
	join autores on autores.idAutor = livros.autor
	where livros.emprestado=false and livros.desativado=false and livros.ano=ano;
	
ELSEIF (tombo is null) and (livro is null) and (autor is null) and (ano is null) then	
	SELECT livros.idLivro, livros.tombo, livros.isbn, livros.nome, livros.edicao,editoras.nome "editora", autores.nome "autor", livros.ano, livros.paginas, livros.estado, livros.descricao, livros.emprestado, livros.desativado from livros
	join editoras on editoras.idEditora = livros.editora
	join autores on autores.idAutor = livros.autor
	where livros.emprestado=false and livros.desativado=false and livros.editora=editora;
	
ELSEIF (tombo is null) and (livro is null) and (autor is null) then	
	SELECT livros.idLivro, livros.tombo, livros.isbn, livros.nome, livros.edicao,editoras.nome "editora", autores.nome "autor", livros.ano, livros.paginas, livros.estado, livros.descricao, livros.emprestado, livros.desativado from livros
	join editoras on editoras.idEditora = livros.editora
	join autores on autores.idAutor = livros.autor
	where livros.emprestado=false and livros.desativado=false and livros.editora=editora and livros.ano=ano;

ELSEIF (tombo is null) and (livro is null) and (editora is null) and (ano is null) then
	SELECT livros.idLivro, livros.tombo, livros.isbn, livros.nome, livros.edicao,editoras.nome "editora", autores.nome "autor", livros.ano, livros.paginas, livros.estado, livros.descricao, livros.emprestado, livros.desativado from livros
	join editoras on editoras.idEditora = livros.editora
	join autores on autores.idAutor = livros.autor
	where livros.emprestado=false and livros.desativado=false and livros.autor=autor;
	
ELSEIF (tombo is null) and (livro is null) and (editora is null) then
	SELECT livros.idLivro, livros.tombo, livros.isbn, livros.nome, livros.edicao,editoras.nome "editora", autores.nome "autor", livros.ano, livros.paginas, livros.estado, livros.descricao, livros.emprestado, livros.desativado from livros
	join editoras on editoras.idEditora = livros.editora
	join autores on autores.idAutor = livros.autor
	where livros.emprestado=false and livros.desativado=false and livros.autor=autor and livros.ano=ano;

ELSEIF (tombo is null) and (livro is null) and (ano is null) then
	SELECT livros.idLivro, livros.tombo, livros.isbn, livros.nome, livros.edicao,editoras.nome "editora", autores.nome "autor", livros.ano, livros.paginas, livros.estado, livros.descricao, livros.emprestado, livros.desativado from livros
	join editoras on editoras.idEditora = livros.editora
	join autores on autores.idAutor = livros.autor
	where livros.emprestado=false and livros.desativado=false and livros.autor=autor and livros.editora=editora;

ELSEIF (tombo is null) and (livro is null) then
	SELECT livros.idLivro, livros.tombo, livros.isbn, livros.nome, livros.edicao,editoras.nome "editora", autores.nome "autor", livros.ano, livros.paginas, livros.estado, livros.descricao, livros.emprestado, livros.desativado from livros
	join editoras on editoras.idEditora = livros.editora
	join autores on autores.idAutor = livros.autor
	where livros.emprestado=false and livros.desativado=false and livros.autor=autor and livros.editora=editora and livros.ano=ano;

ELSEIF (tombo is null) and (autor is null) and (editora is null) and (ano is null) then
	SELECT livros.idLivro, livros.tombo, livros.isbn, livros.nome, livros.edicao,editoras.nome "editora", autores.nome "autor", livros.ano, livros.paginas, livros.estado, livros.descricao, livros.emprestado, livros.desativado from livros
	join editoras on editoras.idEditora = livros.editora
	join autores on autores.idAutor = livros.autor
	where livros.emprestado=false and livros.desativado=false and livros.nome=livro;

ELSEIF (tombo is null) and (autor is null) and (editora is null) then
	SELECT livros.idLivro, livros.tombo, livros.isbn, livros.nome, livros.edicao,editoras.nome "editora", autores.nome "autor", livros.ano, livros.paginas, livros.estado, livros.descricao, livros.emprestado, livros.desativado from livros
	join editoras on editoras.idEditora = livros.editora
	join autores on autores.idAutor = livros.autor
	where livros.emprestado=false and livros.desativado=false and livros.nome=livro and livros.ano=ano;

ELSEIF (tombo is null) and (autor is null) and (ano is null) then
	SELECT livros.idLivro, livros.tombo, livros.isbn, livros.nome, livros.edicao,editoras.nome "editora", autores.nome "autor", livros.ano, livros.paginas, livros.estado, livros.descricao, livros.emprestado, livros.desativado from livros
	join editoras on editoras.idEditora = livros.editora
	join autores on autores.idAutor = livros.autor
	where livros.emprestado=false and livros.desativado=false and livros.nome=livro and livros.editora=editora;	
	
ELSEIF (tombo is null) and (autor is null) then
	SELECT livros.idLivro, livros.tombo, livros.isbn, livros.nome, livros.edicao,editoras.nome "editora", autores.nome "autor", livros.ano, livros.paginas, livros.estado, livros.descricao, livros.emprestado, livros.desativado from livros
	join editoras on editoras.idEditora = livros.editora
	join autores on autores.idAutor = livros.autor
	where livros.emprestado=false and livros.desativado=false and livros.nome=livro and livros.editora=editora and livros.ano=ano;
	
ELSEIF (tombo is null) and (editora is null) and (ano is null) then
	SELECT livros.idLivro, livros.tombo, livros.isbn, livros.nome, livros.edicao,editoras.nome "editora", autores.nome "autor", livros.ano, livros.paginas, livros.estado, livros.descricao, livros.emprestado, livros.desativado from livros
	join editoras on editoras.idEditora = livros.editora
	join autores on autores.idAutor = livros.autor
	where livros.emprestado=false and livros.desativado=false and livros.nome=livro and livros.autor=autor;	
	
ELSEIF (tombo is null) and (editora is null) then
	SELECT livros.idLivro, livros.tombo, livros.isbn, livros.nome, livros.edicao,editoras.nome "editora", autores.nome "autor", livros.ano, livros.paginas, livros.estado, livros.descricao, livros.emprestado, livros.desativado from livros
	join editoras on editoras.idEditora = livros.editora
	join autores on autores.idAutor = livros.autor
	where livros.emprestado=false and livros.desativado=false and livros.nome=livro and livros.autor=autor and livros.ano=ano;		
	
ELSEIF (tombo is null) and (ano is null) then
	SELECT livros.idLivro, livros.tombo, livros.isbn, livros.nome, livros.edicao,editoras.nome "editora", autores.nome "autor", livros.ano, livros.paginas, livros.estado, livros.descricao, livros.emprestado, livros.desativado from livros
	join editoras on editoras.idEditora = livros.editora
	join autores on autores.idAutor = livros.autor
	where livros.emprestado=false and livros.desativado=false and livros.nome=livro and livros.autor=autor and livros.editora=editora;		
	
ELSEIF (tombo is null) then
	SELECT livros.idLivro, livros.tombo, livros.isbn, livros.nome, livros.edicao,editoras.nome "editora", autores.nome "autor", livros.ano, livros.paginas, livros.estado, livros.descricao, livros.emprestado, livros.desativado from livros
	join editoras on editoras.idEditora = livros.editora
	join autores on autores.idAutor = livros.autor
	where livros.emprestado=false and livros.desativado=false and livros.nome=livro and livros.autor=autor and livros.editora=editora and livros.ano=ano;			
	
ELSEIF (livro is null) and (autor is null) and (editora is null) and (ano is null) then
	SELECT livros.idLivro, livros.tombo, livros.isbn, livros.nome, livros.edicao,editoras.nome "editora", autores.nome "autor", livros.ano, livros.paginas, livros.estado, livros.descricao, livros.emprestado, livros.desativado from livros
	join editoras on editoras.idEditora = livros.editora
	join autores on autores.idAutor = livros.autor
	where livros.emprestado=false and livros.desativado=false and livros.tombo=tombo;
	
ELSEIF (livro is null) and (autor is null) and (editora is null) then
	SELECT livros.idLivro, livros.tombo, livros.isbn, livros.nome, livros.edicao,editoras.nome "editora", autores.nome "autor", livros.ano, livros.paginas, livros.estado, livros.descricao, livros.emprestado, livros.desativado from livros
	join editoras on editoras.idEditora = livros.editora
	join autores on autores.idAutor = livros.autor
	where livros.emprestado=false and livros.desativado=false and livros.tombo=tombo and livros.ano=ano;	
	
ELSEIF (livro is null) and (autor is null) and (ano is null) then
	SELECT livros.idLivro, livros.tombo, livros.isbn, livros.nome, livros.edicao,editoras.nome "editora", autores.nome "autor", livros.ano, livros.paginas, livros.estado, livros.descricao, livros.emprestado, livros.desativado from livros
	join editoras on editoras.idEditora = livros.editora
	join autores on autores.idAutor = livros.autor
	where livros.emprestado=false and livros.desativado=false and livros.tombo=tombo and livros.editora=editora;	
	
ELSEIF (livro is null) and (autor is null) then
	SELECT livros.idLivro, livros.tombo, livros.isbn, livros.nome, livros.edicao,editoras.nome "editora", autores.nome "autor", livros.ano, livros.paginas, livros.estado, livros.descricao, livros.emprestado, livros.desativado from livros
	join editoras on editoras.idEditora = livros.editora
	join autores on autores.idAutor = livros.autor
	where livros.emprestado=false and livros.desativado=false and livros.tombo=tombo and livros.editora=editora and livros.ano=ano;		
	
ELSEIF (livro is null) and (editora is null) and (ano is null) then
	SELECT livros.idLivro, livros.tombo, livros.isbn, livros.nome, livros.edicao,editoras.nome "editora", autores.nome "autor", livros.ano, livros.paginas, livros.estado, livros.descricao, livros.emprestado, livros.desativado from livros
	join editoras on editoras.idEditora = livros.editora
	join autores on autores.idAutor = livros.autor
	where livros.emprestado=false and livros.desativado=false and livros.tombo=tombo and livros.autor=autor;	
	
ELSEIF (livro is null) and (editora is null) then
	SELECT livros.idLivro, livros.tombo, livros.isbn, livros.nome, livros.edicao,editoras.nome "editora", autores.nome "autor", livros.ano, livros.paginas, livros.estado, livros.descricao, livros.emprestado, livros.desativado from livros
	join editoras on editoras.idEditora = livros.editora
	join autores on autores.idAutor = livros.autor
	where livros.emprestado=false and livros.desativado=false and livros.tombo=tombo and livros.autor=autor and livros.ano=ano;		

ELSEIF (livro is null) and (ano is null) then
	SELECT livros.idLivro, livros.tombo, livros.isbn, livros.nome, livros.edicao,editoras.nome "editora", autores.nome "autor", livros.ano, livros.paginas, livros.estado, livros.descricao, livros.emprestado, livros.desativado from livros
	join editoras on editoras.idEditora = livros.editora
	join autores on autores.idAutor = livros.autor
	where livros.emprestado=false and livros.desativado=false and livros.tombo=tombo and livros.autor=autor and livros.editora=editora;

ELSEIF (livro is null) then
	SELECT livros.idLivro, livros.tombo, livros.isbn, livros.nome, livros.edicao,editoras.nome "editora", autores.nome "autor", livros.ano, livros.paginas, livros.estado, livros.descricao, livros.emprestado, livros.desativado from livros
	join editoras on editoras.idEditora = livros.editora
	join autores on autores.idAutor = livros.autor
	where livros.emprestado=false and livros.desativado=false and livros.tombo=tombo and livros.autor=autor and livros.editora=editora and livros.ano=ano;

ELSEIF (autor is null) and (editora is null) and (ano is null) then
	SELECT livros.idLivro, livros.tombo, livros.isbn, livros.nome, livros.edicao,editoras.nome "editora", autores.nome "autor", livros.ano, livros.paginas, livros.estado, livros.descricao, livros.emprestado, livros.desativado from livros
	join editoras on editoras.idEditora = livros.editora
	join autores on autores.idAutor = livros.autor
	where livros.emprestado=false and livros.desativado=false and livros.tombo=tombo and livros.nome=livro;

ELSEIF (autor is null) and (editora is null) then
	SELECT livros.idLivro, livros.tombo, livros.isbn, livros.nome, livros.edicao,editoras.nome "editora", autores.nome "autor", livros.ano, livros.paginas, livros.estado, livros.descricao, livros.emprestado, livros.desativado from livros
	join editoras on editoras.idEditora = livros.editora
	join autores on autores.idAutor = livros.autor
	where livros.emprestado=false and livros.desativado=false and livros.tombo=tombo and livros.nome=livro and livros.ano=ano;

ELSEIF (autor is null) and (ano is null) then
	SELECT livros.idLivro, livros.tombo, livros.isbn, livros.nome, livros.edicao,editoras.nome "editora", autores.nome "autor", livros.ano, livros.paginas, livros.estado, livros.descricao, livros.emprestado, livros.desativado from livros
	join editoras on editoras.idEditora = livros.editora
	join autores on autores.idAutor = livros.autor
	where livros.emprestado=false and livros.desativado=false and livros.tombo=tombo and livros.nome=livro and livros.editora=editora;

ELSEIF (autor is null) then
	SELECT livros.idLivro, livros.tombo, livros.isbn, livros.nome, livros.edicao,editoras.nome "editora", autores.nome "autor", livros.ano, livros.paginas, livros.estado, livros.descricao, livros.emprestado, livros.desativado from livros
	join editoras on editoras.idEditora = livros.editora
	join autores on autores.idAutor = livros.autor
	where livros.emprestado=false and livros.desativado=false and livros.tombo=tombo and livros.nome=livro and livros.editora=editora and livros.ano=ano;

ELSEIF (editora is null) and (ano is null) then
	SELECT livros.idLivro, livros.tombo, livros.isbn, livros.nome, livros.edicao,editoras.nome "editora", autores.nome "autor", livros.ano, livros.paginas, livros.estado, livros.descricao, livros.emprestado, livros.desativado from livros
	join editoras on editoras.idEditora = livros.editora
	join autores on autores.idAutor = livros.autor
	where livros.emprestado=false and livros.desativado=false and livros.tombo=tombo and livros.nome=livro and livros.autor=autor;

ELSEIF (editora is null) then
	SELECT livros.idLivro, livros.tombo, livros.isbn, livros.nome, livros.edicao,editoras.nome "editora", autores.nome "autor", livros.ano, livros.paginas, livros.estado, livros.descricao, livros.emprestado, livros.desativado from livros
	join editoras on editoras.idEditora = livros.editora
	join autores on autores.idAutor = livros.autor
	where livros.emprestado=false and livros.desativado=false and livros.tombo=tombo and livros.nome=livro and livros.autor=autor and livros.ano=ano;

ELSEIF (ano is null) then
	SELECT livros.idLivro, livros.tombo, livros.isbn, livros.nome, livros.edicao,editoras.nome "editora", autores.nome "autor", livros.ano, livros.paginas, livros.estado, livros.descricao, livros.emprestado, livros.desativado from livros
	join editoras on editoras.idEditora = livros.editora
	join autores on autores.idAutor = livros.autor
	where livros.emprestado=false and livros.desativado=false and livros.tombo=tombo and livros.nome=livro and livros.autor=autor and livros.editora=editora;
	
ELSE
	SELECT livros.idLivro, livros.tombo, livros.isbn, livros.nome, livros.edicao,editoras.nome "editora", autores.nome "autor", livros.ano, livros.paginas, livros.estado, livros.descricao, livros.emprestado, livros.desativado from livros
	join editoras on editoras.idEditora = livros.editora
	join autores on autores.idAutor = livros.autor
	where livros.emprestado=false and livros.desativado=false and livros.tombo=tombo and livros.nome=livro and livros.autor=autor and livros.editora=editora and livros.ano=ano;
END IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `listaPermGruposSegAtivos` (IN `idGrupoSeg` INT)  NO SQL
select permissoesgrupo.idRegra, gruposeg.nomeGrupo as grupo, permissoes.descricao as permissao, permissoesGrupo.desativado from permissoesgrupo
join gruposeg on gruposeg.idGrupo = permissoesgrupo.grupo
join permissoes on permissoes.idPermissao = permissoesgrupo.permissao
where permissoesgrupo.desativado = false and grupo=idGrupoSeg$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `listaPermGruposSegDesativados` (IN `idGrupoSeg` INT)  NO SQL
select permissoesgrupo.idRegra, gruposeg.nomeGrupo as grupo, permissoes.descricao as permissao, permissoesGrupo.desativado from permissoesgrupo
join gruposeg on gruposeg.idGrupo = permissoesgrupo.grupo
join permissoes on permissoes.idPermissao = permissoesgrupo.permissao
where permissoesgrupo.desativado = true and grupo=idGrupoSeg$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `listaUsuariosBloqAtivos` ()  NO SQL
SELECT usuarios.idUsuario, usuarios.login,usuarios.nome,usuarios.endereco,usuarios.telefone,gruposeg.nomeGrupo "grupo",usuarios.erroLogin,usuarios.bloqueado,usuarios.desativado FROM `usuarios` JOIN gruposeg on gruposeg.idGrupo = usuarios.grupo WHERE usuarios.desativado=false and usuarios.bloqueado=true$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `listaUsuariosBloqDesativados` ()  NO SQL
SELECT usuarios.idUsuario, usuarios.login,usuarios.nome,usuarios.endereco,usuarios.telefone,gruposeg.nomeGrupo "grupo",usuarios.erroLogin,usuarios.bloqueado,usuarios.desativado FROM `usuarios` JOIN gruposeg on gruposeg.idGrupo = usuarios.grupo WHERE usuarios.desativado=true and usuarios.bloqueado=true$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `listaUsuariosDesbloqAtivos` ()  NO SQL
SELECT usuarios.idUsuario, usuarios.login,usuarios.nome,usuarios.endereco,usuarios.telefone,gruposeg.nomeGrupo "grupo",usuarios.erroLogin,usuarios.bloqueado,usuarios.desativado FROM `usuarios` JOIN gruposeg on gruposeg.idGrupo = usuarios.grupo WHERE usuarios.desativado=false and usuarios.bloqueado=false$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `listaUsuariosDesbloqDesativados` ()  NO SQL
SELECT usuarios.idUsuario, usuarios.login,usuarios.nome,usuarios.endereco,usuarios.telefone,gruposeg.nomeGrupo "grupo",usuarios.erroLogin,usuarios.bloqueado,usuarios.desativado FROM `usuarios` JOIN gruposeg on gruposeg.idGrupo = usuarios.grupo WHERE usuarios.desativado=true and usuarios.bloqueado=false$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `permissoesUsuario` (IN `user` INT)  SELECT permissao from PermissoesGrupo
INNER JOIN Usuarios ON PermissoesGrupo.grupo = Usuarios.grupo
where idUsuario = user$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `regLog` (IN `user` INT, IN `ref` INT, IN `evento` INT)  NO SQL
INSERT INTO log (dataEvento,usuariologado,ref,evento) VALUES (now(),user,ref,evento)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `setarPermissoesSeq` (IN `grupox` INT, IN `valor` INT)  NO SQL
BEGIN
DECLARE PERM INT;
SET PERM = 2;

WHILE(PERM<valor) DO
	INSERT permissoesgrupo(grupo,permissao,desativado) VALUES(grupox,PERM,false);
	SET PERM = PERM + 1;
END WHILE;

END$$

--
-- Functions
--
CREATE DEFINER=`root`@`localhost` FUNCTION `atdstAutor` (`oper` INT, `user` INT, `idAutor` INT) RETURNS TINYINT(1) NO SQL
BEGIN

if oper=0 THEN
UPDATE autores SET desativado=false where autores.idAutor=idAutor;
CALL regLog(user,LAST_INSERT_ID(),19);
ELSE
UPDATE autores SET desativado=true where autores.idAutor=idAutor;
CALL regLog(user,LAST_INSERT_ID(),18);
end if;

RETURN (TRUE);
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `atdstEditora` (`oper` INT, `user` INT, `idEditora` INT) RETURNS TINYINT(1) NO SQL
BEGIN

if oper=0 THEN
UPDATE editoras SET desativado=false where editoras.idEditora=idEditora;
CALL regLog(user,LAST_INSERT_ID(),23);
ELSE
UPDATE editoras SET desativado=true where editoras.idEditora=idEditora;
CALL regLog(user,LAST_INSERT_ID(),22);
end if;

RETURN (TRUE);
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `atdstGrupoSeg` (`oper` INT, `user` INT, `idGrupoSeg` INT) RETURNS TINYINT(1) NO SQL
BEGIN

if oper=0 THEN
UPDATE gruposeg SET desativado=false where idGrupo=idGrupoSeg;
CALL regLog(user,LAST_INSERT_ID(),31);
ELSE
UPDATE gruposeg SET desativado=true where idGrupo=idGrupoSeg;
CALL regLog(user,LAST_INSERT_ID(),30);
end if;

RETURN (TRUE);
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `atdstLivros` (`oper` INT, `user` INT, `idLivro` INT) RETURNS TINYINT(1) NO SQL
BEGIN

if oper=0 THEN
UPDATE livros SET desativado=false where livros.idLivro=idLivro;
CALL regLog(user,LAST_INSERT_ID(),27);
ELSE
UPDATE livros SET desativado=true where livros.idLivro=idLivro;
CALL regLog(user,LAST_INSERT_ID(),26);
end if;

RETURN (TRUE);
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `atdstPermissaoGrupo` (`oper` INT, `user` INT, `idRegraGrupo` INT) RETURNS TINYINT(1) NO SQL
BEGIN

if oper=0 THEN
UPDATE permissoesgrupo SET desativado=false where idRegra=idRegraGrupo;
CALL regLog(user,LAST_INSERT_ID(),32);
ELSE
UPDATE permissoesgrupo SET desativado=true where idRegra=idRegraGrupo;
CALL regLog(user,LAST_INSERT_ID(),33);
end if;

RETURN (TRUE);
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `atdstUsuario` (`oper` INT, `user` INT, `idUsuario` INT) RETURNS TINYINT(1) NO SQL
BEGIN

if oper=0 THEN
UPDATE usuarios SET desativado=false where idUsuario=idUsuario;
CALL regLog(user,LAST_INSERT_ID(),12);
ELSE
UPDATE usuarios SET desativado=true where idUsuario=idUsuario;
CALL regLog(user,LAST_INSERT_ID(),11);
end if;

RETURN (TRUE);
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `bldsbUsuario` (`oper` INT, `user` INT, `idUsuario` INT) RETURNS TINYINT(1) NO SQL
BEGIN

if oper=0 THEN
UPDATE usuarios SET bloqueado=false where idUsuario=idUsuario;
CALL regLog(user,LAST_INSERT_ID(),13);
ELSE
UPDATE usuarios SET bloqueado=true where idUsuario=idUsuario;
CALL regLog(user,LAST_INSERT_ID(),6);
end if;

RETURN (TRUE);
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `editAutor` (`user` INT, `idAutor` INT, `nome` VARCHAR(50), `descricao` VARCHAR(1000)) RETURNS TINYINT(1) NO SQL
BEGIN

UPDATE autores SET nome=nome,descricao=descricao where autores.idAutor=idAutor;

CALL regLog(user,LAST_INSERT_ID(),17);

RETURN (TRUE);
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `editEditora` (`user` INT, `idEditora` INT, `nome` VARCHAR(50), `endereco` VARCHAR(50), `telefone` VARCHAR(50), `site` INT) RETURNS TINYINT(1) NO SQL
BEGIN

UPDATE editoras SET editoras.nome=nome,editoras.endereco=endereco,editoras.telefone=telefone,editoras.site=site where editoras.idEditora=idEditora;

CALL regLog(user,LAST_INSERT_ID(),21);

RETURN (TRUE);
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `editGrupoSeg` (`user` INT, `idGrupo` INT, `nomeGrupo` VARCHAR(15)) RETURNS TINYINT(1) NO SQL
BEGIN

UPDATE gruposeg SET nomeGrupo=nomeGrupo where idGrupo=idGrupo;

CALL regLog(user,LAST_INSERT_ID(),29);

RETURN (TRUE);
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `editLivros` (`user` INT, `idLivro` INT, `tombo` VARCHAR(10), `isbn` BIGINT, `nome` VARCHAR(100), `edicao` INT, `editora` INT, `autor` INT, `ano` INT, `paginas` INT, `estado` VARCHAR(20), `descricao` VARCHAR(2000), `emprestado` BOOLEAN) RETURNS TINYINT(1) NO SQL
BEGIN

UPDATE livros SET tombo=tombo,isbn=isbn,nome=nome,edicao=edicao,editora=editora,autor=autor,ano=ano,paginas=paginas,estado=estado,descricao=descricao,emprestado=emprestado where livros.idLivro=idLivro;

CALL regLog(user,LAST_INSERT_ID(),25);

RETURN (TRUE);
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `editUsuario` (`user` INT, `idUsuario` INT, `login` VARCHAR(20), `senha` VARCHAR(30), `nome` VARCHAR(50), `endereco` VARCHAR(50), `telefone` BIGINT, `grupo` INT) RETURNS TINYINT(1) NO SQL
BEGIN

UPDATE `usuarios` SET `login`=login,`senha`=senha,`nome`=nome,`endereco`=endereco,`telefone`=telefone,`grupo`=grupo WHERE idUsuario=idUsuario;

CALL regLog(user,LAST_INSERT_ID(),3);

RETURN (TRUE);
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `fcMudarSenha` (`user` INT, `senhaAtual` VARCHAR(30), `senhaNova` VARCHAR(30), `senhaNovaConf` VARCHAR(30)) RETURNS TINYINT(1) NO SQL
BEGIN
DECLARE resultado Boolean;
DECLARE senhaCorreta Boolean;
DECLARE senhaConfere Boolean;
DECLARE vsenha varchar(30);

select senha into vsenha from  usuarios where usuarios.idUsuario=user;

set resultado = false;

if vsenha=senhaAtual THEN
	set senhaCorreta = true;
ELSE
	set senhaCorreta = false;
end if;

if senhaNova=senhaNovaConf THEN
	set senhaConfere = true;
ELSE
	set senhaConfere = false;
end if;

if senhaCorreta and senhaConfere THEN
	UPDATE `usuarios` SET `senha`=senhaNova WHERE idUsuario=user;
	CALL regLog(user,LAST_INSERT_ID(),10);
	set resultado = true;
ELSE
	set resultado = false;
end if;

RETURN resultado;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `fcResetaSenha` (`userLog` INT, `user` INT) RETURNS TINYINT(1) NO SQL
BEGIN
	UPDATE `usuarios` SET `senha`="mudar123" WHERE idUsuario=user;
	CALL regLog(userLog,LAST_INSERT_ID(),34);
    return true;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `insertAutor` (`user` INT, `nome` VARCHAR(50), `descricao` VARCHAR(1000)) RETURNS TINYINT(1) NO SQL
BEGIN

INSERT INTO autores(nome,descricao,desativado) VALUES(nome,descricao,FALSE);

CALL regLog(user,LAST_INSERT_ID(),16);

RETURN (TRUE);
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `insertEditora` (`user` INT, `nome` VARCHAR(50), `endereco` VARCHAR(50), `telefone` BIGINT, `site` VARCHAR(50)) RETURNS TINYINT(1) NO SQL
BEGIN

INSERT INTO editoras(nome,endereco,telefone,site,desativado) VALUES(nome,endereco,telefone,site,FALSE);

CALL regLog(user,LAST_INSERT_ID(),20);

RETURN (TRUE);
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `insertGrupoSeg` (`user` INT, `nomeGrupo` VARCHAR(15)) RETURNS TINYINT(1) NO SQL
BEGIN

INSERT INTO gruposeg(nomeGrupo,desativado) VALUES(nomeGrupo,FALSE);

CALL regLog(user,LAST_INSERT_ID(),28);

INSERT INTO `permissoesgrupo`(`grupo`, `permissao`) VALUES (LAST_INSERT_ID(),0);

CALL regLog(user,LAST_INSERT_ID(),32);

RETURN (TRUE);
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `insertLivros` (`user` INT, `tombo` VARCHAR(10), `isbn` BIGINT, `nome` VARCHAR(100), `edicao` INT, `editora` INT, `autor` INT, `ano` INT, `paginas` INT, `estado` VARCHAR(20), `descricao` VARCHAR(2000)) RETURNS TINYINT(1) NO SQL
BEGIN

INSERT INTO livros(tombo,isbn,nome,edicao,editora,autor,ano,paginas,estado,descricao,emprestado,desativado) VALUES(tombo,isbn,nome,edicao,editora,autor,ano,paginas,estado,descricao,FALSE,FALSE);

CALL regLog(user,LAST_INSERT_ID(),24);

RETURN (TRUE);
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `insertPermissaoGrupo` (`user` INT, `grupo` INT, `permissao` INT) RETURNS TINYINT(4) NO SQL
BEGIN
DECLARE
existe int;

select idRegra INTO existe FROM permissoesgrupo where permissoesgrupo.grupo=grupo and permissoesgrupo.permissao=permissao;

IF(existe>=0) THEN

INSERT INTO `permissoesgrupo`(`grupo`, `permissao`) VALUES (grupo,permissao);

CALL regLog(user,LAST_INSERT_ID(),32);

RETURN (TRUE);

ELSE

update `permissoesgrupo`set desativado=false where permissoesgrupo.grupo=grupo and permissoesgrupo.permissao=permissao;

CALL regLog(user,LAST_INSERT_ID(),32);

RETURN (TRUE);

END IF;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `insertTeste` (`num` INT) RETURNS TINYINT(1) NO SQL
BEGIN

INSERT INTO temp(num) VALUES(num);

RETURN (TRUE);
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `insertUsuario` (`user` INT, `login` VARCHAR(20), `senha` VARCHAR(30), `nome` VARCHAR(50), `endereco` VARCHAR(50), `telefone` BIGINT, `grupo` INT) RETURNS TINYINT(1) NO SQL
BEGIN

INSERT INTO `usuarios`(`login`, `senha`, `nome`, `endereco`, `telefone`, `grupo`, `erroLogin`, `bloqueado`, `desativado`) VALUES (login,senha,nome,endereco,telefone,grupo,0,false,false);

CALL regLog(user,LAST_INSERT_ID(),2);

RETURN (TRUE);
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `registraBaixa` (`empid` INT, `responsavel` INT) RETURNS TINYINT(1) NO SQL
BEGIN
DECLARE xlivro INT;

SELECT livro INTO xlivro FROM emprestimos where emprestimos.idEmprestimo=empid;

	UPDATE emprestimos SET emprestimos.baixa=true, emprestimos.dataDevolucao=CURDATE(), emprestimos.respBaixa=responsavel, desativado=false where emprestimos.idEmprestimo=empid;
    
    UPDATE livros SET livros.emprestado=false WHERE livros.idLivro=xlivro;
    
    CALL regLog(responsavel,LAST_INSERT_ID(),39);

RETURN TRUE;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `registraDevolucao` (`oper` INT, `usuario` INT, `empid` INT, `responsavel` INT) RETURNS TINYINT(1) NO SQL
BEGIN

IF oper = 0 THEN
	UPDATE emprestimos SET emprestimos.devolvido=true, emprestimos.dataDevolucao=CURDATE(), emprestimos.respDevolucao=responsavel, desativado=false,baixa=false where emprestimos.idEmprestimo=empid;
    
    CALL regLog(usuario,LAST_INSERT_ID(),37);
ELSE
	UPDATE emprestimos SET emprestimos.devolvido=true, emprestimos.dataDevolucao=CURDATE(), emprestimos.respDevolucao=responsavel, desativado=false,baixa=false where emprestimos.idEmprestimo= empid;
    
    CALL regLog(responsavel,LAST_INSERT_ID(),38);
END IF;
RETURN TRUE;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `registraEmprestimo` (`oper` INT, `usuario` INT, `livro` INT, `responsavel` INT, `idPC` VARCHAR(100)) RETURNS TINYINT(1) NO SQL
BEGIN
DECLARE diasEmp INT;

SELECT diasEmprestimo INTO diasEmp FROM configuracoes where configuracoes.pc=idPC;

IF oper = 0 THEN

	INSERT INTO `emprestimos`(`dataRetirada`, `dataEstDevolucao`, `usuario`, `livro`, `respEmprestimo`, `desativado`,devolvido) VALUES (CURDATE(),ADDDATE( CURDATE(), INTERVAL diasEmp DAY),usuario,livro,usuario,FALSE,FALSE);
    
    UPDATE livros SET emprestado=true where idLivro=livro;
        
	CALL regLog(usuario,LAST_INSERT_ID(),35);

ELSE
	
	INSERT INTO `emprestimos`(`dataRetirada`, `dataEstDevolucao`, `usuario`, `livro`, `respEmprestimo`, `desativado`,devolvido) VALUES (CURDATE(),ADDDATE( CURDATE(), INTERVAL diasEmp DAY),usuario,livro,responsavel,FALSE,false);
	
    UPDATE livros SET emprestado=true where idLivro=livro;
    
    CALL regLog(usuario,LAST_INSERT_ID(),36);


END IF;

RETURN TRUE;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `autores`
--

CREATE TABLE `autores` (
  `idAutor` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `descricao` varchar(1000) DEFAULT NULL,
  `desativado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `autores`
--

INSERT INTO `autores` (`idAutor`, `nome`, `descricao`, `desativado`) VALUES
(1, 'teste', 'teste de descricaoo', 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `codigoevento`
--

CREATE TABLE `codigoevento` (
  `idCodEvento` int(11) NOT NULL,
  `descricao` varchar(70) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `codigoevento`
--

INSERT INTO `codigoevento` (`idCodEvento`, `descricao`) VALUES
(0, 'Criado Um Novo Codigo de Evento'),
(1, 'Alterado Um Evento'),
(2, 'Criado Um Novo Usuario'),
(3, 'Alterado Um Usuario'),
(4, 'Tentativa de login com usuario inexistente'),
(5, 'Senha Incorreta'),
(6, 'Usuario bloqueado pelo administrador'),
(7, 'Usuario bloqueado excedido tentativas'),
(8, 'Usuario entrou no sistema'),
(9, 'Usuario saiu do sistema'),
(10, 'Usuario alterou sua senha'),
(11, 'Usuario desativado pelo administrador'),
(12, 'Usuario reativado pelo administrador'),
(13, 'Usuario desbloqueado pelo administrador'),
(14, 'Usuario desbloqueado pelo sistema'),
(15, 'Erro ao setar permissoes de usuario'),
(16, 'Criado Um Novo Autor'),
(17, 'Alterado Um Autor'),
(18, 'Autor desativado pelo administrador'),
(19, 'Autor reativado pelo administrador'),
(20, 'Criado Uma Nova Editora'),
(21, 'Alterado Uma Editora'),
(22, 'Editora desativada pelo administrador'),
(23, 'Editora reativada pelo administrador'),
(24, 'Criado Um Novo Livro'),
(25, 'Alterado Um Livro'),
(26, 'Livro desativado pelo administrador'),
(27, 'Livro reativado pelo administrador'),
(28, 'Criado Um novo grupo de Seguranca'),
(29, 'Alterado Um Grupo de Seguranca'),
(30, 'Grupo de Seguranca desativado pelo administrador'),
(31, 'Grupo de Seguranca reativado pelo administrador'),
(32, 'Adicionada uma nova permissao a Grupo de Seguranca'),
(33, 'Removida uma permissao de Grupo de Seguranca pelo administrador'),
(34, 'Senha do usuario resetada pelo administrador'),
(35, 'Usuario realizou emprestimo a si mesmo'),
(36, 'Usuario realizou emprestimo atraves de outro usuario'),
(37, 'Usuario realizou devolucao por si mesmo'),
(38, 'Usuario realizou devolucao atraves de outro usuario'),
(39, 'Usuario realizou baixa em uma devolucao');

-- --------------------------------------------------------

--
-- Estrutura da tabela `configuracoes`
--

CREATE TABLE `configuracoes` (
  `idConfig` int(11) NOT NULL,
  `pc` varchar(100) NOT NULL,
  `diasEmprestimo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `configuracoes`
--

INSERT INTO `configuracoes` (`idConfig`, `pc`, `diasEmprestimo`) VALUES
(0, '1', 10);

-- --------------------------------------------------------

--
-- Estrutura da tabela `editoras`
--

CREATE TABLE `editoras` (
  `idEditora` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `endereco` varchar(50) DEFAULT NULL,
  `telefone` decimal(10,0) DEFAULT NULL,
  `site` varchar(50) DEFAULT NULL,
  `desativado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `editoras`
--

INSERT INTO `editoras` (`idEditora`, `nome`, `endereco`, `telefone`, `site`, `desativado`) VALUES
(1, 'teste editora', 'teste endereco', NULL, NULL, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `emprestimos`
--

CREATE TABLE `emprestimos` (
  `idEmprestimo` int(11) NOT NULL,
  `dataRetirada` datetime NOT NULL,
  `dataEstDevolucao` datetime NOT NULL,
  `usuario` int(11) NOT NULL,
  `livro` int(11) NOT NULL,
  `respEmprestimo` int(11) NOT NULL,
  `devolvido` tinyint(1) DEFAULT NULL,
  `dataDevolucao` datetime DEFAULT NULL,
  `respDevolucao` int(11) DEFAULT NULL,
  `baixa` tinyint(1) DEFAULT NULL,
  `dataBaixa` datetime DEFAULT NULL,
  `respBaixa` int(11) DEFAULT NULL,
  `atrasado` int(11) NOT NULL,
  `desativado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `gruposeg`
--

CREATE TABLE `gruposeg` (
  `idGrupo` int(11) NOT NULL,
  `nomeGrupo` varchar(15) NOT NULL,
  `desativado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `gruposeg`
--

INSERT INTO `gruposeg` (`idGrupo`, `nomeGrupo`, `desativado`) VALUES
(0, 'Visitante', 0),
(1, 'Cliente', 1),
(2, 'Funcionario', 0),
(3, 'Administrador', 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `livros`
--

CREATE TABLE `livros` (
  `idLivro` int(11) NOT NULL,
  `tombo` varchar(10) DEFAULT NULL,
  `isbn` decimal(13,0) DEFAULT NULL,
  `nome` varchar(100) NOT NULL,
  `edicao` decimal(2,0) DEFAULT NULL,
  `editora` int(11) NOT NULL,
  `autor` int(11) NOT NULL,
  `ano` decimal(4,0) NOT NULL,
  `paginas` int(11) DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL,
  `descricao` varchar(2000) DEFAULT NULL,
  `emprestado` tinyint(1) DEFAULT NULL,
  `desativado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `livros`
--

INSERT INTO `livros` (`idLivro`, `tombo`, `isbn`, `nome`, `edicao`, `editora`, `autor`, `ano`, `paginas`, `estado`, `descricao`, `emprestado`, `desativado`) VALUES
(1, 'tst1', '54540405', 'teste livro', '1', 1, 1, '2017', 1000, 'sao paulo', 'teste de acentos çãõó', 0, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `log`
--

CREATE TABLE `log` (
  `idEvento` int(11) NOT NULL,
  `dataEvento` datetime NOT NULL,
  `usuariologado` int(11) NOT NULL,
  `ref` int(11) NOT NULL,
  `evento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `log`
--

INSERT INTO `log` (`idEvento`, `dataEvento`, `usuariologado`, `ref`, `evento`) VALUES
(1, '2017-05-17 16:40:28', 1, 0, 16),
(2, '2017-05-17 20:10:42', 1, 1, 16),
(3, '2017-05-17 20:13:05', 1, 0, 17),
(4, '2017-05-17 20:14:03', 1, 0, 18),
(5, '2017-05-17 20:14:33', 1, 0, 18),
(6, '2017-05-17 20:15:31', 1, 0, 19),
(7, '2017-05-20 19:12:58', 1, 0, 10),
(8, '2017-05-20 19:14:50', 1, 0, 10),
(9, '2017-05-20 19:15:20', 1, 0, 10),
(10, '2017-05-21 13:25:22', 0, 0, 30),
(11, '2017-05-21 13:25:30', 0, 0, 30),
(12, '2017-05-21 13:25:46', 0, 0, 31),
(13, '2017-05-21 13:33:16', 0, 0, 30),
(14, '2017-05-21 13:33:20', 0, 0, 31),
(15, '2017-05-23 19:42:16', 0, 0, 30),
(16, '2017-05-23 19:42:20', 0, 0, 31),
(17, '2017-05-23 19:42:37', 0, 0, 30);

-- --------------------------------------------------------

--
-- Estrutura da tabela `permissoes`
--

CREATE TABLE `permissoes` (
  `idPermissao` int(11) NOT NULL,
  `descricao` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `permissoes`
--

INSERT INTO `permissoes` (`idPermissao`, `descricao`) VALUES
(0, 'nenhuma'),
(1, 'Permissao de Acessar Usuarios'),
(2, 'Permissao de Criar Usuarios'),
(3, 'Permissao de Editar Usuarios'),
(4, 'Permissao de Ativar/Desativar Usuarios'),
(5, 'Permissao de Acessar Logs'),
(6, 'Permissao de Acessar Autores'),
(7, 'Permissao de Criar Autores'),
(8, 'Permissao de Editar Autores'),
(9, 'Permissao de Ativar/Desativar Autores'),
(10, 'Permissao de Acessar Editoras'),
(11, 'Permissao de Criar Editoras'),
(12, 'Permissao de Editar Editoras'),
(13, 'Permissao de Ativar/Desativar Editoras'),
(14, 'Permissao de Acessar Livros'),
(15, 'Permissao de Criar Livros'),
(16, 'Permissao de Editar Livros'),
(17, 'Permissao de Ativar/Desativar Livros'),
(18, 'Permissao de Acessar Grupos de Seguranca'),
(19, 'Permissao de Criar Grupos de Seguranca'),
(20, 'Permissao de Editar Grupos de Seguranca'),
(21, 'Permissao de Ativar/Desativar Grupos de Seguranca'),
(22, 'Permissao de Adicionar Permissao a Grupo de Segura'),
(23, 'Permissao de Remover Permissao de Grupo de Seguran'),
(24, 'Permissao de Resetar Senha'),
(25, 'Permissao de Trocar Propria Senha'),
(26, 'Permissao de Configurar Sistema'),
(27, 'Permissao de Acessar Permissoes'),
(28, 'Permissao de Acesso A Tela de Emprestimo'),
(29, 'Permissao de Realizar Emprestimo A Si Proprio'),
(30, 'Permissao de Realizar Emprestimo A Outro Usuario'),
(31, 'Permissao de Acesso a Tela de Devolução'),
(32, 'Permissao de Realizar Devolução A Si Proprio'),
(33, 'Permissao de Realizar Devolução A Outro Usuario'),
(34, 'Permissao de Realizar Baixa Em Devolução'),
(35, 'Permissao de Bloquear/Desbloquear Usuarios');

-- --------------------------------------------------------

--
-- Estrutura da tabela `permissoesgrupo`
--

CREATE TABLE `permissoesgrupo` (
  `idRegra` int(11) NOT NULL,
  `grupo` int(11) NOT NULL,
  `permissao` int(11) NOT NULL,
  `desativado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `permissoesgrupo`
--

INSERT INTO `permissoesgrupo` (`idRegra`, `grupo`, `permissao`, `desativado`) VALUES
(1, 1, 1, 0),
(2, 1, 2, 0),
(3, 1, 3, 0),
(4, 1, 4, 0),
(5, 1, 5, 0),
(6, 1, 6, 0),
(7, 1, 7, 0),
(8, 1, 8, 0),
(9, 1, 9, 0),
(10, 1, 10, 0),
(11, 1, 11, 0),
(12, 1, 12, 0),
(13, 1, 13, 0),
(14, 1, 14, 0),
(15, 1, 15, 0),
(16, 1, 16, 0),
(17, 1, 17, 0),
(18, 1, 18, 0),
(19, 1, 19, 0),
(20, 1, 20, 0),
(21, 1, 21, 0),
(22, 1, 22, 0),
(23, 1, 23, 0),
(24, 1, 24, 0),
(25, 1, 25, 0),
(26, 1, 26, 0),
(27, 1, 27, 0),
(28, 1, 28, 0),
(29, 1, 29, 0),
(30, 1, 30, 0),
(31, 1, 31, 0),
(32, 1, 32, 0),
(33, 1, 33, 0),
(34, 1, 34, 0),
(35, 1, 35, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `temp`
--

CREATE TABLE `temp` (
  `idTemp` int(11) NOT NULL,
  `num` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `temp`
--

INSERT INTO `temp` (`idTemp`, `num`) VALUES
(1, 66),
(2, 60),
(3, 543),
(4, 2),
(6, 1),
(7, 1),
(10, 9),
(15, 741),
(16, 10),
(17, 101),
(18, 1015),
(19, 5),
(20, 10),
(21, 12),
(22, 123),
(23, 1234);

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios`
--

CREATE TABLE `usuarios` (
  `idUsuario` int(11) NOT NULL,
  `login` varchar(20) NOT NULL,
  `senha` varchar(30) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `endereco` varchar(50) NOT NULL,
  `telefone` decimal(10,0) NOT NULL,
  `grupo` int(11) NOT NULL,
  `erroLogin` int(11) NOT NULL,
  `bloqueado` tinyint(1) NOT NULL,
  `desativado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuarios`
--

INSERT INTO `usuarios` (`idUsuario`, `login`, `senha`, `nome`, `endereco`, `telefone`, `grupo`, `erroLogin`, `bloqueado`, `desativado`) VALUES
(0, 'visitante', 'visitante', 'Visitante', 'visitante', '0', 0, 0, 0, 0),
(1, 'testelogin', 'testesenha', 'testenome', 'testeendereco', '12345', 1, 0, 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `autores`
--
ALTER TABLE `autores`
  ADD PRIMARY KEY (`idAutor`);

--
-- Indexes for table `codigoevento`
--
ALTER TABLE `codigoevento`
  ADD PRIMARY KEY (`idCodEvento`);

--
-- Indexes for table `editoras`
--
ALTER TABLE `editoras`
  ADD PRIMARY KEY (`idEditora`);

--
-- Indexes for table `emprestimos`
--
ALTER TABLE `emprestimos`
  ADD PRIMARY KEY (`idEmprestimo`);

--
-- Indexes for table `gruposeg`
--
ALTER TABLE `gruposeg`
  ADD PRIMARY KEY (`idGrupo`);

--
-- Indexes for table `livros`
--
ALTER TABLE `livros`
  ADD PRIMARY KEY (`idLivro`);

--
-- Indexes for table `log`
--
ALTER TABLE `log`
  ADD PRIMARY KEY (`idEvento`);

--
-- Indexes for table `permissoes`
--
ALTER TABLE `permissoes`
  ADD PRIMARY KEY (`idPermissao`);

--
-- Indexes for table `permissoesgrupo`
--
ALTER TABLE `permissoesgrupo`
  ADD PRIMARY KEY (`idRegra`);

--
-- Indexes for table `temp`
--
ALTER TABLE `temp`
  ADD PRIMARY KEY (`idTemp`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`idUsuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `autores`
--
ALTER TABLE `autores`
  MODIFY `idAutor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `codigoevento`
--
ALTER TABLE `codigoevento`
  MODIFY `idCodEvento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;
--
-- AUTO_INCREMENT for table `editoras`
--
ALTER TABLE `editoras`
  MODIFY `idEditora` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `emprestimos`
--
ALTER TABLE `emprestimos`
  MODIFY `idEmprestimo` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `gruposeg`
--
ALTER TABLE `gruposeg`
  MODIFY `idGrupo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `livros`
--
ALTER TABLE `livros`
  MODIFY `idLivro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `log`
--
ALTER TABLE `log`
  MODIFY `idEvento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT for table `permissoes`
--
ALTER TABLE `permissoes`
  MODIFY `idPermissao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;
--
-- AUTO_INCREMENT for table `permissoesgrupo`
--
ALTER TABLE `permissoesgrupo`
  MODIFY `idRegra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;
--
-- AUTO_INCREMENT for table `temp`
--
ALTER TABLE `temp`
  MODIFY `idTemp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
