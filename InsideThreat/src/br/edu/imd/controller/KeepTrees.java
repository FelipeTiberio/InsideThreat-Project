package br.edu.imd.controller;

import java.util.ArrayList;

import br.edu.imd.model.NodeUser;

public class KeepTrees {
	ArrayList<ProfileTree> users;
	ArrayList<NodeUser> usersAverangeProfile;
	
	public ArrayList<ProfileTree> getUsers(){
		return users;
	}
	
	public ArrayList<NodeUser> getUsersAverangeProfile(){
		return usersAverangeProfile;
	}
}
