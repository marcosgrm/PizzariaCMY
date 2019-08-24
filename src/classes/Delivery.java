package classes;

public class Delivery {
	private int numeroCasa;
	private String nomeRua;
	private int codigoBairro;
	private String pontoDeReferencia;
	private String observacoes;

	public Delivery(int numeroCasa, String nomeRua, int codigoBairro, String pontoDeReferencia, 
					String observacoes) {
		this.numeroCasa = numeroCasa;
		this.nomeRua = nomeRua;
		this.codigoBairro = codigoBairro;
		this.pontoDeReferencia = pontoDeReferencia;
		this.observacoes = observacoes;
	}

	public int getNumeroCasa() {
		return numeroCasa;
	}

	public void setNumeroCasa(int numeroCasa) {
		this.numeroCasa = numeroCasa;
	}

	public String getNomeRua() {
		return nomeRua;
	}

	public void setNomeRua(String nomeRua) {
		this.nomeRua = nomeRua;
	}

	public int getCodigoBairro() {
		return codigoBairro;
	}

	public void setCodigoBairro(int codigoBairro) {
		this.codigoBairro = codigoBairro;
	}

	public String getPontoDeReferencia() {
		return pontoDeReferencia;
	}

	public void setPontoDeReferencia(String pontoDeReferencia) {
		this.pontoDeReferencia = pontoDeReferencia;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	@Override
	public String toString() {
		return "Delivery [numeroCasa=" + numeroCasa + ", nomeRua=" + nomeRua + ", codigoBairro=" + codigoBairro
				+ ", pontoDeReferencia=" + pontoDeReferencia + ", observacoes=" + observacoes + "]";
	}
	
}
