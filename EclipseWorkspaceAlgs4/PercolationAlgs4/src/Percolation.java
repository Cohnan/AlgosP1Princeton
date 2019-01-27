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
	private boolean[][] siteMatrix;
//	private WQUPC_UF connectivity;							// Change underlying UF structure to be WQUPC_UF
	private WeightedQuickUnionUF connectivity;				// Change underlying UF structure to be WeightedQuickUnionUF
	
	
	
	public Percolation(int n) {
		//Java, by default, initializes arrays with null or 0 like values.
		length = n;
		siteMatrix = new boolean[n][n];
		nOpen = 0;
		//connectivity = new WQUPC_UF(n*n + 2);				// Change underlying UF structure to be WQUPC_UF
		connectivity = new WeightedQuickUnionUF(n*n + 2);	// Change underlying UF structure to be WeightedQuickUnionUF
		
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
		} else {
			return; //Para que no lo conecte si no se abre el sitio
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
		System.out.println("Percolation compiles!");
		
		///////////////////////////////////////////////////////////////////////////////
		Percolation perc1 = new Percolation(3);
		
		// Just made percolation shouldn't percolate:
		if (perc1.percolates()) System.out.println("Recien iniciada. No deberia percolar.");
		else System.out.println("Bien. No percola si recien iniciada.");
		
		// Abrir linea recta y esperar que percole
		perc1.open(1, 2);
		if (perc1.percolates()) System.out.println("No deberia percolar.1, 2");
		else System.out.println("Bien. 1, 2");
		perc1.open(2, 2);
		if (perc1.percolates()) System.out.println("No deberia percolar. 2, 2");
		else System.out.println("Bien. 2, 2");
		perc1.open(3, 2);
		if (perc1.percolates()) System.out.println("Bien. Abrilinea recta en columna 2");
		else System.out.println("Mal. Deberia percolar al abrir linea recta");
		
		///////////////////////////////////////////////////////////////////////////////
		// Linea recta mas peligrosa 1
		Percolation perc2 = new Percolation(3);
		
		// Just made percolation shouldn't percolate:
		if (perc1.percolates()) System.out.println("Recien iniciada. No deberia percolar.");
		else System.out.println("Bien. No percola si recien iniciada.");
		
		// Abrir linea recta y esperar que percole
		perc2.open(1, 1);
		if (perc2.percolates()) System.out.println("No deberia percolar.1, 1");
		else System.out.println("Bien. 1, 1");
		perc2.open(2, 1);
		if (perc2.percolates()) System.out.println("No deberia percolar. 2, 1");
		else System.out.println("Bien. 2, 1");
		perc2.open(3, 1);
		if (perc2.percolates()) System.out.println("Bien. Abrilinea recta en columna 1");
		else System.out.println("Mal. Deberia percolar al abrir linea recta");
		
		///////////////////////////////////////////////////////////////////////////////
		// Linea recta mas peligrosa 1
		Percolation perc3 = new Percolation(3);
	
		// Just made percolation shouldn't percolate:
		if (perc3.percolates()) System.out.println("Recien iniciada. No deberia percolar.");
		else System.out.println("Bien. No percola si recien iniciada.");
		
		// Abrir linea recta y esperar que percole
		perc3.open(1, 1);
		if (perc3.percolates()) System.out.println("No deberia percolar.1, 1");
		else System.out.println("Bien. 1, 3");
		perc3.open(2, 1);
		if (perc3.percolates()) System.out.println("No deberia percolar. 2, 1");
		else System.out.println("Bien. 2, 1");
		perc3.open(3, 1);
		if (perc3.percolates()) System.out.println("Bien. Abrilinea recta en columna 3");
		else System.out.println("Mal. Deberia percolar al abrir linea recta");
		System.out.println("Dice que hay: " + perc3.numberOfOpenSites() + " sitions abiertos");
		
		
	}

}
