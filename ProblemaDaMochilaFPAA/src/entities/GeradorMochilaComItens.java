package entities;

import java.util.Random;

public class GeradorMochilaComItens {

	public static Mochila GeraMochilaComItens(int capacidade, int pesoMaximo) {
		Random gerador = new Random();
		Mochila mochila = new Mochila(pesoMaximo, capacidade);
		int pesoGeracao = 3 * (pesoMaximo / capacidade);
		int pesoTotal = 0;
		for (int i = 0; i < capacidade; i++) {
			int pesoItem = gerador.nextInt(pesoGeracao) + 1;
			int valorItem = gerador.nextInt(pesoMaximo) + 1;
			mochila.addItens(new ItemMochila(i, pesoItem, valorItem));
			pesoTotal += pesoItem;
		}
		int pesoFinal = 3 * pesoMaximo;
		pesoFinal -= pesoTotal;
		pesoFinal = pesoFinal / capacidade;
		for (ItemMochila item : mochila.getListaItens()) {
			item.setPeso(item.getPeso() + pesoFinal + gerador.nextInt(2));
		}
		return mochila;
	}
}
