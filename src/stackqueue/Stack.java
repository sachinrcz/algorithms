package stackqueue;
import java.util.Iterator;

public class Stack<Item> implements Iterable<Item>{
	
	private Node first = null;
	
	private class Node{
		Item item;
		Node next;
	}
	
	public void push(Item item) {
		Node temp = first;
		first = new Node();
		first.next = temp;
		first.item = item;
	}
	
	public Item pop() {
		Item item = first.item;
		first = first.next;
		return item;
	}
	
	public boolean isEmpty() {
		return first==null;
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item>{
		
		private Node current = first;

		@Override
		public boolean hasNext() {
			 
			return current != null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
		
	}

}
