package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Clinica;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase MenuPrincipal.
 * 
 * Esta clase representa el menu principal del sistema.
 * Desde esta ventana el usuario puede acceder a los
 * modulos de duenos, mascotas, veterinarios y consultas.
 * 
 * @author Jose Pablo Zavala Varela
 * @author Sheilyn Zamora Sandoval
 * @version 1.0
 */
public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Clinica clinica;

	/**
	 * Constructor de la ventana menu principal.
	 * 
	 * @param clinica Clinica principal del sistema
	 */
	public MenuPrincipal(Clinica clinica) {
		this.clinica = clinica;

		setTitle("PetClinicSystem - Menu Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 420);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(235, 245, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.WHITE);
		panelPrincipal.setBounds(75, 40, 430, 280);
		panelPrincipal.setLayout(null);
		contentPane.add(panelPrincipal);

		JLabel lblTitulo = new JLabel("PetClinicSystem");
		lblTitulo.setForeground(new Color(0, 102, 153));
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 26));
		lblTitulo.setBounds(115, 20, 220, 30);
		panelPrincipal.add(lblTitulo);

		JLabel lblSubtitulo = new JLabel("Menu Principal");
		lblSubtitulo.setForeground(new Color(80, 80, 80));
		lblSubtitulo.setFont(new Font("Arial", Font.PLAIN, 16));
		lblSubtitulo.setBounds(155, 50, 130, 20);
		panelPrincipal.add(lblSubtitulo);

		JButton btnDuenos = new JButton("Dueños");
		btnDuenos.setBackground(new Color(0, 153, 76));
		btnDuenos.setForeground(new Color(0, 0, 0));
		btnDuenos.setFont(new Font("Arial", Font.BOLD, 14));
		btnDuenos.setBounds(60, 100, 130, 35);
		panelPrincipal.add(btnDuenos);

		JButton btnMascotas = new JButton("Mascotas");
		btnMascotas.setBackground(new Color(0, 153, 76));
		btnMascotas.setForeground(new Color(0, 0, 0));
		btnMascotas.setFont(new Font("Arial", Font.BOLD, 14));
		btnMascotas.setBounds(235, 100, 130, 35);
		panelPrincipal.add(btnMascotas);

		JButton btnVeterinarios = new JButton("Veterinarios");
		btnVeterinarios.setBackground(new Color(0, 102, 204));
		btnVeterinarios.setForeground(new Color(0, 0, 0));
		btnVeterinarios.setFont(new Font("Arial", Font.BOLD, 14));
		btnVeterinarios.setBounds(60, 160, 130, 35);
		panelPrincipal.add(btnVeterinarios);

		JButton btnConsultas = new JButton("Consultas");
		btnConsultas.setBackground(new Color(0, 102, 204));
		btnConsultas.setForeground(new Color(0, 0, 0));
		btnConsultas.setFont(new Font("Arial", Font.BOLD, 14));
		btnConsultas.setBounds(235, 160, 130, 35);
		panelPrincipal.add(btnConsultas);

		JButton btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.setBackground(new Color(204, 51, 51));
		btnCerrarSesion.setForeground(new Color(0, 0, 0));
		btnCerrarSesion.setFont(new Font("Arial", Font.BOLD, 14));
		btnCerrarSesion.setBounds(140, 220, 150, 35);
		panelPrincipal.add(btnCerrarSesion);

		JLabel lblInfoClinica = new JLabel("Clinica: " + clinica.getNombre());
		lblInfoClinica.setForeground(new Color(90, 90, 90));
		lblInfoClinica.setFont(new Font("Arial", Font.ITALIC, 12));
		lblInfoClinica.setBounds(210, 340, 200, 14);
		contentPane.add(lblInfoClinica);

		btnDuenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DuenoFrame dueno = new DuenoFrame(clinica);
				dueno.setVisible(true);
				setVisible(false);
			}
		});

		btnMascotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MascotaFrame mascota = new MascotaFrame(clinica);
				mascota.setVisible(true);	
				setVisible(false);
				}
		});

		btnVeterinarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VeterinarioFrame veterinario = new VeterinarioFrame(clinica);
				veterinario.setVisible(true);	
				setVisible(false);
			}
		});

		btnConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaFrame consulta = new ConsultaFrame(clinica);
				consulta.setVisible(true);	
				setVisible(false);
				
			}
		});

		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InicioSesion inicio = new InicioSesion(clinica);
				inicio.setVisible(true);
				setVisible(false);
			}
		});
		
		btnCerrarSesion.addActionListener(e -> {
			new InicioSesion(clinica).setVisible(true);
			dispose();
		});
	}
}