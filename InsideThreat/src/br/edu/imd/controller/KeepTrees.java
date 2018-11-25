package br.edu.imd.controller;

import java.util.ArrayList;

import br.edu.imd.model.Devices;
import br.edu.imd.model.Http;
import br.edu.imd.model.Logon;
import br.edu.imd.model.NodeUser;
import br.edu.imd.model.User;

public class KeepTrees {
	ArrayList<ProfileTree> users;
	ArrayList<NodeUser> usersAverangeProfile;
	
	// Adiciona cada usu�rio recebido no arrayList em um objeto ProfileTree, tendo assim sua �rvore criada 
	public void addUser(ArrayList<User> users) {
		
	}
	
	// Adiciona a atividade do tipo Http em seu usu�rio especifico, utilizando o m�todo addActivity() 
	// do objeto ProfileTree do user correspondente
	public void addHttp(ArrayList<Http> buildHttp) {
	
	}

	// Adiciona a atividade do tipo Logon em seu usu�rio especifico, utilizando o m�todo addActivity() 
	// do objeto ProfileTree do user correspondente
	public void addLogon(ArrayList<Logon> buildLogon) {
	
	}

	// Adiciona a atividade do tipo Devices em seu usu�rio especifico, utilizando o m�todo addActivity()
	// do objeto ProfileTree do user correspondente
	public void addDevices(ArrayList<Devices> buildDevices) {
		
	}
	
	// Retorna o arrayList que armazena as �rvores de cada usu�rio
	public ArrayList<ProfileTree> getUsers(){
		return users;
	}

	// Retorna o arrayList que armazena os �suarios de perfil m�dio de cada papel
	public ArrayList<NodeUser> getUsersAverangeProfile(){
		return usersAverangeProfile;
	}
}
