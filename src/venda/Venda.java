package venda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import classes.*;
import gerenciadores.GerenciadorBebidas;
import gerenciadores.GerenciadorPizzas;


public abstract class Venda {
	private List<Consumivel> pedidos = new ArrayList<Consumivel>();
	private String data;
	private String hora;
	private long codVenda;
	private int qtdProd;
	private double total;
	private double valorDado;
	private double troco;
	private boolean pedidoFechado;

	Scanner sc = new Scanner(System.in);

	public List<Consumivel> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Consumivel> pedidos) {
		this.pedidos = pedidos;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public long getCodVenda() {
		return codVenda;
	}

	public void setCodVenda(long codVenda) {
		this.codVenda = codVenda;
	}

	public int getQtdProd() {
		return qtdProd;
	}

	public void setQtdProd(int qtdProd) {
		this.qtdProd = qtdProd;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getValorDado() {
		return valorDado;
	}

	public void setValorDado(double valorDado) {
		this.valorDado = valorDado;
	}

	public double getTroco() {
		return troco;
	}

	public void setTroco(double troco) {
		this.troco = troco;
	}

	public boolean isPedidoFechado() {
		return pedidoFechado;
	}

	public void setPedidoFechado(boolean pedidoFechado) {
		this.pedidoFechado = pedidoFechado;
	}
	

	public Venda() {

	}

	public Venda(List<Consumivel> pedidos, String data, String hora, long codVenda, int qtdProd, double total,
			double valorDado, double troco) {
		this.pedidos = pedidos;
		this.data = data;
		this.hora = hora;
		this.codVenda = codVenda;
		this.qtdProd = qtdProd;
		this.total = total;
		this.valorDado = valorDado;
		this.troco = troco;
		this.pedidoFechado = true;
	}

	/**
	 * Verifica se o pedido está fechado a partir de um objeto Venda
	 * 
	 * @param venda
	 * @return
	 */
	public boolean precoTamanho(Pizza pizza, String tamanho) {
		if (tamanho.equalsIgnoreCase("m")) {
			this.total = (pizza.getPrecoBase() + Pizza.pizzaM());
			return true;
		}
		if (tamanho.equalsIgnoreCase("g")) {
			this.total = (pizza.getPrecoBase() + Pizza.pizzaG());
			return true;
		}
		if (tamanho.equalsIgnoreCase("p")) {
			this.total = (pizza.getPrecoBase());
			return true;
		} else {
			System.out.println("Tamanho não aceito!");
			return false;
		}
	}

	/**
	 * Método de interação com o usuário: Faz pedido de bebidas
	 * @param gerenciadorBebidas
	 * @return
	 */
	public Bebida abaPedidoBebida(GerenciadorBebidas gerenciadorBebidas) {
		System.out.println("------PEDIDO BEBIDA------");

		int cod;
		int qtd;

		System.out.println("Insira o código da bebida: ");
		cod = sc.nextInt();
		if (gerenciadorBebidas.existe(cod) == false) {
			System.out.println("Código não cadastrado!");
			return null;
		} else {
			System.out.println("Insira a quantidade: ");
			qtd = sc.nextInt();
			if (qtd <= 0) {
				System.out.println("Quantidade não permitida!");
				return null;
			} else {
				this.qtdProd++;
				this.total += (gerenciadorBebidas.retornaObjeto(cod).getPrecoBase() * qtd);
				return gerenciadorBebidas.retornaObjeto(cod);
			}
		}
	}

	/**
	 * Método que retorna o valor total dos pedidos
	 * @return
	 */
	public double valorTotalPedidos() {
		return getTotal();
	}

	/**
	 * Método que retorna o maior preço entre duas pizzas
	 * @param p1
	 * @param p2
	 * @return
	 */
	public Pizza maiorValorDoisSabores(Pizza p1, Pizza p2) {
		if (p1.getPrecoBase() > p2.getPrecoBase()) {
			return p1;
		} else {
			return p2;
		}
	}

	@Override
	public String toString() {
		return "Venda [pedidos=" + pedidos + ", data=" + data + ", hora=" + hora + ", codVenda=" + codVenda
				+ ", qtdProd=" + qtdProd + ", total=" + total + ", troco=" + troco + ", pedidoFechado=" + pedidoFechado
				+ "]";
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
	 * Método que verifica validade do tamanho de uma pizza
	 * 
	 * @param tamanho
	 * @return
	 */
	public boolean verificaValidadeTamanho(String tamanho) {
		if (tamanho.equalsIgnoreCase("p") | tamanho.equalsIgnoreCase("m") | tamanho.equalsIgnoreCase("g")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Método que coleta informações da bebida que se quer fazer o pedido (seu
	 * código) e retorna um objeto bebida
	 * 
	 * @param gerenciadorBebidas
	 * @return
	 */
	public Bebida abaInformacoesBebida(GerenciadorBebidas gerenciadorBebidas) {
		int cod;
		Bebida bebida = null;
		System.out.println("----PEDIDO BEBIDA----");
		System.out.println("Digite o código da bebida: ");
		cod = sc.nextInt();
		if (gerenciadorBebidas.existe(cod) != false) {
			bebida = gerenciadorBebidas.retornaObjeto(cod);
		}
		return bebida;
	}

	/**
	 * Método para informar as informações da venda de uma pizza (qtd de sabores).
	 * Retorna uma pizza de maior valor.
	 * 
	 * @param gerenciadorPizzas
	 * @return
	 */
	public Pizza abaInformacoesPizza(GerenciadorPizzas gerenciadorPizzas) {
		System.out.println("------PEDIDO PIZZA------");
		Pizza pizza1 = null;
		Pizza pizza2 = null;
		Pizza pizzaMaiorValor = null;

		int qtdSabores;
		int cod1;
		int cod2;

		System.out.println("PIZZA DE QUANTOS SABORES?");
		System.out.println("[1]: 1 SABOR ");
		System.out.println("[2]: 2 SABORES");
		qtdSabores = sc.nextInt();

		switch (qtdSabores) {
		default:
			System.out.println("Erro, tente novamente!");
			break;

		case 1:
			System.out.println("Digite o cód. do SABOR 1: ");
			cod1 = sc.nextInt();
			if (gerenciadorPizzas.existe(cod1) == false) {
				System.out.println("Pizza não cadastrada!");
				return null;
			} else {
				pizzaMaiorValor = gerenciadorPizzas.retornaObjeto(cod1);
			}
			break;

		case 2:
			System.out.println("Digite o cód. do SABOR 1: ");
			cod1 = sc.nextInt();
			if (gerenciadorPizzas.existe(cod1) == false) {
				System.out.println("Pizza não cadastrada!");
				return null;
			} else {
				pizza1 = gerenciadorPizzas.retornaObjeto(cod1);
				System.out.println("Digite o cód. do SABOR 2: ");
				cod2 = sc.nextInt();
				if (gerenciadorPizzas.existe(cod2) == false) {
					System.out.println("Pizza não cadastrada!");
				} else {
					pizza2 = gerenciadorPizzas.retornaObjeto(cod2);
					pizzaMaiorValor = gerenciadorPizzas.retornaPizzaMaiorValor(pizza1, pizza2);
					System.out.println("Pizza de maior valor: " + pizzaMaiorValor.getNome());
					System.out.println("Preço da pizza de maior valor (P): " + pizzaMaiorValor.getPrecoBase());
				}
			}
			break;
		}
		return pizzaMaiorValor;
	}

	/**
	 * Método que recebe a pizza de maior valor e o tamanho dela e calcula o preço
	 * total, atualizando o valor desta pizza com este valor
	 * 
	 * @param pizza
	 * @param tamanho
	 * @return
	 */
	public void mudaValorPizzaTamanho(Pizza pizza, String tamanho) {
		double total = 0;
		if (tamanho.equalsIgnoreCase("m")) {
			total = (pizza.getPrecoBase() + Pizza.pizzaM());
		}
		if (tamanho.equalsIgnoreCase("g")) {
			total = (pizza.getPrecoBase() + Pizza.pizzaG());
		}
		if (tamanho.equalsIgnoreCase("p")) {
			total += (pizza.getPrecoBase());
		}
		pizza.setPrecoBase(total);
	}

	/**
	 * Método que retorna o preço total do pedido
	 * 
	 * @param pedidos
	 * @return
	 */
	public double retornaValorTotal(List<Consumivel> pedidos) {
		double total = 0;
		for (int i = 0; i < pedidos.size(); i++) {
			total += pedidos.get(i).getPrecoBase();
		}
		return total;
	}

	/**
	 * Método que recebe uma quantidade e adiciona um consumivel nesta quantidade na
	 * lista de pedidos
	 * 
	 * @param bebida
	 * @param qtd
	 * @return
	 */
	public void abaInsereQtd(Consumivel consumivel, List<Consumivel> pedidos) {
		int qtd;
		System.out.println("Insira a quantidade: ");
		qtd = sc.nextInt();
		if (verificaValidadeQtd(qtd) != false) {
			for (int i = 0; i < qtd; i++) {
				pedidos.add(consumivel);
			}
			System.out.println(qtd + " produtos adicionados à lista de pedidos!");
		} else {
			System.out.println("Quantidade inválida!");
		}
	}

	/**
	 * Método que retorna o tipo de produto para venda (1 para pizza e 2 para
	 * bebida)
	 */
	public int tipoDeProduto() {
		int op;
		System.out.println("Qual tipo de produto você quer vender? ");
		System.out.println("[1]: Pizza");
		System.out.println("[2]: Bebida");
		op = sc.nextInt();
		return op;
	}

	/**
	 * Método que adiciona um consúmivel na lista de pedidos e o retorna.
	 * 
	 * @param gerenciadorPizzas
	 * @param gerenciadorBebidas
	 * @return
	 */
	public Consumivel abaPedidos(GerenciadorPizzas gerenciadorPizzas, GerenciadorBebidas gerenciadorBebidas,
			List<Consumivel> pedidos) {
		Consumivel consumivel = null;
		Pizza pizza;
		Bebida bebida;
		int opAdd;
		int tipoDeProduto;
		String tamanho;

		tipoDeProduto = tipoDeProduto();

		switch (tipoDeProduto) {
		case 1:
			pizza = abaInformacoesPizza(gerenciadorPizzas);
			System.out.println("Insira o tamanho da pizza: ");
			tamanho = sc.nextLine();
			tamanho = sc.nextLine();
			if (verificaValidadeTamanho(tamanho) == false) {
				System.out.println("Tamanho inválido!");
			} else {
				mudaValorPizzaTamanho(pizza, tamanho);

				System.out.println("Deseja adicionar pizza à lista de pedidos?");
				System.out.println("[1]: SIM");
				System.out.println("[2]: NÃO, ABORTAR OPERAÇÃO");
				opAdd = sc.nextInt();
				switch (opAdd) {
				case 1:
					consumivel = pizza;
					abaInsereQtd(consumivel, pedidos);

					break;
				case 2:
					System.out.println("Operação abortada");
					break;
				default:
					System.out.println("Erro, opção não encontrada!");
					break;
				}
			}
			break;

		case 2:
			bebida = abaInformacoesBebida(gerenciadorBebidas);
			System.out.println("Deseja adicionar bebida à lista de pedidos?");
			System.out.println("[1]: SIM");
			System.out.println("[2]: NÃO, ABORTAR OPERAÇÃO");
			opAdd = sc.nextInt();

			switch (opAdd) {
			case 1:
				consumivel = bebida;
				abaInsereQtd(consumivel, pedidos);

				break;
			case 2:
				System.out.println("Operação abortada");
				break;
			default:
				System.out.println("Erro, opção não encontrada!");
				break;
			}
			break;
		}

		return consumivel;

	}

	/**
	 * Método de menu: pergunta se o usuário deseja adicionar um produto ou fechar o
	 * pedido
	 * 
	 * @return
	 */
	public int addOuFechar() {
		int op;
		System.out.println("VOCÊ DESEJA...");
		System.out.println("[1]: Adicionar um produto à lista de pedidos");
		System.out.println("[2]: Fechar compra");
		op = sc.nextInt();
		return op;
	}
	
	

}
