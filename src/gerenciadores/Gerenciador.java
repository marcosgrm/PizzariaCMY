package gerenciadores;

import java.util.Scanner;

public abstract class Gerenciador {
	
	Scanner sc = new Scanner (System.in);
	
	/**
	 * M�todo que mostra um menu de op��es de CRUD
	 * 
	 * @return
	 */
	public int crud() {
		System.out.println("[1]: CONSULTA");
		System.out.println("[2]: CADASTRO");
		System.out.println("[3]: REMO��O");
		System.out.println("[4]: ATUALIZA��O");
		int crud = sc.nextInt();
		return crud;
	}
}
