package utilitarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import gerenciadores.*;
import venda.Venda;
import venda.VendaDelivery;
import venda.VendaMesa;

public class Relatorios {
	Scanner sc = new Scanner(System.in);

	/**
	 * Método que retorna o faturamento atual
	 * 
	 * @param gerenciadorVendasDelivery
	 * @param gerenciadorVendasMesa
	 * @return
	 */
	public double faturamento(GerenciadorVendasDelivery gerenciadorVendasDelivery,
			GerenciadorVendasMesa gerenciadorVendasMesa) {
		List<Venda> vendas = new ArrayList<Venda>();
		List<VendaDelivery> vendasDelivery = new ArrayList<VendaDelivery>();
		List<VendaMesa> vendasMesa = new ArrayList<VendaMesa>();
		double total = 0;

		vendasDelivery = gerenciadorVendasDelivery.getVendasDelivery();
		vendasMesa = gerenciadorVendasMesa.getVendasMesa();

		vendas.addAll(vendasDelivery);
		vendas.addAll(vendasMesa);

		if (vendas.size() == 0) {
			System.out.println("Nenhuma venda foi feita!");
		} else {
			for (int i = 0; i < vendas.size(); i++) {
				total += vendas.get(i).getTotal();
			}
		}
		return total;
	}
	
	/**
	 * Método que mostra o total atual de produtos já vendidos
	 * @param gerenciadorVendasDelivery
	 * @param gerenciadorVendasMesa
	 */
	public void totalProdutosVendidos(GerenciadorVendasDelivery gerenciadorVendasDelivery,
			GerenciadorVendasMesa gerenciadorVendasMesa) {
		List<Venda> vendas = new ArrayList<Venda>();
		List<VendaDelivery> vendasDelivery = new ArrayList<VendaDelivery>();
		List<VendaMesa> vendasMesa = new ArrayList<VendaMesa>();
		int total = 0;
		vendasDelivery = gerenciadorVendasDelivery.getVendasDelivery();
		vendasMesa = gerenciadorVendasMesa.getVendasMesa();

		vendas.addAll(vendasDelivery);
		vendas.addAll(vendasMesa);

		if (vendas.size() == 0) {
			System.out.println("Nenhuma venda foi feita!");
		} else {
			System.out.println("Produtos vendidos:");
			for (int i = 0; i < vendas.size(); i++) {
				System.out.println(vendas.get(i).getPedidos());
				total += vendas.get(i).getPedidos().size();
				System.out.println("\n");
			}
			System.out.println("\nQuantidade de produtos vendidos: " + total);
		}
	}

	/**
	 * Método que retorna comissão de um garçom informando seu código
	 * 
	 * @param gerenciadorGarcons
	 * @return
	 */
	public double totalComissaoGarcom(GerenciadorGarcons gerenciadorGarcons) {
		int cod;
		double comissao = 0;
		System.out.println("Insira o código do garçom: ");
		cod = sc.nextInt();
		if (gerenciadorGarcons.existe(cod) == false) {
			System.out.println("Garçom não cadastrado!");
		} else {
			comissao = gerenciadorGarcons.retornaObjeto(cod).getComissao();
		}
		return comissao;
	}
	

	/**
	 * Método que exibe o histórico de vendas e suas respectivas informações
	 */
	public void historico(GerenciadorVendasDelivery gerenciadorVendasDelivery,
			GerenciadorVendasMesa gerenciadorVendasMesa) {
		System.out.println("========HISTÓRICO DE VENDAS========");
		if (gerenciadorVendasDelivery.getVendasDelivery().size() == 0
				&& gerenciadorVendasMesa.getVendasMesa().size() == 0) {
			System.out.println("Nenhuma venda cadastrada!");
		} else {
			
				System.out.println(gerenciadorVendasDelivery.getVendasDelivery());
				System.out.println(gerenciadorVendasMesa.getVendasMesa());
			
		}
	}
}
