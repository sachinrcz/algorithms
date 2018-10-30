package unionfind;

public class UnionFindTest {
	
	public static void main(String[] args) {
		UnionFind uf = new UnionFind(10);
		uf.printId();
		uf.printSize();
		System.out.println(uf.connected(0, 1));
		uf.union(0, 1);
		System.out.println(uf.connected(0, 1));		
		uf.printId();
		uf.printSize();
		uf.union(1, 2);
		uf.printId();
		uf.printSize();
		System.out.println(uf.connected(0, 2));	
	}

}
