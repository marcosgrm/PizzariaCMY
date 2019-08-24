package gerenciadores;
import java.util.ArrayList;
import java.util.List;

import classes.Pizza;

public class GerenciadorPizzas extends Gerenciador implements GerenciadorNomeados, InterfaceGerenciador {
	private List<Pizza> pizzas;

	/**
	 * Construtor vazio que j� inicia com alguns objetos cadastrados
	 */
	public GerenciadorPizzas() {
		pizzas = new ArrayList<Pizza>();
		Pizza pizza1 = new Pizza(1, "Calabresa", "MOLHO DE TOMATE, QUEIJO MU�ARELA, CALABRESA, OR�GANO E CEBOLA", 1,
				10);
		Pizza pizza2 = new Pizza(1, "Presunto", "MOLHO, QUEIJO MU�ARELA, PRESUNTO, AZEITONA, OREGANO", 2, 10);
		Pizza pizza3 = new Pizza(1, "Frango", "MOLHO, QUEIJO MU�ARELA, FRANGO, OREGANO", 3, 10);
		Pizza pizza4 = new Pizza(1, "Bacon", "MOLHO, MU�ARELA, BACON E OREGANO", 4, 15);
		Pizza pizza5 = new Pizza(1, "Portuguesa", "MOLHO, MU�ARELA, CALABRESA, MILHO, CEBOLA, AZEITONA, OVO E OREGANO",
				5, 10);
		Pizza pizza6 = new Pizza(1, "4 Queijos", "MOLHO, MU�ARELA, CHEDDAR, COALHO, CATUPIRY, OREGANO", 6, 15);
		Pizza pizza7 = new Pizza(1, "Vegetariana", "QUEIJO COALHO, PIMENT�O, TOMATE, AZEITONA, OREGANO, CEBOLA", 7, 15);
		Pizza pizza8 = new Pizza(1, "Mista", "MOLHO, QUEIJO MU�ARELA, CALABRESA RALADA, PRESUNTO RALADO E OR�GANO", 8,
				10);
		Pizza pizza9 = new Pizza(1, "Camarao", "MOLHO, QUEIJO MU�ARELA, CAMAR�O, CEBOLA, AZEITONA E OR�GANO", 9, 20);
		Pizza pizza10 = new Pizza(1, "Tradicional", "MOLHO, QUEIJO MU�ARELA, OR�GANO, TOMATE", 10, 10);
		Pizza pizza11 = new Pizza(1, "Cocorico", "MOLHO, QUEIJO MU�ARELA, MILHO, FRANGO, OVO, OR�GANO", 11, 10);
		Pizza pizza12 = new Pizza(1, "Bolonhesa", "MOLHO, QUEIJO MU�ARELA, CARNE MO�DA, AZEITONA E OREGANO", 12, 10);
		Pizza pizza13 = new Pizza(1, "Napolitana", "MOLHO, QUEIJO MU�ARELA, PRESUNTO, TOMATE E OR�GANO", 13, 10);
		Pizza pizza14 = new Pizza(1, "Mexicana", "MOLHO, QUEIJO MU�ARELA, CALABRESA RALADA, PIMENT�O OR�GANO, PIMENTA",
				14, 17);
		Pizza pizza15 = new Pizza(1, "Baiana",
				"MOLHO, QUEIJO MU�ARELA, CALABRESA RALADA, CAMAR�O, CEBOLA, OR�GANO, PIMENTA", 15, 17);
		Pizza pizza16 = new Pizza(2, "Romeu e Julieta", "QUEIJO MU�ARELA, GOIABADA E CREME DE LEITE", 16, 12);
		Pizza pizza17 = new Pizza(2, "Banana", "QUEIJO MU�ARELA, BANANA, LEITE CONDENSADO, A��CAR E CANELA", 17, 12);
		Pizza pizza18 = new Pizza(2, "Brigadeiro e Morango", "LEITE CONDENSADO, BRIGADEIRO E GEL�IA MORANGO", 18, 14);
		pizzas.add(pizza1);
		pizzas.add(pizza2);
		pizzas.add(pizza3);
		pizzas.add(pizza4);
		pizzas.add(pizza5);
		pizzas.add(pizza6);
		pizzas.add(pizza7);
		pizzas.add(pizza8);
		pizzas.add(pizza9);
		pizzas.add(pizza10);
		pizzas.add(pizza11);
		pizzas.add(pizza12);
		pizzas.add(pizza13);
		pizzas.add(pizza14);
		pizzas.add(pizza15);
		pizzas.add(pizza16);
		pizzas.add(pizza17);
		pizzas.add(pizza18);
	}

