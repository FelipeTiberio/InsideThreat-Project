package br.edu.imd.model;

import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LogAnalyzer {
	// Usado para armazenar as linhas dos arquivos
	private List<String[]> entries = new ArrayList<>();
	private BufferedReader filebr = null;

	/**
	 * O método é usado para ler uma arquivo scv linha por linha, cada linha é um índice do conteiner entries
	 * @param filename Nome do arquivo a ser lido
	 * @param separate caracter usado para separar as colunas do csv
	 * @throws IOException
	 */
	public void  readFile(String filename, String separate) throws IOException {

		try {

			filebr  = new BufferedReader(new FileReader(filename));
			String line;

			while((line = filebr .readLine()) != null) {
				String filds[] = line.split(separate);
				entries.add(filds);
			}

		}catch (FileNotFoundException e) {
			System.out.println(e.getLocalizedMessage());
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}catch (IOException e) {
			System.out.println(e.getCause());
		}finally {
			if(filebr != null) {
				try {
					filebr.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}

			}
		}

	}

	/**
	 * @return Retorna uma lista de strings, cada string é uma linha do arquivo de log
	 */
	public List<String[]> getEntries() {
		return entries;
	}

	/**
	 * Método usado para debug @
	 * @TODO lembrar de removelo depois
	 * @param n quatidade de índices para de entries para imprime na tela
	 */
	public void TestLeitura(int n) {
		int j =0;

		while (j<n) {
			for(String[] filds : entries) {
				for(int i = 0 ; i < filds.length ; i++ ) {
					System.out.print(filds[i] +",");
				}
				System.out.println();
				j++;
			}
		}
	}
}
