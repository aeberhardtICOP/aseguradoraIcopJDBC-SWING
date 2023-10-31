package IGU;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Service.UserPswdService;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CrearUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	
	public CrearUsuario() {
		setTitle("Crear usuario nuevo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 500);
        setResizable(false);
        
		//setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblUsuario.setBounds(281, 70, 134, 99);
		contentPane.add(lblUsuario);
		
		
		JLabel lblContrasña = new JLabel("Contraseña: ");
		lblContrasña.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblContrasña.setBounds(281, 187, 92, 25);
		contentPane.add(lblContrasña);
		
		JLabel lblNewLabel = new JLabel("(ingresela dos veces)");
		lblNewLabel.setBounds(425, 155, 165, 14);
		contentPane.add(lblNewLabel);
		ImageIcon icon = new ImageIcon("E:\\ICOP\\3er año 2023\\Programacion\\Java-eclipse-EE\\Login\\img\\ICOP.png");
		JLabel lblImg = new JLabel(icon);
		lblImg.setBounds(32, 72, 228, 235);
		contentPane.add(lblImg);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(362, 101, 228, 43);
		contentPane.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(383, 180, 228, 43);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(383, 236, 228, 43);
		contentPane.add(passwordField_1);
		
		final JLabel lblEstadoContraseña = new JLabel("");
		lblEstadoContraseña.setForeground(new Color(255, 0, 0));
		lblEstadoContraseña.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		lblEstadoContraseña.setBounds(301, 304, 373, 25);
		contentPane.add(lblEstadoContraseña);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserPswdService bd = new UserPswdService();
				String usu = textField.getText();
				char[]pass = passwordField.getPassword();
				char[]pass2 = passwordField.getPassword();
				String pswd= new String(pass);
				String pswd2 =new String(pass2);
				if(pswd.equals(pswd2)) {
					if(validarContrasena(pswd)==true) {
						bd.crearUsuario(usu, pswd);
						JOptionPane.showMessageDialog(CrearUsuario.this, "Usuaro creado con exito!.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
						Login login = new Login();
		                login.setVisible(true);
						dispose();
					}else {
						lblEstadoContraseña.setText("La contraseña no cumple con los requisitos!");
					}
				}else {
					lblEstadoContraseña.setText("No coinciden las contraseñas");
				}
			}
		});
		btnAceptar.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnAceptar.setBounds(344, 354, 118, 35);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnCancelar.setBounds(493, 354, 118, 35);
		contentPane.add(btnCancelar);
		
		JLabel lblAsegICop = new JLabel("-ASEGURADORA ICOP-");
		lblAsegICop.setFont(new Font("SimSun-ExtB", Font.BOLD, 15));
		lblAsegICop.setBounds(50, 18, 186, 43);
		contentPane.add(lblAsegICop);
	
		
	}
	 public static boolean validarContrasena(String contrasena) {
	        String regex = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[A-Z]).{8,12}$";
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(contrasena);
	        return matcher.matches();
	    }

}
