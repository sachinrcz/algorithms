package priorityqueues;

public class MaxPQ<Key extends Comparable<Key>> {
	
	private Key[] pq;
	private int N;
	
	public MaxPQ(int capacity) {
		pq = (Key[]) new Comparable[capacity+1];
	}
	
	public void insert(Key v) {
		pq[++N] = v;
		swim(N);
	}
	
	public Key delMax() {
		if(isEmpty()) return null;
		Key k = pq[1];
		exchange(1,N);
		N--;
		sink(1);
		pq[N+1]=null;
		return k;
		
	}
	
	public boolean isEmpty() {
		return N==0;
	}
	
	private void sink(int k) {
		while(2*k<N) {
			int j = 2*k;
			if(j<N && less(j,j+1)) j++;
			if(less(j,k)) break;
			exchange(j,k);
			k=j;
		}
	}
	
	private void swim(int k) {
		while(k>1 && less(k/2,k)) {
			exchange(k/2, k);
			k=k/2;
		}
	}
	
	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}
	
	private void exchange(int i, int j) {
		Key temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
	}

}
