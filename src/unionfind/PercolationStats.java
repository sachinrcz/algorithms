package unionfind;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
	
	private final double[] thr ;
	
	private final double trials;
	
	private double mean;
	private double stddev;
	
	public PercolationStats(int n, int trials) {
		if(n<=0 || trials<=0) {
			throw new java.lang.IllegalArgumentException();
		}
		this.trials = Double.valueOf(trials);
		thr = new double[trials];
		
		for(int i=0;i<trials;i++) {
			Percolation p = new Percolation(n);
			while(!p.percolates()) {
				int row = StdRandom.uniform(1, n+1);
				int col = StdRandom.uniform(1, n+1);
				if(!p.isOpen(row, col)) p.open(row,col);				
//				System.out.println(row+" "+col);
			}
			thr[i] = Double.valueOf(p.numberOfOpenSites())/(n*n);
//			System.out.println(thr[i]);
		}
		
	}
	
	public double mean()  {
		this.mean = StdStats.mean(thr);
		
		return this.mean;
	}
	public double stddev() {
		this.stddev = StdStats.stddev(thr);
		return this.stddev;
	}
	public double confidenceLo() {
		
		double mean = StdStats.mean(thr);
		double std = StdStats.stddev(thr);
		
		return mean - (1.96*std/Math.sqrt(this.trials));
	}
	public double confidenceHi() {
		double mean = StdStats.mean(thr);
		double std = StdStats.stddev(thr);
		
		return mean + (1.96*std/Math.sqrt(this.trials));
	}
	public static void main(String[] args) {
//		int n = 200;
//		int trials = 100;
		int n = Integer.parseInt(args[0]);
		int trials = Integer.parseInt(args[1]);
		PercolationStats st = new PercolationStats(n, trials);
		
//		System.out.println("mean: "+st.mean());
//		System.out.println("stddev: "+st.stddev());
		System.out.println("95% confidence interval: ["+st.confidenceLo()+", "+st.confidenceHi()+"]");
//		st.stddev(); st.stddev() ;st.confidenceHi(); st.confidenceHi(); st.mean();st.confidenceHi(); st.stddev();
//		System.out.println("95% confidence interval: ["+st.confidenceLo()+", "+st.confidenceHi()+"]");
		
	}
	

}
