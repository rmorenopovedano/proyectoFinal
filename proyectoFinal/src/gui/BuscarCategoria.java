package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

import proyectoFinal.Categoria;
import proyectoFinal.Club;
import proyectoFinal.Miembro;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class BuscarCategoria extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private Club club;
	private JComboBox comboBox;
	private MostrarMiembro mostrarMiembro;
	private Component frame;

	/**
	 * Create the dialog.
	 */
	public BuscarCategoria(Club club2) {
		setResizable(false);
		setModal(true);
		setTitle("Buscar por Categor\u00EDa");
		club = club2;
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(frame);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		comboBox = new JComboBox(Categoria.values());
		comboBox.setBounds(147, 32, 133, 26);
		contentPanel.add(comboBox);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("ACEPTAR");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Club clubCategoria = getPorCategoria((Categoria) comboBox
								.getSelectedItem());
						if(clubCategoria.isEmpty())
							JOptionPane.showMessageDialog(frame, "No hay miembros en esta categoría");
						else{
							mostrarMiembro = new MostrarMiembro(clubCategoria);
							mostrarMiembro.setVisible(true);
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

	protected Club getPorCategoria(Categoria categoria) {
		ArrayList<Miembro> arraylist = club.getMiembrosCategoria(categoria);
		Club clubPorCategoria = new Club();
		for (Miembro miembro : arraylist) {
			clubPorCategoria.annadir(miembro);
		}

		return clubPorCategoria;
	}

}
