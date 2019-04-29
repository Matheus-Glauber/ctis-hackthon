package br.com.ctis.hackathon.service;

import java.util.List;

import javax.ejb.Local;

import br.com.ctis.hackathon.dto.PessoaDTO;
import br.com.ctis.hackathon.persistence.model.Pessoa;

@Local
public interface PessoaService extends GenericService<Long, Pessoa>{

	List<Pessoa> listarTodos();
	
	void cadastrar(PessoaDTO pessoaDTO);
	
	Pessoa buscarPessoaPorId(Long id);
	
	void atualizar(Long id, PessoaDTO pessoaDTO);
}
 