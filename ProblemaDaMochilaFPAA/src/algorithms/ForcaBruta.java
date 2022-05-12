package algorithms;

import java.util.ArrayList;
import java.util.List;

import entities.Combinacoes;
import entities.ItemMochila;
import entities.Mochila;

public class ForcaBruta {

	
	public static void forcaBruta(int n, int r, Mochila mochila) {
		int[] combinacao = new int[r];

		for (int i = 0; i < r; i++) {
			combinacao[i] = i;
		}
		List<ItemMochila> itens = mochila.getListaItens();

		while (combinacao[r - 1] < n) {
			int somaValores = 0;
			int somaPesos = 0;
			List<ItemMochila> possivelCombinacao = new ArrayList<>();
			for (int item : combinacao) {
				//System.out.print(item + " ");
				somaValores += itens.get(item).getValor();
				somaPesos += itens.get(item).getPeso();
				possivelCombinacao.add(itens.get(item));
			}
			//System.out.println();
			if (somaPesos <= mochila.getPesoMaximo()) {
				if (!(mochila.getListaResultados().isEmpty())) {
					if (mochila.getListaResultados().get(0).getValor() == somaValores
							&& mochila.getListaResultados().get(0).getPeso() == somaPesos) {
						mochila.addResultados(new Combinacoes(possivelCombinacao));
					} else if (mochila.getListaResultados().get(0).getValor() < somaValores) {
						mochila.setResultados(new Combinacoes(possivelCombinacao));
					}
				} else {
					mochila.addResultados(new Combinacoes(possivelCombinacao));
				}
			}

			int t = r - 1;
			while (t != 0 && combinacao[t] == n - r + t) {
				t--;
			}

			combinacao[t]++;
			for (int i = t + 1; i < r; i++) {
				combinacao[i] = combinacao[i - 1] + 1;
			}
		}

	}
	
}
