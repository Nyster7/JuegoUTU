package com.facundogonzalez.juego;

public class Historia {
	
	public static void imprimirInicio(Jugador jugador) {
		
		Logica.imprimirSeparador(50);
		
		if (jugador.getRaza().equals("Ligitop")) {
			Logica.imprimirEncabezado("Acto 1: Escape del sbmarino");
			System.out.print("Bienvendo " + jugador.getNombre());
			System.out.println("Te encuentras en un submarino, abandonado a tu "
					+ "\nsuerte por los cientificos que experimentaron contigo y"
					+ "\n los demas reclusos. Decides abrirte paso hacia la superficie...");
			Logica.ingresaAlgo();
			Logica.clearConsole();
			
		}else if (jugador.getRaza().equals("Androide")){
			Logica.imprimirEncabezado("Acto 1: El laboratorio");
			System.out.print("Bienvendo " + jugador.getNombre());
			System.out.println("Tras recibir un encargo de investigar un antiguo "
					+ "\nlaboratorio abandonado, notas como el lugar está "
					+ "\ncustodiado por fuera, entonces decides ir por una ventana de atrás. "
					+ "\nAquí comienza tu viaje como cazarrecompensas...");
			Logica.ingresaAlgo();
			Logica.clearConsole();
		}
	
	}
	
	public static void imprimirEventoInicio(Jugador jugador, int enemigosVencidos, int enemigosEvitados) {
		if (jugador.getRaza().equals("Ligitop")) {
			if (enemigosVencidos + enemigosEvitados == 4) {
				Logica.imprimirSeparador(50);
				System.out.println("Felicidades " + jugador.getNombre() + " lograste despejar el area.");
			}else{
				System.out.println("No estas solo en el submarino, notas como "
						+ "\nalgunos reclusos enoloquecieron debido al encierro, otros que creimos"
						+ "\n ahogados, al parecer no lo estan, de alguna forma u otra la radiacion los devolvio "
						+ "\na la vida, pero no parecen ser los mismos de antes. Cualquiera de estos parecen dispuestos a atacar."
						+ "\nLogras ver un objeto brillante en el suelo, pero no logras distinguir de que se trata."
						+ "\nEn una de las habitaciones se puede ver un cofre.");	
			}
			
		}else if (jugador.getRaza().equals("Androide")){
			if (enemigosVencidos + enemigosEvitados == 4) {
				System.out.println("Felicidades " + jugador.getNombre() + " lograste despejar el area.");
			}else{
				System.out.println("Al entrar notas que el laboratorio esta siendo patrullado por 4 guardias."
						+ "\nA tu derecha se encuentra un cofre, te crees capaz de llegar a el sin ser detectado "
						+ "\ndebido a tu habilidad de sigilo. "
						+ "\nA la izquierda se puede ver una especie de objeto brillante, pero no logras distinguir que es.");
			}
		}
	}
	
	public static int imprimirActo(Jugador jugador, int enemigosVencidos, int enemigosEvitados, int lugaresVisitados) {
		int enemigosEncontrados = enemigosVencidos + enemigosEvitados;
		if (enemigosEncontrados == 4 ) {
			lugaresVisitados ++;
			if(jugador.getRaza().equals("Ligitop")) {
				Logica.imprimirEncabezado("Acto 2 : Superficie");
				System.out.println("Lograste salir del submarino y llegas a una playa."
						+ "\nCansado de tanto esfuerzo, decides hace una fogata y pasar la noche ahi.");
				Logica.ingresaAlgo();
				Logica.clearConsole();
				System.out.println("Escuchas a alguien acercarse corriendo, te despiertas para ver que hacia ti viene"
						+ "\nun grupo de bandidos dispuestos a saquearte. Preparate para luchar" + jugador.getNombre());
			}else if (jugador.getRaza().equals("Androide")) {
				Logica.imprimirEncabezado("Acto 2 : Sotano");
				System.out.println("Lograste avanzar hasta la puerta del sotano y decides bajar."
						+ "\nEn el sotano hay mas mutantes, son 10 mas que tu."
						+ "\nHay niños y mujeres que parecen muy asustados."
						+ "\nOtro grupo parece dispuesto a defenderlos, sin escuchar razones te atacan."
						+ "\nPreparate para luchar" + jugador.getNombre());
			}
			
			
			Logica.ingresaAlgo();
		}else if (enemigosEncontrados == 8) {
			Logica.imprimirEncabezado("Acto 3");
			System.out.println("Felicidades " + jugador.getNombre() + " lograste pasar el segundo escenario."
					+ "\nEsta version del juego llega hasta aqui, gracias por jugar.");
			Logica.ingresaAlgo();
			lugaresVisitados ++;
		}
		return lugaresVisitados;
	}
	
	public static void finalBueno(Jugador jugador) {
		if(jugador.getRaza().equals("Ligitop")) {
			System.out.println("Lograste escapar de los bandidos y ahora emprendes una nueva"
					+ "\n aventura, ir a buscar mas gente como tu. Pero alto te dice que no "
					+ "\nsera facil debido a tu apariencia y tendras que enfrentar mas dificultades.");
		}else if(jugador.getRaza().equals("Androide")) {
			System.out.println("Luego de pasar tanto tiempo cazando a estos -Monstruos mutantes- "
					+ "\ncomo los llaman los humanos, te das cuenta de que no todo es blanco y negro."
					+ "\nNo todos los mutantes son malos y muchas veces te toco escoger un mal sobre otro."
					+ "\nAhora estás decidido a buscar al hombre que te traiciono, el que alguna "
					+ "\nvez te salvó la vida y te hizo el androide que eres.");
		}
	}
	
	public static void mensajeDerrota(Jugador jugador) {
		if(jugador.getRaza().equals("Ligitop")) {
			System.out.println("Es sociedad te enterro y te olvido, a pesar de tus esfuerzos por"
					+ "\n ser algo diferente, no lograste sobrevivir en este nuevo mundo plagado"
					+ "\n de mutantes como tu, y humanos despiadados que te hicieron lo que eres."
					+ "\nLa rabia te corre por dentro pero tus organos vitales ya no responden, "
					+ "\na pesar de las mutaciones, sabes que estas muriendo.");
		}else if(jugador.getRaza().equals("Androide")) {
			System.out.println("Tus fallos internos y constantes alertas en el sistema te hacen saber "
					+ "\nque estás muriendo, no dejas de pensar que acabarás muriendo siendo una mera"
					+ "\n herramienta, utilizada para hacer el trabajo sucio de otros.. "
					+ "\nMatando monstruos para otros monstruos.");
		}
	}
}
