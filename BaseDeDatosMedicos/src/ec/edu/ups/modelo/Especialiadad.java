package ec.edu.ups.modelo;

public class Especialiadad {
private int Codigo;
private String Nombre;
public int getCodigo() {
	return Codigo;
}
public void setCodigo(int codigo) {
	Codigo = codigo;
}
public String getNombre() {
	return Nombre;
}
public void setNombre(String nombre) {
	Nombre = nombre;
}
@Override
public String toString() {
	return "Especialidad [Codigo=" + Codigo + ", Nombre=" + Nombre + "]";
}


}
