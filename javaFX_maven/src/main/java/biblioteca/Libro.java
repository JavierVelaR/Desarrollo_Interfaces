package biblioteca;

import javax.persistence.*;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Table(name = "libro")
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private StringProperty nombre = new SimpleStringProperty();
	
	@Column(name="editorial")
	private StringProperty editorial = new SimpleStringProperty();
	
	@Column(name="autor")
	private StringProperty autor = new SimpleStringProperty();
	
	@Column(name="paginas")
	private IntegerProperty paginas = new SimpleIntegerProperty();

	public Libro() {
		super();
	}

	public Libro(String nombre, String editorial, String autor, int paginas) {
		this.nombre.set(nombre);
		this.editorial.set(editorial);
		this.autor.set(autor);
		this.paginas.set(paginas);
	}

// Métodos getter para propiedades observables
	public String getNombre() {
		return nombre.get();
	}

	public StringProperty nombreProperty() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre.set(nombre);
	}

	public String getEditorial() {
		return editorial.get();
	}

	public StringProperty editorialProperty() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial.set(editorial);
	}

	public String getAutor() {
		return autor.get();
	}

	public StringProperty autorProperty() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor.set(autor);
	}
	
	public int getPaginas() {
		return paginas.get();
	}

	public IntegerProperty paginasProperty() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas.set(paginas);
	}

	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombreLibro = getNombre();
	
	@Column(name="editorial")
	private String editorialLibro = getEditorial();
	
	@Column(name="autor")
	private String autorLibro = getAutor();
	
	@Column(name="paginas")
	private int paginasLibro = getPaginas();
	*/
}
