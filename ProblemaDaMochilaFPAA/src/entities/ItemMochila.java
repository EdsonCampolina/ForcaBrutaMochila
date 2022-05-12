package entities;

public class ItemMochila implements Comparable<ItemMochila> {

	private int Id;
	private int peso;
	private Integer valor;
	private double valorPeso;

	public ItemMochila(int Id, int peso, int valor) {
		this.Id = Id;
		this.peso = peso;
		this.valor = valor;
		this.valorPeso = (double) this.valor / this.peso;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
		this.valorPeso = (double) this.valor / this.peso;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
		this.valorPeso = (double) this.valor / this.peso;
	}

	public int getId() {
		return Id;
	}

	public double getValorPeso() {
		return valorPeso;
	}

	public String getValorPesoFormatado() {
		return String.format("%.2f", getValorPeso());
	}

	@Override
	public String toString() {
		return "ItemMochila [Id=" + Id + ", peso=" + peso + ", valor=" + valor + ", valorPeso="
				+ getValorPesoFormatado() + "]";
	}

	@Override
	public int compareTo(ItemMochila o) {
		return this.valor.compareTo(o.valor);
	}
	
	

}
