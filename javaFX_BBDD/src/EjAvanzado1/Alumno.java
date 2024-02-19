package EjAvanzado1;

import javafx.beans.property.*;

public class Alumno {
	 private StringProperty nombre = new SimpleStringProperty();
	 private StringProperty apellido1 = new SimpleStringProperty();
	 private StringProperty apellido2 = new SimpleStringProperty();
	 private BooleanProperty es_repetidor = new SimpleBooleanProperty();
	 private StringProperty fecha_nacimiento = new SimpleStringProperty();
	 private IntegerProperty telefono = new SimpleIntegerProperty();

    public Alumno(String nombre, String apellido1, String apellido2,
				boolean es_repetidor, String fecha_nacimiento, int telefono) {
			super();
			this.nombre.set(nombre);
	        this.apellido1.set(apellido1);
	        this.apellido2.set(apellido2);
	        this.es_repetidor.set(es_repetidor);
	        this.fecha_nacimiento.set(fecha_nacimiento);
	        this.telefono.set(telefono);
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


	public String getApellido1() {
		return apellido1.get();
	}

	public StringProperty apellido1Property() {
        return apellido1;
    }
	
	public void setApellido1(String apellido1) {
		this.apellido1.set(apellido1);;
	}

	public String getApellido2() {
		return apellido2.get();
	}

	public StringProperty apellido2Property() {
        return apellido2;
    }
	
	public void setApellido2(String apellido2) {
		this.apellido2.set(apellido2);;
	}

	public boolean getEs_repetidor() {
		return es_repetidor.getValue();
	}

	public BooleanProperty es_repetidorProperty() {
        return es_repetidor;
    }
	
	public void setEs_repetidor(boolean es_repetidor) {
		this.es_repetidor.set(es_repetidor);;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento.get();
	}

	public StringProperty fecha_nacimientoProperty() {
        return fecha_nacimiento;
    }
	
	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento.set(fecha_nacimiento);;
	}

	public Integer getTelefono() {
		return telefono.get();
	}

	public IntegerProperty telefonoProperty() {
        return telefono;
    }
	
	public void setTelefono(Integer telefono) {
		this.telefono.set(telefono);
	}

    // Otros métodos y constructores
}
