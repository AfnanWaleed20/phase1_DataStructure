package application;

public class DoubleLinkedlist {
	private Node first;
	private Node last;
	private int count;

	public DoubleLinkedlist() {
		super();
	}

	public Node getFirst() {
		if (count == 0)
			return null;
		else
			return first;

	}

	public Object getLast() {
		if (count == 0)
			return null;
		else
			return last.element;
	}

	public void addFirst(Object x) {
		if (count == 0)
			first = last = new Node(x);
		else {
			Node temp = new Node(x);
			first.prev = temp;
			temp.next = first;
			first = temp;
		}
		count++;

	}

	public Node addLast(Object x) {
		if (count == 0)
			first = last = new Node(x);
		else {
			Node temp = new Node(x);
			temp.prev = last;
			last.next = temp;
			last = temp;
		}
		count++;
return last;
	}

	public void add(Object x, int index) {
		if (index == 0)
			addFirst(x);
		if (index >= count)
			addLast(x);
		else {
			Node temp = new Node(x);
			Node current = first;
			for (int i = 0; i < index; i++) {
				current = current.next;
				temp.next = current;
				temp.prev = current.prev;
				current.prev = temp;
				(temp.prev).next = temp;
				temp.next = current.next;
				current.next = temp;
			}
			count++;

		}
	}

	public boolean removeFirst() {
		if (count == 0)
			return false;
		else if (count == 1)
			first = last = null;
		else
			first = first.next;
		first.prev = null;
		count--;
		return true;

	}

	public boolean removeLast() {
		if (last == null)
			return false;
		else if (count == 1)
			first = last = null;
		else {
			Node current = first;
			for (int i = 0; i < count - 1; i++) {
				last = current.prev;
				last = null;

			}

			count--;
		}
		return true;
	}

	public boolean remove(int index) {
		if (index == 1) {
			if (count == 1) {
				first = last = null;
				count = 0;
				return true;
			}
			first = first.next;
			first.prev = null;
			count--;
			return true;
		}
		if (index == count) {
			last = last.prev;
			last.next = null;
			count--;
		}
		Node temp = first.next;
		for (int i = 2; i <= count; i++) {
			if (i == index) {
				Node p = temp.prev;
				Node n = temp.next;
				p.next = n;
				n.prev = p;
				count--;
				return true;
			}
			temp = temp.next;
		}
		return true;
	}
//this method to remove location from your list
	public void removeobj(Location element) {
		if (first == null) {
            return;
        }

        Node current =first;

        
        while (current != null && !current.element.getLocation().equals(element.getLocation())) {
            current = current.next;
        }

        if (current == null) {
            return; 
        }

        if (current == first) {
            first = current.next;
	}
        if (current.prev != null) {
            current.prev.next = current.next; 
        }

        if (current.next != null) {
            current.next.prev = current.prev; 
        }
    }
//this method to make a insert and sort to double linked  list
	public Node insertAndSort(Location point) {
	    Node newNode = new Node(point);
System.out.println("ho");
	    if (first == null) {
	        first = last = newNode;
	        count++;
	        return newNode;
	    } else if (first.element.getLocation().compareTo(point.getLocation()) >= 0) {
	        newNode.next = first;
	        first.prev = newNode;
	        first = newNode;
	        count++;
	        return newNode;

	    } else if (last.element.getLocation().compareTo(point.getLocation()) >= 0) {
	        return addLast(point);
	    } else {
	        Node current = first;

	        while (current.next != null && current.next.element.getLocation().compareTo(point.getLocation()) < 0) {
	            current = current.next;
	            System.out.println("here");
	        }
	        
	        newNode.next = current.next;
	        if (current.next != null) {
	            newNode.next.prev= newNode;
	            System.out.println("here2");
	        }
	        current.next = newNode;
	        newNode.prev = current;
	        count++;
	        System.out.println("her3");
	        return newNode;
	    }
	}
	// this method to search in linked list to find the object
	public Node search(Location pos) {
		Node current = first;
		if (current == null) {
			return null;
		} else {
			while (current != null) {
				if (current.element.getLocation().equals(pos.getLocation())) {
					return current;
				}
				current = current.next;
			}
		}
		return null;
	}
//this method to make a update to location
	public void update(String oldPoint, String newPoint) {
		Node current = first;
		Node index = current.next;
		while (current != null) {
			if (current.element.getLocation().equals(oldPoint)) {
				current.element.setLocation(newPoint);
			
			}
			current = current.next;
		}
	}
//this method to print the data
	public void printList() {
		if (count == 0) {
			System.out.print("empty");
			return;
		}
		if (first.next == null) {
			System.out.println(first.element);
			return;
		}
		Node temp = first;
		System.out.println(first.element + " ");
		temp = first.next;
		while (temp.next != null) {
			System.out.print(temp.element + " ");
			temp = temp.next;
		}
		System.out.print(temp.element);
	
	}

}
