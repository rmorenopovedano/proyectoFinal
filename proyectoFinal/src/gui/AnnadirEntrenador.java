package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import proyectoFinal.Entrenador;
import proyectoFinal.NivelEntrenador;
import proyectoFinal.NombreInvalidoException;
import proyectoFinal.ValorNegativoException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SpinnerNumberModel;

public class AnnadirEntrenador extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField campoNombre;
	private JTextField campoApellido1;
	private JTextField campoApellido2;
	private JList<NivelEntrenador> listaTitulacion;
	private Club club;
	private JSpinner spinnerAnnosExp;
	private JList<Categoria> listaCategorias;
	private Component frame;

	/**
	 * Create the dialog.
	 */
	public AnnadirEntrenador(Club club2) {
		setResizable(false);
		setModal(true);
		setTitle("A\u00F1adir Entrenador");
		club = club2;
		setBounds(100, 100, 750, 400);
		setLocationRelativeTo(frame);
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
				spinnerAnnosExp = new JSpinner();
				spinnerAnnosExp.setModel(new SpinnerNumberModel(0, 0, 50, 1));
				spinnerAnnosExp.setBounds(395, 111, 42, 20);
				panel.add(spinnerAnnosExp);
			}
			{
				JLabel lblAosExperiencia = new JLabel("A\u00F1os Experiencia");
				lblAosExperiencia.setBounds(279, 114, 120, 14);
				panel.add(lblAosExperiencia);
			}
			{
				JLabel lblTitulacin = new JLabel("Nivel");
				lblTitulacin.setBounds(189, 230, 51, 14);
				panel.add(lblTitulacin);
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(244, 197, 102, 67);
				panel.add(scrollPane);

				listaTitulacion = new JList<NivelEntrenador>(NivelEntrenador.values());
				listaTitulacion.setSelectedIndex(0);
				scrollPane.setViewportView(listaTitulacion);
				listaTitulacion
						.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				listaTitulacion.setBorder(new LineBorder(Color.LIGHT_GRAY));
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(472, 197, 110, 67);
				panel.add(scrollPane);
				{
					listaCategorias = new JList<Categoria>(Categoria.values());
					listaCategorias.setSelectedIndex(0);
					scrollPane.setViewportView(listaCategorias);
					listaCategorias
							.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					listaCategorias.setBorder(new LineBorder(Color.LIGHT_GRAY));
				}
			}
			{
				JLabel lblNewLabel = new JLabel("Categor\u00EDa");
				lblNewLabel.setBounds(388, 230, 74, 14);
				panel.add(lblNewLabel);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("ACEPTAR");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							club.annadir(new Entrenador(campoNombre.getText(),
									campoApellido1.getText(), campoApellido2
											.getText(),
									(Categoria) listaCategorias
											.getSelectedValue(),
									(NivelEntrenador) listaTitulacion
											.getSelectedValue(),
									(int) spinnerAnnosExp.getValue()));
							JOptionPane.showMessageDialog(null,
									"Entrenador añadido con éxito");
							club.setModificado(true);
							campoNombre.setText(null);
							campoApellido1.setText(null);
							campoApellido2.setText(null);
						} catch (NombreInvalidoException
								| ApellidoInvalidoException
								| AñoNacimientoInvalidoException
								| ValorNegativoException e) {
							JOptionPane.showMessageDialog(getParent(),
									e.getMessage(), "Error",
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
