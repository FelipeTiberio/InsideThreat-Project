package br.edu.imd.controller;

import br.edu.imd.model.Activity;
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
            
            for(User usuario : users){// Percorre a lista recebida como parêmtro
                NodeUser novoUsuario = new NodeUser(usuario);
                
                if(this.existe_user(novoUsuario)){ // caso o usuário já exista, pula 
                    continue;
                }else{
                    this.addOneUser(usuario); // caso o usuário não exista add novo user
                }
            }
            
	}
	
	// Adiciona a atividade do tipo Http em seu usu�rio especifico, utilizando o m�todo addActivity() 
	// do objeto ProfileTree do user correspondente
	public void addHttp(ArrayList<Http> buildHttp) {
           ProfileTree user;
           for(Http http : buildHttp){
               user =  this.users.get( this.owner_activity(http));
               user.addActivity(http);
           }
            
	}
	// Adiciona a atividade do tipo Logon em seu usu�rio especifico, utilizando o m�todo addActivity() 
	// do objeto ProfileTree do user correspondente
	public void addLogon(ArrayList<Logon> buildLogon) {
          ProfileTree user;
           for(Logon logon : buildLogon){
               user =  this.users.get( this.owner_activity(logon));
               user.addActivity(logon);
           }
	
	}

	// Adiciona a atividade do tipo Devices em seu usu�rio especifico, utilizando o m�todo addActivity()
	// do objeto ProfileTree do user correspondente
	public void addDevices(ArrayList<Devices> buildDevices) {
           ProfileTree user;
           for(Devices dev : buildDevices){
               user =  this.users.get( this.owner_activity(dev));
               user.addActivity(dev);
           }
		
	}
	
	// Retorna o arrayList que armazena as �rvores de cada usu�rio
	public ArrayList<ProfileTree> getUsers(){
		return users;
	}

	// Retorna o arrayList que armazena os perfis m�dios de cada papel
	public ArrayList<NodeUser> getUsersAverangeProfile(){
		return usersAverangeProfile;
	}
        
        
        
        // Mètodo é usando para verificar se um usuráio já existe 
        /**
         * @TODO Lembrar de imprementar o método abaixo
         * @param newUser
         * @return 
         */
        public boolean existe_user(NodeUser newUser){
            return false;
        }
        
        // Método privado usando no método addUser para add de novos usuário a classe keep tree
        private void addOneUser(User newUser){
            this.users.add(new ProfileTree(newUser));
        }
        
        // método retorna o id do dono de uma derterminda atividade 
        // Caso o usuário não esita criar um novo usuário e retorna o seu id
        
        public int owner_activity(Activity novaAtividade){
            int n = 0;
            for(ProfileTree user : users){ // Busca em user quem  é o dono da novaAtividade
                if(user.existeAtividade(novaAtividade)){
                    return n;
                }else{
                    n++;
                }
            }
            return n;
        }
}
