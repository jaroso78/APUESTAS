import java.awt.EventQueue;

/**
 * 
 * @author JAVIER RODRÍGUEZ SOLER. 
 * EJERCICIO APUESTAS
 * Clase Principal
 */

public class Principal {


	public static void main(String[] args) {

		//Serializamos el objeto equipo
	 Equipo equipo = new Equipo("",0,0,0,0);
		
	 				//Pasamos el objeto como parametro en el constructor de VentanaEquipo
					VentanaEquipo frame = new VentanaEquipo(equipo);
					frame.setVisible(true);
				
		

	}

}
