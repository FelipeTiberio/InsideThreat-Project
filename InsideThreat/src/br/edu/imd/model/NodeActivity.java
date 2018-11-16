package br.edu.imd.model;

import java.util.ArrayList;
import java.util.List;

public class NodeActivity implements Node<Activity,Activity> {
	private  Activity data = null;
	private  NodePc parent  = null;
	private  List<NodeActivity> children = new ArrayList<NodeActivity>();

	public NodeActivity(Activity data) {
		this.data = data;
	}

	public void setParent(NodePc parent) {
		this.parent = parent;
	}

 	public List<NodeActivity> getChildren() {
 		return children;
 	}

 	/**@return retorna o canteÃºdo armazenado em um nÃ³ */
 	public Activity getData() {
 		return data;
 	}

 	/**MÃ©todo usado guarda dados a um nÃ³ */
 	public void setData(Devices data) {
 		this.data = data;
 	}

	public NodePc getParent() {
		return parent;
	}
}
