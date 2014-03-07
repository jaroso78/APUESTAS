/**
 * 
 * @author JAVIER RODRÍGUEZ SOLER. 
 * EJERCICIO APUESTAS
 * Clase  VentanaLiga
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaLiga extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private Liga liga;

	
	/**
	 * Create the frame.
	 */
	public VentanaLiga(Liga ligaModifica) {
		// Seleccionamos la liga que pasamos por referencia y cargamos sus datos en la ventana principal.
		liga = ligaModifica;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 394, 271);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreLiga = new JLabel("Nombre de la Liga:");
		lblNombreLiga.setBounds(30, 28, 139, 14);
		contentPane.add(lblNombreLiga);
		
		textField = new JTextField();
		textField.setText(String.valueOf(liga.getNombreLiga()));
		textField.setBounds(31, 53, 138, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNmeroDeEquipos = new JLabel("N\u00FAmero de Equipos:");
		lblNmeroDeEquipos.setBounds(208, 28, 114, 14);
		contentPane.add(lblNmeroDeEquipos);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setText(String.valueOf(liga.getNumeroEquipos()));
		textField_1.setBounds(208, 53, 114, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEquipoAModificar = new JLabel("Equipo a modificar:");
		lblEquipoAModificar.setBounds(30, 125, 126, 14);
		contentPane.add(lblEquipoAModificar);
		
		textField_2 = new JTextField();
		textField_2.setBounds(30, 149, 139, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnModificar = new JButton("Modificar.");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Integer.parseInt(textField_2.getText());
					
					
					if (Integer.valueOf(textField_2.getText())<liga.numEquipos&& Integer.valueOf(textField_2.getText())>=0){ // Comprobamos que se encuentre dentro de los límites.
					
						//Cargamos la VentanaEquipo pasandole por el constructor el equipo a  Modificar.
							
					VentanaEquipo frameEquipo = new VentanaEquipo(liga.getEquipo(Integer.valueOf(textField_2.getText())));
					frameEquipo.setVisible(true);
					frameEquipo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Cerramos sólo la ventan que cerramos y no el resto.
					}
					else
					{
						System.out.println("Debes introducir un número mayor a 0 y menor a " + liga.numEquipos);
					}
					
				} catch (NumberFormatException nfe){ // Comprobamos que es un número
					System.out.println("Introduzca un número");
				}
			    
				
			}
		});
		btnModificar.setBounds(30, 206, 126, 23);
		contentPane.add(btnModificar);
	}
}
