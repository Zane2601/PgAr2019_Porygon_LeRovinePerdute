package it.unibs.fp.lerovineperdute;

import java.util.ArrayList;

public class Citta {
	private int id;
	private String nome;
	private int x;
	private int y;
	private int z;
	private ArrayList<Integer> collegamenti = new ArrayList<Integer>();
	
	
	public Citta(int _id, String _nome, int _x, int _y, int _z) {
		this.id=_id;
		this.nome=_nome;
		this.x=_x;
		this.y=_y;
		this.z=_z;
	}
	
	public Citta() {
		
	}


	public int getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}


	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}


	public int getZ() {
		return z;
	}

	public ArrayList<Integer> getCollegamenti () {
		return collegamenti;
	}

	public void setId(int id) {
		this.id = id;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public void setX(int x) {
		this.x = x;
	}


	public void setY(int y) {
		this.y = y;
	}


	public void setZ(int z) {
		this.z = z;
	}
	

}
