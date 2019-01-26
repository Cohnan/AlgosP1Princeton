/**
 * A class whose objects represent the material, it knows nothing about the probability of openness
 */

/**
 * @author cohnan
 *
 */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	
	private int length;
	private int nOpen;
	// create n-by-n grid, with all sites blocked
	private boolean[][] siteMatrix;
	private WeightedQuickUnionUF connectivity;
	
	
	
	public Percolation(int n) {
		//Java, by default, initializes arrays with null or 0 like values.
		length = n;
		siteMatrix = new boolean[n][n];
		nOpen = 0;
		connectivity = new WeightedQuickUnionUF(n*n + 2);
		
		// Set up virtual nodes and their connections as points labeled 0 and n*n + 1 (first and last)
		// So, I have available the positions 1 through n^2
		// NO: it makes problems if I have a 1 by 1 array and is unnecessary. Make the connections once
		// on of the border nodes are opened.
	}
	
	// open site (row, col) if it is not open already
	public    void open(int row, int col) { 
		//Open site and increment n of open sites
		if(!siteMatrix[row - 1][col - 1]) {
			siteMatrix[row - 1][col - 1]= true;
			nOpen += 1;
		}
		// Connect to virtual nodes if this is an external site.
		if (row == 1)      connectivity.union(0                , indexConversion(row, col));
		if (row == length) connectivity.union(length*length + 1, indexConversion(row, col));
		
		// Connect to open neighbor sites
		if ((row - 1) - 1 >= 0        && siteMatrix[(row - 1) - 1][(col - 1) + 0]) {
			connectivity.union(indexConversion(row, col), indexConversion(row - 1, col));
		}
		if ((col - 1) - 1 >= 0        && siteMatrix[(row - 1) + 0][(col - 1) - 1]) {
			connectivity.union(indexConversion(row, col), indexConversion(row, col - 1));
		}
		if ((row - 1) + 1 <= length-1 && siteMatrix[(row - 1) + 1][(col - 1) + 0]) {
			connectivity.union(indexConversion(row, col), indexConversion(row + 1, col));
		}
		if ((col - 1) + 1 <= length-1 && siteMatrix[(row - 1) + 0][(col - 1) + 1]) {
			connectivity.union(indexConversion(row, col), indexConversion(row, col + 1));
		}
				
	}
	
	// is site (row, col) open?
	public boolean isOpen(int row, int col) {
		return siteMatrix[row - 1][col - 1];
	}
	
	// is site (row, col) full? (connected to row 1 via some path)
	public boolean isFull(int row, int col) {
		return connectivity.connected(indexConversion(row, col), 0);
	}
	
	// number of open sites
	public     int numberOfOpenSites() {
		return nOpen;
	}
	
	// does the system percolate?
	public boolean percolates() {
		return connectivity.connected(0, length*length + 1);
	}
	
	private int indexConversion(int row, int col) {
		return length*(row-1) + col;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Percolation compiled and executed!");
	}

}
