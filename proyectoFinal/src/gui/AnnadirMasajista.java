package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import proyectoFinal.ApellidoInvalidoException;
import proyectoFinal.AñoNacimientoInvalidoException;
import proyectoFinal.Categoria;
import proyectoFinal.Club;
import proyectoFinal.Masajista;
import proyectoFinal.MiembroYaExisteException;
import proyectoFinal.NombreInvalidoException;
import proyectoFinal.TitulacionMasajista;
import proyectoFinal.ValorNegativoException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AnnadirMasajista extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField campoNombre;
	private JTextField campoApellido1;
	private JTextField campoApellido2;
	private JTextField campoAnnoNac;
	private JList listaTitulacion;
	private JList listaCategoria;
	private Club club;
	private JSpinner spinnerAnnosExp;

	/**
	 * Create the dialog.
	 */
	public AnnadirMasajista(Club club2) {
		setTitle("A\u00F1adir Masajista");
		club = club2;
		setBounds(100, 100, 750, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBorder(new EmptyBorder(5, 5, 5, 5));
			panel.setBounds(0, 0, 734, 328);
			contentPanel.add(panel);
			{
				JLabel label = new JLabel("Nombre");
				label.setBounds(24, 23, 46, 14);
				panel.add(label);
			}
			{
				campoNombre = new JTextField();
				campoNombre.setColumns(10);
				campoNombre.setBounds(71, 20, 86, 20);
				panel.add(campoNombre);
			}
			{
				JLabel label = new JLabel("Primer apellido");
				label.setBounds(226, 23, 120, 14);
				panel.add(label);
			}
			{
				campoApellido1 = new JTextField();
				campoApellido1.setColumns(10);
				campoApellido1.setBounds(326, 20, 86, 20);
				panel.add(campoApellido1);
			}
			{
				JLabel label = new JLabel("Segundo apellido");
				label.setBounds(478, 23, 120, 14);
				panel.add(label);
			}
			{
				campoApellido2 = new JTextField();
				campoApellido2.setColumns(10);
				campoApellido2.setBounds(584, 20, 86, 20);
				panel.add(campoApellido2);
			}
			{
				JLabel label = new JLabel("A\u00F1o nacimiento");
				label.setBounds(147, 113, 96, 14);
				panel.add(label);
			}
			{
				campoAnnoNac = new JTextField();
				campoAnnoNac.setColumns(10);
				campoAnnoNac.setBounds(259, 110, 86, 20);
				panel.add(campoAnnoNac);
			}
			{
				spinnerAnnosExp = new JSpinner();
				spinnerAnnosExp.setBounds(523, 110, 42, 20);
				panel.add(spinnerAnnosExp);
			}
			{
				JLabel label = new JLabel("A\u00F1os Experiencia");
				label.setBounds(407, 113, 120, 14);
				panel.add(label);
			}
			{
				JLabel lblTitulacion = new JLabel("Titulacion");
				lblTitulacion.setBounds(172, 230, 51, 14);
				panel.add(lblTitulacion);
			}
			{
				JLabel label = new JLabel("Categor\u00EDa");
				label.setBounds(388, 230, 74, 14);
				panel.add(label);
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(250, 205, 120, 71);
				panel.add(scrollPane);
				{
					listaTitulacion = new JList(TitulacionMasajista.values());
					listaTitulacion.setSelectedIndex(0);
					scrollPane.setViewportView(listaTitulacion);
					listaTitulacion
							.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					listaTitulacion.setBorder(new LineBorder(Color.LIGHT_GRAY));
				}
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(469, 205, 113, 71);
				panel.add(scrollPane);
				{
					listaCategoria = new JList(Categoria.values());
					listaCategoria.setSelectedIndex(0);
					scrollPane.setViewportView(listaCategoria);
					listaCategoria
							.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					listaCategoria.setBorder(new LineBorder(Color.LIGHT_GRAY));
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("ACEPTAR");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							club.annadir(new Masajista(campoNombre.getText(),
									campoApellido1.getText(), campoApellido2
											.getText(), campoAnnoNac.getText(),
									(Categoria) listaCategoria
											.getSelectedValue(),
									(TitulacionMasajista) listaTitulacion
											.getSelectedValue(),
									(int) spinnerAnnosExp.getValue()));
							JOptionPane.showMessageDialog(null,
									"Masajista añadido con éxito");
							club.setModificado(true);
						} catch (NombreInvalidoException
								| ApellidoInvalidoException
								| AñoNacimientoInvalidoException
								| ValorNegativoException e1) {
							JOptionPane.showMessageDialog(getParent(),
									e1.getMessage(), "Error",
									JOptionPane.ERROR_MESSAGE);
						}

					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("CANCELAR");
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
