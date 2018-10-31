package graph;

import stackqueue.Stack;

public class DFSPath {
	
	private boolean[] marked;
	private int[] edgeTo;
	private int s;
	
	public DFSPath(Graph G, int S) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = S;
//		DFS(G,S);
		DFSStack(G, S);
	}
	
	
	private void DFS(Graph G, int v) {
		marked[v] = true;
		
		for(int w: G.adj(v)) {
			if(!marked[w]) {
				DFS(G,w);
				edgeTo[w] = v;
				marked[w] = true;
			}
		}		
	}
	
	private void DFSStack(Graph G, int s) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(s);
		marked[s] = true;
		while(!stack.isEmpty()) {
			int v = stack.pop();
			for(int w: G.adj(v)) {
				if(!marked[w]) {
					stack.push(w);
					edgeTo[w] = v;
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
