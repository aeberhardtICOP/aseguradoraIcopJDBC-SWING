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

import Service.ConnectionService;
import Service.UserPswdService;
import java.awt.Color;
public class LoginBD extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsu;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginBD frame = new LoginBD();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginBD() {
		setTitle("Log-in BD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 500);
        setResizable(false);
        
		//setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario BD:");
		lblUsuario.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblUsuario.setBounds(281, 68, 134, 99);
		contentPane.add(lblUsuario);
		
		txtUsu = new JTextField();
		txtUsu.setBounds(399, 98, 228, 43);
		contentPane.add(txtUsu);
		txtUsu.setColumns(10);
		
		JLabel lblContrasña = new JLabel("Password BD:");
		lblContrasña.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblContrasña.setBounds(281, 148, 134, 99);
		contentPane.add(lblContrasña);
		
		JButton btnAceptar = new JButton("Log-in");
		btnAceptar.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnAceptar.setBounds(380, 281, 118, 35);
		contentPane.add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                String usu = txtUsu.getText();
	                char[] passw = passwordField.getPassword();
	                String pswd = new String(passw);
	                ConnectionService con = new ConnectionService();
	                if(con.Conectar(usu, pswd)==true) {
	                	 Login login = new Login();
	                	 login.setVisible(true);
	                	 dispose();
	                }else {
	                	JOptionPane.showMessageDialog(LoginBD.this, "Conexion fallida. Usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	        });
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnCancelar.setBounds(509, 281, 118, 35);
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
		
		final JLabel lblPing = new JLabel("");
		lblPing.setBounds(399, 373, 207, 23);
		contentPane.add(lblPing);
		
		JLabel lblAsegICop = new JLabel("-ASEGURADORA ICOP-");
		lblAsegICop.setFont(new Font("SimSun-ExtB", Font.BOLD, 15));
		lblAsegICop.setBounds(50, 11, 186, 43);
		contentPane.add(lblAsegICop);
		
		JButton btnTestConn = new JButton("Probar Conexion");
		btnTestConn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConnectionService bd = new ConnectionService();
				if(bd.pingConection(txtUsu.getText(),new String(passwordField.getPassword()))==true) {
					lblPing.setText("Conexion establecida!");
				}else {
					lblPing.setText("No se pudo establecer la conexion :(");
				}
			}
		});
		btnTestConn.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnTestConn.setBounds(380, 327, 247, 35);
		contentPane.add(btnTestConn);
		
	}
}
