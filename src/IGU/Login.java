package IGU;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import Service.UserPswdService;
import java.awt.Color;
public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsu;
	private JPasswordField passwordField;

	public Login() {
		setTitle("Log-in");
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
		lblUsuario.setBounds(281, 68, 134, 99);
		contentPane.add(lblUsuario);
		
		txtUsu = new JTextField();
		txtUsu.setBounds(399, 98, 228, 43);
		contentPane.add(txtUsu);
		txtUsu.setColumns(10);
		
		JLabel lblContrasña = new JLabel("Contraseña: ");
		lblContrasña.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblContrasña.setBounds(281, 148, 134, 99);
		contentPane.add(lblContrasña);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnAceptar.setBounds(380, 304, 118, 35);
		contentPane.add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                String usu = txtUsu.getText();
	                char[] passw = passwordField.getPassword();
	                String pswd = new String(passw);
	                UserPswdService bd = new UserPswdService();
	                if(bd.validacionLogin(usu, pswd)==true) {
	                	 Aseguradora ase = new Aseguradora();
	                	 ase.setVisible(true);
	                	 dispose();
	                }else {
	                	JOptionPane.showMessageDialog(Login.this, "Inicio de sesión fallido. Usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	        });
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnCancelar.setBounds(509, 304, 118, 35);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0); 
				
			}
			
			
		});
        
		ImageIcon icon = new ImageIcon("E:\\ICOP\\3er año 2023\\Programacion\\Java-eclipse-EE\\Login\\img\\ICOP.png");
		JLabel lblImg = new JLabel(icon);
		lblImg.setBounds(31, 68, 228, 235);
		contentPane.add(lblImg);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(399, 178, 228, 43);
		contentPane.add(passwordField);
		
		JLabel lblNuevoUs = new JLabel("Crear nuevo usuario");
		lblNuevoUs.setForeground(new Color(0, 0, 160));
		lblNuevoUs.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNuevoUs.setBounds(427, 374, 154, 18);
		contentPane.add(lblNuevoUs);
		lblNuevoUs.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				CrearUsuario crearUsuario = new CrearUsuario();
                crearUsuario.setVisible(true);
                dispose();
				
			}
		
        });
		
		JLabel lblOlvidaPass = new JLabel("Olvide mi contraseña");
		lblOlvidaPass.setForeground(new Color(0, 0, 160));
		lblOlvidaPass.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblOlvidaPass.setBounds(427, 403, 154, 18);
		contentPane.add(lblOlvidaPass);
		lblOlvidaPass.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				UserPswdService bd = new UserPswdService();
				if(bd.existeUsuario(txtUsu.getText())==true) {
					ModificarContraseña modContr = new ModificarContraseña(txtUsu.getText());
					modContr.setVisible(true);
					dispose();
					}else {
						JOptionPane.showMessageDialog(Login.this, "No existe el usuario "+txtUsu.getText(), "ERROR", JOptionPane.INFORMATION_MESSAGE);
					}
				
			}
		
        });
		
		JLabel lblAsegICop = new JLabel("-ASEGURADORA ICOP-");
		lblAsegICop.setFont(new Font("SimSun-ExtB", Font.BOLD, 15));
		lblAsegICop.setBounds(50, 11, 186, 43);
		contentPane.add(lblAsegICop);
	}
}
