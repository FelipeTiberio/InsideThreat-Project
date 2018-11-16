package br.edu.imd.controller;

import br.edu.imd.model.*;



public class Debug {

	public static void main(String[] args) {
		// Criando alguns usuarios para Testar a árvove
		
	NodeUser root = new NodeUser(new User ("Burton M Stephenson","BMS0001","dtaa.com","Burton.M.Stephenson@dtaa.com","Security"));
	NodeTempo tudo = new NodeTempo(new Tempo());
	NodeDevices dv1 = new NodeDevices(new Devices("{S7A7-Y8QZ65MW-8738SAZP}","01/04/2010 07:12:31","DTAA/RES0962","PC-3736","Connect"));
	NodeDevices dv2 = new NodeDevices(new Devices("{S7A7-Y8QZ65MW-8738SAZP}","01/04/2010 07:12:31","DTAA/RES0962","PC-35","Connect"));
	NodeActivity at1 = new NodeActivity(new Http("{M8H9-W9NL75TH-1322KOLO}","01/04/2010 07:08:47","DTAA/AMA0606","PC-1514","http://cnet.com"));
	NodeActivity at2 = new NodeActivity(new Http("{M8H9-W9NL75TH-1322KOLO}","01/04/2010 07:08:47","DTAA/AMA0606","PC-1514","http://TTT.com"));
	
	dv1.addChild(at1);
	dv1.addChild(at2);
	tudo.addChild(dv1);
	tudo.addChild(dv2);
	root.addChild(tudo);
	
	preintTree(root," ");
	
	}
	
	private static <F,T>  void preintTree(Node<F,T> node, String appender) {
		System.out.println(appender + node.getData());
		   //node.getChildren().forEach(each -> preintTree(each, appender + appender));
		for(Node n : node.getChildren()) {
			preintTree(n, appender + appender);
		}
	}
	

}
