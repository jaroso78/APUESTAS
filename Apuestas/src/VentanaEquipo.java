/**
 * 
 * @author JAVIER RODRÍGUEZ SOLER. 
 * EJERCICIO APUESTAS
 * Clase  VentanaEquipo
 */



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;


public class VentanaEquipo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	private Equipo equipo;
	
	JFrame frame; // Jframe para el Jdialog del MessageBox.
		
	/**
	 * Create the frame.
	 */
	
	public VentanaEquipo(Equipo equipoModificar,  final JComboBox<Equipo> comboBox, final boolean modifica, final JTextField textField_5) {
		
		setTitle("---.Ventana Equipo.---");// Colocamos el título de la ventana.
		
		
		//Creación del equipo.
				equipo = equipoModificar;
		
				
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 422, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreDelEquipo = new JLabel("Nombre del Equipo:");
		lblNombreDelEquipo.setBounds(10, 21, 16, 1);
		contentPane.add(lblNombreDelEquipo);
		
		JLabel lblNombreDelEquipo_1 = new JLabel("Nombre del Equipo:");
		lblNombreDelEquipo_1.setBounds(10, 21, 128, 30);
		contentPane.add(lblNombreDelEquipo_1);
		
		textField = new JTextField();
		textField.setBounds(130, 21, 143, 20);
		textField.setText(equipo.getNombre());
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblGolesAFavor = new JLabel("Goles a favor:");
		lblGolesAFavor.setBounds(10, 70, 115, 14);
		contentPane.add(lblGolesAFavor);
		
		textField_1 = new JTextField();
		textField_1.setBounds(130, 62, 143, 20);
		textField_1.setText(String.valueOf(equipo.getGolesFavor()));
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblGolesEnContra = new JLabel("Goles en Contra:");
		lblGolesEnContra.setBounds(10, 109, 115, 14);
		contentPane.add(lblGolesEnContra);
		
		textField_2 = new JTextField();
		textField_2.setBounds(130, 106, 143, 20);
		textField_2.setText(String.valueOf((equipo.golesEncontra)));
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblPartidosGanados = new JLabel("Partidos Ganados:");
		lblPartidosGanados.setBounds(10, 158, 115, 14);
		contentPane.add(lblPartidosGanados);
		
		textField_3 = new JTextField();
		textField_3.setBounds(130, 155, 143, 20);
		textField_3.setText (String.valueOf((equipo.partidosGanados)));
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblPartidosEnContra = new JLabel("Partidos en contra:");
		lblPartidosEnContra.setBounds(10, 202, 115, 14);
		contentPane.add(lblPartidosEnContra);
		
		textField_4 = new JTextField();
		textField_4.setBounds(130, 199, 143, 20);
		textField_4.setText(String.valueOf(equipo.partidosPerdidos));
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		
		
		JButton btnGuardar = new JButton("Guardar en disco");
		btnGuardar.setBounds(10, 261, 138, 23);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {   //Guardamos los datos en Equipo
				equipo.setNombre(textField.getText());
				
				if ((compruebaNumero(textField_1.getText())==true) & (compruebaNumero(textField_2.getText())==true) & (compruebaNumero(textField_3.getText())==true) & (compruebaNumero(textField_4.getText())==true)  ) {
					equipo.setGolesFavor(Integer.valueOf(textField_1.getText()));
					equipo.setGolesContra(Integer.valueOf(textField_2.getText()));
					equipo.setPartidosGanados(Integer.valueOf(textField_3.getText()));
					equipo.setPartidosPerdidos(Integer.valueOf(textField_4.getText()));
				    grabarEquipo(); //Invocamos el método para lamcenar en el disco.
				 if (modifica==false)
					{
						comboBox.addItem(equipo);
						textField_5.setText(String.valueOf(comboBox.getItemCount()));
					}
				
			} else
			{
				JOptionPane.showMessageDialog(frame,
					    "Compruebe que haya introducido valores numéricos "); // Mostramos un MessageBox para indicarle que compruebe.
			}
			
			}
		});
		contentPane.add(btnGuardar);
		
		JButton btnLeer = new JButton("Leer en disco");
		btnLeer.setBounds(158, 261, 115, 23);
		btnLeer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			 leerEquipo();
				textField.setText(equipo.getNombre());
				textField_1.setText(Integer.toString(equipo.getGolesFavor()));
				textField_2.setText(Integer.toString(equipo.getGolesContra()));
				textField_3.setText(Integer.toString(equipo.getPartidosGanados()));
				textField_4.setText(Integer.toString(equipo.getPartidosPerdidos()));
			}
		});
		contentPane.add(btnLeer);
		
		
		
		JButton btnNewButton = new JButton("GUARDAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				equipo.setNombre(textField.getText());
				
				
				if ((compruebaNumero(textField_1.getText())==true) & (compruebaNumero(textField_2.getText())==true) & (compruebaNumero(textField_3.getText())==true) & (compruebaNumero(textField_4.getText())==true)  ) {
					equipo.setGolesFavor(Integer.valueOf(textField_1.getText()));
					equipo.setGolesContra(Integer.valueOf(textField_2.getText()));
					equipo.setPartidosGanados(Integer.valueOf(textField_3.getText()));
					equipo.setPartidosPerdidos(Integer.valueOf(textField_4.getText()));
					
					if (modifica==false)
					{
						comboBox.addItem(equipo);
						textField_5.setText(String.valueOf(comboBox.getItemCount()));
					}
					
					
				} else
				{
					JOptionPane.showMessageDialog(frame,
						    "Compruebe que haya introducido valores numéricos ");
				}
						
			}
		});
		btnNewButton.setBounds(295, 21, 101, 57);
		contentPane.add(btnNewButton);
	}
	
	
	//Método para leer equipo en disco.
	public void leerEquipo()
	{
		ObjectInputStream entrada;
		
		try{
			 entrada = new ObjectInputStream (new FileInputStream("clientes.ser"));
			 equipo = (Equipo) entrada.readObject();
			
		}
		catch (IOException ioexception) {
			System.err.println("Error al leer el archivo");
		}
		catch (ClassNotFoundException clfex)
		{
			System.err.println("Error al leer el archivo");
		}
	}
	
	//Método para grabar el equipo en disco.
	public void grabarEquipo()
	{
		ObjectOutputStream salida;
		try{
			salida = new ObjectOutputStream (new FileOutputStream ("clientes.ser")); //almacenamos el objeto en el archivo.
			salida.writeObject(equipo);
			if (salida!= null)
				salida.close();
		}
		catch (IOException ioexception){
			System.err.println ("Error al abrir el archivo");
		}
	
	}
	
	
	//Metodo que devuelve un boolean true si el valor pasado por referencia es un número.
	public boolean compruebaNumero( String valor)
	{
	
		try
		{
			if (Integer.valueOf(valor)>=0){ //comprobamos que sea mayor que 0
				
				return true;
			} else
			{
				JOptionPane.showMessageDialog(frame,
					    "Compruebe que haya introducido valores superiores o iguales a 0 "); // En caso contrario se lo índicamos.
				return false;
			}
			
			
		 } catch (NumberFormatException nfe){ // Comprobamos que es un número
				 		
			 return false;
			 }
	
	}
	
}
