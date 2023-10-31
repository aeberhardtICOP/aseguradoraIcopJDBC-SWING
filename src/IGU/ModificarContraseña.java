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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class ModificarContraseña extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
    private JTextField txtUsu; 



	public ModificarContraseña(String user) {
		setTitle("Modificar contraseña");
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
		lblUsuario.setBounds(359, 68, 134, 99);
		contentPane.add(lblUsuario);
		
		txtUsu = new JTextField();
		txtUsu.setBounds(433, 98, 228, 43);
		contentPane.add(txtUsu);
		txtUsu.setColumns(10);
		txtUsu.setText(user);
		
		JLabel lblContrasña = new JLabel("Nueva Contraseña:");
		lblContrasña.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblContrasña.setBounds(290, 148, 159, 99);
		contentPane.add(lblContrasña);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(433, 178, 228, 43);
		contentPane.add(passwordField);
		ImageIcon icon = new ImageIcon("E:\\ICOP\\3er año 2023\\Programacion\\Java-eclipse-EE\\Login\\img\\ICOP.png");
		JLabel lblImg = new JLabel(icon);
		lblImg.setBounds(20, 68, 228, 235);
		contentPane.add(lblImg);
		
		final JLabel lblEstadoContraseña = new JLabel("");
		lblEstadoContraseña.setForeground(Color.RED);
		lblEstadoContraseña.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		lblEstadoContraseña.setBounds(290, 297, 373, 25);
		contentPane.add(lblEstadoContraseña);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnAceptar.setBounds(387, 372, 118, 35);
		contentPane.add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UserPswdService bd = new UserPswdService();
				String usu = txtUsu.getText();
				char[]pass = passwordField.getPassword();
				char[]pass2 = passwordField.getPassword();
				String pswd= new String(pass);
				String pswd2 =new String(pass2);
				if(pswd.equals(pswd2)) {
					if(validarContrasena(pswd)==true) {
						bd.editarContraseña(usu, pswd);
						JOptionPane.showMessageDialog(ModificarContraseña.this, "Se modifico correctamente la contraseña", "Éxito", JOptionPane.INFORMATION_MESSAGE);
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
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnCancelar.setBounds(543, 372, 118, 35);
		contentPane.add(btnCancelar);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(433, 232, 228, 43);
		contentPane.add(passwordField_1);
		
		JLabel lblNewLabel = new JLabel("(ingresela dos veces)");
		lblNewLabel.setBounds(503, 152, 158, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblAsegICop = new JLabel("-ASEGURADORA ICOP-");
		lblAsegICop.setFont(new Font("SimSun-ExtB", Font.BOLD, 15));
		lblAsegICop.setBounds(41, 11, 186, 43);
		contentPane.add(lblAsegICop);
		
		
	}
	public static boolean validarContrasena(String contrasena) {
        String regex = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[A-Z]).{8,12}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(contrasena);
        return matcher.matches();
    }
}
