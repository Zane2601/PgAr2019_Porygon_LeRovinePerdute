package it.unibs.fp.lerovineperdute;

import java.util.ArrayList;

public class Percorso {
	
	Gestione g = new Gestione();
	
	
	public double distanzaDa(ArrayList<Citta> lista, int i, int j) {
		return Math.sqrt(Math.pow(lista.get(i).getX() - lista.get(lista.get(i).getCollegamenti().get(j)).getX(), 2) + Math.pow(lista.get(i).getY() - lista.get(lista.get(i).getCollegamenti().get(j)).getY(), 2));
	}

}
