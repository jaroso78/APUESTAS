/**
 * 
 * @author JAVIER RODR�GUEZ SOLER. 
 * EJERCICIO APUESTAS
 * Clase  Liga
 */

import java.io.Serializable;

public class Liga implements Serializable {

	// Definici�n atributos.
	int numEquipos;
	String nombreLiga;
	Equipo equipos[];

	// Constructor
	public Liga() {
		// Inicializamos atributos con referencia.
		numEquipos = 20;
		equipos = new Equipo[numEquipos];
		nombreLiga = "Liga espa�ola";

		// inicializamos el array
		for (int i = 0; i < numEquipos; i++) {
			equipos[i] = new Equipo();
		}

	}
	
	
	//Constructor sobrecarga con par�metros.
	public Liga(int numero, String nombre) {
		numEquipos = numero;
		equipos = new Equipo[numEquipos];
		nombreLiga = nombre;

		// inicializamos el array

		for (int i = 0; i < numEquipos; i++) {
			equipos[i] = new Equipo();
		}

	}

	//M�todo mutador para incluir el nombre del equipo
	public void setNombreLiga(String nombre) {
		nombreLiga = nombre;
	}
	
	
	//M�todo para recuperar el nombre de la liga.
	public String getNombreLiga() {
		return nombreLiga;
	}

	//M�todo para recuperar el n�mero de equipos
	public int getNumeroEquipos() {
		return numEquipos;
	}

	//M�todo para recuperar el equipo devolviendo el correspondiente al �ndice pasado por parametro.
	public Equipo getEquipo(int numero) {
		return equipos[numero];
	}

	//Metodo para modficiar introduciendo en el array en el �ndice pasado por par�metro el equipo.
	public void setEquipo(Equipo equipo, int numero) {
		equipos[numero] = equipo;

	}

}
