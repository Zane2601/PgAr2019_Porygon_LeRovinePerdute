package it.unibs.fp.grafi;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class GraphWithAdjList implements Graph{
	private int nodes;
	Map<Integer, LinkedList<Node>> adjList;
	
	public GraphWithAdjList(int nodes) {
		this.nodes = nodes;
		adjList = new HashMap<>();
		for (int i = 0; i < nodes; i++) {
			adjList.put(i, new LinkedList<>());
		}
	}
	
	public void addEdgeUnoriented(int from, int to) {
		addEdgeOriented(from, to, 1);
	}
	
	public void addEdgeUnoriented(int from, int to, int weight) {
		adjList.get(from).add(new Node(to,weight));
		adjList.get(to).add(new Node(from,weight));
	}
	
	public void addEdgeOriented(int from, int to) {
		addEdgeOriented(from, to, 1);	
	}
	
	public void addEdgeOriented(int from, int to, int weight) {
		adjList.get(from).add(new Node(to,weight));
	}
	
	class Node {
		int node;
		int weight;
		
		public Node(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}
		
		@Override
		public String toString() {
			return String.format("%d (%d)", node, weight);
		}
	}

	public void print() {
		int i = 0;
		for (Entry<Integer, LinkedList<Node>> element : adjList.entrySet()) {
			System.out.print(i +" ");
			System.out.println(element);
			i++;
		}
	}
	
	
}
