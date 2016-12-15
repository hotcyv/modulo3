package br.com.sematec.livraria.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto extends BaseEntity{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String imagem;
	private BigDecimal preco;

	public Produto(String nome, String imagem, BigDecimal preco) {
		super();
		this.nome = nome;
		this.imagem = imagem;
		this.preco = preco;
	}
	
	public Produto(){
		this("","",new BigDecimal("0.00"));
	}
	
	@Override
	public Long getId() {
		return id;
	}
    
	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
}
