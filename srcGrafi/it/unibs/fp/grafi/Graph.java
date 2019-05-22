package it.unibs.fp.grafi;

/**
 * Interfaccia per la modellizzazione di grafi
 * Vi invito a modificarla aggiungendo nuovi metodi e 
 * modificando quelli già presenti, facendo controlli...
 * @author danielevezz
 *
 */
public interface Graph {
	
	/**
	 * Aggiunge ramo non orientato con peso unitario
	 * 
	 * @param from	nodo 1
	 * @param to	nodo 2
	 */
	void addEdgeUnoriented(int from, int to);
	
	/**
	 * Aggiunge ramo non orientato con peso pari a weight
	 * @param from	nodo 1
	 * @param to	nodo 2
	 * @param weight	peso del collegamento
	 */
	void addEdgeUnoriented(int from, int to, int weight);
	
	/**
	 * Aggiunge ramo orientato con peso unitario
	 * @param from	nodo di partenza
	 * @param to	nodo di arrivo
	 */
	void addEdgeOriented(int from, int to);
	
	/**
	 * Aggiunge ramo non orientato con peso pari a weight
	 * @param from	nodo di partenza
	 * @param to	nodo di arrivo
	 * @param weight	peso del collegamento
	 */
	void addEdgeOriented(int from, int to, int weight);
	
	/**
	 * Stampa il grafo
	 */
	void print();
	
	void dijkstra();
}
