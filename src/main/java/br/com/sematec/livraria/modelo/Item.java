package br.com.sematec.livraria.modelo;

import java.math.BigDecimal;

import br.com.sematec.livraria.dao.ProdutoDAO;

public class Item extends BaseEntity{

	private static final long serialVersionUID = 1L;
	private Long id;
	private Long idProduto;
	private Integer quantidade;
	private BigDecimal total;
	
	public Item(Produto produto, Integer quantidade){
		this.idProduto = produto.getId();
		this.quantidade = quantidade;
		this.total= produto.getPreco().multiply(BigDecimal.valueOf(quantidade));
	}
	
	public Long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public Long getId(){
		return id;
	}
	public Produto getProduto(){
		return ProdutoDAO.getInstance().buscaPorId(this.idProduto);
}
}
