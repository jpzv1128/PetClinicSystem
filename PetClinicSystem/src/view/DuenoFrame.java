package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Clinica;
import model.Dueno;

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
 * Clase DuenoFrame.
 * 
 * Esta clase representa la ventana para registrar, mostrar y eliminar
 * duenos del sistema.
 * 
 * @author Jose Pablo Zavala Varela
 * @author Sheilyn Zamora Sandoval
 * @version 1.0
 */
public class DuenoFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfIdentificacion;
	private JTextField tfNombre;
	private JTextField tfTelefono;
	private JTextField tfCorreo;
	private JTextField tfDireccion;
	private JTextArea taInformacion;
	private Clinica clinica;

	/**
	 * Constructor de la ventana de duenos.
	 * 
	 * @param clinica Clinica principal del sistema
	 */
	public DuenoFrame(Clinica clinica) {
		this.clinica = clinica;

		setTitle("PetClinicSystem - Duenos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 530);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("Modulo de Duenos");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
		lblTitulo.setForeground(new Color(0, 102, 153));
		lblTitulo.setBounds(225, 15, 220, 30);
		contentPane.add(lblTitulo);

		JLabel lblIdentificacion = new JLabel("Identificacion:");
		lblIdentificacion.setFont(new Font("Arial", Font.BOLD, 13));
		lblIdentificacion.setBounds(40, 70, 100, 20);
		contentPane.add(lblIdentificacion);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Arial", Font.BOLD, 13));
		lblNombre.setBounds(40, 105, 100, 20);
		contentPane.add(lblNombre);

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Arial", Font.BOLD, 13));
		lblTelefono.setBounds(40, 140, 100, 20);
		contentPane.add(lblTelefono);

		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setFont(new Font("Arial", Font.BOLD, 13));
		lblCorreo.setBounds(40, 175, 100, 20);
		contentPane.add(lblCorreo);

		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setFont(new Font("Arial", Font.BOLD, 13));
		lblDireccion.setBounds(40, 210, 100, 20);
		contentPane.add(lblDireccion);

		tfIdentificacion = new JTextField();
		tfIdentificacion.setBounds(150, 70, 180, 22);
		contentPane.add(tfIdentificacion);
		tfIdentificacion.setColumns(10);

		tfNombre = new JTextField();
		tfNombre.setBounds(150, 105, 180, 22);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);

		tfTelefono = new JTextField();
		tfTelefono.setBounds(150, 140, 180, 22);
		contentPane.add(tfTelefono);
		tfTelefono.setColumns(10);

		tfCorreo = new JTextField();
		tfCorreo.setBounds(150, 175, 180, 22);
		contentPane.add(tfCorreo);
		tfCorreo.setColumns(10);

		tfDireccion = new JTextField();
		tfDireccion.setBounds(150, 210, 180, 22);
		contentPane.add(tfDireccion);
		tfDireccion.setColumns(10);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(new Color(0, 153, 76));
		btnGuardar.setForeground(Color.BLACK);
		btnGuardar.setFont(new Font("Arial", Font.BOLD, 13));
		btnGuardar.setBounds(400, 70, 140, 30);
		contentPane.add(btnGuardar);

		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.setBackground(new Color(0, 102, 204));
		btnMostrar.setForeground(Color.BLACK);
		btnMostrar.setFont(new Font("Arial", Font.BOLD, 13));
		btnMostrar.setBounds(400, 115, 140, 30);
		contentPane.add(btnMostrar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(new Color(255, 153, 0));
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 13));
		btnEliminar.setBounds(400, 160, 140, 30);
		contentPane.add(btnEliminar);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBackground(new Color(204, 51, 51));
		btnVolver.setForeground(Color.BLACK);
		btnVolver.setFont(new Font("Arial", Font.BOLD, 13));
		btnVolver.setBounds(400, 205, 140, 30);
		contentPane.add(btnVolver);

		taInformacion = new JTextArea();
		taInformacion.setBounds(40, 280, 580, 170);
		contentPane.add(taInformacion);

		/**
		 * Boton para guardar un dueno.
		 */
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarDueno();
			}
		});

		/**
		 * Boton para mostrar los duenos guardados.
		 */
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarDuenos();
			}
		});

		/**
		 * Boton para eliminar un dueno.
		 */
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarDueno();
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
	 * Guarda un dueno en memoria y en archivo de texto.
	 */
	public void guardarDueno() {
		try {
			String identificacion = tfIdentificacion.getText().trim();
			String nombre = tfNombre.getText().trim();
			String telefono = tfTelefono.getText().trim();
			String correo = tfCorreo.getText().trim();
			String direccion = tfDireccion.getText().trim();

			if (identificacion.equals("") || nombre.equals("") || telefono.equals("") || correo.equals("")
					|| direccion.equals("")) {
				JOptionPane.showMessageDialog(this, "Debe completar todos los campos.");
				return;
			}

			Dueno dueno = new Dueno(identificacion, nombre, telefono, correo, direccion);
			clinica.agregarDueno(dueno);

			File archivo = new File("duenos.txt");

			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true));
			bw.write(identificacion + "|" + nombre + "|" + telefono + "|" + correo + "|" + direccion);
			bw.newLine();
			bw.close();

			JOptionPane.showMessageDialog(this, "Dueno guardado con exito.");

			limpiarCampos();

		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	/**
	 * Muestra todos los duenos almacenados en el archivo de forma ordenada.
	 */
	public void mostrarDuenos() {
		try {
			File archivo = new File("duenos.txt");

			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			BufferedReader br = new BufferedReader(new FileReader(archivo));
			String linea = br.readLine();
			String informacion = "";

			while (linea != null) {
				String[] datos = linea.split("\\|");

				if (datos.length == 5) {
					informacion += "Identificacion: " + datos[0] + "\n";
					informacion += "Nombre: " + datos[1] + "\n";
					informacion += "Telefono: " + datos[2] + "\n";
					informacion += "Correo: " + datos[3] + "\n";
					informacion += "Direccion: " + datos[4] + "\n";
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
	 * Elimina un dueno del archivo de texto segun su identificacion.
	 */
	public void eliminarDueno() {
		try {
			String identificacion = tfIdentificacion.getText().trim();

			if (identificacion.equals("")) {
				JOptionPane.showMessageDialog(this, "Debe ingresar la identificacion del dueno a eliminar.");
				return;
			}

			File archivo = new File("duenos.txt");
			File archivoTemporal = new File("duenos_temp.txt");

			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			BufferedReader br = new BufferedReader(new FileReader(archivo));
			BufferedWriter bw = new BufferedWriter(new FileWriter(archivoTemporal));

			String linea = br.readLine();
			boolean eliminado = false;

			while (linea != null) {
				String[] datos = linea.split("\\|");

				if (datos.length == 5) {
					if (!datos[0].equals(identificacion)) {
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
				JOptionPane.showMessageDialog(this, "Dueno eliminado con exito.");
				limpiarCampos();
				mostrarDuenos();
			} else {
				JOptionPane.showMessageDialog(this, "No se encontro el dueno.");
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	/**
	 * Limpia los campos de texto del formulario.
	 */
	public void limpiarCampos() {
		tfIdentificacion.setText("");
		tfNombre.setText("");
		tfTelefono.setText("");
		tfCorreo.setText("");
		tfDireccion.setText("");
	}
}