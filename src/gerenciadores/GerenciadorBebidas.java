package gerenciadores;
import java.util.ArrayList;
import java.util.List;

import classes.Bebida;

public class GerenciadorBebidas extends Gerenciador implements GerenciadorNomeados, InterfaceGerenciador{
	private List<Bebida> bebidas;
	
	/**
	 * Construtor vazio que j� inicia com alguns objetos cadastrados 
	 */
	public GerenciadorBebidas() {
		bebidas=new ArrayList<Bebida>();
		Bebida b1 = new Bebida ("Coca-cola 500ml", 1, "500ml", 3);
		Bebida b2 = new Bebida ("Coca-cola 1L", 2, "1L", 5);
		Bebida b3 = new Bebida ("Coca-cola 2L", 3, "2L", 6);
		Bebida b4 = new Bebida ("Guaran� 500ml", 4, "500ml", 2);
		Bebida b5 = new Bebida ("Guaran� 1L", 5, "1L", 4);
		Bebida b6 = new Bebida ("Guaran� 2L", 6, "2L", 5);
		Bebida b7 = new Bebida ("Sprite 500ml", 7, "500ml", 2);
		Bebida b8 = new Bebida ("Sprite 1L", 8, "1L", 4);
		Bebida b9 = new Bebida ("Sprite 2L", 9, "2L", 5);
		Bebida b10 = new Bebida ("Sukita 600ml", 10, "600ml", 4);
		Bebida b11 = new Bebida ("Sukita 2L", 11, "2L", 5.50);
		Bebida b12 = new Bebida ("Suco copo", 12, "copo", 3);
		Bebida b13 = new Bebida ("Suco jarra", 13, "jarra", 5);
		Bebida b14 = new Bebida ("�gua mineral 500ml", 14, "2L", 2);
		Bebida b15 = new Bebida ("�gua mineral 1,5L", 15, "2L", 3);
		bebidas.add(b1);
		bebidas.add(b2);
		bebidas.add(b3);
		bebidas.add(b4);
		bebidas.add(b5);
		bebidas.add(b6);
		bebidas.add(b7);
		bebidas.add(b8);
		bebidas.add(b9);
		bebidas.add(b10);
		bebidas.add(b11);
		bebidas.add(b12);
		bebidas.add(b13);
		bebidas.add(b14);
		bebidas.add(b15);
	}
	
	/**
	 * Adiciona bebida � lista de bebidas enviando um objeto Bebida
	 * @param bebida
	 * @return
	 */
	public boolean adiciona(Bebida bebida) {
		if (existe(bebida.getCodigo()) == true) {
			System.out.println("Bebida com este c�digo j� est� cadastrada!");
			return false;
		} else {
			bebidas.add(bebida);
			System.out.println("Bebida cadastrada com sucesso!");
			return true;
		}	}

	/**
	 * Remove objeto Bebida da lista informando seu respectivo c�digo
	 * @param codigo
	 * @return
	 */
	@Override
	public boolean removePorCodigo(int codigo) {
		if (existe(codigo) == true) {
			int aux = -1;
			for (int i = 0; i < bebidas.size(); i++) {
				if (bebidas.get(i).getCodigo() == codigo) {
					aux = i;
					break;
				}
			}

			if (aux == -1) {
				return false;
			} else {
				bebidas.remove(aux);
				return true;
			}
		} else {
			return false;
		}
	}

