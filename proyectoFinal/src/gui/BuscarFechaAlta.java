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

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class BuscarFechaAlta extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private Club club;
	private JTextField campoFechaAlta;
	private MostrarMiembro mostrarMiembro;
	private Component frame;

	/**
	 * Create the dialog.
	 */
	public BuscarFechaAlta(Club club2) {
		setTitle("Buscar por Fecha de Alta");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 278, 157);
		setLocationRelativeTo(frame);
		club = club2;
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblIntroducirFecha = new JLabel("Introducir Fecha:");
			lblIntroducirFecha.setBounds(27, 42, 121, 14);
			contentPanel.add(lblIntroducirFecha);
		}

		campoFechaAlta = new JTextField();
		campoFechaAlta.setText("dd/MM/yyyy");
		campoFechaAlta.setBounds(143, 39, 71, 20);
		contentPanel.add(campoFechaAlta);
		campoFechaAlta.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("BUSCAR");
				okButton.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						if (validarFecha(campoFechaAlta.getText(), "dd/MM/yyyy")) {
							Club clubFechaAlta = getPorFechaAlta(campoFechaAlta
									.getText());
							if (clubFechaAlta.isEmpty())
								JOptionPane
										.showMessageDialog(frame,
												"No hay miembros dados de alta en esa fecha");
							else {
								mostrarMiembro = new MostrarMiembro(
										clubFechaAlta);
								mostrarMiembro.setVisible(true);
							}

						} else
							JOptionPane.showMessageDialog(frame,
									"Fecha inválida");

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

	protected Club getPorFechaAlta(String fecha) {
		ArrayList<Miembro> arraylist = club.getMiembrosFechaAlta(fecha);
		Club clubPorFechaAlta = new Club();
		for (Miembro miembro : arraylist) {
			clubPorFechaAlta.annadir(miembro);
		}

		return clubPorFechaAlta;
	}

	public boolean validarFecha(String fecha, String patronFecha) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(patronFecha);
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(fecha.trim());
		} catch (ParseException pe) {
			return false;
		}
		return true;

	}
}
