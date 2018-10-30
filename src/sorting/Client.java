package sorting;

public class Client {
	
	public static void main(String[] args) {
		Integer[] a = {4,3,9,-1,0};
//		SelectionSort.sort(a);
		QuickSort.sort(a);
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+ " ");
		}
		
	}

}
