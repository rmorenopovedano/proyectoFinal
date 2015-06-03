/**
 * 
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JList;

import proyectoFinal.ApellidoInvalidoException;
import proyectoFinal.AñoNacimientoInvalidoException;
import proyectoFinal.Club;
import proyectoFinal.DemarcacionJugador;
import proyectoFinal.Jugador;
import proyectoFinal.NombreInvalidoException;
import proyectoFinal.ValorNegativoException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.SpinnerNumberModel;

/**
 * 
 * @author RAUL MORENO POVEDANO
 * @version 1.0
 */
public class AnnadirJugador extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField campoNombre;
	private JTextField campoApellido1;
	private JTextField campoApellido2;
	private JTextField campoAnno;
	private JList<DemarcacionJugador> listaDemarcacion;
	private JSpinner spinnerDorsal;
	private JSpinner spinnerPartidosJugados;
	private JSpinner spinnerGoles;
	private Club club;
	private Component frame;

	/**
	 * Create the dialog.
	 */
	public AnnadirJugador(Club club2) {
		setResizable(false);
		setModal(true);
		club = club2;
		setTitle("A\u00F1adir Jugador");
		setBounds(100, 100, 750, 400);
		setLocationRelativeTo(frame);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(24, 23, 46, 14);
		contentPanel.add(lblNewLabel);

		campoNombre = new JTextField();
		campoNombre.setBounds(71, 20, 86, 20);
		contentPanel.add(campoNombre);
		campoNombre.setColumns(10);
		{
			JLabel lblPrimerApellido = new JLabel("Primer apellido");
			lblPrimerApellido.setBounds(226, 23, 120, 14);
			contentPanel.add(lblPrimerApellido);
		}
		{
			campoApellido1 = new JTextField();
			campoApellido1.setColumns(10);
			campoApellido1.setBounds(326, 20, 86, 20);
			contentPanel.add(campoApellido1);
		}
		{
			JLabel lblSegundoApellido = new JLabel("Segundo apellido");
			lblSegundoApellido.setBounds(478, 23, 120, 14);
			contentPanel.add(lblSegundoApellido);
		}
		{
			campoApellido2 = new JTextField();
			campoApellido2.setColumns(10);
			campoApellido2.setBounds(584, 20, 86, 20);
			contentPanel.add(campoApellido2);
		}
		{
			JLabel lblAoNacimiento = new JLabel("A\u00F1o nacimiento");
			lblAoNacimiento.setBounds(230, 113, 96, 14);
			contentPanel.add(lblAoNacimiento);
		}

		campoAnno = new JTextField();
		campoAnno.setColumns(10);
		campoAnno.setBounds(342, 110, 86, 20);
		contentPanel.add(campoAnno);
		{
			spinnerDorsal = new JSpinner();
			spinnerDorsal.setModel(new SpinnerNumberModel(1, 1, 99, 1));
			spinnerDorsal.setBounds(628, 197, 42, 20);
			contentPanel.add(spinnerDorsal);
		}
		{
			JLabel lblDorsal = new JLabel("Dorsal");
			lblDorsal.setBounds(498, 200, 120, 14);
			contentPanel.add(lblDorsal);
		}
		{
			spinnerPartidosJugados = new JSpinner();
			spinnerPartidosJugados.setModel(new SpinnerNumberModel(new Integer(
					0), new Integer(0), null, new Integer(1)));
			spinnerPartidosJugados.setBounds(628, 229, 42, 20);
			contentPanel.add(spinnerPartidosJugados);
		}
		{
			JLabel lblPartidosJugados = new JLabel("Partidos Jugados");
			lblPartidosJugados.setBounds(498, 233, 120, 14);
			contentPanel.add(lblPartidosJugados);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(107, 208, 127, 67);
			contentPanel.add(scrollPane);
			{
				listaDemarcacion = new JList<DemarcacionJugador>(
						DemarcacionJugador.values());
				listaDemarcacion.setSelectedIndex(0);
				scrollPane.setViewportView(listaDemarcacion);
				listaDemarcacion
						.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				listaDemarcacion.setBorder(new LineBorder(Color.LIGHT_GRAY));
			}
		}
		{
			JLabel lblDemarcacin = new JLabel("Demarcaci\u00F3n");
			lblDemarcacin.setBounds(28, 227, 129, 14);
			contentPanel.add(lblDemarcacin);
		}
		{
			spinnerGoles = new JSpinner();
			spinnerGoles.setModel(new SpinnerNumberModel(new Integer(0),
					new Integer(0), null, new Integer(1)));
			spinnerGoles.setBounds(628, 260, 42, 20);
			contentPanel.add(spinnerGoles);
		}
		{
			JLabel lblGolesMarcados = new JLabel("Goles marcados");
			lblGolesMarcados.setBounds(498, 263, 118, 14);
			contentPanel.add(lblGolesMarcados);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton annadirButton = new JButton("A\u00D1ADIR");
				annadirButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							club.annadir(new Jugador(campoNombre.getText(),
									campoApellido1.getText(), campoApellido2
											.getText(), campoAnno.getText().trim(),
									(int) spinnerPartidosJugados.getValue(),
									(int) spinnerDorsal.getValue(),
									(DemarcacionJugador) listaDemarcacion
											.getSelectedValue(),
									(int) spinnerGoles.getValue()));
							JOptionPane.showMessageDialog(null,
									"Jugador añadido con éxito");
							club.setModificado(true);
							campoNombre.setText(null);
							campoApellido1.setText(null);
							campoApellido2.setText(null);
							campoAnno.setText(null);
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
				annadirButton.setActionCommand("OK");
				buttonPane.add(annadirButton);
				getRootPane().setDefaultButton(annadirButton);
			}
			{
				JButton cancelButton = new JButton("CANCELAR");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
