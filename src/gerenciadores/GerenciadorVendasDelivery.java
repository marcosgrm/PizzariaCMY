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
	 * M�todo que cria um c�digo de venda v�lido de acordo com as vendas j�
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
	 * M�todo que verifica se o c�digo de uma venda j� existe no hist�rico de vendas
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
	 * M�todo que retorna um objeto VendaDelivery informando seu c�digo
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
			System.out.println("Venda n�o cadastrada!");
			return null;
		}
	}

	/**
	 * M�todo que remove um objeto VendaDelivery da lista de VendaDelivery
	 * 
	 * @param codigo
	 * @return
	 */
	@Override
	public boolean removePorCodigo(long codigo) {
		if (existe(codigo) == false) {
			System.out.println("Venda n�o cadastrada!");
			return false;
		} else {
			vendasDelivery.remove(retornaObjeto(codigo));
			System.out.println("Venda cancelada com sucesso!");
			return true;
		}
	}

	/**
	 * M�todo de intera��o com usu�rio: Consulta de vendas informando o c�digo da venda
	 */
	@Override
	public void abaConsulta() {
		int codVenda;
		System.out.println("---CONSULTA DE VENDAS---");
		System.out.println("Insira o c�digo da venda: ");
		codVenda = sc.nextInt();
		if (existe(codVenda) == false) {
			System.out.println("C�digo n�o cadastrado!");
		} else {
			retornaObjeto(codVenda);
		}
	}

	/**
	 * M�todo que adiciona um objeto vendaDelivery � lista de vendas a partir de um
	 * objeto vendaDelivery
	 * 
	 * @param vendaDelivery
	 * @return
	 */
	public boolean adiciona(VendaDelivery vendaDelivery) {
		if (existe(vendaDelivery.getCodVenda()) == true) {
			System.out.println("Venda com este c�digo j� est� cadastrada!");
			return false;
		} else {
			vendasDelivery.add(vendaDelivery);
			return true;

		}
	}
	
	/**
	 * M�todo de intera��o com usu�rio: Mostra pedidos de uma compra informando o c�digo de compra
	 * @return
	 */
	public List<Consumivel> abaMostraPedidosCompra() {
		long codVenda;
		System.out.println("Digite o c�digo da compra: ");
		codVenda = sc.nextLong();
		if (existe(codVenda) == false) {
			System.out.println("C�digo n�o cadastrado!");
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
