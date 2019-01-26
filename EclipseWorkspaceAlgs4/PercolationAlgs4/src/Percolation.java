/**
 * A class whose objects represent the material, it knows nothing about the probability of openness
 */

/**
 * @author cohnan
 *
 */
public class Percolation {
	// create n-by-n grid, with all sites blocked
	private boolean[][] siteMatrix;
	private int p;
	
	
	public Percolation(int n) {
		//Java, by default, initializes arrays with null or 0 like values.
		siteMatrix = new boolean[n][n]; 
	}
	
	// open site (row, col) if it is not open already
	public    void open(int row, int col) { 
		siteMatrix[row - 1][col - 1] = true;
	}
	
	// is site (row, col) open?
	public boolean isOpen(int row, int col) {
		return siteMatrix[row - 1][col - 1];
	}
	
	// is site (row, col) full? (connected to row 1 via some path)
	public boolean isFull(int row, int col) {
		
	}
	
	// number of open sites
	public     int numberOfOpenSites() {
		
	}
	
	// does the system percolate?
	public boolean percolates() {
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
