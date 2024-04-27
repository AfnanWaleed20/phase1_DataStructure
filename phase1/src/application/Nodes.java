package application;
//this class to node of single linked list
public class Nodes {
	
		Martyr element;
	      Nodes next;
	     
	      
	public Nodes(Martyr x) {
	element=x;
	}


	public Nodes() {

	}


	public Martyr getElement() {
		return element;
	}


	public void setElement(Martyr element) {
		this.element = element;
	}


	@Override
	public String toString() {
		return "Node [element=" + element + ", next=" + next + "]";
	}
	}

