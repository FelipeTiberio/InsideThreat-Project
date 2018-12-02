package br.edu.imd.view;

import java.util.Scanner;
import br.edu.imd.controller.Controller;

/**
 * Classe responsável por manter método main com um menu disponibilizando todas as funções do sistema 
 * e chamando os métodos adequados.
 * @author Felipe / Matheus
 */
public class Debug {

	public static void main(String[] args) {

        Controller controle = new Controller();
        Scanner scan = new Scanner(System.in);
     
        String entrada = "";
        
        while(entrada != "0") {
        
        	System.out.println("\n------ DIGITE O NÚMERO CORRESPONDENTE A AÇÃO QUE DESEJA ------");
        	System.out.println("(1)  - CRIAR USUÁRIOS");
        	System.out.println("(2)  - CRIAR ATIVIDADES DE LOGON");
        	System.out.println("(3)  - CRIAR ATIVIDADES DE DEVICES");
        	System.out.println("(4)  - CRIAR ATIVIDADES DE HTTP"); 
        	System.out.println("(5)  - CRIAR ATIVIDADES DE LOGON EM UM PERÍODO ESPECÍFICO");
        	System.out.println("(6)  - CRIAR ATIVIDADES DE DEVICES EM UM PERÍODO ESPECÍFICO");
        	System.out.println("(7)  - CRIAR ATIVIDADES DE HTTP EM UM PERÍODO ESPECÍFICO"); 
        	System.out.println("(8)  - VISUALIZAR ÁRVORE DE UM USUÁRIO");
        	System.out.println("(9)  - COMPARAR HISTOGRAMA DE DOIS USUÁRIOS");
        	System.out.println("(10) - SALVAR ÁRVORE DE TODOS USUÁRIOS EM ARQUIVOS");
        	System.out.println("(11) - SALVAR ÁRVORE DE UM USUÁRIO EM ARQUIVO");
        	System.out.println("(12) - VERIFICAR SE USUÁRIO É UMA ANOMALIA");
        	System.out.println("(13) - VISUALIZAR HISTOGRAMAS DOS PERFIS MÉDIOS");
        	System.out.println("(14) - VISUALIZAR RANKING DOS USUÁRIOS DE UM PAPEL");
        	System.out.println("(0)  - SAIR");
        
        	entrada = scan.nextLine();
        
        	switch(entrada) {
        		case "1": {
        			controle.createUsers("../InsideThreat/Data/LDAP.csv");	
        			System.out.println("\nQuantidade de árvore de usuários cadastrados: " + controle.qtdUsers());
        		}
        			break;
        		case "2": {
        			if(controle.existUsers()) {
        				controle.createLogon("../InsideThreat/Data/logon.csv");
        			} else {
        				System.out.println("Não existe usuários cadastrados.");
        			}
        		}
        			break;
        		case "3": {
        			if(controle.existUsers()){
        				controle.createDevices("../InsideThreat/Data/device.csv");
        			} else {
        				System.out.println("Não existe usuários cadastrados.");
        			}
        		}
        			break;
        		case "4": {
        			if(controle.existUsers()) {
        				controle.createHttp("../InsideThreat/Data/http.csv");
        			} else {
        				System.out.println("Não existe usuários cadastrados.");
        			}	
        		}
        			break;
        		case "5": {
        			if(controle.existUsers()) {
        				try{
        					System.out.println("Digite a data inicial: ");
        					String dateOne = scan.nextLine();
        					System.out.println("Digite a data final: ");
        					String finalDate = scan.nextLine();
        					controle.createLogon("../InsideThreat/Data/logon.csv", dateOne, finalDate);
        				} catch(Exception e) {
        					e.getMessage();
        				}
        			} else {
        				System.out.println("Não existe usuários cadastrados.");
        			}
        		}
        			break;
        		case "6": {
        			if(controle.existUsers()) {
        				try{
        					System.out.println("Digite a data inicial: ");
        					String dateOne = scan.nextLine();
        					System.out.println("Digite a data final: ");
        					String finalDate = scan.nextLine();
        					controle.createDevices("../InsideThreat/Data/device.csv", dateOne, finalDate);
        				} catch(Exception e) {
        					e.getMessage();
        				} 
        			} else {
        				System.out.println("Não existe usuários cadastrados.");
        			}
        		}
        			break;
        		case "7": {
        			if(controle.existUsers()) {
        				try{
        					System.out.println("Digite a data inicial: ");
        					String dateOne = scan.nextLine();
        					System.out.println("Digite a data final: ");
        					String finalDate = scan.nextLine();
        					controle.createHttp("../InsideThreat/Data/http.csv", dateOne, finalDate);
        				} catch(Exception e) {
        					e.getMessage();
        				}
        			} else {
        				System.out.println("Não existe usuários cadastrados.");
        			}
        		}
        			break;
        		case "8": {
        			if(controle.existUsers()) {
        				System.out.println("Digite o nome do usuário que deseja visualizar a árovre: ");
        				try {
        					controle.viewUser(scan.nextLine());	
        				} catch(Exception e) {
        					e.getMessage();
        				}
        			} else {
        				System.out.println("Não existe usuários cadastrados.");
        			}
        		}
        			break;
        		case "9": {
        			if(controle.existUsers()) {
        				try {
        					System.out.println("Digite o nome do primeiro usuário: ");
        					String nameOne = scan.nextLine();
        					System.out.println("Digite o nome do segundo usuário: ");
        					String nameTwo = scan.nextLine();
        					controle.compareUsers(nameOne, nameTwo);	
        				} catch(Exception e) {
        					e.getMessage();
        				}
        			} else {
        				System.out.println("Não existe usuários cadastrados.");
        			}
        		}
        			break;
        		case "10": {
        			if(controle.existUsers()) {
        				try {
        					controle.saveForest();
        				} catch(Exception e) {
        					e.getMessage();
        				}
        			} else {
        				System.out.println("Não existe usuários cadastrados.");
        			}
        		}
        			break;
        		case "11": {
        			if(controle.existUsers()) {
        				try {
        					System.out.println("Digite o nome do usuário que deseja salvar seus dados: ");
        					controle.saveProfile(scan.nextLine());
        				} catch(Exception e) {
        					e.getMessage();
        				}
        			} else {
        				System.out.println("Não existe usuários cadastrados.");
        			}
        		}
        			break;
        		case "12": {
        			if(controle.existUsers()) {
        				try {
        					System.out.println("Digite o nome do usuário que deseja verificar se é uma anomalia: ");
        					controle.searchAnomaly(scan.nextLine());
        				} catch(Exception e) {
        					e.getMessage();
        				}
        			} else {
        				System.out.println("Não existe usuários cadastrados.");
        			}
        		}
        			break;
        		case "13": {
        			if(controle.existUsers()) {
        				controle.viewAllAverangeProfile();
        			} else {
        				System.out.println("Não existe usuários cadastrados.");
        			}
        		}
        			break;
        		case "14": {
        			if(controle.existUsers()) {
        				try {
        					System.out.println("Digite o nome do papel que deseja visualizaro ranking: ");
        					controle.showRanking(scan.nextLine());
        				} catch(Exception e) {
        					e.getMessage();
        				}
        			} else {
        				System.out.println("Não existe usuários cadastrados.");
        			}
        		}
        			break;
        		case "0":
        			System.out.println("Até a próxima!");
        			System.exit(0);
        		default: {
        			System.out.println("Digite um valor válido, seguindo a lista disponibilizada.");
        		}
        	}
        }
        scan.close();
    }
}