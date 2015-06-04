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
						.setText("<h2 text-align: justify>Crea un archivo nuevo vac�o. Si el archivo ha sido modificado y se vuelve a pulsar en <strong>Nuevo</strong> preguntar� si se desea guardar el archivo anterior.</h2>");
			}
		});
		mnArchivo.add(mntmNuevo);

		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMensaje.setVisible(true);
				panelMensaje
						.setText("<h2 text-align: justify>Abrir un fichero existente. Si estamos trabajando con un archivo y no lo hemos guardado, si pulsamos en <strong>Abrir</strong> preguntar� si se desea guardar el archivo. En caso de que el archivo no pueda abrirse porque est� corrupto o no pueda abrirse, lanzar� un mensaje de error.</h2>");
			}
		});
		mnArchivo.add(mntmAbrir);

		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelMensaje.setVisible(true);
				panelMensaje
						.setText("<h2 text-align: justify>Guardar un archivo. Si al guardar el archivo existe un archivo con el mismo nombre, preguntar� si deseamos sobreescribirlo.</h2>");
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
						.setText("<h2 text-align: justify>Salir del programa. Si el archivo en uso ha sido modificado, te pedir� si deseas guardar los cambios antes de salir.</h2>");
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
						.setText("<h2 text-align: justify>A�adir un jugador al club. Se a�adir�n los campos Nombre, Primer apellido, Segundo apellido, A�o Nacimiento, Demarcaci�n, Partidos Jugados, Dorsal y Goles marcados.<p>Nombre y Primer apellido no pueden contener n�meros ni quedar vac�os.</p><p>Segundo apellido no puede contener n�meros aunque si puede quedar vac�o ya que hay personas que no tienen segundo apellido.</p><p>A�o Nacimiento ser� una fecha comprendida entre 1900 y 2009, ambos inclusive, con el siguiente formato (YYYY). Si introduces un a�o de nacimiento en el que el ni�o tenga menos de 6 a�os, habr� un mensaje de error diciendo que el ni�o es demasiado peque�o, ya que la edad m�nima para que un jugador pueda pertenecer al club es de 6 a�os, por tanto no puede haber un ni�o en el club m�s peque�o de esa edad. Si el error viene dado por meter un formato err�neo te avisar� de error de formato.</p><p>Demarcaci�n muestra las 5 posiciones de campo que existen en el f�tbol sala: PORTERO, CIERRE, ALA DERECHA, ALA IZQUIERDA Y PIVOT.</p><p>Partidos Jugados que el jugador haya disputado en su vida. No puede haber un valor menor que 0.</p><p>Dorsal es el n�mero favorito del jugador. En f�tbol sala solo existen dorsales entre 1 y 99.</p><p>Goles marcados son los goles que el jugador haya anotado en su trayecto, siendo 0 el valor m�nimo.</p></h2>");
			}
		});
		mnNewMenu_1.add(mntmJugador);

		JMenuItem mntmEntrenador = new JMenuItem("Entrenador");
		mntmEntrenador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMensaje.setVisible(true);
				panelMensaje
						.setText("<h2 text-align: justify>A�adir un entrenador al club. Se a�adir�n los campos Nombre, Primer apellido, Segundo apellido, Nivel, Categor�a y A�os de Experiencia.<p>Nombre y Primer apellido no pueden contener n�meros ni quedar vac�os.</p><p>Segundo apellido no puede contener n�meros aunque si puede quedar vac�o, ya que hay personas que no tienen segundo apellido.</p></p><p>Nivel muestra los niveles que un entrenador ha de tener para poder entrenar en el club. Por orden de importancia de mayor a menor son: LICENCIADO, NIVEL2, NIVEL1, MONITOR.</p></<p>Categor�a es el grupo de edad a los que va a entrenar.</p><<p>A�os de Experiencia son los a�os que el entrenador tiene de experiencia. No puede haber un valor menor que 0.</p></h2>");
			}
		});
		mnNewMenu_1.add(mntmEntrenador);

		JMenuItem mntmMasajista = new JMenuItem("Masajista");
		mntmMasajista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMensaje.setVisible(true);
				panelMensaje
						.setText("<h2 text-align: justify>A�adir un masajista al club. Se a�adir�n los campos Nombre, Primer apellido, Segundo apellido, Titulaci�n, Categor�a y A�os de Experiencia.<p>Nombre y Primer apellido no pueden contener n�meros ni quedar vac�os.</p><p>Segundo apellido no puede contener n�meros aunque si puede quedar vac�o, ya que hay persoans que no tienen segundo apellido.</p></p><p>Titulaci�n muestra los estudios que tiene el masajista: FISIOTERAPETUA, QUIROMASAJISTA, OSTE�PATA.</p><p>Categor�a es el grupo de edad a los que va a entrenar.</p><p>A�os de Experiencia son los a�os que el masajista tiene de experiencia como profesional. No puede haber un valor menor que 0.</p> </h2>");
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
						.setText("<h2 text-align: justify>Ha de haber al menos un jugador en el Club. Si no hay ninguno, te mostrar� un mensaje diciendo que no hay jugadores en la lista.<p>En el desplegable se muestran los nombres y apellidos de los jugadores que existan. Hay que seleccionar el nombre del jugador en el desplegable para que aparezcan sus datos. La categor�a y el sueldo son campos calculados. La categor�a depende del a�o de nacimiento del jugador:<ul><li>PREBENJAMIN: 6-7 A�OS</li><li>BENJAMIN: 8-9 A�OS</li><li>ALEVIN: 10-11 A�OS</li><li>INFANTIL: 12-13 A�OS</li><li>CADETE:14-15 A�OS</li><li>JUVENIL: 16-17-18 A�OS</li><li>SENIOR: 19 A�OS EN ADELANTE</li></ul><p>El sueldo del jugador depende de la demarcaci�n. Por orden de sueldo de menos a m�s: PORTERO, CIERRE, ALAS, PIVOT</p><p>El bot�n eliminar elimina el jugador que est� seleccionado pidiendo confirmaci�n antes.</h2>");
			}
		});
		mnNewMenu_2.add(mntmJugador_1);

		JMenuItem mntmEntrenador_1 = new JMenuItem("Entrenador");
		mntmEntrenador_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMensaje.setVisible(true);
				panelMensaje
						.setText("<h2 text-align: justify>Ha de haber al menos un entrenador en el Club. Si no hay ninguno, te mostrar� un mensaje diciendo que no hay entrenadores en la lista.<p>En el desplegable se muestran los nombres y apellidos de los entrenadores que existan. Hay que seleccionar el nombre del entrenador en el desplegable para que aparezcan sus datos. El sueldo es un campo calculado y depende del nivel y de los a�os de experiencia. En orden del que m�s al que menos cobra es: LICENCIADO, NIVEL2, NIVEL1 Y MONITOR. Dentro de cada nivel cobrar� m�s cuanto m�s a�os de experiencia tenga en su profesi�n.<p>El boton eliminar elimina el entrenador que est� seleccionado en el desplegable pidiendo confirmaci�n antes.</p></h2>");
			}
		});
		mnNewMenu_2.add(mntmEntrenador_1);

		JMenuItem mntmMasajista_1 = new JMenuItem("Masajista");
		mntmMasajista_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMensaje.setVisible(true);
				panelMensaje
						.setText("<h2 text-align: justify>Ha de haber al menos un masajista en el Club. Si no hay ninguno, te mostrar� un mensaje diciendo que no hay masajistas en la lista.<p>En el desplegabe se muestran los nombres y apellidos de los masajistas que existan.El sueldo es un campo calculado y depende de la titulaci�n y de los a�os de experiencia. En orden del que m�s al que menos cobra es: FISIOTERAPEUTA, OSTE�PATA Y QUIROMASAJISTA. Dentro de cada titulaci�n cobrar� m�s cuanto m�s a�os de experiencia tenga en su profesi�n.El boton eliminar elimina el masajista que est� seleccionado en el desplegable pidiendo confirmaci�n antes.</h2>");
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
						.setText("<h2 text-align: justify>Para que se abra la ventana de b�squeda ha de haber al menos un miembro registrado en el club. Si no hay ninguno, mostrar� un mensaje de que no hay miembros en la lista.</h2><p>La b�squeda por categor�a se seleccionar� en un desplegable que abarca todas las categor�as. En la b�squeda aparecer�n todos los miembros que existen en esa categor�a, tanto JUGADORES, como ENTRENADORES, como MASAJISTAS. En el caso de que no haya un miembro inscrito en una determinada categor�a, te avisar� de que no existe ning�n miembro en la categor�a seleccionada.</p><p>Tras elegir una categor�a del desplegable y pulsar en ACEPTAR, se abrir� una nueva ventana donde aparecer�n en el desplegable superior todos los miembros pertenecientes a la categor�a seleccionada. Si seleccionamos el nombre de uno de los miembros, aparecer�n todos los datos relevantes de ese miembro, distinguiendo si es JUGADOR, ENTRENADOR O MASAJISTA.</p><p>El bot�n ORDENAR ordena los miembros del desplegable alfab�ticamente seg�n el Primer apellido, en caso de ser iguales, los ordena seg�n el Segundo apellido.</p>");
			}
		});
		mnBuscar.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem(
				"Por a\u00F1o de inscripci\u00F3n");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMensaje.setVisible(true);
				panelMensaje
						.setText("<h2 text-align: justify>Para que se abra la ventana de b�squeda ha de haber al menos un miembro registrado en el club. Si no hay ninguno, mostrar� un mensaje de que no hay miembros en la lista.</h2><p>La b�squeda por a�o de inscripci�n se hace mediante un desplegable en el que aparecer�n los a�os. El programa est� dise�ado para llevar un control a partir del a�o presente de los jugadores inscritos en el club, por tanto en el 2015 solo va a aparecer que se puede buscar por el a�o 2015. Cuando lleguemos al a�o 2016, se a�adir� el a�o 2016 al desplegable.</p><p>Tras elegir una categor�a del desplegable y pulsar en ACEPTAR, se abrir� una nueva ventana donde aparecer�n en el desplegable superior todos los miembros pertenecientes al a�o de inscripci�n seleccionada. Si seleccionamos el nombre de uno de los miembros, aparecer�n todos los datos relevantes de ese miembro, distinguiendo si es JUGADOR, ENTRENADOR O MASAJISTA.</p><p>El bot�n ORDENAR ordena los miembros del desplegable alfab�ticamente seg�n el Primer apellido, en caso de ser iguales, los ordena seg�n el Segundo apellido.</p>");
			}
		});
		mnBuscar.add(mntmNewMenuItem_1);

		JMenuItem mntmPorFechaDe = new JMenuItem("Por fecha  de alta");
		mntmPorFechaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMensaje.setVisible(true);
				panelMensaje
						.setText("<h2 text-align: justify>Para que se abra la ventana de b�squeda ha de haber al menos un miembro registrado en el club. Si no hay ninguno, mostrar� un mensaje de que no hay miembros en la lista.</h2><p>La b�squeda por fecha de Alta se realiza introduciendo una fecha seg�n el formato (dd/MM/yyyy) en el campo de texto.</p><p>Tras elegir una fecha y pulsar en ACEPTAR, si existe alg�n miembro registrado en esa fecha, se abrir� una nueva ventana donde aparecer�n en el desplegable superior todos los miembros pertenecientes a la fecha de alta seleccionada. Si seleccionamos el nombre de uno de los miembros, aparecer�n todos los datos relevantes de ese miembro, distinguiendo si es JUGADOR, ENTRENADOR O MASAJISTA. En caso de que no exista ning�n jugador inscrito en la fecha buscada, mostrar� un mensaje advirtiendo que no existen miembros dados de alta en esa fecha. Si la fecha no sigue el formato mostrado en el cuadro de texto, aparecer� un mensaje de Fecha inv�lida.</p><p>El bot�n ORDENAR ordena los miembros del desplegable alfab�ticamente seg�n el Primer apellido, en caso de ser iguales, los ordena seg�n el Segundo apellido.</p></p>");
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
						.setText("<h2 text-align: justify>Muestra al usuario un peque�o manual acerca de lo que va a encontrarse en el programa.<ul><li>Alt+a: Despliega el men� Archivo</li><li>Alt+c: Despliega el men� Club</li><li>Alt+b: Despliega el men� Buscar</li><li>Alt+h: Despliega el men� Ayuda</li></ul></h2>");
			}
		});
		mnAyuda.add(mntmVerLaAyuda);

		JMenuItem mntmAcercaDelClub = new JMenuItem("Acerca del club");
		mntmAcercaDelClub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMensaje.setVisible(true);
				panelMensaje
						.setText("<h2 text-align: justify>Muestra una breve rese�a del Club y el Alumno que ha llevado a cabo el programa.</h2>");
			}
		});
		mnAyuda.add(mntmAcercaDelClub);
	}
}
