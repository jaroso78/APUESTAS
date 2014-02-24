/**
 * 
 * @author JAVIER RODRÍGUEZ SOLER. 
 * EJERCICIO APUESTAS
 * Clase  Equipo
 */


import java.io.Serializable;


public class Equipo implements Serializable{
 
	
	//Definición de los atrítubos.
	String nombreEquipo;
	int golesFavor;
	int golesEncontra;
	int partidosGanados;
	int partidosPerdidos;
	
	
	//Constructor con parámetros.
	public Equipo (String nom, int golesF, int golesC, int partidosG, int partidosP){
	
		//Introducimos los datos en los atributos con los respectivos parámetros.
	setNombre(nom);
	setGolesFavor(golesF);
	setGolesContra (golesC);
	setPartidosGanados (partidosG);
	setPartidosPerdidos (partidosP);
		
		
	}
	
	
	// Método para incluir el nombre del equipo pasándolo por parámetro
	public void setNombre ( String nombre)
	{
		nombreEquipo = nombre;
	}
	
	//Método para recuperar el nombre.
	public String getNombre()
	{
		return nombreEquipo;
	}
	
	
	//Método para incluir los goles a favor pasándolo por parámetros.
	public void setGolesFavor (int golesF)
	{
		golesFavor = golesF;
	}
	
	
	//Método para recuperar los goles a favor.
	public int getGolesFavor ()
	{
		return golesFavor;
	}
	
	
	// Método para incluir los goles a contra pasándolo por parámetros.
	public void setGolesContra (int golesC)
	{
		golesEncontra = golesC;
	}
	
	// Método para recuperar los goles en contra.
	public int setGolesContra ()
	{
		return golesEncontra;
	}
	
	// Método para incluir los partidos ganádos pasándolo por parámetro.
	public void setPartidosGanados(int partidosG)
	{
		partidosGanados = partidosG;
	}
	
	
	// Método para recuperar los partidos gandados.
	public int getPartidosGanados()
	{
		return partidosGanados;
	}
	

	//Método para incluir los partidos perdidos pasándolos por parámetro.
	public void setPartidosPerdidos(int partidosP)
	{
		partidosPerdidos = partidosP;
	}


	//Método para recuperar los partidos perdidos.
	public int getPartidosPerdidos()
	{
		return partidosPerdidos;
	}
}
