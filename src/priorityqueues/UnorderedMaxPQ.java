package priorityqueues;

/*
 * Non-optimized Max Priority Queue 
 * 
 */


public class UnorderedMaxPQ<Key extends Comparable<Key>> {
	
	private Key[] pq;
	private int N;
	
	public UnorderedMaxPQ(int capacity) {
		pq = (Key[]) new Comparable[capacity];
	}
	
	public boolean isEmpty() {
		return N==0;
	}
	
	public void insert(Key v) {
		pq[++N] = v;
	}
	
	public Key delMax() {
		int m = 0;
		for(int i=1;i<N;i++) {
			if(pq[m].compareTo(pq[i]) < 0)	m=i;
		}
		exchange(pq,m,N);
		Key maxKey = pq[N];
		pq[--N] = null;
		return maxKey;
		
	}
	
	private void exchange(Key[] pq, int i, int j) {
		Key temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
	}

}
