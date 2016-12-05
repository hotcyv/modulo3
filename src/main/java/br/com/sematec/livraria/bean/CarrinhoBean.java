package br.com.sematec.livraria.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.sematec.livraria.dao.CarrinhoDAO;
import br.com.sematec.livraria.dao.ProdutoDAO;
import br.com.sematec.livraria.modelo.Carrinho;
import br.com.sematec.livraria.modelo.Item;
import br.com.sematec.livraria.modelo.Produto;

@ManagedBean
@ViewScoped
public class CarrinhoBean {

	private Carrinho carrinho;
	
	public CarrinhoBean() {
		FacesContext context = FacesContext.getCurrentInstance();
		carrinho = (Carrinho) context.getExternalContext().getSessionMap().get("carrinho");
	}
	public void removerItemCarrinho(Item item){
		carrinho.removeProduto(item);
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}
}