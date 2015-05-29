package proyectoFinal;

import java.util.ArrayList;

public class testProyecto {

	public static void main(String[] args) {
		Club club= new Club();
		
		try {
			club.annadir(new Jugador("Raul", "Moreno", "Povedano", "1985", null, "2000", 1000, 10, DemarcacionJugador.PORTERO, 0));
		} catch (MiembroYaExisteException | NombreInvalidoException
				| ApellidoInvalidoException | AñoNacimientoInvalidoException
				| ValorNegativoException e) {
			System.out.println(e.getMessage());
		}System.out.println(club.size());
		try {
			club.annadir(new Entrenador("Juan", "Moreno", "Torreras", "1960", null, "2000", NivelEntrenador.LICENCIADO, 10, true));
			club.eliminar(1);
			club.eliminar(2);

		} catch (MiembroYaExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NombreInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ApellidoInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AñoNacimientoInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ValorNegativoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(club.size());
	}

}
