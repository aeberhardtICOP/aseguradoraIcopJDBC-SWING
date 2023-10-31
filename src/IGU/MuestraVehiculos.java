package IGU;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Model.Autobus;
import Model.Taxi;
import Model.Vehiculo;
import Service.VehiculoService;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class MuestraVehiculos extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTable tblVehiculos;
    private DefaultTableModel model;
    private JRadioButton rdBtnTaxi;
    private JRadioButton rdBtnAutobus;
    private ButtonGroup buttonGroup;
    private JTextField txtMatricula;
    private JTextField txtModelo;
    private JTextField txtMarca;
    private JTextField txtAnio;
    private JTextField txtColor;
    private VehiculoService vehiculo;
    private JButton btnVerDatos;
    private JButton btnEditar;
    private JButton btnBaja;
	private JRadioButton rdBtnVehicul;

    public MuestraVehiculos(final VehiculoService vehiculo) {
        this.vehiculo = vehiculo;
        setTitle("Ver vehículos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 960, 586);
        setResizable(false);
        getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
        panel.setBounds(33, 35, 878, 478);
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblMatricula = new JLabel("Matrícula:");
        lblMatricula.setBounds(35, 37, 58, 14);
        panel.add(lblMatricula);

        JLabel lblModelo = new JLabel("Modelo:");
        lblModelo.setBounds(35, 87, 46, 14);
        panel.add(lblModelo);

        JLabel lblMarca = new JLabel("Marca:");
        lblMarca.setBounds(343, 87, 46, 14);
        panel.add(lblMarca);

        JLabel lblAnio = new JLabel("Año:");
        lblAnio.setBounds(343, 139, 73, 14);
        panel.add(lblAnio);

        JLabel lblColor = new JLabel("Color:");
        lblColor.setBounds(343, 37, 64, 14);
        panel.add(lblColor);

        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(657, 34, 46, 14);
        panel.add(lblTipo);

        rdBtnTaxi = new JRadioButton("Taxi");
        rdBtnTaxi.setBounds(707, 30, 109, 23);
        panel.add(rdBtnTaxi);

        rdBtnAutobus = new JRadioButton("Autobus");
        rdBtnAutobus.setBounds(707, 55, 109, 23);
        panel.add(rdBtnAutobus);
        
        rdBtnVehicul = new JRadioButton("Vehiculo");
        rdBtnVehicul.setBounds(707, 81, 109, 23);
        panel.add(rdBtnVehicul);
        rdBtnVehicul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonGroup.clearSelection();
            }
        });

        buttonGroup = new ButtonGroup();
        buttonGroup.add(rdBtnTaxi);
        buttonGroup.add(rdBtnAutobus);
        buttonGroup.add(rdBtnVehicul);

        JButton btnFiltrar = new JButton("Filtrar");
        btnFiltrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 vaciarTabla(model.getRowCount());
		         llenarTabla();
			}
		});
        
        btnFiltrar.setBounds(693, 133, 101, 26);
        panel.add(btnFiltrar);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(35, 191, 812, 261);
        panel.add(scrollPane);

        tblVehiculos = new JTable();
        model = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblVehiculos.setModel(model);
        tblVehiculos.setRowHeight(30);
        model.addColumn("ID");
        model.addColumn("MARCA");
        model.addColumn("MODELO");
        model.addColumn("AÑO");
        model.addColumn("COLOR");
        model.addColumn("MATRICULA");
        model.addColumn("TIPO");
        model.addColumn("");
        model.addColumn("");
        model.addColumn("");

        tblVehiculos.setDefaultRenderer(Object.class, new RenderTabla());
        tblVehiculos.getColumnModel().getColumn(0).setPreferredWidth(34);
        tblVehiculos.getColumnModel().getColumn(1).setPreferredWidth(82);
        tblVehiculos.getColumnModel().getColumn(2).setPreferredWidth(74);
        tblVehiculos.getColumnModel().getColumn(3).setPreferredWidth(99);
        tblVehiculos.getColumnModel().getColumn(4).setPreferredWidth(54);
        tblVehiculos.getColumnModel().getColumn(5).setPreferredWidth(90);
        tblVehiculos.getColumnModel().getColumn(6).setPreferredWidth(75);
        scrollPane.setViewportView(tblVehiculos);
        tblVehiculos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int column = tblVehiculos.getColumnModel().getColumnIndexAtX(e.getX());
                int row = e.getY() / tblVehiculos.getRowHeight();
                if (row < tblVehiculos.getRowCount() && row >= 0 && column < tblVehiculos.getColumnCount() && column >= 0) {
                    Object value = tblVehiculos.getValueAt(row, column);
                    if (value instanceof JButton) {
                        ((JButton) value).doClick();
                        JButton btn = (JButton) value;
                        if (btn.getName().equals("V")) {
                            int id = (int) tblVehiculos.getValueAt(row, 0);
                           // VerDatosVehiculo verDatos = new VerDatosVehiculo(id, vehiculo);
                            //verDatos.setVisible(true);
                        } else if (btn.getName().equals("E")) {
                            int id = (int) tblVehiculos.getValueAt(row, 0);
                           
                            EditarVehiculo editar = new EditarVehiculo(id, vehiculo);
                            editar.setVisible(true);
                        } else if (btn.getName().equals("B")) {
                            int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea dar de baja al vehículo?", "Advertencia", JOptionPane.YES_NO_OPTION);
                            if (respuesta == JOptionPane.YES_OPTION) {
                                //vehiculo.baja((int) tblVehiculos.getValueAt(row, 0));
                            }
                        }
                    }
                }
            }
        });

        txtMatricula = new JTextField();
        txtMatricula.setBounds(87, 31, 163, 26);
        panel.add(txtMatricula);
        txtMatricula.setColumns(10);

        txtModelo = new JTextField();
        txtModelo.setColumns(10);
        txtModelo.setBounds(87, 84, 163, 26);
        panel.add(txtModelo);

        txtMarca = new JTextField();
        txtMarca.setColumns(10);
        txtMarca.setBounds(394, 81, 163, 26);
        panel.add(txtMarca);

        txtAnio = new JTextField();
        txtAnio.setColumns(10);
        txtAnio.setBounds(394, 133, 163, 26);
        panel.add(txtAnio);

        txtColor = new JTextField();
        txtColor.setColumns(10);
        txtColor.setBounds(394, 31, 163, 26);
        panel.add(txtColor);

        JLabel lblTitulo = new JLabel("Filtrar vehículos:");
        lblTitulo.setForeground(Color.BLUE);
        lblTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        lblTitulo.setBounds(407, 11, 143, 25);
        getContentPane().add(lblTitulo);

        JLabel lblVolver = new JLabel("<-Volver al menú");
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

        btnVerDatos = new JButton("Ver datos");
        btnVerDatos.setName("V");

        btnEditar = new JButton("Editar");
        btnEditar.setName("E");

        btnBaja = new JButton("Baja");
        btnBaja.setName("B");
    }

    public void llenarTabla() {
        HashMap<Integer, Vehiculo> res = vehiculo.filtrarVehiculos(txtMatricula.getText(), txtModelo.getText(), txtMarca.getText(), obtenerSeleccion(buttonGroup),
                txtAnio.getText(), txtColor.getText());
        
        for (Map.Entry<Integer, Vehiculo> entry : res.entrySet()) {
            Object[] fila = new Object[10];
            final int id = entry.getKey();
            String tipo = null;
            final Vehiculo vehiculo = entry.getValue();
            if (vehiculo instanceof Taxi) {
            	tipo="Taxi";
            }else if(vehiculo instanceof Autobus) {
            	tipo="Autobus";
            }
            fila[0] = id;
            fila[1] = vehiculo.getMarca();
            fila[2] = vehiculo.getModelo();
            fila[3] = vehiculo.getAño();
            fila[4] = vehiculo.getColor();
            fila[5] = vehiculo.getMatricula();
            fila[6] = tipo;
            fila[7] = btnVerDatos;
            fila[8] = btnEditar;
            fila[9] = btnBaja;
            model.addRow(fila);
        }
        tblVehiculos.revalidate();
        tblVehiculos.repaint();
    }

    public void vaciarTabla(int cantFilas) {
        for (int i = cantFilas - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    private static String obtenerSeleccion(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements(); ) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return "";
    }
}
