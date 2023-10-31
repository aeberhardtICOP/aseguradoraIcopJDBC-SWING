package IGU;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;

import javax.swing.JTextField;
import java.awt.GridBagLayout;
import javax.swing.JTextPane;
import java.awt.GridBagConstraints;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import Service.ClienteService;

import javax.swing.JButton;

public class CargaCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtMail;
	private JTextField txtDni;
	private JTextField txtApellido;
	private JTextField txtDomicilio;
	private JTextField txtTelefon;

	

	public CargaCliente() {
		setTitle("Carga de cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel.setBounds(33, 35, 649, 373);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(27, 31, 58, 14);
		panel.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(304, 31, 64, 14);
		panel.add(lblApellido);
		
		JLabel lblMail = new JLabel("Mail:");
		lblMail.setBounds(27, 81, 46, 14);
		panel.add(lblMail);
		
		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setBounds(304, 81, 46, 14);
		panel.add(lblGenero);
		
		JLabel lblDni = new JLabel("Dni:");
		lblDni.setBounds(27, 133, 46, 14);
		panel.add(lblDni);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(83, 24, 181, 29);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtMail = new JTextField();
		txtMail.setColumns(10);
		txtMail.setBounds(83, 74, 181, 29);
		panel.add(txtMail);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(83, 126, 181, 29);
		panel.add(txtDni);
		
		final JRadioButton rdBtnMasculino = new JRadioButton("Masculino");
		rdBtnMasculino.setBounds(354, 77, 109, 23);
		panel.add(rdBtnMasculino);
		
		final JRadioButton rdBtnFemenino = new JRadioButton("Femenino");
		rdBtnFemenino.setBounds(354, 102, 109, 23);
		panel.add(rdBtnFemenino);
		
		final JRadioButton rdBtnOtro = new JRadioButton("Otro");
		rdBtnOtro.setBounds(354, 126, 109, 23);
		panel.add(rdBtnOtro);
		
		final ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdBtnMasculino);
		buttonGroup.add(rdBtnFemenino);
		buttonGroup.add(rdBtnOtro);

		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(363, 24, 181, 29);
		panel.add(txtApellido);
		
		JLabel lblDomicilio = new JLabel("Domicilio:");
		lblDomicilio.setBounds(27, 179, 73, 14);
		panel.add(lblDomicilio);
		
		JLabel lblDomicilio_1 = new JLabel("Telefono:");
		lblDomicilio_1.setBounds(304, 179, 64, 14);
		panel.add(lblDomicilio_1);
		
		txtDomicilio = new JTextField();
		txtDomicilio.setColumns(10);
		txtDomicilio.setBounds(83, 172, 181, 29);
		panel.add(txtDomicilio);
		
		txtTelefon = new JTextField();
		txtTelefon.setColumns(10);
		txtTelefon.setBounds(363, 172, 181, 29);
		panel.add(txtTelefon);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(463, 299, 116, 38);
		panel.add(btnGuardar);
		btnGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!isInteger(txtDni.getText())) {
                    JOptionPane.showMessageDialog(null, "DNI: Ingrese solo numeros enteros", "Error", JOptionPane.ERROR_MESSAGE);
                    txtDni.setText("");
				}else if(!isInteger(txtTelefon.getText())){
					JOptionPane.showMessageDialog(null, "TELEFONO: Ingrese solo números enteros", "Error", JOptionPane.ERROR_MESSAGE);
                    txtDni.setText("");
				}else {
					ClienteService bd = new ClienteService();
					String nombre=txtNombre.getText();
					String apellido=txtApellido.getText();
					String mail=txtMail.getText();
					String dni=txtDni.getText();
					String domicilio=txtDomicilio.getText();
					String telefono=txtTelefon.getText();
					String genero=obtenerSeleccion(buttonGroup);
					bd.crearCliente(nombre, apellido, mail, genero, dni, domicilio, telefono);
					JOptionPane.showMessageDialog(null, "Usuario creado con exito!", "Exito", JOptionPane.OK_OPTION);
					txtNombre.setText("");
					txtApellido.setText("");
					txtApellido.setText("");
					txtMail.setText("");
					txtDni.setText("");
					txtDomicilio.setText("");
					txtTelefon.setText("");
					rdBtnFemenino.setSelected(false);
					rdBtnMasculino.setSelected(false);
					rdBtnOtro.setSelected(false);
					
					
				
			}
		}});
		
		JLabel lblTitulo = new JLabel("Carga de cliente:");
		lblTitulo.setForeground(new Color(0, 0, 255));
		lblTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblTitulo.setBounds(271, 11, 159, 25);
		contentPane.add(lblTitulo);
		
		JLabel lblVolver = new JLabel("<-Volver al menu");
		lblVolver.setForeground(new Color(0, 0, 160));
		lblVolver.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		lblVolver.setBounds(10, 11, 115, 14);
		contentPane.add(lblVolver);
		lblVolver.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Aseguradora ase = new Aseguradora();
				ase.setVisible(true);
                dispose();
				
			}
		});
	}
	 private static String obtenerSeleccion(ButtonGroup buttonGroup) {
	        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
	            AbstractButton button = buttons.nextElement();
	            if (button.isSelected()) {
	                return button.getText();
	            }
	        }
	        return "No especifica";
	    }
	 private static boolean isInteger(String text) {
	        try {
	            Integer.parseInt(text);
	            return true;
	        } catch (NumberFormatException e) {
	            return false;
	        }
	    }
}
