/**
 * 
 * @author JAVIER RODRÍGUEZ SOLER. 
 * EJERCICIO APUESTAS
 * Clase  Liga
 */

import java.io.Serializable;
import java.util.ArrayList;

public class Liga implements Serializable {

	// Definición atributos.
	int numEquipos;
	String nombreLiga;
	
	//Definición del ArrayList de Equipos.
	ArrayList <Equipo> equipos = new ArrayList<Equipo>();

	// Constructor
	public Liga() {
		// Inicializamos atributos con referencia.
		numEquipos = 20;
		//equipos = new Equipo[numEquipos];
			nombreLiga = "Liga española";

		// inicializamos el arraylist
		for (int i = 0; i < numEquipos; i++) {
			equipos.add( new Equipo());
			}

	}
	
	
	//Constructor sobrecarga con parámetros.
	public Liga(int numero, String nombre) {
		numEquipos = numero;
		nombreLiga = nombre;

		// inicializamos el arraylist

		for (int i = 0; i < numEquipos; i++) {
			equipos.add( new Equipo());
		}

	}

	//Método mutador para incluir el nombre del equipo
	public void setNombreLiga(String nombre) {
		nombreLiga = nombre;
	}
	
	
	//Método para recuperar el nombre de la liga.
	public String getNombreLiga() {
		return nombreLiga;
	}

	//Método para recuperar el número de equipos
	public int getNumeroEquipos() {
		return numEquipos;
	}

	//Método para recuperar el equipo devolviendo el correspondiente al índice pasado por parametro.
	public Equipo getEquipo(int numero) {
				return equipos.get(numero);
		}

	//Metodo para modficiar introduciendo en el arraylist el índice pasado por parámetro el equipo.
	public void setEquipo(Equipo equipo, int numero) {
		equipos.set(numero, equipo);
		

	}

}
