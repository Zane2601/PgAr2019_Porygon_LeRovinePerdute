package it.unibs.fp.lerovineperdute;

import java.util.ArrayList;

public class LeRovinePerduteMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Gestione g= new Gestione();
		ArrayList<Citta> listaEstratta= g.leggiXml();
		
        g.creaGrafo(listaEstratta).print();

       
	}

}
