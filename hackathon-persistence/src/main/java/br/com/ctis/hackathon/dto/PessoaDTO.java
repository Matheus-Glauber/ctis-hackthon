package br.com.ctis.hackathon.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import io.swagger.v3.oas.annotations.media.Schema;

public class PessoaDTO extends BaseDTO {

	private static final long serialVersionUID = 4339996097780965908L;
	
	@Valid
	private EnderecoDTO endereco;
	
	@NotNull(message = "Nome não pode ser nulo")
	@NotBlank(message = "Nome não pode ser vazio")
	@Length(max = 255, message = "Nome deve possuir até 255 caracteres")
	@Schema(description= "nome", required = false)
	private String nome;
	
	@NotNull(message = "Sobrenome não pode ser nulo")
	@NotBlank(message = "Sobrenome não pode ser vazio")
	@Length(max = 255, message = "Sobrenome deve possuir até 255 caracteres")
	@Schema(description= "Sobrenome", required = false)
	private String sobrenome;
	
	@Email(message = "Email invalido")
	private String email;
	
	@CPF(message = "cpf invalido")
	private String cpf;
	
	@Valid
	private List<TelefoneDTO> telefones;
	
	@NotNull(message = "Status não pode ser nulo")
	@NotBlank(message = "Status não pode ser vazio")
	@Schema(description= "Status do recurso", required = false)
	private String status;

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}
	
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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
