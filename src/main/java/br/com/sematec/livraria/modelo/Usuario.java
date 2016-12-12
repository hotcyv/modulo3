package br.com.sematec.livraria.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String email;
	private String senha;
	private boolean newsletter;

	public Usuario() {
		this("", "",false);
	}

	public Usuario(String email, String senha, boolean newsletter) {
		super();
		this.email = email;
		this.senha = senha;
		this.newsletter = newsletter;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public Long getId() {
		return id;
	}

	public String getSenha() {
		return senha;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isNewsletter() {
		return newsletter;
	}

	public void setNewsletter(boolean newsletter) {
		this.newsletter = newsletter;
	}
}
