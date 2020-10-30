package Vista;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Sistema.ControladorProducto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;

public class CrearProducto extends JFrame {

	private JPanel contentPane;
	private JTextField NombreProducto;
	private JTextField CodigoBarra;
	private JTextField Precio;
	private JTextField StockProd;
	private JTextField StockMinProd;
	private JTextField CatProd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearProducto frame = new CrearProducto();
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
	public CrearProducto() {
		setResizable(false);
		setTitle("Crear Producto");
		
		setBounds(100, 100, 442, 327);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Table.selectionBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbNombreProducto = new JLabel("Nombre Producto:");
		lbNombreProducto.setBounds(10, 51, 120, 27);
		contentPane.add(lbNombreProducto);
		
		NombreProducto = new JTextField();
		NombreProducto.setBounds(124, 54, 275, 20);
		contentPane.add(NombreProducto);
		NombreProducto.setColumns(10);
		
		JLabel lbCodigoBarra = new JLabel("Codigo de Barra:");
		lbCodigoBarra.setBounds(10, 7, 120, 28);
		contentPane.add(lbCodigoBarra);
		
		CodigoBarra = new JTextField();
		CodigoBarra.setBounds(124, 11, 232, 20);
		contentPane.add(CodigoBarra);
		CodigoBarra.setColumns(10);
		
		JLabel lbPrecioProd = new JLabel("Precio:");
		lbPrecioProd.setBounds(10, 97, 46, 14);
		contentPane.add(lbPrecioProd);
		
		Precio = new JTextField();
		Precio.setBounds(124, 94, 156, 20);
		contentPane.add(Precio);
		Precio.setColumns(10);
		
		JLabel lbStockProd = new JLabel("Stock:");
		lbStockProd.setBounds(10, 131, 46, 14);
		contentPane.add(lbStockProd);
		
		StockProd = new JTextField();
		StockProd.setBounds(124, 128, 156, 20);
		contentPane.add(StockProd);
		StockProd.setColumns(10);
		
		JLabel lbStockMin = new JLabel("Stock Minimo:");
		lbStockMin.setBounds(10, 167, 90, 14);
		contentPane.add(lbStockMin);
		
		StockMinProd = new JTextField();
		StockMinProd.setBounds(124, 164, 132, 20);
		contentPane.add(StockMinProd);
		StockMinProd.setColumns(10);
		
		JLabel lbCatProd = new JLabel("Categor\u00EDa:");
		lbCatProd.setBounds(10, 205, 58, 14);
		contentPane.add(lbCatProd);
		
		CatProd = new JTextField();
		CatProd.setBounds(124, 205, 216, 20);
		contentPane.add(CatProd);
		CatProd.setColumns(10);
		
		JButton btnCrearProducto = new JButton("Crear Producto");
		btnCrearProducto.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				ControladorProducto.getContr().getListaproductos();
				try
				{
				if(CodigoBarra.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "el campo de Codigo de barra debe estar completo", "Formulario incompleto",JOptionPane.WARNING_MESSAGE);
				}
				else if( NombreProducto.getText().equalsIgnoreCase("") ) {
					JOptionPane.showMessageDialog(null, "el campo de Nombre de producto debe estar completo", "Formulario incompleto",JOptionPane.WARNING_MESSAGE);
				}
				else if( Precio.getText().equalsIgnoreCase("") ) {
					JOptionPane.showMessageDialog(null, "el campo de Precio debe estar completo", "Formulario incompleto",JOptionPane.WARNING_MESSAGE);
				}
				else if(StockProd.getText().equalsIgnoreCase("") ) {
					JOptionPane.showMessageDialog(null, "el campo de Stock debe estar completo", "Formulario incompleto",JOptionPane.WARNING_MESSAGE);
				}
				else if( StockMinProd.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "el campo de Stock mínimo debe estar completo", "Formulario incompleto",JOptionPane.WARNING_MESSAGE);
				}
				else if( CatProd.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "el campo de Categoría debe estar completo", "Formulario incompleto",JOptionPane.WARNING_MESSAGE);
				}
				
				else {
								
					int codigo=Integer.parseInt(CodigoBarra.getText());
					String desc= NombreProducto.getText();		
					float pre=Float.parseFloat(Precio.getText());
					int st=Integer.parseInt(StockProd.getText());
					int stMin=Integer.parseInt(StockMinProd.getText());
					String cat= CatProd.getText();	
					
					
					
					boolean respuesta= ControladorProducto.getContr().crearProducto(codigo, desc  ,pre, st, stMin, cat);
					if(respuesta) {
						JOptionPane.showMessageDialog(null,"El producto se ha creado Correctamente","Producto Creado",JOptionPane.INFORMATION_MESSAGE);
						CodigoBarra.setText("");
						NombreProducto.setText("");	
						CatProd.setText("");
						StockProd.setText("");
						StockMinProd.setText("");
						Precio.setText("");
					
					}
					else {
						JOptionPane.showMessageDialog(null, "El producto ya existe en el sistema","Producto Duplicado",JOptionPane.ERROR_MESSAGE);
						CodigoBarra.setText("");
						NombreProducto.setText("");	
						CatProd.setText("");
						StockProd.setText("");
						StockMinProd.setText("");
						Precio.setText("");
					}
					
					
					}
				}
				catch(NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(null,"no ingrese caracteres en los campos de solo números", "Error caracter ingresado erroneamente",JOptionPane.ERROR_MESSAGE);
				}


			
			
			}
		
		});
		btnCrearProducto.setBounds(156, 236, 124, 23);
		contentPane.add(btnCrearProducto);
		
		JButton btnNewButton = new JButton("Volver atr\u00E1s");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(0, 266, 130, 20);
		contentPane.add(btnNewButton);
	}
}

