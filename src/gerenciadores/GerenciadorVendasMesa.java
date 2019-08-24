package gerenciadores;

import java.util.ArrayList;
import java.util.List;
import classes.Consumivel;
import utilitarios.Utilidades;
import venda.VendaMesa;

public class GerenciadorVendasMesa extends GerenciadorVendas implements InterfaceGerenciadorVendas {
	List<VendaMesa> vendasMesa;

	public GerenciadorVendasMesa() {
		vendasMesa = new ArrayList<VendaMesa>();
	}

	public List<VendaMesa> getVendasMesa() {
		return vendasMesa;
	}

	public void setVendasMesa(List<VendaMesa> vendasMesa) {
		this.vendasMesa = vendasMesa;
	}

	@Override
	public String toString() {
		return "GerenciadorVendasMesa [vendasMesa=" + vendasMesa + "]";
	}
	
	

	/**
	 * M�todo que verifica se uma venda j� existe informando seu c�digo
	 */
	@Override
	public boolean existe(long codigo) {
		int aux = -1;
		for (int i = 0; i < vendasMesa.size(); i++) {
			if (vendasMesa.get(i).getCodVenda() == codigo) {
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
	 * M�todo que retorna um objeto do tipo VendaMesa informando seu c�digo
	 * 
	 * @param codigo
	 * @return
	 */
	public VendaMesa retornaObjeto(long codigo) {
		int aux = -1;
		for (int i = 0; i < vendasMesa.size(); i++) {
			if (vendasMesa.get(i).getCodVenda() == codigo) {
				aux = i;
				break;
			}
		}
		if (aux != -1) {
			return vendasMesa.get(aux);
		} else {
			System.out.println("Venda n�o cadastrada!");
			return null;
		}
	}

	/**
	 * M�todo que remove uma venda do tipo VendaMesa informando seu c�digo
	 */
	@Override
	public boolean removePorCodigo(long codigo) {
		if (existe(codigo) == false) {
			System.out.println("Venda n�o cadastrada!");
			return false;
		} else {
			vendasMesa.remove(retornaObjeto(codigo));
			System.out.println("Venda cancelada com sucesso!");
			return true;
		}
	}

	/**
	 * M�todo que adiciona um objeto do tipo VendaMesa na lista de vendas j� feitas
	 * @param vendaMesa
	 * @return
	 */
	public boolean adiciona(VendaMesa vendaMesa) {
		if (existe(vendaMesa.getCodVenda()) == true) {
			System.out.println("Venda com este c�digo j� est� cadastrada!");
			return false;
		} else {
			vendasMesa.add(vendaMesa);
			return true;
		}
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
	 * M�todo que verifica validade de um n�mero correspondente � quantidade
	 * 
	 * @param valor
	 * @return
	 */
	public boolean verificaValidadeQtd(int valor) {
		if (valor <= 0) {
			System.out.println("Valor n�o permitido!");
			return false;
		} else {
			return true;
		}
	}

	/**
	 * M�todo de intera��o com o usu�rio: Mostra pedidos de uma compra informando o c�digo de compra/venda
	 */
	@Override
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

	/**
	 * M�todo de intera��o com usu�rio: Mostra detalhes de uma venda/compra informando o c�digo de venda/compra
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

}
