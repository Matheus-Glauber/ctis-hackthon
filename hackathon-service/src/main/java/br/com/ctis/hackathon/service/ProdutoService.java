package br.com.ctis.hackathon.service;

import java.util.List;

import javax.ejb.Local;

import br.com.ctis.hackathon.dto.ProdutoDTO;
import br.com.ctis.hackathon.persistence.model.Produto;

@Local
public interface ProdutoService extends GenericService<Long, Produto>{

	List<Produto> listarTodos();
	
	void cadastrar(ProdutoDTO produtoDTO);
	
	Produto buscarProdutoPorId(Long id);
	
	void atualizar(ProdutoDTO produtoDTO);
}
 