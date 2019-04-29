package br.com.ctis.hackathon.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import br.com.ctis.hackathon.converter.Converter;
import br.com.ctis.hackathon.dto.ProdutoDTO;
import br.com.ctis.hackathon.enumeration.MensagemEnum;
import br.com.ctis.hackathon.exception.DAOException;
import br.com.ctis.hackathon.exception.NegocioException;
import br.com.ctis.hackathon.exception.RegistroNaoEncontradoException;
import br.com.ctis.hackathon.persistence.dao.ProdutoDAO;
import br.com.ctis.hackathon.persistence.model.Produto;
import br.com.ctis.hackathon.service.ProdutoService;
import br.com.ctis.hackathon.util.MensagemUtil;

@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class ProdutoServiceImpl extends GenericServiceImpl<Long, Produto> implements ProdutoService{
	
	private static final long serialVersionUID = -6826007837387020698L;
	
	@EJB
	private ProdutoDAO produtoDAO;
	
	@Override
	public List<Produto>listarTodos(){
		try {
			return produtoDAO.listarTodos();
		}catch(DAOException e) {
			throw new NegocioException(MensagemUtil.getMessage(MensagemEnum.MSG001));
		}
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void cadastrar(ProdutoDTO produtoDTO) {
		produtoDAO.gravar(Converter.getInstance().converter(produtoDTO, Produto.class));
	}
	
	@Override
	public Produto buscarProdutoPorId(Long id) {
		try {
			return produtoDAO.buscarProdutoPorId(id);
		} catch (RegistroNaoEncontradoException e) {
			throw new NegocioException("Produto com Identificador " + id + " não encontrado");
		} catch (DAOException e) {
			throw new NegocioException(MensagemUtil.getMessage(MensagemEnum.MSG001));
		}

	}
	
	@Override
	public void atualizar(ProdutoDTO produtoDTO) {
		produtoDAO.gravar(mapper(produtoDTO));
	}
	
	private Produto mapper(ProdutoDTO produtoDTO) {
		Produto produto = buscarProdutoPorId(produtoDTO.getId());
		produto.setNome(produtoDTO.getNome());
		produto.setCategorias(produtoDTO.getCategorias());
		produto.setDataCriacao(produtoDTO.getDataCriacao());
		produto.setPreco(produtoDTO.getPreco());
		return produto;
	}

}
