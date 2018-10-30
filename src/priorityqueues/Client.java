package priorityqueues;

public class Client {
	
	public static void main(String[] args) {
		MaxPQ<Integer> pq = new MaxPQ<Integer>(100);
		pq.insert(2);
		pq.insert(-1);
		pq.insert(5);
		pq.insert(0);
		System.out.println(pq.delMax());
		System.out.println(pq.delMax());
		System.out.println(pq.delMax());
		System.out.println(pq.delMax());
		System.out.println(pq.delMax());
		System.out.println(pq.delMax());
	}

}
