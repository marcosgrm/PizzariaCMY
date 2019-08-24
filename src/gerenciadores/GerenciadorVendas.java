package gerenciadores;

import java.util.Scanner;

public abstract class GerenciadorVendas {

	Scanner sc = new Scanner(System.in);

	/**
	 * Menu de opção de CRUD de vendas
	 */
	public void crud() {
		System.out.println("===CRUD DE VENDAS===");
		System.out.println("[1]: CONSULTA");
		System.out.println("[2]: REMOÇÃO");
	}

}
