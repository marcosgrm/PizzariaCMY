package venda;

import java.util.ArrayList;
import java.util.List;

import classes.Consumivel;
import gerenciadores.*;
import utilitarios.Utilidades;

public class VendaMesa extends Venda {
	private int codGarcom;
	private int codMesa;

	public VendaMesa(int codGarcom, int codMesa) {
		this.codGarcom = codGarcom;
	}

	public int getCodGarcom() {
		return codGarcom;
	}

	public void setCodGarcom(int codGarcom) {
		this.codGarcom = codGarcom;
	}

	public int getCodMesa() {
		return codMesa;
	}

	public void setCodMesa(int codMesa) {
		this.codMesa = codMesa;
	}

	@Override
	public String toString() {
		return "\n -----------------------------" + "\nVendaMesa de código " + super.getCodVenda() + "\nRealizada em: "
				+ super.getData() + " às " + super.getHora() + "\n  -   Dados sobre a compra  -   " + "\nCód. Garçom: "
				+ codGarcom + "\nLista de compras: " + super.getPedidos() + "\nTotal: "
				+ super.getTotal() + "\nTroco: " + super.getTroco() + "\n ";
	}

	public VendaMesa(List<Consumivel> pedidos, String data, String hora, long codVenda, int qtdProd, double total,
			double valorDado, double troco, int codGarcom, int codMesa) {
		super(pedidos, data, hora, codVenda, qtdProd, total, valorDado, troco);
		this.codGarcom = codGarcom;
	}

	public VendaMesa() {

	}

	/**
	 * Pizzaria com sistema de comanda. Cliente entrega a comanda para o funcionário
	 * do caixa e o mesmo faz o cadastro da venda.
	 * 
	 * @param gerenciadorGarcons
	 * @param gerenciadorPizzas
	 * @param gerenciadorBebidas
	 * @param gerenciadorVendasDelivery
	 * @return
	 */
	public VendaMesa abaVendaMesa(GerenciadorGarcons gerenciadorGarcons, GerenciadorPizzas gerenciadorPizzas,
			GerenciadorBebidas gerenciadorBebidas, GerenciadorVendasMesa gerenciadorVendasMesa,
			GerenciadorMesas gerenciadorMesas) {
		VendaMesa vendaMesa = null;
		long codVenda;
		double total = 0;
		double troco = 0;
		int codGarcom;
		List<Consumivel> pedidos = new ArrayList<Consumivel>();
		Consumivel consumivel;
		String data;
		String hora;
		int qtdProd = 0;
		double valorDado;
		int addOuFechar;
		boolean pedidoFechado = false;

		System.out.println("=====VENDA MESA=====");
		System.out.println("Digite o código da mesa: ");
		codMesa = sc.nextInt();
		if (gerenciadorMesas.existe(codMesa) == false) {
			System.out.println("Mesa não cadastrada!");
		} else {
			if (gerenciadorMesas.retornaObjeto(codMesa).getDisponibilidade() == true) {
				System.out.println("Esta mesa não esteve ocupada!");
			} else {
				gerenciadorGarcons.listaResumida();
				System.out.println("Digite o código do garçom: ");
				codGarcom = sc.nextInt();
				if (gerenciadorGarcons.existe(codGarcom) == false) {
					System.out.println("Garçom com este código não está cadastrado!");
				} else {
					System.out.println("------------------------");
					while (pedidoFechado == false) {
						addOuFechar = addOuFechar();

						if (addOuFechar == 1) {
							System.out.println("---ADICIONAR PRODUTO À COMPRA---");
							consumivel = abaPedidos(gerenciadorPizzas, gerenciadorBebidas, pedidos);
							System.out.println("\nAINDA PARA ESTA COMPRA...");
						}

						if (addOuFechar == 2) {
							if (pedidos.size() == 0) {
								System.out.println("Venda cancelada! Não há pedidos");
								pedidoFechado = true;
							} else {
								total = retornaValorTotal(pedidos) + (retornaValorTotal(pedidos) * 0.05);// O valor
																											// total já
																											// inclui a
																											// porcentagem
																											// do garçom
								qtdProd = pedidos.size();
								System.out.println("Quantida de produtos na lista de pedidos: " + qtdProd);
								System.out.println("Total: " + total); // Já inclui os 5% do garçom
								System.out.println("Valor dado: ");
								valorDado = sc.nextDouble();
								troco = Utilidades.retornaTroco(valorDado, total);
								if (troco == -1) {
									System.out.println("ERRO! Valor dado é menor que o total");
								} else {
									System.out.println("Troco: " + troco);

									codVenda = gerenciadorVendasMesa.criaCodigoValido();
									data = Utilidades.data();
									hora = Utilidades.hora();

									vendaMesa = criaObjeto(pedidos, data, hora, codVenda, qtdProd, total, valorDado,
											troco, codGarcom, codMesa);
									gerenciadorVendasMesa.adiciona(vendaMesa);
									System.out.println("Venda realizada e cadastrada com sucesso!");
									System.out.println("Venda feita dia " + data + " às " + hora);
									System.out.println("\n Código da venda: " + codVenda);
									gerenciadorGarcons.retornaObjeto(codGarcom).adicionaVenda(vendaMesa);
									gerenciadorGarcons.retornaObjeto(codGarcom)
											.adicionaComissao(retornaValorTotal(pedidos));
									pedidoFechado = true;
								}
							}
						}
					}
				}
			}
			if (vendaMesa == null) {
				System.out.println("Erro, a venda não foi feita!");
			}
		}
		gerenciadorMesas.desocuparMesa(codMesa);
		return vendaMesa;
	}

	/**
	 * Método que cria um objeto do tipo VendaMesa e o retorna.
	 * @param pedidos
	 * @param data
	 * @param hora
	 * @param codVenda
	 * @param qtdProd
	 * @param total
	 * @param valorDado
	 * @param troco
	 * @param codGarcom
	 * @param codMesa
	 * @return
	 */
	public VendaMesa criaObjeto(List<Consumivel> pedidos, String data, String hora, long codVenda, int qtdProd,
			double total, double valorDado, double troco, int codGarcom, int codMesa) {

		VendaMesa vendaMesa = new VendaMesa(pedidos, data, hora, codVenda, qtdProd, total, valorDado, troco, codGarcom,
				codMesa);
		return vendaMesa;
	}

}
