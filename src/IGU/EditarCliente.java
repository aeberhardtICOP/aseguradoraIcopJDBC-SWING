package IGU;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Model.Cliente;
import Service.ClienteService;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

public class EditarCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private ClienteService bd;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtMail;
	private JTextField txtDni;
	private JTextField txtApellido;
	private JTextField txtDomicilio;
	private JTextField txtTelefono;
	private JButton btnCancelar;
	private JButton btnGuardar;
	private JRadioButton rdBtnOtro;
	private JRadioButton rdBtnFemenino;
	private Component rdBtnMasculino;
	private ButtonGroup grupoGenero;


	public EditarCliente(final int id, final String nombre, final String apellido, final String mail, final String genero, final int dni, final String domicilio, final int telefono, ClienteService cliser) {
		this.bd=cliser;
		setTitle("Editar Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel.setBounds(28, 49, 649, 373);
		contentPane.add(panel);
		
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
		txtNombre.setColumns(10);
		txtNombre.setBounds(83, 24, 181, 29);
		panel.add(txtNombre);
		txtNombre.setText(nombre);
		
		txtMail = new JTextField();
		txtMail.setColumns(10);
		txtMail.setBounds(83, 74, 181, 29);
		panel.add(txtMail);
		txtMail.setText(mail);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(83, 126, 181, 29);
		panel.add(txtDni);
		txtDni.setText(Integer.toString(dni));
		
		rdBtnMasculino = new JRadioButton("Masculino");
		rdBtnMasculino.setBounds(354, 77, 109, 23);
		panel.add(rdBtnMasculino);
		
		rdBtnFemenino = new JRadioButton("Femenino");
		rdBtnFemenino.setBounds(354, 102, 109, 23);
		panel.add(rdBtnFemenino);
		
		rdBtnOtro = new JRadioButton("Otro");
		rdBtnOtro.setBounds(354, 126, 109, 23);
		panel.add(rdBtnOtro);
		rdBtnSelector(genero);
		
		grupoGenero = new ButtonGroup();
        grupoGenero.add((AbstractButton) rdBtnMasculino);
        grupoGenero.add(rdBtnFemenino);
        grupoGenero.add(rdBtnOtro);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(363, 24, 181, 29);
		panel.add(txtApellido);
		txtApellido.setText(apellido);
		
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
		txtDomicilio.setText(domicilio);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(363, 172, 181, 29);
		panel.add(txtTelefono);
		txtTelefono.setText(Integer.toString(telefono));
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(463, 299, 116, 38);
		panel.add(btnGuardar);
		btnGuardar.addActionListener(new ActionListener() {
			

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!isInteger(txtDni.getText())) {
                    JOptionPane.showMessageDialog(null, "DNI: Ingrese solo numeros enteros", "Error", JOptionPane.ERROR_MESSAGE);
                    txtDni.setText("");
				}else if(!isInteger(txtTelefono.getText())){
					JOptionPane.showMessageDialog(null, "TELEFONO: Ingrese solo números enteros", "Error", JOptionPane.ERROR_MESSAGE);
                    txtDni.setText("");
				}else {
					bd.editarCliente(txtNombre.getText(), txtApellido.getText(), txtMail.getText(), txtDni.getText(), txtDomicilio.getText(), txtTelefono.getText(), obtenerSeleccion(grupoGenero), id);
					JOptionPane.showMessageDialog(contentPane, "Modificado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				}
			}
		});
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(325, 299, 116, 38);
		panel.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		JLabel lblTitulo = new JLabel("Cliente N°: "+id);
		lblTitulo.setForeground(Color.BLUE);
		lblTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblTitulo.setBounds(286, 11, 159, 25);
		contentPane.add(lblTitulo);
	}
	public void rdBtnSelector(String genero) {
		if(genero.equals("Masculino")) {
			((AbstractButton) rdBtnMasculino).setSelected(true);
		}else if(genero.equals("Femenino")) {
			((AbstractButton) rdBtnFemenino).setSelected(true);
		}else if(genero.equals("Otro")) {
			((AbstractButton) rdBtnOtro).setSelected(true);
		}
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
