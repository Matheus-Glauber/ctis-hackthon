package br.com.ctis.hackathon.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import br.com.ctis.hackathon.exception.DAOException;
import br.com.ctis.hackathon.exception.RegistroNaoEncontradoException;
import br.com.ctis.hackathon.persistence.model.Produto;

@Local
public interface ProdutoDAO extends GenericDAO<Long, Produto> {
	
	/**
	 * Lista todos os produtos
	 * @return Lista com todos produtos cadastrados
	 * @throws DAOException
	 */
	List<Produto> listarTodos() throws DAOException;
	
	/**
	 * Busca um produto por id
	 * @param id
	 * @return Produto correspondente ao id passado como parametro
	 * @throws RegistroNaoEncontradoException
	 * @throws DAOException
	 */
	Produto buscarProdutoPorId(Long id) throws RegistroNaoEncontradoException, DAOException;
	

}
