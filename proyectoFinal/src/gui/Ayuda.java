package gui;


import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;

public class Ayuda extends JDialog {

	/**
	 * Launch the application.
	 */


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Component frame;
	private JEditorPane dtrpnHola;

	/**
	 * Create the dialog.
	 */
	public Ayuda() {
		setModal(true);
		setResizable(false);
		setTitle("Ayuda");
		setBounds(100, 100, 560, 421);
		setLocationRelativeTo(frame);
		getContentPane().setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(10, 327, 534, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton volverButton = new JButton("VOLVER");
				volverButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				volverButton.setActionCommand("Cancel");
				buttonPane.add(volverButton);
			}
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 44, 534, 272);
		getContentPane().add(scrollPane);
		{
			dtrpnHola = new JEditorPane();
			scrollPane.setViewportView(dtrpnHola);
			dtrpnHola.setEditable(false);
			dtrpnHola.setContentType("text/html");
			dtrpnHola.setText("");
		}
		
		JLabel lblElijaUnaOpcin = new JLabel("Elija una opci\u00F3n del men\u00FA para ver su ayuda");
		lblElijaUnaOpcin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblElijaUnaOpcin.setHorizontalAlignment(SwingConstants.CENTER);
		lblElijaUnaOpcin.setBounds(10, 11, 534, 22);
		getContentPane().add(lblElijaUnaOpcin);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dtrpnHola.setText("<html>\r\n<body>\r\n<h2>Men\u00FA</h2>\r\n<ul>\r\n\t<li>Archivo<br/></li>\r\n\t\t<ul>\r\n\t\t\t<li><u>Nuevo:</u> Crear un archivo nuevo vac\u00EDo. Si el archivo ha sido modificado y se vuelve a pulsar en <strong>Nuevo</strong> preguntar\u00E1 si se desea guardar el archivo anterior.</li>\r\n\t\t\t<li><u>Abrir:</u> Abrir un fichero existente. Si estamos trabajando con un archivo y no lo hemos guardado, si pulsamos en <strong>Abrir</strong> preguntar\u00E1 si se desea guardar el archivo.</li>\r\n\t\t\t<li><u>Guardar:</u> Guardar un archivo. Si al guardar el archivo existe un archivo con el mismo nombre, preguntar\u00E1 si deseamos sobreescribirlo.</li>\r\n\t\t\t<li><u>Guardar como:</u> Guardar el fichero con otro nombre distinto.</li>\r\n\t\t</ul>\r\n\t\r\n\t<li>Club<br/></li>\r\n\t\t<ul>\r\n\t\t\t<li>A\u00F1adir</li>\r\n\t\t\t\t<ul>\r\n\t\t\t\t\t<li><u>Jugador:</u> A\u00F1adir un jugador al club. Se a\u00F1adir\u00E1n los campos Nombre, Primer apellido, Segundo apellido, A\u00F1o Nacimiento, Demarcaci\u00F3n, Partidos Jugados, Dorsal y Goles marcados.\r\n\t\t\t\t\t\t<p>Nombre y Primer apellido no pueden contener n\u00FAmeros ni quedar vac\u00EDos.</p>\r\n\t\t\t\t\t\t<p>Segundo apellido no puede contener n\u00FAmeros aunque si puede quedar vac\u00EDo ya que hay personas que no tienen segundo apellido.</p>\r\n\t\t\t\t\t\t<p>A\u00F1o Nacimiento ser\u00E1 una fecha comprendida entre 1900 y 2009, ambos inclusive. La edad m\u00EDnima para que un jugador pueda pertenecer al club es de 6 a\u00F1os, por tanto no puede haber un ni\u00F1o en el club m\u00E1s peque\u00F1o de esa edad.</p>\r\n\t\t\t\t\t\t<p>Demarcaci\u00F3n muestra las 5 posiciones de campo que existen en el f\u00FAtbol sala: PORTERO, CIERRE, ALA DERECHA, ALA IZQUIERDA Y PIVOT.</p>\r\n\t\t\t\t\t\t<p>Partidos Jugados que el jugador haya disputado en su vida. No puede haber un valor menor que 0.</p>\r\n\t\t\t\t\t\t<p>Dorsal es el n\u00FAmero favorito del jugador. En f\u00FAtbol sala solo existen dorsales entre 1 y 99.</p>\r\n\t\t\t\t\t\t<p>Goles marcados son los goles que el jugador haya anotado en su trayecto, siendo 0 el valor m\u00EDnimo.</p>\r\n\t\t\t\t\t</li>\r\n\t\t\t\t\t<li><u>Entrenador:</u></li>\r\n\t\t\t\t\t<li><u>Masajista:</u></li>\r\n\t\t\t\t</ul>\r\n\t\t\t<li>Mostrar</li>\r\n\t\t\t<li>Mostrar concesionario</li>\r\n\t\t\t<li>Buscar coche por matr\u00EDcula</li>\r\n\t\t\t<li>Buscar coche por color</li>\r\n\t\t\t<li>Contar coches del concesionario</li>\r\n\t\t</ul>\r\n</ul>\r\n</body>\r\n</html>\r\n\t\t");
			}
		});
		mnArchivo.add(mntmNuevo);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtrpnHola.setText("<html><head></head><body><h1>Esta es la ayuda de ABRIR</h1></body></html>");
			}
		});
		mnArchivo.add(mntmAbrir);
	}
}
