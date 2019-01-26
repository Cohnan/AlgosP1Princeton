
public class WQUPC_UF {
	private int[] id;
	private int[] sz;
	
	public WQUPC_UF(int N) 
	{
		id = new int[N];
		sz = new int[N]; //Init at size 0, which means there is only the root.
		
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}
	
	private int root(int i)
	{
		int parent = i;
		while (parent != id[parent]) {
			parent = id[parent];
		} // Simple makes parent store root. Modifies nothing else.
		
		// Path compression
		int current = i;
		int previous;
		while (current != parent) { //Modify current node's parent and update current to be its previous parent
			previous = current;
			current = id[current];
			id[previous] = parent;
		}
		
		return parent;
	}
	
	public boolean connected(int p, int q)
	{
		return root(p) == root(q);
	}
	
	public void union(int p, int q)
	{
		int i = root(p);
		int j = root(q);
		if (i == j) return;
		// Weighting of the trees to decide who joins who
		if (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
		else			   { id[j] = i; sz[i] += sz[j]; }
	}
	
	// Testing the class
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
