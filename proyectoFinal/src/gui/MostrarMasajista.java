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
import proyectoFinal.Masajista;
import proyectoFinal.Tipo;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MostrarMasajista extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Club club;
	private JComboBox comboBox;
	private JLabel campoApellido2;
	private JLabel campoApellido1;
	private JLabel campoNombre;
	private JLabel campoAnnoNac;
	private JLabel campoSueldo;
	private JLabel campoAnnosExp;
	private JLabel campoCategoria;
	private JLabel lblTitulacion;
	private JLabel campoTitulacion;

	/**
	 * Create the dialog.
	 */
	public MostrarMasajista(Club club2) {
		setTitle("Mostrar Masajista");
		setBounds(100, 100, 500, 370);
		club=club2;
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(10, 53, 466, 234);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				lblTitulacion = new JLabel("Titulaci\u00F3n:");
				lblTitulacion.setForeground(Color.BLUE);
				lblTitulacion.setFont(new Font("Arial", Font.BOLD, 13));
				lblTitulacion.setBounds(10, 185, 137, 15);
				panel.add(lblTitulacion);
			}
			{
				JLabel label = new JLabel("Categor\u00EDa:");
				label.setForeground(Color.BLUE);
				label.setFont(new Font("Arial", Font.BOLD, 13));
				label.setBounds(10, 136, 66, 15);
				panel.add(label);
			}
			{
				campoCategoria = new JLabel("New label");
				campoCategoria.setBounds(89, 137, 82, 14);
				panel.add(campoCategoria);
			}
			{
				campoTitulacion = new JLabel("New label");
				campoTitulacion.setBounds(89, 186, 90, 14);
				panel.add(campoTitulacion);
			}
			{
				JLabel label = new JLabel("A\u00F1os Experiencia:");
				label.setForeground(Color.BLUE);
				label.setFont(new Font("Arial", Font.BOLD, 13));
				label.setBounds(224, 137, 115, 15);
				panel.add(label);
			}
			{
				campoAnnosExp = new JLabel("New label");
				campoAnnosExp.setBounds(355, 137, 46, 14);
				panel.add(campoAnnosExp);
			}
			{
				JLabel label = new JLabel("\u20AC");
				label.setForeground(Color.BLUE);
				label.setFont(new Font("Arial", Font.BOLD, 13));
				label.setBounds(378, 81, 66, 14);
				panel.add(label);
			}
			{
				campoSueldo = new JLabel("New label");
				campoSueldo.setBounds(297, 81, 46, 14);
				panel.add(campoSueldo);
			}
			{
				JLabel label = new JLabel("Sueldo:");
				label.setForeground(Color.BLUE);
				label.setFont(new Font("Arial", Font.BOLD, 13));
				label.setBounds(224, 80, 49, 15);
				panel.add(label);
			}
			{
				campoAnnoNac = new JLabel("New label");
				campoAnnoNac.setBounds(125, 81, 46, 14);
				panel.add(campoAnnoNac);
			}
			{
				JLabel label = new JLabel("A\u00F1o Nacimiento:");
				label.setForeground(Color.BLUE);
				label.setFont(new Font("Arial", Font.BOLD, 13));
				label.setBounds(10, 80, 105, 15);
				panel.add(label);
			}
			{
				JLabel label = new JLabel("Nombre:");
				label.setForeground(Color.BLUE);
				label.setFont(new Font("Arial", Font.BOLD, 13));
				label.setBounds(10, 33, 54, 15);
				panel.add(label);
			}
			{
				campoNombre = new JLabel("New label");
				campoNombre.setBounds(74, 34, 73, 14);
				panel.add(campoNombre);
			}
			{
				JLabel label = new JLabel("Apellidos:");
				label.setForeground(Color.BLUE);
				label.setFont(new Font("Arial", Font.BOLD, 13));
				label.setBounds(224, 33, 63, 15);
				panel.add(label);
			}
			{
				campoApellido1 = new JLabel("New label");
				campoApellido1.setBounds(297, 34, 71, 14);
				panel.add(campoApellido1);
			}
			{
				campoApellido2 = new JLabel("New label");
				campoApellido2.setBounds(378, 34, 78, 14);
				panel.add(campoApellido2);
			}
		}
		{
			JLabel lblNewLabel = new JLabel("Elegir Masajista:");
			lblNewLabel.setBounds(81, 21, 96, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			comboBox = new JComboBox(club.getMasajistasParaLista());
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String temp = (String) comboBox.getSelectedItem();
					String[] partes = temp.split(".-");
					Miembro masajista =  club.get(Integer
							.parseInt(partes[0]));
					campoNombre.setText(masajista.getNombre());
					campoApellido1.setText(masajista.getApellido1());
					campoApellido2.setText(masajista.getApellido2());
					campoAnnoNac.setText(masajista.getAñoNacimiento());
					campoAnnosExp.setText(String.valueOf(((Masajista) masajista).getAnnosExperiencia()));
					campoCategoria.setText(String.valueOf(masajista.getCategoria()));
					campoSueldo.setText(String.valueOf(masajista.getSueldo()));
					campoTitulacion.setText(String.valueOf(((Masajista) masajista).getTitulacion()));
					
				}
			});
			comboBox.setBounds(184, 15, 134, 26);
			contentPanel.add(comboBox);
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
								"¿Está seguro de eliminar este masajista?",
								"Eliminar masajista",
								JOptionPane.YES_NO_OPTION);
						if (resp == JOptionPane.YES_OPTION) {
							String temp = (String) comboBox.getSelectedItem();
							String[] partes = temp.split(".-");
							club.eliminar(Integer.parseInt(partes[0]));
							JOptionPane.showMessageDialog(null,
									"Masajista eliminado con éxito");
							club.setModificado(true);
							Club clubFiltered = club.getClubFiltradoTipo(Tipo.MASAJISTA);
							if (clubFiltered.size() > 0) {
								comboBox.removeItemAt(comboBox
										.getSelectedIndex());
								comboBox.revalidate();
								comboBox.repaint();
							} else {
								JOptionPane.showMessageDialog(null,
										"No hay más masajistas en la lista.");
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
	}

}
