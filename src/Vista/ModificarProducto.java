package Vista;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Sistema.ControladorProducto;
import Sistema.Producto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;

public class ModificarProducto extends JFrame {

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
	public ModificarProducto () {
		setBackground(UIManager.getColor("Table.selectionBackground"));
		setResizable(false);
		setTitle("Modificar Producto");
		
		setBounds(100, 100, 446, 329);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Table.selectionBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbNombreProducto = new JLabel("Nombre Producto:");
		lbNombreProducto.setBounds(10, 59, 120, 27);
		contentPane.add(lbNombreProducto);
		lbNombreProducto.setVisible(false);
		
		NombreProducto = new JTextField();
		NombreProducto.setEditable(false);
		NombreProducto.setBounds(126, 62, 275, 20);
		contentPane.add(NombreProducto);
		NombreProducto.setColumns(10);
		NombreProducto.setVisible(false);
		
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
		lbPrecioProd.setVisible(false);
		
		Precio = new JTextField();
		Precio.setBounds(124, 94, 156, 20);
		contentPane.add(Precio);
		Precio.setColumns(10);
		Precio.setEditable(false);
		Precio.setVisible(false);
		
		JLabel lbStockProd = new JLabel("Stock:");
		lbStockProd.setBounds(10, 131, 46, 14);
		contentPane.add(lbStockProd);
		lbStockProd.setVisible(false);
		
		StockProd = new JTextField();
		StockProd.setBounds(124, 128, 156, 20);
		contentPane.add(StockProd);
		StockProd.setColumns(10);
		StockProd.setEditable(false);
		StockProd.setVisible(false);
		
		
		JLabel lbStockMin = new JLabel("Stock Minimo:");
		lbStockMin.setBounds(10, 167, 90, 14);
		contentPane.add(lbStockMin);
		lbStockMin.setVisible(false);
		
		StockMinProd = new JTextField();
		StockMinProd.setBounds(124, 164, 132, 20);
		contentPane.add(StockMinProd);
		StockMinProd.setColumns(10);
		StockMinProd.setEditable(false);
		StockMinProd.setVisible(false);
		
		JLabel lbCatProd = new JLabel("Categor\u00EDa:");
		lbCatProd.setBounds(10, 205, 58, 14);
		contentPane.add(lbCatProd);
		lbCatProd.setVisible(false);
		
		CatProd = new JTextField();
		CatProd.setBounds(124, 205, 216, 20);
		contentPane.add(CatProd);
		CatProd.setColumns(10);
		CatProd.setEditable(false);
		CatProd.setVisible(false);
		
		JButton btnModificarProducto = new JButton("Modificar Producto");
		btnModificarProducto.setEnabled(false);
		btnModificarProducto.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				
				
				
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
					
					
					
					boolean respuesta= ControladorProducto.getContr().modificarProducto(codigo, desc, pre, st, stMin, cat);
					if(respuesta) {
						JOptionPane.showMessageDialog(null,"El producto se ha modificado Correctamente","Producto Creado",JOptionPane.INFORMATION_MESSAGE);
						CodigoBarra.setText("");
						NombreProducto.setText("");	
						CatProd.setText("");
						StockProd.setText("");
						StockMinProd.setText("");
						Precio.setText("");
					
					}
					else {
						JOptionPane.showMessageDialog(null, "El producto NO se ha modificado","Error",JOptionPane.ERROR_MESSAGE);
					}
					
					
					}
				}
				catch(NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(null,"no ingrese caracteres en los campos de solo números", "Error caracter ingresado erroneamente",JOptionPane.ERROR_MESSAGE);
				}


			
			
			}
				
			}
		);
		btnModificarProducto.setBounds(229, 236, 156, 24);
		contentPane.add(btnModificarProducto);
		
		JButton BuscarProd = new JButton("Buscar Producto");
		BuscarProd.addActionListener(new ActionListener() {
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
						NombreProducto.setText("");	
						CatProd.setText("");
						StockProd.setText("");
						StockMinProd.setText("");
						Precio.setText("");
					}
					else {
						btnModificarProducto.setEnabled(true);
						NombreProducto.setText(respuesta.getDescripcion());	
						CatProd.setText(respuesta.getDescripcion());
						Precio.setText(String.valueOf(respuesta.getPrecio()));
						StockProd.setText(String.valueOf(respuesta.getStock()));
						StockMinProd.setText(String.valueOf(respuesta.getStockMin()));
						NombreProducto.setVisible(true);
						Precio.setVisible(true);
						CatProd.setVisible(true);
						StockMinProd.setVisible(true);
						StockProd.setVisible(true);
						Precio.setVisible(true);
						Precio.setEditable(true);
						NombreProducto.setEditable(true);
						Precio.setEditable(true);
						CatProd.setEditable(true);
						StockMinProd.setEditable(true);
						StockProd.setEditable(true);
						lbNombreProducto.setVisible(true);
						lbPrecioProd.setVisible(true);
						lbStockProd.setVisible(true);
						lbStockMin.setVisible(true);
						lbCatProd.setVisible(true);

					
					}
					}
				catch(NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(null,"no ingrese caracteres en el CODIGO DE BARRA", "Error caracter ingresado erroneamente",JOptionPane.ERROR_MESSAGE);
				}
	
				}
			}
			
				
			
		});
		BuscarProd.setBounds(20, 237, 149, 23);
		contentPane.add(BuscarProd);
		
		JLabel lblNewLabel = new JLabel("*Ingrese el codigo de barra y luego presione \"Buscar Producto\"");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(36, 31, 440, 20);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Volver atr\u00E1s");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(0, 271, 130, 18);
		contentPane.add(btnNewButton);
	}
}