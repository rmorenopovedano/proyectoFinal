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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextPane;

import java.awt.SystemColor;
import java.awt.Font;

import javax.swing.border.TitledBorder;

import java.awt.Color;

import javax.swing.UIManager;

/**
 * 
 * @author RAUL MORENO POVEDANO
 * @version 1.0
 */
public class SobreElClub extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private Component frame;

	/**
	 * Create the dialog.
	 */
	public SobreElClub() {
		setTitle("Acerca del Club");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(frame);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Alumno", TitledBorder.LEFT,
				TitledBorder.TOP, null, Color.GRAY));
		panel.setBounds(105, 107, 240, 108);
		contentPanel.add(panel);
		panel.setLayout(null);

		JTextPane txtpnAutorRalMoreno = new JTextPane();
		txtpnAutorRalMoreno.setBounds(6, 16, 228, 81);
		panel.add(txtpnAutorRalMoreno);
		txtpnAutorRalMoreno
				.setText("Autor: Ra\u00FAl Moreno Povedano\r\nVersion: 1.0\r\nCurso: 1\u00BA DAW\r\nAsignatura: Programaci\u00F3n\r\nA\u00F1o: 2015");
		txtpnAutorRalMoreno.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtpnAutorRalMoreno.setBackground(SystemColor.menu);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Club",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		panel_1.setBounds(104, 11, 241, 85);
		contentPanel.add(panel_1);

		JTextPane txtpnNombreCdModas = new JTextPane();
		txtpnNombreCdModas
				.setText("Nombre: C.D. Modas Levante\r\nLocalidad: C\u00F3rdoba\r\nA\u00F1o de Fundaci\u00F3n: 1988");
		txtpnNombreCdModas.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtpnNombreCdModas.setBackground(SystemColor.menu);
		txtpnNombreCdModas.setBounds(6, 16, 228, 58);
		panel_1.add(txtpnNombreCdModas);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			buttonPane.setBackground(new Color(255, 255, 255, 0));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("VOLVER");
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
