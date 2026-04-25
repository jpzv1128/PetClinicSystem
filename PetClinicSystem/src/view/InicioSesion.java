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
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase InicioSesion.
 * 
 * Esta clase representa la ventana de inicio de sesion del sistema.
 * Permite al usuario ingresar con sus credenciales o dirigirse
 * a la ventana de registro de usuario.
 * 
 * @author Jose Pablo Zavala Varela
 * @author Sheilyn Zamora Sandoval
 * @version 1.0
 */
public class InicioSesion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfUsuario;
	private JTextField tfPassword;
	private Clinica clinica;
	
	

	/**
	 * Constructor de la ventana de inicio de sesion.
	 * 
	 * @param clinica Clinica principal del sistema
	 */
	public InicioSesion(Clinica clinica) {
		this.clinica = clinica;

		setTitle("PetClinicSystem - Inicio de Sesion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 242, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelFormulario = new JPanel();
		panelFormulario.setBackground(Color.WHITE);
		panelFormulario.setBounds(60, 50, 360, 220);
		panelFormulario.setLayout(null);
		contentPane.add(panelFormulario);

		JLabel lblTitulo = new JLabel("PetClinicSystem");
		lblTitulo.setForeground(new Color(0, 102, 153));
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
		lblTitulo.setBounds(88, 15, 220, 30);
		panelFormulario.add(lblTitulo);

		JLabel lblSubtitulo = new JLabel("Inicio de Sesion");
		lblSubtitulo.setForeground(new Color(80, 80, 80));
		lblSubtitulo.setFont(new Font("Arial", Font.PLAIN, 16));
		lblSubtitulo.setBounds(116, 45, 140, 20);
		panelFormulario.add(lblSubtitulo);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setForeground(new Color(0, 51, 102));
		lblUsuario.setFont(new Font("Arial", Font.BOLD, 14));
		lblUsuario.setBounds(45, 90, 80, 20);
		panelFormulario.add(lblUsuario);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(new Color(0, 51, 102));
		lblPassword.setFont(new Font("Arial", Font.BOLD, 14));
		lblPassword.setBounds(45, 125, 80, 20);
		panelFormulario.add(lblPassword);

		tfUsuario = new JTextField();
		tfUsuario.setFont(new Font("Arial", Font.PLAIN, 13));
		tfUsuario.setBounds(140, 90, 160, 22);
		panelFormulario.add(tfUsuario);
		tfUsuario.setColumns(10);

		tfPassword = new JTextField();
		tfPassword.setFont(new Font("Arial", Font.PLAIN, 13));
		tfPassword.setBounds(140, 125, 160, 22);
		panelFormulario.add(tfPassword);
		tfPassword.setColumns(10);

		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.setBackground(new Color(0, 153, 76));
		btnIniciarSesion.setForeground(Color.BLACK);
		btnIniciarSesion.setFont(new Font("Arial", Font.BOLD, 13));
		btnIniciarSesion.setBounds(45, 170, 125, 30);
		panelFormulario.add(btnIniciarSesion);

		JButton btnRegistrarUsuario = new JButton("Registrar");
		btnRegistrarUsuario.setBackground(new Color(0, 102, 204));
		btnRegistrarUsuario.setForeground(Color.BLACK);
		btnRegistrarUsuario.setFont(new Font("Arial", Font.BOLD, 13));
		btnRegistrarUsuario.setBounds(185, 170, 115, 30);
		panelFormulario.add(btnRegistrarUsuario);

		JLabel lblFrase = new JLabel("Cuidamos a tus mascotas con amor");
		lblFrase.setForeground(new Color(90, 90, 90));
		lblFrase.setFont(new Font("Arial", Font.ITALIC, 12));
		lblFrase.setBounds(135, 285, 220, 14);
		contentPane.add(lblFrase);

		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciarSesion();
			}
		});

		btnRegistrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroUsuario registro = new RegistroUsuario(clinica);
				registro.setVisible(true);
				setVisible(false);
			}
		});
	}

	/**
	 * Valida las credenciales ingresadas por el usuario
	 * contra el archivo de usuarios del sistema.
	 */
	public void iniciarSesion() {
		try {
			String usuario = tfUsuario.getText().trim();
			String password = tfPassword.getText().trim();

			if (usuario.equals("") || password.equals("")) {
				JOptionPane.showMessageDialog(this, "Debe completar todos los campos.", "Advertencia",
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
			boolean accesoCorrecto = false;

			while (linea != null) {
				String[] datos = linea.split("\\|");

				if (datos.length == 2) {
					if (datos[0].equals(usuario) && datos[1].equals(password)) {
						accesoCorrecto = true;
					}
				}

				linea = br.readLine();
			}

			br.close();

			if (accesoCorrecto) {
				JOptionPane.showMessageDialog(this, "Ingreso correcto.");

				MenuPrincipal menu = new MenuPrincipal(clinica);
				menu.setVisible(true);
				setVisible(false);
			} else {
				JOptionPane.showMessageDialog(this, "Usuario o password incorrectos.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}