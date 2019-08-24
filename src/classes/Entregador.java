package classes;
import java.util.ArrayList;
import java.util.List;

public class Entregador extends Funcionario{
	private int codVeiculo;
	private List<Delivery> pedidos;
	
	public Entregador(String nomeDoFuncionario, String cargoDoFuncionario, int codigo, int codVeiculo) {
		super(nomeDoFuncionario, cargoDoFuncionario, codigo);
		pedidos=new ArrayList<Delivery>();
		this.codVeiculo=codVeiculo;
	}

	public int getCodVeiculo() {
		return codVeiculo;
	}

	public void setCodVeiculo(int codVeiculo) {
		this.codVeiculo = codVeiculo;
	}

	public List<Delivery> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Delivery> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public String toString() {
		return "Entregador " +super.getNome() 
		+"\nCódigo: " +super.getCodigo() 
		+"Código Veículo: " + codVeiculo 
		+ "Pedidos sendo atendidos: " + pedidos;
	}	
	
}
