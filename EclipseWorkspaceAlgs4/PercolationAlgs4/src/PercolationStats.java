

/**
 * @author cohnan
 *
 */

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

import java.lang.Math;
import java.lang.*;

public class PercolationStats {
	
	private Percolation percolation;
	private double mean;
	private double stddev;
	private double confidenceLo;
	private double confidenceHi;
	
	
	// perform trials independent experiments on an n-by-n grid
	public PercolationStats(int n, int trials) {
		int row;
		int col;
		double[] results = new double[trials];
		
		for (int i = 0; i < trials; i++) {
			percolation = new Percolation(n);
			
			while (!percolation.percolates()) {
				row = StdRandom.uniform(n) + 1;
				col = StdRandom.uniform(n) + 1;
				percolation.open(row, col);
			}
			results[i] = percolation.numberOfOpenSites() / ((double) n*n);
		}
		
		mean = StdStats.mean(results);
		stddev = StdStats.stddev(results);
		confidenceLo = mean - (1.96 * stddev / Math.sqrt(trials));
		confidenceHi = mean + (1.96 * stddev / Math.sqrt(trials));
	}
	
	// sample mean of percolation threshold
	public double mean() {
		return mean;
	}
	
	// sample standard deviation of percolation threshold
	public double stddev() {
		return stddev;
	}
	
	// low  endpoint of 95% confidence interval
	public double confidenceLo() {
		return confidenceLo;
	}
	
	// high endpoint of 95% confidence interval
	public double confidenceHi() {
		return confidenceHi;
	}
	   
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int size;
		int trials;
		try {
			size = Integer.parseInt(args[0]);
			trials = Integer.parseInt(args[1]);
		} catch (java.lang.NumberFormatException e) {
			throw(new IllegalArgumentException());
		}
		PercolationStats statistician = new PercolationStats(size, trials);
		
		System.out.println("mean \t\t\t\t = " + statistician.mean());
		System.out.println("stddev\t\t\t\t = " + statistician.stddev());
		System.out.println("95% confidence interval\t = [" + statistician.confidenceLo() + ", " + statistician.confidenceHi() + "]");
		
	}

}
