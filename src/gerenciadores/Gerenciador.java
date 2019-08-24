package gerenciadores;

import java.util.Scanner;

public abstract class Gerenciador {
	
	Scanner sc = new Scanner (System.in);
	
	/**
	 * Método que mostra um menu de opções de CRUD
	 * 
	 * @return
	 */
	public int crud() {
		System.out.println("[1]: CONSULTA");
		System.out.println("[2]: CADASTRO");
		System.out.println("[3]: REMOÇÃO");
		System.out.println("[4]: ATUALIZAÇÃO");
		int crud = sc.nextInt();
		return crud;
	}
}
