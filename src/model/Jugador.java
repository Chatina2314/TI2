package model;

public class Jugador {
	
	int id;
	String ficha;
	
	public Jugador(String ficha, int id) {
		this.ficha = ficha;
		this.id=id;
	}

	public String getFicha() {
		return ficha;
	}

	public void setFicha(String ficha) {
		this.ficha = ficha;
	}
	
	public int getId() {
		return id;
	}
	

}
