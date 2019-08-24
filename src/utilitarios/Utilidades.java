package utilitarios;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilidades {

	/**
	 * M�todo que gera um n�mero aleat�rio de oito d�gitos.
	 * @return
	 */
	public static long numAleatorioOitoD() {
		long i = (long) (10000000 + Math.random() * 89999999l);
		return i;
	}

	/**
	 * M�todo que retorna a data atual.
	 * @return
	 */
	public static String data() {
		Date dataAtual = new Date();
		String data = new SimpleDateFormat("dd/MM/yyyy").format(dataAtual);
		return data;
	}

	/**
	 * M�todo que retorna a hora atual.
	 * @return
	 */
	public static String hora() {
		Date horaAtual = new Date();
		String hora = new SimpleDateFormat("HH:mm:ss").format(horaAtual);
		return hora;
	}

	/**
	 * M�todo que retorna o troco informando um valor recebido e um total de compra
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
