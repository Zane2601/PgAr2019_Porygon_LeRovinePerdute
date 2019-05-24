package it.unibs.fp.lerovineperdute;

import java.util.ArrayList;

public class Percorso {
	
	Gestione g = new Gestione();
	
	
	public double distanzaDaGruppo1(ArrayList<Citta> lista, int i, int j) {
		
		return Math.sqrt(Math.pow(lista.get(i).getX() - lista.get(lista.get(i).getCollegamenti().get(j)).getX(), 2) + Math.pow(lista.get(i).getY() - lista.get(lista.get(i).getCollegamenti().get(j)).getY(), 2));
	}
	
	public double distanzaDaGruppo2(ArrayList<Citta> lista, int i, int j) {
		return Math.abs(lista.get(i).getZ() - lista.get(lista.get(i).getCollegamenti().get(j)).getZ());
	}
	
	
	public void dijkstra () {
		ArrayList<Citta> porcodio = g.leggiXml();
		int lunghezza = porcodio.size();
		Citta origine = porcodio.get(0);
		Citta destinazione = porcodio.get(lunghezza-1);
		System.out.println("L'origine è " + origine);
		System.out.println("La destinazione è" + destinazione);
	}


}
