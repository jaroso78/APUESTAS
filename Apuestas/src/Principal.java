import java.awt.EventQueue;

/**
 * 
 * @author JAVIER RODRÍGUEZ SOLER. 
 * EJERCICIO APUESTAS
 * Clase Principal
 */

public class Principal {


	public static void main(String[] args) {

		//Serializamos el objeto Liga
	 Liga liga = new Liga();
	//Pasamos el objeto como parametro en el constructor de VentanaLiga
	 VentanaLiga frame = new VentanaLiga (liga);
	 //Hacemos visible la ventana.
	 frame.setVisible(true);
				
		

	}

}
