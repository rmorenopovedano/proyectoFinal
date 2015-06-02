package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

import proyectoFinal.Club;
import proyectoFinal.Miembro;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class BuscarPorAnno extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private Club club;
	private MostrarMiembro mostrarMiembro;
	private JComboBox<String> comboBox;
	private Component frame;

	/**
	 * Create the dialog.
	 */
	public BuscarPorAnno(Club club2) {
		setResizable(false);
		setModal(true);
		setTitle("Buscar por A\u00F1o de Inscripci\u00F3n");
		setBounds(100, 100, 332, 179);
		setLocationRelativeTo(frame);
		club = club2;
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			SimpleDateFormat formato = new SimpleDateFormat("yyyy");
			int diferencia = Integer.parseInt(formato.format(new Date()))
					- 2015 +1;
			String anyos [] = new String[diferencia];
			int pos = 0;
			for(int i = 2015; i<(Integer.parseInt(formato.format(new Date()))+1); i++){
				anyos[pos] = Integer.toString(i);
				pos++;
			}
			comboBox = new JComboBox<String>(anyos);
			comboBox.setBounds(159, 55, 94, 20);
			contentPanel.add(comboBox);
		}
		
		JLabel lblSeleccionarFecha = new JLabel("Seleccionar fecha:");
		lblSeleccionarFecha.setBounds(37, 58, 122, 14);
		contentPanel.add(lblSeleccionarFecha);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("ACEPTAR");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Club clubPorAnno=getPorAnno((String) comboBox.getSelectedItem());
						mostrarMiembro=new MostrarMiembro(clubPorAnno);
						mostrarMiembro.setVisible(true);
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
	protected Club getPorAnno(String fechaAlta) {
		ArrayList<Miembro> arraylist = club.getMiembrosPorAnno(fechaAlta);
		Club clubPorAnno = new Club();
		for (Miembro miembro : arraylist) {
			clubPorAnno.annadir(miembro);
		}

		return clubPorAnno;
	}
}
