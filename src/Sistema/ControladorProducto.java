package Sistema;

import java.util.Vector;

public class ControladorProducto {
	//Attributes
	private Vector<Producto>listaproductos;
	private static ControladorProducto instancia;

	public ControladorProducto()
	{
		listaproductos = new Vector <Producto>();
	
	}
	public static ControladorProducto getContr()
	{
		if(instancia == null)
			instancia = new ControladorProducto();
		return instancia;
	}
	
	
	public boolean crearProducto(int codigo, String desc, 
			float pre, int st, int stMin, String cat) 
	{
		Producto p = buscarProducto(codigo);
		if (p==null)
		{
			p = new Producto(codigo, desc, pre, st, stMin, cat);
			listaproductos.add(p);
			return true;
		}
		return false;
	}
	
	public Producto buscarProducto(int codigo)
	{
		for (Producto prod : listaproductos)
	    	{
	            if (prod.sosElProducto(codigo))
	                return prod;
	        }
	        return null;	
	}
	
	public boolean modificarProducto(int codigo, String desc,
			float pre, int st, int stMin, String cat)
	{
		Producto prod = buscarProducto(codigo);
		if (prod!=null)
		{
			prod.setDescripcion(desc);
			prod.setPrecio(pre);
			prod.setStock(st);
			prod.setStockMin(stMin);
			prod.setCategoria(cat);
			return true;
		}
		
		return false;
	}
	
	public boolean eliminarProducto(int codigo)
	{
		Producto prod = buscarProducto(codigo);
		
		//eliminacion fisica	
		if (prod!=null)
		{
			listaproductos.remove(prod);
			//baja logica
			prod.eliminar();
			return true;
		}
		return false;
	}

	public Vector<Producto> getListaproductos() {
		return listaproductos;
	}
	
	
}
