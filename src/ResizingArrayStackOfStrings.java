
public class ResizingArrayStackOfStrings {
	
	private int N;
	private String[] s;
	
	public ResizingArrayStackOfStrings() {
		s = new String[1];
	}
	
	public void resize(int C) {
		String [] copy = new String[C];
		for(int i=0;i<N;i++) {
			copy[i] = s[i];
		}
		s = copy;
	}
	
	// Double the array size if array is full
	public void push(String item) {
		if(N == s.length) resize(2*s.length);
		s[++N] = item;
	}
	
	
	public String pop() {
		if(N>0 && N==s.length/4) resize(s.length/2);
		String item = s[N];
		s[--N] = null;
		return item;
	}
	

}
