package sorting;

public class QuickSort {
	
	public static void sort(Comparable[] a) {
		sort(a,0,a.length-1);
	}
	
	private static void sort(Comparable[] a,int l, int r) {
		if(l<r) {
			int p = partition(a, l, r);
			sort(a,l,p-1);
			sort(a,p+1,r);
		}
	}
	
	private static int partition(Comparable[] a, int l, int r) {
		Comparable p = a[l];
		int i = l+1;
		for(int j=l+1;j<=r;j++) {
			if(less(a[j],p)) {
				exchange(a, i, j);
				i++;
			}
		}
		exchange(a, l, i-1);
		return i-1;
	}
	
	
	private static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}
	
	
	private static void exchange(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	

}
