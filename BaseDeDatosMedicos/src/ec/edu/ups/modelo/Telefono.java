package ec.edu.ups.modelo;

public class Telefono {
    private int Codigo;
    private int Codigo_medico;
	private String Tipo;
	private String Numero;
	
	
	public int getCodigo_medico() {
		return Codigo_medico;
	}
	public void setCodigo_medico(int codigo_medico) {
		Codigo_medico = codigo_medico;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public String getNumero() {
		return Numero;
	}
	public void setNumero(String numero) {
		Numero = numero;
	}
	

	@Override
	public String toString() {
		return "Telefono [Codigo=" + Codigo + ", Codigo_medico=" + Codigo_medico + ", Tipo=" + Tipo + ", Numero="
				+ Numero + "]";
	}
	public int getCodigo() {
		return Codigo;
	}
	public void setCodigo(int codigo) {
		Codigo = codigo;
	}
	
	
	
	
}
