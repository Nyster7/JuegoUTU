package com.facundogonzalez.juego;
//Fuerza; Salud; Armadura; Destreza; Inteligencia,
//Cabeza, Torso, Piernas, Pies, Mano derecha, Mano Izquierda.


public abstract class Personaje {
	public String nombre;
	private int fuerza, 
					salud, 
					armadura, 
					destreza, 
					inteligencia;

						
	public Personaje(String nombre, int fuerza, int salud, int armadura, int destreza, int inteligencia) {
		// TODO Auto-generated constructor stub
		this.nombre = nombre;
		this.fuerza = fuerza;
		this.salud = salud;
		this.armadura = armadura;
		this.destreza = destreza;
		this.inteligencia = inteligencia;
	}
	


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}

	public int getArmadura() {
		return armadura;
	}

	public void setArmadura(int armadura) {
		this.armadura = armadura;
	}

	public int getDestreza() {
		return destreza;
	}

	public void setDestreza(int destreza) {
		this.destreza = destreza;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}
	
	
}
