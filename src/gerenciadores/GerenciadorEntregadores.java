package gerenciadores;
import java.util.ArrayList;
import java.util.List;
import classes.Entregador;

public class GerenciadorEntregadores extends Gerenciador implements GerenciadorNomeados, InterfaceGerenciador{
	private List<Entregador> entregadores;

	
	/**
	 * Construtor que já inicia com alguns entregadores cadastrados
	 */
	public GerenciadorEntregadores() {
		entregadores = new ArrayList<Entregador>();
		Entregador e1 = new Entregador("Maria da Graça dos Santos", "Entregador", 6, 1234);
		Entregador e2 = new Entregador("João Marcos de Paula", "Entregador", 7, 5678);
		Entregador e3 = new Entregador("Wilson Joaquim da Silva", "Entregador", 8, 9101);
		Entregador e4 = new Entregador("Edson Santos Matos", "Entregador", 9, 1121);
		Entregador e5 = new Entregador("José Cícero da Silva", "Entregador", 10, 3141);
		entregadores.add(e1);
		entregadores.add(e2);
		entregadores.add(e3);
		entregadores.add(e4);
		entregadores.add(e5);
	}

	/**
	 * Verifica se o código já está cadastrado
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
	 * Pesquisa o código informando o nome
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
	 * Remove o objeto informando o código
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
	 * Verifica se objeto existe informando um código
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
	 * Retorna um objeto Entregador informando seu respectivo código
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
	 * Pesquisa atributo nome de um objeto informando o seu código
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
			System.out.println("Entregador com este código já existe!");
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
			System.out.println("Código: " +entregadores.get(i).getCodigo());
			System.out.println("Código do veículo: "+entregadores.get(i).getCodVeiculo());
			System.out.println("\n");

		}
	}
	
	/**
	 * Método de interação com o usuário: CRUD de entregadores
	 */
	@Override
	public void abaCrud() {
		int opCrudFuncionario;
		System.out.println("---CONSULTA/CADASTRO/REMOÇÃO/ATUALIZAÇÃO DE ENTREGADORES---");

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
	 * Método de interação com o usuário: Faz consulta de entregadores
	 */
	@Override
	public void abaConsulta() {
		int opConsultaBebidas;
		String nomeEntregador;
		int codEntregador;

		System.out.println("------CONSULTA------");
		System.out.println("[1]: Saber código de um entregador inserindo o seu nome");
		System.out.println("[2]: Saber nome de um entregador inserindo o seu código");
		System.out.println("[3]: Lista completa de entregadores ");
		System.out.println("[4]: Lista resumida de entregadores");

		opConsultaBebidas = sc.nextInt();
		switch (opConsultaBebidas) {
		case 1:
			System.out.println("Digite o nome completo do entregador: ");
			nomeEntregador = sc.nextLine();
			nomeEntregador = sc.nextLine();
			if (pesquisaCodigoPorNome(nomeEntregador) != -1) {
				System.out.println("Código do entregador " + nomeEntregador + ": "
						+ pesquisaCodigoPorNome(nomeEntregador));
			} else {
				System.out.println("Entregador não encontrado!");
			}
			break;

		case 2:
			System.out.println("Digite o código do entregador: ");
			codEntregador = sc.nextInt();
			if (pesquisaNomePorCodigo(codEntregador) != null) {
				System.out.println("Nome do entregador de código " + codEntregador + ": "
						+ pesquisaNomePorCodigo(codEntregador));
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
	 * Método de interação com o usuário: Realiza cadastro de entregador
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
		System.out.println("Insira o código deste entregador: ");
		codigo = sc.nextInt();
		if (existe(codigo) == true) {
			System.out.println("Entregador com este código já está cadastrado!");
		} else {
			System.out.println("Insira o código do veículo deste entregador: ");
			codVeiculo = sc.nextInt();
			if (existeVeiculo(codVeiculo) == true) {
				System.out.println("Veículo com este código já está cadastrado!");
			} else {

				entregador = new Entregador(nome, "Entregador", codigo, codVeiculo);
				adiciona(entregador);
			}
		}
	}

	/**
	 * Método de interação com o usuário: Faz remoção de entregador informando seu código
	 */
	@Override
	public void abaRemocao() {
		int codigo;

		System.out.println("------REMOÇÃO------");
		System.out.println("Digite o código do entregador: ");
		codigo = sc.nextInt();
		if (existe(codigo) == false) {
			System.out.println("Código não cadastrado!");
		} else {
			removePorCodigo(codigo);
		}
	}

	/**
	 * Método de interação com o usuário: Faz atualização do código do entregador
	 */
	@Override
	public void abaAtualizacao() {
		int cod;
		int novoCod;
		int escolha;

		System.out.println("------ATUALIZAÇÃO------");
		System.out.println("Digite o código do entregador: ");
		cod = sc.nextInt();

		if (existe(cod) == false) {
			System.out.println("Entregador com este código não está cadastrado!");
		} else {
			System.out.println("Digite o novo código: ");
			novoCod = sc.nextInt();
			if (existe(novoCod) == true) {
				System.out.println("Este código já está sendo usado por outro entregador");
			} else {
				System.out.println("Você tem certeza que deseja atualizar o código deste entregador?");
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
		return "GerenciadorEntregadores [entregadores=" + entregadores + "]";
	}

	public List<Entregador> getEntregadores() {
		return entregadores;
	}

	public void setEntregadores(List<Entregador> entregadores) {
		this.entregadores = entregadores;
	}

	
}
