package model;
/**
 * Clase veterinario
 * Representa a un veterinario de la clinica
 * Contiene la informacion del veterinario que atiende la consulta
 * 
 * @autor Jose Pablo Zavala Varela
 * @author Sheilyn Zamora Sandoval
 * @version 1.0
 */
public class Veterinario {
	private String idVeterinario;
	private String nombre;
	private String especialidad;
	private int telefono;
	private String horario;
	/**
	 * Constructor por defecto
	 */
	public Veterinario() {
	}
	/**
	 * Constructor con atributos
	 * @param idVeterinario Identificador del veterinario
	 * @param nombre Nombre del veterinario
	 * @param especialidad Especialidad del veterinario
	 * @param telefono Telefono del veterinario
	 * @param horario Horario del veterinario
	 */
	public Veterinario(String idVeterinario, String nombre, String especialidad, int telefono, String horario) {
		this.idVeterinario = idVeterinario;
		this.nombre = nombre;
		this.especialidad = especialidad;
		this.telefono = telefono;
		this.horario = horario;
	}
	/**
	 * Obtiene el Identificador del veterinario
	 * @return Identificador del veterinario
	 */
	public String getIdVeterinario() {
		return idVeterinario;
	}
	/**
	 * Modifica el Identificador del veterinario
	 * @param idVeterinario Nuevo Identificador del veterinario
	 */
	public void setIdVeterinario(String idVeterinario) {
		this.idVeterinario = idVeterinario;
	}
	/**
	 * Obtiene Nombre del veterinario
	 * @return Nombre del veterinario
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Modifica Nombre del veterinario
	 * @param nombre nuevo Nombre del veterinario
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Obtiene Especialidad del veterinario
	 * @return Especialidad del veterinario
	 */
	public String getEspecialidad() {
		return especialidad;
	}
	/**
	 * Modifica Especialidad del veterinario
	 * @param especialidad Nueva Especialidad del veterinario
	 */
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	/**
	 * Obtiene Telefono del veterinario
	 * @return Telefono del veterinario
	 */
	public int getTelefono() {
		return telefono;
	}
	/**
	 * Modifica Telefono del veterinario
	 * @param telefono nuevo Telefono del veterinario
	 */
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	/**
	 * Obtiene Horario del veterinario
	 * @return Horario del veterinario
	 */
	public String getHorario() {
		return horario;
	}
	/**
	 * Modifica Horario del veterinario
	 * @param horario Nuevo Horario del veterinario
	 */
	public void setHorario(String horario) {
		this.horario = horario;
	}	
	/**
	 * Devuelve los datos del veterinario en formato texto
	 * @return Datos del veterinario
	 */
	@Override
	public String toString() {
		return "ID veterinario: " + idVeterinario + "\nNombre: " + nombre + "\nEspecialidad: " + especialidad + "\nTelefono: " + telefono + "\nHorario: " + horario;
	}
}
