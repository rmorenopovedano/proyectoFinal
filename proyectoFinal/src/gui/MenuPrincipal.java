package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import proyectoFinal.Club;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal {

	private JFrame frmMenuPrincipal;
	private AnnadirJugador annadirJugador;
	private MostrarJugador mostrarJugador;
	private BuscarCategoria buscarCategoria;
	private BuscarPorAnno buscarAnno;
	private Club club = new Club();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal window = new MenuPrincipal();
					window.frmMenuPrincipal.setVisible(true);
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
		frmMenuPrincipal = new JFrame();
		frmMenuPrincipal.setTitle("Menu Principal");
		frmMenuPrincipal.setBounds(100, 100, 450, 300);
		frmMenuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmMenuPrincipal.setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mnArchivo.add(mntmNuevo);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir...");
		mnArchivo.add(mntmAbrir);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mnArchivo.add(mntmGuardar);
		
		JMenuItem mntmGuardarComo = new JMenuItem("Guardar como...");
		mnArchivo.add(mntmGuardarComo);
		
		JMenu mnClub = new JMenu("Club");
		menuBar.add(mnClub);
		
		JMenu mnAadir = new JMenu("A\u00F1adir");
		mnClub.add(mnAadir);
		
		JMenuItem mntmJugador_1 = new JMenuItem("Jugador");
		mntmJugador_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				annadirJugador=new AnnadirJugador(club);
				annadirJugador.setVisible(true);
			}
		});
		mnAadir.add(mntmJugador_1);
		
		JMenuItem mntmEntrenador_1 = new JMenuItem("Entrenador");
		mnAadir.add(mntmEntrenador_1);
		
		JMenuItem mntmMasajista_1 = new JMenuItem("Masajista");
		mnAadir.add(mntmMasajista_1);
		
		JMenu mnMostrar = new JMenu("Mostrar");
		mnClub.add(mnMostrar);
		
		JMenuItem mntmJugador = new JMenuItem("Jugador");
		mntmJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(club.isEmpty()){
					JOptionPane.showMessageDialog(null, "No hay jugadores en la lista.");
				}else{
				mostrarJugador=new MostrarJugador(club);
				mostrarJugador.setVisible(true);
				}
			}
		});
		mnMostrar.add(mntmJugador);
		
		JMenuItem mntmEntrenador = new JMenuItem("Entrenador");
		mnMostrar.add(mntmEntrenador);
		
		JMenuItem mntmMasajista = new JMenuItem("Masajista");
		mnMostrar.add(mntmMasajista);
		
		JMenu mnBuscar = new JMenu("Buscar");
		menuBar.add(mnBuscar);
		
		JMenuItem mntmPorCategora = new JMenuItem("Por categor\u00EDa");
		mntmPorCategora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarCategoria=new BuscarCategoria(club);
				buscarCategoria.setVisible(true);
			}
		});
		mnBuscar.add(mntmPorCategora);
		
		JMenuItem mntmPorAoDe = new JMenuItem("Por a\u00F1o de inscripci\u00F3n");
		mntmPorAoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarAnno = new BuscarPorAnno(club);
				buscarAnno.setVisible(true);
			}
		});
		mnBuscar.add(mntmPorAoDe);
	}

}
