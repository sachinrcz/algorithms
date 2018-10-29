
public class UFQuickUnion {
	
	public int[] id;
	
	public UFQuickUnion(int N) {
		id = new int[N];
		for(int i=0;i<N;i++) {
			id[i] = i;
		}
	}
	
	public void printId() {
		for(int i=0;i<id.length;i++) {
			System.out.print(id[i]+" ");
		}
	}
	
	private int root(int p) {
		while(id[p] != p) {
			p = id[p];
		}
		return p;
	}
	
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		id[i] = j;
		
	}

	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}
}
