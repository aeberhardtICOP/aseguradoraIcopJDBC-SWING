package IGU;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Model.Taxi;
import Model.Vehiculo;
import Model.Autobus;
import Service.VehiculoService;


public class EditarVehiculo extends JFrame {
    private VehiculoService vehi;
    private JTextField txtMatricula;
    private JTextField txtModelo;
    private JTextField txtPotencia;
    private JTextField txtAño;
    private JTextField txtNroChas;
    private JTextField txtNroMot;
    private JComboBox<String> cmbxTipo;
    private JTextField txtNroLicencia;
    private JTextField txtMarca;
    private JTextField txtColor;
    private JButton btnGuardar;
    private JLabel lblVolver;
	private JLabel lblNroLicencia;
	private JTextField txtNroPlaza;
	private JLabel lblNroPlazas;
	private Vehiculo v;

    public EditarVehiculo(final int id, final VehiculoService vehi) {
    	v=vehi.buscarVehiculo(id);
        setTitle("Editar Vehículo");
        setBounds(100, 100, 730, 472);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
       
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder((Border) new LineBorder(new Color(0, 0, 0), 2, true));
        panel.setBounds(26, 50, 649, 373);
        contentPane.add(panel);

        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(27, 38, 46, 14);
        panel.add(lblTipo);

        cmbxTipo = new JComboBox<String>();
        cmbxTipo.setBounds(83, 31, 181, 29);
        panel.add(cmbxTipo);
        cmbxTipo.addItem("Taxi");
        cmbxTipo.addItem("Autobus");
        cmbxTipo.addActionListener(new ActionListener() {
			
        	public void actionPerformed(ActionEvent e) {
           	 if (cmbxTipo.getSelectedItem().equals("Taxi")) {
                    lblNroLicencia.setEnabled(true);
                    txtNroLicencia.setEnabled(true);
                    lblNroPlazas.setEnabled(false);
                    txtNroPlaza.setEnabled(false);
                    txtNroPlaza.setText("");
                } else if (cmbxTipo.getSelectedItem().equals("Autobus")) {
                    lblNroPlazas.setEnabled(true);
                    txtNroPlaza.setEnabled(true);
                    lblNroLicencia.setEnabled(false);
                    txtNroLicencia.setEnabled(false);
                    txtNroLicencia.setText("");
                }else {
                	System.out.println("??");
                }
        	}
		});
        

        JLabel lblMatricula = new JLabel("Matrícula:");
        lblMatricula.setBounds(27, 82, 73, 14);
        panel.add(lblMatricula);

        txtMatricula = new JTextField();
        txtMatricula.setColumns(10);
        txtMatricula.setBounds(83, 75, 181, 29);
        panel.add(txtMatricula);
        txtMatricula.setText(v.getMatricula());

        JLabel lblModelo = new JLabel("Modelo:");
        lblModelo.setBounds(27, 134, 46, 14);
        panel.add(lblModelo);

        txtModelo = new JTextField();
        txtModelo.setColumns(10);
        txtModelo.setBounds(83, 127, 181, 29);
        panel.add(txtModelo);
        txtModelo.setText(v.getModelo());

        JLabel lblAño = new JLabel("Año:");
        lblAño.setBounds(27, 179, 73, 14);
        panel.add(lblAño);

        txtAño = new JTextField();
        txtAño.setColumns(10);
        txtAño.setBounds(83, 172, 181, 29);
        panel.add(txtAño);
        txtAño.setText(Integer.toString(v.getAño()));

        JLabel lblPotencia = new JLabel("Potencia (CV):");
        lblPotencia.setBounds(304, 179, 88, 14);
        panel.add(lblPotencia);

        txtPotencia = new JTextField();
        txtPotencia.setColumns(10);
        txtPotencia.setBounds(402, 172, 142, 29);
        panel.add(txtPotencia);
        txtPotencia.setText(Integer.toString(v.getPotenciaCV()));

        lblNroLicencia = new JLabel("Nro. Licencia:");
        lblNroLicencia.setBounds(27, 226, 88, 14);
        panel.add(lblNroLicencia);

        txtNroLicencia = new JTextField();
        txtNroLicencia.setColumns(10);
        txtNroLicencia.setBounds(93, 219, 171, 29);
        panel.add(txtNroLicencia);
        

        JLabel lblMarca = new JLabel("Marca:");
        lblMarca.setBounds(304, 38, 58, 14);
        panel.add(lblMarca);

        txtMarca = new JTextField();
        txtMarca.setColumns(10);
        txtMarca.setBounds(363, 31, 181, 29);
        panel.add(txtMarca);
        txtMarca.setText(v.getMarca());

        JLabel lblNroMotor = new JLabel("Nro. Motor:");
        lblNroMotor.setBounds(304, 89, 73, 14);
        panel.add(lblNroMotor);

        txtNroMot = new JTextField();
        txtNroMot.setColumns(10);
        txtNroMot.setBounds(373, 82, 171, 29);
        panel.add(txtNroMot);
        txtNroMot.setText(Integer.toString(v.getNro_motor()));

        JLabel lblNroChasis = new JLabel("Nro. Chasis:");
        lblNroChasis.setBounds(304, 134, 73, 14);
        panel.add(lblNroChasis);

        txtNroChas = new JTextField();
        txtNroChas.setColumns(10);
        txtNroChas.setBounds(363, 127, 181, 29);
        panel.add(txtNroChas);
        txtNroChas.setText(Integer.toString(v.getNro_chasis()));

        JLabel lblColor = new JLabel("Color:");
        lblColor.setBounds(304, 226, 73, 14);
        panel.add(lblColor);

        txtColor = new JTextField();
        txtColor.setColumns(10);
        txtColor.setBounds(363, 219, 181, 29);
        panel.add(txtColor);
        txtColor.setText(v.getColor());

        btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isInteger(txtAño.getText())) {
                    JOptionPane.showMessageDialog(null, "AÑO: Ingrese solo números enteros", "Error", JOptionPane.ERROR_MESSAGE);
                    txtAño.setText("");
                } else if (!isInteger(txtPotencia.getText())) {
                    JOptionPane.showMessageDialog(null, "POTENCIA(CV): Ingrese solo números enteros", "Error", JOptionPane.ERROR_MESSAGE);
                    txtPotencia.setText("");
                } else if (!isInteger(txtNroLicencia.getText()) && cmbxTipo.getSelectedItem().equals("Taxi")) {
                    JOptionPane.showMessageDialog(null, "NRO. LICENCIA: Ingrese solo números enteros", "Error", JOptionPane.ERROR_MESSAGE);
                    txtNroLicencia.setText("");
                } else if (!isInteger(txtNroMot.getText())) {
                    JOptionPane.showMessageDialog(null, "NRO. MOTOR: Ingrese solo números enteros", "Error", JOptionPane.ERROR_MESSAGE);
                    txtNroMot.setText("");
                } else if (!isInteger(txtNroChas.getText())) {
                    JOptionPane.showMessageDialog(null, "NRO. CHASIS: Ingrese solo números enteros", "Error", JOptionPane.ERROR_MESSAGE);
                    txtNroChas.setText("");
                } else if (!isInteger(txtNroPlaza.getText()) && cmbxTipo.getSelectedItem().equals("Autobus")) {
                    JOptionPane.showMessageDialog(null, "NRO. PLAZAS: Ingrese solo números enteros", "Error", JOptionPane.ERROR_MESSAGE);
                    txtNroPlaza.setText("");
                } else {
                	String nroLicencia=null;
                	String nroPlazas=null;
                	if(v instanceof Taxi) {
                		nroLicencia=txtNroLicencia.getText();
                		nroPlazas=null;
                	}else if(v instanceof Autobus) {
                		nroPlazas=txtNroPlaza.getText();
                		nroLicencia=null;
                	}
                    vehi.editarVehiculo(Integer.toString(id), (String)cmbxTipo.getSelectedItem(), txtMatricula.getText(), txtModelo.getText(), txtAño.getText(), txtPotencia.getText(),
                			nroLicencia, txtMarca.getText(), txtNroMot.getText(), txtNroChas.getText(), nroPlazas, txtColor.getText());
                    JOptionPane.showMessageDialog(null, "Vehículo editado con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }
            }
        });
        btnGuardar.setBounds(463, 299, 116, 38);
        panel.add(btnGuardar);
        
        txtNroPlaza = new JTextField();
        txtNroPlaza.setColumns(10);
        txtNroPlaza.setBounds(105, 271, 159, 29);
        panel.add(txtNroPlaza);
        
        lblNroPlazas = new JLabel("Nro. Plazas:");
        lblNroPlazas.setBounds(27, 278, 88, 14);
        panel.add(lblNroPlazas);

        lblVolver = new JLabel("<- Volver al menú");
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
        {
        	if(v instanceof Taxi){
        		Taxi tax = (Taxi) v;
        		txtNroLicencia.setText(Integer.toString(tax.getNroLicencia()));
        		txtNroPlaza.setText("");
        		cmbxTipo.setSelectedItem("Taxi");
        	}else if(v instanceof Autobus){
        		Autobus bus = (Autobus) v;
        		txtNroPlaza.setText(Integer.toString(bus.getNroPlazas()));
        		txtNroLicencia.setText("");
        		cmbxTipo.setSelectedItem("Autobus");
        	}
        }

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
