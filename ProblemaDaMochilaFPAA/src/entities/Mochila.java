package entities;

import java.util.ArrayList;
import java.util.List;

public class Mochila {

	private int id;

	private List<ItemMochila> itens = new ArrayList<>();

	private List<Combinacoes> resultados = new ArrayList<>();

	private Combinacoes resultadoAlgGulosoValor;

	private Combinacoes resultadoAlgGulosoValorPeso;

	private Combinacoes resultadoAlgGulosoAmbos;

	// Relatório

	private int pesoMaximo;

	private int capacidadeItens;

	private long tempoForcaBruta;
	private long tempoAlgGulosoValor;
	private long tempoAlgGulosoValorPeso;
	private long tempoAlgGulosoAmbos;

	private String precisaoAlgGulosoValor;
	private String precisaoAlgGulosoValorPeso;
	private String precisaoAlgGulosoAmbos;

	private String eficienciaAlgGulosoValor;
	private String eficienciaAlgGulosoValorPeso;
	private String eficienciaAlgGulosoAmbos;

	public Mochila(int pesoMaximo, int capacidadeItens) {
		this.pesoMaximo = pesoMaximo;
		this.capacidadeItens = capacidadeItens;
	}

	public Mochila() {

	};

	public int getPesoMaximo() {
		return pesoMaximo;
	}

	public int getCapacidadeItens() {
		return capacidadeItens;
	}

	public List<ItemMochila> getListaItens() {
		return itens;
	}

	public List<Combinacoes> getListaResultados() {
		return resultados;
	}

	public void addItens(ItemMochila item) {
		this.itens.add(item);
	}

	public void addResultados(Combinacoes item) {
		this.resultados.add(item);
	}

	public void setResultados(Combinacoes resultado) {
		List<Combinacoes> novaLista = new ArrayList<Combinacoes>();
		novaLista.add(resultado);
		this.resultados = novaLista;
	}

	public Combinacoes getResultadoAlgGulosoValor() {
		return resultadoAlgGulosoValor;
	}

	public void setResultadoAlgGulosoValor(Combinacoes resultadoAlgGulosoValor) {
		this.resultadoAlgGulosoValor = resultadoAlgGulosoValor;
	}

	public Combinacoes getResultadoAlgGulosoValorPeso() {
		return resultadoAlgGulosoValorPeso;
	}

	public void setResultadoAlgGulosoValorPeso(Combinacoes resultadoAlgGulosoValorPeso) {
		this.resultadoAlgGulosoValorPeso = resultadoAlgGulosoValorPeso;
	}

	public Combinacoes getResultadoAlgGulosoAmbos() {
		return resultadoAlgGulosoAmbos;
	}

	public void setResultadoAlgGulosoAmbos(Combinacoes resultadoAlgGulosoAmbos) {
		this.resultadoAlgGulosoAmbos = resultadoAlgGulosoAmbos;
	}

	public long getTempoForcaBruta() {
		return tempoForcaBruta;
	}

	public void setTempoForcaBruta(long tempoForçaBruta) {
		this.tempoForcaBruta = tempoForçaBruta;
	}

	public long getTempoAlgGulosoValor() {
		return tempoAlgGulosoValor;
	}

	public void setTempoAlgGulosoValor(long tempoAlgGulosoValor) {
		this.tempoAlgGulosoValor = tempoAlgGulosoValor;
	}

	public long getTempoAlgGulosoValorPeso() {
		return tempoAlgGulosoValorPeso;
	}

	public void setTempoAlgGulosoValorPeso(long tempoAlgGulosoValorPeso) {
		this.tempoAlgGulosoValorPeso = tempoAlgGulosoValorPeso;
	}

	public long getTempoAlgGulosoAmbos() {
		return tempoAlgGulosoAmbos;
	}

