package br.com.sematec.livraria.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sematec.livraria.dao.UsuarioDAO;
import br.com.sematec.livraria.modelo.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioBean {

	private Usuario usuario = new Usuario();
	private Long usuarioId;

	public void carregarUsuarioPelaId() {
		this.setUsuario(UsuarioDAO.getInstance().buscaPorId(usuarioId));
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public List<Usuario> getUsuarios() {
		return UsuarioDAO.getInstance().listaTodos();
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void gravar() {
		System.out.println("Gravando usuario " + this.getUsuario().getEmail() +" - "+ this.getUsuario().getSenha());
		if (this.getUsuario().getId() == null) {
			UsuarioDAO.getInstance().adiciona(this.getUsuario());
		} else {
			UsuarioDAO.getInstance().atualiza(this.getUsuario());
		}
		this.setUsuario(new Usuario());
	}
	public String gravarNovo() {
		System.out.println("Gravando usuario " + this.getUsuario().getEmail() +" - "+ this.getUsuario().getSenha());
		if (this.getUsuario().getId() == null) {
			UsuarioDAO.getInstance().adiciona(this.getUsuario());
		} else {
			UsuarioDAO.getInstance().atualiza(this.getUsuario());
		}
		this.setUsuario(new Usuario());
		return "login?faces-redirect=true";
	}

	public void remover(Usuario usuario) {
		System.out.println("Removendo usuario");
		UsuarioDAO.getInstance().remove(usuario);
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
}