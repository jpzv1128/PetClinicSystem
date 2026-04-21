package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Clinica;
import model.Dueno;
import model.Mascota;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clase MascotaFrame.
 * 
 * Esta clase representa la ventana para registrar, mostrar y eliminar
 * mascotas del sistema.
 * 
 * @author Jose Pablo Zavala Varela
 * @author Sheilyn Zamora Sandoval
 * @version 1.0
 */
public class MascotaFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfIdMascota;
	private JTextField tfNombre;
	private JTextField tfEspecie;
	private JTextField tfRaza;
	private JTextField tfEdad;
	private JTextField tfSexo;
	private JTextField tfIdentificacionDueno;
	private JTextArea taInformacion;
	private Clinica clinica;

	/**
	 * Constructor de la ventana de mascotas.
	 * 
	 * @param clinica Clinica principal del sistema
	 */
	public MascotaFrame(Clinica clinica) {
		this.clinica = clinica;

		setTitle("PetClinicSystem - Mascotas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 570);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 250, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("Modulo de Mascotas");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
		lblTitulo.setForeground(new Color(0, 102, 153));
		lblTitulo.setBounds(230, 15, 240, 30);
		contentPane.add(lblTitulo);

		JLabel lblIdMascota = new JLabel("ID Mascota:");
		lblIdMascota.setFont(new Font("Arial", Font.BOLD, 13));
		lblIdMascota.setBounds(40, 70, 120, 20);
		contentPane.add(lblIdMascota);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Arial", Font.BOLD, 13));
		lblNombre.setBounds(40, 105, 120, 20);
		contentPane.add(lblNombre);

		JLabel lblEspecie = new JLabel("Especie:");
		lblEspecie.setFont(new Font("Arial", Font.BOLD, 13));
		lblEspecie.setBounds(40, 140, 120, 20);
		contentPane.add(lblEspecie);

		JLabel lblRaza = new JLabel("Raza:");
		lblRaza.setFont(new Font("Arial", Font.BOLD, 13));
		lblRaza.setBounds(40, 175, 120, 20);
		contentPane.add(lblRaza);

		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setFont(new Font("Arial", Font.BOLD, 13));
		lblEdad.setBounds(40, 210, 120, 20);
		contentPane.add(lblEdad);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Arial", Font.BOLD, 13));
		lblSexo.setBounds(40, 245, 120, 20);
		contentPane.add(lblSexo);

		JLabel lblIdDueno = new JLabel("ID Dueno:");
		lblIdDueno.setFont(new Font("Arial", Font.BOLD, 13));
		lblIdDueno.setBounds(40, 280, 120, 20);
		contentPane.add(lblIdDueno);

		tfIdMascota = new JTextField();
		tfIdMascota.setBounds(170, 70, 180, 22);
		contentPane.add(tfIdMascota);
		tfIdMascota.setColumns(10);

		tfNombre = new JTextField();
		tfNombre.setBounds(170, 105, 180, 22);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);

		tfEspecie = new JTextField();
		tfEspecie.setBounds(170, 140, 180, 22);
		contentPane.add(tfEspecie);
		tfEspecie.setColumns(10);

		tfRaza = new JTextField();
		tfRaza.setBounds(170, 175, 180, 22);
		contentPane.add(tfRaza);
		tfRaza.setColumns(10);

		tfEdad = new JTextField();
		tfEdad.setBounds(170, 210, 180, 22);
		contentPane.add(tfEdad);
		tfEdad.setColumns(10);

		tfSexo = new JTextField();
		tfSexo.setBounds(170, 245, 180, 22);
		contentPane.add(tfSexo);
		tfSexo.setColumns(10);

		tfIdentificacionDueno = new JTextField();
		tfIdentificacionDueno.setBounds(170, 280, 180, 22);
		contentPane.add(tfIdentificacionDueno);
		tfIdentificacionDueno.setColumns(10);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(new Color(0, 153, 76));
		btnGuardar.setForeground(Color.BLACK);
		btnGuardar.setFont(new Font("Arial", Font.BOLD, 13));
		btnGuardar.setBounds(430, 80, 140, 30);
		contentPane.add(btnGuardar);

		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.setBackground(new Color(0, 102, 204));
		btnMostrar.setForeground(Color.BLACK);
		btnMostrar.setFont(new Font("Arial", Font.BOLD, 13));
		btnMostrar.setBounds(430, 125, 140, 30);
		contentPane.add(btnMostrar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(new Color(255, 153, 0));
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 13));
		btnEliminar.setBounds(430, 170, 140, 30);
		contentPane.add(btnEliminar);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBackground(new Color(204, 51, 51));
		btnVolver.setForeground(Color.BLACK);
		btnVolver.setFont(new Font("Arial", Font.BOLD, 13));
		btnVolver.setBounds(430, 215, 140, 30);
		contentPane.add(btnVolver);
		

		taInformacion = new JTextArea();
		taInformacion.setBounds(40, 340, 622, 196);
		contentPane.add(taInformacion);
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesión");
		btnCerrarSesion.setFont(new Font("Arial", Font.BOLD, 13));
		btnCerrarSesion.setBounds(430, 260, 140, 30); 
		btnCerrarSesion.setBackground(new Color(102, 0, 0));
		btnCerrarSesion.setForeground(new Color(0, 0, 0));

		btnCerrarSesion.addActionListener(e -> {
			new InicioSesion(clinica).setVisible(true);
			dispose();
		});

		contentPane.add(btnCerrarSesion);
		

		/**
		 * Boton para guardar una mascota.
		 */
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarMascota();
			}
		});

		/**
		 * Boton para mostrar las mascotas guardadas.
		 */
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarMascotas();
			}
		});

		/**
		 * Boton para eliminar una mascota.
		 */
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarMascota();
			}
		});

		/**
		 * Boton para volver al menu principal.
		 */
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal menu = new MenuPrincipal(clinica);
				menu.setVisible(true);
				setVisible(false);
			}
		});
	}

	/**
	 * Guarda una mascota asociada a un dueno en archivo y en memoria.
	 */
	public void guardarMascota() {
		try {
			String idMascota = tfIdMascota.getText().trim();
			String nombre = tfNombre.getText().trim();
			String especie = tfEspecie.getText().trim();
			String raza = tfRaza.getText().trim();
			String edadTexto = tfEdad.getText().trim();
			String sexo = tfSexo.getText().trim();
			String identificacionDueno = tfIdentificacionDueno.getText().trim();

			if (idMascota.equals("") || nombre.equals("") || especie.equals("") || raza.equals("") || edadTexto.equals("")
					|| sexo.equals("") || identificacionDueno.equals("")) {
				JOptionPane.showMessageDialog(this, "Debe completar todos los campos.");
				return;
			}

			int edad = Integer.parseInt(edadTexto);

			Dueno duenoMascota = buscarDuenoEnArchivo(identificacionDueno);

			if (duenoMascota == null) {
				JOptionPane.showMessageDialog(this, "El dueno no existe en el sistema.");
				return;
			}

			Mascota mascota = new Mascota(idMascota, nombre, especie, raza, edad, sexo, duenoMascota);
			clinica.agregarMascota(mascota);

			File archivo = new File("mascotas.txt");

			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true));
			bw.write(idMascota + "|" + nombre + "|" + especie + "|" + raza + "|" + edad + "|" + sexo + "|"
					+ identificacionDueno);
			bw.newLine();
			bw.close();

			JOptionPane.showMessageDialog(this, "Mascota guardada con exito.");

			limpiarCampos();

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "La edad debe ser numerica.");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	/**
	 * Busca un dueno por identificacion en el archivo de duenos.
	 * 
	 * @param identificacion Identificacion del dueno
	 * @return Objeto Dueno si existe, null si no existe
	 */
	public Dueno buscarDuenoEnArchivo(String identificacion) {
		Dueno duenoEncontrado = null;

		try {
			File archivo = new File("duenos.txt");

			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			BufferedReader br = new BufferedReader(new FileReader(archivo));
			String linea = br.readLine();

			while (linea != null) {
				String[] datos = linea.split("\\|");

				if (datos.length == 5) {
					if (datos[0].equals(identificacion)) {
						duenoEncontrado = new Dueno(datos[0], datos[1], datos[2], datos[3], datos[4]);
					}
				}

				linea = br.readLine();
			}

			br.close();

		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}

		return duenoEncontrado;
	}

	/**
	 * Muestra todas las mascotas almacenadas en el archivo de forma ordenada.
	 */
	public void mostrarMascotas() {
		try {
			File archivo = new File("mascotas.txt");

			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			BufferedReader br = new BufferedReader(new FileReader(archivo));
			String linea = br.readLine();
			String informacion = "";

			while (linea != null) {
				String[] datos = linea.split("\\|");

				if (datos.length == 7) {
					informacion += "ID Mascota: " + datos[0] + "\n";
					informacion += "Nombre: " + datos[1] + "\n";
					informacion += "Especie: " + datos[2] + "\n";
					informacion += "Raza: " + datos[3] + "\n";
					informacion += "Edad: " + datos[4] + "\n";
					informacion += "Sexo: " + datos[5] + "\n";
					informacion += "ID Dueno: " + datos[6] + "\n";
					informacion += "-----------------------------\n";
				}

				linea = br.readLine();
			}

			br.close();
			taInformacion.setText(informacion);

		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	/**
	 * Elimina una mascota del archivo de texto segun su identificacion.
	 */
	public void eliminarMascota() {
		try {
			String idMascota = tfIdMascota.getText().trim();

			if (idMascota.equals("")) {
				JOptionPane.showMessageDialog(this, "Debe ingresar el ID de la mascota a eliminar.");
				return;
			}

			File archivo = new File("mascotas.txt");
			File archivoTemporal = new File("mascotas_temp.txt");

			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			BufferedReader br = new BufferedReader(new FileReader(archivo));
			BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTemporal));

			String linea = br.readLine();
			boolean eliminado = false;

			while (linea != null) {
				String[] datos = linea.split("\\|");

				if (datos.length == 7) {
					if (!datos[0].equals(idMascota)) {
						bw.write(linea);
						bw.newLine();
					} else {
						eliminado = true;
					}
				}

				linea = br.readLine();
			}

			br.close();
			bw.close();

			archivo.delete();
			archivoTemporal.renameTo(archivo);

			if (eliminado) {
				JOptionPane.showMessageDialog(this, "Mascota eliminada con exito.");
				limpiarCampos();
				mostrarMascotas();
			} else {
				JOptionPane.showMessageDialog(this, "No se encontro la mascota.");
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	/**
	 * Limpia los campos de texto del formulario.
	 */
	public void limpiarCampos() {
		tfIdMascota.setText("");
		tfNombre.setText("");
		tfEspecie.setText("");
		tfRaza.setText("");
		tfEdad.setText("");
		tfSexo.setText("");
		tfIdentificacionDueno.setText("");
	}
}