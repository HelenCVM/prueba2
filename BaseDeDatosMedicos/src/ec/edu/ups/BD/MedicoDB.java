package ec.edu.ups.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.ConexionDB.ConexionBD;
import ec.edu.ups.modelo.Especialiadad;
import ec.edu.ups.modelo.Medico;

public class MedicoDB {
//insertar
	public void insertar(Medico medi){
		Connection con = null;
		String sql = "INSERT INTO Especialiadad(Codigo), "
				+ "      Nombre  , Especialidad "
				+ "      ) "
				+ "VALUES (?,?);";
		try {
			con = ConexionBD.getConnection();
		    
			PreparedStatement ps= con.prepareStatement(sql);
		    ps.setInt(1, medi.getCodigo());
		    ps.setString(2,medi.getNombre());
		    
		   		    
		    
		    ps.executeUpdate();
		    
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
			ConexionBD.close(con);
		}
	}
	//actualizar
	public void actualizar(Especialiadad espe){
		
	}
	
	public void borrar(Especialiadad espe){
		
	}
	
	public Especialiadad leer(String cedula){
		
		return null;
	}
	
	//listar
	public List<Medico> listar(){
		
		List<Medico> personas= new ArrayList<Medico>();             
		String sql="SELECT Codigo, Nombre ,Especialidad , Telefono(Tipo) ,Telefono(Numero) "
				+ "FROM Especialiadad,Medico,Telefono ";
		System.out.println(sql);
		Connection con = null;
		try {
			con = ConexionBD.getConnection();
		    PreparedStatement ps= con.prepareStatement(sql);
		    ResultSet rs=ps.executeQuery();
		    while(rs.next())
		    {
		        System.out.println(rs.getString("Codigo"));
		        
		        Medico me = new Medico();
		        me.setCodigo(rs.getInt("Codigo"));
		        me.setNombre(rs.getString("Nombre").trim());
		        me.setEspecialidad(rs.getInt("Especialidad"));
		        
		        
		        personas.add(me);
		        
		    }
		   
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
			ConexionBD.close(con);
		}
		return personas;
	}
}
