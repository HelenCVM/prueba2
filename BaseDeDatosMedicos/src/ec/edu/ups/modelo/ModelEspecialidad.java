package ec.edu.ups.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ModelEspecialidad extends AbstractTableModel {
//sentencias para generar tabla
	 public String[] columnas = { "Codigo", "Nombre"};
	//tipo de dato de las columnas
		    public Class[] columnasTipos = { Integer.class, String.class};

		    //mando la lista que deseo poner en tabla
		    private List<Especialiadad> datos;

		    public ModelEspecialidad() {
		      super();
		      datos = new ArrayList<Especialiadad>();
		    }
		    
		    public ModelEspecialidad(List<Especialiadad> datos) {
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
		      Especialiadad dato = (Especialiadad) (datos.get(row));

		      switch (col) {
		      case 0:
		        dato.setCodigo((Integer) value);
		        break;
		      case 1:
		        dato.setNombre((String) value);
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
		      Especialiadad dato = (Especialiadad) (datos.get(row));

		      switch (col) {
		      case 0:
		        return dato.getCodigo();
		      case 1:
		        return dato.getNombre();
		      default:
		        break;
		      }
		      return new String();
		    }
	}

