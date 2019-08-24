package gerenciadores;
import java.util.ArrayList;
import java.util.List;

import classes.Pizza;

public class GerenciadorPizzas extends Gerenciador implements GerenciadorNomeados, InterfaceGerenciador {
	private List<Pizza> pizzas;

	/**
	 * Construtor vazio que já inicia com alguns objetos cadastrados
	 */
	public GerenciadorPizzas() {
		pizzas = new ArrayList<Pizza>();
		Pizza pizza1 = new Pizza(1, "Calabresa", "MOLHO DE TOMATE, QUEIJO MUÇARELA, CALABRESA, ORÉGANO E CEBOLA", 1,
				10);
		Pizza pizza2 = new Pizza(1, "Presunto", "MOLHO, QUEIJO MUÇARELA, PRESUNTO, AZEITONA, OREGANO", 2, 10);
		Pizza pizza3 = new Pizza(1, "Frango", "MOLHO, QUEIJO MUÇARELA, FRANGO, OREGANO", 3, 10);
		Pizza pizza4 = new Pizza(1, "Bacon", "MOLHO, MUÇARELA, BACON E OREGANO", 4, 15);
		Pizza pizza5 = new Pizza(1, "Portuguesa", "MOLHO, MUÇARELA, CALABRESA, MILHO, CEBOLA, AZEITONA, OVO E OREGANO",
				5, 10);
		Pizza pizza6 = new Pizza(1, "4 Queijos", "MOLHO, MUÇARELA, CHEDDAR, COALHO, CATUPIRY, OREGANO", 6, 15);
		Pizza pizza7 = new Pizza(1, "Vegetariana", "QUEIJO COALHO, PIMENTÃO, TOMATE, AZEITONA, OREGANO, CEBOLA", 7, 15);
		Pizza pizza8 = new Pizza(1, "Mista", "MOLHO, QUEIJO MUÇARELA, CALABRESA RALADA, PRESUNTO RALADO E ORÉGANO", 8,
				10);
		Pizza pizza9 = new Pizza(1, "Camarao", "MOLHO, QUEIJO MUÇARELA, CAMARÃO, CEBOLA, AZEITONA E ORÉGANO", 9, 20);
		Pizza pizza10 = new Pizza(1, "Tradicional", "MOLHO, QUEIJO MUÇARELA, ORÉGANO, TOMATE", 10, 10);
		Pizza pizza11 = new Pizza(1, "Cocorico", "MOLHO, QUEIJO MUÇARELA, MILHO, FRANGO, OVO, ORÉGANO", 11, 10);
		Pizza pizza12 = new Pizza(1, "Bolonhesa", "MOLHO, QUEIJO MUÇARELA, CARNE MOÍDA, AZEITONA E OREGANO", 12, 10);
		Pizza pizza13 = new Pizza(1, "Napolitana", "MOLHO, QUEIJO MUÇARELA, PRESUNTO, TOMATE E ORÉGANO", 13, 10);
		Pizza pizza14 = new Pizza(1, "Mexicana", "MOLHO, QUEIJO MUÇARELA, CALABRESA RALADA, PIMENTÃO ORÉGANO, PIMENTA",
				14, 17);
		Pizza pizza15 = new Pizza(1, "Baiana",
				"MOLHO, QUEIJO MUÇARELA, CALABRESA RALADA, CAMARÃO, CEBOLA, ORÉGANO, PIMENTA", 15, 17);
		Pizza pizza16 = new Pizza(2, "Romeu e Julieta", "QUEIJO MUÇARELA, GOIABADA E CREME DE LEITE", 16, 12);
		Pizza pizza17 = new Pizza(2, "Banana", "QUEIJO MUÇARELA, BANANA, LEITE CONDENSADO, AÇÚCAR E CANELA", 17, 12);
		Pizza pizza18 = new Pizza(2, "Brigadeiro e Morango", "LEITE CONDENSADO, BRIGADEIRO E GELÉIA MORANGO", 18, 14);
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
	 * Método que adiciona um objeto Pizza à lista de pizzas
	 * @param pizza
	 * @return
	 */
	public boolean adiciona(Pizza pizza) {
		if (existe(pizza.getCodSabor()) == true) {
			System.out.println("Pizza com este código já está cadastrada!");
			return false;
		} else {
			pizzas.add(pizza);
			System.out.println("Pizza cadastrada com sucesso!");
			return true;
		}
	}

	/**
	 * Método que remove uma pizza da lista de pizza informando o seu código (do sabor)
	 */
	@Override
	public boolean removePorCodigo(int codigo) {
		if (existe(codigo) == false) {
			System.out.println("Pizza não cadastrada!");
			return false;
		} else {
			pizzas.remove(retornaObjeto(codigo));
			System.out.println("Pizza removida com sucesso!");
			return true;
		}
	}

	/**
	 * Método que retorna um objeto Pizza informando o seu código (do sabor)
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
			System.out.println("Pizza não cadastrada!");
			return null;
		}
	}

	/**
	 * Método que verifica se uma pizza já está cadastrada na lista de pizzas
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
	 * Método que pesquisa código da pizza informando seu nome
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
	 * Método que pesquisa o nome da pizza informando o seu código
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
	 * Dados os códigos de sabores de 2 pizzas, o método retorna o maior preço entre
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
	 * Dados dois objetos do tipo Pizza, o método retorna o maior preço entre as duas
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
	 * Método que mostra um menu com todas as pizzas, detalhes sobre seus sabores e preços em todos os tamanhos disponíveis
	 */
	public void menu() {
		System.out.println("========MENU PIZZAS========");
		double valorM, valorG;
		String tipo;
		for (int i = 0; i < pizzas.size(); i++) {
			System.out.println(" > SABOR: " + pizzas.get(i).getNome() + " <");
			System.out.println("CÓDIGO: " + pizzas.get(i).getCodSabor());
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
	 * Método que mostra um menu com todas as PIZZAS SALGADAS, detalhes sobre seus sabores e preços em todos os tamanhos disponíveis
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
	 * Método que mostra um menu com todas as PIZZAS DOCES, detalhes sobre seus sabores e preços em todos os tamanhos disponíveis
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
	 * Método que mostra um menu resumido (apenas com o nome do sabor e seu código) com todas as pizzas
	 */
	public void menuResumido() {
		System.out.println("========MENU PIZZAS========");
		for (int i = 0; i < pizzas.size(); i++) {
			System.out.println(pizzas.get(i).getNome() + "--------------COD:" + pizzas.get(i).getCodSabor());
		}
	}
	
	/**
	 * Método de interação com o usuário: Aba de CRUD's
	 */
	@Override
	public void abaCrud() {
		int opCrudPizza;
		System.out.println("---CONSULTA/CADASTRO/REMOÇÃO/ATUALIZAÇÃO DE PIZZAS---");
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
			System.out.println("ERRO, opção não encontrada!");
			break;
		}
	}

	/**
	 * Método de interação com o usuário: Realiza consultas de pizzas e mostra menus
	 * 
	 * @param gerenciadorPizzas
	 */
	@Override
	public void abaConsulta() {
		int opConsultaPizza;
		String nomeSabor;
		int codSabor;

		System.out.println("------CONSULTA------");
		System.out.println("[1]: Saber o código do sabor inserindo o nome do sabor");
		System.out.println("[2]: Saber o nome da pizza inserindo o código do sabor");
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
				System.out.println("Pizza não encontrada!");
			}
			break;

		case 2:
			System.out.println("Digite o código do sabor pizza: ");
			codSabor = sc.nextInt();
			if (pesquisaNomePorCodigo(codSabor) == null) {
				System.out.println("Código não encontrado! Pizza não cadastrada!");
			} else {
				System.out.println("Nome da pizza de código " + codSabor + ": "
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
			System.out.println("ERRO, opção não encontrada!");
			break;
		}
	}

	/**
	 * Método de inreração com o usuário: Realiza remoção de pizzas da lista de pizzas cadastradas no sistema informando seu código (do sabor)
	 */
	@Override
	public void abaRemocao() {
		int codigo;
		System.out.println("------REMOÇÃO------");
		System.out.println("Digite o código do sabor pizza: ");
		codigo = sc.nextInt();
		if (existe(codigo) == false) {
			System.out.println("Código não cadastrado!");
		} else {
			removePorCodigo(codigo);
		}
	}

	/**
	 * Método de interação com o usuário: Realiza cadastro de pizzas
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
		System.out.println("Insira a descrição do sabor: ");
		descricao = sc.nextLine();
		System.out.println("Insira o código do sabor: ");
		codSabor = sc.nextInt();
		if (existe(codSabor) == true) {
			System.out.println("Código já cadastrado!");
		} else {
			System.out.println("Insira o preço base da pizza (preco do tamanho P): ");
			precoBase = sc.nextInt();

			pizza = new Pizza(tipo, nomeSabor, descricao, codSabor, precoBase);
		adiciona(pizza);
		}
	}

	/**
	 * Método de interação com o usuário: Faz atualização do código da pizza
	 */
	@Override
	public void abaAtualizacao() {
		int codSabor;
		int novoCod;
		int escolha;

		System.out.println("------ATUALIZAÇÃO------");
		System.out.println("Digite o código do sabor pizza: ");
		codSabor = sc.nextInt();

		if (existe(codSabor) == false) {
			System.out.println("Pizza com este código não está cadastrada!");
		} else {
			System.out.println("Digite o novo código: ");
			novoCod = sc.nextInt();
			if (existe(novoCod) == true) {
				System.out.println("Este código já está sendo usado por outra pizza!");
			} else {
				System.out.println("Você tem certeza que deseja atualizar o código desta pizza?");
				System.out.println("[1]: SIM");
				System.out.println("[2]: NÃO, ABORTAR OPERAÇÃO");
				escolha = sc.nextInt();

				if (escolha == 1) {
					retornaObjeto(codSabor).setCodSabor(novoCod);
					System.out.println("Código atualizado com sucesso!");
				}
			}
		}
	}

	@Override
	public String toString() {
		return "GerenciadorPizzas [pizzas=" + pizzas + "]";
	}
	
	
}
