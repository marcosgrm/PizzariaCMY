package gerenciadores;
import java.util.ArrayList;
import classes.*;
import java.util.List;
import utilitarios.Utilidades;
import venda.VendaDelivery;

public class GerenciadorVendasDelivery extends GerenciadorVendas implements InterfaceGerenciadorVendas{
	List<VendaDelivery> vendasDelivery;

	/**
	 * Construtor vazio
	 */
	public GerenciadorVendasDelivery() {
		vendasDelivery = new ArrayList<VendaDelivery>();
	}

	/**
	 * Método que cria um código de venda válido de acordo com as vendas já
	 * cadastradas
	 * 
	 * @return
	 */
	@Override
	public long criaCodigoValido() {
		long cod = Utilidades.numAleatorioOitoD();

		while (existe(cod) == true) {
			cod = Utilidades.numAleatorioOitoD();
		}
		return cod;
	}

	/**
	 * Método que verifica se o código de uma venda já existe no histórico de vendas
	 * 
	 * @param codigo
	 * @return
	 */
	@Override
	public boolean existe(long codigo) {
		int aux = -1;
		for (int i = 0; i < vendasDelivery.size(); i++) {
			if (vendasDelivery.get(i).getCodVenda() == codigo) {
				aux++;
				break;
			}
		}
		if (aux == -1) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Método que retorna um objeto VendaDelivery informando seu código
	 * 
	 * @param codigo
	 * @return
	 */
	public VendaDelivery retornaObjeto(long codigo) {
		int aux = -1;
		for (int i = 0; i < vendasDelivery.size(); i++) {
			if (vendasDelivery.get(i).getCodVenda() == codigo) {
				aux = i;
				break;
			}
		}
		if (aux != -1) {
			return vendasDelivery.get(aux);
		} else {
			System.out.println("Venda não cadastrada!");
			return null;
		}
	}

	/**
	 * Método que remove um objeto VendaDelivery da lista de VendaDelivery
	 * 
	 * @param codigo
	 * @return
	 */
	@Override
	public boolean removePorCodigo(long codigo) {
		if (existe(codigo) == false) {
			System.out.println("Venda não cadastrada!");
			return false;
		} else {
			vendasDelivery.remove(retornaObjeto(codigo));
			System.out.println("Venda cancelada com sucesso!");
			return true;
		}
	}

	/**
	 * Método de interação com usuário: Consulta de vendas informando o código da venda
	 */
	@Override
	public void abaConsulta() {
		int codVenda;
		System.out.println("---CONSULTA DE VENDAS---");
		System.out.println("Insira o código da venda: ");
		codVenda = sc.nextInt();
		if (existe(codVenda) == false) {
			System.out.println("Código não cadastrado!");
		} else {
			retornaObjeto(codVenda);
		}
	}

	/**
	 * Método que adiciona um objeto vendaDelivery à lista de vendas a partir de um
	 * objeto vendaDelivery
	 * 
	 * @param vendaDelivery
	 * @return
	 */
	public boolean adiciona(VendaDelivery vendaDelivery) {
		if (existe(vendaDelivery.getCodVenda()) == true) {
			System.out.println("Venda com este código já está cadastrada!");
			return false;
		} else {
			vendasDelivery.add(vendaDelivery);
			return true;

		}
	}
	
	/**
	 * Método de interação com usuário: Mostra pedidos de uma compra informando o código de compra
	 * @return
	 */
	public List<Consumivel> abaMostraPedidosCompra() {
		long codVenda;
		System.out.println("Digite o código da compra: ");
		codVenda = sc.nextLong();
		if (existe(codVenda) == false) {
			System.out.println("Código não cadastrado!");
			return null;
		} else {
			return retornaObjeto(codVenda).getPedidos();
		}
	}
	

	public List<VendaDelivery> getVendasDelivery() {
		return vendasDelivery;
	}

	public void setVendasDelivery(List<VendaDelivery> vendasDelivery) {
		this.vendasDelivery = vendasDelivery;
	}

	@Override
	public String toString() {
		return "GerenciadorVendasDelivery [vendasDelivery=" + vendasDelivery + "]";
	}
	
	

}
