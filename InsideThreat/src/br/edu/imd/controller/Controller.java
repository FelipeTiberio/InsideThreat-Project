package br.edu.imd.controller;

public class Controller {
	BildPerfil bild = new BildPerfil();
	KeepTrees keep = new KeepTrees();
	AnomalyAnalysis anomaly = new AnomalyAnalysis();
	
	public void createUsers(String wayFile) {
		keep.addUser(bild.buildUser(wayFile));
	}
	
	public void createHttp(String wayFile) {
		keep.addHttp(bild.buildHttp(wayFile));
	}
	
	public void createLogon(String wayFile) {
		keep.addLogon(bild.buildLogon(wayFile));
	}
	
	public void createDevices(String wayFile) {
		keep.addDevices(bild.buildDevices(wayFile));
	}
}
