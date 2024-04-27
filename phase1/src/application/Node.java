package application;
//this class to node of doublelinked list
public class Node {
	Location element=new Location();
	Linkedlist list = new Linkedlist();
	Node next,prev;
    
      
public Node(Object x) {
element=(Location) x;
}

public Node() {
	super();
	
}


public Linkedlist getList() {
	if (list == null) {
		return new Linkedlist();
	}
	else
	return list;
}

public void setList(Linkedlist list) {
	this.list = list;
}

@Override
public String toString() {
	return "Node [element=" + element + ", next=" + next + "]";
}


}
