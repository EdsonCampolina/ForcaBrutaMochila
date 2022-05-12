package entities;

import java.util.ArrayList;
import java.util.List;

public class Combinacoes {

	private List<Integer> ids = new ArrayList<>();

	private int peso;

	private int valor;

	public Combinacoes(List<ItemMochila> itens) {
		for (ItemMochila item : itens) {
			this.peso += item.getPeso();
			this.valor += item.getValor();
			this.ids.add(item.getId());
		}
	}

	public List<Integer> getIds() {
		return ids;
	}

	private String getIdsToString() {
		String resultado = "";
		for (int item : ids) {
			resultado += item + ",";
		}
		resultado = resultado.substring(0, resultado.length() - 1);
		return resultado;
	}

	public int getPeso() {
		return peso;
	}

	public int getValor() {
		return valor;
	}

	@Override
	public String toString() {
		return "Combinacoes [ids= {" + getIdsToString() + "}, peso=" + peso + ", valor=" + valor + "]";
	}

}
