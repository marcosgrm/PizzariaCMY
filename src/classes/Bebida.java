package classes;

public class Bebida extends Consumivel {
	private String conteudo;

	public Bebida(String nome, int codigo, String conteudo, double precoBase) {
		super(codigo, precoBase, nome);
		this.conteudo = conteudo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	@Override
	public String toString() {
		return "Bebida [conteudo=" + conteudo + "]";
	}

}
