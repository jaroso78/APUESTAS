/**
 * 
 * @author JAVIER RODRÍGUEZ SOLER. 
 * EJERCICIO APUESTAS
 * Clase  VentanEquipo
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class VentanaEquipo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEquipo frame = new VentanaEquipo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaEquipo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreDelEquipo = new JLabel("Nombre del Equipo:");
		lblNombreDelEquipo.setBounds(10, 21, 16, 1);
		contentPane.add(lblNombreDelEquipo);
		
		JLabel lblNombreDelEquipo_1 = new JLabel("Nombre del Equipo:");
		lblNombreDelEquipo_1.setBounds(39, 37, 128, 30);
		contentPane.add(lblNombreDelEquipo_1);
		
		textField = new JTextField();
		textField.setBounds(39, 61, 206, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblGolesAFavor = new JLabel("Goles a favor:");
		lblGolesAFavor.setBounds(39, 103, 115, 14);
		contentPane.add(lblGolesAFavor);
		
		textField_1 = new JTextField();
		textField_1.setBounds(39, 134, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblGolesEnContra = new JLabel("Goles en Contra:");
		lblGolesEnContra.setBounds(146, 103, 99, 14);
		contentPane.add(lblGolesEnContra);
		
		textField_2 = new JTextField();
		textField_2.setBounds(146, 134, 99, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblPartidosGanados = new JLabel("Partidos Ganados:");
		lblPartidosGanados.setBounds(39, 194, 99, 14);
		contentPane.add(lblPartidosGanados);
		
		textField_3 = new JTextField();
		textField_3.setBounds(39, 219, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblPartidosEnContra = new JLabel("Partidos en contra:");
		lblPartidosEnContra.setBounds(146, 194, 99, 14);
		contentPane.add(lblPartidosEnContra);
		
		textField_4 = new JTextField();
		textField_4.setBounds(146, 219, 99, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar ");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			//Serializamos la clase equipo en el objeto eq y le pasamos los datos al constructor.	
			Equipo eq = new Equipo(textField.getText(),Integer.valueOf(textField_1.getText()),Integer.valueOf(textField_2.getText()), Integer.valueOf(textField_3.getText()), Integer.valueOf(textField_4.getText()));
			ObjectOutputStream salida;
			try{
				salida = new ObjectOutputStream (new FileOutputStream ("clientes.ser")); //almacenamos el objeto en el archivo.
				salida.writeObject(eq);
				if (salida!= null)
					salida.close();
			}
			catch (IOException ioexception){
				System.err.println ("Error al abrir el archivo");
			}
			
			}
		});
		btnGuardar.setBounds(373, 60, 89, 23);
		contentPane.add(btnGuardar);
	}
}
