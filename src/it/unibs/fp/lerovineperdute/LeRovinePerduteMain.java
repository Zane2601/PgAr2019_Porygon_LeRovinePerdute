package it.unibs.fp.lerovineperdute;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

import it.unibs.fp.grafi.Dijkstra;
import it.unibs.fp.grafi.GraphTrovato;
import it.unibs.fp.grafi.Node;

public class LeRovinePerduteMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Gestione g= new Gestione();
		Percorso p = new Percorso();
		
		
		ArrayList<Citta> listaEstratta= g.leggiXml();
		ArrayList<Node> listaNodi = new ArrayList<Node>();
		
		 
		//aggiungo i nodi in una lista di Node
		for (int i = 0; i < listaEstratta.size(); i++) {
			Node nodo = new Node(listaEstratta.get(i).getId(), listaEstratta.get(i).getNome());
			listaNodi.add(nodo);
		}
			
		GraphTrovato grafo = g.creaGrafo(listaEstratta, 1, listaNodi);    //creiamo il grafo dalla lista estratta
		
		LinkedHashSet<Node> set1 = Dijkstra.calculateShortestPathFromSource(grafo, listaNodi.get(0));  //calcoliamo il percorso minimo
		
		//stampiamo le città del percorso 1
		Iterator iter = set1.iterator();  
		while (iter.hasNext()) {
			System.out.println(iter.next());
			}
		 
		
		
		
		System.out.println("**************************************");
		grafo = g.creaGrafo(listaEstratta, 2, listaNodi);
		
		LinkedHashSet set2 = Dijkstra.calculateShortestPathFromSource(grafo, listaNodi.get(0));
		
		iter = set2.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
			}
		
		
		
		g.write("outputCitta", set1, set2, listaEstratta);
		
		
		
		
        
	}
	
	
	

}
