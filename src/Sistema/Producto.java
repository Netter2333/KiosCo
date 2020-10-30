package Sistema;

public class Producto 
{
	//atributos
	private int codigoBarra;
	private String descripcion;
	private float precio;
	private int stock;
	private int stockMin;
	private String categoria;
	protected String estado;
	
	//constructor
	public Producto(int codigoBarra, String descripcion, float precio, int stock, int stockMin, String categoria) 
	{
		super();
		this.codigoBarra = codigoBarra;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.stockMin = stockMin;
		this.categoria = categoria;
		estado ="Activo";
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getStockMin() {
		return stockMin;
	}

	public void setStockMin(int stockMin) {
		this.stockMin = stockMin;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getCodigoBarra() {
		return codigoBarra;
	}
	
	public boolean sosElProducto(int cod) {
		return cod == codigoBarra;
	}
	
	public void descontarStock(int cant) {
		stock = stock - cant;
	}
	
	public boolean tieneStockMinimo()
	{
		return (stockMin>stock);
	}
	
	public void eliminar() 
	{
		estado= "Eliminado";
		
	}

}
