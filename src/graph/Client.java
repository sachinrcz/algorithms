package graph;

public class Client {
	
	public static void main(String[] args) {
		Graph g = new Graph(6);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(1, 5);
		g.addEdge(5, 4);
		BFSPath path = new BFSPath(g, 0);
		for(int x: path.pathTo(4)) {
			System.out.print(x+" - ");
		}
	}

}
