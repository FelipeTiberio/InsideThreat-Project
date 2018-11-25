package br.edu.imd.controller;

import br.edu.imd.model.LogAnalyzer;
import br.edu.imd.model.User;
import br.edu.imd.model.Http;
import br.edu.imd.model.Logon;
import br.edu.imd.model.Devices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BildPerfil {
	LogAnalyzer reading = new LogAnalyzer();

	public ArrayList<User> buildUser(String way){
		try {
			reading.readFile(way, ";");
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

	public ArrayList<Http> buildHttp(String way){
		try {
			reading.readFile(way, ";");
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
		List<String[]> data = reading.getEntries();

		ArrayList<Http> http = new ArrayList<Http>();

		String id;
		String date;
		String user;
		String pc;
		String url;

		for(String[] line : data) {
			id 	 = line[0];
			date = line[1];
			user = line[2];
			pc   = line[3];
			url  = line[4];

			Http auxHttp= new Http(id, date, user, pc, url);
			http.add(auxHttp);
		}

		return http;
	}

	public ArrayList<Logon> buildLogon(String way){
		try {
			reading.readFile(way, ";");
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
		List<String[]> data = reading.getEntries();

		ArrayList<Logon> logon = new ArrayList<Logon>();

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

	public ArrayList<Devices> buildDevices(String way){
		try {
			reading.readFile(way, ";");
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
		List<String[]> data = reading.getEntries();

		ArrayList<Devices> device = new ArrayList<Devices>();

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
