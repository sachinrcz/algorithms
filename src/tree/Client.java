package tree;

public class Client {
	
	public static void main(String[] args) {
		BinarySearchTree<String, Integer> bst = new BinarySearchTree<String, Integer>();
		bst.put("a", 1);
		bst.put("b", 10);
		bst.put("c", 11);
		bst.put("b", 5);
		System.out.println(bst.get("c"));
		System.out.println(bst.get("b"));
	}

}
