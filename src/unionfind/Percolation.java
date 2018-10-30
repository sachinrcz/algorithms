package unionfind;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	
	private int[][] site;
	private int opens = 0;
	private final int N ;
	
	private final WeightedQuickUnionUF uf;
	
	public Percolation(int n) {
		if(n<=0) {
			throw new java.lang.IllegalArgumentException();
		}
		
		this.N = n;
		uf = new WeightedQuickUnionUF(n*n+2);
		site = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				site[i][j] = 0;
			}			
		}
	}
	
	private int getIndex(int row, int col) {
		if (row<1 || row>this.N || col<1 || col>this.N) {
			return -1;
		}
		int index = (row-1)*this.N + col;
		return index;
	}
	
	private void checkRowCol(int row, int col) {
		if(row<=0 || col<=0 || row >this.N || col >this.N) {
			throw new java.lang.IllegalArgumentException();
		}
	}
	
	
	public void open(int row,int col) {
		checkRowCol(row, col);
		if(site[row-1][col-1] == 0) {
			site[row-1][col-1] = 1;
			opens++;
			int up = getIndex(row-1, col);
			int down = getIndex(row+1,col);
			int left = getIndex(row,col-1);
			int right = getIndex(row, col+1);
			int s = getIndex(row,col);
			if(up != -1 && site[row-2][col-1] == 1) uf.union(s, up);
			if(down != -1 && site[row][col-1] == 1) uf.union(s, down);
			if(left != -1 && site[row-1][col-2] == 1) uf.union(s, left);
			if(right != -1 && site[row-1][col] == 1) uf.union(s, right);
			if(row == 1) uf.union(0, s);
			if(row == this.N) uf.union(this.N*this.N+1, s);
		}
	}
	
	public boolean isOpen(int row, int col) {
		checkRowCol(row, col);
		return site[row-1][col-1] == 1;
	}
	
	public boolean isFull(int row, int col) {
		checkRowCol(row, col);
		int index = getIndex(row, col);
		return uf.connected(0, index);
	}
	
	public int numberOfOpenSites() {
		return opens;
	}
	
	public boolean percolates() {
		
		return uf.connected(0, this.N*this.N+1);
	}
	

}
