package classes;

public class Bairro {
	private String nome;
	private int codigo;
	private double frete;
	
	public Bairro(String nome, int codigo, double frete) {
		this.nome = nome;
		this.codigo = codigo;
		this.frete=frete;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getFrete() {
		return frete;
	}

	public void setFrete(double frete) {
		this.frete = frete;
	}

	@Override
	public String toString() {
		return "Bairro [nome=" + nome + ", codigo=" + codigo + ", frete=" + frete + "]";
	}

}

