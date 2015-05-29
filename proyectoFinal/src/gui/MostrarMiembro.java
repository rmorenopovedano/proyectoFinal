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

public class MostrarMiembro extends JDialog {

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
	private JLabel campoTipo;

	/**
	 * Create the dialog.
	 */
	public MostrarMiembro(Club club2) {
		setTitle("Mostrar Miembro");
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
				campoTipo.setText(String.valueOf(juga.getTipo()));
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
		
		campoTipo = new JLabel("");
		campoTipo.setBounds(176, 124, 46, 14);
		panelDetalle.add(campoTipo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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
