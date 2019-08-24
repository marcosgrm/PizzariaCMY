package principal;

import gerenciadores.*;
import venda.VendaDelivery;
import venda.VendaMesa;

public class Main {

	public static void main(String[] args) {

		/**
		 * Criação de um gerenciador de bairros (alguns objetos já criados a partir do
		 * construtor da classe)
		 */
		GerenciadorBairros listaBairros = new GerenciadorBairros();

		/**
		 * Criação de um gerenciador de mesas (alguns objetos já criados a partir do
		 * construtor da classe)
		 */
		GerenciadorMesas listaMesas = new GerenciadorMesas();

		/**
		 * Criação de um gerenciador de pizzas (alguns objetos já criados a partir do
		 * construtor da classe)
		 */
		GerenciadorPizzas listaPizzas = new GerenciadorPizzas();

		/**
		 * Criação de um gerenciador de bebidas (alguns objetos já criados a partir do
		 * construtor da classe)
		 */
		GerenciadorBebidas listaBebidas = new GerenciadorBebidas();

		/**
		 * Criação de um gerenciador de garçons (alguns objetos já criados a partir do
		 * construtor da classe)
		 */
		GerenciadorGarcons listaGarcons = new GerenciadorGarcons();

		/**
		 * Criação de um gerenciador de entregadores (alguns objetos já criados a partir
		 * do construtor da classe)
		 */
		GerenciadorEntregadores listaEntregadores = new GerenciadorEntregadores();

		/**
		 * Criação de um gerenciador de vendas do tipo delivery
		 */
		GerenciadorVendasDelivery listaVendasDelivery = new GerenciadorVendasDelivery();

		/**
		 * Criação de um gerenciador de vendas do tipo mesa
		 */
		GerenciadorVendasMesa listaVendasMesa = new GerenciadorVendasMesa();

		/**
		 * Criação da classe sistema
		 */
		Sistema sistema = new Sistema();

		/**
		 * Criação de um objeto vazio do tipo VendaDelivery para ter acesso ao método de
		 * venda para delivery
		 */
		VendaDelivery abaVendaDelivery = new VendaDelivery();

		/**
		 * Criação de um objeto vazio do tipo VendaMesa para ter acesso ao método de
		 * venda para mesa
		 */
		VendaMesa abaVendaMesa = new VendaMesa();

		sistema.inicializa(listaPizzas, listaBebidas, listaEntregadores, listaGarcons, listaMesas, listaVendasDelivery,
				listaBairros, listaVendasMesa, abaVendaDelivery, abaVendaMesa);

	}
}
