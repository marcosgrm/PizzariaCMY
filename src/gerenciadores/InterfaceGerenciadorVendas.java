package gerenciadores;

import java.util.List;

import classes.Consumivel;

public interface InterfaceGerenciadorVendas {

	List<Consumivel> abaMostraPedidosCompra();

	boolean existe(long codigo);

	long criaCodigoValido();

	boolean removePorCodigo(long codigo);

	void abaConsulta();
}
