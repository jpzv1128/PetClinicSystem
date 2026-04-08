package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Clinica.
 * 
 * Esta clase representa una clinica veterinaria dentro del sistema.
 * Ademas, funciona como la clase gestora, ya que administra la
 * informacion de duenos, mascotas, veterinarios y consultas.
 * 
 * @author Jose Pablo Zavala Varela
 * @author Sheilyn Zamora Sandoval
 * @version 1.0
 */
public class Clinica {
	private String nombre;
	private String direccion;
	private int telefono;
	private String correo;
	private String horarioAtencion;
	private List <Mascota> mascotas;
	private List<Dueno> duenos;
	private List<Consulta> consultas;
	private List<Veterinario> veterinarios;
	
	
	
	/**
	 * Contructor por defecto
	 */
	
	public Clinica() {
		mascotas = new ArrayList<Mascota>();
		duenos = new ArrayList<Dueno>();
		consultas =  new ArrayList<Consulta>();
		veterinarios = new ArrayList<Veterinario>();
		
	}
	/**
	 * Constructor con parametros.
	 * 
	 * @param name Nombre de la clinica
	 * @param direccion Direccion de la clinica
	 * @param telefono Telefono de la clinica
	 * @param correo Correo de la clinica
	 * @param horarioAtencion Horario de atencion de la clinica
	 */
	public Clinica(String nombre, String direccion, int telefono, String correo, String horarioAtencion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
		this.horarioAtencion = horarioAtencion;
		mascotas = new ArrayList<Mascota>();
		duenos = new ArrayList<Dueno>();
		consultas =  new ArrayList<Consulta>();
		veterinarios = new ArrayList<Veterinario>();
	}
	
	/**
	 * Obtiene el nombre de la clinica.
	 * 
	 * @return Nombre de la clinica
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Modifica el nombre de la clinica.
	 * 
	 * @param nombre Nuevo nombre de la clinica
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la direccion de la clinica.
	 * 
	 * @return Direccion de la clinica
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Modifica la direccion de la clinica.
	 * 
	 * @param direccion Nueva direccion de la clinica
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Obtiene el telefono de la clinica.
	 * 
	 * @return Telefono de la clinica
	 */
	public int getTelefono() {
		return telefono;
	}

	/**
	 * Modifica el telefono de la clinica.
	 * 
	 * @param telefono Nuevo telefono de la clinica
	 */
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	/**
	 * Obtiene el correo de la clinica.
	 * 
	 * @return Correo de la clinica
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * Modifica el correo de la clinica.
	 * 
	 * @param correo Nuevo correo de la clinica
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * Obtiene el horario de atencion de la clinica.
	 * 
	 * @return Horario de atencion de la clinica
	 */
	public String getHorarioAtencion() {
		return horarioAtencion;
	}

	/**
	 * Modifica el horario de atencion de la clinica.
	 * 
	 * @param horarioAtencion Nuevo horario de atencion de la clinica
	 */
	public void setHorarioAtencion(String horarioAtencion) {
		this.horarioAtencion = horarioAtencion;
	}
	/**
	 * Obtiene la lista de mascotas de la clinica.
	 * @return Lista de mascotas de la clinica.
	 */
	public List<Mascota> getMascotas(){
		return mascotas;
	}
	/**
	 * Modifica la lista de mascotas de la clinica.
	 * @param mascotas Nueva lista de mascotas de la clinica.
	 */
	public void setMascotas(List<Mascota> mascotas) {
		this.mascotas = mascotas;
	}
	/**
	 * Obtiene los duenos
	 * @return Duenos de las mascotas
	 */
	public List<Dueno> getDuenos(){
		return duenos;
	}
	/**
	 * Modifica Duenos de las mascotas
	 * @param duenos Nuevos Duenos de las mascotas
	 */
	public void setDuenos(List<Dueno>duenos) {
		this.duenos = duenos;
	}
	/**
	 * Obtiene la lista de consultas
	 * @return La lista de consultas
	 */
	public List<Consulta> getConsultas(){
		return consultas;
	}
	/**
	 * Modifica la lista de consultas
	 * @param consultas nueva lista de consultas
	 */
	public void setConsultas(List<Consulta>consultas) {
		this.consultas = consultas;
	}
	/**
	 * Obtiene la lista de veterinarios
	 * @return Lista de veterinarios
	 */
	public List<Veterinario> getVeterinarios(){
		return veterinarios;
	}
	/**
	 * Modifica la lista de veterinarios
	 * @param veterinarios nueva lista de veterinarios
	 */
	public void setVeterinarios(List<Veterinario>veterinarios) {
		this.veterinarios = veterinarios;
	}
	/**
	 * Agrega una mascota a la lista de mascotas.
	 * 
	 * @param mascota Mascota a agregar
	 */
	public void agregarMascota(Mascota mascota) {
		mascotas.add(mascota);
	}
	/**
	 * Agrega un dueno a la lista de duenos.
	 * 
	 * @param dueno Dueno a agregar
	 */
	public void agregarDueno(Dueno dueno) {
		duenos.add(dueno);
	}
	/**
	 * Agrega una consulta a la lista de consultas.
	 * 
	 * @param consulta Consulta a agregar
	 */
	public void agregarConsultas(Consulta consulta) {
		consultas.add(consulta);
	}
	/**
	 * Agrega un veterinario a la lista de veterinarios.
	 * 
	 * @param veterinario Veterinario a agregar
	 */
	public void agregarVeterinario(Veterinario veterinario) {
		veterinarios.add(veterinario);
	}
	
	@Override
	public String toString() {
		return  "Nombre: " + nombre + "\nDireccion: " + direccion + "\nTelefono: "
				+ telefono + "\nCorreo: " + correo + "\nHorario de atencion: " + horarioAtencion;
	}

}
