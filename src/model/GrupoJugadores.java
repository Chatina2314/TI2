package model;

import java.util.ArrayList;

public class GrupoJugadores {
	
	ArrayList<Jugador> jugadores;
	
	public GrupoJugadores() {
		jugadores = new ArrayList<>();
	}
	
	public ArrayList<Jugador> getData() {
		return jugadores;
	}
	
	
	public void printPlayers() {
		String output = "";
		for(int i=0 ;  i<jugadores.size() ; i++) {
			output += jugadores.get(i).getFicha();
		}
		System.out.println(output);
	}

}
