package stackqueue;
/*
 * Linked List Implementation of Stack
 * 
 */

public class StackOfStrings {
	
	private Node first = null;
	
	private class Node{
		String item;
		Node next;		
	}
		
	public void push(String item) {
			Node temp = this.first;
			this.first = new Node();
			this.first.next = temp; 
			this.first.item = item;
	}
	
	public String pop() {
		String item = this.first.item;
		this.first = this.first.next;
		return item;
	}
	
	public boolean isEmpty() {
		return this.first == null;
	}
	

}
