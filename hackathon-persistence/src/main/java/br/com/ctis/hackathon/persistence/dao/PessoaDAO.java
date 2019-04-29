package br.com.ctis.hackathon.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import br.com.ctis.hackathon.exception.DAOException;
import br.com.ctis.hackathon.exception.RegistroNaoEncontradoException;
import br.com.ctis.hackathon.persistence.model.Pessoa;

@Local
public interface PessoaDAO extends GenericDAO<Long, Pessoa> {
	/**
	 * Lista todas as pessoas
	 * @return lista com todas pessoas cadastradas
	 * @throws DAOException
	 */
	List<Pessoa> listarTodos() throws DAOException;
	
	/**
	 * Busca uma pessoa por id
	 * @param id
	 * @return Pessoa correspondente ao id passado como parametro
	 * @throws RegistroNaoEncontradoException
	 * @throws DAOException
	 */
	Pessoa buscarPessoaPorId(Long id) throws RegistroNaoEncontradoException, DAOException;
	

}
