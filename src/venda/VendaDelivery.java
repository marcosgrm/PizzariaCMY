package venda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import classes.Consumivel;
import gerenciadores.GerenciadorBairros;
import gerenciadores.GerenciadorBebidas;
import gerenciadores.GerenciadorEntregadores;
import gerenciadores.GerenciadorPizzas;
import gerenciadores.GerenciadorVendasDelivery;
import utilitarios.Utilidades;

public class VendaDelivery extends Venda {
	private int codBairro;
	private String rua;
	private int numero;
	private String pontoDeReferencia;
	private long contato;
	private String nomeCliente;
	private int codVeiculo;
	private String observacoes;

	@Override
	public String toString() {
		return "\n -----------------------------" + "\nVendaDelivery de c�digo " + super.getCodVenda()
				+ "\nRealizada em: " + super.getData() + " �s " + super.getHora()
				+ "\n  -   Dados sobre o cliente  -   " + "\nNome do Cliente: " + nomeCliente + "\nContato: " + contato
				+ "\nCod. Bairro: " + codBairro + "\nRua: " + rua + "\nN�mero: " + numero + "\nPonto de Referencia: "
				+ pontoDeReferencia + "\nObservacoes: " + observacoes + "\n  -   Dados sobre a compra  -   "
				+ "\nC�digo do Veiculo de Entrega: " + codVeiculo + "\nLista de compras: " + super.getPedidos()
				+ "\nTotal: " + super.getTotal() + "\nTroco: " + super.getTroco() + "\n ";
	}

	public VendaDelivery(List<Consumivel> pedidos, String data, String hora, long codVenda, int qtdProd, double total,
			double valorDado, double troco, int codBairro, String rua, int numero, String pontoDeReferencia,
			long contato, String nomeCliente, int codVeiculo, String observacoes) {
		super(pedidos, data, hora, codVenda, qtdProd, total, valorDado, troco);
		this.codBairro = codBairro;
		this.rua = rua;
		this.numero = numero;
		this.pontoDeReferencia = pontoDeReferencia;
		this.contato = contato;
		this.nomeCliente = nomeCliente;
		this.codVeiculo = codVeiculo;
		this.observacoes = observacoes;
	}

	public VendaDelivery() {

	}

	public int getCodBairro() {
		return codBairro;
	}

