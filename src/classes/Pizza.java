package classes;

public class Pizza extends Consumivel {
	int tipo; // 1: salgada 2: doce
	int codSabor;
	String descricao; //Descriçao do sabor da pizza
	String tamanho;

	public Pizza(int tipo, String nomeSabor, String descricao, int codSabor, double precoBase) {
		super(1, precoBase, nomeSabor);
		this.tipo = tipo;
		this.descricao = descricao;
		this.codSabor = codSabor;
		this.tamanho="p";
	}
	
	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getCodSabor() {
		return codSabor;
	}

	public void setCodSabor(int codSabor) {
		this.codSabor = codSabor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return "Pizza [tipo=" + tipo + ", nome=" +super.getNome() +", codSabor=" + codSabor + ", descricao=" + descricao + "]";
	}

	/**
	 * Que método que aumenta o preço base da pizza em 5 reais;
	 * @return
	 */
	public static double pizzaM() {
		return 5;
	}

	/**
	 * Método que aumenta o preço base da pizza em 10 reais;
	 * @return
	 */
	public static double pizzaG() {
		return 10;
	}

}
