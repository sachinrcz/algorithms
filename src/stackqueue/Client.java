package stackqueue;

public class Client {
	
	static void stacktest() {
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(2);
		s.pop();
		s.push(3);
		s.pop();
		s.pop();
		for(Integer i: s) {
			System.out.println(i);
		}
		
	}
	
	static void queuetest() {
		Queue<String> q = new Queue<String>();
		q.enqueue("l");
		q.enqueue("a");
		q.enqueue("m");
		q.dequeue();
		q.dequeue();
		for(String s:q) {
			System.out.println(s);
		}
	}
	
	public static void main(String[] args) {
		Bag<Double> bag = new Bag<Double>();
		bag.add(0.0);
		bag.add(1.2);
		for(Double b:bag) {
			System.out.println(b);
		}
	}

}
