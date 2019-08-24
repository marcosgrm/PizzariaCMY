package gerenciadores;

import java.util.ArrayList;
import java.util.List;

import classes.Mesa;

public class GerenciadorMesas extends Gerenciador implements InterfaceGerenciador {
	private List<Mesa> mesas;

	/**
	 * Construtor vazio que já inicia com alguns objetos cadastrados
	 */
	public GerenciadorMesas() {
		mesas = new ArrayList<Mesa>();
		Mesa mesa1 = new Mesa(1);
		Mesa mesa2 = new Mesa(2);
		Mesa mesa3 = new Mesa(3);
		Mesa mesa4 = new Mesa(4);
		Mesa mesa5 = new Mesa(5);
		Mesa mesa6 = new Mesa(6);
		Mesa mesa7 = new Mesa(7);
		Mesa mesa8 = new Mesa(8);
		Mesa mesa9 = new Mesa(9);
		Mesa mesa10 = new Mesa(10);
		Mesa mesa11 = new Mesa(11);
		Mesa mesa12 = new Mesa(12);
		Mesa mesa13 = new Mesa(13);
		Mesa mesa14 = new Mesa(14);
		Mesa mesa15 = new Mesa(15);
		mesas.add(mesa1);
		mesas.add(mesa2);
		mesas.add(mesa3);
		mesas.add(mesa4);
		mesas.add(mesa5);
		mesas.add(mesa6);
		mesas.add(mesa7);
		mesas.add(mesa8);
		mesas.add(mesa9);
		mesas.add(mesa10);
		mesas.add(mesa11);
		mesas.add(mesa12);
		mesas.add(mesa13);
		mesas.add(mesa14);
		mesas.add(mesa15);
	}

	/**
	 * Método que adiciona uma mesa à lista de mesas cadastradas
	 * @param mesa
	 * @return
	 */
	public boolean adiciona(Mesa mesa) {
		if (existe(mesa.getCodigo()) == true) {
			System.out.println("Mesa com este código já está cadastrada!");
			return false;
		} else {
			mesas.add(mesa);
			System.out.println("Mesa cadastrada com sucesso!");
			return true;
		}
	}

	/**
	 * Método que remove uma mesa da lista de mesas cadastradas
	 * @param mesa
	 */
	public void remove(Mesa mesa) {
		mesas.remove(mesa);
	}

	/**
	 * Método que mostra disponibilidade de mesas cadastradas
	 */
	public void mostraDisponibilidade() {
		System.out.println("----MESAS DISPONÍVEIS----");
		int qtdMesas = 0;
		for (int i = 0; i < mesas.size(); i++) {
			if (mesas.get(i).getDisponibilidade() == true) {
				System.out.println("MESA " + mesas.get(i).getCodigo());
				qtdMesas++;
			}
		}
		if (qtdMesas == 0) {
			System.out.println("Não há nenhuma mesa disponível");
		}
		if (qtdMesas == mesas.size()) {
			System.out.println("TODAS AS MESAS ESTÃO DISPONÍVEIS");
		}
		System.out.println("Quantidade de mesas disponíveis: " + qtdMesas);
	}

	/**
	 * Método que recebe o código de uma mesa e retorna se ela está disponível ou não
	 * @param codMesa
	 * @return
	 */
	public boolean estaDisponivel(int codMesa) {
		if (existe(codMesa) == true) {
			int aux = 0;
			for (int i = 0; i < mesas.size(); i++) {
				if (mesas.get(i).getCodigo() == codMesa) {
					aux = i;
					break;
				}
			}
			return mesas.get(aux).getDisponibilidade();
		} else {
			System.out.println("Mesa não cadastrada!");
			return false;
		}

	}

