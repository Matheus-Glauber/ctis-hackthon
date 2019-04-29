package br.com.ctis.hackathon.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import io.swagger.v3.oas.annotations.media.Schema;

public class EnderecoDTO {
	
	@NotNull(message = "Logradouro não pode ser nulo")
	@NotBlank(message = "Logradouro não pode ser vazio")
	@Length(max = 255, message = "Logradouro deve possuir até 255 caracteres")
	@Schema(description= "Logradouro", required = false)
	private String logradouro;
	
	@NotNull(message = "Numero não pode ser nulo")
	@NotBlank(message = "Numero não pode ser vazio")
	@Length(max = 10, message = "Numero deve possuir até 10 caracteres")
	@Schema(description= "Numero", required = false)
	private String numero;
	
	@NotNull(message = "Complemento não pode ser nulo")
	@NotBlank(message = "Complemento não pode ser vazio")
	@Length(max = 255, message = "Complemento deve possuir até 255 caracteres")
	@Schema(description= "Complemento", required = false)
	private String complemento;
	
	@NotNull(message = "Bairro não pode ser nulo")
	@NotBlank(message = "Bairro não pode ser vazio")
	@Length(max = 255, message = "Bairro deve possuir até 255 caracteres")
	@Schema(description= "Bairro do recurso", required = false)
	private String bairro;
	
	@NotNull(message = "Cidade não pode ser nulo")
	@NotBlank(message = "Cidade não pode ser vazio")
	@Length(max = 255, message = "Cidade deve possuir até 255 caracteres")
	@Schema(description= "Cidade", required = false)
	private String cidade;
	
	@NotNull(message = "Uf não pode ser nulo")
	@NotBlank(message = "Uf não pode ser vazio")
	@Length(max = 2, message = "Uf deve possuir até 2 caracteres")
	@Schema(description= "Uf", required = false)
	private String uf;

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	
	
}
