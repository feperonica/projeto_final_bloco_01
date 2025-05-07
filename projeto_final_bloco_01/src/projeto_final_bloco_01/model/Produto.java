package projeto_final_bloco_01.model;

import java.text.NumberFormat;

public abstract class Produto {

	private int id;
	private String nome;
	private int categoria;
	private double preco;

	public Produto(int id, String nome, int categoria, double preco) {
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public void visualizar() {
		
		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();
		
		String categoria = "";
				
		switch (this.categoria) {
		case 1 -> categoria = "Componente";
		case 2 -> categoria = "Periférico";
		default -> categoria = "Inválido";
	}
		
		System.out.println("ID do Produto: " + this.id);
		System.out.println("Nome: " + this.nome);
		System.out.println("Categoria: " + categoria);
		System.out.println("Preço: " + nfMoeda.format(this.preco));
	}
}