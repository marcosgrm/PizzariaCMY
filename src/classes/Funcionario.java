package classes;
abstract class Funcionario {
	private String nome;
	private String cargo;
	private int codigo;
	
	public Funcionario(String nomeDoFuncionario, String cargoDoFuncionario, int codigo) {
		this.nome = nomeDoFuncionario;
		this.cargo = cargoDoFuncionario;
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", cargo=" + cargo + ", codigo=" + codigo + "]";
	}


}
