package br.com.sematec.livraria.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.com.sematec.livraria.dao.ProdutoDAO;
import br.com.sematec.livraria.modelo.Carrinho;
import br.com.sematec.livraria.modelo.Produto;

@ManagedBean
@ViewScoped
public class ProdutoBean {

	private Produto produto = new Produto();
	private Long produtoId;
	private List<Produto> produtos;
	private Carrinho carrinho;
	
	public ProdutoBean() {
		FacesContext context = FacesContext.getCurrentInstance();
		carrinho = (Carrinho) context.getExternalContext().getSessionMap().get("carrinho");
	}

	public void carregarProdutoPelaId() {
		this.setProduto(ProdutoDAO.getInstance().buscaPorId(produtoId));
	}

	public Produto getProduto() {
		return produto;
	}

	public List<Produto> getProdutos() {
		if (this.produtos == null) {
			this.produtos = ProdutoDAO.getInstance().listaTodos();
		}
		return produtos;
	}

	public Long getProdutoId() {
		return produtoId;
	}

	public void adicionarItemCarrinho(Produto produto) {
		carrinho.adicionaProduto(ProdutoDAO.getInstance().buscaPorId(produto.getId()));

	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}
}