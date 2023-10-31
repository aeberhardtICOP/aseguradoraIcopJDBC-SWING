package IGU;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Service.VehiculoService;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;

public class CargaVehiculo extends JFrame {
	private VehiculoService vehi;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtPotencia;
	private JTextField txtAño;
	private JTextField txtNroChas;
	private JTextField txtNroMot;
	private JComboBox<String> cmbxTipo;
	private JTextField txtNroLicencia;
	private JTextField txtNroPlazas;
	private JLabel lblNroLicencia;
	private JLabel lblNroPlazas;
	private JButton btnGuardar;
	private JTextField txtMatricula;
	private JTextField txtColor;
	private JLabel lblVolver;


	public CargaVehiculo(final VehiculoService vehi) {
		setTitle("Carga de vehiculo");
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
		panel.setBounds(26, 50, 649, 373);
		contentPane.add(panel);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(304, 38, 58, 14);
		panel.add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(27, 134, 46, 14);
		panel.add(lblModelo);
		
		JLabel lvlPotencia = new JLabel("Potencia (CV):");
		lvlPotencia.setBounds(304, 179, 88, 14);
		panel.add(lvlPotencia);
		
		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		txtMarca.setBounds(363, 31, 181, 29);
		panel.add(txtMarca);
		
		txtModelo = new JTextField();
		txtModelo.setColumns(10);
		txtModelo.setBounds(83, 127, 181, 29);
		panel.add(txtModelo);
		
		txtPotencia = new JTextField();
		txtPotencia.setColumns(10);
		txtPotencia.setBounds(402, 172, 142, 29);
		panel.add(txtPotencia);
		
		JLabel lblAño = new JLabel("Año:");
		lblAño.setBounds(27, 179, 73, 14);
		panel.add(lblAño);
		
		JLabel lblNroChasis = new JLabel("Nro. Chasis:");
		lblNroChasis.setBounds(304, 134, 73, 14);
		panel.add(lblNroChasis);
		
		txtAño = new JTextField();
		txtAño.setColumns(10);
		txtAño.setBounds(83, 172, 181, 29);
		panel.add(txtAño);
		
		txtNroChas = new JTextField();
		txtNroChas.setColumns(10);
		txtNroChas.setBounds(373, 127, 171, 29);
		panel.add(txtNroChas);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!isInteger(txtAño.getText())) {
                    JOptionPane.showMessageDialog(null, "AÑO: Ingrese solo numeros enteros", "Error", JOptionPane.ERROR_MESSAGE);
                    txtAño.setText("");
				}else if(!isInteger(txtPotencia.getText())){
					JOptionPane.showMessageDialog(null, "POTENCIA(CV): Ingrese solo números enteros", "Error", JOptionPane.ERROR_MESSAGE);
                    txtPotencia.setText("");
				}else if(!isInteger(txtNroLicencia.getText())&&cmbxTipo.getSelectedItem().equals("Taxi")) {
					JOptionPane.showMessageDialog(null, "NRO. LICENCIA: Ingrese solo números enteros", "Error", JOptionPane.ERROR_MESSAGE);
                    txtPotencia.setText("");
				}else if(!isInteger(txtNroMot.getText())) {
					JOptionPane.showMessageDialog(null, "NRO. MOTOR: Ingrese solo números enteros", "Error", JOptionPane.ERROR_MESSAGE);
                    txtNroMot.setText("");
				}else if(!isInteger(txtNroChas.getText())) {
					JOptionPane.showMessageDialog(null, "NRO. CHASIS: Ingrese solo números enteros", "Error", JOptionPane.ERROR_MESSAGE);
                    txtNroChas.setText("");
				}else if(!isInteger(txtNroPlazas.getText())&&cmbxTipo.getSelectedItem().equals("Autobus")) {
					JOptionPane.showMessageDialog(null, "NRO. PLAZAS: Ingrese solo números enteros", "Error", JOptionPane.ERROR_MESSAGE);
                    txtNroPlazas.setText("");
				}else {
				vehi.crearVehiculo((String) cmbxTipo.getSelectedItem(), txtMatricula.getText(), txtModelo.getText(), txtAño.getText(), txtPotencia.getText(),
						txtNroLicencia.getText(), txtMarca.getText(), txtNroMot.getText(), txtNroChas.getText(), txtNroPlazas.getText(), txtColor.getText());
				JOptionPane.showMessageDialog(null, "Vehiculo creado con exito!", "Exito", JOptionPane.OK_OPTION);
				cmbxTipo.setSelectedItem("Taxi");
				txtMatricula.setText("");
				txtModelo.setText("");
				txtAño.setText("");
				txtPotencia.setText("");
				txtNroLicencia.setText("");
				txtMarca.setText("");
				txtNroMot.setText("");
				txtNroChas.setText("");
				txtNroPlazas.setText("");
				txtColor.setText("");
				
				
				}
			}
		});
		btnGuardar.setBounds(463, 299, 116, 38);
		panel.add(btnGuardar);
		
		cmbxTipo = new JComboBox<String>();
		cmbxTipo.setBounds(83, 31, 181, 29);
		panel.add(cmbxTipo);
		cmbxTipo.addItem("Taxi");
		cmbxTipo.addItem("Autobus");
		cmbxTipo.setSelectedItem("Taxi");
		cmbxTipo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(cmbxTipo.getSelectedItem().equals("Taxi")) {
					lblNroLicencia.setEnabled(true);
					txtNroLicencia.setEnabled(true);
					lblNroPlazas.setEnabled(false);
		            txtNroPlazas.setEnabled(false);
		            txtNroPlazas.setText("");
				}else if (cmbxTipo.getSelectedItem().equals("Autobus")) {
					lblNroPlazas.setEnabled(true);
		            txtNroPlazas.setEnabled(true);	
		            lblNroLicencia.setEnabled(false);
					txtNroLicencia.setEnabled(false);
					txtNroLicencia.setText("");
		            }
			}
		});
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(27, 38, 46, 14);
		panel.add(lblTipo);
		
		JLabel lblNroMotor = new JLabel("Nro. Motor:");
		lblNroMotor.setBounds(304, 89, 73, 14);
		panel.add(lblNroMotor);
		
		txtNroMot = new JTextField();
		txtNroMot.setColumns(10);
		txtNroMot.setBounds(373, 82, 171, 29);
		panel.add(txtNroMot);
		
		lblNroLicencia = new JLabel("Nro. Licencia:");
		lblNroLicencia.setBounds(27, 272, 88, 14);
		panel.add(lblNroLicencia);
		
		lblNroPlazas = new JLabel("Nro. Plazas:");
		lblNroPlazas.setBounds(27, 226, 73, 14);
		panel.add(lblNroPlazas);
		lblNroPlazas.setEnabled(false);
       
		
		txtNroLicencia = new JTextField();
		txtNroLicencia.setColumns(10);
		txtNroLicencia.setBounds(105, 265, 159, 29);
		panel.add(txtNroLicencia);
		 
		
		txtNroPlazas = new JTextField();
		txtNroPlazas.setColumns(10);
		txtNroPlazas.setBounds(93, 219, 171, 29);
		panel.add(txtNroPlazas);
		txtNroPlazas.setEnabled(false);
        txtNroPlazas.setText("");
        
        JLabel lblMatricula = new JLabel("Matricula:");
        lblMatricula.setBounds(27, 89, 73, 14);
        panel.add(lblMatricula);
        
        txtMatricula = new JTextField();
        txtMatricula.setColumns(10);
        txtMatricula.setBounds(83, 82, 181, 29);
        panel.add(txtMatricula);
        
        JLabel lblColor = new JLabel("Color:");
        lblColor.setBounds(304, 226, 73, 14);
        panel.add(lblColor);
        
        txtColor = new JTextField();
        txtColor.setColumns(10);
        txtColor.setBounds(363, 219, 181, 29);
        panel.add(txtColor);
        
		JLabel lblTitulo = new JLabel("Carga de vehiculo");
		lblTitulo.setForeground(Color.BLUE);
		lblTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblTitulo.setBounds(266, 13, 175, 25);
		contentPane.add(lblTitulo);
		
		lblVolver = new JLabel("<-Volver al menu");
		lblVolver.setForeground(new Color(0, 0, 160));
		lblVolver.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		lblVolver.setBounds(10, 21, 115, 14);
		contentPane.add(lblVolver);
		lblVolver.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Aseguradora ase = new Aseguradora();
				ase.setVisible(true);
                dispose();
			}
		});
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