	/**
	 * M�todo que adiciona um objeto Pizza � lista de pizzas
	 * @param pizza
	 * @return
	 */
	public boolean adiciona(Pizza pizza) {
		if (existe(pizza.getCodSabor()) == true) {
			System.out.println("Pizza com este c�digo j� est� cadastrada!");
			return false;
		} else {
			pizzas.add(pizza);
			System.out.println("Pizza cadastrada com sucesso!");
			return true;
		}
	}

	/**
	 * M�todo que remove uma pizza da lista de pizza informando o seu c�digo (do sabor)
	 */
	@Override
	public boolean removePorCodigo(int codigo) {
		if (existe(codigo) == false) {
			System.out.println("Pizza n�o cadastrada!");
			return false;
		} else {
			pizzas.remove(retornaObjeto(codigo));
			System.out.println("Pizza removida com sucesso!");
			return true;
		}
	}

	/**
	 * M�todo que retorna um objeto Pizza informando o seu c�digo (do sabor)
	 * @param codigoSabor
	 * @return
	 */
	public Pizza retornaObjeto(int codigoSabor) {
		int aux = -1;
		for (int i = 0; i < pizzas.size(); i++) {
			if (pizzas.get(i).getCodSabor() == codigoSabor) {
				aux = i;
				break;
			}
		}
		if (aux != -1) {
			return pizzas.get(aux);
		} else {
			System.out.println("Pizza n�o cadastrada!");
			return null;
		}
	}

