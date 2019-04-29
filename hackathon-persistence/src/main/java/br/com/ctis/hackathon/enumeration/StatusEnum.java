package br.com.ctis.hackathon.enumeration;


public enum StatusEnum {
	
	ATIVO("ativo"),
	INATIVO("inativo");
	
	private String estado;

	private StatusEnum(String estado) {
		this.estado = estado;
	
	}
	
	public String getEstado() {
		return this.estado;
	}

	

}
	

