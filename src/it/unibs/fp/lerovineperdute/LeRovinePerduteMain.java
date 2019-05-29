package it.unibs.fp.lerovineperdute;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

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
			Node nodo = new Node(listaEstratta.get(i).getId(), listaEstratta.get(i).getNome());
			listaNodi.add(nodo);
		}
			
		GraphTrovato grafo = g.creaGrafo(listaEstratta, 1, listaNodi);
		
		LinkedHashSet<Node> set = Dijkstra.calculateShortestPathFromSource(grafo, listaNodi.get(0));
		
		
		Iterator iter = set.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
			}
		 
		
		for (int i = 0; i < set.size(); i++) {
			//System.out.println("Codice: " + listaEstratta.get(set.get(i).getId()).getId() + "\tNome città: " + listaEstratta.get(set.get(i).getId()).getNome());
		}
		
		System.out.println("**************************************");
		grafo = g.creaGrafo(listaEstratta, 2, listaNodi);
		
		set = Dijkstra.calculateShortestPathFromSource(grafo, listaNodi.get(0));
		
		iter = set.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
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
		
		private static void write(String fileName, LinkedList<Persona> persone, LinkedList<CodiceFiscale> codiciSpaiati, LinkedList<CodiceFiscale> codiciFalsi) {
	        System.out.println("Sto scrivendo il file...");
	        XMLOutputFactory output = XMLOutputFactory.newInstance();
	        XMLStreamWriter writer;

	        try {
	            writer = output.createXMLStreamWriter(new FileWriter(fileName));
	            writer.writeStartDocument("utf-8","1.0");
	            writer.writeStartElement("output"); //apro il tag output
	            writer.writeStartElement("persone"); //apro il tag persone
	            writer.writeAttribute("numero", persone.size()+""); //scrivo nel tag persone quanti sottoelementi contiene
	           //in questo ciclo scrivo nel file tutte le persone col rispettivo codice fiscale
	            for(Persona persona: persone) {
	                writer.writeStartElement("persona"); //apro il tag persona
	                writer.writeAttribute("id", persona.getId()+""); //scrivo nel tag persona l'id
	                writer.writeStartElement("nome"); //apro il tag nome
	                writer.writeCharacters(persona.getNome()); //scrivo il nome della persona
	                writer.writeEndElement(); // chiudo nome
	                writer.writeStartElement("cognome"); //apro il tag cognome
	                writer.writeCharacters(persona.getCognome()); //scrivo il cognome della persona
	                writer.writeEndElement(); //chiudo cognome
	                writer.writeStartElement("sesso"); //apro il tag sesso
	                writer.writeCharacters(persona.getSesso()+""); //scrivo il sesso della persona
	                writer.writeEndElement(); //chiudo sesso
	                writer.writeStartElement("comune_nascita"); //apro il tag comune_nascita
	                writer.writeCharacters(persona.getLuogoNascita()); //scrivo il luogo di nascita della persona
	                writer.writeEndElement(); //chiudo comune_nascita
	                writer.writeStartElement("data_nascita"); //apro il tag data_nascita
	                writer.writeCharacters(persona.getDataNascita()); //scrivo la data di nascita della persona
	                writer.writeEndElement(); //chiudo data_nascita
	                writer.writeStartElement("codice_fiscale"); //apro il tag codice_fiscale
	                if(!persona.hasCodiceFiscale()) //controllo se la persona ha il codice fiscale (se non lo ha vuol dire che non era presente nel file codiciFiscali.xml
	                    writer.writeCharacters("ASSENTE"); //se non lo ha scrivo assente
	                else
	                    writer.writeCharacters(persona.getCodiceFiscale().toString()); // se lo ha scrivo il codice fiscale
	                writer.writeEndElement(); //chiudo  codice_fiscale
	                writer.writeEndElement(); //chiudo persona
	            }
	            writer.writeEndElement(); //chiudo persone
	            writer.writeStartElement("codici"); //apro il tag codici
	            writer.writeStartElement("invalidi"); //apro il tag invalidi
	            writer.writeAttribute("numero",codiciFalsi.size()+""); //scrivo in invalidi quanti sottoelementi contiene
	           //questo ciclo scrive tutti i codici con la sintassi errata
	            for(CodiceFiscale codice : codiciFalsi){
	                writer.writeStartElement("codice"); //apro il tag codice
	                writer.writeCharacters(codice.toString()); //scrivo il codice errato
	                writer.writeEndElement(); //chiudo codice
	            }
	            writer.writeEndElement(); //chiudo invalidi
	            writer.writeStartElement("spaiati"); //apro il tag spaiati
	            writer.writeAttribute("numero",codiciSpaiati.size()+""); //scrivo in spaiati quanti sottoelementi contiene
	            //questo ciclo scrive tutti i codici con la sintassi corretta ma senza corrispondenza nel file inputoPersone
	            for(CodiceFiscale codice : codiciSpaiati){
	                writer.writeStartElement("codice"); //apro il tag codice
	                writer.writeCharacters(codice.toString()); //scrivo il codice spaiato
	                writer.writeEndElement(); //chiudo codice
	            }
	            writer.writeEndElement(); //chiudo spaiati
	            writer.writeEndElement(); //chiudo codici
	            writer.writeEndElement(); //chiudo output
	            writer.writeEndDocument(); //termino il documento
	            writer.flush(); //svuoto la cache di writer
	            writer.close(); //chiudo writer
	            System.out.println("scritto");
	        }
	        catch (Exception e) {
	            System.out.print("Errore");
	            e.printStackTrace();
	        }
	    }
		
        
	}

}