	/**
	 * Método que verifica se uma mesa já existe informando seu código
	 */
	@Override
	public boolean existe(int codigoMesa) {
		int aux = -1;
		for (int i = 0; i < mesas.size(); i++) {
			if (mesas.get(i).getCodigo() == codigoMesa) {
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
	 * Método que remove uma mesa informando seu código
	 */
	@Override
	public boolean removePorCodigo(int codigo) {
		if (existe(codigo) == true) {
			int aux = -1;
			for (int i = 0; i < mesas.size(); i++) {
				if (mesas.get(i).getCodigo() == codigo) {
					aux = i;
					break;
				}
			}

			if (aux == -1) {
				return false;
			} else {
				mesas.remove(aux);
				return true;
			}
		} else {
			System.out.println("Código não cadastrado!");
			return false;
		}
	}

	/**
	 * Método que retorna um objeto do tipo Mesa informando seu código
	 * @param codigo
	 * @return
	 */
	public Mesa retornaObjeto(int codigo) {
		int aux = -1;
		for (int i = 0; i < mesas.size(); i++) {
			if (mesas.get(i).getCodigo() == codigo) {
				aux = i;
			}
		}
		if (aux != -1) {
			return mesas.get(aux);
		} else {
			System.out.println("Código não cadastrado!");
			return null;
		}
	}

	/**
	 * Método que retorna a lista de mesas (todos os atributos)
	 */
	public void lista() {
		for (int i = 0; i < mesas.size(); i++) {
			System.out.println(mesas.get(i));
		}
	}

	/**
	 * Método que retorna uma lista resumida de mesas (apenas código e disponibilidade)
	 */
	public void listaResumida() {
		for (int i = 0; i < mesas.size(); i++) {
			System.out.println(
					"COD. " + mesas.get(i).getCodigo() + "..........." + "DISP.? " + mesas.get(i).getDisponibilidade());
		}
	}

	/**
	 * Método de interação com o usuário: CRUD de mesas
	 */
	@Override
	public void abaCrud() {
		int opCrudMesa;
		System.out.println("---CONSULTA/CADASTRO/REMOÇÃO/ATUALIZAÇÃO DE MESAS---");

		opCrudMesa = crud();
		switch (opCrudMesa) {
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
	 * Método de interação com o usuário: Consulta de mesas
	 */
	@Override
	public void abaConsulta() {
		int opConsultaMesas;

		System.out.println("------CONSULTA------");
		System.out.println("[1]: Menu de mesas completo");
		System.out.println("[2]: Menu resumido");

		opConsultaMesas = sc.nextInt();
		switch (opConsultaMesas) {
		case 1:
			lista();
			break;

		case 2:
			listaResumida();
			break;

		default:
			System.out.println("ERRO, opção não encontrada!");
			break;
		}
	}

	/**
	 * Método de interação com o usuário: Cadastro de mesas
	 */
	@Override
	public void abaCadastro() {
		System.out.println("------CADASTRO------");
		Mesa mesa;

		int codigo;

		System.out.println("Insira o código da mesa: ");
		codigo = sc.nextInt();
		if (existe(codigo) == true) {
			System.out.println("Código já cadastrado!");
		} else {
			mesa = new Mesa(codigo);
			adiciona(mesa);
		}
	}

	/**
	 * Método de interação com o usuário: Remoção de mesa informando seu código
	 */
	@Override
	public void abaRemocao() {
		int codigo;

		System.out.println("------REMOÇÃO------");
		System.out.println("Digite o código da mesa: ");
		codigo = sc.nextInt();
		if (existe(codigo) == false) {
			System.out.println("Código não cadastrado!");
		} else {
			removePorCodigo(codigo);
		}
	}

	/**
	 * Método de interação com o usuário: Atualização do código da mesa
	 */
	@Override
	public void abaAtualizacao() {
		int cod;
		int novoCod;
		int escolha;

		System.out.println("------ATUALIZAÇÃO------");
		System.out.println("Digite o código da mesa: ");
		cod = sc.nextInt();

		if (existe(cod) == false) {
			System.out.println("Mesa com este código não está cadastrada!");
		} else {
			System.out.println("Digite o novo código: ");
			novoCod = sc.nextInt();
			if (existe(novoCod) == true) {
				System.out.println("Este código já está sendo usado por outra mesa!");
			} else {
				System.out.println("Você tem certeza que deseja atualizar o código desta mesa?");
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

	/**
	 * Método que ocupa uma mesa
	 */
	public void ocuparMesa() {
		int codMesa;
		System.out.println("Insira o código da mesa: ");
		codMesa = sc.nextInt();
		if (existe(codMesa) == false) {
			System.out.println("Mesa não cadastrada!");
		} else {
			if (retornaObjeto(codMesa).getDisponibilidade() == false) {
				System.out.println("Mesa já está ocupada!");
			} else {
				retornaObjeto(codMesa).setDisponibilidade(false);
				System.out.println("Mesa ocupada com sucesso!");
			}
		}
	}

	/**
	 * Método que desocupa uma mesa
	 */
	public void desocuparMesa(int codMesa) {
		if (retornaObjeto(codMesa).getDisponibilidade() == true) {
			System.out.println("Mesa não está ocupada!");
		} else {
			retornaObjeto(codMesa).setDisponibilidade(true);
			System.out.println("Mesa desocupada com sucesso!");
		}
	}

	/**
	 * Aba de interação com o usuário para desocupar uma mesa
	 */
	public void abaDesocuparMesa() {
		int codMesa;
		System.out.println("Insira o código da mesa: ");
		codMesa = sc.nextInt();
		if (existe(codMesa) == false) {
			System.out.println("Mesa não cadastrada!");
		} else {
			desocuparMesa(codMesa);
		}
	}

	@Override
	public String toString() {
		return "GerenciadorMesas [mesas=" + mesas + "]";
	}

	public List<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(List<Mesa> mesas) {
		this.mesas = mesas;
	}

	
	
}
