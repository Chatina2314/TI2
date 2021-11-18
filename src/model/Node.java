package model;

import java.util.ArrayList;

public class Node {
	//Valores
	private ArrayList<Jugador> persona;
	private int id;

	public Node(int id) {
		this.id = id;
		persona = new ArrayList<Jugador>();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	//Enlaces
	private Node next;
	private Node prev;

	public ArrayList<Jugador> getPersona() {
		return persona;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Node getPrev() {
		return prev;
	}
	public void setPrev(Node prev) {
		this.prev = prev;
	}
	public String printPlayers() {
		String output = "";
		for(int i=0 ;  i<persona.size() ; i++) {
			output += persona.get(i).getFicha();
		}
		return output;
	}
}