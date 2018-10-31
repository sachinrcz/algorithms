package graph;
import stackqueue.Bag;

public class Graph {
	
	private Bag<Integer>[] arr;
	private final int V;
	
	Graph(int V){
		this.V = V;
		arr = (Bag<Integer>[]) new Bag[V];
		for(int i=0;i<V;i++) {
			arr[i] = new Bag<Integer>();
		}
	}
	
	public void addEdge(int v, int w) {
		arr[v].add(w);
		arr[w].add(v);
	}
	
	public int V() {
		return this.V;
	}
	
	public Iterable<Integer> adj(int v){
		return arr[v];
	}

}
