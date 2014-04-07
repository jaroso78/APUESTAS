/**
 * 
 * @author JAVIER RODRÍGUEZ SOLER. 
 * EJERCICIO APUESTAS
 * Clase Apuestas.
 */


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Apuestas extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apuestas frame = new Apuestas();
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
	public Apuestas() {
		
		
		setTitle("---.Apuestas.---");// Colocamos el título de la ventana.
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 355, 124);
		panel.setBorder( new TitledBorder( "Administrador de Ligas." ) );
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre de la liga");
		lblNewLabel.setBounds(10, 22, 111, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 42, 218, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Administrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 Liga liga = new Liga();
					//Pasamos el objeto como parametro en el constructor de VentanaLiga
					 VentanaLiga frame = new VentanaLiga (liga);
					 frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cerramos sólo
						// la ventana que
						// cerramos
						// y no
						// el
						// resto.

					 //Hacemos visible la ventana.
					 frame.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(10, 90, 111, 23);
		panel.add(btnNewButton);
		
		JButton btnGenerarApuesta = new JButton("Generar apuesta");
		btnGenerarApuesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGenerarApuesta.setBounds(10, 159, 161, 23);
		contentPane.add(btnGenerarApuesta);
		
		JButton btnSeguimientoDe = new JButton("Seguimiento de apuestas ");
		btnSeguimientoDe.setBounds(10, 214, 208, 23);
		contentPane.add(btnSeguimientoDe);
	}
}
