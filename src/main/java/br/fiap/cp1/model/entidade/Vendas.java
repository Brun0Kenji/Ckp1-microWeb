package br.fiap.cp1.model.entidade;

public class Vendas {

	int id, idProd;
	double preco;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdProd() {
		return idProd;
	}
	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public Vendas(int id, int idProd, double preco) {
		super();
		this.id = id;
		this.idProd = idProd;
		this.preco = preco;
	}
	
	
	
}
