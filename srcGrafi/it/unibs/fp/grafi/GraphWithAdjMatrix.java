package it.unibs.fp.grafi;

/**
 * Implementazione grafo con matrice di adiacenza
 * I nodi sono identificati con int
 * @author danielevezz
 *
 */
public class GraphWithAdjMatrix implements Graph{
	private int nodes;
	
	int[][] adj;

	public GraphWithAdjMatrix(int nodes) {
		this.nodes = nodes;
		adj = new int[nodes][nodes];
		for(int i = 0; i<nodes; i++) {
			for (int j = 0; j<nodes; j++) {
				adj[i][j] = 0;
			}
		}
	}

	public void addEdgeUnoriented(int from, int to) {
		addEdgeOriented(from, to, 1);
	}

	public void addEdgeUnoriented(int from, int to, int weight) {
		adj[from][to] = weight;
		adj[to][from] = weight;
	}
	
	public void addEdgeOriented(int from, int to) {
		addEdgeOriented(from, to, 1);
	}
	
	public void addEdgeOriented(int from, int to, int weight) {
		adj[from][to] = weight;
	}
	
	public void print() {
		System.out.print("   \t");
		for(int i = 0; i<nodes; i++) {
			System.out.print(String.format("%2d", i) + " \t");
		}
		System.out.println("\n");
		for(int i = 0; i<nodes; i++) {
			System.out.print(String.format("%2d", i) + " \t");
			for (int j = 0; j<nodes; j++) {
				System.out.print(String.format("%2d", adj[i][j]) + " \t");
			}
			
			System.out.println();
		}
	}

	
}
