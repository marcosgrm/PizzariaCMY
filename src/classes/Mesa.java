package classes;

public class Mesa {
	private boolean disponibilidade;
	private int codigo;
	
	public Mesa(int codigoDaMesa) {
		this.disponibilidade = true;
		this.codigo = codigoDaMesa;
	}

	public boolean getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "\nMesa código " +codigo
				+"\nDisponibilidade: " + disponibilidade;
	}
	
}
