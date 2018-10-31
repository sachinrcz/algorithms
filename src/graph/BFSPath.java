package graph;

import stackqueue.Queue;
import stackqueue.Stack;

public class BFSPath {
	
	private boolean[] marked;
	private int s;
	private int[] edgeTo;
	
	public BFSPath(Graph G, int S) {
		edgeTo = new int[G.V()];
		marked = new boolean[G.V()];
		this.s = S;
		BFS(G,S);
		
	}
	
	private void BFS(Graph g, int v) {
		Queue<Integer> q = new Queue<Integer>();
		q.enqueue(v);
		marked[v] = true;
		while(!q.isEmpty()) {
			int x = q.dequeue();
			for(int w: g.adj(x)) {
				if(!marked[w]) {
					q.enqueue(w);
					edgeTo[w] = x;
					marked[w] = true;
				}
			}
		}
		
	}
	
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v)) return null;
		Stack<Integer> stack = new Stack<Integer>();
		for(int x=v;x!=s; x=edgeTo[x]) {
			stack.push(x);
		}
		stack.push(s);
		return stack;
		
	}
	
	
}
