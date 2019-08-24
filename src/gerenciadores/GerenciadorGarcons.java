package gerenciadores;
import java.util.ArrayList;
import java.util.List;
import classes.Garcom;

public class GerenciadorGarcons extends Gerenciador implements GerenciadorNomeados, InterfaceGerenciador {
	private List<Garcom> garcons;
	
	/**
	 * Construtor vazio que j� inicia com alguns objetos cadastrados
	 */
	public GerenciadorGarcons() {
		garcons = new ArrayList<Garcom>();
		Garcom g1 = new Garcom("Jos� M�rio Lima Barros", "Gar�om", 1);
		Garcom g2 = new Garcom("Mariano da Silva Teixeira", "Gar�om", 2);
		Garcom g3 = new Garcom("Pedro Lima e Silva", "Gar�om", 3);
		Garcom g4 = new Garcom("Leandro Joaquim Pereira", "Gar�om", 4);
		Garcom g5 = new Garcom("Felipe Gon�alves Vieira", "Gar�om", 5);
		garcons.add(g1);
		garcons.add(g2);
		garcons.add(g3);
		garcons.add(g4);
		garcons.add(g5);
	}
	
	/**
	 * M�todo que verifica se j� existe gar�om com um determinado c�digo cadastrado na lista de gar�ons
	 */
	@Override
	public boolean existe(int codigo) {
		int aux = -1;
		for (int i = 0; i < garcons.size(); i++) {
			if (garcons.get(i).getCodigo() == codigo) {
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
	 * M�todo que pesquisa e retorna o nome de um gar�om informando seu c�digo
	 * @param cod
	 * @return
	 */
	public String pesquisaNomePorCodigo(int cod) {
		int aux = -1;
		for (int i = 0; i < garcons.size(); i++) {
			if (garcons.get(i).getCodigo()==cod) {
				aux = i;
				break;
			}
		}

		if (aux == -1) {
			return null;
		} else {
			return garcons.get(aux).getNome();
		}
	}
	
	/**
	 * M�todo que pesquisa e retorna o c�digo de um gar�om informando seu nome
	 */
	@Override
	public int pesquisaCodigoPorNome(String nome) {
		int aux = -1;
		for (int i = 0; i < garcons.size(); i++) {
			if (garcons.get(i).getNome().equalsIgnoreCase(nome)) {
				aux = i;
				break;
			}
		}

		if (aux == -1) {
			return aux;
		} else {
			return garcons.get(aux).getCodigo();
		}
	}

	/**
	 * M�todo que remove um gar�om da lista de gar�ons informando seu c�digo
	 */
	@Override
	public boolean removePorCodigo(int codigo) {
		if (existe(codigo) == false) {
			return false;
		} else {
			garcons.remove(retornaObjeto(codigo));
			return true;
		}
	}

	/**
	 * M�todo que retorna um objeto do tipo Gar�om informando um c�digo do gar�om
	 * @param codigo
	 * @return
	 */
	public Garcom retornaObjeto(int codigo) {
		int aux = -1;
		for (int i = 0; i < garcons.size(); i++) {
			if (garcons.get(i).getCodigo() == codigo) {
				aux = i;
			}
		}
		if (aux != -1) {
			return garcons.get(aux);
		} else {
			return null;
		}
	}
	
	/**
	 * M�todo que retorna a quantidade de mesas atendidas 
	 */
	public void mesasAtendidas() {
		for(int i=0; i<garcons.size(); i++) {
			System.out.println("~GAR�OM "+i +"~");
			System.out.println("Mesas atendidas:");
			garcons.get(i).getMesasAtendidas();
		}
	}
	
	/**
	 * M�todo que adiciona um objeto gar�om � lista de gar�ons
	 * @param garcom
	 * @return
	 */
	public boolean adiciona(Garcom garcom) {
		if (existe(garcom.getCodigo()) == true) {
			System.out.println("Gar�om com este c�digo j� existe!");
			return false;
		} else {
			garcons.add(garcom);
			System.out.println("Gar�om cadastrado com sucesso!");
			return true;
		}
	}

	/**
	 * Mostra lista completa de gar�om (todos os seus atributos)
	 */
	public void lista() {
		for(int i=0; i<garcons.size(); i++) {
			System.out.println(garcons.get(i).toString());
		}
	}
	
	/**
	 * Mostra lista resumida de gar�ons: informa nome e c�digo
	 */
	public void listaResumida() {
		for(int i=0; i<garcons.size(); i++) {
			System.out.println("Nome: " +garcons.get(i).getNome());
			System.out.println("C�digo: " +garcons.get(i).getCodigo());
			System.out.println("\n");

		}
	}
		
	/**
	 * M�todo de intera��o com o usu�rio: CRUD de gar�om
	 */
	@Override
	public void abaCrud() {
		int opCrudFuncionario;
		System.out.println("---CONSULTA/CADASTRO/REMO��O/ATUALIZA��O DE GAR�ONS---");

		opCrudFuncionario = crud();
		switch (opCrudFuncionario) {
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
	 * M�todo de intera��o com o usu�rio: Faz consulta de gar�om
	 */
	@Override
	public void abaConsulta() {
		int opConsultaGarcons;
		String nomeGarcom;
		int codGarcom;

		System.out.println("------CONSULTA------");
		System.out.println("[1]: Saber c�digo de um gar�om inserindo o seu nome");
		System.out.println("[2]: Saber nome de um gar�om inserindo o seu c�digo");
		System.out.println("[3]: Lista completa de gar�ons ");
		System.out.println("[4]: Lista resumida de gar�ons");

		opConsultaGarcons = sc.nextInt();
		switch (opConsultaGarcons) {
		case 1:
			System.out.println("Digite o nome completo do gar�om: ");
			nomeGarcom = sc.nextLine();
			nomeGarcom = sc.nextLine();
			if (pesquisaCodigoPorNome(nomeGarcom) != -1) {
				System.out.println(
						"C�digo do gar�om " + nomeGarcom + ": " + pesquisaCodigoPorNome(nomeGarcom));
			} else {
				System.out.println("Gar�om n�o encontrado!");
			}
			break;

		case 2:
			System.out.println("Digite o c�digo do gar�om: ");
			codGarcom = sc.nextInt();
			if (pesquisaNomePorCodigo(codGarcom) != null) {
				System.out.println("Nome do gar�om de c�digo " + codGarcom + ": "
						+ pesquisaNomePorCodigo(codGarcom));
			} else {
				System.out.println("Entregador n�o encontrado!");
			}
			break;

		case 3:
			lista();
			break;

		case 4:
			listaResumida();
			break;

		default:
			System.out.println("ERRO, op��o n�o encontrada!");
			break;
		}
	}

	/**
	 * M�todo de intera��o com o usu�rio: Faz cadastro de gar�om
	 */
	@Override
	public void abaCadastro() {
		System.out.println("------CADASTRO DE GAR�ONS------");
		Garcom garcom;

		String nome;
		int codigo;

		System.out.println("Insira o nome do gar�om:");
		nome = sc.nextLine();
		nome = sc.nextLine();
		System.out.println("Insira o c�digo deste gar�om: ");
		codigo = sc.nextInt();
		if (existe(codigo) == true) {
			System.out.println("Garcom com este c�digo j� est� cadastrado!");
		} else {

			garcom = new Garcom(nome, "Gar�om", codigo);
			adiciona(garcom);
		}

	}

	/**
	 * M�todo de intera��o com o usu�rio: Faz remo��o de gar�om a partir do seu c�digo
	 */
	@Override
	public void abaRemocao() {
		int codigo;

		System.out.println("------REMO��O------");
		System.out.println("Digite o c�digo do gar�om: ");
		codigo = sc.nextInt();
		if (existe(codigo) == false) {
			System.out.println("C�digo n�o cadastrado!");
		} else {
			removePorCodigo(codigo);
		}
	}

	/**
	 * M�todo de intera��o com o usu�rio: Faz atualiza��o do c�digo do gar�om
	 */
	@Override
	public void abaAtualizacao() {
		int cod;
		int novoCod;
		int escolha;

		System.out.println("------ATUALIZA��O------");
		System.out.println("Digite o c�digo do gar�om: ");
		cod = sc.nextInt();

		if (existe(cod) == false) {
			System.out.println("Gar�om com este c�digo n�o est� cadastrado!");
		} else {
			System.out.println("Digite o novo c�digo: ");
			novoCod = sc.nextInt();
			if (existe(novoCod) == true) {
				System.out.println("Este c�digo j� est� sendo usado por outro gar�om");
			} else {
				System.out.println("Voc� tem certeza que deseja atualizar o c�digo deste gar�om?");
				System.out.println("[1]: SIM");
				System.out.println("[2]: N�O, ABORTAR OPERA��O");
				escolha = sc.nextInt();

				if (escolha == 1) {
					retornaObjeto(cod).setCodigo(novoCod);
					System.out.println("C�digo atualizado com sucesso!");
				}
			}
		}
	}

	@Override
	public String toString() {
		return "GerenciadorGarcons [garcons=" + garcons + "]";
	}

	
	public List<Garcom> getGarcons() {
		return garcons;
	}

	public void setGarcons(List<Garcom> garcons) {
		this.garcons = garcons;
	}
	
	
}
