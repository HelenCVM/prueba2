package ec.edu.ups.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.ConexionDB.ConexionBD;
import ec.edu.ups.modelo.Especialiadad;
import ec.edu.ups.modelo.Medico;
import ec.edu.ups.modelo.Telefono;

public class TelefonoDB {
	//insertar datos
	public void insertar(Telefono telef){
		Connection con = null;
		String sql = "INSERT INTO  Telefono(Codigo ,Codigo_medico,Tipo ,Numero)"
				+ "VALUES (?,?,?,?);";
		try {
			con = ConexionBD.getConnection();
		    
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setInt(1,telef.getCodigo());
			ps.setInt(2,telef.getCodigo_medico());
		    ps.setString(3, telef.getTipo());
		    ps.setString(4,telef.getNumero());
		    ps.executeUpdate();
		    
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
			ConexionBD.close(con);
		}
	}
	
	
	
	public Telefono leer(String codigo){
		
		return null;
	}
	
	//listar
	public List<Telefono> listar(){
		List<Telefono> personas= new ArrayList<Telefono>();             
		String sql="SELECT Codigo,Codigo_medico,Tipo , Numero "
				+ "FROM Telefono ";
		System.out.println(sql);
		Connection con = null;
		try {
			con = ConexionBD.getConnection();
		    PreparedStatement ps= con.prepareStatement(sql);
		    ResultSet rs=ps.executeQuery();
			
		  // ps.setString(1, codigo);
		    while(rs.next())
		    {
		        System.out.println(rs.getInt("Codigo"));
		        
		        Telefono me = new Telefono();
		        me.setCodigo(rs.getInt("Codigo"));
		        me.setCodigo_medico(rs.getInt("Codigo_medico"));
		        me.setTipo(rs.getString("Tipo").trim());
		        me.setNumero(rs.getString("Numero").trim());
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
