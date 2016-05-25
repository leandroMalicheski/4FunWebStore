package br.com.fourfungames.model;

public class Produto {
	int id;
	double valor;
	String name;
	String caminhoImagem;

	public Produto(int id, String name,String caminhoImagem, double valor){
		this.id = id;
		this.valor = valor;
		this.name = name;
		this.caminhoImagem = caminhoImagem;
	}
	public Produto(String name,String caminhoImagem, double valor){
		this.valor = valor;
		this.name = name;
		this.caminhoImagem = caminhoImagem;
	}
	
	public Produto(){}
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCaminhoImagem() {
		return this.caminhoImagem;
	}

	public void setCaminhoImagem(String caminhoImagem) {
		this.caminhoImagem = caminhoImagem;
	}
}