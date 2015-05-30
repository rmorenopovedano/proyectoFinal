package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import proyectoFinal.Club;
import proyectoFinal.Jugador;
import proyectoFinal.Miembro;
import proyectoFinal.NombreInvalidoException;
import proyectoFinal.Tipo;

import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class MostrarJugador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Club club;
	private JComboBox comboBox;
	private JPanel panelDetalle;
	private JLabel nombreJugador;
	private JLabel apellido1Jugador;
	private JLabel apellido2Jugador;
	private JLabel annoNacimiento;
	private JLabel categoriaJugador;
	private JLabel sueldoJugador;
	private JLabel campoId;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel lblGoles;
	private JLabel campoGoles;
	private JLabel lblDemarcacin;
	private JLabel campoDemarcacion;
	private JLabel lblPJugados;
	private JLabel campoPJ;
	private JLabel lblDorsal;
	private JLabel campoDorsal;
	private JLabel label_5;

	/**
	 * Create the dialog.
	 */
	public MostrarJugador(Club club2) {
		setTitle("Mostrar Jugador");
		club = club2;
		setBounds(100, 100, 500, 370);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		comboBox = new JComboBox(club.getJugadoresParaLista());
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String temp = (String) comboBox.getSelectedItem();
				String[] partes = temp.split(".-");
				// Obtengo el ID del jugador para poder obtenerlo del listado.
				Miembro juga = club.get(Integer.parseInt(partes[0]));
				nombreJugador.setText(juga.getNombre());
				apellido1Jugador.setText(juga.getApellido1());
				apellido2Jugador.setText(juga.getApellido2());
				annoNacimiento.setText(juga.getAñoNacimiento());
				sueldoJugador.setText((String.valueOf(juga.getSueldo())));
				categoriaJugador.setText(String.valueOf(juga.getCategoria()));
				campoGoles.setText(String.valueOf(((Jugador) juga)
						.getGolesMarcados()));
				campoDemarcacion.setText(String.valueOf(((Jugador) juga)
						.getDemarcacion()));
				campoPJ.setText(String.valueOf(((Jugador) juga)
						.getPartidosJugados()));
				campoDorsal.setText(String.valueOf(((Jugador) juga).getDorsal()));
			}
		});
		comboBox.setBounds(166, 11, 230, 31);
		contentPanel.add(comboBox);

		JLabel lblElegirJugador = new JLabel("Elegir jugador");
		lblElegirJugador.setBounds(78, 19, 90, 14);
		contentPanel.add(lblElegirJugador);

		panelDetalle = new JPanel();
		panelDetalle.setBounds(10, 53, 466, 234);
		contentPanel.add(panelDetalle);
		panelDetalle.setLayout(null);

		nombreJugador = new JLabel("");
		nombreJugador.setBounds(77, 12, 73, 14);
		panelDetalle.add(nombreJugador);

		apellido1Jugador = new JLabel("");
		apellido1Jugador.setBounds(267, 12, 84, 14);
		panelDetalle.add(apellido1Jugador);

		apellido2Jugador = new JLabel("");
		apellido2Jugador.setBounds(362, 12, 84, 14);
		panelDetalle.add(apellido2Jugador);

		annoNacimiento = new JLabel("");
		annoNacimiento.setBounds(135, 61, 73, 14);
		panelDetalle.add(annoNacimiento);

		categoriaJugador = new JLabel("");
		categoriaJugador.setBounds(99, 108, 90, 14);
		panelDetalle.add(categoriaJugador);

		sueldoJugador = new JLabel("");
		sueldoJugador.setBounds(320, 61, 79, 14);
		panelDetalle.add(sueldoJugador);

		campoId = new JLabel("");
		campoId.setBounds(176, 124, 46, 14);
		panelDetalle.add(campoId);

		label = new JLabel("Nombre:");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Arial", Font.BOLD, 13));
		label.setBounds(10, 12, 57, 14);
		panelDetalle.add(label);

		label_1 = new JLabel("Apellidos:");
		label_1.setForeground(Color.BLUE);
		label_1.setFont(new Font("Arial", Font.BOLD, 13));
		label_1.setBounds(184, 11, 90, 14);
		panelDetalle.add(label_1);

		label_2 = new JLabel("A\u00F1o Nacimiento:");
		label_2.setForeground(Color.BLUE);
		label_2.setFont(new Font("Arial", Font.BOLD, 13));
		label_2.setBounds(10, 60, 125, 14);
		panelDetalle.add(label_2);

		label_3 = new JLabel("Categor\u00EDa:");
		label_3.setForeground(Color.BLUE);
		label_3.setFont(new Font("Arial", Font.BOLD, 13));
		label_3.setBounds(10, 108, 79, 14);
		panelDetalle.add(label_3);

		label_4 = new JLabel("Sueldo:");
		label_4.setForeground(Color.BLUE);
		label_4.setFont(new Font("Arial", Font.BOLD, 13));
		label_4.setBounds(234, 61, 66, 14);
		panelDetalle.add(label_4);

		lblGoles = new JLabel("Goles:");
		lblGoles.setForeground(Color.BLUE);
		lblGoles.setFont(new Font("Arial", Font.BOLD, 13));
		lblGoles.setBounds(10, 154, 51, 14);
		panelDetalle.add(lblGoles);

		campoGoles = new JLabel("");
		campoGoles.setBounds(71, 154, 64, 14);
		panelDetalle.add(campoGoles);

		lblDemarcacin = new JLabel("Demarcaci\u00F3n:");
		lblDemarcacin.setForeground(Color.BLUE);
		lblDemarcacin.setFont(new Font("Arial", Font.BOLD, 13));
		lblDemarcacin.setBounds(234, 108, 110, 14);
		panelDetalle.add(lblDemarcacin);

		campoDemarcacion = new JLabel("");
		campoDemarcacion.setBounds(329, 108, 117, 14);
		panelDetalle.add(campoDemarcacion);

		lblPJugados = new JLabel("P. Jugados:");
		lblPJugados.setForeground(Color.BLUE);
		lblPJugados.setFont(new Font("Arial", Font.BOLD, 13));
		lblPJugados.setBounds(157, 155, 90, 14);
		panelDetalle.add(lblPJugados);

		campoPJ = new JLabel("");
		campoPJ.setBounds(254, 155, 46, 14);
		panelDetalle.add(campoPJ);

		lblDorsal = new JLabel("Dorsal:");
		lblDorsal.setForeground(Color.BLUE);
		lblDorsal.setFont(new Font("Arial", Font.BOLD, 13));
		lblDorsal.setBounds(329, 155, 51, 14);
		panelDetalle.add(lblDorsal);

		campoDorsal = new JLabel("");
		campoDorsal.setBounds(390, 155, 46, 14);
		panelDetalle.add(campoDorsal);
		
		label_5 = new JLabel("\u20AC");
		label_5.setForeground(Color.BLUE);
		label_5.setFont(new Font("Arial", Font.BOLD, 13));
		label_5.setBounds(390, 61, 66, 14);
		panelDetalle.add(label_5);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton eliminarButton = new JButton("ELIMINAR");
				eliminarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int resp = JOptionPane.showConfirmDialog(null,
								"¿Está seguro de eliminar este jugador?",
								"Eliminar jugador", JOptionPane.YES_NO_OPTION);
						if (resp == JOptionPane.YES_OPTION) {
							String temp = (String) comboBox.getSelectedItem();
							String[] partes = temp.split(".-");
							club.eliminar(Integer.parseInt(partes[0]));
							JOptionPane.showMessageDialog(null,
									"Jugador eliminado con éxito");
							club.setModificado(true);
							// Comprobamos que sigan quedando jugadores en el club. Si no quedan más
							// mostramos un mensaje y cerramos la ventana.
							Club clubFiltered = club.getClubFiltradoTipo(Tipo.JUGADOR);
							if (clubFiltered.size() > 0) {
								comboBox.removeItemAt(comboBox
										.getSelectedIndex());
								comboBox.revalidate();
								comboBox.repaint();
							} else {
								JOptionPane.showMessageDialog(null,
										"No hay más jugadores en la lista.");
								setVisible(false);
							}
						} else {
						}
					}
				});
				eliminarButton.setActionCommand("OK");
				buttonPane.add(eliminarButton);
				getRootPane().setDefaultButton(eliminarButton);
			}
			{
				JButton volverButton = new JButton("VOLVER");
				volverButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				volverButton.setActionCommand("Cancel");
				buttonPane.add(volverButton);
			}
		}
	}
}