	public void setCodBairro(int codBairro) {
		this.codBairro = codBairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getPontoDeReferencia() {
		return pontoDeReferencia;
	}

	public void setPontoDeReferencia(String pontoDeReferencia) {
		this.pontoDeReferencia = pontoDeReferencia;
	}

	public long getContato() {
		return contato;
	}

	public void setContato(long contato) {
		this.contato = contato;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public int getCodVeiculo() {
		return codVeiculo;
	}

	public void setCodVeiculo(int codVeiculo) {
		this.codVeiculo = codVeiculo;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	/**
	 * M�todo de intera��o com o usu�rio para venda do tipo delivery
	 * 
	 * @param listaBairros
	 * @param listaEntregadores
	 * @param gerenciadorPizzas
	 * @param gerenciadorBebidas
	 * @return
	 */
	public VendaDelivery abaVendaDelivery(GerenciadorBairros listaBairros, GerenciadorEntregadores listaEntregadores,
			GerenciadorPizzas gerenciadorPizzas, GerenciadorBebidas gerenciadorBebidas,
			GerenciadorVendasDelivery gerenciadorVendasDelivery) {
		long codVenda;
		double total = 0;
		double troco = 0;
		int codBairro;
		String rua;
		int numero;
		String pontoDeReferencia;
		long contato;
		String nomeCliente;
		int codVeiculo;
		String observacoes;
		VendaDelivery vendaDelivery = null;
		List<Consumivel> pedidos = new ArrayList<Consumivel>();
		Consumivel consumivel;
		String data;
		String hora;
		int qtdProd = 0;
		double valorDado;
		int addOuFechar;
		boolean pedidoFechado = false;

		System.out.println("=====VENDA DELIVERY=====");
		System.out.println("Digite o nome do cliente: ");
		nomeCliente = sc.nextLine();

		System.out.println("Digite o nome da rua: ");
		rua = sc.nextLine();

		System.out.print("Digite o n�mero da casa: ");
		numero = sc.nextInt();

		System.out.println("\n");
		listaBairros.lista();
		System.out.print("\nDigite o c�digo do bairro: ");
		codBairro = sc.nextInt();
		if (listaBairros.existe(codBairro) == false) {
			System.out.println("C�digo n�o cadastrado!");
		} else {
			listaBairros.retornaObjeto(codBairro).getCodigo();

			System.out.println("Digite um ponto de refer�ncia: ");
			pontoDeReferencia = sc.nextLine();
			pontoDeReferencia = sc.nextLine();

			System.out.println(
					"Digite o telefone para contato:  " + "\n(somente numeros, sem caracteres como - ou '(' ')' )");
			contato = sc.nextLong();

			System.out.println("Observa��es?");
			observacoes = sc.nextLine();
			observacoes = sc.nextLine();

			System.out.println("------------------------\n");

			listaEntregadores.listaResumida();
			System.out.println("\nC�digo do -VE�CULO- de entrega: ");
			codVeiculo = sc.nextInt();
			if (listaEntregadores.existeVeiculo(codVeiculo) == false) {
				System.out.println("C�digo n�o cadastrado!");
			} else {
				System.out.println("Taxa de frete = " + listaBairros.retornaFrete(codBairro));

				System.out.println("------------------------");

				while (pedidoFechado == false) {
					addOuFechar = addOuFechar();

					if (addOuFechar == 1) {
						System.out.println("---ADICIONAR PRODUTO � COMPRA---");
						consumivel = abaPedidos(gerenciadorPizzas, gerenciadorBebidas, pedidos);
						System.out.println("\nAINDA PARA ESTA COMPRA...");
					}

					if (addOuFechar == 2) {
						if (pedidos.size() == 0) {
							System.out.println("Venda cancelada! N�o h� pedidos");
							pedidoFechado = true;
						} else {
							total = retornaValorTotal(pedidos) + listaBairros.retornaFrete(codBairro);
							qtdProd = pedidos.size();
							System.out.println("Quantida de produtos na lista de pedidos: " + qtdProd);
							System.out.println("Total: " + total);
							System.out.println("Valor dado: ");
							valorDado = sc.nextDouble();
							troco = Utilidades.retornaTroco(valorDado, total);
							if (troco == -1) {
								System.out.println("ERRO! Valor dado � menor que o total");
							} else {
								System.out.println("Troco: " + troco);

								codVenda = gerenciadorVendasDelivery.criaCodigoValido();
								data = Utilidades.data();
								hora = Utilidades.hora();

								vendaDelivery = criaObjeto(pedidos, data, hora, codVenda, qtdProd, total, valorDado,
										troco, codBairro, rua, numero, pontoDeReferencia, contato, nomeCliente,
										codVeiculo, observacoes);
								gerenciadorVendasDelivery.adiciona(vendaDelivery);
								System.out.println("Venda realizada e cadastrada com sucesso!");
								System.out.println("Venda feita dia " + data + " �s " + hora);
								System.out.println("\n C�digo da venda: " + codVenda);

								pedidoFechado = true;
							}
						}
					}
				}
				if (vendaDelivery == null) {
					System.out.println("Erro, a venda n�o foi feita!");
				}
			}
		}

		return vendaDelivery;

	}

	/**
	 * M�todo que cria um objeto do tipo VendaDelivery
	 * 
	 * @param pedidos
	 * @param data
	 * @param hora
	 * @param codVenda
	 * @param qtdProd
	 * @param total
	 * @param valorDado
	 * @param troco
	 * @param codBairro
	 * @param rua
	 * @param numero
	 * @param pontoDeReferencia
	 * @param contato
	 * @param nomeCliente
	 * @param codVeiculo
	 * @param observacoes
	 * @return
	 */
	public VendaDelivery criaObjeto(List<Consumivel> pedidos, String data, String hora, long codVenda, int qtdProd,
			double total, double valorDado, double troco, int codBairro, String rua, int numero,
			String pontoDeReferencia, long contato, String nomeCliente, int codVeiculo, String observacoes) {

		VendaDelivery vendaDelivery = new VendaDelivery(pedidos, data, hora, codVenda, qtdProd, total, valorDado, troco,
				codBairro, rua, numero, pontoDeReferencia, contato, nomeCliente, codVeiculo, observacoes);
		return vendaDelivery;
	}

}
