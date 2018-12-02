package br.edu.imd.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe responsável em fazer leitura de arquivos com uma formatação
 * @author Felipe / Matheus
 */
public class LogAnalyzer {
	// Usado para armazenar as linhas dos arquivos
	private List<String[]> entries = new LinkedList<String[]>();
	private FileInputStream filebr = null;

	/**
	 * O método usado para ler uma arquivo scv linha por linha, cada linha é um índice do conteiner entries
	 * @param filename Nome do arquivo a ser lido
	 * @param separate caracter usado para separar as colunas do csv
	 * @throws IOException
	 */
	public void  readFile(String filename, String separate) throws IOException {
		
		entries.clear();
		try {
            System.out.println("Lendo o arquivo:" + filename);
			filebr = new FileInputStream(filename);
                        Scanner scanner = new Scanner(filebr);
                        scanner.useDelimiter("\\n"); 
			String line;
            String filds[];
                        
			while(scanner.hasNext()) {
				line = scanner.next();
                filds = line.split(separate);
                                
				entries.add(filds);
			}
			scanner.close();

		}catch (FileNotFoundException e) {
			System.out.println(e.getLocalizedMessage());
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
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
