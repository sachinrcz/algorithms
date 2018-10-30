import java.util.Iterator;

public class Queue<Item> implements Iterable<Item>{
	private Node first;
	private Node last;
	
	private class Node{
		Item item;
		Node next;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public Item dequeue() {
		Item item = first.item;
		first = first.next;
		if(isEmpty()) last =null;
		return item;
	}
	
	public void enqueue(Item item) {
		Node temp = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if(isEmpty()) first = last;
		else temp.next = last;
				
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
			
			return current!=null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
		
	}	

}
