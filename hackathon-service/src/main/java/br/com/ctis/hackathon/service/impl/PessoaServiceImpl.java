package br.com.ctis.hackathon.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import br.com.ctis.hackathon.converter.Converter;
import br.com.ctis.hackathon.dto.EnderecoDTO;
import br.com.ctis.hackathon.dto.PessoaDTO;
import br.com.ctis.hackathon.dto.TelefoneDTO;
import br.com.ctis.hackathon.enumeration.MensagemEnum;
import br.com.ctis.hackathon.exception.DAOException;
import br.com.ctis.hackathon.exception.NegocioException;
import br.com.ctis.hackathon.exception.RegistroNaoEncontradoException;
import br.com.ctis.hackathon.persistence.dao.PessoaDAO;
import br.com.ctis.hackathon.persistence.model.Endereco;
import br.com.ctis.hackathon.persistence.model.Pessoa;
import br.com.ctis.hackathon.persistence.model.Telefone;
import br.com.ctis.hackathon.service.PessoaService;
import br.com.ctis.hackathon.util.MensagemUtil;

@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class PessoaServiceImpl extends GenericServiceImpl<Long, Pessoa> implements PessoaService{
	
	private static final long serialVersionUID = -6826007837387020698L;
	
	@EJB
	private PessoaDAO pessoaDAO;
	
	@Override
	public List<Pessoa>listarTodos(){
		try {
			return pessoaDAO.listarTodos();
		}catch(DAOException e) {
			throw new NegocioException(MensagemUtil.getMessage(MensagemEnum.MSG001));
		}
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void cadastrar(PessoaDTO pessoaDTO) {
		pessoaDAO.gravar(Converter.getInstance().converter(pessoaDTO, Pessoa.class));
	}
	
	@Override
	public Pessoa buscarPessoaPorId(Long id) {
		try {
			return pessoaDAO.buscarPessoaPorId(id);
		} catch (RegistroNaoEncontradoException e) {
			throw new NegocioException("Pessoa com Identificador " + id + " não encontrado");
		} catch (DAOException e) {
			throw new NegocioException(MensagemUtil.getMessage(MensagemEnum.MSG001));
		}

	}

	@Override
	public void atualizar(Long id, PessoaDTO pessoaDTO) {
		try {
			Pessoa pessoa = pessoaDAO.buscarPessoaPorId(id);
			pessoaDAO.gravar(mapper(pessoa,pessoaDTO));
		}catch (RegistroNaoEncontradoException e) {
			throw new NegocioException("Pessoa com Identificador " + id + " não encontrado");
		}catch (DAOException e) {
			throw new NegocioException(MensagemUtil.getMessage(MensagemEnum.MSG001));
		}
		
	}
	
	/**
	 * Método utilizado para converter de PessoaDTO para Pessoa
	 * @param pessoa
	 * @param pessoaDTO
	 * @return
	 */
	private Pessoa mapper(Pessoa pessoa, PessoaDTO pessoaDTO) {
		
		pessoa.setEndereco(mapper(pessoa.getEndereco(),pessoaDTO.getEndereco()));
		pessoa.setTelefones(mapper(pessoa.getTelefones(),pessoaDTO.getTelefones()));
		pessoa.setCpf(pessoaDTO.getCpf());
		pessoa.setNome(pessoaDTO.getNome());
		pessoa.setSobrenome(pessoaDTO.getSobrenome());
		pessoa.setEmail(pessoaDTO.getEmail());
		pessoa.setStatus(pessoaDTO.getStatus());
		
		return pessoa;
		
	}
	
	/**
	 * Método utilizado para converter de EnderecoDTO para Endereco
	 * @param endereco
	 * @param enderecoDTO
	 * @return
	 */
	private Endereco mapper(Endereco endereco, EnderecoDTO enderecoDTO) {
		
		endereco.setBairro(enderecoDTO.getBairro());
		endereco.setCidade(enderecoDTO.getCidade());
		endereco.setComplemento(enderecoDTO.getComplemento());
		endereco.setLogradouro(enderecoDTO.getLogradouro());
		endereco.setNumero(enderecoDTO.getNumero());
		endereco.setUf(enderecoDTO.getUf());
	
		return endereco;
	}
	
	
	/**
	 * Método utilizado para converter de List<TelefoneDTO> para List<Telefone>
	 * @param telefones
	 * @param telefonesDTO
	 * @return
	 */
	private List<Telefone> mapper(List<Telefone> telefones, List<TelefoneDTO> telefonesDTO)
	{
		for (int i = 0; i < telefonesDTO.size(); i++)
		{
			telefones.set(i, mapper(telefones.get(i),telefonesDTO.get(i)));
		}

		return telefones;
	}
	
	/**
	 * Metodo utilizado para converter de TelefoneDTO para Telefone
	 * @param telefone
	 * @param telefoneDTO
	 * @return
	 */
	private Telefone mapper(Telefone telefone,TelefoneDTO telefoneDTO)
	{
		telefone.setTelefone(telefoneDTO.getTelefone());
		
		return telefone;
	}
}
