package stackqueue;

public class QueueOfStrings {
	
	private class Node{
		String item;
		Node next;
	}
	
	private Node first;
	private Node last;
	
	
	public String dequeue() {
		String item = first.item;
		first = first.next;
		if (isEmpty()) last = null;
		return item;
	}
	
	public void enqueue(String item) {
		Node temp = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if(isEmpty()){
			first = last;
		}else {
			temp.next = last;
		}
	}
	
	public boolean isEmpty() {
		return first==null;
	}

}
