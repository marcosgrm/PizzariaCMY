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
	 * Método que verifica se uma venda já existe informando seu código
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
	 * Método que retorna um objeto do tipo VendaMesa informando seu código
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
			System.out.println("Venda não cadastrada!");
			return null;
		}
	}

	/**
	 * Método que remove uma venda do tipo VendaMesa informando seu código
	 */
	@Override
	public boolean removePorCodigo(long codigo) {
		if (existe(codigo) == false) {
			System.out.println("Venda não cadastrada!");
			return false;
		} else {
			vendasMesa.remove(retornaObjeto(codigo));
			System.out.println("Venda cancelada com sucesso!");
			return true;
		}
	}

	/**
	 * Método que adiciona um objeto do tipo VendaMesa na lista de vendas já feitas
	 * @param vendaMesa
	 * @return
	 */
	public boolean adiciona(VendaMesa vendaMesa) {
		if (existe(vendaMesa.getCodVenda()) == true) {
			System.out.println("Venda com este código já está cadastrada!");
			return false;
		} else {
			vendasMesa.add(vendaMesa);
			return true;
		}
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
	 * Método que verifica validade de um número correspondente à quantidade
	 * 
	 * @param valor
	 * @return
	 */
	public boolean verificaValidadeQtd(int valor) {
		if (valor <= 0) {
			System.out.println("Valor não permitido!");
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Método de interação com o usuário: Mostra pedidos de uma compra informando o código de compra/venda
	 */
	@Override
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

	/**
	 * Método de interação com usuário: Mostra detalhes de uma venda/compra informando o código de venda/compra
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

}
