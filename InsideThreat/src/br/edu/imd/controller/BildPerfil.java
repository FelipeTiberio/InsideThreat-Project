package br.edu.imd.controller;

import br.edu.imd.model.LogAnalyzer;
import br.edu.imd.model.User;
import br.edu.imd.model.Http;
import br.edu.imd.model.Logon;
import br.edu.imd.model.Activity;
import br.edu.imd.model.Devices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

/**
 * Classe responsável em coletar as informações dos arquivos e criar os objetos user, http, logon e devices.
 * @author Matheus / Felipe
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
		User user;

		for(String[] line : data) {
			if(!line[0].equals("employee_name")) {
				employer_name = line[0];
				user_id 	  = line[1];
				email		  = line[2];
				domain 		  = line[3];
				role 		  = line[4].replace(line[4].substring(line[4].length()-1, line[4].length()),"");

				user = new User(employer_name, user_id, email, domain, role.replace(role.substring(role.length()-1, role.length()),""));
				users.add(user);
			}
		}
		return users;
	}
	
	/**
	 * Método responsável em coletar as informações do arquivo específico e criar os objetos http.
	 * @param way caminho do arquivo onde será coletados os dados.
	 * @return LinkedList com todos os objetos Http criados.
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
			if(!line[0].equals("id")) {
				id 	 = line[0];
				date = line[1];
				user = line[2];
				pc   = line[3];
				url  = line[4].replace(line[4].substring(line[4].length()-1, line[4].length()),"");

				auxHttp = new Http(id, date, user, pc, url);
				http.add(auxHttp);
			}
		}
		return http;
	}
	
	/**
	 * Método responsável em coletar as informações do arquivo específico e criar os objetos http,
	 * em um período de tempo específico.
	 * @param way caminho do arquivo onde será coletados os dados.
	 * @param startDate data inicial do prazo.
	 * @param finalDate data final do prazo.
	 * @return LinkedList com todos os objetos Http criados.
	 */
	public LinkedList<Activity> buildHttp(String way, String startDate, String finalDate){
		try {
			reading.readFile(way, ",");
			System.out.println("Voltou da leitura");
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
		
		List<String[]> data = reading.getEntries();
		LinkedList<Activity> http = new LinkedList<Activity>();
		
		String datas[] = new String[2];
		Calendar start = new GregorianCalendar(Integer.parseInt(startDate.substring(6)), Integer.parseInt(startDate.substring(0,2)),
								Integer.parseInt(startDate.substring(3,5)));
		Calendar end = new GregorianCalendar(Integer.parseInt(finalDate.substring(6)), Integer.parseInt(finalDate.substring(0,2)),
								Integer.parseInt(finalDate.substring(3,5)));
		Calendar auxDate;

		String id;
		String date;
		String user;
		String pc;
		String url;
        Http auxHttp;
                
		for(String[] line : data) {
			if(!line[0].equals("id")) {
				datas = line[1].split(" ");
				auxDate = new GregorianCalendar(Integer.parseInt(datas[0].substring(6)), Integer.parseInt(datas[0].substring(0, 2)),
									Integer.parseInt(datas[0].substring(3, 5)));
				
				if(!auxDate.before(start) && !auxDate.after(end)) {
					id 	 = line[0];
					date = line[1];
					user = line[2];
					pc   = line[3];
					url  = line[4].replace(line[4].substring(line[4].length()-1, line[4].length()),"");

					auxHttp = new Http(id, date, user, pc, url);
					http.add(auxHttp);
				}
			}
		}
		return http;
	}
	
	/**
	 * Método responsável em coletar as informações do arquivo específico e criar os objetos logon.
	 * @param way caminho do arquivo onde será coletados os dados.
	 * @return LinkedList com todos os objetos Logon criados.
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
		Logon auxLogon;
		
		for(String[] line : data) {
			if(!line[0].equals("id")) {
				id   	 = line[0];
				date 	 = line[1];
				user 	 = line[2];
				pc       = line[3];
				activity = line[4].replace(line[4].substring(line[4].length()-1, line[4].length()),"");

				auxLogon = new Logon(id, date, user, pc, activity);
				logon.add(auxLogon);
			}
		}
		return logon;
	}
	
	/**
	 * Método responsável em coletar as informações do arquivo específico e criar os objetos logon,
	 * em um período de tempo específico.
	 * @param way caminho do arquivo onde será coletados os dados.
	 * @param startDate data inicial do prazo.
	 * @param finalDate data final do prazo.
	 * @return LinkedList com todos os objetos Logon criados.
	 */
	public LinkedList<Activity> buildLogon(String way, String startDate, String finalDate){
		try {
			reading.readFile(way, ",");
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
		
		List<String[]> data = reading.getEntries();		
		LinkedList<Activity> logon = new  LinkedList<Activity>();
		
		String datas[] = new String[2];
		Calendar start = new GregorianCalendar(Integer.parseInt(startDate.substring(6)), Integer.parseInt(startDate.substring(0,2)),
								Integer.parseInt(startDate.substring(3,5)));
		Calendar end = new GregorianCalendar(Integer.parseInt(finalDate.substring(6)), Integer.parseInt(finalDate.substring(0,2)),
								Integer.parseInt(finalDate.substring(3,5)));
		Calendar auxDate;
		
		String id;
		String date;
		String user;
		String pc;
		String activity;
		Logon auxLogon;
		
		for(String[] line : data) {
			if(!line[0].equals("id")) {
				datas = line[1].split(" ");
				auxDate = new GregorianCalendar(Integer.parseInt(datas[0].substring(6)), Integer.parseInt(datas[0].substring(0, 2)),
									Integer.parseInt(datas[0].substring(3, 5)));
				
				if(!auxDate.before(start) && !auxDate.after(end)) {
					id   	 = line[0];
					date 	 = line[1];
					user 	 = line[2];
					pc       = line[3];
					activity = line[4].replace(line[4].substring(line[4].length()-1, line[4].length()),"");

					auxLogon = new Logon(id, date, user, pc, activity);
					logon.add(auxLogon);
				}
			}
		}
		return logon;
	}
	
	/**
	 * Método responsável em coletar as informações do arquivo específico e criar os objetos devices.
	 * @param way caminho do arquivo onde será coletados os dados.
	 * @return LinkedList com todos os objetos Devices criados.
	 */
	public LinkedList<Activity> buildDevices(String way){
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
		Devices auxDevice;

		for(String[] line : data) {
			if(!line[0].equals("id")) {
				id 		 = line[0];
				date 	 = line[1];
				user 	 = line[2];
				pc 		 = line[3];
				activity = line[4].replace(line[4].substring(line[4].length()-1, line[4].length()),"");

				auxDevice = new Devices(id, date, user, pc, activity);
				device.add(auxDevice);
			}
		}
		return device;
	}
	
	/**
	 * Método responsável em coletar as informações do arquivo específico e criar os objetos devices,
	 * em um período de tempo específico.
	 * @param way caminho do arquivo onde será coletados os dados.
	 * @param startDate data inicial do prazo.
	 * @param finalDate data final do prazo.
	 * @return LinkedList com todos os objetos Devices criados.
	 */
	public LinkedList<Activity> buildDevices(String way, String startDate, String finalDate){
		try {
			reading.readFile(way, ",");
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
		
		List<String[]> data = reading.getEntries();
		LinkedList<Activity> device = new  LinkedList<Activity>();
		
		String datas[] = new String[2];
		Calendar start = new GregorianCalendar(Integer.parseInt(startDate.substring(6)), Integer.parseInt(startDate.substring(0,2)),
									Integer.parseInt(startDate.substring(3,5)));
		Calendar end = new GregorianCalendar(Integer.parseInt(finalDate.substring(6)), Integer.parseInt(finalDate.substring(0,2)),
									Integer.parseInt(finalDate.substring(3,5)));
		Calendar auxDate;

		String id;
		String date;
		String user;
		String pc;
		String activity;
		Devices auxDevice;

		for(String[] line : data) {
			if(!line[0].equals("id")) {
				datas = line[1].split(" ");
				auxDate = new GregorianCalendar(Integer.parseInt(datas[0].substring(6)), Integer.parseInt(datas[0].substring(0, 2)),
									Integer.parseInt(datas[0].substring(3, 5)));
				
				if(!auxDate.before(start) && !auxDate.after(end)) {
					id 		 = line[0];
					date 	 = line[1];
					user 	 = line[2];
					pc 		 = line[3];
					activity = line[4].replace(line[4].substring(line[4].length()-1, line[4].length()),"");

					auxDevice = new Devices(id, date, user, pc, activity);
					device.add(auxDevice);
				}
			}
		}
		return device;
	}

}
