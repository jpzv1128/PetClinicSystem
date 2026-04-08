package model;
/**
 * Clase Mascota
 * Representa una mascota del sistema
 * Contiene la informacion detallada de la mascota.
 * 
 * @autor Jose Pablo Zavala Varela
 * @author Sheilyn Zamora Sandoval
 * @version 1.0
 */
public class Mascota {
	private String idMascota;
	private String nombre;
	private String raza;
	private String especie;
	private int edad;
	private String sexo;
	private Dueno dueno;
	/**
	 * Constructor por defecto
	 */
	public Mascota() {
	}
	/**
	 * Constructor con atributos
	 * @param idMascota Identificador de la mascota
	 * @param nombre Nombre de la mascota
	 * @param raza Raza de la mascota
	 * @param especie Especie de la mascota
	 * @param edad Edad de la mascota
	 * @param sexo Sexo de la mascota
	 * @param dueno Dueno de la mascota
	 */
	public Mascota(String idMascota, String nombre, String raza, String especie, int edad, String sexo, Dueno dueno) {
		this.idMascota = idMascota;
		this.nombre = nombre;
		this.raza = raza;
		this.especie = especie;
		this.edad = edad;
		this.sexo = sexo;
		this.dueno = dueno;
	}
	/**
	 * Obtiene Identificador de la mascota
	 * @return Identificador de la mascota
	 */
	public String getIdMascota() {
		return idMascota;
	}
	/**
	 * Modifica Identificador de la mascota
	 * @param idMascota nuevo Identificador de la mascota
	 */
	public void setIdMascota(String idMascota) {
		this.idMascota = idMascota;
	}
	/**
	 * Obtiene Nombre de la mascota
	 * @return Nombre de la mascota
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Modifica Nombre de la mascota
	 * @param nombre Nuevo Nombre de la mascota
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Obtiene Raza de la mascota
	 * @return Raza de la mascota
	 */
	public String getRaza() {
		return raza;
	}
	/**
	 * Modifica Raza de la mascota
	 * @param raza Nueva Raza de la mascota
	 */
	public void setRaza(String raza) {
		this.raza = raza;
	}
	/**
	 * Obtiene Especie de la mascota
	 * @return Especie de la mascota
	 */
	public String getEspecie() {
		return especie;
	}
	/**
	 * Modifica Especie de la mascota
	 * @param especie Nueva Especie de la mascota
	 */
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	/**
	 * Obtiene Edad de la mascota
	 * @return Edad de la mascota
	 */
	public int getEdad() {
		return edad;
	}
	/**
	 * Modifica Edad de la mascota
	 * @param edad Nueva Edad de la mascota
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}
	/**
	 * Obtiene Sexo de la mascota
	 * @return Sexo de la mascota
	 */
	public String getSexo() {
		return sexo;
	}
	/**
	 * Modifica Sexo de la mascota
	 * @param sexo Nueva Sexo de la mascota
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	/**
	 * Obtiene Dueno de la mascota
	 * @return Dueno de la mascota
	 */
	public Dueno getDueno() {
		return dueno;
	}
	/**
	 * modifica Dueno de la mascota
	 * @param dueno Nuevo Dueno de la mascota
	 */
	public void setDueno(Dueno dueno) {
		this.dueno = dueno;
	}
	/**
	 * Devuelve lso datos de la mascota en formato texto
	 */
	@Override
	public String toString() {
		return "ID mascota: " + idMascota + "\nNombre: " + nombre + "\nRaza: " + raza + "\nEspecie: " + especie + "\nEdad: " + edad + "\nSexo: " + sexo + "\nDueño: " + dueno.getNombre();
	}

}
