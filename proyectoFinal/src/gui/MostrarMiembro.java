package gui;

import java.awt.BorderLayout;
import java.awt.Component;
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
import java.awt.Color;
import java.awt.Font;

public class MostrarMiembro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Club club;
	private JComboBox<String> comboBox;
	private JPanel panelDetalle;
	private JLabel nombreJugador;
	private JLabel apellido1Jugador;
	private JLabel apellido2Jugador;
	private JLabel annoNacimiento;
	private JLabel categoriaJugador;
	private JLabel sueldoJugador;
	private JLabel campoTipo;
	private JLabel lblTipo;
	private JLabel label;
	private JButton btnOrdenar;
	private Component frame;

	/**
	 * Create the dialog.
	 */
	public MostrarMiembro(Club club2) {
		setResizable(false);
		setModal(true);
		setTitle("Mostrar Miembro");
		club = club2;
		setBounds(100, 100, 500, 300);
		setLocationRelativeTo(frame);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		comboBox = new JComboBox(club.getMiembrosParaLista());
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox.getItemCount()>0){
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
			}
		});
		comboBox.setBounds(166, 11, 230, 31);
		contentPanel.add(comboBox);

		JLabel lblElegirJugador = new JLabel("Elegir miembro:");
		lblElegirJugador.setBounds(66, 19, 90, 14);
		contentPanel.add(lblElegirJugador);

		panelDetalle = new JPanel();
		panelDetalle.setBounds(10, 53, 466, 164);
		contentPanel.add(panelDetalle);
		panelDetalle.setLayout(null);

		nombreJugador = new JLabel("");
		nombreJugador.setBounds(90, 23, 46, 14);
		panelDetalle.add(nombreJugador);

		apellido1Jugador = new JLabel("");
		apellido1Jugador.setBounds(290, 23, 79, 14);
		panelDetalle.add(apellido1Jugador);

		apellido2Jugador = new JLabel("");
		apellido2Jugador.setBounds(379, 23, 77, 14);
		panelDetalle.add(apellido2Jugador);

		annoNacimiento = new JLabel("");
		annoNacimiento.setBounds(145, 72, 46, 14);
		panelDetalle.add(annoNacimiento);

		categoriaJugador = new JLabel("");
		categoriaJugador.setBounds(320, 124, 89, 14);
		panelDetalle.add(categoriaJugador);

		sueldoJugador = new JLabel("");
		sueldoJugador.setBounds(363, 72, 57, 14);
		panelDetalle.add(sueldoJugador);
		
		campoTipo = new JLabel("");
		campoTipo.setBounds(90, 124, 89, 14);
		panelDetalle.add(campoTipo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Arial", Font.BOLD, 13));
		lblNombre.setForeground(new Color(0, 0, 255));
		lblNombre.setBounds(10, 23, 57, 14);
		panelDetalle.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Arial", Font.BOLD, 13));
		lblApellidos.setForeground(new Color(0, 0, 255));
		lblApellidos.setBounds(184, 22, 90, 14);
		panelDetalle.add(lblApellidos);
		
		JLabel lblFNac = new JLabel("A\u00F1o Nacimiento:");
		lblFNac.setForeground(new Color(0, 0, 255));
		lblFNac.setFont(new Font("Arial", Font.BOLD, 13));
		lblFNac.setBounds(10, 71, 125, 14);
		panelDetalle.add(lblFNac);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa:");
		lblCategora.setForeground(new Color(0, 0, 255));
		lblCategora.setFont(new Font("Arial", Font.BOLD, 13));
		lblCategora.setBounds(243, 123, 79, 14);
		panelDetalle.add(lblCategora);
		
		JLabel lblSueldo = new JLabel("Sueldo:");
		lblSueldo.setFont(new Font("Arial", Font.BOLD, 13));
		lblSueldo.setForeground(new Color(0, 0, 255));
		lblSueldo.setBounds(273, 72, 66, 14);
		panelDetalle.add(lblSueldo);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Arial", Font.BOLD, 13));
		lblTipo.setForeground(new Color(0, 0, 255));
		lblTipo.setBounds(10, 123, 78, 14);
		panelDetalle.add(lblTipo);
		
		label = new JLabel("\u20AC");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Arial", Font.BOLD, 13));
		label.setBounds(421, 72, 45, 14);
		panelDetalle.add(label);
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
				
				btnOrdenar = new JButton("ORDENAR");
				btnOrdenar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						club.ordenar();
						comboBox.removeAllItems();
						for(String s:club.getMiembrosParaLista()){
							comboBox.addItem(s);
						}
					}
				});
				btnOrdenar.setActionCommand("Cancel");
				buttonPane.add(btnOrdenar);
				volverButton.setActionCommand("Cancel");
				buttonPane.add(volverButton);
			}
		}
	}
}