	public void setTempoAlgGulosoAmbos(long tempoAlgGulosoAmbos) {
		this.tempoAlgGulosoAmbos = tempoAlgGulosoAmbos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrecisaoAlgGulosoValor() {
		return (double) this.resultadoAlgGulosoValor.getValor() / this.resultados.get(0).getValor() * (100);
	}

	public double getPrecisaoAlgGulosoValorPeso() {
		return (double) this.resultadoAlgGulosoValorPeso.getValor() / this.resultados.get(0).getValor() * (100);
	}

	public double getPrecisaoAlgGulosoAmbos() {
		return (double) this.resultadoAlgGulosoAmbos.getValor() / this.resultados.get(0).getValor() * (100);
	}

	public double getEficienciaAlgGulosoValor() {
		return (double) this.resultadoAlgGulosoValor.getPeso() / this.resultados.get(0).getPeso() * (100);
	}

	public double getEficienciaAlgGulosoValorPeso() {
		return (double) this.resultadoAlgGulosoValorPeso.getPeso() / this.resultados.get(0).getPeso() * (100);
	}

	public double getEficienciaAlgGulosoAmbos() {
		return (double) this.resultadoAlgGulosoAmbos.getPeso() / this.resultados.get(0).getPeso() * (100);
	}

	public void calculaVariaveis() {
		// CalcValor
		double resposta = (double) this.resultadoAlgGulosoValor.getValor() / this.resultados.get(0).getValor() * (100);
		this.precisaoAlgGulosoValor = String.format("%.2f", resposta) + "%";
		resposta = (double) this.resultadoAlgGulosoValor.getPeso() / this.resultados.get(0).getPeso() * (100);
		this.eficienciaAlgGulosoValor = String.format("%.2f", resposta) + "%";
		// Calc ValorPeso
		resposta = (double) this.resultadoAlgGulosoValorPeso.getValor() / this.resultados.get(0).getValor() * (100);
		this.precisaoAlgGulosoValorPeso = String.format("%.2f", resposta) + "%";
		resposta = (double) this.resultadoAlgGulosoValorPeso.getPeso() / this.resultados.get(0).getPeso() * (100);
		this.eficienciaAlgGulosoValorPeso = String.format("%.2f", resposta) + "%";
		// Calc Ambos
		resposta = (double) this.resultadoAlgGulosoAmbos.getValor() / this.resultados.get(0).getValor() * (100);
		this.precisaoAlgGulosoAmbos = String.format("%.2f", resposta) + "%";
		resposta = (double) this.resultadoAlgGulosoAmbos.getPeso() / this.resultados.get(0).getPeso() * (100);
		this.eficienciaAlgGulosoAmbos = String.format("%.2f", resposta) + "%";
	}

	public void calcularAmbos() {
		this.tempoAlgGulosoAmbos = this.tempoAlgGulosoValor + this.tempoAlgGulosoValorPeso;

		if (this.resultadoAlgGulosoValor.getValor() > this.resultadoAlgGulosoValorPeso.getValor()) {
			this.resultadoAlgGulosoAmbos = this.resultadoAlgGulosoValor;
		} else if (this.resultadoAlgGulosoValor.getValor() == this.resultadoAlgGulosoValorPeso.getPeso()) {
			if (this.resultadoAlgGulosoValor.getPeso() < this.resultadoAlgGulosoValorPeso.getPeso()) {
				this.resultadoAlgGulosoAmbos = this.resultadoAlgGulosoValor;
			} else {
				this.resultadoAlgGulosoAmbos = this.resultadoAlgGulosoValorPeso;
			}
		} else {
			this.resultadoAlgGulosoAmbos = this.resultadoAlgGulosoValorPeso;
		}

	}

	// IDMochila,PesoMaximo,NumeroItens,MelhorValor,MelhorPeso,TempoForcaBruta,
	// TempoAlgGulosoValor,ValorAlgGulosoValor,PesoAlgGulosoValor,PrecisaoAlgGulosValor,EficienciaAlgGulosoValor,
	// TempoAlgGulosoValorPeso,ValorAlgGulosoValorPeso,PesoAlgGulosoValorPeso,PrecisaoAlgGulosoValorPeso,EficienciaAlgGulosoValorPeso,
	// TempoAlgGulosoAmbos,ValorAlgGulosoAmbos,PesoAlgGulosoAmbos,PrecisaoAlgGulosoAmbos,EficienciaAlgGulosoAmbos
	public String retornoExcel() {
		this.calcularAmbos();
		this.calculaVariaveis();
		// Gerando primeira parte
		String resposta = this.id + "," + this.pesoMaximo + "," + this.capacidadeItens + ","
				+ this.resultados.get(0).getValor() + "," + this.resultados.get(0).getPeso() + ","
				+ this.tempoForcaBruta + "ns,";
		// Parte AlgGulosoValor
		resposta += this.tempoAlgGulosoValor + "ns," + this.resultadoAlgGulosoValor.getValor() + ","
				+ this.resultadoAlgGulosoValor.getPeso() + "," + this.precisaoAlgGulosoValor + ","
				+ this.eficienciaAlgGulosoValor + ",";
		// Parte AlgGulosoValorPeso
		resposta += this.tempoAlgGulosoValorPeso + "ns," + this.resultadoAlgGulosoValorPeso.getValor() + ","
				+ this.resultadoAlgGulosoValorPeso.getPeso() + "," + this.precisaoAlgGulosoValorPeso + ","
				+ this.eficienciaAlgGulosoValorPeso + ",";
		// Parte AlgGulosoAmbos
		resposta += this.tempoAlgGulosoAmbos + "ns," + this.resultadoAlgGulosoAmbos.getValor() + ","
				+ this.resultadoAlgGulosoAmbos.getPeso() + "," + this.precisaoAlgGulosoAmbos + ","
				+ this.eficienciaAlgGulosoAmbos;
		return resposta;
	}

}
