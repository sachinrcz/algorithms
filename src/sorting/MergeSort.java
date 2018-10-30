package sorting;

public class MergeSort {
	
	public static void sort(Comparable[] a) {
		sort(a,0,a.length-1);
	}
	
	private static void sort(Comparable[] a,int low, int high) {
		if(low<high) {
			int mid = (low+high)/2;
			sort(a,low,mid);
			sort(a,mid+1,high);
			merge(a, low, mid, high);
		}
		
	}
	
	private static void merge(Comparable[] a, int low, int mid, int high) {
		int n1 = mid-low+1;
		int n2 = high-mid;
		Comparable[] L = new Comparable[n1];
		Comparable[] R = new Comparable[n2];
		
		for(int i=0;i<n1;i++) {
			L[i] = a[low+i];
		}
		for(int i=0;i<n2;i++) {
			R[i] = a[mid+1+i];
		}
		
		int i=0;
		int j=0;
		int k=low;
		while(i<n1 && j<n2) {
			if(less(R[j],L[i])) {
				a[k] = R[j];
				j++;
			}else {
				a[k] = L[i];
				i++;
			}
			k++;
		}
		while(i<n1) {
			a[k] = L[i];
			k++;
			i++;
		}
		while(j<n2) {
			a[k] = R[j];
			k++;
			j++;
		}
	
		
	}
	
	private static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}

	


}
