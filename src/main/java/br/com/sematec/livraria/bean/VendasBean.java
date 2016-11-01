package br.com.sematec.livraria.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;

import br.com.sematec.livraria.dao.LivroDAO;
import br.com.sematec.livraria.modelo.Livro;
import br.com.sematec.livraria.modelo.Venda;

@ManagedBean
@ViewScoped
public class VendasBean {
	public List<Venda> getVendas(long seed) {
		List<Livro> livros = LivroDAO.getInstance().listaTodos();
		List<Venda> vendas = new ArrayList<Venda>();
		Random random = new Random(seed);
		for (Livro livro : livros) {
			Integer quantidade = random.nextInt(500);
			vendas.add(new Venda(livro, quantidade));
		}
		return vendas;
	}

	public BarChartModel getVendasModel() {
		BarChartModel model = new BarChartModel();
		Random randomAno = new Random();
		Random randomValor = new Random();
		ChartSeries boys = new ChartSeries();
		boys.setLabel("Boys");
		boys.set(2000 + randomAno.nextInt(16), randomValor.nextInt(150));
		boys.set(2000 + randomAno.nextInt(16), randomValor.nextInt(150));
		boys.set(2000 + randomAno.nextInt(16), randomValor.nextInt(150));
		boys.set(2000 + randomAno.nextInt(16), randomValor.nextInt(150));
		boys.set(2000 + randomAno.nextInt(16), randomValor.nextInt(150));
		ChartSeries girls = new ChartSeries();
		girls.setLabel("Girls");
		girls.set(2000 + randomAno.nextInt(16), randomValor.nextInt(150));
		girls.set(2000 + randomAno.nextInt(16), randomValor.nextInt(150));
		girls.set(2000 + randomAno.nextInt(16), randomValor.nextInt(150));
		girls.set(2000 + randomAno.nextInt(16), randomValor.nextInt(150));
		girls.set(2000 + randomAno.nextInt(16), randomValor.nextInt(150));
		model.addSeries(boys);
		model.addSeries(girls);
		return model;
	}

	public BarChartModel getVendasModel2() {
		HorizontalBarChartModel model = new HorizontalBarChartModel();
		ChartSeries vendaSerie = new ChartSeries();
		vendaSerie.setLabel("Vendas 2018");
		List<Venda> vendas = getVendas(1234);
		for (Venda venda : vendas) {
			vendaSerie.set(venda.getLivro().getTitulo(), venda.getQuantidade());
		}
		model.addSeries(vendaSerie);
		ChartSeries vendaSerie2015 = new ChartSeries();
		vendaSerie2015.setLabel("Vendas 2017");
		vendas = getVendas(4321);
		for (Venda venda : vendas) {
			vendaSerie2015.set(venda.getLivro().getTitulo(), venda.getQuantidade());
		}
		model.addSeries(vendaSerie2015);
		model.setTitle("Horizontal and Stacked");
		model.setLegendPosition("e");
		model.setStacked(true);
		model.setAnimate(true);
		Axis xAxis = model.getAxis(AxisType.X);
		xAxis.setLabel("Vendas");
		Axis yAxis = model.getAxis(AxisType.Y);
		yAxis.setLabel("Ano");
		return model;
	}
}
