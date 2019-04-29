package br.com.ctis.hackathon.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

import io.swagger.v3.oas.annotations.media.Schema;

public class EmpresaDTO {
	
	@Valid
	private EnderecoDTO endereco;
	
	@NotNull(message = "Razão Social não pode ser nulo")
	@NotBlank(message = "Razão Social não pode ser vazio")
	@Length(max = 255, message = "Razão Social deve possuir até 255 caracteres")
	@Schema(description= "nome", required = false)
	private String razaoSocial;
	
	@NotNull(message = "Nome Fantasia não pode ser nulo")
	@NotBlank(message = "Nome Fantasia não pode ser vazio")
	@Length(max = 255, message = "Nome Fantasia deve possuir até 255 caracteres")
	@Schema(description= "Nome Fantasia", required = false)
	private String nomeFantasia;
	
	@CNPJ
	private String cnpj;
	
	@Valid
	private List<TelefoneDTO> telefones;
	
	@NotNull(message = "Status não pode ser nulo")
	@NotBlank(message = "Status não pode ser vazio")
	@Schema(description= "status", required = false)
	private String status;

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<TelefoneDTO> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<TelefoneDTO> telefones) {
		this.telefones = telefones;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
