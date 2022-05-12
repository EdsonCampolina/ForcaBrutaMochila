package algorithms;

import java.util.ArrayList;
import java.util.List;

import entities.Combinacoes;
import entities.ItemMochila;
import entities.Mochila;

public class AlgoritmosGulosos {

	/**
	 * A partir do ItemMochila de maior Valor, os itens serão inseridos na resposta.
	 * Caso a resposta com o ItemMochila ainda tenha um peso menor que o máximo, o
	 * ItemMochila será inserido na resposta.
	 * 
	 * @param mochila Mochila em que seus ItemMochila estão ordenados pela
	 *                propriedade Valor.
	 */
	public static void AlgoritmoGulosoValor(Mochila mochila) {

		int somaPesos = 0;
		List<ItemMochila> resposta = new ArrayList<>();
		for (ItemMochila item : mochila.getListaItens()) {
			if (item.getPeso() + somaPesos <= mochila.getPesoMaximo()) {
				resposta.add(item);
				somaPesos += item.getPeso();

			}
		}
		mochila.setResultadoAlgGulosoValor(new Combinacoes(resposta));
	}

	/**
	 * A partir do ItemMochila de maior ValorPeso, os itens serão inseridos na
	 * resposta. Caso a resposta com o ItemMochila ainda tenha um peso menor que o
	 * máximo, o ItemMochila será inserido na resposta.
	 * 
	 * @param mochila
	 */
	public static void AlgoritmoGulosoValorPeso(Mochila mochila) {

		List<ItemMochila> temp = new ArrayList<>();
		for (ItemMochila item : mochila.getListaItens()) {
			temp.add(item);
		}
		List<ItemMochila> ordenada = new ArrayList<>();
		while (!(temp.isEmpty())) {
			ItemMochila menorValor = new ItemMochila(999, 1, 999);
			for (int i = 0; i <= temp.size() - 1; i++) {
				if (temp.get(i).getValorPeso() < menorValor.getValorPeso()) {
					menorValor = temp.get(i);
				}
			}
			ordenada.add(menorValor);
			temp.remove(menorValor);
		}

		int somaPesos = 0;
		List<ItemMochila> resposta = new ArrayList<>();

		for (int i = ordenada.size() - 1; i > 0; i--) {
			if (ordenada.get(i).getPeso() + somaPesos <= mochila.getPesoMaximo()) {
				resposta.add(ordenada.get(i));
				somaPesos += ordenada.get(i).getPeso();
			}
		}

		mochila.setResultadoAlgGulosoValorPeso(new Combinacoes(resposta));

	}

}
