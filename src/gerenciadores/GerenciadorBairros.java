package gerenciadores;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import classes.Bairro;

public class GerenciadorBairros extends Gerenciador implements GerenciadorNomeados, InterfaceGerenciador {
	private List<Bairro> bairros;

	/**
	 * Construtor vazio que já inicia com alguns objetos cadastrados
	 */
	public GerenciadorBairros() {
		bairros = new ArrayList<Bairro>();
		Bairro bairro1 = new Bairro("Magano", 1, 5.00);
		Bairro bairro2 = new Bairro("Heliópolis", 2, 5.00);
		Bairro bairro3 = new Bairro("Vila do Quartel", 3, 6.00);
		Bairro bairro4 = new Bairro("Indiano", 4, 6.00);
		Bairro bairro5 = new Bairro("Boa Vista", 5, 3.00);
		Bairro bairro6 = new Bairro("Centro", 6, 4.00);
		Bairro bairro7 = new Bairro("José Maria Dourado", 7, 6.00);
		Bairro bairro8 = new Bairro("Aloísio Pinto", 8, 3.00);
		Bairro bairro9 = new Bairro("São José", 9, 4.00);
		Bairro bairro10 = new Bairro("Cohab I", 10, 5.00);
		Bairro bairro11 = new Bairro("Cohab II", 11, 4.00);
		Bairro bairro12 = new Bairro("Cohab III", 12, 5.00);
		Bairro bairro13 = new Bairro("Severiano Moraes Filho", 13, 5.00);
		Bairro bairro14 = new Bairro("Francisco Dos Santos Simao Figueiredo", 14, 5.00);
		Bairro bairro15 = new Bairro("Dom Thiago Postma", 15, 5.00);
		Bairro bairro16 = new Bairro("Dom Helder Camara", 16, 5.00);
		Bairro bairro17 = new Bairro("Brasília", 17, 5.00);
		Bairro bairro18 = new Bairro("Manoel Camelo", 18, 4.00);
		bairros.add(bairro1);
		bairros.add(bairro2);
		bairros.add(bairro3);
		bairros.add(bairro4);
		bairros.add(bairro5);
		bairros.add(bairro6);
		bairros.add(bairro7);
		bairros.add(bairro8);
		bairros.add(bairro9);
		bairros.add(bairro10);
		bairros.add(bairro11);
		bairros.add(bairro12);
		bairros.add(bairro13);
		bairros.add(bairro14);
		bairros.add(bairro15);
		bairros.add(bairro16);
		bairros.add(bairro17);
		bairros.add(bairro18);
	}

	/**
	 * Adiciona objeto Bairro à lista enviando-o como parâmetro
	 * 
	 * @param bairro
	 */
	public boolean adiciona(Bairro bairro) {
		if (existe(bairro.getCodigo()) == true) {
			System.out.println("Bairro com este código já está cadastrado!");
			return false;
		} else {
			bairros.add(bairro);
			System.out.println("Bairro cadastrado com sucesso!");
			return true;
		}

	}

