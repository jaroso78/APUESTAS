/**
 * 
 * @author JAVIER RODR�GUEZ SOLER. 
 * EJERCICIO APUESTAS
 * Clase  Liga
 */

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Liga implements Serializable {

	// Definici�n atributos.
	int numEquipos;
	String nombreLiga;
	int idLiga;
	
	//Definici�n del ArrayList de Equipos.
	ArrayList <Equipo> equipos = new ArrayList<Equipo>();

	
	// DB
	
	Connection conexion = null;
	Statement instruccion = null;
	
	
	// Constructor
	public Liga(Connection conexion) {
		
		this.conexion = conexion;
		
		leerLiga();
		// Inicializamos atributos con referencia.
		//numEquipos = 0;
		//nombreLiga = "Liga espa�ola";
		//inicializamos el arraylist
	for (int i = 0; i < numEquipos; i++) {
		equipos.add( new Equipo());
			}
	}
	
	
	public void nuevoEquipo()
	{
		equipos.add(new Equipo());
		numEquipos++;
	//	nuevoEquipoDB(getEquipo(0));
		
		
		
	}
	
	//Constructor sobrecarga con par�metros.
	public Liga(int numero, String nombre, Connection conexion) {
		
		this.conexion = conexion;
		numEquipos = numero;
		nombreLiga = nombre;

		// inicializamos el arraylist

		for (int i = 0; i < numEquipos; i++) {
			equipos.add( new Equipo());
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
				return equipos.get(numero);
		}

	//Metodo para modficiar introduciendo en el arraylist el �ndice pasado por par�metro el equipo.
	public void setEquipo(Equipo equipo, int numero) {
		equipos.set(numero, equipo);
		

	}
	
	//M�todo para eliminar un Equipo y restarle.
	public void eraseEquipo(Equipo equipo)
	{
	   equipos.remove(equipo);
	   numEquipos--;
	}
	
	
	private void leerLiga()
	{
		try
		{
			instruccion = (Statement) conexion.createStatement();
			ResultSet conjuntoResultados = instruccion.executeQuery("Select *from  ligas LIMIT 1");
			conjuntoResultados.next();
			
			this.nombreLiga = (String) conjuntoResultados.getObject("nombre");
			this.numEquipos = (int) conjuntoResultados.getObject("numEquipos");
			this.idLiga = (int) conjuntoResultados.getObject ("idLiga");
		}
		catch(SQLException excepcionSql)
		{
			excepcionSql.printStackTrace();
		}
	}
	
	
	private void nuevoEquipoDB(Equipo equipo)
	{
		try{
		instruccion = (Statement) conexion.createStatement();
		String sql_inst = "INSERT into Equipos (idLiga,nombreEquipo, golesFavor, golesEnContra, partidosGanados, partidosPerdidos )";
		sql_inst = sql_inst + " VALUES ( "+idLiga+",'"+equipo.getNombre()+"',"+equipo.getGolesFavor()+","+equipo.golesEncontra+","+equipo.partidosGanados+","+equipo.partidosPerdidos+")";
		System.out.println(sql_inst);
		instruccion.executeUpdate(sql_inst);
		}
		catch(SQLException excepcionSql)
		{
			excepcionSql.printStackTrace();
		}
		
	}

}
