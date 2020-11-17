package com.facundogonzalez.juego;

public class Equipo {
	String nombre;
	String slot;
	String set;
	int bonusFuerza;
	int bonusSalud;
	int bonusArmadura;
	int bonusDestreza;
	int bonusInteligencia;
	
	public Equipo(String nombre, String slot, String set, int bonusFuerza, int bonusSalud, int bonusArmadura, int bonusDestreza, int bonusInteligencia) {
		// TODO Auto-generated constructor stub
		this.nombre = nombre;
		this.slot = slot;
		this.set = set;
		this.bonusFuerza = bonusFuerza;
		this.bonusSalud = bonusSalud;
		this.bonusArmadura = bonusArmadura;
		this.bonusDestreza = bonusDestreza;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getBonusFuerza() {
		return bonusFuerza;
	}

	public void setBonusFuerza(int bonusFuerza) {
		this.bonusFuerza = bonusFuerza;
	}

	public int getBonusSalud() {
		return bonusSalud;
	}

	public void setBonusSalud(int bonusSalud) {
		this.bonusSalud = bonusSalud;
	}

	public int getBonusArmadura() {
		return bonusArmadura;
	}

	public void setBonusArmadura(int bonusArmadura) {
		this.bonusArmadura = bonusArmadura;
	}

	public int getBonusDestreza() {
		return bonusDestreza;
	}

	public void setBonusDestreza(int bonusDestreza) {
		this.bonusDestreza = bonusDestreza;
	}

	public int getBonusInteligencia() {
		return bonusInteligencia;
	}

	public void setBonusInteligencia(int bonusInteligencia) {
		this.bonusInteligencia = bonusInteligencia;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public String getSet() {
		return set;
	}

	public void setSet(String set) {
		this.set = set;
	}
	
	
	

}
