package it.unibs.fp.lerovineperdute;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

import it.unibs.fp.grafi.*;



public class Gestione {
	
	XMLInputFactory xmlif = null;
	XMLStreamReader xmlr=null;
	
<<<<<<< HEAD
	private String mappa = "PgAr_Map_5.xml";
=======
	private String mappa = "PgAr_Map_10000.xml";
>>>>>>> f755eb2512f74792b5ea44724d7b5dfd34e86c26
	
	Citta c = new Citta();
	
	 public ArrayList<Citta> leggiXml() {
		 
		 
		 ArrayList<Citta> listaCitta = new ArrayList<Citta>();
		 
		 //contatore per contare nella listaCitta
		 int j = 0;
		 
		 try {
			 xmlif = XMLInputFactory.newInstance();
			 xmlr = xmlif.createXMLStreamReader(mappa, new FileInputStream(mappa)); 
			 while (xmlr.hasNext()) { // continua a leggere finché ha eventi a disposizione 
				 switch (xmlr.getEventType()) { // switch sul tipo di evento
				 
				 case XMLStreamConstants.START_DOCUMENT: // inizio del documento: stampa che inizia il documento 
					 //System.out.println("Start Read Doc " + mappa); 
					 break;
			     
				 case XMLStreamConstants.START_ELEMENT: // inizio di un elemento: stampa il nome del tag e i suoi attributi 
			    	 //System.out.println("Tag " + xmlr.getLocalName());
			    	 if (xmlr.getLocalName().equals("city")) {
			    		 Citta nuovaCitta = new Citta();
			    		 listaCitta.add(nuovaCitta);
			    		 //System.out.println("nuova citta creata");
			    		 j++;
			    	 }
			         for (int i = 0; i < xmlr.getAttributeCount(); i++) {
			        	 //System.out.printf(" => attributo %s->%s%n", xmlr.getAttributeLocalName(i), xmlr.getAttributeValue(i));
			        	 switch (xmlr.getAttributeLocalName(i)) {
							case "id":
								int idInt = Integer.parseInt(xmlr.getAttributeValue(i));
								listaCitta.get(j-1).setId(idInt);
								//System.out.println("id aggiunto");
								break;
	
							case "name":
								listaCitta.get(j-1).setNome(xmlr.getAttributeValue(i));
								break;
							case "x":
								int xInt = Integer.parseInt(xmlr.getAttributeValue(i));
								listaCitta.get(j-1).setX(xInt);
								break;
							case "y":
								int yInt = Integer.parseInt(xmlr.getAttributeValue(i));
								listaCitta.get(j-1).setY(yInt);
								break;
							case "h":
								int zInt = Integer.parseInt(xmlr.getAttributeValue(i));
								listaCitta.get(j-1).setZ(zInt);
								break;
		
							default:
								break;
						}
			        	 if (xmlr.getLocalName().equals("link")) {
				    		 listaCitta.get(j-1).setCollegamenti(Integer.parseInt(xmlr.getAttributeValue(i)));
				    	 }
			         }
			         
			         break;
			     
				 case XMLStreamConstants.END_ELEMENT: // fine di un elemento: stampa il nome del tag chiuso 
			    	 //System.out.println("END-Tag " + xmlr.getLocalName()); 
			    	 break;
			     
				 case XMLStreamConstants.COMMENT:
			         //System.out.println("// commento " + xmlr.getText()); 
			         break; // commento: ne stampa il contenuto
			     
				 case XMLStreamConstants.CHARACTERS: // content all’interno di un elemento: stampa il testo 
			    	 if (xmlr.getText().trim().length() > 0) // controlla se il testo non contiene solo spazi
			         //System.out.println("-> " + xmlr.getText()); 
			    	 break;
			    	 }
			    
				 xmlr.next();
			    
			     }
			 
			 } 
		 catch (Exception e) {
			 //System.out.println("Errore nell'inizializzazione del reader:");
			 //System.out.println(e.getMessage()); 
			 }
		 
		 //System.out.println(listaCitta.size());
		 //System.out.println("\n\n\n");		 
		 
		 
		 
		 return listaCitta;
	 }
	 
	 
	 public static HashMap creaHashMap(ArrayList<Citta> listaCitta) {
		 HashMap<Integer, String> mappa = new HashMap<>();
		 for (int k = 0; k < listaCitta.size(); k++) {
			mappa.put(listaCitta.get(k).getId(), listaCitta.get(k).getNome());
		}
		 Iterator<Map.Entry<Integer, String>> it = mappa.entrySet().iterator();
		 while (it.hasNext()) {
			Map.Entry<Integer, String> e = it.next();
			System.out.println(e.getKey()+ " = "+ e.getValue());
		}
		 for (int k = 0; k < listaCitta.size(); k++) {
			System.out.println(listaCitta.get(k)+ " è collegata alla "+listaCitta.get(k).getCollegamenti());
		}
		 
		 return mappa;
	 }
	 
	/**
	 * crea il grafo
	 * @param listaLuoghi, lista estratta dall'xml
	 * @return grafoMappa, grafo creato con i collegamenti fra gli elementi della lista in entrata
	 */
	public GraphTrovato creaGrafo(ArrayList<Citta> listaLuoghi, int scelta, ArrayList<Node> listaNodi) {
		Percorso p = new Percorso();
		//dichiaro il grafo da ritornare alla fine
		GraphTrovato grafoMappa = new GraphTrovato();
		
		
		for (int j = 0; j < listaNodi.size(); j++) {
			for (int i = 0; i < listaLuoghi.get(j).getCollegamenti().size(); i++) {
				int distanza;
					if (scelta == 1) {
						distanza = (int) p.distanzaDaGruppo1(listaLuoghi.get(i), listaLuoghi, j);
						listaNodi.get(j).addDestination(listaNodi.get(i), distanza);
					}
					else {
						distanza = (int) p.distanzaDaGruppo2(listaLuoghi.get(i), listaLuoghi, j);
						listaNodi.get(j).addDestination(listaNodi.get(i), distanza);
					}
				
			}
	
			grafoMappa.addNode(listaNodi.get(j));
		}
		
		/*
		//scorro gli elementi della lista
		for (int i = 0; i < listaLuoghi.size(); i++) {
			//scorro i collegamenti della citta
			for (int j = 0; j < listaLuoghi.get(i).getCollegamenti().size(); j++) {
				if( scelta == 1) {
					grafoMappa.addEdgeOriented(listaLuoghi.get(i).getId(), listaLuoghi.get(i).getCollegamenti().get(j).intValue(),(int) p.distanzaDaGruppo1(listaLuoghi, i, j));
				}
				else grafoMappa.addEdgeOriented(listaLuoghi.get(i).getId(), listaLuoghi.get(i).getCollegamenti().get(j).intValue(),(int) p.distanzaDaGruppo2(listaLuoghi, i, j));
			}
		}
		*/
		
		 return grafoMappa;
	 }
	
	
	
}
