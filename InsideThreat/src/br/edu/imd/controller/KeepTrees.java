package br.edu.imd.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import br.edu.imd.model.Activity;
import br.edu.imd.model.NodeUser;
import br.edu.imd.model.User;
import java.util.LinkedList;
import java.util.List;

/**
 * Classe responsável por manter e construir a organização das árvores
 * @author Felipe / Matheus
 */
public class KeepTrees {
	private List<ProfileTree> users = new LinkedList<ProfileTree>();
	private Map<String, NodeUser> usersAverangeProfile = new HashMap<String, NodeUser>();
	
	/**
	 * Adiciona cada usuário recebido no arrayList em um objeto ProfileTree, tendo assim sua ásrvore criada 
	 * @param newUsers ArrayList contendo todos os usuários
	 */
	public void addUser(ArrayList<User> newUsers) {
		for(User usuario : newUsers) {    
			if(this.existUser(usuario.getEmployerName())) { 
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
	public void addActivity(LinkedList<Activity> buildActivity) {
        ProfileTree user;
        for(Activity activity : buildActivity){
            int ArrayIdUser = this.ownerActivity(activity);
            if(ArrayIdUser >= 0 && ArrayIdUser <= this.users.size()-1){
            	user = this.users.get(ArrayIdUser);
            	user.addActivity(activity);
            	this.addActivityAverangeProfile(user.raiz().getData(), activity);
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
    public boolean existUser(String name){
    	if(users.isEmpty()) {
    		return false;
        } else {
            for(ProfileTree auxUser : users) {
            	if(auxUser.raiz().getData().getEmployerName().equals(name)) {
            		return true;
        		}
        	}
        }
    	return false;	
    }
    
    /**
     * Método que adiciona uma atividade a mais no histograma do perfil médio do papel
     * do suário que realizou a atividade
     * @param user usuário a qual o perfil médio do seu papel será adicionado
     * @param activity atividade que foi realizada, importante para obter o horário
     */
    public void addActivityAverangeProfile(User user, Activity activity) {	
    	if(existAverangeProfile(user.getRole())) {
    		String data[] = new String[2];
        	int hora;
        			
        	data = activity.getDate().split(" ");
        	hora = Integer.parseInt(data[1].substring(0, 2));
        	
        	if(user.isContributesAverngeProfile()) {
        		usersAverangeProfile.get(user.getRole()).addToHistogra(1, hora);
        	} else {
        		usersAverangeProfile.get(user.getRole()).addUserHistogram();
        		user.setContributesAverngeProfile(true);
        		usersAverangeProfile.get(user.getRole()).addToHistogra(1, hora);
        	}
    	} else {
    		createAverangeProfile(user.getRole());
    		addActivityAverangeProfile(user, activity);
    	}
    }
    
    /**
     * Método que cria um nono user de perfil médio, caso não exista para o papel específico 
     * @param role o papel a qual será criado o perfil médio representante 
     */
    private void createAverangeProfile(String role) {
    	NodeUser nodeUser = new NodeUser(new User("","","","",""));
    	usersAverangeProfile.put(role, nodeUser);
    }
    
    /**
    * Método responsável para verificar se existe o perfil médio do papel do usário.
    * @param user usuário a qual o papel será verificado.
    * @return boolean que caso o perfil médio exista é verdadeiro, caso contrário, falso
    */
    public boolean existAverangeProfile(String role) {
    	if(usersAverangeProfile.isEmpty()) {
    		return false;
    	} else {
        	for(String userKey : usersAverangeProfile.keySet()) {
        		if(userKey.equals(role)) {
        			return true;
        		}
        	}
    	}
    	return false;	
    }
    
    /**
     * Método que faz a atulização dos valores de todos os histogramas
     */
    public void attHistogram() {
    	for(Map.Entry<String, NodeUser> users : usersAverangeProfile.entrySet()) {
    		users.getValue().attValuesAvernageProfile();
    	}
    }
    
    
    /**
     * Método que a atualização de um hitstograma específico
     * @param role papel a qual perfil médio terá o histograma atualizado
     
    public void attHistogram(String role) {
    	usersAverangeProfile.get(role).attValuesAvernageProfile();
    }
    */
	
	/**
	 *  Retorna o arrayList que armazena as árvores de cada usuário
	 * @return ArrayList com todas as árvores
	 */
	public List<ProfileTree> getUsers(){
		return users;
	}

	/**
	 * Retorna o arrayList que armazena os perfis médios de cada papel
	 * @return ArrayList com todos os perfis médio de cada papel
	 */
	public Map<String, NodeUser> getUsersAverangeProfile(){
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
    /**
     * Retorna o id de uma ProfileTree a partir do nome do user
     * @param nome nome do usuário a ser buscado
     * @return id da ProfileTree do usuário correspondente, caso não exista retorna -1;
     */
    public int searchUser(String name) {
    	int n = 0;
    	for(ProfileTree user : this.users) {
    		if(user.raiz().getData().getEmployerName().equals(name)) {
    			return n;
    		}
    		n++;	
    	}
    	return -1;
    }
}
