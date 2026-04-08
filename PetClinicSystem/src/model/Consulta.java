package model;
/**
 * Clase Consulta.
 * 
 * Esta clase representa una consulta veterinaria dentro del sistema.
 * Una consulta pertenece a una mascota, a un veterinario y a una clinica.
 * 
 * @author Jose Pablo Zavala Varela
 * @author Sheilyn Zamora Sandoval
 * @version 1.0
 */
public class Consulta {
	private Mascota mascota;
	private Veterinario veterinario;
	private Clinica clinica;
	private String idConsulta;
	private String fecha;
	private String motivo;
	private String diagnostico;
	/**
	 * contructor por defecto
	 */
	public Consulta() {
	}
	/**
	 * Constructor con parametros.
	 * 
	 * @param idConsulta Identificador de la consulta
	 * @param fecha Fecha de la consulta
	 * @param motivo Motivo de la consulta
	 * @param diagnostico Diagnostico de la consulta
	 * @param mascota Mascota atendida en la consulta
	 * @param veterinario Veterinario encargado de la consulta
	 * @param clinica Clinica a la que pertenece la consulta
	 */
	public Consulta(Mascota mascota, Veterinario veterinario, Clinica clinica, String idConsulta, String fecha, String motivo, String diagnostico) {
		this.mascota = mascota;
		this.veterinario = veterinario;
		this.clinica = clinica;
		this.idConsulta = idConsulta;
		this.fecha = fecha;
		this.motivo = motivo;
		this.diagnostico = diagnostico;
	}
	/**
	 * Obtiene Mascota atendida en la consulta
	 * @return Mascota atendida en la consulta
	 */
	public Mascota getMascota() {
		return mascota;
	}
	/**
	 * Modifica Mascota atendida en la consulta
	 * @param mascota nueva Mascota atendida en la consulta
	 */
	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}
	/**
	 * Obtiene veterinario encargado de la consulta
	 * @return Veterinario encargado de la consulta
	 */
	public Veterinario getVeterinario() {
		return veterinario;
	}
	/**
	 * Modifica veterinario encargado de la consulta
	 * @param veterinario Nuevo veterinario encargado de la consulta
	 */
	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}
	/**
	 * Obtiene Clinica a la que pertenece la consulta
	 * @return Clinica a la que pertenece la consulta
	 */
	public Clinica getClinica() {
		return clinica;
	}
	/**
	 * Modifica Clinica a la que pertenece la consulta
	 * @param clinica Nueva Clinica a la que pertenece la consulta
	 */
	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}
	/**
	 * Obtiene Identificador de la consulta
	 * @return Identificador de la consulta
	 */
	public String getIdConsulta() {
		return idConsulta;
	}
	/**
	 * Modifica Identificador de la consulta
	 * @param idConsulta Nuevo Identificador de la consulta
	 */
	public void setIdConsulta(String idConsulta) {
		this.idConsulta = idConsulta;
	}
	/**
	 * Obtiene Fecha de la consulta
	 * @return Fecha de la consulta
	 */
	public String getFecha() {
		return fecha;
	}
	/**
	 * Modifica Fecha de la consulta
	 * @param fecha nueva Fecha de la consulta
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	/**
	 * Obtiene Motivo de la consulta
	 * @return Motivo de la consulta
	 */
	public String getMotivo(){
		return motivo;
	}
	/**
	 * Modifica Motivo de la consulta
	 * @param motivo nuevo Motivo de la consulta
	 */
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	/**
	 * Obtiene Diagnostico de la consulta
	 * @return Diagnostico de la consulta
	 */
	public String getDiagnostico() {
		return diagnostico;
	}
	/**
	 * Modifica Diagnostico de la consulta
	 * @param diagnostico Nuevo Diagnostico de la consulta
	 */
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	/**
	 * Devuelve los datos de la consulta en formato texto.
	 * 
	 * @return Datos de la consulta
	 */
	@Override
	public String toString() {
		return "Mascota: " + mascota.getNombre() + "\nVeterinario: " + veterinario.getNombre() + "\nClinica: " + clinica + "\nID consulta: " + idConsulta + "\nFecha: " + fecha + "\nMotivo: " + motivo + "\nDiagnostico: " + diagnostico; 
	}

}
