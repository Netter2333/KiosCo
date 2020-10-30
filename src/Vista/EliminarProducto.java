package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Sistema.ControladorProducto;
import Sistema.Producto;

import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.Checkbox;
import javax.swing.UIManager;

public class EliminarProducto extends JFrame {

	private JPanel contentPane;
	private JTextField CodigoBarra;
	private JTextField Prod;
	private JTextField CatProd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminarProducto frame = new EliminarProducto();
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
	public EliminarProducto() {
		setTitle("Eliminar Producto");
		setResizable(false);
		
		setBounds(100, 100, 468, 327);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Table.selectionBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbCodProd = new JLabel("Ingrese el codigo de Barra:");
		lbCodProd.setBounds(10, 11, 178, 39);
		contentPane.add(lbCodProd);
		
		CodigoBarra = new JTextField();
		CodigoBarra.setBounds(172, 20, 245, 20);
		contentPane.add(CodigoBarra);
		CodigoBarra.setColumns(10);
		//////////////////////////////////
		
		
		////////////////////////////////////
		JButton btnBuscarProd = new JButton("BuscarProducto");
		btnBuscarProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
					if(CodigoBarra.getText().equalsIgnoreCase("")) {
						JOptionPane.showMessageDialog(null, "Debes llenar el campo de CODIGO DE BARRA","Error de entrada",JOptionPane.WARNING_MESSAGE);
					}
					else {
						try {
							int codigo=Integer.parseInt(CodigoBarra.getText());
							Producto respuesta=ControladorProducto.getContr().buscarProducto(codigo);
							if (respuesta==null) {
								JOptionPane.showMessageDialog(null,"el codigo ingresado no corresponde a ningún producto","Dato invalido",JOptionPane.WARNING_MESSAGE);
								Prod.setText("");	
								CatProd.setText("");
								
							}
							else {
								Prod.setText(respuesta.getDescripcion());	
								CatProd.setText(respuesta.getCategoria());
								
								
								
								
							}
						}
					catch(NumberFormatException ex)
					{
						JOptionPane.showMessageDialog(null,"no ingrese caracteres en el CODIGO DE BARRA", "Error caracter ingresado erroneamente",JOptionPane.ERROR_MESSAGE);
					}
		
					}
				}
			
		});
		btnBuscarProd.setBounds(136, 61, 161, 23);
		contentPane.add(btnBuscarProd);
		
		JLabel lbProd = new JLabel("Producto:");
		lbProd.setBounds(10, 116, 115, 20);
		contentPane.add(lbProd);
		
		Prod = new JTextField();
		Prod.setBounds(77, 116, 245, 20);
		contentPane.add(Prod);
		Prod.setColumns(10);
		Prod.setEditable(false);
		
		Checkbox checkbox = new Checkbox("Confirmo la Eliminaci\u00F3n de este Producto");
		checkbox.setState(false);
		checkbox.setBounds(10, 178, 245, 35);
		contentPane.add(checkbox);
		
		
		JLabel lbCatProd = new JLabel("Categor\u00EDa:");
		lbCatProd.setBounds(10, 158, 65, 14);
		contentPane.add(lbCatProd);
		
		
		CatProd = new JTextField();
		CatProd.setBounds(77, 155, 245, 20);
		contentPane.add(CatProd);
		CatProd.setColumns(10);
		CatProd.setEditable(false);
		
		JButton btnEliminarProd = new JButton("Eliminar Producto");
		btnEliminarProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				if(CodigoBarra.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Debe buscar un producto primero", "Formulario incompleto",JOptionPane.WARNING_MESSAGE);
				}
				else {
					if(checkbox.getState()==true) {		
						int codigo=Integer.parseInt(CodigoBarra.getText());
						boolean respuesta= ControladorProducto.getContr().eliminarProducto(codigo);
						if(respuesta==true)  {
							JOptionPane.showMessageDialog(null,"El producto se ha Eliminado Correctamente","Producto Creado",JOptionPane.INFORMATION_MESSAGE);
							CodigoBarra.setText("");
							CatProd.setText("");
							Prod.setText("");
							checkbox.setState(false);
							
						
						}
						else {
							JOptionPane.showMessageDialog(null, "El producto No se ha podido eliminar","Producto NO eliminado",JOptionPane.ERROR_MESSAGE);
							CodigoBarra.setText("");
							Prod.setText("");
							Prod.setText("");
							checkbox.setState(false);
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Debe CONFIRMAR la eliminación del producto","Solicitud denegada",JOptionPane.ERROR_MESSAGE);
					}
					
					}
				}
				catch(NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(null,"no ingrese caracteres en el campo de CODIGO DE BARRA", "Error caracter ingresado erroneamente",JOptionPane.ERROR_MESSAGE);
				}


			
			
			}
			
		});
		btnEliminarProd.setForeground(Color.RED);
		btnEliminarProd.setBounds(122, 222, 200, 38);
		contentPane.add(btnEliminarProd);
		
		JButton btnNewButton = new JButton("Volver atr\u00E1s");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(0, 266, 125, 20);
		contentPane.add(btnNewButton);
		
		
		
	}
}
