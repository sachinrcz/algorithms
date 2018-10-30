package stackqueue;
/*
 * Array based implementation of Stack with fix capacity
 * 
 */

public class FixedCapacityStackOfStrings {
	
	private String[] s;
	private int N;
	
	public FixedCapacityStackOfStrings(int C) {
		s = new String[C];
	}
	
	public void push(String item) {
		s[N++]=item;
	}
	
	public String pop() {
		String item = s[N];
		s[--N] = null;
		return item;
	}
	
	public boolean isEmplty() {
		return N == 0;
	}
	

}
