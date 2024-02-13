package Ejercicio2;

import javafx.beans.property.*;

public class TProducto {
	private IntegerProperty id = new SimpleIntegerProperty();
	private StringProperty nombre = new SimpleStringProperty();
	private DoubleProperty precio = new SimpleDoubleProperty();
	private IntegerProperty codigo_fabricante = new SimpleIntegerProperty();

	public TProducto(int id, String nombre, Double precio, int codigo_fabricante) {
		this.id.set(id);
		this.nombre.set(nombre);
		this.precio.set(precio);
		this.codigo_fabricante.set(codigo_fabricante);

	}

	// Métodos getter para propiedades observables
	public int getId() {
		return id.get();
	}

	public IntegerProperty idProperty() {
		return id;
	}

	public void setId(int id) {
		this.id.set(id);
		;
	}

	public String getNombre() {
		return nombre.get();
	}

	public StringProperty nombreProperty() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre.set(nombre);
	}

	public double getPrecio() {
		return precio.get();
	}

	public DoubleProperty precioProperty() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio.set(precio);
		;
	}
	
	public int getCodigo_fabricante() {
		return codigo_fabricante.get();
	}

	public IntegerProperty codigo_fabricanteProperty() {
		return codigo_fabricante;
	}

	public void setCodigo_fabricante(int id) {
		this.codigo_fabricante.set(id);
		;
	}

	// Otros métodos y constructores

}
