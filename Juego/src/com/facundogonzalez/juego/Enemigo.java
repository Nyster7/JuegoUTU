package com.facundogonzalez.juego;

import java.util.Random;

public class Enemigo extends Personaje{
	int dropEquipo;
	int dropOro;
	int dropPocion;
	String ataquePotente;

	public Enemigo(String nombre, int fuerza, int salud, int armadura, int destreza, int inteligencia, int dropEquipo, int dropOro, int dropPocion, String ataquePotente) {
		super(nombre, fuerza, salud, armadura, destreza, inteligencia);
		this.dropEquipo = dropEquipo;
		this.dropOro = dropOro;
		this.dropPocion = dropPocion;
		this.ataquePotente = ataquePotente;
		// TODO Auto-generated constructor stub
	}
	
	public static Enemigo generarEnemigo(Enemigo [] enemigos) {
		Random aleatorio = 	new Random();
		Enemigo enemigoGenerado = enemigos[aleatorio.nextInt(enemigos.length)];
		return enemigoGenerado;
		
	}
	

}
