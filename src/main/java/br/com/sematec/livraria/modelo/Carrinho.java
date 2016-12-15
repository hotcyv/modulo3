package br.com.sematec.livraria.modelo;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Carrinho extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private Long id;
	private ArrayList<Item> itens;
	private BigDecimal total;

	public Carrinho() {
		this(new ArrayList<Item>(), new BigDecimal(0.0));
	}

	public Carrinho(ArrayList<Item> itens, BigDecimal total) {
		this.itens = itens;
		this.total = total;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public ArrayList<Item> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Item> itens) {
		this.itens = itens;
	}

	public void adicionaProduto(Produto produto) {
		int index = 0;
		boolean existe = false;
		for (Item item : itens) {
			if (item.getProduto().getId() == produto.getId()) {
				Item itemNovo = new Item(produto, item.getQuantidade() + 1);
				itens.add(itemNovo);
				itens.remove(index);
				total = total.subtract(item.getTotal());
				total = total.add(itemNovo.getTotal());
				existe = true;
				break;
			}
			index++;
		}
		if (!existe) {
			Item item = new Item(produto, 1);
			itens.add(item);
			total = total.add(item.getTotal());
		}

	}

	public void removeProduto(Item item) {
		itens.remove(item);
		total = total.subtract(item.getTotal());
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;

	}

}
