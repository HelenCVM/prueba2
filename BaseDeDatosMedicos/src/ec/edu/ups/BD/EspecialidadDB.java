package ec.edu.ups.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;


import ec.edu.ups.ConexionDB.ConexionBD;
import ec.edu.ups.modelo.Especialiadad;



public class EspecialidadDB {
	//insertar datos
	public void insertar(Especialiadad espe){
		Connection con = null;
		String sql = "INSERT INTO  Especialiadad(Codigo, "
				+ "      Nombre"
				+ "      ) "
				+ "VALUES (?,?);";
		try {
			con = ConexionBD.getConnection();
		    
			PreparedStatement ps= con.prepareStatement(sql);
		    ps.setInt(1, espe.getCodigo());
		    ps.setString(2, espe.getNombre());
		   		    
		    
		    ps.executeUpdate();
		    
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
			ConexionBD.close(con);
		}
	}
	
	//actualizar los datos ya existentes
	public void actualizar(Especialiadad espe,JTextField txtcodigo){
	
			Connection con = null;
			Statement stmt=null;
			int result=0;
			//stmt=con.prepareStatement("UPDATE  Especialiadad "
			//		+ "SET Nombre =?  )"
				//	+ "WHERE Codigo = 
			
                try
                    {
                	con = ConexionBD.getConnection();
                	 stmt = con.createStatement();
         		  //  result = stmt.executeUpdate();

                    } catch (Exception e) {
            		    e.printStackTrace();
            		} finally {
            			ConexionBD.close(con);
            		}
	
	}
	//borrar datos ya existentes
	public void borrar(Especialiadad espe,JTextField txtcodigo ){
		Connection con = null;
		Statement stmt = null;
		int result = 0;
		
		System.out.println(txtcodigo.getText());
		String sql = "DELETE FROM Especialiadad   "
				+ "WHERE  codigo =  "+ txtcodigo.getText();
				
		try {
			con = ConexionBD.getConnection();
		    stmt = con.createStatement();
		    result = stmt.executeUpdate(sql);
		//	PreparedStatement ps= con.prepareStatement(sql);
		  //  ps.setInt(1, espe.getCodigo());
		  //  ps.setString(2, espe.getNombre());
		   		    
		    
		//    ps.executeUpdate();
		    
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
			ConexionBD.close(con);
		}
		}
		
	
	public Especialiadad leer(String cedula){
		
		return null;
	}
	
	//listar
	public List<Especialiadad> listar(){
		
		List<Especialiadad> personas= new ArrayList<Especialiadad>();             
		String sql="SELECT Codigo, Nombre "
				+ "FROM Especialiadad";
		System.out.println(sql);
		Connection con = null;
		try {
			con = ConexionBD.getConnection();
		    PreparedStatement ps= con.prepareStatement(sql);
		    ResultSet rs=ps.executeQuery();
		    while(rs.next())
		    {
		        System.out.println(rs.getString("Codigo"));
		        
		        Especialiadad p = new Especialiadad();
		        p.setCodigo(rs.getInt("Codigo"));
		        p.setNombre(rs.getString("Nombre").trim());
		        personas.add(p);
		        
		    }
		   
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
			ConexionBD.close(con);
		}
		return personas;
	}
	
}
