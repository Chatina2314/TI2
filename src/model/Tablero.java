package model;

import java.util.ArrayList;

public class Tablero {
	private Node first;
	private Node last;
	private long size;
	
	private GrupoJugadores players=new GrupoJugadores();
	
	public Tablero(int n, int m) {
		this.size=n*m;
		for(int i=0;i<size;i++) {
			insertFirst(new Node(i+1));
		}
	}
	
	public void insertFirst(Node node) {
		if(first==null) {
			first = node;
			last = node;
		}
		else{
			Node second = first;
			first = node;
			first.setNext(second);
			second.setPrev(first);
		}
	}
	public void insertLast(Node node) {
		if(last==null) {
			first = node;
			last = node;
		}
		else {
			Node beforelast = last;
			last = node;
			beforelast.setNext(last);
			last.setPrev(beforelast);
		}
		size++;
	}
	public void printList(int n, int m) {
		Node current= first;
		
		
		String row = "";
		System.out.println(current.getId());
		while(current.getNext()!=null) {
			
			current = current.getNext();
			if(current.getPersona()!=null) {
				System.out.println(current.getId()+current.printPlayers());
			}
		}
		
		System.out.println("--------------");
		
		current= first;
		
		for(int i=0;i<n;i++) {
			for(int o=0;o<m;o++) {
				if(i%2!=0) {
					row = row+ current.getId() + " ";
				}else {
					if(current.getPersona()==null) {
						row =current.getId() + " "+ row;
					}else {
						row =current.getId() + current.printPlayers()+" "+row;
					}
				}
					current = current.getNext();
			}
			System.out.println(row);
			row="";
			}

	}
	public void addPlayers(int numP, String ficha) {
			Jugador e = new Jugador(ficha, numP);
			players.getData().add(e);
	}
		
	public String printP() {
		String message="";
		for(int i=0; i<players.getData().size();i++) {
			message= players.getData().get(i).getFicha() + players.getData().get(i).getId();
		}
		return message;
	}
	
	
	public void triggerMove(int num, int player) {
		//TODO: Desarrollar el metodo searchNode
		//Node casillaActual = searchNodeOfPlayer();
		Node casillaActual = searchNodeOfPlayer(player);
		if(casillaActual==null) {
			move(last, num);
		}else {
			move(casillaActual, num);
		}
	}
	public Node searchNodeOfPlayer(int num) {
		Node current = first;
		while(current.getNext() != null) {
			current = current.getNext();
			
			if(current.getId()==num) {
				return current;
			}
		}
		return null;
	}
	public void remove(int num) {
		if(first.getId()==num) {
			Node second = first.getNext();
			first = second;
		}
		Node current = first;
		while(current.getNext()!=null) {
			Node next = current.getNext();
			if(next.getId()==num) {
				current.setNext(next.getNext());
			}
			current = next;
		}
	 }
	public void move(Node current, int num) {
		Jugador j= searchPlayer(num);
		if(j!=null && num>0 && current.getPrev() != null) {
			ArrayList<Jugador> listaJugadoresPrevia = current.getPrev().getPersona();		
			//Node casillaActual = searchNodeOfPlayer(num);
			//Eliminar jugador del actual
			if(num>0) {
				ArrayList<Jugador> listaJugadoresActual = current.getPersona();
				listaJugadoresActual.remove(j);
				listaJugadoresPrevia.remove(j);
			}
			
			//Agregamos jugador al prev
			listaJugadoresPrevia.add(j);
			move(current.getPrev(), num-1);
		}else if(current.getNext()==null && current.getPrev()!=null) {
			System.out.println("gana el jugadoer de la ficha "+j.getFicha());
		}else {
			System.out.println("Turno terminado");
		}	
	}
	
	private Jugador searchPlayer(int num) {
		Jugador j=null;
		for(int i=0;i<players.getData().size();i++) {
			j=players.getData().get(i);
			if(j.getId()==num) {
				return j;
			}
		}
		return j;
	}

	public Node getFirst() {
		return first;
	}
	public void setFirst(Node first) {
		this.first = first;
	}
	public Node getLast() {
		return last;
	}
	public void setLast(Node last) {
		this.last = last;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
}
