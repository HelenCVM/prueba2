package ec.edu.ups.modelo;

import java.util.ArrayList;

public class Medico {

	private int Codigo;
	private String Nombre;
	private int Especialidad;
	private ArrayList<Telefono>tel;
	private Especialiadad espe;
	
	
	
	
	public Especialiadad getEspe() {
		return espe;
	}
	public void setEspe(Especialiadad espe) {
		this.espe = espe;
	}
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
	public int getEspecialidad() {
		return Especialidad;
	}
	public void setEspecialidad(int especialidad) {
		Especialidad = especialidad;
	}
	public ArrayList<Telefono> getTel() {
		return tel;
	}
	public void setTel(ArrayList<Telefono> tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "Medico [Codigo=" + Codigo + ", Nombre=" + Nombre + ", Especialidad=" + Especialidad + ", tel=" + tel
				+ ", espe=" + espe + "]";
	}
	
	public void addTelefono(Telefono tele)
	{
		tel.add(tele);
	}
	
	
	
}
