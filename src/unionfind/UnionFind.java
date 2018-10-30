package unionfind;

public class UnionFind {
	
	private int[] id;
	private int[] sz;
	
	public UnionFind(int N) {
		id = new int[N];
		sz = new int[N];
		for(int i=0;i<N;i++) {
			id[i] = i;
			sz[i]=1;
		}
		
	}
	
	public void printId() {
		for(int i=0;i<id.length;i++) {
			System.out.print(id[i]+" ");
		}
		System.out.println();
	}
	public void printSize() {
		for(int i=0;i<id.length;i++) {
			System.out.print(sz[i]+" ");
		}
		System.out.println();
	}
	
	private int root(int p) {
		while(id[p] != p) {
			id[p] = id[id[p]];
			p = id[p];
		}
		return p;
	}
	
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		if (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i];}
		else  {id[j]=i; sz[i]+= sz[j];}
		
	}

	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}
}