	/**
	 * Remove objeto Bairro da lista enviando-o
	 * 
	 * @param bairro
	 * @return
	 */
	public boolean remove(Bairro bairro) {
		if (this.bairros.contains(bairro) == true) {
			bairros.remove(bairro);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Verifica se um bairro já está cadastrado informando um determinado código de
	 * bairro
	 * 
	 * @param codigo
	 * @return
	 */
	@Override
	public boolean existe(int codigo) {
		int aux = -1;
		for (int i = 0; i < bairros.size(); i++) {
			if (bairros.get(i).getCodigo() == codigo) {
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
	 * Pesquisa código de um bairro informando seu respectivo nome
	 * 
	 * @param nome
	 * @return
	 */
	@Override
	public int pesquisaCodigoPorNome(String nome) {
		int aux = -1;
		for (int i = 0; i < bairros.size(); i++) {
			if (bairros.get(i).getNome().equalsIgnoreCase(nome)) {
				aux = i;
				break;
			}
		}

		if (aux == -1) {
			return aux;
		} else {
			return bairros.get(aux).getCodigo();
		}
	}

	/**
	 * Remove um objeto Bairro informando seu respectivo código
	 * 
	 * @param codigo
	 * @return
	 */
	@Override
	public boolean removePorCodigo(int codigo) {
		if (retornaObjeto(codigo) != null) {
			bairros.remove(retornaObjeto(codigo));
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Retorna frete de um determinado bairro informando seu respectivo código
	 * 
	 * @param codigoBairro
	 * @return
	 */
	public double retornaFrete(int codigoBairro) {
		if (retornaObjeto(codigoBairro) != null) {
			return retornaObjeto(codigoBairro).getFrete();
		} else {
			return 0;
		}
	}

	/**
	 * Retorna um objeto Bairro informando seu respectivo código
	 * 
	 * @param codigo
	 * @return Bairro
	 */
	public Bairro retornaObjeto(int codigo) {
		int aux = -1;
		for (int i = 0; i < bairros.size(); i++) {
			if (bairros.get(i).getCodigo() == codigo) {
				aux = i;
			}
		}
		if (aux != -1) {
			return bairros.get(aux);
		} else {
			return null;
		}
	}

	/**
	 * Método que mostra lista de bairros cadastrados: nome, código e frete
	 */
	public void lista() {
		System.out.println("====BAIRROS CADASTRADOS===");
		for (int i = 0; i < bairros.size(); i++) {
			System.out.println(bairros.get(i).getNome() + "........ CÓD.:" + bairros.get(i).getCodigo()
					+ "   (Frete: R$" + bairros.get(i).getFrete() + ") ");
		}
	}

	/**
	 * Método de interação com o usuário: CRUD de bairros
	 */
	@Override
	public void abaCrud() {
		int opCrud;

		System.out.println("---CONSULTA/CADASTRO/REMOÇÃO/ATUALIZAÇÃO DE BEBIDAS---");
		opCrud = crud();
		switch (opCrud) {
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
	 * Método de interação com o usuário: Consulta de bairros
	 */
	@Override
	public void abaConsulta() {
		int opConsultaBairros;
		String nomeBairro;

		System.out.println("------CONSULTA------");
		System.out.println("[1]: Saber código do bairro inserindo o seu nome");
		System.out.println("[2]: Lista de bairros");

		opConsultaBairros = sc.nextInt();
		switch (opConsultaBairros) {
		case 1:
			System.out.println("Digite o nome do bairro: ");
			nomeBairro = sc.nextLine();
			nomeBairro = sc.nextLine();
			if (pesquisaCodigoPorNome(nomeBairro) != -1) {
				System.out.println("Código do Bairro " + nomeBairro + ": " + pesquisaCodigoPorNome(nomeBairro));
			} else {
				System.out.println("Bebida não encontrada!");
			}
			break;

		case 2:
			lista();
			break;

		default:
			System.out.println("ERRO, opção não encontrada!");
			break;
		}
	}

	/**
	 * Método de interação com o usuário: Cadastro de bairros
	 */
	@Override
	public void abaCadastro() {
		System.out.println("------CADASTRO------");
		Bairro bairro;
		String nome;
		int codigo;
		double frete;

		System.out.println("Insira o nome do bairro: ");
		nome = sc.nextLine();
		nome = sc.nextLine();
		System.out.println("Insira o código do bairro: ");
		codigo = sc.nextInt();
		if (existe(codigo) == true) {
			System.out.println("Código já cadastrado!");
		} else {
			System.out.println("Insira o preco do frete do bairro: ");
			frete = sc.nextDouble();

			bairro = new Bairro(nome, codigo, frete);
			adiciona(bairro);
		}
	}

	/**
	 * Método de interação com o usuário: Remoção de bairro informando seu código
	 */
	@Override
	public void abaRemocao() {
		int codigo;

		System.out.println("------REMOÇÃO------");
		System.out.println("Digite o código do bairro: ");
		codigo = sc.nextInt();
		if (existe(codigo) == false) {
			System.out.println("Código não cadastrado!");
		} else {
			removePorCodigo(codigo);
		}
	}

	/**
	 * Método de interação com o usuário: Atualização do código do bairro
	 */
	@Override
	public void abaAtualizacao() {
		int cod;
		int novoCod;
		int escolha;

		System.out.println("------ATUALIZAÇÃO------");
		System.out.println("Digite o código do bairro: ");
		cod = sc.nextInt();

		if (existe(cod) == false) {
			System.out.println("Bairro com este código não está cadastrada!");
		} else {
			System.out.println("Digite o novo código: ");
			novoCod = sc.nextInt();
			if (existe(novoCod) == true) {
				System.out.println("Este código já está sendo usado por outro bairro!");
			} else {
				System.out.println("Você tem certeza que deseja atualizar o código deste bairro?");
				System.out.println("[1]: SIM");
				System.out.println("[2]: NÃO, ABORTAR OPERAÇÃO");
				escolha = sc.nextInt();

				if (escolha == 1) {
					retornaObjeto(cod).setCodigo(novoCod);
					;
					System.out.println("Código atualizado com sucesso!");
				}
			}
		}
	}

	@Override
	public String toString() {
		return "GerenciadorBairros [bairros=" + bairros + "]";
	}

	public List<Bairro> getBairros() {
		return bairros;
	}

	public void setBairros(List<Bairro> bairros) {
		this.bairros = bairros;
	}


}

