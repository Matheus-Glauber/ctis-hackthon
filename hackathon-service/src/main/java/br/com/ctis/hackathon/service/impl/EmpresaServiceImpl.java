package br.com.ctis.hackathon.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import br.com.ctis.hackathon.converter.Converter;
import br.com.ctis.hackathon.dto.EmpresaDTO;
import br.com.ctis.hackathon.dto.EnderecoDTO;
import br.com.ctis.hackathon.dto.TelefoneDTO;
import br.com.ctis.hackathon.enumeration.MensagemEnum;
import br.com.ctis.hackathon.exception.DAOException;
import br.com.ctis.hackathon.exception.NegocioException;
import br.com.ctis.hackathon.exception.RegistroNaoEncontradoException;
import br.com.ctis.hackathon.persistence.dao.EmpresaDAO;
import br.com.ctis.hackathon.persistence.model.Empresa;
import br.com.ctis.hackathon.persistence.model.Endereco;
import br.com.ctis.hackathon.persistence.model.Telefone;
import br.com.ctis.hackathon.service.EmpresaService;
import br.com.ctis.hackathon.util.MensagemUtil;

@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class EmpresaServiceImpl extends GenericServiceImpl<Long, Empresa> implements EmpresaService{
	
	private static final long serialVersionUID = -6826007837387020698L;
	
	@EJB
	private EmpresaDAO empresaDAO;
	
	@Override
	public List<Empresa>listarTodos(){
		try {
			return empresaDAO.listarTodos();
		}catch(DAOException e) {
			throw new NegocioException(MensagemUtil.getMessage(MensagemEnum.MSG001));
		}
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void cadastrar(EmpresaDTO empresaDTO) {
		empresaDAO.gravar(Converter.getInstance().converter(empresaDTO, Empresa.class));
	}
	
	@Override
	public Empresa buscarEmpresaPorId(Long id) {
		try {
			return empresaDAO.buscarEmpresaPorId(id);
		} catch (RegistroNaoEncontradoException e) {
			throw new NegocioException("Empresa com Identificador " + id + " não encontrado");
		} catch (DAOException e) {
			throw new NegocioException(MensagemUtil.getMessage(MensagemEnum.MSG001));
		}

	}
	
	@Override
	public void atualizar(Long id, EmpresaDTO empresaDTO) {
		try {
			Empresa empresa = empresaDAO.buscarEmpresaPorId(id);
			empresaDAO.gravar(mapper(empresa,empresaDTO));
		}catch (RegistroNaoEncontradoException e) {
			throw new NegocioException("Empresa com Identificador " + id + " não encontrado");
		}catch (DAOException e) {
			throw new NegocioException(MensagemUtil.getMessage(MensagemEnum.MSG001));
		}
		
	}
	
	/**
	 * Método utilizado para converter de EmpresaDTO para Empresa
	 * @param empresa
	 * @param empresaDTO
	 * @return
	 */
	private Empresa mapper(Empresa empresa, EmpresaDTO empresaDTO) {
		
		empresa.setCnpj(empresaDTO.getCnpj());
		empresa.setEndereco(mapper(empresa.getEndereco(),empresaDTO.getEndereco()));
		empresa.setNomeFantasia(empresaDTO.getNomeFantasia());
		empresa.setStatus(empresaDTO.getStatus());
		empresa.setTelefones(mapper(empresa.getTelefones(),empresaDTO.getTelefones()));
		
		return empresa;
		
		
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
