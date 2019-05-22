package it.unibs.fp.grafi;

import java.util.ArrayList;
import java.util.List;

public class GraphWithClasses implements Graph {
	
	private List<Node> nodes = new ArrayList<>();
	private List<Edge> edges = new ArrayList<>();
	private int numNodes;
	
	public GraphWithClasses(int nodes) {
		numNodes = nodes;
		for(int i=0; i<nodes; i++) {
			this.nodes.add(new Node(i));
		}
	}

	@Override
	public void addEdgeUnoriented(int from, int to) {
		addEdgeOriented(from, to, 1);
	}

	@Override
	public void addEdgeUnoriented(int from, int to, int weight) {
		Edge edge = new Edge(nodes.get(from), nodes.get(to), weight);
		
		if (!edges.contains(edge)) {
			edge.getStartNode().setLinkedNodes(edge.getEndNode());
			edge.getEndNode().setLinkedNodes(edge.getStartNode());
			edge.getStartNode().addEdge(edge);
			edge.getEndNode().addEdge(edge);
			edges.add(edge);
		}
	}

	@Override
	public void addEdgeOriented(int from, int to) {
		addEdgeOriented(from, to, 1);
	}

	@Override
	public void addEdgeOriented(int from, int to, int weight) {
		Edge edge = new Edge(nodes.get(from), nodes.get(to), weight);
		
		if (!edges.contains(edge)) {
			edge.getStartNode().setLinkedNodes(edge.getEndNode());
			edge.getStartNode().addEdge(edge);
			edges.add(edge);
		}
	}

	@Override
	public void print() {
		for (Node n : nodes) {
			System.out.println(n);
		}
		System.out.print("\n\n");
		for (Edge e : edges) {
			System.out.println(e + " ");
}
	}
	
	/**
	 * Una sola classe per file!!
	 */
	class Node {
		private List<Edge> links = new ArrayList<>();
		private List<Node> linkedNodes = new ArrayList<>();
		int label;
		
		public Node(int label) {
			this.label = label;
		}
		
		public String toString() {
			StringBuffer str = new StringBuffer("\nNodo: " + " " + label + " ");
			for (Edge e : links) {
				str.append("\n" + e);
			}
			str.append("\nConnesso a:");
			for (Node n : linkedNodes) {
				str.append("\n" + n.label);
			}
			return str.toString();
		}
		
		public int getLabel() {
			return label;
		}

		public List<Node> getLinkedNodes() {
			return linkedNodes;
		}

		public void setLinkedNodes(Node _linkedNode) {
			this.linkedNodes.add(_linkedNode);
		}
		

		public void addEdge(Edge newEdge) {
			links.add(newEdge);
		}
		
	}

	/**
	 * Vi invito ad informarvi su come funziona comparable e quindi anche il metodo equals
	 */
	class Edge implements Comparable<Edge>{

		private Node startNode;
		private Node endNode;
		private int weight;
		
		public Edge(Node _startNode, Node _endNode, int _weight) {
			startNode = _startNode;
			endNode = _endNode;
			weight = _weight;
		}
		
		public String toString() {
			return String.format(startNode.getLabel() + " - " + endNode.getLabel() + " = " + weight);
		}
		

		public Node getStartNode() {
			return startNode;
		}

		public Node getEndNode() {
			return endNode;
		}

		public int getWeight() {
			return weight;
		}
			
		public int compareTo(Edge e1) {
				return Integer.compare(this.getWeight(), e1.getWeight());
		}
		
		public boolean equals(Edge edge) {
			boolean flag = false;
			if (this.startNode.equals(edge.getStartNode()) && this.endNode.equals(edge.getEndNode())
					&& (this.weight == edge.getWeight())) {
				flag = true;
			}
			if (this.startNode.equals(edge.getEndNode()) && this.endNode.equals(edge.getStartNode())
					&& (this.weight == edge.getWeight())) {
				flag = true;
			}
			return flag;
		}
	
	}

	@Override
	public void dijkstra() {
		//  Auto-generated method stub
		
	}

}
