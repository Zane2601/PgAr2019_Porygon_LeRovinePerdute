package it.unibs.fp.grafi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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

	
	
	
	
	
	public void dijkstra() {
		ArrayList<Double> distanze = new ArrayList<Double>();
		ArrayList<Integer> nodiPrecedenti = new ArrayList<Integer>();
		//ArrayList<Integer> percorso = new ArrayList<Integer>();
		//Double vecchiaDistanza;
		Double inf = Double.POSITIVE_INFINITY;
		Set<Integer> setDiCitta = new HashSet<Integer>();
		ArrayList<Integer> nodiVisitati = new ArrayList<Integer>();

		/* setto tutte le distanze a infinito
		 * aggiungo un nodo precedente (intanto null) per ogni città
		 * aggiungo il numero della città nel setDiCitta
		 */
		
		for (int i = 0; i < adj.length; i++) {
			distanze.add(inf);
			nodiPrecedenti.add(null);
			//aggiungo i nodi al setDiCitta
			setDiCitta.add(i);
		}
		
		//setto a 0.0 (perché double) la distanza dell'origine dall'origine
		distanze.set(0, 0.0);

		int k = 0;
		//do...while (ci sono elementi dentro il set di città
		do {
			for (int j = 0; j < adj.length; j++) {
				if (adj[k][j] != 0) {
					if ((adj[k][j] + distanze.get(k)) < distanze.get(j)) {
						distanze.set(j, adj[k][j] + distanze.get(k));
						nodiPrecedenti.set(j, k);
					}
				}
				
			}
			
			nodiVisitati.add(k);
			k = posizioneNodoConDistanzaMinimaDallOrigine(distanze, nodiVisitati);
			/*
			Iterator iter = setDiCitta.iterator();
			int elem = (int) iter.next();
			int i = 0;
			while (i == 0) {
				while (iter.hasNext()) {
					if (adj[i][elem] != 0) {
						distanze.set(elem, Double.valueOf(adj[i][elem]));
					}
				}
				i++;
			}
			
			//imposto t come numero del nodo che ha la distanza minoren dall'origine
			int t = nodoConDistanzaMinimaDallOrigine(setDiCitta, distanze);
			setDiCitta.remove(t);
			
			Set<Integer> setDiCollegamenti = new HashSet<Integer>();
			*/
			
			
				
		} while (!nodiVisitati.contains(adj.length-1));

		System.out.println(ricostruisciPercorso(nodiPrecedenti));

	}

	private String ricostruisciPercorso(ArrayList<Integer> listaNodiPrecedenti) {
		String percorso = "";
		Integer nodoCorrente = adj.length;
		
		do {
			percorso += nodoCorrente.toString() + ", ";
			nodoCorrente = listaNodiPrecedenti.get(nodoCorrente);
		} while (nodoCorrente == 0);
		
		return percorso;
	}
	 
	private int posizioneNodoConDistanzaMinimaDallOrigine(ArrayList<Double> listaDistanze, ArrayList<Integer> listaNodiVisitati) {
		int posMin = 0;
		while (listaDistanze.get(posMin) == 0)
			posMin++;
		
		for (int i = 0; i < listaDistanze.size(); i++) {
			if (listaDistanze.get(i) != 0) {
				if (listaDistanze.get(i) < listaDistanze.get(posMin) && !listaNodiVisitati.contains(posMin)) {
					posMin = i;
				}
			}
		}
		
		return posMin;
	}
	
	private int nodoConDistanzaMinimaDallOrigine (Set<Integer> setCitta, ArrayList<Double> listaDistanze) {
		Iterator iter = setCitta.iterator();
		int elem = (int) iter.next();
		Double min = listaDistanze.get(0);
		
		while(iter.hasNext()) {
			if (listaDistanze.get(elem) < min)
				min = listaDistanze.get(elem);
		}
		
		return elem;
	}
	
	
	
	private int numeroDiCollegamenti(int[] array) {
		int numCollegamenti = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0)
				numCollegamenti++;
		}
		
		return numCollegamenti;
	}

	private int minimoNonZeroSet(Set<Integer> setCitta, ArrayList<Double> listaDistanze) {
		Iterator iter = setCitta.iterator();
		Double min = listaDistanze.get(0);
		Double i = 0.0;
		
		
		while (iter.hasNext()) {
			int elem = (int) iter.next(); 
			if (elem != 0 && elem < min) {
				min = elem;
			}
			i++;
		}
		System.out.println("Il minimo non zero è " +min);
		return i;
	}
	
	//minimoNonZero con input int[] (forse non serve più)
	private Double minimoNonZero(int[] array) {
		Double min = (double) array[0];

		for (int j = 1; j < array.length; j++) {
			if (min == 0) {
				min = (double) array[j];
			} else if (array[j] < min && array[j] != 0)
				min = (double) array[j];
		}
		System.out.println(min);
		return min;
	}

	private int cercaPos(int[] array, Double minimo) {
		int pos = -1;
		int i = 0;

		do {
			if (array[i] == minimo)
				pos = i;
			i++;
		} while (pos == -1);
		return pos;
	}

	private int posConDistanzaMinima(ArrayList<Double> listaDistanze, Double minimo) {
		int posDistanzaMinima = -1;
		int i = 0;

		do {
			if (listaDistanze.get(i).equals(minimo)) {
				posDistanzaMinima = i;
			}
			i++;
		} while (posDistanzaMinima == -1);
		return posDistanzaMinima;
	}

	
	/*
	public void dijkstra() {
		ArrayList<Double> distanze = new ArrayList<Double>();
		ArrayList<Integer> nodiPrecedenti = new ArrayList<Integer>();
		ArrayList<Integer> percorso = new ArrayList<Integer>();
		Double vecchiaDistanza;
		Double inf = Double.POSITIVE_INFINITY;
		
		//setto la distanza dall'origine dell'origine a 0 (A dista 0 da A)
		distanze.add(0.0);
		nodiPrecedenti.add(-1);
		//setto tutte le altre distanze a infinito
		for (int i = 1; i < adj.length; i++) {
			distanze.add(inf);
			nodiPrecedenti.add(-1);
		}
		
		do {
			for (int i = 0; i < adj.length; i++) {
				percorso.add(i);
				//for (int j = 0; j < adj.length; j++) {
					Double min = minimoNonZero(adj[i]);
					int pos = cercaPos(adj[i], min);
					
					if (!distanze.get(pos).equals(inf))
						min += distanze.get(pos);

					if (i == 0) {
						if (min < distanze.get(pos)) {
							vecchiaDistanza = 0.0;	
							distanze.set(pos, min + vecchiaDistanza);
							nodiPrecedenti.set(pos, i);
						}
					} else if (min < distanze.get(pos) && distanze.get(pos) != inf) {
						if (distanze.get(pos).equals(inf)) {
							vecchiaDistanza = 0.0;
						} else vecchiaDistanza = distanze.get(pos);	
						distanze.set(pos, min + vecchiaDistanza);
						nodiPrecedenti.set(pos, i);
					}
					
				//	}
				
	
				i = posConDistanzaMinima(distanze, min) -1;
				
			}
			
		} while (!percorso.contains(adj.length));
		
		System.out.println(percorso);
		
	}
	
	private Double minimoNonZero(int[] array) {
		Double min = (double) array[0];
		
		for (int j = 1; j < array.length; j++) {
			if (min == 0) {
				min = (double) array[j];
			} else
				if (array[j] < min && array[j] != 0) 
					min = (double) array[j];
		}
		System.out.println(min);
		return min;
	}
	
	private int cercaPos(int[] array, Double minimo) {
		int pos = -1;
		int i = 0;
		
		do {
			if (array[i] == minimo)
				pos = i;
			i++;
		} while (pos == -1);
		return pos;
	}
	
	private int posConDistanzaMinima(ArrayList<Double> listaDistanze, Double minimo) {
		int posDistanzaMinima = -1;
		int i = 0;
		
		do {
			if (listaDistanze.get(i).equals(minimo)) {
				posDistanzaMinima = i;
			}
			i++;
			if (i==5 && posDistanzaMinima==-1) {
				System.out.println("ERRORE, NON HA TROVATO LA POSIZIONE A DISTANZA MINIMA");
			}
		} while (posDistanzaMinima == -1);
		return posDistanzaMinima;
	}
	
	*/
	
}
