package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Clinica;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
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
 * Clase RegistroUsuario.
 * 
 * Esta clase representa la ventana de registro de usuarios del sistema.
 * Permite guardar un nuevo usuario y password en un archivo de texto.
 * 
 * @author Jose Pablo Zavala Varela
 * @author Sheilyn Zamora Sandoval
 * @version 1.0
 */
public class RegistroUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfUsuario;
	private JTextField tfPassword;
	private JTextField tfConfirmarPassword;
	private Clinica clinica;

	/**
	 * Constructor de la ventana de registro de usuario.
	 * 
	 * @param clinica Clinica principal del sistema
	 */
	public RegistroUsuario(Clinica clinica) {
		this.clinica = clinica;

		setTitle("PetClinicSystem - Registro de Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 380);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 250, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelFormulario = new JPanel();
		panelFormulario.setBackground(Color.WHITE);
		panelFormulario.setBounds(65, 45, 370, 250);
		panelFormulario.setLayout(null);
		contentPane.add(panelFormulario);

		JLabel lblTitulo = new JLabel("Registro de Usuario");
		lblTitulo.setForeground(new Color(0, 102, 153));
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
		lblTitulo.setBounds(78, 15, 220, 30);
		panelFormulario.add(lblTitulo);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setForeground(new Color(0, 51, 102));
		lblUsuario.setFont(new Font("Arial", Font.BOLD, 14));
		lblUsuario.setBounds(40, 75, 120, 20);
		panelFormulario.add(lblUsuario);

		tfUsuario = new JTextField();
		tfUsuario.setFont(new Font("Arial", Font.PLAIN, 13));
		tfUsuario.setBounds(180, 75, 140, 22);
		panelFormulario.add(tfUsuario);
		tfUsuario.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(new Color(0, 51, 102));
		lblPassword.setFont(new Font("Arial", Font.BOLD, 14));
		lblPassword.setBounds(40, 115, 120, 20);
		panelFormulario.add(lblPassword);

		tfPassword = new JTextField();
		tfPassword.setFont(new Font("Arial", Font.PLAIN, 13));
		tfPassword.setBounds(180, 115, 140, 22);
		panelFormulario.add(tfPassword);
		tfPassword.setColumns(10);

		JLabel lblConfirmar = new JLabel("Confirmar Password:");
		lblConfirmar.setForeground(new Color(0, 51, 102));
		lblConfirmar.setFont(new Font("Arial", Font.BOLD, 14));
		lblConfirmar.setBounds(40, 155, 140, 20);
		panelFormulario.add(lblConfirmar);

		tfConfirmarPassword = new JTextField();
		tfConfirmarPassword.setFont(new Font("Arial", Font.PLAIN, 13));
		tfConfirmarPassword.setBounds(180, 155, 140, 22);
		panelFormulario.add(tfConfirmarPassword);
		tfConfirmarPassword.setColumns(10);

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBackground(new Color(0, 153, 76));
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setFont(new Font("Arial", Font.BOLD, 13));
		btnRegistrar.setBounds(55, 205, 120, 30);
		panelFormulario.add(btnRegistrar);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBackground(new Color(0, 102, 204));
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setFont(new Font("Arial", Font.BOLD, 13));
		btnVolver.setBounds(200, 205, 120, 30);
		panelFormulario.add(btnVolver);

		JLabel lblFrase = new JLabel("Crea tu cuenta para ingresar al sistema");
		lblFrase.setForeground(new Color(90, 90, 90));
		lblFrase.setFont(new Font("Arial", Font.ITALIC, 12));
		lblFrase.setBounds(145, 308, 225, 14);
		contentPane.add(lblFrase);

		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarUsuario();
			}
		});

		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InicioSesion inicio = new InicioSesion(clinica);
				inicio.setVisible(true);
				setVisible(false);
			}
		});
	}

	/**
	 * Registra un nuevo usuario en el archivo de texto del sistema.
	 */
	public void registrarUsuario() {
		try {
			String usuario = tfUsuario.getText().trim();
			String password = tfPassword.getText().trim();
			String confirmarPassword = tfConfirmarPassword.getText().trim();

			if (usuario.equals("") || password.equals("") || confirmarPassword.equals("")) {
				JOptionPane.showMessageDialog(this, "Debe completar todos los campos.", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			if (!password.equals(confirmarPassword)) {
				JOptionPane.showMessageDialog(this, "Las contrasenas no coinciden.", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
				return;
			}

			File archivo = new File("usuarios.txt");

			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);

			String linea = br.readLine();
			boolean usuarioExiste = false;

			while (linea != null) {
				String[] datos = linea.split("\\|");

				if (datos.length == 2) {
					if (datos[0].equals(usuario)) {
						usuarioExiste = true;
					}
				}

				linea = br.readLine();
			}

			br.close();

			if (usuarioExiste) {
				JOptionPane.showMessageDialog(this, "El usuario ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			FileWriter fw = new FileWriter(archivo, true);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(usuario + "|" + password);
			bw.newLine();
			bw.close();

			JOptionPane.showMessageDialog(this, "Usuario registrado con exito.");

			InicioSesion inicio = new InicioSesion(clinica);
			inicio.setVisible(true);
			setVisible(false);

		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}