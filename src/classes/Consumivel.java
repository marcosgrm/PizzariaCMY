package classes;
public abstract class Consumivel {
	private int codigo;
	private double precoBase;
	private String nome;
	
	public Consumivel(int codigo, double precoBase, String nome){
		this.codigo = codigo;
		this.precoBase=precoBase;
		this.nome=nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getPrecoBase() {
		return precoBase;
	}

	public void setPrecoBase(double preco) {
		this.precoBase = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Consumivel [codigo=" + codigo + ", precoBase=" + precoBase + ", nome=" + nome + "]";
	}
	
}
