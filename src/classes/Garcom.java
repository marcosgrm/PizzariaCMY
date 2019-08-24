package classes;
import java.util.ArrayList;
import java.util.List;

import venda.VendaMesa;

public class Garcom extends Funcionario {
	private double comissao;
	private List<VendaMesa> vendasFeitas;
	
	public Garcom(String nomeDoFuncionario, String cargoDoFuncionario, int codigo) {
		super(nomeDoFuncionario, cargoDoFuncionario, codigo);
		vendasFeitas=new ArrayList<VendaMesa>();
	}

	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}

	public List<VendaMesa> getMesasAtendidas() {
		return vendasFeitas;
	}

	public void setMesasAtendidas(List<VendaMesa> vendasFeitas) {
		this.vendasFeitas = vendasFeitas;
	}

	@Override
	public String toString() {
		return 	"\n" +super.getNome()
				+"\nCódigo: "+super.getCodigo()
				+"\nComissão: R$" +this.comissao
				+"\nVendas feitas: " +vendasFeitas;
		
	}
	
	/**
	 * Método que adiciona uma venda à lista de vendas feitas por um garçom
	 * @param vendaMesa
	 */
	public void adicionaVenda(VendaMesa vendaMesa) {
		 vendasFeitas.add(vendaMesa);
		 System.out.println("Venda adicionada às vendas realizadas pelo garçom com sucesso!");
	}
	
	/**
	 * Método que retorna o total de vendas feitas por um garçom
	 * @return
	 */
	public int totalVendasFeitas() {
		int total=0;
		if(vendasFeitas.size()==0) {
			System.out.println("Nenhuma venda feita!");
		}else {
			total=vendasFeitas.size();
		}
		return total;
	}
	
	/**
	 * Método que adiciona comissão a um garçom
	 * @param total
	 */
	public void adicionaComissao(double total) {
		this.comissao+=(total*0.05);
	}


	
	
	
	

}
