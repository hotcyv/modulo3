package br.com.sematec.livraria.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.sematec.livraria.dao.CarrinhoDAO;
import br.com.sematec.livraria.dao.UsuarioDAO;
import br.com.sematec.livraria.modelo.Carrinho;
import br.com.sematec.livraria.modelo.Usuario;

@ManagedBean
@SessionScoped
public class LoginBean {
	private Usuario usuario = new Usuario();
	private Carrinho carrinho;
	private UsuarioDAO usuarioDao;

	public String deslogar() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("usuarioLogado");
		context.getExternalContext().getSessionMap().remove("carrinho");
		return "login?faces-redirect=true";
	}

	public String efetuaLogin() {
		System.out.println("Fazendo login do usuário " + this.usuario.getEmail());
		FacesContext context = FacesContext.getCurrentInstance();
		Usuario usuarioDao = UsuarioDAO.getInstance().getUsuario(this.usuario);
		if (usuarioDao != null) {
			context.getExternalContext().getSessionMap().put("usuarioLogado", this.usuario);
			carrinho = CarrinhoDAO.getInstance().adicionaCarrinho(usuarioDao.getId().toString());
			context.getExternalContext().getSessionMap().put("carrinho", carrinho);
			System.out.println(carrinho.getId());
			return "produto?faces-redirect=true";
		}
		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage("Usuário não encontrado!"));
		return "login?faces-redirect=true";
	}

	public Usuario getUsuario() {
		return usuario;
	}
}
