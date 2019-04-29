package br.com.ctis.hackathon.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import io.swagger.v3.oas.annotations.media.Schema;

public class TelefoneDTO {
	
	@NotNull(message = "telefone não pode ser nulo")
	@NotBlank(message = "telefone não pode ser vazio")
	@Length(max = 11 , message = "telefone deve possuir até 11 caracteres")
	@Schema(description= "telefone", required = false)
	private String telefone;


	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


} 
