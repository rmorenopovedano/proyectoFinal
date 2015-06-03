/**
 * 
 */
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
import proyectoFinal.Entrenador;
import proyectoFinal.Miembro;
import proyectoFinal.Tipo;

import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

/**
 * 
 * @author RAUL MORENO POVEDANO
 * @version 1.0
 */
public class MostrarEntrenador extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private Club club;
	private JComboBox<String> comboBox;
	private JLabel campoNivel;
	private JLabel campoAnnosExp;
	private JLabel campoCategoria;
	private JLabel campoSueldo;
	private JLabel campoApellido2;
	private JLabel campoApellido1;
	private JLabel nombreJugador;
	private JLabel campoFechaAlta;
	private Component frame;

	/**
	 * Create the dialog.
	 */
	public MostrarEntrenador(Club club2) {
		setResizable(false);
		setModal(true);
		setTitle("Mostrar Entrenador");
		setBounds(100, 100, 500, 370);
		setLocationRelativeTo(frame);
		club = club2;
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblElegirEntrenador = new JLabel("Elegir entrenador: ");
			lblElegirEntrenador.setBounds(43, 22, 110, 14);
			contentPanel.add(lblElegirEntrenador);
		}

		comboBox = new JComboBox<String>(club.getEntrenadoresParaLista());
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = (String) comboBox.getSelectedItem();
				String[] partes = temp.split(".-");
				Miembro entrenador = club.get(Integer.parseInt(partes[0]));
				nombreJugador.setText(entrenador.getNombre());
				campoApellido1.setText(entrenador.getApellido1());
				campoApellido2.setText(entrenador.getApellido2());
				campoAnnosExp.setText(String.valueOf(((Entrenador) entrenador)
						.getAnnosExp()));
				campoCategoria.setText(String.valueOf(entrenador.getCategoria()));
				campoNivel.setText(String.valueOf(((Entrenador) entrenador)
						.getNivel()));
				campoSueldo.setText(String.valueOf(entrenador.getSueldo()));
				campoFechaAlta.setText(entrenador.getFechaAlta());

			}
		});
		comboBox.setBounds(178, 19, 214, 20);
		contentPanel.add(comboBox);

		JPanel panelDetalle = new JPanel();
		panelDetalle.setBounds(10, 53, 466, 234);
		contentPanel.add(panelDetalle);
		panelDetalle.setLayout(null);
		{
			JLabel label = new JLabel("Nombre:");
			label.setBounds(10, 37, 54, 15);
			label.setForeground(Color.BLUE);
			label.setFont(new Font("Arial", Font.BOLD, 13));
			panelDetalle.add(label);
		}
		{
			JLabel label = new JLabel("Apellidos:");
			label.setBounds(224, 37, 63, 15);
			label.setForeground(Color.BLUE);
			label.setFont(new Font("Arial", Font.BOLD, 13));
			panelDetalle.add(label);
		}
		{
			JLabel label = new JLabel("Sueldo:");
			label.setBounds(10, 87, 49, 15);
			label.setForeground(Color.BLUE);
			label.setFont(new Font("Arial", Font.BOLD, 13));
			panelDetalle.add(label);
		}
		{
			JLabel label = new JLabel("Categor\u00EDa:");
			label.setBounds(10, 140, 66, 15);
			label.setForeground(Color.BLUE);
			label.setFont(new Font("Arial", Font.BOLD, 13));
			panelDetalle.add(label);
		}
		{
			JLabel lblAosExperiencia = new JLabel("A\u00F1os Experiencia:");
			lblAosExperiencia.setForeground(Color.BLUE);
			lblAosExperiencia.setFont(new Font("Arial", Font.BOLD, 13));
			lblAosExperiencia.setBounds(224, 141, 115, 15);
			panelDetalle.add(lblAosExperiencia);
		}
		{
			JLabel lblNivel = new JLabel("Nivel:");
			lblNivel.setForeground(Color.BLUE);
			lblNivel.setFont(new Font("Arial", Font.BOLD, 13));
			lblNivel.setBounds(10, 189, 66, 15);
			panelDetalle.add(lblNivel);
		}
		{
			nombreJugador = new JLabel("");
			nombreJugador.setBounds(74, 38, 73, 14);
			panelDetalle.add(nombreJugador);
		}
		{
			campoApellido1 = new JLabel("");
			campoApellido1.setBounds(297, 38, 71, 14);
			panelDetalle.add(campoApellido1);
		}
		{
			campoApellido2 = new JLabel("");
			campoApellido2.setBounds(378, 38, 78, 14);
			panelDetalle.add(campoApellido2);
		}
		{
			campoSueldo = new JLabel("");
			campoSueldo.setBounds(83, 88, 46, 14);
			panelDetalle.add(campoSueldo);
		}
		{
			campoCategoria = new JLabel("");
			campoCategoria.setBounds(89, 141, 82, 14);
			panelDetalle.add(campoCategoria);
		}
		{
			campoAnnosExp = new JLabel("");
			campoAnnosExp.setBounds(355, 141, 46, 14);
			panelDetalle.add(campoAnnosExp);
		}
		{
			campoNivel = new JLabel("");
			campoNivel.setBounds(57, 190, 90, 14);
			panelDetalle.add(campoNivel);
		}
		{
			JLabel label = new JLabel("\u20AC");
			label.setForeground(Color.BLUE);
			label.setFont(new Font("Arial", Font.BOLD, 13));
			label.setBounds(164, 88, 66, 14);
			panelDetalle.add(label);
		}
		{
			JLabel lblFechaAlta = new JLabel("Fecha Alta:");
			lblFechaAlta.setForeground(Color.BLUE);
			lblFechaAlta.setFont(new Font("Arial", Font.BOLD, 13));
			lblFechaAlta.setBounds(224, 190, 90, 15);
			panelDetalle.add(lblFechaAlta);
		}
		{
			campoFechaAlta = new JLabel("");
			campoFechaAlta.setBounds(308, 190, 82, 14);
			panelDetalle.add(campoFechaAlta);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("ELIMINAR");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int resp = JOptionPane.showConfirmDialog(null,
								"¿Está seguro de eliminar este entrenador?",
								"Eliminar entrenador",
								JOptionPane.YES_NO_OPTION);
						if (resp == JOptionPane.YES_OPTION) {
							String temp = (String) comboBox.getSelectedItem();
							String[] partes = temp.split(".-");
							club.eliminar(Integer.parseInt(partes[0]));
							JOptionPane.showMessageDialog(null,
									"Entrenador eliminado con éxito");
							club.setModificado(true);
							Club clubFiltrado = club
									.getClubFiltradoTipo(Tipo.ENTRENADOR);
							if (clubFiltrado.size() > 0) {
								comboBox.removeItemAt(comboBox
										.getSelectedIndex());
								comboBox.revalidate();
								comboBox.repaint();
							} else {
								JOptionPane.showMessageDialog(null,
										"No hay más entrenadores en la lista.");
								setVisible(false);
							}
						} else {
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("VOLVER");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		comboBox.setSelectedIndex(0);
	}
}
