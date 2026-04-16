package service;

import java.awt.EventQueue;

import model.Clinica;
import view.InicioSesion;

/**
 * Clase Main.
 * 
 * Esta clase inicia la ejecucion del sistema PetClinicSystem.
 * 
 * @author Jose Pablo Zavala Varela
 * @author Sheilyn Zamora Sandoval
 * @version 1.0
 */
public class Main {

	/**
	 * Metodo principal del sistema.
	 * 
	 * @param args Parametro por defecto de Java
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clinica clinica = new Clinica("PetClinicSystem", "Centro", "8888-8888",
							"petclinic@gmail.com", "8:00am - 6:00pm");

					InicioSesion inicio = new InicioSesion(clinica);
					inicio.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}