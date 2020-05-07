package ec.ups.edu.Vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ec.edu.ups.BD.EspecialidadDB;
import ec.edu.ups.modelo.Especialiadad;
import ec.edu.ups.modelo.ModelEspecialidad;




public class Ventana extends JFrame implements ActionListener {
	
	private JTextField txtnombre;
	private JTextField txtcodigo;
	private JButton sali;
	private JButton ingresar;
	private JButton guardar;
	private JButton limpiar;
	private JTable tabla;
	private JButton btndelete;
	private JButton btnupdate;
EspecialidadDB pe=new EspecialidadDB();
	
	public Ventana() {
		this.setSize(500, 500);
		this.setTitle("Especialidad");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container cp = getContentPane();
		BorderLayout layout = new BorderLayout();
		cp.setLayout(layout);

		JPanel panel1 = new JPanel();
		GridBagLayout la = new GridBagLayout();
		panel1.setLayout(la);

		JLabel lblcodigo = new JLabel("Codigo:");
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel1.add(lblcodigo, gbc);

		
		JLabel lblnombre = new JLabel("Nombre:");
		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.gridx = 0;
		gbc2.gridy = 1;
		panel1.add(lblnombre, gbc2);
		
		txtcodigo = new JTextField(20);
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.gridx = 1;
		gbc1.gridy = 0;
		gbc1.gridwidth = 2;
		gbc1.fill = GridBagConstraints.HORIZONTAL;
		panel1.add(txtcodigo, gbc1);
		
		
		txtnombre = new JTextField(20);
		GridBagConstraints gbc3 = new GridBagConstraints();
		gbc3.gridx = 1;
		gbc3.gridy = 1;
		gbc3.gridwidth = 2;
		gbc3.fill = GridBagConstraints.HORIZONTAL;
		panel1.add(txtnombre, gbc3);
		
		
		
		JPanel panel2 = new JPanel();
		BorderLayout a = new BorderLayout();
		panel2.setLayout(new BorderLayout());
		panel2.setLayout(a);

		 tabla = new JTable();
	     tabla.setModel(new ModelEspecialidad());
	        
	    JScrollPane scrollPaneTabla = new JScrollPane(tabla);
	    

		JPanel panel3 = new JPanel();
		FlowLayout aa = new FlowLayout();
		panel3.setLayout(new FlowLayout());
		panel3.setLayout(aa);
		
	  
		
		guardar = new JButton("Guardar");
		guardar.addActionListener(this);
		guardar.setActionCommand("Guardar");
		
		limpiar = new JButton("Limpiar");
		limpiar.addActionListener(this);
		limpiar.setActionCommand("Limpiar");

		sali = new JButton("Salir");
		sali.addActionListener(this);
		sali.setActionCommand("Salir");
		
		
		btnupdate = new JButton("Actualizar");
		btnupdate.addActionListener(this);
		btnupdate.setActionCommand("Actualizar");
		
		btndelete = new JButton("Delete");
		btndelete.addActionListener(this);
		btndelete.setActionCommand("Delete");
	
		panel3.add(guardar);
		panel3.add(btnupdate);
		panel3.add(btndelete);
		panel3.add(limpiar);
		panel3.add(sali);
		

		cp.add(panel1, BorderLayout.NORTH);
		cp.add(scrollPaneTabla, BorderLayout.CENTER);
		cp.add(panel3, BorderLayout.SOUTH);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();

		switch (comando) {

		case "Ingresar":
			
			break;
			
		case "Guardar":
			guardar();
			break;
			
		case "Salir":
			salir();
			break;
			
		case "Limpiar":
			limpiar();
			break;
			
		case"Actualizar":
			
			update();
			break;
		case"Delete":
			detete();
			break;
			default:
				break;
		}
	
	
	}
	
	public void salir()
	{
		dispose();
	}
	
	public void guardar()
	{
		Especialiadad espe=new Especialiadad();
		espe.setCodigo(Integer.parseInt(txtcodigo.getText()));
		espe.setNombre(txtnombre.getText());
	    pe.insertar(espe);
	   tabla.setModel(new ModelEspecialidad(pe.listar()));
		
	}
	
	public void limpiar()
	{
		txtcodigo.setText(" ");
		txtnombre.setText(" ");
	}
	
public void update()
{
	Especialiadad es=new Especialiadad();
	es.setCodigo(Integer.parseInt(txtcodigo.getText()));
	es.setNombre(txtnombre.getText());
	pe.actualizar(es,txtcodigo);
	tabla.setModel(new ModelEspecialidad(pe.listar()));
}

public void detete()
{
	Especialiadad esp=new Especialiadad();
	esp.setCodigo(Integer.parseInt(txtcodigo.getText()));
	esp.setNombre(txtnombre.getText());
	pe.borrar(esp,txtcodigo);
	tabla.setModel(new ModelEspecialidad(pe.listar()));
}

public void oio()
{
	int fila=tabla.getSelectedRow();
	if(fila>=0)
	{
		txtcodigo.setText(tabla.getValueAt(fila,0).toString());
		txtnombre.setText(tabla.getValueAt(fila,1).toString());
	}
}


}
