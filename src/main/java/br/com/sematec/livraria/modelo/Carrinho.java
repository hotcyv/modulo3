package br.com.sematec.livraria.modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Carrinho extends BaseEntity {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToOne
	private Usuario usuario;
	@OneToMany(cascade = {CascadeType.ALL})
	private List<Item> itens;
	private BigDecimal total;

	public Carrinho() {
		this(new Usuario(),new ArrayList<Item>(), new BigDecimal(0.0));
	}

	public Carrinho(Usuario usuario,List<Item> itens, BigDecimal total) {
		this.usuario = usuario;
		this.itens = itens;
		this.total = total;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<Item> getItens() {
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
