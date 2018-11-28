package br.edu.imd.controller;

import br.edu.imd.model.LogAnalyzer;
import br.edu.imd.model.User;
import br.edu.imd.model.Http;
import br.edu.imd.model.Logon;
import br.edu.imd.model.Activity;
import br.edu.imd.model.Devices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Classe responsável em coletar as informações dos arquivos e criar os objetos user, http, logon e devices.
 * @author Matheus
 *
 */
public class BildPerfil {
	LogAnalyzer reading = new LogAnalyzer();

	/**
	 * Método responsável em coletar as informações do arquivo específico e criar os objetos users.
	 * @param way caminho do arquivo onde será coletados os dados.
	 * @return ArrayList com todos os objetos users criados.
	 */
	public ArrayList<User> buildUser(String way){
		try {
			reading.readFile(way, ",");
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
		List<String[]> data = reading.getEntries();

		ArrayList<User> users = new ArrayList<User>();

		String employer_name;
		String user_id;
		String email;
		String domain;
		String role;

		for(String[] line : data) {
			employer_name = line[0];
			user_id 	  = line[1];
			email		  = line[2];
			domain 		  = line[3];
			role 		  = line[4];

			User user = new User(employer_name, user_id, email, domain, role);
			users.add(user);
		}
		return users;
	}
	
	/**
	 * Método responsável em coletar as informações do arquivo específico e criar os objetos http.
	 * @param way caminho do arquivo onde será coletados os dados.
	 * @return ArrayList com todos os objetos users criados.
	 */
	public LinkedList<Activity> buildHttp(String way){
		try {
			reading.readFile(way, ",");
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
		List<String[]> data = reading.getEntries();

		LinkedList<Activity> http = new LinkedList<Activity>();

		String id;
		String date;
		String user;
		String pc;
		String url;
                Http auxHttp;
                
		for(String[] line : data) {
			id 	 = line[0];
			date = line[1];
			user = line[2];
			pc   = line[3];
			url  = line[4];

			auxHttp= new Http(id, date, user, pc, url);
			http.add(auxHttp);
		}
                System.out.println("Terminei a leitura do arquivo");
		return http;
	}
	
	/**
	 * Método responsável em coletar as informações do arquivo específico e criar os objetos logon.
	 * @param way caminho do arquivo onde será coletados os dados.
	 * @return ArrayList com todos os objetos users criados.
	 */
	public  LinkedList<Activity> buildLogon(String way){
		try {
			reading.readFile(way, ",");
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
		List<String[]> data = reading.getEntries();

		 LinkedList<Activity> logon = new  LinkedList<Activity>();

		String id;
		String date;
		String user;
		String pc;
		String activity;

		for(String[] line : data) {
			id   	 = line[0];
			date 	 = line[1];
			user 	 = line[2];
			pc       = line[3];
			activity = line[4];

			Logon auxLogon= new Logon(id, date, user, pc, activity);
			logon.add(auxLogon);
		}

		return logon;
	}
	
	/**
	 * Método responsável em coletar as informações do arquivo específico e criar os objetos devices.
	 * @param way caminho do arquivo onde será coletados os dados.
	 * @return ArrayList com todos os objetos users criados.
	 */
	public  LinkedList<Activity> buildDevices(String way){
		try {
			reading.readFile(way, ",");
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
		List<String[]> data = reading.getEntries();

		 LinkedList<Activity> device = new  LinkedList<Activity>();

		String id;
		String date;
		String user;
		String pc;
		String activity;

		for(String[] line : data) {
			id 		 = line[0];
			date 	 = line[1];
			user 	 = line[2];
			pc 		 = line[3];
			activity = line[4];

			Devices auxDevice = new Devices(id, date, user, pc, activity);
			device.add(auxDevice);
		}

		return device;
	}

}