	/**
	 * Verifica se objeto Bebida existe informando um c�digo de Bebida
	 * @param codigo
	 * @return
	 */
	@Override
	public boolean existe(int codigo) {
		int aux = -1;
		for (int i = 0; i < bebidas.size(); i++) {
			if (bebidas.get(i).getCodigo() == codigo) {
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
	 * Retorna c�digo de um objeto Bebida informando seu nome
	 * @param nome
	 * @return
	 */
	@Override
	public int pesquisaCodigoPorNome(String nome) {
		int aux = -1;
		for (int i = 0; i < bebidas.size(); i++) {
			if (bebidas.get(i).getNome().equalsIgnoreCase(nome)) {
				aux = i;
				break;
			}
		}

		if (aux == -1) {
			return aux;
		} else {
			return bebidas.get(aux).getCodigo();
		}
	}

	/**
	 * Retorna objeto Bebida informando um c�digo de Bebida
	 * @param codigo
	 * @return
	 */
	public Bebida retornaObjeto(int codigo) {
		int aux = -1;
		for (int i = 0; i < bebidas.size(); i++) {
			if (bebidas.get(i).getCodigo() == codigo) {
				aux = i;
			}
		}
		if (aux != -1) {
			return bebidas.get(aux);
		} else {
			return null;
		}
	}

	/**
	 * Mostra menu na tela com todas as bebidas cadastradas mostrando todas as suas
	 * informa��es
	 */
	public void menu() {
		System.out.println("========MENU BEBIDAS========");
		for (int i = 0; i < bebidas.size(); i++) {
			System.out.println(" > NOME: " + bebidas.get(i).getNome() + " <");
			System.out.println("C�DIGO: " + bebidas.get(i).getCodigo());
			System.out.println("PRE�O: " + bebidas.get(i).getPrecoBase());
			System.out.println("\n");
		}
	}

	/**
	 * Mostra menu resumido na tela com todas as bebidas cadastradas mostrando
	 * apenas nome e c�digo
	 */
	public void menuResumido() {
		System.out.println("========MENU BEBIDAS RESUMIDO========");
		for (int i = 0; i < bebidas.size(); i++) {
			System.out.println(bebidas.get(i).getNome() + "..........COD: " + bebidas.get(i).getCodigo());
		}
	}
	
	/**
	 * M�todo de intera��o com o usu�rio: CRUD's
	 */
	@Override
	public void abaCrud() {
		int opCrudBebida;

		System.out.println("---CONSULTA/CADASTRO/REMO��O/ATUALIZA��O DE BEBIDAS---");
		opCrudBebida = crud();
		switch (opCrudBebida) {
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
	 * M�todo de intera��o com o usu�rio: consulta de bebidas
	 */
	@Override
	public void abaConsulta() {
		int opConsultaBebidas;
		String nomeBebida;

		System.out.println("------CONSULTA------");
		System.out.println("[1]: Saber c�digo da bebida inserindo o seu nome");
		System.out.println("[2]: Menu de bebidas completo");
		System.out.println("[3]: Menu resumido");

		opConsultaBebidas = sc.nextInt();
		switch (opConsultaBebidas) {
		case 1:
			System.out.println("Digite o nome da bebida: ");
			nomeBebida = sc.nextLine();
			nomeBebida = sc.nextLine();
			if (pesquisaCodigoPorNome(nomeBebida) != -1) {
				System.out.println(
						"C�digo da Bebida " + nomeBebida + ": " + pesquisaCodigoPorNome(nomeBebida));
			} else {
				System.out.println("Bebida n�o encontrada!");
			}
			break;

		case 2:
			menu();
			break;

		case 3:
			menuResumido();
			break;

		default:
			System.out.println("ERRO, op��o n�o encontrada!");
			break;
		}
	}

	/**
	 * M�todo de intera��o com o usu�rio: cadastro de bebidas
	 */
	@Override
	public void abaCadastro() {
		System.out.println("------CADASTRO------");
		Bebida bebida;

		String nome;
		int codigo;
		String conteudo;
		double precoBase;

		System.out.println("Insira o nome da bebida: ");
		nome = sc.nextLine();
		nome = sc.nextLine();
		System.out.println("Insira o c�digo da bebida: ");
		codigo = sc.nextInt();
		if (existe(codigo) == true) {
			System.out.println("C�digo j� cadastrado!");
		} else {
			System.out.println("Insira o conte�do da bebida (ex: 500ml   1,5L    2L): ");
			conteudo = sc.nextLine();
			conteudo = sc.nextLine();
			System.out.println("Insira o preco da bebida: ");
			precoBase = sc.nextDouble();

			bebida = new Bebida(nome, codigo, conteudo, precoBase);
			adiciona(bebida);
		}
	}

	/**
	 * M�todo de intera��o com o usu�rio: remo��o de bebidas
	 */
	@Override
	public void abaRemocao() {
		int codigo;

		System.out.println("------REMO��O------");
		System.out.println("Digite o c�digo da bebida: ");
		codigo = sc.nextInt();
		if (existe(codigo) == false) {
			System.out.println("C�digo n�o cadastrado!");
		} else {
			removePorCodigo(codigo);
		}
	}

	/**
	 * M�todo de intera��o com usu�rio: atualiza��o do c�digo de bebidas
	 */
	@Override
	public void abaAtualizacao() {
		int cod;
		int novoCod;
		int escolha;

		System.out.println("------ATUALIZA��O------");
		System.out.println("Digite o c�digo da bebida: ");
		cod = sc.nextInt();

		if (existe(cod) == false) {
			System.out.println("Bebida com este c�digo n�o est� cadastrada!");
		} else {
			System.out.println("Digite o novo c�digo: ");
			novoCod = sc.nextInt();
			if (existe(novoCod) == true) {
				System.out.println("Este c�digo j� est� sendo usado por outra bebida!");
			} else {
				System.out.println("Voc� tem certeza que deseja atualizar o c�digo desta bebida?");
				System.out.println("[1]: SIM");
				System.out.println("[2]: N�O, ABORTAR OPERA��O");
				escolha = sc.nextInt();

				if (escolha == 1) {
					retornaObjeto(cod).setCodigo(novoCod);
					;
					System.out.println("C�digo atualizado com sucesso!");
				}
			}
		}
	}

	@Override
	public String toString() {
		return "GerenciadorBebidas [bebidas=" + bebidas + "]";
	}

	public List<Bebida> getBebidas() {
		return bebidas;
	}

	public void setBebidas(List<Bebida> bebidas) {
		this.bebidas = bebidas;
	}

	
}
