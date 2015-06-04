/**
 * 
 */
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

/**
 * 
 * @author RAUL MORENO POVEDANO
 * @version 1.0
 */
public class Ayuda extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Component frame;
	private JEditorPane panelMensaje;

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
			panelMensaje = new JEditorPane();
			scrollPane.setViewportView(panelMensaje);
			panelMensaje.setEditable(false);
			panelMensaje.setContentType("text/html");
			panelMensaje.setText("");
			panelMensaje.setVisible(false);
		}

		JLabel lblElijaUnaOpcin = new JLabel(
				"Elija una opci\u00F3n del men\u00FA para ver su ayuda");
		lblElijaUnaOpcin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblElijaUnaOpcin.setHorizontalAlignment(SwingConstants.CENTER);
		lblElijaUnaOpcin.setBounds(10, 11, 534, 22);
		getContentPane().add(lblElijaUnaOpcin);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		mnArchivo.setMnemonic('a');
		menuBar.add(mnArchivo);

		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelMensaje.setVisible(true);
				panelMensaje
						.setText("<h2 text-align: justify>Crea un archivo nuevo vacío. Si el archivo ha sido modificado y se vuelve a pulsar en <strong>Nuevo</strong> preguntará si se desea guardar el archivo anterior.</h2>");
			}
		});
		mnArchivo.add(mntmNuevo);

		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMensaje.setVisible(true);
				panelMensaje
						.setText("<h2 text-align: justify>Abrir un fichero existente. Si estamos trabajando con un archivo y no lo hemos guardado, si pulsamos en <strong>Abrir</strong> preguntará si se desea guardar el archivo. En caso de que el archivo no pueda abrirse porque esté corrupto o no pueda abrirse, lanzará un mensaje de error.</h2>");
			}
		});
		mnArchivo.add(mntmAbrir);

		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelMensaje.setVisible(true);
				panelMensaje
						.setText("<h2 text-align: justify>Guardar un archivo. Si al guardar el archivo existe un archivo con el mismo nombre, preguntará si deseamos sobreescribirlo.</h2>");
			}
		});
		mnArchivo.add(mntmGuardar);

		JMenuItem mntmGuardarComo = new JMenuItem("Guardar como");
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMensaje.setVisible(true);
				panelMensaje
						.setText("<h2 text-align: justify>Guardar el fichero con otro nombre distinto.</h2>");
			}
		});
		mnArchivo.add(mntmGuardarComo);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMensaje.setVisible(true);
				panelMensaje
						.setText("<h2 text-align: justify>Salir del programa. Si el archivo en uso ha sido modificado, te pedirá si deseas guardar los cambios antes de salir.</h2>");
			}
		});
		mnArchivo.add(mntmSalir);

		JMenu mnNewMenu = new JMenu("Club");
		mnNewMenu.setMnemonic('c');
		menuBar.add(mnNewMenu);

		JMenu mnNewMenu_1 = new JMenu("A\u00F1adir");
		mnNewMenu.add(mnNewMenu_1);

		JMenuItem mntmJugador = new JMenuItem("Jugador");
		mntmJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMensaje.setVisible(true);
				panelMensaje
						.setText("<h2 text-align: justify>Añadir un jugador al club. Se añadirán los campos Nombre, Primer apellido, Segundo apellido, Año Nacimiento, Demarcación, Partidos Jugados, Dorsal y Goles marcados.<p>Nombre y Primer apellido no pueden contener números ni quedar vacíos.</p><p>Segundo apellido no puede contener números aunque si puede quedar vacío ya que hay personas que no tienen segundo apellido.</p><p>Año Nacimiento será una fecha comprendida entre 1900 y 2009, ambos inclusive, con el siguiente formato (YYYY). Si introduces un año de nacimiento en el que el niño tenga menos de 6 años, habrá un mensaje de error diciendo que el niño es demasiado pequeño, ya que la edad mínima para que un jugador pueda pertenecer al club es de 6 años, por tanto no puede haber un niño en el club más pequeño de esa edad. Si el error viene dado por meter un formato erróneo te avisará de error de formato.</p><p>Demarcación muestra las 5 posiciones de campo que existen en el fútbol sala: PORTERO, CIERRE, ALA DERECHA, ALA IZQUIERDA Y PIVOT.</p><p>Partidos Jugados que el jugador haya disputado en su vida. No puede haber un valor menor que 0.</p><p>Dorsal es el número favorito del jugador. En fútbol sala solo existen dorsales entre 1 y 99.</p><p>Goles marcados son los goles que el jugador haya anotado en su trayecto, siendo 0 el valor mínimo.</p></h2>");
			}
		});
		mnNewMenu_1.add(mntmJugador);

		JMenuItem mntmEntrenador = new JMenuItem("Entrenador");
		mntmEntrenador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMensaje.setVisible(true);
				panelMensaje
						.setText("<h2 text-align: justify>Añadir un entrenador al club. Se añadirán los campos Nombre, Primer apellido, Segundo apellido, Nivel, Categoría y Años de Experiencia.<p>Nombre y Primer apellido no pueden contener números ni quedar vacíos.</p><p>Segundo apellido no puede contener números aunque si puede quedar vacío, ya que hay personas que no tienen segundo apellido.</p></p><p>Nivel muestra los niveles que un entrenador ha de tener para poder entrenar en el club. Por orden de importancia de mayor a menor son: LICENCIADO, NIVEL2, NIVEL1, MONITOR.</p></<p>Categoría es el grupo de edad a los que va a entrenar.</p><<p>Años de Experiencia son los años que el entrenador tiene de experiencia. No puede haber un valor menor que 0.</p></h2>");
			}
		});
		mnNewMenu_1.add(mntmEntrenador);

		JMenuItem mntmMasajista = new JMenuItem("Masajista");
		mntmMasajista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMensaje.setVisible(true);
				panelMensaje
						.setText("<h2 text-align: justify>Añadir un masajista al club. Se añadirán los campos Nombre, Primer apellido, Segundo apellido, Titulación, Categoría y Años de Experiencia.<p>Nombre y Primer apellido no pueden contener números ni quedar vacíos.</p><p>Segundo apellido no puede contener números aunque si puede quedar vacío, ya que hay persoans que no tienen segundo apellido.</p></p><p>Titulación muestra los estudios que tiene el masajista: FISIOTERAPETUA, QUIROMASAJISTA, OSTEÓPATA.</p><p>Categoría es el grupo de edad a los que va a entrenar.</p><p>Años de Experiencia son los años que el masajista tiene de experiencia como profesional. No puede haber un valor menor que 0.</p> </h2>");
			}
		});
		mnNewMenu_1.add(mntmMasajista);

		JMenu mnNewMenu_2 = new JMenu("Mostrar");
		mnNewMenu.add(mnNewMenu_2);

		JMenuItem mntmJugador_1 = new JMenuItem("Jugador");
		mntmJugador_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMensaje.setVisible(true);
				panelMensaje
						.setText("<h2 text-align: justify>Ha de haber al menos un jugador en el Club. Si no hay ninguno, te mostrará un mensaje diciendo que no hay jugadores en la lista.<p>En el desplegable se muestran los nombres y apellidos de los jugadores que existan. Hay que seleccionar el nombre del jugador en el desplegable para que aparezcan sus datos. La categoría y el sueldo son campos calculados. La categoría depende del año de nacimiento del jugador:<ul><li>PREBENJAMIN: 6-7 AÑOS</li><li>BENJAMIN: 8-9 AÑOS</li><li>ALEVIN: 10-11 AÑOS</li><li>INFANTIL: 12-13 AÑOS</li><li>CADETE:14-15 AÑOS</li><li>JUVENIL: 16-17-18 AÑOS</li><li>SENIOR: 19 AÑOS EN ADELANTE</li></ul><p>El sueldo del jugador depende de la demarcación. Por orden de sueldo de menos a más: PORTERO, CIERRE, ALAS, PIVOT</p><p>El botón eliminar elimina el jugador que está seleccionado pidiendo confirmación antes.</h2>");
			}
		});
		mnNewMenu_2.add(mntmJugador_1);

		JMenuItem mntmEntrenador_1 = new JMenuItem("Entrenador");
		mntmEntrenador_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMensaje.setVisible(true);
				panelMensaje
						.setText("<h2 text-align: justify>Ha de haber al menos un entrenador en el Club. Si no hay ninguno, te mostrará un mensaje diciendo que no hay entrenadores en la lista.<p>En el desplegable se muestran los nombres y apellidos de los entrenadores que existan. Hay que seleccionar el nombre del entrenador en el desplegable para que aparezcan sus datos. El sueldo es un campo calculado y depende del nivel y de los años de experiencia. En orden del que más al que menos cobra es: LICENCIADO, NIVEL2, NIVEL1 Y MONITOR. Dentro de cada nivel cobrará más cuanto más años de experiencia tenga en su profesión.<p>El boton eliminar elimina el entrenador que está seleccionado en el desplegable pidiendo confirmación antes.</p></h2>");
			}
		});
		mnNewMenu_2.add(mntmEntrenador_1);

		JMenuItem mntmMasajista_1 = new JMenuItem("Masajista");
		mntmMasajista_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMensaje.setVisible(true);
				panelMensaje
						.setText("<h2 text-align: justify>Ha de haber al menos un masajista en el Club. Si no hay ninguno, te mostrará un mensaje diciendo que no hay masajistas en la lista.<p>En el desplegabe se muestran los nombres y apellidos de los masajistas que existan.El sueldo es un campo calculado y depende de la titulación y de los años de experiencia. En orden del que más al que menos cobra es: FISIOTERAPEUTA, OSTEÓPATA Y QUIROMASAJISTA. Dentro de cada titulación cobrará más cuanto más años de experiencia tenga en su profesión.El boton eliminar elimina el masajista que está seleccionado en el desplegable pidiendo confirmación antes.</h2>");
			}
		});
		mnNewMenu_2.add(mntmMasajista_1);

		JMenu mnBuscar = new JMenu("Buscar");
		mnBuscar.setMnemonic('b');
		menuBar.add(mnBuscar);

		JMenuItem mntmNewMenuItem = new JMenuItem("Por categor\u00EDa");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelMensaje.setVisible(true);
				panelMensaje
						.setText("<h2 text-align: justify>Para que se abra la ventana de búsqueda ha de haber al menos un miembro registrado en el club. Si no hay ninguno, mostrará un mensaje de que no hay miembros en la lista.</h2><p>La búsqueda por categoría se seleccionará en un desplegable que abarca todas las categorías. En la búsqueda aparecerán todos los miembros que existen en esa categoría, tanto JUGADORES, como ENTRENADORES, como MASAJISTAS. En el caso de que no haya un miembro inscrito en una determinada categoría, te avisará de que no existe ningún miembro en la categoría seleccionada.</p><p>Tras elegir una categoría del desplegable y pulsar en ACEPTAR, se abrirá una nueva ventana donde aparecerán en el desplegable superior todos los miembros pertenecientes a la categoría seleccionada. Si seleccionamos el nombre de uno de los miembros, aparecerán todos los datos relevantes de ese miembro, distinguiendo si es JUGADOR, ENTRENADOR O MASAJISTA.</p><p>El botón ORDENAR ordena los miembros del desplegable alfabéticamente según el Primer apellido, en caso de ser iguales, los ordena según el Segundo apellido.</p>");
			}
		});
		mnBuscar.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem(
				"Por a\u00F1o de inscripci\u00F3n");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMensaje.setVisible(true);
				panelMensaje
						.setText("<h2 text-align: justify>Para que se abra la ventana de búsqueda ha de haber al menos un miembro registrado en el club. Si no hay ninguno, mostrará un mensaje de que no hay miembros en la lista.</h2><p>La búsqueda por año de inscripción se hace mediante un desplegable en el que aparecerán los años. El programa está diseñado para llevar un control a partir del año presente de los jugadores inscritos en el club, por tanto en el 2015 solo va a aparecer que se puede buscar por el año 2015. Cuando lleguemos al año 2016, se añadirá el año 2016 al desplegable.</p><p>Tras elegir una categoría del desplegable y pulsar en ACEPTAR, se abrirá una nueva ventana donde aparecerán en el desplegable superior todos los miembros pertenecientes al año de inscripción seleccionada. Si seleccionamos el nombre de uno de los miembros, aparecerán todos los datos relevantes de ese miembro, distinguiendo si es JUGADOR, ENTRENADOR O MASAJISTA.</p><p>El botón ORDENAR ordena los miembros del desplegable alfabéticamente según el Primer apellido, en caso de ser iguales, los ordena según el Segundo apellido.</p>");
			}
		});
		mnBuscar.add(mntmNewMenuItem_1);

		JMenuItem mntmPorFechaDe = new JMenuItem("Por fecha  de alta");
		mntmPorFechaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMensaje.setVisible(true);
				panelMensaje
						.setText("<h2 text-align: justify>Para que se abra la ventana de búsqueda ha de haber al menos un miembro registrado en el club. Si no hay ninguno, mostrará un mensaje de que no hay miembros en la lista.</h2><p>La búsqueda por fecha de Alta se realiza introduciendo una fecha según el formato (dd/MM/yyyy) en el campo de texto.</p><p>Tras elegir una fecha y pulsar en ACEPTAR, si existe algún miembro registrado en esa fecha, se abrirá una nueva ventana donde aparecerán en el desplegable superior todos los miembros pertenecientes a la fecha de alta seleccionada. Si seleccionamos el nombre de uno de los miembros, aparecerán todos los datos relevantes de ese miembro, distinguiendo si es JUGADOR, ENTRENADOR O MASAJISTA. En caso de que no exista ningún jugador inscrito en la fecha buscada, mostrará un mensaje advirtiendo que no existen miembros dados de alta en esa fecha. Si la fecha no sigue el formato mostrado en el cuadro de texto, aparecerá un mensaje de Fecha inválida.</p><p>El botón ORDENAR ordena los miembros del desplegable alfabéticamente según el Primer apellido, en caso de ser iguales, los ordena según el Segundo apellido.</p></p>");
			}
		});
		mnBuscar.add(mntmPorFechaDe);

		JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setMnemonic('h');
		menuBar.add(mnAyuda);

		JMenuItem mntmVerLaAyuda = new JMenuItem("Ver la ayuda");
		mntmVerLaAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMensaje.setVisible(true);
				panelMensaje
						.setText("<h2 text-align: justify>Muestra al usuario un pequeño manual acerca de lo que va a encontrarse en el programa.<ul><li>Alt+a: Despliega el menú Archivo</li><li>Alt+c: Despliega el menú Club</li><li>Alt+b: Despliega el menú Buscar</li><li>Alt+h: Despliega el menú Ayuda</li></ul></h2>");
			}
		});
		mnAyuda.add(mntmVerLaAyuda);

		JMenuItem mntmAcercaDelClub = new JMenuItem("Acerca del club");
		mntmAcercaDelClub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMensaje.setVisible(true);
				panelMensaje
						.setText("<h2 text-align: justify>Muestra una breve reseña del Club y el Alumno que ha llevado a cabo el programa.</h2>");
			}
		});
		mnAyuda.add(mntmAcercaDelClub);
	}
}
