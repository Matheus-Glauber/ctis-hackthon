package br.com.ctis.hackathon.persistence.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_produtos", schema = "hackaton")
public class Produto extends EntidadeBase<Long>{

	private static final long serialVersionUID = 2956490029184536849L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="preco")
	private BigDecimal preco;
	
	@Column(name="data_criacao")
	private Long dataCriacao;
	
	@ElementCollection
	private List<String> categorias;
	
	public Produto() {
		
	}
	
	
	public Produto(String nome, BigDecimal preco, Long dataCriacao) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.dataCriacao = dataCriacao;
	}

	
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public BigDecimal getPreco() {
		return preco;
	}


	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}


	public Long getDataCriacao() {
		return dataCriacao;
	}


	public void setDataCriacao(Long dataCriacao) {
		this.dataCriacao = dataCriacao;
	}


	public List<String> getCategorias() {
		return categorias;
	}


	public void setCategorias(List<String> categorias) {
		this.categorias = categorias;
	}


	public void setId(Long id) {
		this.id = id;
	}


	@Override
	public Long getId() {
		return id;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
