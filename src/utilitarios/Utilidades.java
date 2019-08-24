package utilitarios;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilidades {

	/**
	 * Método que gera um número aleatório de oito dígitos.
	 * @return
	 */
	public static long numAleatorioOitoD() {
		long i = (long) (10000000 + Math.random() * 89999999l);
		return i;
	}

	/**
	 * Método que retorna a data atual.
	 * @return
	 */
	public static String data() {
		Date dataAtual = new Date();
		String data = new SimpleDateFormat("dd/MM/yyyy").format(dataAtual);
		return data;
	}

	/**
	 * Método que retorna a hora atual.
	 * @return
	 */
	public static String hora() {
		Date horaAtual = new Date();
		String hora = new SimpleDateFormat("HH:mm:ss").format(horaAtual);
		return hora;
	}

	/**
	 * Método que retorna o troco informando um valor recebido e um total de compra
	 * @param valorRecebido
	 * @param total
	 * @return
	 */
	public static double retornaTroco(double valorRecebido, double total) {
		double troco = 0;
		if (valorRecebido > total) {
			troco = valorRecebido - total;
		}
		if (valorRecebido == total) {
			troco = 0;
		}
		if(valorRecebido<total) {
			troco=-1;
		}
		return troco;
	}
}
