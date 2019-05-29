package it.unibs.fp.lerovineperdute;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

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
			Node nodo = new Node(listaEstratta.get(i).getId());
			listaNodi.add(nodo);
		}
			
		GraphTrovato grafo = g.creaGrafo(listaEstratta, 1, listaNodi);
		
		LinkedHashSet<Node> set = Dijkstra.calculateShortestPathFromSource(grafo, listaNodi.get(0));
		
		
		Iterator iter = set.iterator();
		while (iter.hasNext()) {
			System.out.println("Codice: " + iter.next());
			}
		 
		
		for (int i = 0; i < set.size(); i++) {
			//System.out.println("Codice: " + listaEstratta.get(set.get(i).getId()).getId() + "\tNome città: " + listaEstratta.get(set.get(i).getId()).getNome());
		}
		
		System.out.println("**************************************");
		grafo = g.creaGrafo(listaEstratta, 2, listaNodi);
		
		set = Dijkstra.calculateShortestPathFromSource(grafo, listaNodi.get(0));
		
		iter = set.iterator();
		while (iter.hasNext()) {
			System.out.println("Codice: " + iter.next());
			}
		
		/*
		for (int i = 0; i < set.size(); i++) {
			//System.out.println(set.get(i).getId() + set.get(i).getName());
		}
		*/
		
		/*
		//g.creaHashMap(listaEstratta);
		//System.out.println("\n\n");
        g.creaGrafo(listaEstratta,1).print();
        //System.out.println("\n\n");
        g.creaGrafo(listaEstratta,2).print();

        //g.creaGrafo(listaEstratta, 1).dijkstra();
        //p.dijkstra();
        g.creaGrafo(listaEstratta, 1).dijkstra();
       
        g.creaGrafo(listaEstratta, 1)
        
        */
		
        
	}

}
