package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import proyectoFinal.Club;
import proyectoFinal.Miembro;
import proyectoFinal.NombreInvalidoException;

import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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

	/**
	 * Create the dialog.
	 */
	public MostrarJugador(Club club2) {
		setTitle("Mostrar Jugador");
		club = club2;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		comboBox = new JComboBox(club.getJugadoresParaLista());
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String temp = (String) comboBox.getSelectedItem();
				String[] partes = temp.split(".-");
				Miembro juga = club.get(Integer.parseInt(partes[0]));
				nombreJugador.setText(juga.getNombre());
				apellido1Jugador.setText(juga.getApellido1());
				apellido2Jugador.setText(juga.getApellido2());
				annoNacimiento.setText(juga.getAñoNacimiento());
				sueldoJugador.setText((String.valueOf(juga.getSueldo())));
				categoriaJugador.setText(String.valueOf(juga.getCategoria()));
			}
		});
		comboBox.setBounds(166, 11, 230, 31);
		contentPanel.add(comboBox);

		JLabel lblElegirJugador = new JLabel("Elegir jugador");
		lblElegirJugador.setBounds(78, 19, 90, 14);
		contentPanel.add(lblElegirJugador);

		panelDetalle = new JPanel();
		panelDetalle.setBounds(10, 53, 414, 164);
		contentPanel.add(panelDetalle);
		panelDetalle.setLayout(null);

		nombreJugador = new JLabel("");
		nombreJugador.setBounds(26, 23, 46, 14);
		panelDetalle.add(nombreJugador);

		apellido1Jugador = new JLabel("");
		apellido1Jugador.setBounds(147, 23, 46, 14);
		panelDetalle.add(apellido1Jugador);

		apellido2Jugador = new JLabel("");
		apellido2Jugador.setBounds(240, 23, 46, 14);
		panelDetalle.add(apellido2Jugador);

		annoNacimiento = new JLabel("");
		annoNacimiento.setBounds(26, 61, 46, 14);
		panelDetalle.add(annoNacimiento);

		categoriaJugador = new JLabel("");
		categoriaJugador.setBounds(162, 61, 46, 14);
		panelDetalle.add(categoriaJugador);

		sueldoJugador = new JLabel("");
		sueldoJugador.setBounds(282, 61, 46, 14);
		panelDetalle.add(sueldoJugador);

		campoId = new JLabel("");
		campoId.setBounds(176, 124, 46, 14);
		panelDetalle.add(campoId);
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
							if (club.size() > 0) {
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
						// panelDetalle.revalidate();
						// panelDetalle.repaint();
						// comboBox = new
						// JComboBox(club.getJugadoresParaLista());
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
