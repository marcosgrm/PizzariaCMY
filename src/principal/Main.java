package principal;

import gerenciadores.*;
import venda.VendaDelivery;
import venda.VendaMesa;

public class Main {

	public static void main(String[] args) {

		/**
		 * Cria��o de um gerenciador de bairros (alguns objetos j� criados a partir do
		 * construtor da classe)
		 */
		GerenciadorBairros listaBairros = new GerenciadorBairros();

		/**
		 * Cria��o de um gerenciador de mesas (alguns objetos j� criados a partir do
		 * construtor da classe)
		 */
		GerenciadorMesas listaMesas = new GerenciadorMesas();

		/**
		 * Cria��o de um gerenciador de pizzas (alguns objetos j� criados a partir do
		 * construtor da classe)
		 */
		GerenciadorPizzas listaPizzas = new GerenciadorPizzas();

		/**
		 * Cria��o de um gerenciador de bebidas (alguns objetos j� criados a partir do
		 * construtor da classe)
		 */
		GerenciadorBebidas listaBebidas = new GerenciadorBebidas();

		/**
		 * Cria��o de um gerenciador de gar�ons (alguns objetos j� criados a partir do
		 * construtor da classe)
		 */
		GerenciadorGarcons listaGarcons = new GerenciadorGarcons();

		/**
		 * Cria��o de um gerenciador de entregadores (alguns objetos j� criados a partir
		 * do construtor da classe)
		 */
		GerenciadorEntregadores listaEntregadores = new GerenciadorEntregadores();

		/**
		 * Cria��o de um gerenciador de vendas do tipo delivery
		 */
		GerenciadorVendasDelivery listaVendasDelivery = new GerenciadorVendasDelivery();

		/**
		 * Cria��o de um gerenciador de vendas do tipo mesa
		 */
		GerenciadorVendasMesa listaVendasMesa = new GerenciadorVendasMesa();

		/**
		 * Cria��o da classe sistema
		 */
		Sistema sistema = new Sistema();

		/**
		 * Cria��o de um objeto vazio do tipo VendaDelivery para ter acesso ao m�todo de
		 * venda para delivery
		 */
		VendaDelivery abaVendaDelivery = new VendaDelivery();

		/**
		 * Cria��o de um objeto vazio do tipo VendaMesa para ter acesso ao m�todo de
		 * venda para mesa
		 */
		VendaMesa abaVendaMesa = new VendaMesa();

		sistema.inicializa(listaPizzas, listaBebidas, listaEntregadores, listaGarcons, listaMesas, listaVendasDelivery,
				listaBairros, listaVendasMesa, abaVendaDelivery, abaVendaMesa);

	}
}
