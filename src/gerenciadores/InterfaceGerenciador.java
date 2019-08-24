package gerenciadores;

public interface InterfaceGerenciador {

	boolean existe(int codigo);

	boolean removePorCodigo(int codigo);

	void abaAtualizacao();

	void abaRemocao();

	void abaCadastro();

	void abaConsulta();

	void abaCrud();

}
