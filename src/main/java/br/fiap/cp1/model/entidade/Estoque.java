package br.fiap.cp1.model.entidade;

public class Estoque {

	int id, idProd, qtdAtual, qtdMin, qtdMax;

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

	public int getQtdAtual() {
		return qtdAtual;
	}

	public void setQtdAtual(int qtdAtual) {
		this.qtdAtual = qtdAtual;
	}

	public int getQtdMin() {
		return qtdMin;
	}

	public void setQtdMin(int qtdMin) {
		this.qtdMin = qtdMin;
	}

	public int getQtdMax() {
		return qtdMax;
	}

	public void setQtdMax(int qtdMax) {
		this.qtdMax = qtdMax;
	}

	public Estoque(int id, int idProd, int qtdAtual, int qtdMin, int qtdMax) {
		super();
		this.id = id;
		this.idProd = idProd;
		this.qtdAtual = qtdAtual;
		this.qtdMin = qtdMin;
		this.qtdMax = qtdMax;
	}
	
	
	
}
