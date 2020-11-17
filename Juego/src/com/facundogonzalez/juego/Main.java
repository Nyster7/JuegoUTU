package com.facundogonzalez.juego;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = 		new Scanner(System.in);
		Random aleatorio = 	new Random();
		
		//Variables jugador
		int oroAcumulado =		0;
		int enemigosVencidos =	0;
		int enemigosEvitados =	0;
		int lugaresVisitados =	0;
		int edadJugador;
		String barrioJugador;
		String institucionJugador;
		
		
		// Array de enemigos
		Enemigo [] enemigosLaboratorio = new Enemigo[2];
		//Enemigo("Nombre", fuerza, salud, armadura, destreza, inteligencia, % dropEquipo, dropOro, % dropPocion);
		enemigosLaboratorio[0] = new Enemigo("Harry el viajero", 70, 80, 50, 25, 5, 30, 3, 50, "Pedo");
		enemigosLaboratorio[1] = new Enemigo("Verdugo", 90, 120, 50, 20, 10, 40, 7, 50, "Alabarda sangrienta");
		
		Enemigo [] enemigosSubmarino = new Enemigo [2];
		enemigosSubmarino[0] = new Enemigo("Ahogado mutante", 70, 80, 50, 25, 5, 30, 3, 50, "Escupir acido");
		enemigosSubmarino[1] = new Enemigo("Recluso loco", 90, 120, 50, 20, 10, 40, 7, 50, "Ataque berserker");
		
		Enemigo [] enemigosPlaya = new Enemigo [2];
		enemigosPlaya[0] = new Enemigo("Bandido novato", 80, 100, 50, 25, 5, 30, 3, 50, "Golpe bajo");
		enemigosPlaya[1] = new Enemigo("Bandido veterano", 100, 150, 50, 20, 10, 40, 7, 50, "Puï¿½alada precisa");
		
		Enemigo [] enemigosSotano = new Enemigo [2];
		enemigosSotano[0] = new Enemigo("Mutante asustado", 80, 80, 60, 25, 5, 30, 3, 50, "Ataque frontal");
		enemigosSotano[1] = new Enemigo("Mutante entrenado", 105, 120, 60, 20, 10, 40, 7, 50, "Quebrador de piernas");
		
		// Array equipos
		Equipo [] partesEquipo = new Equipo [12];
		// Set turing
		partesEquipo [0] = new Equipo("Modulo Cerebral de Turing", "Cabeza", "Turing", 0, 0, -5, 0, 5);
		partesEquipo [1] = new Equipo("Tunica de Turing", "Torso", "Turing", 0, 0, 5, 5, 10);
		partesEquipo [2] = new Equipo("Pantalones Church de Turing", "Piernas", "Turing", 0, 0, 5, 10, 0);
		partesEquipo [3] = new Equipo("Deportivas Paddington de Turing", "Pies", "Turing", 0, 0, 0, 5, 0);
		partesEquipo [4] = new Equipo("Pistola de Fotones Enigma", "ManoIzquierda", "Turing", 5, 0, 0, 5, 5);
		partesEquipo [5] = new Equipo("Daga de Church", "ManoDerecha", "Turing", 5, 0, 0, 10, 0);
		// Set elite
		partesEquipo [6] = new Equipo("Casco M12 de ï¿½lite", "Cabeza", "ï¿½lite", 0, 0, 10, 0, 0);
		partesEquipo [7] = new Equipo("Arnadura Troski de ï¿½lite", "Torso", "ï¿½lite", 0, 10, 15, -5, 0);
		partesEquipo [8] = new Equipo("Pantalones Galife de ï¿½lite", "Piernas", "ï¿½lite", 0, 10, 5, 0, 0);
		partesEquipo [9] = new Equipo("Botas Stalin de ï¿½lite", "Pies", "ï¿½lite", 0, 0, 5, 0, 0);
		partesEquipo [10] = new Equipo("Lanza de Ivï¿½n el Terrible", "ManoIzquierda", "ï¿½lite", 15, 0, 0, 0, 0);
		partesEquipo [11] = new Equipo("Gran Escudo del Leï¿½n Rojo", "ManoDerecha", "ï¿½lite", 0, 5, 10, -10, 0);
		
		
		//Variables de las pociones
		int numeroPociones = 	3;
		int curacionPocion = 	30;

		boolean juegoCorriendo = true;
		
		// Constructor de jugador 
		Jugador jugador = new Jugador("nombre", false, null, 100);
		
		// Contructor de objetos default (sin estadisticas)
		Equipo cabeza = new Equipo("Ninguno", "Cabeza", null, 0, 0, 0, 0, 0);
		Equipo torso = new Equipo("Ninguno", "Torso", null, 0, 0, 0, 0, 0);
		Equipo piernas = new Equipo("Ninguno", "Piernas", null, 0, 0, 0, 0, 0);
		Equipo pies = new Equipo("Ninguno", "Pies", null, 0, 0, 0, 0, 0);
		Equipo manoDerecha = new Equipo("Ninguno", "ManoDerecha", null, 0, 0, 0, 0, 0);
		Equipo manoIzquierda = new Equipo("Ninguno", "ManoIzquierda", null, 0, 0, 0, 0, 0);
		
		// Pasando valores
		jugador.cabeza = cabeza;
		jugador.torso = torso;
		jugador.piernas = piernas;
		jugador.pies = pies;
		jugador.manoIzquierda = manoIzquierda;
		jugador.manoDerecha = manoDerecha;
		
		// Pasando bonus de los equipos a las estadisticas del jugador
		jugador.setFuerza(jugador.getFuerza() + jugador.cabeza.bonusFuerza + jugador.torso.bonusFuerza + jugador.piernas.bonusFuerza + jugador.pies.bonusFuerza + jugador.manoDerecha.bonusFuerza + jugador.manoIzquierda.bonusFuerza);
		jugador.setSalud(jugador.getSalud() + jugador.cabeza.bonusSalud + jugador.torso.bonusSalud + jugador.piernas.bonusSalud + jugador.pies.bonusSalud + jugador.manoDerecha.bonusSalud + jugador.manoIzquierda.bonusSalud);
		jugador.setArmadura(jugador.getArmadura() + jugador.cabeza.bonusArmadura + jugador.torso.bonusArmadura + jugador.piernas.bonusArmadura + jugador.pies.bonusArmadura + jugador.manoDerecha.bonusArmadura + jugador.manoIzquierda.bonusArmadura);
		jugador.setDestreza(jugador.getDestreza() + jugador.cabeza.bonusDestreza + jugador.torso.bonusDestreza + jugador.piernas.bonusDestreza + jugador.pies.bonusDestreza + jugador.manoDerecha.bonusDestreza + jugador.manoIzquierda.bonusDestreza);
		jugador.setInteligencia(jugador.getInteligencia() + jugador.cabeza.bonusInteligencia + jugador.torso.bonusInteligencia + jugador.piernas.bonusInteligencia + jugador.pies.bonusInteligencia + jugador.manoDerecha.bonusInteligencia + jugador.manoIzquierda.bonusInteligencia);
		
		// Varibles para controlar cuantas partes de cada set tiene
		int setTuring = 0;
		int setElite = 0;
		
		
		// Apica bonus dependiendo de cuantas partes del set tenga
		if (setTuring >2) {
			jugador.setFuerza(jugador.getFuerza() + 10);
			jugador.setDestreza(jugador.getDestreza() +5);
		}
		if (setTuring >5) {
			jugador.setInteligencia(jugador.getInteligencia() +15);
			jugador.setArmadura(jugador.getArmadura() +10);
		}
		if (setElite >2) {
			jugador.setSalud(jugador.getSalud() + 5);
			jugador.setArmadura(jugador.getArmadura() +10);
		}
		if (setElite >5) {
			jugador.setFuerza(jugador.getFuerza() +20);
			jugador.setSalud(jugador.getSalud() +5);
		}
		
		
		Logica.imprimirEncabezado("Este es un juego desarrollado por estudiantes de utu");
		
		// Pedir nombre al jugador y verificacion
		boolean nombreCorrecto = false;
		while(nombreCorrecto == false) {
			Logica.imprimirEncabezado("Como te llamas?");	
			jugador.nombre = sc.nextLine();
			int respuesta = Logica.eleccionJugador("Te llamas " + jugador.nombre + ". \nEs correcto? \n1. Si \n2. No" , 2);
			if (respuesta == 1) {
				nombreCorrecto = true;
				break;
			}
		}
			
		// Institucion
		boolean confirmarInstitucion = false;
		while(confirmarInstitucion == false) {
			Logica.imprimirEncabezado("A que institucion educativa concurres?");	
			institucionJugador = sc.nextLine();
			int respuesta = Logica.eleccionJugador("Concurres a " + institucionJugador + ". \nEs correcto? \n1. Si \n2. No" , 2);
			if (respuesta == 1) {
				confirmarInstitucion = true;
				break;
			}
		}
		
		// Barrio
		boolean confirmarBarrio = false;
		while(confirmarBarrio == false) {
			Logica.imprimirEncabezado("En que barrio resides?");	
			barrioJugador = sc.nextLine();
			int respuesta = Logica.eleccionJugador("Resides en el bariio " + barrioJugador + ". \nEs correcto? \n1. Si \n2. No" , 2);
			if (respuesta == 1) {
				confirmarBarrio = true;
				break;
			}
		}
		
		// Edad
				boolean confirmarEdad = false;
				while(confirmarEdad == false) {
					Logica.imprimirEncabezado("Que edad tienes?");	
					edadJugador = sc.nextInt();
					
					int respuesta = Logica.eleccionJugador("Tienes " + edadJugador + " años. \nEs correcto? \n1. Si \n2. No" , 2);
					if (respuesta == 1) {
						confirmarEdad = true;
						break;
					}
				}
		
		// Uso de metodo para elegir raza 
		jugador.elegirRaza();
		
		// Metodo para distribuir puntos
		jugador.distribuirPuntos();
		
		Historia.imprimirInicio(jugador);
		lugaresVisitados ++;
		
		boolean eventoInicio = false;
		boolean cofreInicio = false;
		
		
		// El label JUEGO es para que cuando escape de un enemigo vuelva a generar un nuevo encuentro, sino iria al segundo while
		JUEGO:
		while(juegoCorriendo) {
			Logica.imprimirSeparador(50);
			
			while (eventoInicio == false || (enemigosVencidos + enemigosEvitados == 4 && cofreInicio == false)) {
				Historia.imprimirEventoInicio(jugador, enemigosEvitados, enemigosVencidos);
				int respuesta = Logica.eleccionJugador("\n\nQue haces? "
						+ "\n1. Intentar abrir el cofre. "
						+ "\n2. Investigar el objeto brillante. "
						+ "\n3. Deshacerse de los guardias primero.", 3);
				if (respuesta == 1) {
					if(eventoInicio == false) {
						System.out.println("Intentas abrir el cofre pero parece que este no abrira sin la llave."
								+ "\nAlguien te esucha y te ataca por sorpresa desde la espalda."
								+ "\nTe causa 30 de daï¿½o, preparate para luchar!");
						jugador.setSalud(jugador.getSalud() - 30);
						eventoInicio = true;
					}else if(enemigosVencidos + enemigosEvitados == 4) {
						System.out.println("Intentas abrir el cofre pero parece que este no abrira sin la llave.");
					}
				}else if (respuesta == 2){
					System.out.println("El objeto brillante resulto ser una llave, posiblemente del cofre que viste antes."
							+ "\nAbres el cofre y dentro hay un arma.");
					if(jugador.getRaza().equals("Ligitop")){
						Logica.imprimirSeparador(50);
						System.out.println("\tNombre del objeto: " + partesEquipo[10].getNombre() +
								"\n\tSe equipa en: " + partesEquipo[10].getSlot() +
								"\n\tBonus al equipar: " + partesEquipo[10].getBonusFuerza() + " de Fuerza, " + partesEquipo[10].getBonusSalud() + " de Salud, " + partesEquipo[10].getBonusArmadura() + " de Armadura, " + partesEquipo[10].getBonusDestreza() + " de Destreza, " + partesEquipo[10].getBonusInteligencia() + " de Inteligencia");
					}else if(jugador.getRaza().equals("Androide")) {
						System.out.println("\tNombre del objeto: " + partesEquipo[10].getNombre() +
								"\n\tSe equipa en: " + partesEquipo[4].getSlot() +
								"\n\tBonus al equipar: " + partesEquipo[4].getBonusFuerza() + " de Fuerza, " + partesEquipo[4].getBonusSalud() + " de Salud, " + partesEquipo[4].getBonusArmadura() + " de Armadura, " + partesEquipo[4].getBonusDestreza() + " de Destreza, " + partesEquipo[4].getBonusInteligencia() + " de Inteligencia");
					}
					Logica.imprimirSeparador(50);
					if(jugador.manoIzquierda.getNombre() != "Ninguno"){
						System.out.println("Ahora mismo tienes equipado :" + jugador.manoIzquierda.getNombre());
					}
					Logica.imprimirSeparador(50);		
					respuesta = Logica.eleccionJugador("Quieres equiparlo? \n1. Si \n2. No", 2);
					if(respuesta == 1) {
						Equipo armaInicial = null;
						if (jugador.getRaza().equals("Ligitop")) {
							armaInicial = partesEquipo [10];
							setElite ++;
						}else if (jugador.getRaza().equals("Androide")) {
							armaInicial = partesEquipo [4];
							setTuring ++;
						}
						System.out.println("Equipaste " + armaInicial.getNombre());
						eventoInicio = true;
						cofreInicio = true;
					}else {
						System.out.println("Dejaste el arma en el cofre.");
						eventoInicio = true;
					}
					
				}else if (respuesta == 3) {
					
					if (enemigosVencidos + enemigosEvitados < 4) {
						eventoInicio = true;
						break;
					}else {
						System.out.println("Ya no quedan enemigos.");
					}
				}
			}
			
			lugaresVisitados = Historia.imprimirActo(jugador, enemigosVencidos, enemigosEvitados, lugaresVisitados);
			if (enemigosVencidos + enemigosEvitados == 8) {
				break JUEGO;
			}
			
			//Genera encuentro aleatorio con enemigos de la lista
			Enemigo enemigoGenerado = null;
			
			if(jugador.getRaza().equals("Androide")) {
				enemigoGenerado = Enemigo.generarEnemigo(enemigosLaboratorio);
				if(enemigosVencidos + enemigosEvitados > 3) {
					enemigoGenerado = Enemigo.generarEnemigo(enemigosSotano);
				}
			}else if(jugador.getRaza().equals("Ligitop")) {
				enemigoGenerado = Enemigo.generarEnemigo(enemigosSubmarino);
				if(enemigosVencidos + enemigosEvitados > 3) {
					enemigoGenerado = Enemigo.generarEnemigo(enemigosPlaya);
				}
			}
			

			
			int vidaEnemigo = enemigoGenerado.getSalud();
			int ataqueMinimoEnemigo = enemigoGenerado.getFuerza()/2;
			int ataqueMaximoEnemigo = enemigoGenerado.getFuerza();
			
			// Establece un rango de ataque al jugador para usarlo en las batallas
			int ataqueMinimo = jugador.getFuerza()/2;
			int ataqueMaximo = jugador.getFuerza();
			
			Logica.imprimirEncabezado(enemigoGenerado.getNombre() + " te ataca!");
			
			//Mientras la vida del enemigo sea mayor a 0, vuelve a este while
			while(vidaEnemigo > 0) {
				Logica.imprimirSeparador(50);
				System.out.println("\tTu vida: " + jugador.getSalud());
				System.out.println("\tVida de " + enemigoGenerado.getNombre() + ": " + vidaEnemigo);
				System.out.println("\n\t Que te gustaria hacer?");
				System.out.println("\t1. Atacar");
				System.out.println("\t2. Tomar pocion");
				System.out.println("\t3. Huir");
				
				String respuestaUsuario = sc.nextLine();
				
				// Generando valores de ataque aleatorio
				int ataqueRealizado = (aleatorio.nextInt(ataqueMaximo - ataqueMinimo) + ataqueMinimo) - (enemigoGenerado.getArmadura()/2);
				int ataqueRecibido = (aleatorio.nextInt(ataqueMaximoEnemigo - ataqueMinimoEnemigo) + ataqueMinimoEnemigo) - (jugador.getArmadura()/2);
				
				//Opcion de atacar, genera un numero aleatorio tomando como valor maximo el ataque del usuario especificado en las variables
				if(respuestaUsuario.equals("1")) {
					
					
					//Resta vida al enemigo
					if (ataqueRealizado > enemigoGenerado.getSalud() ) {
						ataqueRealizado = ataqueRealizado /2;
					}
					if (ataqueRealizado > vidaEnemigo ) {
						ataqueRealizado = vidaEnemigo;
					}
					if (ataqueRealizado < 0) {
						ataqueRealizado = 5;
					}
					vidaEnemigo -= ataqueRealizado;
					
					//Resta vida al jugador
					if(vidaEnemigo >0 ) {
						if(ataqueRecibido > jugador.getSalud()) {
							ataqueRecibido = jugador.getSalud();
						}
						if(ataqueRecibido < 0) {
							ataqueRecibido = 1;
						}
						jugador.setSalud(jugador.getSalud() - ataqueRecibido);
					}
					
					
					Logica.imprimirSeparador(50);
					if(ataqueRealizado > 50) {System.out.println("\t> Ataque critico!");}
					System.out.println("\t> Atacaste a " + enemigoGenerado.getNombre() + ", haciendole " + ataqueRealizado + " de daï¿½o." );
					if(vidaEnemigo >0 ) { if(ataqueRecibido > 50) {System.out.println("\t> " + enemigoGenerado.getNombre() + " uso " + enemigoGenerado.ataquePotente + ".");}}
					if(vidaEnemigo >0 ) {System.out.println("\t> Recibiste " + ataqueRecibido + " de daï¿½o.");}
					
					
					//Si el enemigo te mata
					if (jugador.getSalud() <1) {
						Logica.imprimirSeparador(50);
						System.out.println("\t> Recibiste mucho daï¿½o, te sientes demasiado debil para continuar.");
						Logica.ingresaAlgo();
						break JUEGO;
					}
					
				//Opcion de tomar pocion	
				}else if(respuestaUsuario.equals("2")) {
					
					//Se fija que tengas al menos 1 pocion, te curas y resta una pocion
					//Si no quedan pociones pasa al else
					if(numeroPociones > 0) {
						jugador.setSalud(jugador.getSalud() + curacionPocion);
						numeroPociones --;
						Logica.imprimirSeparador(50);
						System.out.println("\t> Tomas una pocion que te cura " + curacionPocion + " de vida."
										+ "\n\t> Ahora estas con " +  jugador.getSalud() + " de vida, podes seguir a las piï¿½as."
										+ "\n\t> Te quedan " + numeroPociones + " pociones.\n");
						
					}else {
						Logica.imprimirSeparador(50);
						System.out.println("\t> No te quedan mas pociones, consigue mas ganandole a enemigos.");
					}
				
				//Opcion de escapar la pelea
				}else if(respuestaUsuario.equals("3")) {
					int exitoEscape = jugador.getDestreza() - enemigoGenerado.getDestreza();
					if(aleatorio.nextInt(50) > exitoEscape) {
						Logica.imprimirSeparador(50);
						System.out.println("\tEscapaste de " + enemigoGenerado.getNombre());
						enemigosEvitados += 1;
						
						//Vuelve al loop JUEGO, para generar un nuevo enemigo
						continue JUEGO;	
						
					}else {
						Logica.imprimirSeparador(50);
						System.out.println("\t>No pudiste escapar");
						jugador.setSalud(jugador.getSalud() - ataqueRecibido);
						
						Logica.imprimirSeparador(50);
						System.out.println("\t> Recibiste " + ataqueRecibido + " de daï¿½o.");
						if (jugador.getSalud() <1) {
							Logica.imprimirSeparador(50);
							System.out.println("\t> Recibiste mucho daï¿½o, te sientes demasiado debil para continuar.");
							oroAcumulado = 0;
							Logica.ingresaAlgo();
							Historia.mensajeDerrota(jugador);
							Logica.ingresaAlgo();
							Logica.clearConsole();
							break JUEGO;
						}
					}
					
					
								
				}else {
					// Mensaje de error
					Logica.imprimirSeparador(50);
					System.out.println("Comando invalido, por favor ingresa un numero valido.");
				}
			}
			
			//Mensaje enemigo derrotado y drop de pocion
			Logica.imprimirSeparador(50);
			System.out.println(" # " + enemigoGenerado.getNombre() + " fue derrotado! #");
			System.out.println(" # " + "Saliste de la batalla con " + jugador.getSalud() + " puntos de vida. #");
			System.out.println(" # " + enemigoGenerado.getNombre() + " tiro " + enemigoGenerado.dropOro + " monedas de oro #");
			
			oroAcumulado += enemigoGenerado.dropOro;
			enemigosVencidos += 1;
			
			//Si el numero es mayor al porcentaje del drop (50 en este caso), el enemigo dropea una pocion
			if(aleatorio.nextInt(100) > enemigoGenerado.dropPocion) {
				numeroPociones++;
				System.out.println(" # " + enemigoGenerado.getNombre() + " tiro una pocion! # ");
				System.out.println(" # Ahora tenes " + numeroPociones + " pocion(es). # " );
				
			}
			
			// Drop parte de equipo
			if(aleatorio.nextInt(100) > enemigoGenerado.dropEquipo) {
				Equipo equipoDropeado = partesEquipo [aleatorio.nextInt(partesEquipo.length)];
				System.out.println(" # " + enemigoGenerado.getNombre() + " tiro una parte de equipamiento! # ");
				System.out.println("\tNombre del objeto: " + equipoDropeado.getNombre() +
						"\n\tSe equipa en: " + equipoDropeado.getSlot() +
						"\n\tBonus al equipar: " + equipoDropeado.getBonusFuerza() + " de Fuerza, " + equipoDropeado.getBonusSalud() + " de Salud, " + equipoDropeado.getBonusArmadura() + " de Armadura, " + equipoDropeado.getBonusDestreza() + " de Destreza, " + equipoDropeado.getBonusInteligencia() + " de Inteligencia");
				
				// Confirmar si equiparlo o no
				System.out.println("Quieres equiparlo? \n1. Si \n2. No");
				String respuestaUsuario = sc.nextLine();
				
				// Mientras el usuario no responda 1 o 2, se queda en este blucle
				while(!respuestaUsuario.equals("1") && !respuestaUsuario.equals("2") ) {
					System.out.println("Comando Incorrecto");
				}
				
				// El jugador equipa el objeto
				if (respuestaUsuario.equals("1")) {
					System.out.println(" # Equipaste " + equipoDropeado.getNombre() + "! # ");
					
					// Verifica si el objeto a equipar ya lo tiene 
					if (equipoDropeado.getNombre().equals(jugador.cabeza.getNombre()) 
							|| equipoDropeado.getNombre().equals(jugador.torso.getNombre())
							|| equipoDropeado.getNombre().equals(jugador.piernas.getNombre()) 
							|| equipoDropeado.getNombre().equals(jugador.pies.getNombre()) 
							|| equipoDropeado.getNombre().equals(jugador.manoDerecha.getNombre())
							|| equipoDropeado.getNombre().equals(jugador.manoIzquierda.getNombre())) {
						
						// En caso de querer equipar un objeto con el mismo nombre, quita 1 al contador del set y luego lo vuelve a sumar
						if(equipoDropeado.getSet().equals("Turing")) {
							setTuring --;
							setTuring ++;
						}else if(equipoDropeado.getSet().equals("ï¿½lite")) {
							setElite --;
							setElite ++;
						}
					}
					// En caso de no tener una parte igual, suma al contador de partes del set
					if (equipoDropeado.getSet().equals("Turing")) {
						setTuring ++;
					}else if (equipoDropeado.getSet().equals("ï¿½lite")) {
						setElite ++;
					}
					
					// Verificar a que slot pertenece y pasar los atributos
					if (equipoDropeado.getSlot().equals("Cabeza")) {
						jugador.cabeza = equipoDropeado;
					}else if (equipoDropeado.getSlot().equals("Torso")) {
						jugador.torso = equipoDropeado;
					}else if (equipoDropeado.getSlot().equals("Piernas")) {
						jugador.piernas = equipoDropeado;
					}else if (equipoDropeado.getSlot().equals("Pies")) {
						jugador.pies = equipoDropeado;
					}else if (equipoDropeado.getSlot().equals("ManoDerecha")) {
						jugador.manoDerecha = equipoDropeado;
					}else if (equipoDropeado.getSlot().equals("ManoIzquierda")) {
						jugador.manoIzquierda = equipoDropeado;
					}
				
				// En caso de no querer el objeto
				}else {
					System.out.println("Dejas el Objeto tirado");
				}
			}
			
			// Despues de una batalla, una pausa
			while(juegoCorriendo) {
				Logica.imprimirSeparador(50);
				System.out.println("Que te gustaria hacer ahora?");
				System.out.println("1. Continuar Explorando.");
				System.out.println("2. Tomar Pocion.");
				System.out.println("3. Informacion del Personaje");
				System.out.println("4. Salir.");
				
				String respuestaUsuario = sc.nextLine();
				
				// Sigue jugando
				if(respuestaUsuario.equals("1")) {
					Logica.imprimirSeparador(50);
					System.out.println("\nContinuas explorando. \n");
					continue JUEGO;
				
				// Usar una pocion
				}else if(respuestaUsuario.equals("2")) {
					if(numeroPociones > 0) {
						Logica.imprimirSeparador(50);
						jugador.setSalud(jugador.getSalud() + curacionPocion);;
						numeroPociones --;
						System.out.println("\t> Tomas una pocion que te cura " + curacionPocion + " de vida."
										+ "\n\t> Ahora estas con " +  jugador.getSalud() + " de vida, podes seguir a las piï¿½as."
										+ "\n\t> Te quedan " + numeroPociones + " pociones.\n");
					}else {
						Logica.imprimirSeparador(50);
						System.out.println("\t> No te quedan mas pociones, consigue mas ganandole a enemigos.");
					}
				}else if(respuestaUsuario.equals("3")) {
					Logica.informacionPersonaje(jugador, numeroPociones, setTuring, setElite);
					
				// Dejar de jugar
				}else if(respuestaUsuario.equals("4")) {
					Logica.imprimirSeparador(50);
					System.out.println("\nAbandonaste el lugar. \n");
					Logica.ingresaAlgo();
					break JUEGO;
				}else {
					Logica.imprimirSeparador(50);
					System.out.println("Comando invalido.");
				}
				
			}
			
		}// Final while JUEGO
		
		if (enemigosVencidos + enemigosEvitados == 8) {
			Historia.finalBueno(jugador);
			Logica.ingresaAlgo();
		}
		
		Logica.clearConsole();
		Logica.imprimirEncabezado("Venciste a " + enemigosVencidos + " enemigos.");
		Logica.imprimirEncabezado("Evitaste a " + enemigosEvitados + " enemigos.");
		Logica.imprimirEncabezado("Acumulaste " + oroAcumulado + " monedas de oro.");
		if(enemigosVencidos == 8) {
			Logica.imprimirEncabezado("Nivel de aventurero: Hï¿½roe Supremo");
		}else if (enemigosVencidos > enemigosEvitados) {
			Logica.imprimirEncabezado("Nivel de aventurero: Aventurero de Paso");
		}else if (enemigosVencidos < enemigosEvitados) {
			Logica.imprimirEncabezado("Nivel de aventurero: Luchando por Sobrevivir");
		}
		Logica.imprimirEncabezado("Visitaste " + lugaresVisitados + " lugares.");
		System.out.println("///////////////////////////////////////////");
		System.out.println(" #           GRACIAS POR JUGAR           # ");
		System.out.println("///////////////////////////////////////////");
		

	}

}
