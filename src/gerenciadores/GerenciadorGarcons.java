package gerenciadores;
import java.util.ArrayList;
import java.util.List;
import classes.Garcom;

public class GerenciadorGarcons extends Gerenciador implements GerenciadorNomeados, InterfaceGerenciador {
	private List<Garcom> garcons;
	
	/**
	 * Construtor vazio que já inicia com alguns objetos cadastrados
	 */
	public GerenciadorGarcons() {
		garcons = new ArrayList<Garcom>();
		Garcom g1 = new Garcom("José Mário Lima Barros", "Garçom", 1);
		Garcom g2 = new Garcom("Mariano da Silva Teixeira", "Garçom", 2);
		Garcom g3 = new Garcom("Pedro Lima e Silva", "Garçom", 3);
		Garcom g4 = new Garcom("Leandro Joaquim Pereira", "Garçom", 4);
		Garcom g5 = new Garcom("Felipe Gonçalves Vieira", "Garçom", 5);
		garcons.add(g1);
		garcons.add(g2);
		garcons.add(g3);
		garcons.add(g4);
		garcons.add(g5);
	}
	
	/**
	 * Método que verifica se já existe garçom com um determinado código cadastrado na lista de garçons
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
	 * Método que pesquisa e retorna o nome de um garçom informando seu código
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
	 * Método que pesquisa e retorna o código de um garçom informando seu nome
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
	 * Método que remove um garçom da lista de garçons informando seu código
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
	 * Método que retorna um objeto do tipo Garçom informando um código do garçom
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
	 * Método que retorna a quantidade de mesas atendidas 
	 */
	public void mesasAtendidas() {
		for(int i=0; i<garcons.size(); i++) {
			System.out.println("~GARÇOM "+i +"~");
			System.out.println("Mesas atendidas:");
			garcons.get(i).getMesasAtendidas();
		}
	}
	
	/**
	 * Método que adiciona um objeto garçom à lista de garçons
	 * @param garcom
	 * @return
	 */
	public boolean adiciona(Garcom garcom) {
		if (existe(garcom.getCodigo()) == true) {
			System.out.println("Garçom com este código já existe!");
			return false;
		} else {
			garcons.add(garcom);
			System.out.println("Garçom cadastrado com sucesso!");
			return true;
		}
	}

	/**
	 * Mostra lista completa de garçom (todos os seus atributos)
	 */
	public void lista() {
		for(int i=0; i<garcons.size(); i++) {
			System.out.println(garcons.get(i).toString());
		}
	}
	
	/**
	 * Mostra lista resumida de garçons: informa nome e código
	 */
	public void listaResumida() {
		for(int i=0; i<garcons.size(); i++) {
			System.out.println("Nome: " +garcons.get(i).getNome());
			System.out.println("Código: " +garcons.get(i).getCodigo());
			System.out.println("\n");

		}
	}
		
	/**
	 * Método de interação com o usuário: CRUD de garçom
	 */
	@Override
	public void abaCrud() {
		int opCrudFuncionario;
		System.out.println("---CONSULTA/CADASTRO/REMOÇÃO/ATUALIZAÇÃO DE GARÇONS---");

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
			System.out.println("ERRO, opção não encontrada!");
			break;
		}
	}
	
	/**
	 * Método de interação com o usuário: Faz consulta de garçom
	 */
	@Override
	public void abaConsulta() {
		int opConsultaGarcons;
		String nomeGarcom;
		int codGarcom;

		System.out.println("------CONSULTA------");
		System.out.println("[1]: Saber código de um garçom inserindo o seu nome");
		System.out.println("[2]: Saber nome de um garçom inserindo o seu código");
		System.out.println("[3]: Lista completa de garçons ");
		System.out.println("[4]: Lista resumida de garçons");

		opConsultaGarcons = sc.nextInt();
		switch (opConsultaGarcons) {
		case 1:
			System.out.println("Digite o nome completo do garçom: ");
			nomeGarcom = sc.nextLine();
			nomeGarcom = sc.nextLine();
			if (pesquisaCodigoPorNome(nomeGarcom) != -1) {
				System.out.println(
						"Código do garçom " + nomeGarcom + ": " + pesquisaCodigoPorNome(nomeGarcom));
			} else {
				System.out.println("Garçom não encontrado!");
			}
			break;

		case 2:
			System.out.println("Digite o código do garçom: ");
			codGarcom = sc.nextInt();
			if (pesquisaNomePorCodigo(codGarcom) != null) {
				System.out.println("Nome do garçom de código " + codGarcom + ": "
						+ pesquisaNomePorCodigo(codGarcom));
			} else {
				System.out.println("Entregador não encontrado!");
			}
			break;

		case 3:
			lista();
			break;

		case 4:
			listaResumida();
			break;

		default:
			System.out.println("ERRO, opção não encontrada!");
			break;
		}
	}

	/**
	 * Método de interação com o usuário: Faz cadastro de garçom
	 */
	@Override
	public void abaCadastro() {
		System.out.println("------CADASTRO DE GARÇONS------");
		Garcom garcom;

		String nome;
		int codigo;

		System.out.println("Insira o nome do garçom:");
		nome = sc.nextLine();
		nome = sc.nextLine();
		System.out.println("Insira o código deste garçom: ");
		codigo = sc.nextInt();
		if (existe(codigo) == true) {
			System.out.println("Garcom com este código já está cadastrado!");
		} else {

			garcom = new Garcom(nome, "Garçom", codigo);
			adiciona(garcom);
		}

	}

	/**
	 * Método de interação com o usuário: Faz remoção de garçom a partir do seu código
	 */
	@Override
	public void abaRemocao() {
		int codigo;

		System.out.println("------REMOÇÃO------");
		System.out.println("Digite o código do garçom: ");
		codigo = sc.nextInt();
		if (existe(codigo) == false) {
			System.out.println("Código não cadastrado!");
		} else {
			removePorCodigo(codigo);
		}
	}

	/**
	 * Método de interação com o usuário: Faz atualização do código do garçom
	 */
	@Override
	public void abaAtualizacao() {
		int cod;
		int novoCod;
		int escolha;

		System.out.println("------ATUALIZAÇÃO------");
		System.out.println("Digite o código do garçom: ");
		cod = sc.nextInt();

		if (existe(cod) == false) {
			System.out.println("Garçom com este código não está cadastrado!");
		} else {
			System.out.println("Digite o novo código: ");
			novoCod = sc.nextInt();
			if (existe(novoCod) == true) {
				System.out.println("Este código já está sendo usado por outro garçom");
			} else {
				System.out.println("Você tem certeza que deseja atualizar o código deste garçom?");
				System.out.println("[1]: SIM");
				System.out.println("[2]: NÃO, ABORTAR OPERAÇÃO");
				escolha = sc.nextInt();

				if (escolha == 1) {
					retornaObjeto(cod).setCodigo(novoCod);
					System.out.println("Código atualizado com sucesso!");
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
