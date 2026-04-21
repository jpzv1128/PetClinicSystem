package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import model.Clinica;
import model.Veterinario;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

/**
 * Clase VeterinarioFrame.
 * 
 * Esta clase representa la ventana para registrar, mostrar y eliminar
 * veterinarios del sistema.
 * 
 * @author Jose Pablo Zavala Varela
 * @author Sheilyn Zamora Sandoval
 * @version 1.0
 */

public class VeterinarioFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfVeterinario;
	private JTextField tfIdVeterinario;
	private JTextField tfEspecialidad;
	private JTextField tfHorario;
	private JTextField tfTelefono;
	private Clinica clinica;
	private JTextArea taMostrar;
	
	/**
	 * Constructor de la ventana de veterinario.
	 * 
	 * @param clinica Clinica principal del sistema
	 */
	
	public VeterinarioFrame(Clinica clinica) {
	    this.clinica = clinica;

	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setSize(720, 570);
	    contentPane = new JPanel();
	    contentPane.setBackground(new Color(250, 250, 255));
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    contentPane.setLayout(null);
	    setContentPane(contentPane);

	    setLocationRelativeTo(null);
		
		JLabel lblTitulo = new JLabel("Modulo de Veterinario");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
		lblTitulo.setForeground(new Color(0, 102, 153));
		lblTitulo.setBounds(199, 10, 279, 49);
		contentPane.add(lblTitulo);

		JLabel lblIdVeterinario = new JLabel("Id del veterinario:");
		lblIdVeterinario.setFont(new Font("Arial", Font.BOLD, 13));
		lblIdVeterinario.setBounds(38, 135, 120, 20);
		contentPane.add(lblIdVeterinario);
		
		JLabel lblnombreVeterinario = new JLabel("Nombre del veterinario:");
		lblnombreVeterinario.setFont(new Font("Arial", Font.BOLD, 13));
		lblnombreVeterinario.setBounds(38, 85, 175, 20);
		contentPane.add(lblnombreVeterinario);
		
		JLabel lblEspecialidad = new JLabel("Especialidad:");
		lblEspecialidad.setFont(new Font("Arial", Font.BOLD, 13));
		lblEspecialidad.setBounds(38, 192, 175, 20);
		contentPane.add(lblEspecialidad);
		
		JLabel lbltelefono = new JLabel("Número telefonico:");
		lbltelefono.setFont(new Font("Arial", Font.BOLD, 13));
		lbltelefono.setBounds(38, 308, 175, 20);
		contentPane.add(lbltelefono);
		
		JLabel lblHorario = new JLabel("Horario de atención:");
		lblHorario.setFont(new Font("Arial", Font.BOLD, 13));
		lblHorario.setBounds(38, 250, 175, 20);
		contentPane.add(lblHorario);
		
		tfVeterinario = new JTextField();
		tfVeterinario.setBounds(199, 81, 182, 30);
		contentPane.add(tfVeterinario);
		tfVeterinario.setColumns(10);
		
		tfIdVeterinario = new JTextField();
		tfIdVeterinario.setColumns(10);
		tfIdVeterinario.setBounds(199, 131, 182, 30);
		contentPane.add(tfIdVeterinario);
		
		tfEspecialidad = new JTextField();
		tfEspecialidad.setColumns(10);
		tfEspecialidad.setBounds(199, 188, 182, 30);
		contentPane.add(tfEspecialidad);
		
		tfHorario = new JTextField();
		tfHorario.setColumns(10);
		tfHorario.setBounds(199, 244, 182, 34);
		contentPane.add(tfHorario);
		
		tfTelefono = new JTextField();
		tfTelefono.setColumns(10);
		tfTelefono.setBounds(199, 304, 182, 30);
		contentPane.add(tfTelefono);
		
		/**
		 * Boton para guardar un veterinario.
		 */
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarVeterinario();
			}
		});
		btnGuardar.setBackground(new Color(0, 153, 76));
		btnGuardar.setForeground(Color.BLACK);
		btnGuardar.setFont(new Font("Arial", Font.BOLD, 13));
		btnGuardar.setBounds(430, 80, 140, 30);
		contentPane.add(btnGuardar);
		
		/**
		 * Boton para mostrar un veterinario.
		 */
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarVeterinarios();
			}
		});
		btnMostrar.setBackground(new Color(0, 102, 204));
		btnMostrar.setForeground(Color.BLACK);
		btnMostrar.setFont(new Font("Arial", Font.BOLD, 13));
		btnMostrar.setBounds(430, 125, 140, 30);
		contentPane.add(btnMostrar);
		
		/**
		 * Boton para eliminar un veterinario.
		 */
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				eliminarVeterinario();
			}
		});
		btnEliminar.setBackground(new Color(255, 153, 0));
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 13));
		btnEliminar.setBounds(430, 170, 140, 30);
		contentPane.add(btnEliminar);
		
		/**
		 * Boton para volver al menu principal.
		 */
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal menu = new MenuPrincipal(clinica);
				menu.setVisible(true);
				dispose(); 
			}
		});
		btnVolver.setBackground(new Color(204, 51, 51));
		btnVolver.setForeground(Color.BLACK);
		btnVolver.setFont(new Font("Arial", Font.BOLD, 13));
		btnVolver.setBounds(430, 215, 140, 30);
		contentPane.add(btnVolver);

		/**
		 * Boton para volver al inicio de sesion.
		 */
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
		
		taMostrar = new JTextArea();
		taMostrar.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(taMostrar);
		scrollPane.setBounds(72, 361, 532, 150); 
		contentPane.add(scrollPane);
	}
	

	/**
	 * Metodo que guarda un veterinario.
	 */
	public void guardarVeterinario() {
	    try {
	        String id = tfIdVeterinario.getText();
	        String nombre = tfVeterinario.getText();
	        String especialidad = tfEspecialidad.getText();
	        String horario = tfHorario.getText();
	        String telefono = tfTelefono.getText();

	        if (id.equals("") || nombre.equals("") || especialidad.equals("") || horario.equals("") || telefono.equals("")) {
	            JOptionPane.showMessageDialog(null, "Complete todos los campos.");
	            return;
	        }
	        
	        File archivo = new File("veterinarios.txt");
	        if (!archivo.exists()) archivo.createNewFile();

	        BufferedReader br = new BufferedReader(new FileReader(archivo));
	        String linea;
	        while ((linea = br.readLine()) != null) {
	            String[] datos = linea.split("\\|");
	            if (datos[0].equals(id)) {
	                br.close();
	                JOptionPane.showMessageDialog( null, "Ya existe un veterinario con ese ID.");
	                return; 
	            }
	        }
	        br.close();

	        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true));
	        bw.write(id + "|" + nombre + "|" + especialidad + "|" + horario + "|" + telefono);
	        bw.newLine();
	        bw.close();

	        JOptionPane.showMessageDialog(null, "Veterinario guardado.");
	        limpiarCampos();

	    } catch (IOException e) {
	        JOptionPane.showMessageDialog(null, e.getMessage());
	    }
	}
	
	/**
	 * Metodo que muestra un veterinario.
	 */
	public void mostrarVeterinarios() {
	    try {
	        File archivo = new File("veterinarios.txt");
	        if (!archivo.exists()) archivo.createNewFile();

	        BufferedReader br = new BufferedReader(new FileReader(archivo));
	        String linea;
	        String info = "";

	        while ((linea = br.readLine()) != null) {
	            String[] datos = linea.split("\\|");

	            if (datos.length == 5) {
	                info += "ID: " + datos[0] + "\n";
	                info += "Nombre: " + datos[1] + "\n";
	                info += "Especialidad: " + datos[2] + "\n";
	                info += "Horario: " + datos[3] + "\n";
	                info += "Teléfono: " + datos[4] + "\n";
	                info += "---------------------\n";
	            }
	        }

	        br.close();
	        taMostrar.setText(info);

	    } catch (IOException e) {
	        JOptionPane.showMessageDialog(this, e.getMessage());
	    }
	}
	/**
	 * Metodo que elimina un veterinario.
	 */
	public void eliminarVeterinario() {
		try {
			String id = tfIdVeterinario.getText().trim();

			if (id.equals("")) {
				JOptionPane.showMessageDialog(null, "Ingrese ID.");
				return;
			}

			File archivo = new File("veterinarios.txt");
			File temp = new File("temp.txt");

			BufferedReader br = new BufferedReader(new FileReader(archivo));
			BufferedWriter bw = new BufferedWriter(new FileWriter(temp));

			String linea;
			boolean eliminado = false;

			while ((linea = br.readLine()) != null) {
				String[] datos = linea.split("\\|");

				if (!datos[0].equals(id)) {
					bw.write(linea);
					bw.newLine();
				} else {
					eliminado = true;
				}
			}

			br.close();
			bw.close();

			archivo.delete();
			temp.renameTo(archivo);

			if (eliminado) {
				JOptionPane.showMessageDialog(null, "Eliminado.");
				limpiarCampos();
			} else {
				JOptionPane.showMessageDialog(null, "No encontrado.");
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	

	/**
	 * Limpia los campos de texto del formulario.
	 */
	public void limpiarCampos() {
		tfIdVeterinario.setText("");
		tfVeterinario.setText("");
		tfEspecialidad.setText("");
		tfHorario.setText("");
		tfTelefono.setText("");
	}
}
