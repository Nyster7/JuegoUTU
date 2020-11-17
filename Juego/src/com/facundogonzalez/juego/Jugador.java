package com.facundogonzalez.juego;

import java.util.Scanner;
//Cabeza, Torso, Piernas, Pies, Mano derecha, Mano Izquierda.
public class Jugador extends Personaje{
	public boolean razaSeleccionada = false;
	public String raza;
	public int puntosDistribuir;
	public Equipo cabeza;
	public Equipo torso;
	public Equipo piernas;
	public Equipo pies;
	public Equipo manoDerecha;
	public Equipo manoIzquierda;


	public Jugador(String nombre, boolean razaSeleccionada, String raza, int puntosDistribuir) {
		
		super(nombre, 30, 150, 30, 20, 20);
		this.razaSeleccionada = razaSeleccionada;
		this.raza = raza;
		this.puntosDistribuir = puntosDistribuir;
		// TODO Auto-generated constructor stub
	}
	
	
	
	public void elegirRaza() {
		Scanner sc = new Scanner(System.in);
		SELECCIONRAZA:
		while(isRazaSeleccionada() == false) {
			
			System.out.println("Selecciona una raza"
					+ "\n1. Ligiop \t Bonus: +10 Fuerza"
					+ "\n2. Androide \t Bonus: +10 Destreza");
			int respuestaUsuario = sc.nextInt();
			
			if(respuestaUsuario == 1) {
	
				System.out.println("Estas seguro de que quieres la raza Ligitop?"
									+ "\n1. Si"
									+ "\n2. No");
				respuestaUsuario = sc.nextInt();
				
				if(respuestaUsuario == 1) {
					setFuerza(getFuerza() + 10);
					raza = "Ligitop";
					razaSeleccionada = true;
					System.out.println("Tu raza ahora es " + raza);
				}else if(respuestaUsuario == 2) {
					continue SELECCIONRAZA;
				}else {
					System.out.println("Ingresa un numero valido");
					continue SELECCIONRAZA;
				}
				
				
			}else if(respuestaUsuario == 2){
				System.out.println("Estas seguro de que quieres la raza Androide?"
									+ "\n1. Si"
									+ "\n2. No");
				respuestaUsuario = sc.nextInt();
				
				if(respuestaUsuario == 1) {
					setDestreza(getDestreza() +10);
					raza = "Androide";
					razaSeleccionada = true;
					System.out.println("Tu raza ahora es " + raza);
					
				}else if(respuestaUsuario == 2) {
					continue SELECCIONRAZA;
				}else {
					System.out.println("Ingresa un numero valido");
					continue SELECCIONRAZA;
				}
				
				
			}else {
				System.out.println("Ingresa un numero valido");
				continue SELECCIONRAZA;
			}
		}
	}
	
	
	public void distribuirPuntos() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nTienes " + puntosDistribuir + " puntos para distribuir entre 5 estadisticas.");
		System.out.println("Cada estadistica afecta dentro del juego, por ejemplo la fuerza y la armadura se utilizan para los calculos de la batalla.");
		System.out.println("Tus puntos de salud tambien forman parte de la aventura ya que si llegas a 0 significa que te mataron.");
		DISTRIBUIRPUTNOS:
		while(puntosDistribuir >0 ) {
			System.out.println("\nEn que quieres distribuir tus putnos? \tTe quedan " + puntosDistribuir + " puntos para distribuir");
			System.out.println("1. Fuerza"
					+ "\n2. Salud"
					+ "\n3. Armadura"
					+ "\n4. Destreza"
					+ "\n5. Inteligencia");
			int respuestaUsuario = sc.nextInt();
			
			if(respuestaUsuario == 1) {
				System.out.println("\nIngresa cuantos puntos distribuir en fuerza");
				int puntosStats = sc.nextInt();
				if(puntosStats > puntosDistribuir){
					System.out.println("\nNo tienes tantos puntos para distribuir, te quedan " + puntosDistribuir);
					continue DISTRIBUIRPUTNOS;
				}
				setFuerza(getFuerza() + puntosStats);
				puntosDistribuir -= puntosStats;
				
			}else if(respuestaUsuario == 2){
				System.out.println("\nIngresa cuantos puntos distribuir en salud");
				int puntosStats = sc.nextInt();
				if(puntosStats > puntosDistribuir){
					System.out.println("\nNo tienes tantos puntos para distribuir, te quedan " + puntosDistribuir);
					continue DISTRIBUIRPUTNOS;
				}
				setSalud(getSalud() + puntosStats);
				puntosDistribuir -= puntosStats;
				
			}else if(respuestaUsuario == 3){
				System.out.println("\nIngresa cuantos puntos distribuir en armadura");
				int puntosStats = sc.nextInt();
				if(puntosStats > puntosDistribuir){
					System.out.println("\nNo tienes tantos puntos para distribuir, te quedan " + puntosDistribuir);
					continue DISTRIBUIRPUTNOS;
				}
				setArmadura(getArmadura() + puntosStats);
				puntosDistribuir -= puntosStats;
				
			}else if(respuestaUsuario == 4){
				System.out.println("\nIngresa cuantos puntos distribuir en destreza");
				int puntosStats = sc.nextInt();
				if(puntosStats > puntosDistribuir){
					System.out.println("\nNo tienes tantos puntos para distribuir, te quedan " + puntosDistribuir);
					continue DISTRIBUIRPUTNOS;
				}
				setDestreza(getDestreza() + puntosStats);
				puntosDistribuir -= puntosStats;
				
			}else if(respuestaUsuario == 5){
				System.out.println("\nIngresa cuantos puntos distribuir en inteligencia");
				int puntosStats = sc.nextInt();
				if(puntosStats > puntosDistribuir){
					System.out.println("\nNo tienes tantos puntos para distribuir, te quedan " + puntosDistribuir);
					continue DISTRIBUIRPUTNOS;
				}
				setInteligencia(getInteligencia() + puntosStats);
				puntosDistribuir -= puntosStats;
			}else {
				System.out.println("Ingresa un numero correcto");
				continue DISTRIBUIRPUTNOS;
			}
			
			Logica.imprimirSeparador(50);
			System.out.println("Fuerza: " + getFuerza()
					+ "\nSalud: " + getSalud()
					+ "\nArmadura: " + getArmadura()
					+ "\nDestreza: " + getDestreza()
					+ "\nInteligencia: " + getInteligencia());
			Logica.ingresaAlgo();
			Logica.clearConsole();
		}
	}

	public boolean isRazaSeleccionada() {
		return razaSeleccionada;
	}


	public void setRazaSeleccionada(boolean razaSeleccionada) {
		this.razaSeleccionada = razaSeleccionada;
	}


	public String getRaza() {
		return raza;
	}


	public void setRaza(String raza) {
		this.raza = raza;
	}


	public int getPuntosDistribuir() {
		return puntosDistribuir;
	}


	public void setPuntosDistribuir(int puntosDistribuir) {
		this.puntosDistribuir = puntosDistribuir;
	}



	public Equipo getCabeza() {
		return cabeza;
	}



	public void setCabeza(Equipo cabeza) {
		this.cabeza = cabeza;
	}



	public Equipo getTorso() {
		return torso;
	}



	public void setTorso(Equipo torso) {
		this.torso = torso;
	}



	public Equipo getPiernas() {
		return piernas;
	}



	public void setPiernas(Equipo piernas) {
		this.piernas = piernas;
	}



	public Equipo getPies() {
		return pies;
	}



	public void setPies(Equipo pies) {
		this.pies = pies;
	}



	public Equipo getManoDerecha() {
		return manoDerecha;
	}



	public void setManoDerecha(Equipo manoDerecha) {
		this.manoDerecha = manoDerecha;
	}



	public Equipo getManoIzquierda() {
		return manoIzquierda;
	}



	public void setManoIzquierda(Equipo manoIzquierda) {
		this.manoIzquierda = manoIzquierda;
	}




	
	
	

}
