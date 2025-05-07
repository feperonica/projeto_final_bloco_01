package projeto_final_bloco_01.model;

public class Componente extends Produto {

	private String especificacao;

	public Componente(int id, String nome, int categoria, double preco, String especificacao) {
		super(id, nome, categoria, preco);
		this.especificacao = especificacao;
	}

	public String getEspecificacao() {
		return especificacao;
	}

	public void setEspecificacao(String especificacao) {
		this.especificacao = especificacao;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Especificação Técnica: " + this.especificacao);
	}
}