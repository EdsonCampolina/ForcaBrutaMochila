package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Locale;

import algorithms.AlgoritmosGulosos;
import algorithms.ForcaBruta;
import entities.Combinacoes;
import entities.GeradorMochilaComItens;
import entities.ItemMochila;
import entities.Mochila;

public class ProgramMain {

	//// Criar um vetor que vai salvar todas as precisoes para fazer uma media e ver
	//// se é valido usar o algoritmo guloso

	public static void main(String[] args) throws CloneNotSupportedException {

		// Setando Localce como US para não dar erro ao gerar o CSV, já que virá com
		// ponto e não com vírgula
		Locale.setDefault(Locale.US);
		// Escrevendo o títuloo das colunas
		try (BufferedWriter bw = new BufferedWriter(
				new FileWriter("D:\\WORKSPACES\\WS_ECLIPSE\\ProblemaDaMochilaFPAA\\Relatorio.csv", true))) {
			bw.write(
					"IDMochila,PesoMaximo,NumeroItens,MelhorValor,MelhorPeso,TempoForcaBruta,TempoAlgGulosoValor,ValorAlgGulosoValor,PesoAlgGulosoValor,PrecisaoAlgGulosValor,EficienciaAlgGulosoValor,TempoAlgGulosoValorPeso,ValorAlgGulosoValorPeso,PesoAlgGulosoValorPeso,PrecisaoAlgGulosoValorPeso,EficienciaAlgGulosoValorPeso,TempoAlgGulosoAmbos,ValorAlgGulosoAmbos,PesoAlgGulosoAmbos,PrecisaoAlgGulosoAmbos,EficienciaAlgGulosoAmbos");
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		long inicio = System.currentTimeMillis();
		int pesoMaximo = 30;
		int numeroItens = 3;
		// Numero de repeticoes (Em caso de testes com menores valores, basta alterar
		// esse valor)
		int numeroRepeticoes = 500;
		Mochila mochila = new Mochila();
		long resultadoMochila = 0;

		// Achando o número de itens em que o algoritmo rodará em menos de 4 segundos
		System.out.println("Procurando mochila que seja resolvida em até 4 segundos");
		while (resultadoMochila < 4000) {
			long inicioMochila = System.currentTimeMillis();
			mochila = GeradorMochilaComItens.GeraMochilaComItens(numeroItens, pesoMaximo);
			Collections.sort(mochila.getListaItens());
			int peso = 0;
			for (ItemMochila item : mochila.getListaItens()) {
				// System.out.println(item);
				peso += item.getPeso();
			}
			long inicioBrute = System.currentTimeMillis();
			for (int i = 1; i <= numeroItens; i++) {
				ForcaBruta.forcaBruta(numeroItens, i, mochila);

			}
			long fimBrute = System.currentTimeMillis();

			System.out.println("Mochila de " + numeroItens + " itens foi gerada");
			long fimMochila = System.currentTimeMillis();
			long resultadoBrute = fimBrute - inicioBrute;
			resultadoMochila = fimMochila - inicioMochila;
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(
					"D:\\WORKSPACES\\WS_ECLIPSE\\ProblemaDaMochilaFPAA\\ProcurandoMochilas.txt", true))) {
				bw.write("CRIANDO NOVA MOCHILA:");
				bw.newLine();
				for (ItemMochila item : mochila.getListaItens()) {
					bw.write(item.toString());
					bw.newLine();
				}
				for (Combinacoes item : mochila.getListaResultados()) {
					bw.write(item.toString());
					bw.newLine();
				}
				bw.write("Peso total dos itens da mochila = " + peso);
				bw.newLine();
				bw.write("Tempo gasto criando a mochila de " + numeroItens + " itens : " + resultadoMochila + "ms");
				bw.newLine();
				bw.write("Tempo gasto no Algoritmo Bruto da mochila de " + numeroItens + " itens : " + resultadoBrute
						+ "ms");
				bw.newLine();
				bw.newLine();
				bw.newLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			numeroItens++;
			pesoMaximo++;
		}
		numeroItens = numeroItens - 2;

		// Preenchendo algumas informações sobre o que foi encontrado na parte de
		// encontrar mochila que roda em menos de 4 segundos

		try (BufferedWriter bw = new BufferedWriter(
				new FileWriter("D:\\WORKSPACES\\WS_ECLIPSE\\ProblemaDaMochilaFPAA\\Execucoes.txt", true))) {
			bw.write("VALORES ENCONTRADOS");
			bw.newLine();
			bw.write("PESO MAXIMO DAS MOCHILAS SERA DE :" + pesoMaximo);
			bw.newLine();
			bw.write("NUMERO DE ITENS DA MOCHILA SERA DE :" + numeroItens);
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// A partir daqui começa o algoritmo que irá resolver a mochila 500 vezes
		// Começo do programa
		double[] precisoesAlgGulValor = new double[numeroRepeticoes];
		double[] precisoesAlgGulValorPeso = new double[numeroRepeticoes];
		double[] precisoesAlgGulAmbos = new double[numeroRepeticoes];
		double[] eficienciasAlGulValor = new double[numeroRepeticoes];
		double[] eficienciasAlGulValorPeso = new double[numeroRepeticoes];
		double[] eficienciasAlGulValorAmbos = new double[numeroRepeticoes];
		System.out
				.println("A mochila que atende aos requisitos de ser resolvida em menos de 4 segundos foi encontrada!");
		System.out.println();
		for (int i = 1; i <= numeroRepeticoes; i++) {
			System.out.println("Mochila numero " + i + " foi gerada");
			Mochila mochilaAlgoritmo = GeradorMochilaComItens.GeraMochilaComItens(numeroItens, pesoMaximo);
			mochilaAlgoritmo.setId(i);
			Collections.sort(mochilaAlgoritmo.getListaItens());

			int peso = 0;
			for (ItemMochila item : mochilaAlgoritmo.getListaItens()) {
				// System.out.println(item);
				peso += item.getPeso();
			}
			long tempoExec1 = System.nanoTime();
			for (int j = 1; j <= numeroItens; j++) {
				ForcaBruta.forcaBruta(numeroItens, j, mochilaAlgoritmo);
			}
			long tempoExec2 = System.nanoTime();
			mochilaAlgoritmo.setTempoForcaBruta(tempoExec2 - tempoExec1);
			AlgoritmosGulosos.AlgoritmoGulosoValor(mochilaAlgoritmo);
			long tempoExec3 = System.nanoTime();
			mochilaAlgoritmo.setTempoAlgGulosoValor(tempoExec3 - tempoExec2);
			AlgoritmosGulosos.AlgoritmoGulosoValorPeso(mochilaAlgoritmo);
			long tempoExec4 = System.nanoTime();
			mochilaAlgoritmo.setTempoAlgGulosoValorPeso(tempoExec4 - tempoExec3);

			try (BufferedWriter bw = new BufferedWriter(
					new FileWriter("D:\\WORKSPACES\\WS_ECLIPSE\\ProblemaDaMochilaFPAA\\Relatorio.csv", true))) {
				bw.write(mochilaAlgoritmo.retornoExcel());
				bw.newLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try (BufferedWriter bw = new BufferedWriter(
					new FileWriter("D:\\WORKSPACES\\WS_ECLIPSE\\ProblemaDaMochilaFPAA\\Execucoes.txt", true))) {
				bw.write("MOCHILA NUMERO " + i);
				bw.newLine();
				for (ItemMochila item : mochilaAlgoritmo.getListaItens()) {
					bw.write(item.toString());
					bw.newLine();
				}
				for (Combinacoes item : mochilaAlgoritmo.getListaResultados()) {
					bw.write(item.toString());
					bw.newLine();
				}
				bw.write("Peso total = " + peso);
				bw.newLine();
				bw.write("Tempo de execução da forca bruta = " + mochilaAlgoritmo.getTempoForcaBruta() + "ns");
				bw.newLine();
				bw.write("Tempo de execução do algortimo guloso valor = " + mochilaAlgoritmo.getTempoAlgGulosoValor()
						+ "ns");
				bw.newLine();
				bw.write("Tempo de execução do algortimo guloso valor peso = "
						+ mochilaAlgoritmo.getTempoAlgGulosoValorPeso() + "ns");
				bw.newLine();
				bw.write("Tempo de execução do algortimo guloso ambos = " + mochilaAlgoritmo.getTempoAlgGulosoAmbos()
						+ "ns");
				bw.newLine();
				bw.newLine();
				bw.newLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			precisoesAlgGulValor[i - 1] = mochilaAlgoritmo.getPrecisaoAlgGulosoValor();
			precisoesAlgGulValorPeso[i - 1] = mochilaAlgoritmo.getPrecisaoAlgGulosoValorPeso();
			precisoesAlgGulAmbos[i - 1] = mochilaAlgoritmo.getPrecisaoAlgGulosoAmbos();
			eficienciasAlGulValor[i - 1] = mochilaAlgoritmo.getEficienciaAlgGulosoValor();
			eficienciasAlGulValorPeso[i - 1] = mochilaAlgoritmo.getEficienciaAlgGulosoValorPeso();
			eficienciasAlGulValorAmbos[i - 1] = mochilaAlgoritmo.getEficienciaAlgGulosoAmbos();
		}
		double mediaPrecisoesAlgGulValor = 0;
		double mediaPrecisoesAlgGulValorPeso = 0;
		double mediaPrecisoesAlgGulAmbos = 0;

		double mediaEficienciasAlGulValor = 0;
		double mediaEficienciasAlGulValorPeso = 0;
		double mediaEficienciasAlGulValorAmbos = 0;

		for (int i = 0; i < numeroRepeticoes; i++) {
			mediaPrecisoesAlgGulValor += precisoesAlgGulValor[i];
			mediaPrecisoesAlgGulValorPeso += precisoesAlgGulValorPeso[i];
			mediaPrecisoesAlgGulAmbos += precisoesAlgGulAmbos[i];
			mediaEficienciasAlGulValor += eficienciasAlGulValor[i];
			mediaEficienciasAlGulValorPeso += eficienciasAlGulValorPeso[i];
			mediaEficienciasAlGulValorAmbos += eficienciasAlGulValorAmbos[i];
		}

		mediaPrecisoesAlgGulValor = mediaPrecisoesAlgGulValor / numeroRepeticoes;
		mediaPrecisoesAlgGulValorPeso = mediaPrecisoesAlgGulValorPeso / numeroRepeticoes;
		mediaPrecisoesAlgGulAmbos = mediaPrecisoesAlgGulAmbos / numeroRepeticoes;
		mediaEficienciasAlGulValor = mediaEficienciasAlGulValor / numeroRepeticoes;
		mediaEficienciasAlGulValorPeso = mediaEficienciasAlGulValorPeso / numeroRepeticoes;
		mediaEficienciasAlGulValorAmbos = mediaEficienciasAlGulValorAmbos / numeroRepeticoes;
		long fim = System.currentTimeMillis();
		long resultado = fim - inicio;
		try (BufferedWriter bw = new BufferedWriter(
				new FileWriter("D:\\WORKSPACES\\WS_ECLIPSE\\ProblemaDaMochilaFPAA\\Execucoes.txt", true))) {
			bw.write("Precisao media do Algoritmo Guloso Valor = " + mediaPrecisoesAlgGulValor);
			bw.newLine();
			bw.write("Precisao media do Algoritmo Guloso Valor Peso = " + mediaPrecisoesAlgGulValorPeso);
			bw.newLine();
			bw.write("Precisao media do Algoritmo Guloso Ambos = " + mediaPrecisoesAlgGulAmbos);
			bw.newLine();
			bw.write("Eficiencia media do Algoritmo Guloso Valor = " + mediaEficienciasAlGulValor);
			bw.newLine();
			bw.write("Eficiencia media do Algoritmo Guloso Valor Peso = " + mediaEficienciasAlGulValorPeso);
			bw.newLine();
			bw.write("Eficiencia media do Algoritmo Guloso Ambos = " + mediaEficienciasAlGulValorAmbos);
			bw.newLine();
			bw.write("Tempo de execucao do programa: " + resultado + "ms");

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Programa finalizado!");

	}

}
