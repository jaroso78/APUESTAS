/**
 * 
 * @author JAVIER RODR�GUEZ SOLER. 
 * EJERCICIO APUESTAS
 * Clase  Equipo
 */


import java.io.Serializable;


public class Equipo implements Serializable{
 
	
	//Definici�n de los atr�tubos.
	String nombreEquipo;
	int golesFavor;
	int golesEncontra;
	int partidosGanados;
	int partidosPerdidos;
	
	
	//Constructor con par�metros.
	public Equipo (String nom, int golesF, int golesC, int partidosG, int partidosP){
	
		//Introducimos los datos en los atributos con los respectivos par�metros utilizando los m�todos SET
	setNombre(nom);
	setGolesFavor(golesF);
	setGolesContra (golesC);
	setPartidosGanados (partidosG);
	setPartidosPerdidos (partidosP);
		
		
	}
	
	
	// Constructor sin parametros 
	public Equipo()
	{
		//Inicializamos en vacio.
		setNombre("");
		setGolesFavor(0);
		setGolesContra (0);
		setPartidosGanados (0);
		setPartidosPerdidos (0);
			
	}
	
	
	// M�todo para incluir el nombre del equipo pas�ndolo por par�metro
	public void setNombre ( String nombre)
	{
		nombreEquipo = nombre;
	}
	
	//M�todo para recuperar el nombre.
	public String getNombre()
	{
		return nombreEquipo;
	}
	
	
	//M�todo para incluir los goles a favor pas�ndolo por par�metros.
	public void setGolesFavor (int golesF)
	{
		golesFavor = golesF;
	}
	
	
	//M�todo para recuperar los goles a favor.
	public int getGolesFavor ()
	{
		return golesFavor;
	}
	
	
	// M�todo para incluir los goles a contra pas�ndolo por par�metros.
	public void setGolesContra (int golesC)
	{
		golesEncontra = golesC;
	}
	
	// M�todo para recuperar los goles en contra.
	public int getGolesContra ()
	{
		return golesEncontra;
	}
	
	// M�todo para incluir los partidos gan�dos pas�ndolo por par�metro.
	public void setPartidosGanados(int partidosG)
	{
		partidosGanados = partidosG;
	}
	
	
	// M�todo para recuperar los partidos gandados.
	public int getPartidosGanados()
	{
		return partidosGanados;
	}
	

	//M�todo para incluir los partidos perdidos pas�ndolos por par�metro.
	public void setPartidosPerdidos(int partidosP)
	{
		partidosPerdidos = partidosP;
	}


	//M�todo para recuperar los partidos perdidos.
	public int getPartidosPerdidos()
	{
		return partidosPerdidos;
	}
}
