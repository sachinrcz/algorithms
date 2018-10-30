import java.util.Iterator;

public class Bag<Item> implements Iterable<Item>{
	private class Node{
		Item item;
		Node next;
	}
	private Node start;
	private int size;
	
	public void add(Item item) {
		Node temp = start;
		start = new Node();
		start.item = item;
		start.next = temp;
		size++;
	}
	
	public int size() {
		return size;
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new BagIterator();
	}
	
	private class BagIterator implements Iterator<Item>{
		private Node current = start;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current!=null;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			Item item = current.item;
			current = current.next;
			return item;
		}
		
	}
	

}
