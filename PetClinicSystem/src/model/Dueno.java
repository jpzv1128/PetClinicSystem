package model;
/**
 * Clase Dueno
 * Esta clase representa el dueño de la mascota.
 * contiene informacion basica del propietario.
 * 
 * @autor Jose Pablo Zavala Varela
 * @author Sheilyn Zamora Sandoval
 * @version 1.0
 */
public class Dueno {
	private String identificacion;
	private String nombre;
	private int telefono;
	private String correo;
	private String direccion;
	
	/**
	 * Contructor por defecto
	 */
	public Dueno() {
	}
	/**
	 * Constructor con parametros
	 * @param identificacion del dueño.
	 * @param nombre del dueño.
	 * @param telefono del dueño.
	 * @param correo del dueño.
	 * @param direccion del dueño.
	 */
	public Dueno(String identificacion, String nombre, int telefono, String correo, String direccion) {
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
		this.direccion = direccion;
	}
	/**
	 * Obtiene la identificacion del dueno.
	 * @return la identificacion del dueno.
	 */
	public String getIdentificacion() {
		return identificacion;
	}
	/**
	 * Modifica la identificacion del dueno.
	 * @param identificacion Nueva identificacion del dueno
	 */
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	/**
	 * Obtiene el nombre del dueno.
	 * @return El nombre del dueno.
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Modifica el nombre del dueno.
	 * @param nombre Nuevo nombre del dueno
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Obtiene el nombre del dueno.
	 * @return El nombre del dueno.
	 */
	public int getTelefono() {
		return telefono;
	}
	/**
	 * Modifica el telefono del dueno.
	 * @param telefono Nuevo telefono del dueno.
	 */
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	/**
	 * Obtiene el correo del dueno.
	 * @return El nombre del dueno.
	 */
	public String getCorreo() {
		return correo;
	}
	/**
	 * Modifica el correo del dueno.
	 * @param correo Nuevo correo del dueno.
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	/**
	 * Obtiene la direccion del dueno.
	 * @return La direccion del dueno.
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * Modifica la direccion del dueno.
	 * @param direccion Nueva direccion del dueno.
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@Override
	public String toString() {
		return "Identificacion: " + identificacion + "\nNombre: " + nombre + "\nTelefono: " + telefono + "\nCorreo: " + correo + "\nDireccion: " + direccion;
	}
}
