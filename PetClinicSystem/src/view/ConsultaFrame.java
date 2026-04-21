package view;

import java.awt.Color;
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
import javax.swing.JTextArea;
import model.Clinica;
import model.Consulta;
import model.Mascota;
import model.Veterinario;
import model.Dueno;

public class ConsultaFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfIdConsulta;
	private JTextField tfFecha;
	private JTextField tfMotivo;
	private JTextField tfDiagnostico;
	private JTextField tfIdMascota;
	private JTextField tfIdVeterinario;
	private JTextArea taMostrar;
	private Clinica clinica;

	public ConsultaFrame(Clinica clinica) {
		this.clinica = clinica;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(720, 570);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 250, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		setLocationRelativeTo(null);

		JLabel lblTitulo = new JLabel("Modulo de Consultas");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
		lblTitulo.setForeground(new Color(0, 102, 153));
		lblTitulo.setBounds(220, 10, 279, 49);
		contentPane.add(lblTitulo);

		JLabel lblIdConsulta = new JLabel("Id de la consulta:");
		lblIdConsulta.setFont(new Font("Arial", Font.BOLD, 13));
		lblIdConsulta.setBounds(38, 85, 140, 20);
		contentPane.add(lblIdConsulta);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Arial", Font.BOLD, 13));
		lblFecha.setBounds(38, 130, 140, 20);
		contentPane.add(lblFecha);

		JLabel lblMotivo = new JLabel("Motivo:");
		lblMotivo.setFont(new Font("Arial", Font.BOLD, 13));
		lblMotivo.setBounds(38, 175, 140, 20);
		contentPane.add(lblMotivo);

		JLabel lblDiagnostico = new JLabel("Diagnóstico:");
		lblDiagnostico.setFont(new Font("Arial", Font.BOLD, 13));
		lblDiagnostico.setBounds(38, 220, 140, 20);
		contentPane.add(lblDiagnostico);

		JLabel lblIdMascota = new JLabel("Id de la mascota:");
		lblIdMascota.setFont(new Font("Arial", Font.BOLD, 13));
		lblIdMascota.setBounds(38, 265, 140, 20);
		contentPane.add(lblIdMascota);

		JLabel lblIdVeterinario = new JLabel("Id del veterinario:");
		lblIdVeterinario.setFont(new Font("Arial", Font.BOLD, 13));
		lblIdVeterinario.setBounds(38, 308, 140, 20);
		contentPane.add(lblIdVeterinario);

		tfIdConsulta = new JTextField();
		tfIdConsulta.setColumns(10);
		tfIdConsulta.setBounds(199, 81, 182, 30);
		contentPane.add(tfIdConsulta);

		tfFecha = new JTextField();
		tfFecha.setColumns(10);
		tfFecha.setBounds(199, 126, 182, 30);
		contentPane.add(tfFecha);

		tfMotivo = new JTextField();
		tfMotivo.setColumns(10);
		tfMotivo.setBounds(199, 171, 182, 30);
		contentPane.add(tfMotivo);

		tfDiagnostico = new JTextField();
		tfDiagnostico.setColumns(10);
		tfDiagnostico.setBounds(199, 216, 182, 30);
		contentPane.add(tfDiagnostico);

		tfIdMascota = new JTextField();
		tfIdMascota.setColumns(10);
		tfIdMascota.setBounds(199, 261, 182, 30);
		contentPane.add(tfIdMascota);

		tfIdVeterinario = new JTextField();
		tfIdVeterinario.setColumns(10);
		tfIdVeterinario.setBounds(199, 304, 182, 30);
		contentPane.add(tfIdVeterinario);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarConsulta();
			}
		});
		btnGuardar.setBackground(new Color(0, 153, 76));
		btnGuardar.setForeground(Color.BLACK);
		btnGuardar.setFont(new Font("Arial", Font.BOLD, 13));
		btnGuardar.setBounds(430, 80, 140, 30);
		contentPane.add(btnGuardar);

		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarConsultas();
			}
		});
		btnMostrar.setBackground(new Color(0, 102, 204));
		btnMostrar.setForeground(Color.BLACK);
		btnMostrar.setFont(new Font("Arial", Font.BOLD, 13));
		btnMostrar.setBounds(430, 125, 140, 30);
		contentPane.add(btnMostrar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarConsulta();
			}
		});
		btnEliminar.setBackground(new Color(255, 153, 0));
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 13));
		btnEliminar.setBounds(430, 170, 140, 30);
		contentPane.add(btnEliminar);

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

	public void guardarConsulta() {
		try {
			String idConsulta = tfIdConsulta.getText();
			String fecha = tfFecha.getText();
			String motivo = tfMotivo.getText();
			String diagnostico = tfDiagnostico.getText();
			String idMascota = tfIdMascota.getText();
			String idVeterinario = tfIdVeterinario.getText();

			if (idConsulta.equals("") || fecha.equals("") || motivo.equals("") || diagnostico.equals("")
					|| idMascota.equals("") || idVeterinario.equals("")) {
				JOptionPane.showMessageDialog(null, "Complete todos los campos.");
				return;
			}

			File archivo = new File("consultas.txt");
			if (!archivo.exists()) archivo.createNewFile();

			BufferedReader br = new BufferedReader(new FileReader(archivo));
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] datos = linea.split("\\|");
				if (datos[0].equals(idConsulta)) {
					br.close();
					JOptionPane.showMessageDialog(null, "Ya existe una consulta con ese ID.");
					return;
				}
			}
			br.close();

			if (!existeEnArchivo("mascotas.txt", idMascota)) {
				JOptionPane.showMessageDialog(null, "La mascota no existe en el sistema.");
				return;
			}

			if (!existeEnArchivo("veterinarios.txt", idVeterinario)) {
				JOptionPane.showMessageDialog(null, "El veterinario no existe en el sistema.");
				return;
			}

			BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true));
			bw.write(idConsulta + "|" + fecha + "|" + motivo + "|" + diagnostico + "|" + idMascota + "|" + idVeterinario);
			bw.newLine();
			bw.close();

			JOptionPane.showMessageDialog(null, "Consulta guardada.");
			limpiarCampos();

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void mostrarConsultas() {
		try {
			File archivo = new File("consultas.txt");
			if (!archivo.exists()) archivo.createNewFile();

			BufferedReader br = new BufferedReader(new FileReader(archivo));
			String linea;
			String info = "";

			while ((linea = br.readLine()) != null) {
				String[] datos = linea.split("\\|");

				if (datos.length == 6) {
					info += "ID Consulta: " + datos[0] + "\n";
					info += "Fecha: " + datos[1] + "\n";
					info += "Motivo: " + datos[2] + "\n";
					info += "Diagnóstico: " + datos[3] + "\n";
					info += "ID Mascota: " + datos[4] + "\n";
					info += "ID Veterinario: " + datos[5] + "\n";
					info += "---------------------\n";
				}
			}

			br.close();
			taMostrar.setText(info);

		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	public void eliminarConsulta() {
		try {
			String id = tfIdConsulta.getText().trim();

			if (id.equals("")) {
				JOptionPane.showMessageDialog(this, "Ingrese ID.");
				return;
			}

			File archivo = new File("consultas.txt");
			File temp    = new File("temp_consultas.txt");
			
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
				JOptionPane.showMessageDialog(this, "Eliminado.");
				limpiarCampos();
			} else {
				JOptionPane.showMessageDialog(this, "No encontrado.");
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	public boolean existeEnArchivo(String nombreArchivo, String id) {
		try {
			File archivo = new File(nombreArchivo);
			if (!archivo.exists()) return false;

			BufferedReader br = new BufferedReader(new FileReader(archivo));
			String linea;

			while ((linea = br.readLine()) != null) {
				String[] datos = linea.split("\\|");
				if (datos[0].equals(id)) {
					br.close();
					return true;
				}
			}
			br.close();

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return false;
	}

	public void limpiarCampos() {
		tfIdConsulta.setText("");
		tfFecha.setText("");
		tfMotivo.setText("");
		tfDiagnostico.setText("");
		tfIdMascota.setText("");
		tfIdVeterinario.setText("");
	}
}