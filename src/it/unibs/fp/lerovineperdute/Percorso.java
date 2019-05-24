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
		ArrayList<Citta> listacitta = g.leggiXml();
		int lunghezza = listacitta.size();
		Citta origine = listacitta.get(0);
		Citta destinazione = listacitta.get(lunghezza-1);
		System.out.println("L'origine è " + origine);
		System.out.println("La destinazione è " + destinazione);
		for(int i=0; i<=origine.getId(); i++) {
			for (int j=0; j<listacitta.get(i).getCollegamenti().size(); j++) {
				System.out.println(""+ distanzaDaGruppo1(listacitta, i, j));
				System.out.println("\n");
				//System.out.println(""+ distanzaDaGruppo2(listacitta, i, j));
			}
		}
		
	}


}
