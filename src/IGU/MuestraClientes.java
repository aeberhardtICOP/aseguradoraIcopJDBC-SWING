package IGU;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Model.Cliente;
import Service.ClienteService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class MuestraClientes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JComboBox<String> cmbGenero;
	private JTable tblClientes;
	private DefaultTableModel model;
	private JRadioButton rdBtnMasculino;
	private JRadioButton rdBtnFemenino;
	private JRadioButton rdBtnOtro;
	private ButtonGroup buttonGroup;
	private JTextField txtNombre;
	private JTextField txtMail;
	private JTextField txtDomicilio;
	private JTextField TxtApellido;
	private JTextField txtDni;
	private JTextField txtTelefono;
	private ClienteService cli;
	private JButton btnEditar;
	private JButton btnBaja;
	
	public MuestraClientes(ClienteService cliente) {
		this.cli = cliente;
		 setTitle("Ver clientes");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 960, 586);
	        setResizable(false);
	        getContentPane().setLayout(null);

	        JPanel panel = new JPanel();
	        panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
	        panel.setBounds(33, 35, 878, 478);
	        getContentPane().add(panel);
	        panel.setLayout(null);
	        
	        JLabel lblNombre = new JLabel("Nombre:");
	        lblNombre.setBounds(35, 37, 58, 14);
	        panel.add(lblNombre);
	        
	        JLabel lblMail = new JLabel("Mail:");
	        lblMail.setBounds(35, 87, 46, 14);
	        panel.add(lblMail);
	        
	        JLabel lblDni = new JLabel("Dni:");
	        lblDni.setBounds(343, 87, 46, 14);
	        panel.add(lblDni);
	        
	        JLabel lblDomicilio = new JLabel("Domicilio:");
	        lblDomicilio.setBounds(30, 139, 73, 14);
	        panel.add(lblDomicilio);
	        
	        JLabel lblApellido = new JLabel("Apellido:");
	        lblApellido.setBounds(343, 37, 64, 14);
	        panel.add(lblApellido);
	        
	        JLabel lblDomicilio_1 = new JLabel("Telefono:");
	        lblDomicilio_1.setBounds(343, 139, 64, 14);
	        panel.add(lblDomicilio_1);
	        
	        JLabel lblGenero = new JLabel("Genero:");
	        lblGenero.setBounds(657, 34, 46, 14);
	        panel.add(lblGenero);
	        
	        rdBtnMasculino = new JRadioButton("Masculino");
	        rdBtnMasculino.setBounds(707, 30, 109, 23);
	        panel.add(rdBtnMasculino);
	        
	        rdBtnFemenino = new JRadioButton("Femenino");
	        rdBtnFemenino.setBounds(707, 55, 109, 23);
	        panel.add(rdBtnFemenino);
	        
	        rdBtnOtro = new JRadioButton("Otro");
	        rdBtnOtro.setBounds(707, 79, 109, 23);
	        panel.add(rdBtnOtro);
	        buttonGroup = new ButtonGroup();
			buttonGroup.add(rdBtnMasculino);
			buttonGroup.add(rdBtnFemenino);
			buttonGroup.add(rdBtnOtro);
	        
	        JButton btnFiltrar = new JButton("Filtrar");
	        btnFiltrar.addActionListener(new ActionListener() {
	        	@Override
	        	public void actionPerformed(ActionEvent e) {
	        		System.out.println("apreta");
	        		vaciarTabla(model.getRowCount());
	        		llenarTabla();
	        		
	        	}
	        });
	        btnFiltrar.setBounds(693, 133, 101, 26);
	        panel.add(btnFiltrar);
	        
	        JScrollPane scrollPane = new JScrollPane();
	        scrollPane.setBounds(35, 191, 812, 261);
	        panel.add(scrollPane);
	        
	        tblClientes = new JTable();
	        model = new DefaultTableModel(){
	        	public boolean isCellEditable(int row, int column) {
	        		return false;
	        	}
	        };
	        tblClientes.setModel(model);
	        tblClientes.setRowHeight(30);
	        model.addColumn("ID");
	        model.addColumn("NOMBRE");
	        model.addColumn("APELLIDO");
	        model.addColumn("MAIL");
	        model.addColumn("GENERO");
	        model.addColumn("DNI");
	        model.addColumn("DOMICILIO");
	        model.addColumn("TELEFONO");
	        model.addColumn("");
	        model.addColumn("");
	        
	        tblClientes.setDefaultRenderer(Object.class, new RenderTabla());
	        tblClientes.getColumnModel().getColumn(0).setPreferredWidth(34);
	        tblClientes.getColumnModel().getColumn(1).setPreferredWidth(82);
	        tblClientes.getColumnModel().getColumn(2).setPreferredWidth(74);
	        tblClientes.getColumnModel().getColumn(3).setPreferredWidth(99);
	        tblClientes.getColumnModel().getColumn(4).setPreferredWidth(54);
	        tblClientes.getColumnModel().getColumn(5).setPreferredWidth(53);
	        tblClientes.getColumnModel().getColumn(6).setPreferredWidth(101);
	        scrollPane.setViewportView(tblClientes);
	        tblClientes.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		int column = tblClientes.getColumnModel().getColumnIndexAtX(e.getX());
	        		int row = e.getY()/tblClientes.getRowHeight();
	        		if(row < tblClientes.getRowCount() && row >= 0 && column < tblClientes.getColumnCount() && column >= 0) {
	        			Object value = tblClientes.getValueAt(row, column);
	        			if(value instanceof JButton) {
	        				((JButton)value).doClick();
	        				JButton btn = (JButton) value;
	        				if(btn.getName().equals("E")) {
	        					int id = (int) tblClientes.getValueAt(row, 0);
	                           
	                            EditarCliente edi = new EditarCliente(id, nombre, apellido, mail, genero, dni, domicilio, telefono, cli);
	                            edi.setVisible(true);
	                            tblClientes.revalidate();
	                   		 	tblClientes.repaint();
	        				}else if(btn.getName().equals("B")) {
	        					 int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea dar de baja al cliente?", "Advertencia", JOptionPane.YES_NO_OPTION);
	        					 if (respuesta == JOptionPane.YES_OPTION) {
	        				           cli.baja((int) tblClientes.getValueAt(row, 0));
	        					 } else {  
	        				            
	        				     		}
	        				}
	        			}
	        		}
	        	}
	        });
	        
	        txtNombre = new JTextField();
	        txtNombre.setBounds(87, 31, 163, 26);
	        panel.add(txtNombre);
	        txtNombre.setColumns(10);
	        
	        txtMail = new JTextField();
	        txtMail.setColumns(10);
	        txtMail.setBounds(87, 84, 163, 26);
	        panel.add(txtMail);
	        
	        txtDomicilio = new JTextField();
	        txtDomicilio.setColumns(10);
	        txtDomicilio.setBounds(87, 136, 163, 26);
	        panel.add(txtDomicilio);
	        
	        TxtApellido = new JTextField();
	        TxtApellido.setColumns(10);
	        TxtApellido.setBounds(394, 34, 163, 26);
	        panel.add(TxtApellido);
	        
	        txtDni = new JTextField();
	        txtDni.setColumns(10);
	        txtDni.setBounds(394, 75, 163, 26);
	        panel.add(txtDni);
	        
	        txtTelefono = new JTextField();
	        txtTelefono.setColumns(10);
	        txtTelefono.setBounds(394, 136, 163, 26);
	        panel.add(txtTelefono);
	        
	        JLabel lblTitulo = new JLabel("Filtrar clientes:");
	        lblTitulo.setForeground(Color.BLUE);
	        lblTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 22));
	        lblTitulo.setBounds(407, 11, 143, 25);
	        getContentPane().add(lblTitulo);
			
			JLabel lblVolver = new JLabel("<-Volver al menu");
			lblVolver.setBounds(23, 10, 115, 14);
			getContentPane().add(lblVolver);
			lblVolver.setForeground(new Color(0, 0, 160));
			lblVolver.setFont(new Font("Times New Roman", Font.ITALIC, 13));
			lblVolver.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					Aseguradora ase = new Aseguradora();
					ase.setVisible(true);
	                dispose();
					
				}
			});
			btnEditar = new JButton("Editar");
			btnEditar.setName("E");
			
			btnBaja = new JButton("Baja");
			btnBaja.setName("B");
	}
	public void llenarTabla() {
		System.out.println("HOLA");
		
		HashMap<Integer, Cliente>res=cli.filtrarClientes(txtNombre.getText(), TxtApellido.getText(), txtMail.getText(), txtDni.getText(), txtDomicilio.getText(), txtTelefono.getText(), obtenerSeleccion(buttonGroup));
		
		for (Map.Entry<Integer, Cliente> entry : res.entrySet()) {
			Object[] fila = new Object[10];
			final int id=entry.getKey();
			final Cliente cliente=entry.getValue();
			fila[0]=id;
			System.out.println(id);
			fila[1]=cliente.getNombre();
			fila[2]=cliente.getApellido();
			fila[3]=cliente.getMail();
			fila[4]=cliente.getGenero();
			fila[5]=cliente.getDni();
			fila[6]=cliente.getDomicilio();
			fila[7]=cliente.getTelefono();
	        fila[8] = btnEditar;
	        fila[9] = btnBaja;
			model.addRow(fila);
		}
		 tblClientes.revalidate();
		 tblClientes.repaint();
	}
	public void vaciarTabla(int cantFilas) {
		for (int i = cantFilas - 1; i >= 0; i--) {
	        model.removeRow(i);
	    }
	}
	 private static String obtenerSeleccion(ButtonGroup buttonGroup) {
	        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
	            AbstractButton button = buttons.nextElement();
	            if (button.isSelected()) {
	                return button.getText();
	            }
	        }
	        return "";
	    }
}
