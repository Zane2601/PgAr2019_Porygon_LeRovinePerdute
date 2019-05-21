package it.unibs.fp.grafi;

public class MainClass {

	public static void main(String[] args) {
		
		Graph gAdjM = new GraphWithAdjMatrix(4);
		gAdjM.addEdgeUnoriented(0, 1, 4);
		gAdjM.addEdgeUnoriented(1, 2, 2);
		gAdjM.addEdgeUnoriented(2, 3, 3);
		gAdjM.addEdgeUnoriented(0, 2, 1);
		gAdjM.addEdgeOriented(1, 3, 2);
		
		gAdjM.print();
		
		//================
		
		System.out.println("\n\n");
		
		Graph gAdjL = new GraphWithAdjList(4);
		gAdjL.addEdgeUnoriented(0, 1, 4);
		gAdjL.addEdgeUnoriented(1, 2, 2);
		gAdjL.addEdgeUnoriented(2, 3, 3);
		gAdjL.addEdgeUnoriented(0, 2, 1);
		gAdjL.addEdgeOriented(1, 3, 2);
		
		gAdjL.print();
		
		//================
		
		System.out.println("\n\n");
		
		Graph gClass = new GraphWithClasses(4);
		gClass.addEdgeUnoriented(0, 1, 4);
		gClass.addEdgeUnoriented(1, 2, 2);
		gClass.addEdgeUnoriented(2, 3, 3);
		gClass.addEdgeUnoriented(0, 2, 1);
		gClass.addEdgeOriented(1, 3, 2);
		
		gClass.print();
		
	}
	

}

