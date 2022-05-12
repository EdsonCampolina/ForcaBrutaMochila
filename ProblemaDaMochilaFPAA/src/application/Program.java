package application;

import algorithms.AlgoritmosGulosos;
import entities.GeradorMochilaComItens;
import entities.ItemMochila;
import entities.Mochila;

public class Program {

	public static void main(String[] args) {

		
		
		// PROGRAMA TESTE - PODE IGNORAR
		Mochila mochila = GeradorMochilaComItens.GeraMochilaComItens(7, 30);
		for (ItemMochila item : mochila.getListaItens()) {
			System.out.println(item);
		}
		System.out.println("Alg guloso");
		AlgoritmosGulosos.AlgoritmoGulosoValor(mochila);
		AlgoritmosGulosos.AlgoritmoGulosoValorPeso(mochila);
		System.out.println(mochila.getResultadoAlgGulosoValor());
		System.out.println(mochila.getResultadoAlgGulosoValorPeso());
	}

}
