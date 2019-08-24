package gerenciadores;
import java.util.ArrayList;
import java.util.List;
import classes.Entregador;

public class GerenciadorEntregadores extends Gerenciador implements GerenciadorNomeados, InterfaceGerenciador{
	private List<Entregador> entregadores;

	
	/**
	 * Construtor que j� inicia com alguns entregadores cadastrados
	 */
	public GerenciadorEntregadores() {
		entregadores = new ArrayList<Entregador>();
		Entregador e1 = new Entregador("Maria da Gra�a dos Santos", "Entregador", 6, 1234);
		Entregador e2 = new Entregador("Jo�o Marcos de Paula", "Entregador", 7, 5678);
		Entregador e3 = new Entregador("Wilson Joaquim da Silva", "Entregador", 8, 9101);
		Entregador e4 = new Entregador("Edson Santos Matos", "Entregador", 9, 1121);
		Entregador e5 = new Entregador("Jos� C�cero da Silva", "Entregador", 10, 3141);
		entregadores.add(e1);
		entregadores.add(e2);
		entregadores.add(e3);
		entregadores.add(e4);
		entregadores.add(e5);
	}

	/**
	 * Verifica se o c�digo j� est� cadastrado
	 */
	@Override
	public boolean existe(int codigo) {
		int aux = -1;
		for (int i = 0; i < entregadores.size(); i++) {
			if (entregadores.get(i).getCodigo() == codigo) {
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
	 * Pesquisa o c�digo informando o nome
	 */
	@Override
	public int pesquisaCodigoPorNome(String nome) {
		int aux = -1;
		for (int i = 0; i < entregadores.size(); i++) {
			if (entregadores.get(i).getNome().equalsIgnoreCase(nome)) {
				aux = i;
				break;
			}
		}

		if (aux == -1) {
			return aux;
		} else {
			return entregadores.get(aux).getCodigo();
		}
	}

	/**
	 * Remove o objeto informando o c�digo
	 */
	@Override
	public boolean removePorCodigo(int codigo) {
		if (existe(codigo) == true) {
			int aux = -1;
			for (int i = 0; i < entregadores.size(); i++) {
				if (entregadores.get(i).getCodigo() == codigo) {
					aux = i;
					break;
				}
			}

			if (aux == -1) {
				return false;
			} else {
				entregadores.remove(aux);
				return true;
			}
		} else {
			return false;
		}
	}

	/**
	 * Verifica se objeto existe informando um c�digo
	 * @param codigo
	 * @return
	 */
	public boolean existeVeiculo(int codigo) {
		int aux = -1;
		for (int i = 0; i < entregadores.size(); i++) {
			if (entregadores.get(i).getCodVeiculo() == codigo) {
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
	 * Retorna um objeto Entregador informando seu respectivo c�digo
	 * 
	 * @param codigo
	 * @return Bairro
	 */
	public Entregador retornaObjeto(int codigo) {
		int aux = -1;
		for (int i = 0; i < entregadores.size(); i++) {
			if (entregadores.get(i).getCodigo() == codigo) {
				aux = i;
			}
		}
		if (aux != -1) {
			return entregadores.get(aux);
		} else {
			return null;
		}
	}

	/**
	 * Pesquisa atributo nome de um objeto informando o seu c�digo
	 * @param cod
	 * @return
	 */
	public String pesquisaNomePorCodigo(int cod) {
		int aux = -1;
		for (int i = 0; i < entregadores.size(); i++) {
			if (entregadores.get(i).getCodigo()==cod) {
				aux = i;
				break;
			}
		}

		if (aux == -1) {
			return null;
		} else {
			return entregadores.get(aux).getNome();
		}
	}
	
	/**
	 * Adiciona objeto na arraylist
	 * @param entregador
	 * @return
	 */
	public boolean adiciona(Entregador entregador) {
		if (existe(entregador.getCodigo()) == true || existeVeiculo(entregador.getCodVeiculo())) {
			System.out.println("Entregador com este c�digo j� existe!");
			return false;
		} else {
			entregadores.add(entregador);
			System.out.println("Entregador cadastrado com sucesso!");
			return true;
		}
	}
	
	/**
	 * Mostra lista completa de objetos cadastrados e seus atributos
	 */
	public void lista() {
		for(int i=0; i<entregadores.size(); i++) {
			System.out.println(entregadores.get(i).toString());
		}
	}
	
	/**
	 * Mostra lista resumida dos objetos cadastrados
	 */
	public void listaResumida() {
		for(int i=0; i<entregadores.size(); i++) {
			System.out.println("Nome: " +entregadores.get(i).getNome());
			System.out.println("C�digo: " +entregadores.get(i).getCodigo());
			System.out.println("C�digo do ve�culo: "+entregadores.get(i).getCodVeiculo());
			System.out.println("\n");

		}
	}
	
	/**
	 * M�todo de intera��o com o usu�rio: CRUD de entregadores
	 */
	@Override
	public void abaCrud() {
		int opCrudFuncionario;
		System.out.println("---CONSULTA/CADASTRO/REMO��O/ATUALIZA��O DE ENTREGADORES---");

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
	 * M�todo de intera��o com o usu�rio: Faz consulta de entregadores
	 */
	@Override
	public void abaConsulta() {
		int opConsultaBebidas;
		String nomeEntregador;
		int codEntregador;

		System.out.println("------CONSULTA------");
		System.out.println("[1]: Saber c�digo de um entregador inserindo o seu nome");
		System.out.println("[2]: Saber nome de um entregador inserindo o seu c�digo");
		System.out.println("[3]: Lista completa de entregadores ");
		System.out.println("[4]: Lista resumida de entregadores");

		opConsultaBebidas = sc.nextInt();
		switch (opConsultaBebidas) {
		case 1:
			System.out.println("Digite o nome completo do entregador: ");
			nomeEntregador = sc.nextLine();
			nomeEntregador = sc.nextLine();
			if (pesquisaCodigoPorNome(nomeEntregador) != -1) {
				System.out.println("C�digo do entregador " + nomeEntregador + ": "
						+ pesquisaCodigoPorNome(nomeEntregador));
			} else {
				System.out.println("Entregador n�o encontrado!");
			}
			break;

		case 2:
			System.out.println("Digite o c�digo do entregador: ");
			codEntregador = sc.nextInt();
			if (pesquisaNomePorCodigo(codEntregador) != null) {
				System.out.println("Nome do entregador de c�digo " + codEntregador + ": "
						+ pesquisaNomePorCodigo(codEntregador));
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
	 * M�todo de intera��o com o usu�rio: Realiza cadastro de entregador
	 */
	@Override
	public void abaCadastro() {
		System.out.println("------CADASTRO DE ENTREGADORES------");
		Entregador entregador;

		String nome;
		int codigo;
		int codVeiculo;

		System.out.println("Insira o nome do entregador:");
		nome = sc.nextLine();
		nome = sc.nextLine();
		System.out.println("Insira o c�digo deste entregador: ");
		codigo = sc.nextInt();
		if (existe(codigo) == true) {
			System.out.println("Entregador com este c�digo j� est� cadastrado!");
		} else {
			System.out.println("Insira o c�digo do ve�culo deste entregador: ");
			codVeiculo = sc.nextInt();
			if (existeVeiculo(codVeiculo) == true) {
				System.out.println("Ve�culo com este c�digo j� est� cadastrado!");
			} else {

				entregador = new Entregador(nome, "Entregador", codigo, codVeiculo);
				adiciona(entregador);
			}
		}
	}

	/**
	 * M�todo de intera��o com o usu�rio: Faz remo��o de entregador informando seu c�digo
	 */
	@Override
	public void abaRemocao() {
		int codigo;

		System.out.println("------REMO��O------");
		System.out.println("Digite o c�digo do entregador: ");
		codigo = sc.nextInt();
		if (existe(codigo) == false) {
			System.out.println("C�digo n�o cadastrado!");
		} else {
			removePorCodigo(codigo);
		}
	}

	/**
	 * M�todo de intera��o com o usu�rio: Faz atualiza��o do c�digo do entregador
	 */
	@Override
	public void abaAtualizacao() {
		int cod;
		int novoCod;
		int escolha;

		System.out.println("------ATUALIZA��O------");
		System.out.println("Digite o c�digo do entregador: ");
		cod = sc.nextInt();

		if (existe(cod) == false) {
			System.out.println("Entregador com este c�digo n�o est� cadastrado!");
		} else {
			System.out.println("Digite o novo c�digo: ");
			novoCod = sc.nextInt();
			if (existe(novoCod) == true) {
				System.out.println("Este c�digo j� est� sendo usado por outro entregador");
			} else {
				System.out.println("Voc� tem certeza que deseja atualizar o c�digo deste entregador?");
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
		return "GerenciadorEntregadores [entregadores=" + entregadores + "]";
	}

	public List<Entregador> getEntregadores() {
		return entregadores;
	}

	public void setEntregadores(List<Entregador> entregadores) {
		this.entregadores = entregadores;
	}

	
}
