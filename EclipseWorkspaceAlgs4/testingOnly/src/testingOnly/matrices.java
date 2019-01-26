package testingOnly;

public class matrices {

	public static void main(String[] args) {
		
		int n = 3;
		boolean[][] matrix = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.println(matrix[i][j]);
			}
		}
	}

}
