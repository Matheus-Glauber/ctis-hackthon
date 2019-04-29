package br.com.ctis.hackathon.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import br.com.ctis.hackathon.exception.DAOException;
import br.com.ctis.hackathon.exception.RegistroNaoEncontradoException;
import br.com.ctis.hackathon.persistence.model.Empresa;

@Local
public interface EmpresaDAO extends GenericDAO<Long, Empresa> {
	
	/**
	 * Lista todas as Empresas
	 * @return Lista com todas Empresas
	 * @throws DAOException
	 */
	List<Empresa>listarTodos() throws DAOException;
	
	/**
	 * Busca Empresa por id
	 * @param id
	 * @return Empresa correspondente ao id passado como parametro
	 * @throws RegistroNaoEncontradoException
	 * @throws DAOException
	 */
	Empresa buscarEmpresaPorId(Long id)throws RegistroNaoEncontradoException, DAOException;
}
