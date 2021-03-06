package it.unibs.fp.lerovineperdute;

import java.util.ArrayList;

import it.unibs.fp.grafi.Node;

public class Percorso {
	
	Gestione g = new Gestione();
	double min = Double.POSITIVE_INFINITY;
	
	/*
	 * public double distanzaDaGruppo1(ArrayList<Citta> listaCitta, int i, int j) {
	 * Citta cittaInizioCollegamento = listaCitta.get(i);
	 * 
	 * return Math.sqrt(Math.pow(cittaInizioCollegamento.getX() -
	 * listaCitta.get(cittaInizioCollegamento.getCollegamenti().get(j)).getX(), 2) +
	 * Math.pow(cittaInizioCollegamento.getY() -
	 * listaCitta.get(cittaInizioCollegamento.getCollegamenti().get(j)).getY(), 2));
	 * }
	 * 
	 * 
	 * 
	 * public double distanzaDaGruppo2(ArrayList<Citta> lista, int i, int j) {
	 * return Math.abs(lista.get(i).getZ() - lista.get(lista.get(i).getCollegamenti().get(j)).getZ());
	 * }
	 */
	
	public double distanzaDaGruppo1(Citta origine, ArrayList<Citta> listaCitta, int indiceCollegamento) {
		
		return Math.sqrt(Math.pow(origine.getX() - listaCitta.get(indiceCollegamento).getX(), 2) + Math.pow(origine.getY() - listaCitta.get(indiceCollegamento).getY(),2));
	}
	
	public double distanzaDaGruppo2(Citta origine, ArrayList<Citta> listaCitta, int indiceCollegamento) {
		return Math.abs(origine.getZ() -  listaCitta.get(indiceCollegamento).getZ());
	}
	
	/*
	public void dijkstra () {
		ArrayList<Citta> listacitta = g.leggiXml();
		int lunghezza = listacitta.size();
		double distanzaBase = 0; 
		double distanzaFinale = 0;
		Node origine = listacitta.get(0);
		Citta destinazione = listacitta.get(lunghezza-1);
		System.out.println("L'origine è " + origine);
		System.out.println("La destinazione è " + destinazione);
		for(int i=0; i<=origine.getId(); i++) {
			for (int j=0; j<listacitta.get(i).getCollegamenti().size(); j++) {
				//System.out.println(""+ distanzaDaGruppo1(listacitta, i, j));
				
				if(minimo(distanzaDaGruppo1(listacitta, i, j)) == true) {
					 distanzaBase = distanzaDaGruppo1(listacitta, i, j);
				}
				do {
					for(int l=1; l<lunghezza; l++) {
						for(int p=0; p<listacitta.get(l).getCollegamenti().size(); p++) {
							if(minimo(distanzaDaGruppo1(listacitta, l, p)) == true) {
								 double min = distanzaDaGruppo1(listacitta, l, p);
							}
							
						}
						
					}
					
				}while(!listacitta.get(i).getCollegamenti().contains(destinazione));
				
				//System.out.println("\n");
				//System.out.println(""+ distanzaDaGruppo2(listacitta, i, j));
				distanzaBase = distanzaBase + min;
			}
		}
		
		System.out.println("la distanza base è " + distanzaBase);
		
	}
	
	public boolean minimo(double i) {
		
		
		if(i<min) {
			min = i;
			return true;
		}
		else return false;
		
	}

	 */

}
