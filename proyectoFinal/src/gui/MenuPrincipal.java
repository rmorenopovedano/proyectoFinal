/**
 * 
 */
package gui;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import proyectoFinal.Club;
import proyectoFinal.Fichero;
import proyectoFinal.Miembro;
import proyectoFinal.Tipo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

import javax.swing.JSeparator;

/**
 * 
 * @author RAUL MORENO POVEDANO
 * @version 1.0
 */
public class MenuPrincipal {

	private JFrame frame;
	private AnnadirJugador annadirJugador;
	private AnnadirEntrenador annadirEntrenador;
	private AnnadirMasajista annadirMasajista;
	private MostrarJugador mostrarJugador;
	private MostrarEntrenador mostrarEntrenador;
	private MostrarMasajista mostrarMasajista;
	private BuscarCategoria buscarCategoria;
	private BuscarPorAnno buscarAnno;
	private BuscarFechaAlta buscarFechaAlta;
	private SobreElClub sobreElClub;
	private Ayuda ayuda;
	private Club club = new Club();
	private File fichero;
	private JFileChooser filechooser = new JFileChooser();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal window = new MenuPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		filechooser.setFileFilter(new FileNameExtensionFilter(
				"Archivos Tipo .obj", "obj"));
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Menu Principal");
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				if (comprobarCambios())
					System.exit(0);
			}
		});
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		mnArchivo.setMnemonic('a');
		menuBar.add(mnArchivo);

		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				InputEvent.CTRL_MASK));
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comprobarCambios()) {
					fichero = null;
					frame.setTitle("Sin Titulo - C.D. Modas Levante");
					club = new Club();
					Miembro.idContador=0;
				}
			}
		});
		mnArchivo.add(mntmNuevo);

		JMenuItem mntmAbrir = new JMenuItem("Abrir...");
		mntmAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				InputEvent.CTRL_MASK));
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comprobarCambios())
					abrir();
			}
		});
		mnArchivo.add(mntmAbrir);

		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,
				InputEvent.CTRL_MASK));
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		mnArchivo.add(mntmGuardar);

		JMenuItem mntmGuardarComo = new JMenuItem("Guardar como...");
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarComo();
			}
		});
		mnArchivo.add(mntmGuardarComo);

		JSeparator separator = new JSeparator();
		mnArchivo.add(separator);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comprobarCambios())
					System.exit(0);
			}
		});
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				InputEvent.CTRL_MASK));
		mnArchivo.add(mntmSalir);

		JMenu mnClub = new JMenu("Club");
		mnClub.setMnemonic('c');
		menuBar.add(mnClub);

		JMenu mnAadir = new JMenu("A\u00F1adir");
		mnClub.add(mnAadir);

		JMenuItem mntmJugador_1 = new JMenuItem("Jugador");
		mntmJugador_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J,
				InputEvent.ALT_MASK));
		mntmJugador_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				annadirJugador = new AnnadirJugador(club);
				annadirJugador.setVisible(true);
			}
		});
		mnAadir.add(mntmJugador_1);

		JMenuItem mntmEntrenador_1 = new JMenuItem("Entrenador");
		mntmEntrenador_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
				InputEvent.ALT_MASK));
		mntmEntrenador_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				annadirEntrenador = new AnnadirEntrenador(club);
				annadirEntrenador.setVisible(true);
			}
		});
		mnAadir.add(mntmEntrenador_1);

		JMenuItem mntmMasajista_1 = new JMenuItem("Masajista");
		mntmMasajista_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,
				InputEvent.ALT_MASK));
		mntmMasajista_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				annadirMasajista = new AnnadirMasajista(club);
				annadirMasajista.setVisible(true);
			}
		});
		mnAadir.add(mntmMasajista_1);

		JSeparator separator_1 = new JSeparator();
		mnClub.add(separator_1);

		JMenu mnMostrar = new JMenu("Mostrar");
		mnClub.add(mnMostrar);

		JMenuItem mntmJugador = new JMenuItem("Jugador");
		mntmJugador.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J,
				InputEvent.SHIFT_MASK));
		mntmJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Club clubFiltered = club.getClubFiltradoTipo(Tipo.JUGADOR);
				if (clubFiltered.isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"No hay jugadores en la lista.");
				} else {
					mostrarJugador = new MostrarJugador(club);
					mostrarJugador.setVisible(true);
				}
			}
		});
		mnMostrar.add(mntmJugador);

		JMenuItem mntmEntrenador = new JMenuItem("Entrenador");
		mntmEntrenador.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
				InputEvent.SHIFT_MASK));
		mntmEntrenador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Club clubFiltrado = club.getClubFiltradoTipo(Tipo.ENTRENADOR);
				if (clubFiltrado.isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"No hay entrenadores en la lista.");
				} else {
					mostrarEntrenador = new MostrarEntrenador(club);
					mostrarEntrenador.setVisible(true);
				}
			}
		});
		mnMostrar.add(mntmEntrenador);

		JMenuItem mntmMasajista = new JMenuItem("Masajista");
		mntmMasajista.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,
				InputEvent.SHIFT_MASK));
		mntmMasajista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Club clubFiltered = club.getClubFiltradoTipo(Tipo.MASAJISTA);
				if (clubFiltered.isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"No hay masajistas en la lista.");
				} else {
					mostrarMasajista = new MostrarMasajista(club);
					mostrarMasajista.setVisible(true);
				}
			}
		});
		mnMostrar.add(mntmMasajista);

		JMenu mnBuscar = new JMenu("Buscar");
		mnBuscar.setMnemonic('b');
		menuBar.add(mnBuscar);

		JMenuItem mntmPorCategora = new JMenuItem("Por categor\u00EDa");
		mntmPorCategora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (club.isEmpty())
					JOptionPane.showMessageDialog(null,
							"No hay miembros en la lista.");
				else {
					buscarCategoria = new BuscarCategoria(club);
					buscarCategoria.setVisible(true);
				}

			}
		});
		mnBuscar.add(mntmPorCategora);

		JMenuItem mntmPorAoDe = new JMenuItem(
				"Por a\u00F1o de inscripci\u00F3n");
		mntmPorAoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (club.isEmpty())
					JOptionPane.showMessageDialog(null,
							"No hay miembros en la lista.");
				else {
					buscarAnno = new BuscarPorAnno(club);
					buscarAnno.setVisible(true);
				}

			}
		});
		mnBuscar.add(mntmPorAoDe);

		JMenuItem mntmPorFechaDe = new JMenuItem("Por fecha de alta");
		mntmPorFechaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (club.isEmpty())
					JOptionPane.showMessageDialog(null,
							"No hay miembros en la lista.");
				else {
					buscarFechaAlta = new BuscarFechaAlta(club);
					buscarFechaAlta.setVisible(true);
				}
			}
		});
		mnBuscar.add(mntmPorFechaDe);

		JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setMnemonic('h');
		menuBar.add(mnAyuda);

		JMenuItem mntmVerLaAyuda = new JMenuItem("Ver la Ayuda");
		mntmVerLaAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ayuda = new Ayuda();
				ayuda.setVisible(true);
			}
		});
		mnAyuda.add(mntmVerLaAyuda);

		JMenuItem mntmAcercaDelClub = new JMenuItem("Acerca del Club");
		mntmAcercaDelClub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sobreElClub = new SobreElClub();
				sobreElClub.setVisible(true);
			}
		});
		mnAyuda.add(mntmAcercaDelClub);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(MenuPrincipal.class
				.getResource("/gui/imagenes/BENJMODAS12.jpg")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 444, 250);
		frame.getContentPane().add(lblNewLabel);
	}

	/**
	 * Método que comprueba si el club ha sido modificado
	 * 
	 * @return true si se ha modificado, false en otro caso
	 */
	private boolean comprobarCambios() {
		int entero;
		if (club.isModificado()) {
			entero = JOptionPane
					.showConfirmDialog(
							frame,
							"Los cambios guardados se perderán. Desea guardar los cambios?",
							"Cambios", JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE);
			switch (entero) {
			case JOptionPane.YES_OPTION:
				return guardar();

			case JOptionPane.NO_OPTION:
				return true;
			case JOptionPane.CANCEL_OPTION:
				return false;

			}
		}
		return true;

	}

	/**
	 * Recupera el contenido de un fichero, en caso de que el videoclub se haya
	 * modificado se pregunta al usuario si desea guardarlo
	 */
	protected void abrir() {
		int entero = filechooser.showOpenDialog(frame);
		if (entero == JFileChooser.APPROVE_OPTION)
			try {
				club = (Club) Fichero.abrir(filechooser.getSelectedFile());
				fichero = filechooser.getSelectedFile();
				frame.setTitle(fichero.getName() + " - C.D. Modas Levante");
				club.setModificado(false);
				actualizarId(club.size());
			} catch (ClassNotFoundException | IOException e) {
				JOptionPane.showMessageDialog(frame,
						"No se ha podido abrir el archivo", "Abrir",
						JOptionPane.ERROR_MESSAGE);
			}

	}

	/**
	 * Método que comprueba la forma en la que hay que guardar un archivo
	 * 
	 * @return true si se guarda el archivo sin preguntar, false en caso de que
	 *         el archivo necesite guardarse con otro nombre
	 */
	private boolean guardar() {
		if (fichero != null)
			return almacenar();
		else
			return guardarComo();
	}

	/**
	 * Método que guarda un archivo directamente
	 * 
	 * @return true si se ha almacenado, false en cualquier otro caso
	 */
	private boolean almacenar() {
		try {
			fichero = filechooser.getSelectedFile();
			Fichero.guardar(fichero, club);
			fichero = Fichero.annadirExtension(fichero);
			frame.setTitle(fichero.getName() + " - C.D. Modas Levante");
			club.setModificado(false);
			return true;
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "No se ha podido guardar",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
		return false;
	}

	/**
	 * Método que guarda un fichero con un nombre nuevo
	 * 
	 * @return true si el fichero se guarda con un nombre nuevo, false en
	 *         cualquier otro caso
	 */
	private boolean guardarComo() {
		int opcion = filechooser.showSaveDialog(frame);
		if (opcion == JFileChooser.APPROVE_OPTION)
			if (sobreescribir(filechooser.getSelectedFile()))
				return almacenar();

		return false;
	}

	/**
	 * Método que comprueba si un archivo existe y pregunta si desea
	 * sobreescrirse
	 * 
	 * @param file2
	 *            Representa el archivo que vamos a guardar
	 * @return true si deseamos sobreescribir, false en cualquier otro caso
	 */
	protected boolean sobreescribir(File file2) {
		int entero;
		if (file2.exists()) {
			entero = JOptionPane.showConfirmDialog(frame,
					"¿Desea sobreescribir?", "Guardar",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			switch (entero) {
			case JOptionPane.YES_OPTION:
				return true;

			default:
				return false;
			}
		}
		return true;

	}
	/**
	 * Actualiza el id del club
	 * @param indice Representa el índice a actualizar
	 * @return índice actualizado
	 */
	private int actualizarId(int indice){
		return Miembro.idContador=indice;
	}
}
