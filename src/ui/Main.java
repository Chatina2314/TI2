package ui;

import java.util.Scanner;
import model.Tablero;

public class Main {
	int n=3;
	int m=4;
	//Attributes
	private Tablero lista= new Tablero(n, m);;
	
	// global variables
	public static Scanner lector;
		
	public static void main(String[] args) {
		
		lector = new Scanner(System.in);

		Main objMain=new Main();
		boolean menu=true;
		int opcions = 0;
		while(menu){
			System.out.println("1.- Start Game.");
            System.out.println("2.- Exit");
			
			System.out.println("Enter the action to perform: ");
			opcions=Integer.parseInt(lector.nextLine());
			switch(opcions){
			case 1:
				objMain.startGame();
				break;
				case 2:
				menu=false;
				break;
				default:
				System.out.println("Only numbers between 1 and 2.");
				break;
			}
		}
	}
	public void startGame() {
		int num=0;
		System.out.println("Ingrese el numero de jugadores:");
		num=lector.nextInt();
		lector.nextLine();
		createPlayer(num);
		lista.printP();
	}
	public void createPlayer(int num) {
		String ficha=" ";
		if(num>0) {
			System.out.println("Ingresar la ficha del jugador: ");
			ficha=lector.nextLine();
			lista.addPlayers(num, ficha);
			createPlayer(num-1);
		}else {
			turns(num);
		}
	}
	private void turns(int num) {
		System.out.println("Precione 1 para tirar dado jugador");
		int dado= 0;
		dado= lector.nextInt();
		if(dado==1) {
			int dice;
			dice = (int)(Math.random()*6)+1;
			System.out.println(dice);
			//lista.Next();
			lista.triggerMove(dice);
			lista.printList(n, m);
			turns(num-1);
		}
		
	}
	
}