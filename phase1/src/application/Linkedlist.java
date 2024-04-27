package application;


public class Linkedlist {
	private Nodes first;
	private Nodes last;
	private int count;

	public Linkedlist() {

	}

	public Nodes getFirst() {
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

	public void addFirst(Martyr x) {
		if (count == 0)
			first = last = new Nodes(x);
		else {
			Nodes temp = new Nodes(x);
			temp.next = first;
			first = temp;
		}
		count++;

	}

	public void addLast(Martyr x) {
		if (count == 0)
			first = last = new Nodes(x);
		else {
			Nodes temp = new Nodes(x);
			last.next = temp;
			last = temp;
		}
		count++;

	}

	public void add(Martyr x, int index) {
		if (index == 0)
			addFirst(x);
		if (index >= count)
			addLast(x);
		else {
			Nodes temp = new Nodes(x);
			Nodes current = first;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			temp.next = current.next;
			current.next = temp;
			count++;
		}

	}
//to insert and sort to my list 
	public void addAndSort(Martyr data) {
		Nodes newNode = new Nodes(data);

		if (first == null || newNode.element.getDateOfDeath().compareTo(first.element.getDateOfDeath()) < 0) {
			newNode.next = first;
			first = newNode;
			count++;
		} else {
			Nodes current = first;
			while (current.next != null
					&& newNode.element.getDateOfDeath().compareTo(current.next.element.getDateOfDeath()) >= 0) {
				current = current.next;
			}
			newNode.next = current.next;
			current.next = newNode;
			count++;
		}
	}
//to search of a martyr name
	public Nodes searhName(String name) {
		Nodes current = first;
		if(current==null)
			return null;
		while (current != null) {
			if (name.contains(current.getElement().getName())) {
				return current;

			}
			current = current.next;
		}
		return null;

	}

	public boolean removeFirst() {
		if (count == 0)
			return false;
		else if (count == 1)
			first = last = null;
		else
			first = first.next;
		count--;
		return true;

	}

	public boolean removeLast() {
		if (last == null)
			return false;
		else if (count == 1)
			first = last = null;
		else {
			Nodes current = first;
			for (int i = 0; i < count - 2; i++) {
				current = current.next;
				last = current;
				current.next = null;
			}

		}
		count--;
		return true;
	}

	public boolean remove(int index) {
		if (count == 0)
			return false;
		else if (index == 1)
			return removeFirst();
		else if (index == count)
			return removeLast();
		else if (index <= 0 || index > count)
			return false;
		else {
			Nodes current = first;
			for (int i = 0; i < index - 1; i++)
				current = current.next;
			current.next = (current.next).next;
		}
		count--;
		return true;

	}
//this method to remove martyr
	public boolean remove(Martyr element) {
		Nodes previous = first;
		Nodes current;
		if (first != null) {
			if (element.getName().equals(first.element.getName())) {
				if (first == last)
					first = last = first.next;
				else
					first = first.next;
				count--;
				return true;
			} else
				current = first.next;
		}

		else
			return false;
		for (int i = 0; i < count - 1; i++) {
			if (element.getName().equals(current.element.getName())) {
				previous.next = current.next;
				count--;
				return true;
			} else
				previous = current;
			current = current.next;
		}
		return false;
	}

	public Nodes searchList(Martyr obj) {
		Nodes current = first;
		while ((current != null) && (current.element.equals(obj)))
			current = current.next;
		return current;
	
	}

	public void updateage(Martyr obj, Martyr newObj) {
		Nodes current = first;

		while (current != null) {
			if ((current.element.getAge()) == (obj.getAge())) {
				current.element = newObj;
				break;
			}
			current = current.next;
		}
	}

	public void updatename(Martyr obj, Martyr newObj) {
		Nodes current = first;

		while (current != null) {
			if ((current.element.getName()) == (obj.getName())) {
				current.element = newObj;
				break;
			}
			current = current.next;
		}
	}

	public void updatedate(Martyr obj, Martyr newObj) {
		Nodes current = first;

		while (current != null) {
			if ((current.element.getDateOfDeath()) == (obj.getDateOfDeath())) {
				current.element = newObj;
				break;
			}
			current = current.next;
		}
	}

	public void updategennder(Martyr obj, Martyr newObj) {
		Nodes current = first;

		while (current != null) {
			if ((current.element.getName()) == (obj.getName())) {
				current.element = newObj;
				break;
			}
			current = current.next;
		}
	}
	public String printList() {
	    StringBuilder sb = new StringBuilder();
	    Nodes current = first;
	    while (current != null) {
	        sb.append(current.element.toString()).append("\n");
	        current = current.next;
	    }
	    return sb.toString();
	}


	/*public String printList() {
		String text = " ";
		Nodes current = first;
		for (int i = 0; i < count; i++) {
			text += (current.element + "  ");
			current = current.next;
		}
		return text;
	}*/
}