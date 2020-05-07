package ec.edu.ups.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
//sentencias de codigo para generar tabla
public class ModelTelefono extends AbstractTableModel{

	 public String[] columnas = { "Codigo","Codigo_medico","Tipo", "Numero"};
		//tipo de dato de las columnas
			    public Class[] columnasTipos = { Integer.class,Integer.class,String.class, String.class};

			    //mando la lista que deseo poner en tabla
			    private List<Telefono> datos;

			    public ModelTelefono() {
			      super();
			      datos = new ArrayList<Telefono>();
			    }
			    
			    public ModelTelefono(List<Telefono> datos) {
			      super();
			      this.datos = datos;
			    }
			    public int getColumnCount() {
			      return columnas.length;
			    }
			    public int getRowCount() {
			      return datos.size();
			    }
			    public void setValueAt(Object value, int row, int col) {
			      Telefono dato = (Telefono) (datos.get(row));

			      switch (col) {
			      case 0:
			        dato.setCodigo((Integer) value);
			        break;
			      case 1:
			    	  dato.setCodigo_medico((Integer) value);
			        break;
			      case 2:
			    	  dato.setTipo((String) value);
				        break;
			      case 3:
				        dato.setNumero((String) value);
				        break;
			      default:
			        break;
			      }
			    }

			    public String getColumnName(int col) {
			      return columnas[col];
			    }

			    public Class getColumnClass(int col) {
			      return columnasTipos[col];
			    }
			    public Object getValueAt(int row, int col) {
			      Telefono dato = (Telefono) (datos.get(row));

			      switch (col) {
			      case 0:
			        return dato.getCodigo();
			      case 1:
			    	  return dato.getCodigo_medico();
			      case 2:
			    	  return dato.getTipo();
			      case 3:
				        return dato.getNumero();
			      default:
			        break;
			      }
			      return new String();
			    }
	
}
