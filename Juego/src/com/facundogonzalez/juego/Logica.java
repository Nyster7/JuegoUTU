package com.facundogonzalez.juego;
import java.util.Random;
import java.util.Scanner;

public class Logica {
	static Scanner sc = new Scanner (System.in);
	static Random aleatorio = 	new Random();
	
	//Metodo para obtener respuesta del usuario
	public static int eleccionJugador(String textoInformativo, int eleccionesUsuario) {
		int respuesta;
		
		do {
			System.out.println(textoInformativo);
			try {
				respuesta = Integer.parseInt(sc.next());
			}catch(Exception e) {
				respuesta = -1;
				System.out.println("Por favor, ingresa un numero correcto!");
			}
		}while(respuesta <1 || respuesta > eleccionesUsuario);
		return respuesta;
	}
	
	//Metodo que simula limpiar la consola, imprime campos vacios
	public static void clearConsole() {
		for(int i = 0; i < 100; i++)
			System.out.println();
	}
	
	//Metodo imprimir separador, entre () va el numero de veces que queremos repetir el guion
	public static void imprimirSeparador(int n) {
		for(int i = 0; i < n; i++)
			System.out.print("-");
		System.out.println();
	}
	
	//Metodo para imprimir un encabezado
	public static void imprimirEncabezado(String titulo) {
		imprimirSeparador(45);
		System.out.println("\t# " + titulo + " #");
		imprimirSeparador(45);
	}
	
	//Metodo para parar el juego hasta que el usuario escriba algo
	public static void ingresaAlgo() {
		System.out.println("\n Ingresa algo a la consola para continuar...");
		sc.next();
	}
	
	public static void informacionPersonaje(Jugador jugador, int numeroPociones, int setTuring, int setElite) {
		clearConsole();
		imprimirEncabezado("INFORMACION DEL PERSONAJE");
		System.out.println(jugador.getNombre() + "\t SALUD: " + jugador.getSalud());
		imprimirSeparador(50);
		System.out.println("POCIONES: " + numeroPociones);
		
		imprimirEncabezado("EQUIPO :");
		System.out.println("\tCabeza: " + jugador.cabeza.nombre + "\n\tTorso: " + jugador.torso.nombre + "\n\tPiernas: " + jugador.piernas.nombre
				+ "\n\tPies: " + jugador.pies.nombre + "\n\tMano Izquierda: " + jugador.manoIzquierda.nombre + "\n\tMano Derecha: " + jugador.manoDerecha.nombre);
		
		if(setTuring > 2) {
			System.out.println("Bonus set Alan Turing : \n3 piezas: +10 Fuerza\t +5 Destreza");
			if(setTuring >5) {
				System.out.println("6 piezas: +15 Inteligencia\t +10 Armadura");
			}
		}
		if (setElite >3) {
			System.out.println("Bonus set Élite Roja : \n3 piezas: +5 Salud\t +10 Armadura");
			if(setElite >5) {
				System.out.println("6 piezas: +20 Fuerza\t +5 Salud");
			}
		}
		
		ingresaAlgo();
	}


}
