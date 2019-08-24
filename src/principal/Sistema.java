package principal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import classes.Consumivel;
import gerenciadores.*;
import utilitarios.Relatorios;
import venda.*;

public class Sistema {

	private boolean sistemaFechado;

	Scanner sc = new Scanner(System.in);

	Relatorios relatorios = new Relatorios();
	
	/**
	 * Construtor que inicia com o sistema aberto
	 */
	public Sistema() {
		this.sistemaFechado = false;
	}

	/**
	 * M�todo que mostra o cabe�alho do sistema
	 */
	public void cabe�alho() {
		Date dataHoraAtual = new Date();
		String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
		String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);

		System.out.println("\n==================PIZZARIA CMY==================\n");
		System.out.println("> SEJA BEM-VINDO � PIZZARIA CMY!! <");
		System.out.println("> DATA DE HOJE:  " + data);
		System.out.println("> HORA ATUAL:  " + hora);
	}

	/**
	 * M�todo que mostra o menu principal do sistema
	 * 
	 * @return
	 */
	public int abaMenuPrincipal() {
		System.out.println("\n   ------->  MENU PRINCIPAL  <-------   ");
		System.out.println("[1]: VENDA");
		System.out.println("[2]: MOSTRAR PEDIDOS DE UMA COMPRA VIA C�DIGO DE COMPRA");
		System.out.println("[3]: CONSULTAS, CADASTROS, REMO��ES E ATUALIZA��ES");
		System.out.println("[4]: OCUPAR MESA");
		System.out.println("[5]: DESOCUPAR MESA");
		System.out.println("[6]: RELAT�RIOS");
		System.out.println("[7]: HIST�RICO DE VENDAS");
		System.out.println("[8]: LIMPAR CONSOLE");
		System.out.println("[9]: FECHAR SISTEMA");

		System.out.println("\nOBS: P/ UMA VENDA SER FEITA EM UMA MESA, ELA DEVE ESTAR OCUPADA."
				+ "\nOCUPE UMA MESA APERTANDO A OP��O [4] DESTE MENU.");

		int opMenuPrincipal = sc.nextInt();
		return opMenuPrincipal;
	}

	/**
	 * M�todo que mostra menu dos objetos que podem sofrer CRUD's (consultas,
	 * cadastros, remo��es e atualiza��es)
	 * 
	 * @return
	 */
	public int abaCruds() {
		System.out.println("======CONSULTAS, CADASTROS, REMO��ES E ATUALIZA��ES======");
		System.out.println("[1]: DE PIZZAS");
		System.out.println("[2]: DE BEBIDAS");
		System.out.println("[3]: DE ENTREGADORES");
		System.out.println("[4]: DE GAR�ONS");
		System.out.println("[5]: DE MESAS");
		System.out.println("[6]: DE BAIRROS");
		int cruds = sc.nextInt();
		return cruds;
	}

	/**
	 * M�todo que mostra as duas op��es de venda (mesa ou delivery)
	 * 
	 * @return
	 */
	public int abaVenda() {
		System.out.println("======ABA DE VENDA======");
		System.out.println("Insira o tipo de venda");
		System.out.println("[1]: VENDA PARA ENTREGA RESIDENCIAL (DELIVERY)");
		System.out.println("[2]: VENDA MESA");
		int opVenda = sc.nextInt();
		return opVenda;
	}

	/**
	 * M�todo que mostra op��es de relat�rios
	 * @return
	 */
	public int abaRelatorios() {
		int op;
		System.out.println("----RELAT�RIOS----");
		System.out.println("[1]: FATURAMENTO AT� AGORA");
		System.out.println("[2]: TOTAL DE COMISS�O DE GAR�OM");
		op = sc.nextInt();
		return op;
	}

	/**
	 * M�todo que mostra os pedidos de uma venda inserindo o c�digo de venda/compra
	 * @param gerenciadorVendasDelivery
	 * @param gerenciadorVendasMesa
	 * @return
	 */
	public List<Consumivel> abaMostrarPedidosCod(GerenciadorVendasDelivery gerenciadorVendasDelivery, GerenciadorVendasMesa gerenciadorVendasMesa) {
		int op;
		List<Consumivel> pedidos=null;
		System.out.println("Selecione o tipo de venda");
		System.out.println("[1]: DELIVERY");
		System.out.println("[2]: MESA");
		op = sc.nextInt();
		switch (op) {
		case 1:
			pedidos=gerenciadorVendasDelivery.abaMostraPedidosCompra();
			break;

		case 2:
			pedidos=gerenciadorVendasMesa.abaMostraPedidosCompra();
			break;

		default:
			System.out.println("Op��o n�o encontrada.");
			break;
		}
		return pedidos;
	}
	
	/**
	 * Classe principal do sistema de vendas. Respons�vel pela intera��o do usu�rio com o sistema de vendas.
	 * @param gerenciadorPizzas
	 * @param gerenciadorBebidas
	 * @param gerenciadorEntregadores
	 * @param gerenciadorGarcons
	 * @param gerenciadorMesas
	 * @param gerenciadorVendasDelivery
	 * @param gerenciadorBairros
	 * @param gerenciadorVendasMesa
	 * @param vendaDelivery
	 * @param vendaMesa
	 */
	public void inicializa(GerenciadorPizzas gerenciadorPizzas, GerenciadorBebidas gerenciadorBebidas,
			GerenciadorEntregadores gerenciadorEntregadores, GerenciadorGarcons gerenciadorGarcons,
			GerenciadorMesas gerenciadorMesas, GerenciadorVendasDelivery gerenciadorVendasDelivery,
			GerenciadorBairros gerenciadorBairros, GerenciadorVendasMesa gerenciadorVendasMesa,
			VendaDelivery vendaDelivery, VendaMesa vendaMesa) {
		int opMenuPrincipal;
		int opVenda;
		int opCruds;
		int opRelatorios;
		
		while (this.sistemaFechado == false) {
			cabe�alho();
			opMenuPrincipal = abaMenuPrincipal();

			switch (opMenuPrincipal) {

			case 1:
				opVenda = abaVenda();
				switch (opVenda) {

				case 1:
					vendaDelivery.abaVendaDelivery(gerenciadorBairros, gerenciadorEntregadores, gerenciadorPizzas,
							gerenciadorBebidas, gerenciadorVendasDelivery);
					break;

				case 2:
					vendaMesa.abaVendaMesa(gerenciadorGarcons, gerenciadorPizzas, gerenciadorBebidas,
							gerenciadorVendasMesa, gerenciadorMesas);
					break;
				}
				break;

			case 2:
				System.out.println(abaMostrarPedidosCod(gerenciadorVendasDelivery, gerenciadorVendasMesa));
				break;

			case 3:
				opCruds = abaCruds();
				switch (opCruds) {
				case 1:
					gerenciadorPizzas.abaCrud();
					break;

				case 2:
					gerenciadorBebidas.abaCrud();
					break;

				case 3:
					gerenciadorEntregadores.abaCrud();
					break;

				case 4:
					gerenciadorGarcons.abaCrud();
					break;

				case 5:
					gerenciadorMesas.abaCrud();
					break;
					
				case 6:
					gerenciadorBairros.abaCrud();
				}
				break;

			case 4:
				gerenciadorMesas.mostraDisponibilidade();
				System.out.println("----OCUPAR MESA----");
				gerenciadorMesas.ocuparMesa();
				break;

			case 5:
				System.out.println("----DESOCUPAR MESA----");
				gerenciadorMesas.abaDesocuparMesa();
				break;

			case 6:
				opRelatorios=abaRelatorios();
				switch(opRelatorios) {
				case 1:
					System.out.println("Faturamento atual");
					System.out.println("\n R$: " +relatorios.faturamento(gerenciadorVendasDelivery, gerenciadorVendasMesa));
					break;
					
				case 2:
					System.out.println("Comiss�o de atual de gar�om");
					System.out.println("\n R$: "+relatorios.totalComissaoGarcom(gerenciadorGarcons));
					break;
					
					default:
						System.out.println("Erro, op��o n�o encontrada!");
						break;
				}
				break;

			case 7:
				relatorios.historico(gerenciadorVendasDelivery, gerenciadorVendasMesa);
				break;

			case 8:
				System.out.println("Limpando console...");
				for (int i = 0; i < 20; i++) {
					System.out.println("\n");
				}
				System.out.println("Console limpo!");
				break;

			case 9:
				System.out.println("----RELAT�RIO DO CAIXA----");
				System.out.println("Faturamento: R$" + relatorios.faturamento(gerenciadorVendasDelivery, gerenciadorVendasMesa));
				relatorios.totalProdutosVendidos(gerenciadorVendasDelivery, gerenciadorVendasMesa);
				System.out.println("--------------------------");
				System.out.println("Fechando sistema...");
				this.sistemaFechado = true;
				System.out.println("Sistema fechado!");
				break;

			default:
				System.out.println("Op��o n�o encontrada! Tente novamente!");
				break;
			}
		}
	}

	public boolean isSistemaFechado() {
		return sistemaFechado;
	}

	public void setSistemaFechado(boolean sistemaFechado) {
		this.sistemaFechado = sistemaFechado;
	}

	@Override
	public String toString() {
		return "Sistema [sistemaFechado=" + sistemaFechado + "]";
	}
	
	
}
