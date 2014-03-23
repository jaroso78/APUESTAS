/**
 * 
 * @author JAVIER RODRÍGUEZ SOLER. 
 * EJERCICIO APUESTAS
 * Clase  VentanaLiga
 */



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;

public class VentanaLiga extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox<Equipo> comboBox;

	private Liga liga;
	
	JFrame frame;

	/**
	 * Create the frame.
	 */
	public VentanaLiga(Liga ligaModifica) {
		
		
		setTitle("---.Ventana Liga.---");// Colocamos el título de la ventana.
		
		
		// Seleccionamos la liga que pasamos por referencia y cargamos sus datos
		// en la ventana principal.
		liga = ligaModifica;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 271);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombreLiga = new JLabel("Nombre de la Liga:");
		lblNombreLiga.setBounds(30, 28, 139, 14);
		contentPane.add(lblNombreLiga);

		textField = new JTextField();
		textField.setText(String.valueOf(liga.getNombreLiga()));
		textField.setBounds(31, 53, 233, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNmeroDeEquipos = new JLabel("N\u00FAmero de Equipos:");
		lblNmeroDeEquipos.setBounds(292, 28, 114, 14);
		contentPane.add(lblNmeroDeEquipos);

		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setText(String.valueOf(liga.getNumeroEquipos()));
		textField_1.setBounds(292, 53, 114, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblEquipoAModificar = new JLabel("Equipos:");
		lblEquipoAModificar.setBounds(30, 125, 126, 14);
		contentPane.add(lblEquipoAModificar);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Equipo equipomodificar = (Equipo) comboBox.getSelectedItem();

					abreVentanaEquipo(equipomodificar, true);

				} catch (Exception e1) {
					System.out.println(e1);
				}

							}
		});
		btnModificar.setBounds(138, 181, 126, 23);
		contentPane.add(btnModificar);

		comboBox = new JComboBox<Equipo>();
		comboBox.setBounds(29, 150, 235, 20);
		contentPane.add(comboBox);

		JButton button = new JButton("+");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Creamos nuevo Equipo
				try {
					liga.nuevoEquipo();
					abreVentanaEquipo(liga.getEquipo(Integer
							.parseInt(textField_1.getText())), false);
				} catch (ArrayIndexOutOfBoundsException e1) {

				}

			}
		});
		button.setBounds(30, 180, 46, 23);
		contentPane.add(button);

		JButton button_1 = new JButton("-");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  //Método para eliminar equipo

				try {
					if (comboBox.getItemCount() != 0) { //Comprobamos que haya más de 1 elemento para eliminar.
						
						Equipo equipoEliminar = (Equipo) comboBox //Seleccionamos el objeto del equipo a eliminar.
								.getSelectedItem();
						liga.eraseEquipo(equipoEliminar); //Eliminamos.
						comboBox.removeItem(equipoEliminar);
						textField_1.setText(String.valueOf(liga.numEquipos)); // Y pasamos el número de equipos.
					}
				} catch (ArrayIndexOutOfBoundsException e1) {

				}
			}
		});
		button_1.setBounds(80, 180, 46, 23);
		contentPane.add(button_1);
	}

	private void abreVentanaEquipo(Equipo equipo, boolean modifica) {  //Abre Ventana Equipo

		VentanaEquipo frameEquipo = new VentanaEquipo(equipo, this.comboBox,
				modifica, this.textField_1);
		frameEquipo.setVisible(true);
		frameEquipo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cerramos sólo
																		// la ventana que
																		// cerramos
																		// y no
																		// el
																		// resto.
	}
	
}
