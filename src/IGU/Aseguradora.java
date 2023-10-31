package IGU;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Service.ClienteService;
import Service.VehiculoService;

import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.DropMode;

public class Aseguradora extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	ClienteService cli;
	VehiculoService vehi;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aseguradora frame = new Aseguradora();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Aseguradora() {
		this.cli = new ClienteService();
		this.cli.traerClientesMemoria();
		this.vehi = new VehiculoService();
		this.vehi.traerVehiculos();
		setTitle("Aseguradora - principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 462);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnuCliente = new JMenu("Cliente");
		menuBar.add(mnuCliente);
		
		JMenuItem itmCcargarCliente = new JMenuItem("Nuevo cliente");
		mnuCliente.add(itmCcargarCliente);
		itmCcargarCliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CargaCliente cli = new CargaCliente();
				cli.setVisible(true);
				dispose();
				
			}
		});
		JMenuItem itmVerClientes = new JMenuItem("Ver clientes");
		mnuCliente.add(itmVerClientes);
		itmVerClientes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MuestraClientes mCli = new MuestraClientes(cli);
				mCli.setVisible(true);
				dispose();
				
			}
		});
		
		JMenu mnVehiculo = new JMenu("Vehiculo");
		menuBar.add(mnVehiculo);
		
		JMenuItem itmNuevoVehiculo = new JMenuItem("Nuevo vehiculo");
		mnVehiculo.add(itmNuevoVehiculo);
		itmNuevoVehiculo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					CargaVehiculo ve = new CargaVehiculo(vehi);
					ve.setVisible(true);
					dispose();

			}
		});
		
		JMenuItem itmVerVehiculos = new JMenuItem("Ver vehiculos");
		mnVehiculo.add(itmVerVehiculos);
		itmVerVehiculos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MuestraVehiculos veh = new MuestraVehiculos(vehi);
				veh.setVisible(true);
				dispose();
			}
		});
		
		JMenu mnuPoliza = new JMenu("Poliza");
		menuBar.add(mnuPoliza);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Generar poliza");
		mnuPoliza.add(mntmNewMenuItem);
		
		JMenuItem itmVerPolizas = new JMenuItem("Ver polizas");
		mnuPoliza.add(itmVerPolizas);
		
		JMenu mnuCuota = new JMenu("Cuota");
		menuBar.add(mnuCuota);
		
		JMenuItem itmPagarCuota = new JMenuItem("Pagar cuota");
		mnuCuota.add(itmPagarCuota);
		
		JMenu mnuStats = new JMenu("Estadisticas");
		menuBar.add(mnuStats);
		
		JMenu mnuEstPolizas = new JMenu("Polizas por..");
		mnuStats.add(mnuEstPolizas);
		
		JMenuItem itmPolizasCobertura = new JMenuItem("Cobertura");
		mnuEstPolizas.add(itmPolizasCobertura);
		
		JMenuItem itmPolizasMPago = new JMenuItem("Formas de pago");
		mnuEstPolizas.add(itmPolizasMPago);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		ImageIcon icon = new ImageIcon("E:\\ICOP\\3er año 2023\\Programacion\\Java-eclipse-EE\\Login\\img\\ICOP.png");
		JLabel lblIconIcop = new JLabel(icon);
		panel.add(lblIconIcop);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JTextArea txtArea = new JTextArea();
		txtArea.setText("*PROXIMOS DATOS ESTADISTICOS*");
		txtArea.setEditable(false);
		txtArea.setDropMode(DropMode.INSERT);
		panel_2.add(txtArea);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnCerrarSesion = new JButton("Cerrar sesion");
		panel_1.add(btnCerrarSesion);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel_1.add(btnNewButton_1);
	}
	public ClienteService getClienteService() {
		return cli;
		
	}
}
