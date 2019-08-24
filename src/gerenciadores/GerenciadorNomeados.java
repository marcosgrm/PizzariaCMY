package gerenciadores;

public interface GerenciadorNomeados {
	boolean existe(int codigo);
	boolean removePorCodigo(int codigo);
	public int pesquisaCodigoPorNome(String nome);

}
