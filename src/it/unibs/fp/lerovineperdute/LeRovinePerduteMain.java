package it.unibs.fp.lerovineperdute;

import java.util.ArrayList;

public class LeRovinePerduteMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Gestione g= new Gestione();
		ArrayList<Citta> listaEstratta= g.leggiXml();
		Percorso p = new Percorso();
		
		
		
		g.creaHashMap(listaEstratta);
		
        g.creaGrafo(listaEstratta,1).print();
        
        g.creaGrafo(listaEstratta,2).print();

        g.creaGrafo(listaEstratta, 1).dijkstra();
       
	}

}
