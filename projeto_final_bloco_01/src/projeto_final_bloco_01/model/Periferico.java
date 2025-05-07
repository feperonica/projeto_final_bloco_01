package projeto_final_bloco_01.model;

public class Periferico extends Produto {

	private String tipoConexao;

	public Periferico(int id, String nome, int categoria, double preco, String tipoConexao) {
		super(id, nome, categoria, preco);
		this.tipoConexao = tipoConexao;
	}

	public String getTipoConexao() {
		return tipoConexao;
	}

	public void setTipoConexao(String tipoConexao) {
		this.tipoConexao = tipoConexao;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Tipo de Conexão: " + this.tipoConexao);
	}
}