	/**
	 * M�todo que verifica se uma pizza j� est� cadastrada na lista de pizzas
	 */
	@Override
	public boolean existe(int codigo) {
		int aux = -1;
		for (int i = 0; i < pizzas.size(); i++) {
			if (pizzas.get(i).getCodSabor() == codigo) {
				aux = i;
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
	 * M�todo que pesquisa c�digo da pizza informando seu nome
	 */
	@Override
	public int pesquisaCodigoPorNome(String nome) {
		int aux = -1;
		for (int i = 0; i < pizzas.size(); i++) {
			if (pizzas.get(i).getNome().equalsIgnoreCase(nome)) {
				aux = i;
				break;
			}
		}

		if (aux == -1) {
			return aux;
		} else {
			return pizzas.get(aux).getCodigo();
		}
	}
	
	/**
	 * M�todo que pesquisa o nome da pizza informando o seu c�digo
	 * @param cod
	 * @return
	 */
	public String pesquisaNomePorCodigo(int cod) {
		int aux=0;
		
		if(existe(cod)==false) {
			return null;
		}else {
		for(int i=0; i<pizzas.size(); i++) {
			if(pizzas.get(i).getCodSabor()==cod){
				aux=i;
				break;
			}
		}
			return pizzas.get(aux).getNome();
		}
	}

	/**
	 * Dados os c�digos de sabores de 2 pizzas, o m�todo retorna o maior pre�o entre
	 * as duas
	 * 
	 * @param cod1
	 * @param cod2
	 * @return
	 */
	public double retornaMaiorValor(int cod1, int cod2) {
		double v1 = 0, v2 = 0;

		if (existe(cod1) == false && existe(cod2) == false) {
			return -2;
		} else {
			if (existe(cod1) == false || existe(cod2) == false) {
				return -1;
			} else {
				v1 = retornaObjeto(cod1).getPrecoBase();
				v2 = retornaObjeto(cod2).getPrecoBase();
				if (v1 > v2) {
					return v1;
				} else {
					return v2;
				}
			}
		}
	}

	/**
	 * Dados dois objetos do tipo Pizza, o m�todo retorna o maior pre�o entre as duas
	 * @param pizza1
	 * @param pizza2
	 * @return
	 */
	public Pizza retornaPizzaMaiorValor(Pizza pizza1, Pizza pizza2) {
		if (pizza1.getPrecoBase() > pizza2.getPrecoBase()) {
			return pizza1;
		} else {
			return pizza2;
		}
	}

	/**
	 * M�todo que mostra um menu com todas as pizzas, detalhes sobre seus sabores e pre�os em todos os tamanhos dispon�veis
	 */
	public void menu() {
		System.out.println("========MENU PIZZAS========");
		double valorM, valorG;
		String tipo;
		for (int i = 0; i < pizzas.size(); i++) {
			System.out.println(" > SABOR: " + pizzas.get(i).getNome() + " <");
			System.out.println("C�DIGO: " + pizzas.get(i).getCodSabor());
			System.out.println("DESCRICAO: " + pizzas.get(i).getDescricao());
			if (pizzas.get(i).getTipo() == 1) {
				tipo = "salgada";
			} else {
				tipo = "doce";
			}
			System.out.println("TIPO: " + pizzas.get(i).getTipo() + " (" + tipo + ")");
			System.out.println("P: " + pizzas.get(i).getPrecoBase());
			valorM = pizzas.get(i).getPrecoBase() + Pizza.pizzaM();
			System.out.println("M: " + valorM);
			valorG = pizzas.get(i).getPrecoBase() + Pizza.pizzaG();
			System.out.println("G: " + valorG);
			System.out.println("\n");
		}
	}

	/**
	 * M�todo que mostra um menu com todas as PIZZAS SALGADAS, detalhes sobre seus sabores e pre�os em todos os tamanhos dispon�veis
	 */
	public void menuPizzasSalgadas() {
		System.out.println("========MENU PIZZAS SALGADAS========");
		double valorM, valorG;
		for (int i = 0; i < pizzas.size(); i++) {
			if (pizzas.get(i).getTipo() == 1) {
				System.out.println("SABOR: " + pizzas.get(i).getNome());
				System.out.println("CODIGO: " + pizzas.get(i).getCodSabor());
				System.out.println("DESCRICAO: " + pizzas.get(i).getDescricao());
				System.out.println("P: " + pizzas.get(i).getPrecoBase());
				valorM = pizzas.get(i).getPrecoBase() + Pizza.pizzaM();
				System.out.println("M: " + valorM);
				valorG = pizzas.get(i).getPrecoBase() + Pizza.pizzaG();
				System.out.println("G: " + valorG);
				System.out.println("\n");
			}
		}
	}

	/**
	 * M�todo que mostra um menu com todas as PIZZAS DOCES, detalhes sobre seus sabores e pre�os em todos os tamanhos dispon�veis
	 */
	public void menuPizzasDoces() {
		System.out.println("========MENU PIZZAS DOCES========");
		double valorM, valorG;
		for (int i = 0; i < pizzas.size(); i++) {
			if (pizzas.get(i).getTipo() == 2) {
				System.out.println("SABOR: " + pizzas.get(i).getNome());
				System.out.println("CODIGO: " + pizzas.get(i).getCodSabor());
				System.out.println("DESCRICAO: " + pizzas.get(i).getDescricao());
				System.out.println("P: " + pizzas.get(i).getPrecoBase());
				valorM = pizzas.get(i).getPrecoBase() + Pizza.pizzaM();
				System.out.println("M: " + valorM);
				valorG = pizzas.get(i).getPrecoBase() + Pizza.pizzaG();
				System.out.println("G: " + valorG);
				System.out.println("\n");
			}
		}
	}

	/**
	 * M�todo que mostra um menu resumido (apenas com o nome do sabor e seu c�digo) com todas as pizzas
	 */
	public void menuResumido() {
		System.out.println("========MENU PIZZAS========");
		for (int i = 0; i < pizzas.size(); i++) {
			System.out.println(pizzas.get(i).getNome() + "--------------COD:" + pizzas.get(i).getCodSabor());
		}
	}
	
	/**
	 * M�todo de intera��o com o usu�rio: Aba de CRUD's
	 */
	@Override
	public void abaCrud() {
		int opCrudPizza;
		System.out.println("---CONSULTA/CADASTRO/REMO��O/ATUALIZA��O DE PIZZAS---");
		opCrudPizza = crud();
		switch (opCrudPizza) {
		case 1:
			abaConsulta();
			break;

		case 2:
			abaCadastro();
			break;

		case 3:
			abaRemocao();
			break;

		case 4:
			abaAtualizacao();
			break;

		default:
			System.out.println("ERRO, op��o n�o encontrada!");
			break;
		}
	}

	/**
	 * M�todo de intera��o com o usu�rio: Realiza consultas de pizzas e mostra menus
	 * 
	 * @param gerenciadorPizzas
	 */
	@Override
	public void abaConsulta() {
		int opConsultaPizza;
		String nomeSabor;
		int codSabor;

		System.out.println("------CONSULTA------");
		System.out.println("[1]: Saber o c�digo do sabor inserindo o nome do sabor");
		System.out.println("[2]: Saber o nome da pizza inserindo o c�digo do sabor");
		System.out.println("[3]: Menu de pizzas completo");
		System.out.println("[4]: Menu de pizzas salgadas completo");
		System.out.println("[5]: Menu de pizzas doces completo");
		System.out.println("[6]: Menu resumido");

		opConsultaPizza = sc.nextInt();
		switch (opConsultaPizza) {
		case 1:
			System.out.println("Digite o nome do sabor da pizza: ");
			nomeSabor = sc.nextLine();
			nomeSabor = sc.nextLine();
			if (pesquisaCodigoPorNome(nomeSabor) != -1) {
				System.out.println(pesquisaCodigoPorNome(nomeSabor));
			} else {
				System.out.println("Pizza n�o encontrada!");
			}
			break;

		case 2:
			System.out.println("Digite o c�digo do sabor pizza: ");
			codSabor = sc.nextInt();
			if (pesquisaNomePorCodigo(codSabor) == null) {
				System.out.println("C�digo n�o encontrado! Pizza n�o cadastrada!");
			} else {
				System.out.println("Nome da pizza de c�digo " + codSabor + ": "
						+ pesquisaNomePorCodigo(codSabor));
			}
			break;

		case 3:
			menu();
			break;

		case 4:
			menuPizzasSalgadas();
			break;

		case 5:
			menuPizzasDoces();
			break;

		case 6:
			menuResumido();
			break;

		default:
			System.out.println("ERRO, op��o n�o encontrada!");
			break;
		}
	}

	/**
	 * M�todo de inrera��o com o usu�rio: Realiza remo��o de pizzas da lista de pizzas cadastradas no sistema informando seu c�digo (do sabor)
	 */
	@Override
	public void abaRemocao() {
		int codigo;
		System.out.println("------REMO��O------");
		System.out.println("Digite o c�digo do sabor pizza: ");
		codigo = sc.nextInt();
		if (existe(codigo) == false) {
			System.out.println("C�digo n�o cadastrado!");
		} else {
			removePorCodigo(codigo);
		}
	}

	/**
	 * M�todo de intera��o com o usu�rio: Realiza cadastro de pizzas
	 */
	@Override
	public void abaCadastro() {
		System.out.println("------CADASTRO------");
		Pizza pizza;

		int tipo;
		String nomeSabor;
		String descricao;
		int codSabor;
		double precoBase;

		System.out.println("Insira o tipo da pizza	  [1]: Salgada    [2]: Doce: ");
		tipo = sc.nextInt();
		System.out.println("Insira o nome do sabor: ");
		nomeSabor = sc.nextLine();
		nomeSabor = sc.nextLine();
		System.out.println("Insira a descri��o do sabor: ");
		descricao = sc.nextLine();
		System.out.println("Insira o c�digo do sabor: ");
		codSabor = sc.nextInt();
		if (existe(codSabor) == true) {
			System.out.println("C�digo j� cadastrado!");
		} else {
			System.out.println("Insira o pre�o base da pizza (preco do tamanho P): ");
			precoBase = sc.nextInt();

			pizza = new Pizza(tipo, nomeSabor, descricao, codSabor, precoBase);
		adiciona(pizza);
		}
	}

	/**
	 * M�todo de intera��o com o usu�rio: Faz atualiza��o do c�digo da pizza
	 */
	@Override
	public void abaAtualizacao() {
		int codSabor;
		int novoCod;
		int escolha;

		System.out.println("------ATUALIZA��O------");
		System.out.println("Digite o c�digo do sabor pizza: ");
		codSabor = sc.nextInt();

		if (existe(codSabor) == false) {
			System.out.println("Pizza com este c�digo n�o est� cadastrada!");
		} else {
			System.out.println("Digite o novo c�digo: ");
			novoCod = sc.nextInt();
			if (existe(novoCod) == true) {
				System.out.println("Este c�digo j� est� sendo usado por outra pizza!");
			} else {
				System.out.println("Voc� tem certeza que deseja atualizar o c�digo desta pizza?");
				System.out.println("[1]: SIM");
				System.out.println("[2]: N�O, ABORTAR OPERA��O");
				escolha = sc.nextInt();

				if (escolha == 1) {
					retornaObjeto(codSabor).setCodSabor(novoCod);
					System.out.println("C�digo atualizado com sucesso!");
				}
			}
		}
	}

	@Override
	public String toString() {
		return "GerenciadorPizzas [pizzas=" + pizzas + "]";
	}
	
	
}
