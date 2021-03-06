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
import proyectoFinal.Miembro;
import proyectoFinal.Masajista;
import proyectoFinal.Tipo;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 
 * @author RAUL MORENO POVEDANO
 * @version 1.0
 */
public class MostrarMasajista extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private Club club;
	private JComboBox<String>comboBox;
	private JLabel campoApellido2;
	private JLabel campoApellido1;
	private JLabel campoNombre;
	private JLabel campoSueldo;
	private JLabel campoAnnosExp;
	private JLabel campoCategoria;
	private JLabel lblTitulacion;
	private JLabel campoTitulacion;
	private JLabel campoFechaAlta;
	private Component frame;

	/**
	 * Create the dialog.
	 */
	public MostrarMasajista(Club club2) {
		setResizable(false);
		setModal(true);
		setTitle("Mostrar Masajista");
		setBounds(100, 100, 500, 370);
		setLocationRelativeTo(frame);
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
				lblTitulacion.setBounds(10, 185, 97, 15);
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
				campoCategoria = new JLabel("");
				campoCategoria.setBounds(89, 137, 82, 14);
				panel.add(campoCategoria);
			}
			{
				campoTitulacion = new JLabel("");
				campoTitulacion.setBounds(89, 186, 125, 14);
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
				campoAnnosExp = new JLabel("");
				campoAnnosExp.setBounds(355, 137, 46, 14);
				panel.add(campoAnnosExp);
			}
			{
				JLabel label = new JLabel("\u20AC");
				label.setForeground(Color.BLUE);
				label.setFont(new Font("Arial", Font.BOLD, 13));
				label.setBounds(164, 81, 66, 14);
				panel.add(label);
			}
			{
				campoSueldo = new JLabel("");
				campoSueldo.setBounds(83, 81, 46, 14);
				panel.add(campoSueldo);
			}
			{
				JLabel label = new JLabel("Sueldo:");
				label.setForeground(Color.BLUE);
				label.setFont(new Font("Arial", Font.BOLD, 13));
				label.setBounds(10, 80, 49, 15);
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
				campoNombre = new JLabel("");
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
				campoApellido1 = new JLabel("");
				campoApellido1.setBounds(297, 34, 71, 14);
				panel.add(campoApellido1);
			}
			{
				campoApellido2 = new JLabel("");
				campoApellido2.setBounds(378, 34, 78, 14);
				panel.add(campoApellido2);
			}
			{
				JLabel lblFechaAlta = new JLabel("Fecha Alta:");
				lblFechaAlta.setForeground(Color.BLUE);
				lblFechaAlta.setFont(new Font("Arial", Font.BOLD, 13));
				lblFechaAlta.setBounds(224, 186, 105, 15);
				panel.add(lblFechaAlta);
			}
			{
				campoFechaAlta = new JLabel("");
				campoFechaAlta.setBounds(322, 186, 90, 14);
				panel.add(campoFechaAlta);
			}
		}
		{
			JLabel lblNewLabel = new JLabel("Elegir Masajista:");
			lblNewLabel.setBounds(81, 21, 96, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			comboBox = new JComboBox<String>(club.getMasajistasParaLista());
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String temp = (String) comboBox.getSelectedItem();
					String[] partes = temp.split(".-");
					Miembro masajista =  club.get(Integer
							.parseInt(partes[0]));
					campoNombre.setText(masajista.getNombre());
					campoApellido1.setText(masajista.getApellido1());
					campoApellido2.setText(masajista.getApellido2());
					campoAnnosExp.setText(String.valueOf(((Masajista) masajista).getAnnosExperiencia()));
					campoCategoria.setText(String.valueOf(masajista.getCategoria()));
					campoSueldo.setText(String.valueOf(masajista.getSueldo()));
					campoTitulacion.setText(String.valueOf(((Masajista) masajista).getTitulacion()));
					campoFechaAlta.setText(masajista.getFechaAlta());
					
				}
			});
			comboBox.setBounds(184, 15, 228, 26);
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
								"�Est� seguro de eliminar este masajista?",
								"Eliminar masajista",
								JOptionPane.YES_NO_OPTION);
						if (resp == JOptionPane.YES_OPTION) {
							String temp = (String) comboBox.getSelectedItem();
							String[] partes = temp.split(".-");
							club.eliminar(Integer.parseInt(partes[0]));
							JOptionPane.showMessageDialog(null,
									"Masajista eliminado con �xito");
							club.setModificado(true);
							Club clubFiltrado = club.getClubFiltradoTipo(Tipo.MASAJISTA);
							if (clubFiltrado.size() > 0) {
								comboBox.removeItemAt(comboBox
										.getSelectedIndex());
								comboBox.revalidate();
								comboBox.repaint();
							} else {
								JOptionPane.showMessageDialog(null,
										"No hay m�s masajistas en la lista.");
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
