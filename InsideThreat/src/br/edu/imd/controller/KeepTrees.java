package br.edu.imd.controller;

import java.util.ArrayList;

import br.edu.imd.model.Activity;
import br.edu.imd.model.NodeUser;
import br.edu.imd.model.User;

/**
 * Classe responsável por manter e construir a organização das árvores
 * @author Felipe / Matheus
 */
public class KeepTrees {
	private ArrayList<ProfileTree> users = new ArrayList<ProfileTree>();
	private ArrayList<NodeUser> usersAverangeProfile = new ArrayList<NodeUser>();
	
	/**
	 * Adiciona cada usuário recebido no arrayList em um objeto ProfileTree, tendo assim sua ásrvore criada 
	 * @param newUsers ArrayList contendo todos os usuários
	 */
	public void addUser(ArrayList<User> newUsers) {
		for(User usuario : newUsers) {    
			if(this.existUser(usuario)) { 
				continue;
            } else {
            	this.addOneUser(usuario); 
            }
        }
    }
    
    /**
     *  Método privado usando no método addUser para adicionar novos usuários a classe KeepTrees
     * @param newUser O usuário específico a ser adicionado
     */
    private void addOneUser(User newUser){
    	this.users.add(new ProfileTree(newUser));
    }
	
	/**
	 * Adiciona a atividade de qualquer tipo em seu usuário específico, utilizando o método addActivity() 
	 * do objeto ProfileTree do user correspondente
	 * @param buildActivity ArrayList cotendo objetos do tipo activity que serão adicionados no user correspondente
	 */
	public void addActivity(ArrayList<Activity> buildActivity) {
        ProfileTree user;
        for(Activity activity : buildActivity){
            int ArrayIdUser = this.ownerActivity(activity);
            if( ArrayIdUser >= 0 && ArrayIdUser <= this.users.size() -1){
            	user =  this.users.get( ArrayIdUser);
            	user.addActivity(activity);
            } else {
                continue;
            }
        }
	}
	
    /**
     * Método retorna o id do dono de uma derterminda atividade. Caso o usuário não exista, 
     * cria um novo usuário e retorna o seu id 
     * @param activity a atividade a ser analisada
     * @return o id do user que a atividade corresponde, caso não o id do novo usário criado
     */
    public int ownerActivity(Activity activity){
    	int n = 0;
    	for(ProfileTree user : users){ // Busca em user quem  é o dono da novaAtividade
    		if(user.raiz().getData().getUserId().equals(activity.getUser())){
    			return n;
            } else {
                n++;
            }
        }
        // Caso não encontre retorna -1
        return -1;
    }
    
    /**
     * Método é usando para verificar se um usuráio já existe   
     * @param newUser o user a ser verificado
     * @return um valor lógico que caso o usuário exista é verdadeiro, caso contrário, falso
     */
    public boolean existUser(User newUser){
    	if(users.isEmpty()) {
    		return false;
        }
  
        for(ProfileTree auxUser : users) {
        	if(auxUser.raiz().getData().getUserId().equals(newUser.getUserId())) {
        		return true;
    		}
    	}
        
    	return false;	
    }
    
    /**
    * Método responsável para verificar se existe o perfil médio do papel do usário.
    * @param user usuário a qual o papel será verificado.
    * @return boolean que caso o perfil médio exista é verdadeiro, caso contrário, falso
    */
    public boolean searchAverangeProfile(User user) {
    	for(NodeUser auxUser : usersAverangeProfile) {
    		if(auxUser.getData().getUserId().equals(user.getUserId())) {
    			return true;
    		}
    	}
    	return false;	
    }
	
	/**
	 *  Retorna o arrayList que armazena as árvores de cada usuário
	 * @return ArrayList com todas as árvores
	 */
	public ArrayList<ProfileTree> getUsers(){
		return users;
	}

	/**
	 * Retorna o arrayList que armazena os perfis médios de cada papel
	 * @return ArrayList com todos os perfis médio de cada papel
	 */
	public ArrayList<NodeUser> getUsersAverangeProfile(){
		return usersAverangeProfile;
	}
          
	/**
	 * Método que imprime na tela todos os nomes de cada usuário cadastrado
	 */
    public void nome() {
    	for(ProfileTree user : users) {
    		System.out.println(user.raiz().getData().getEmployerName());
    	}
    }
}
