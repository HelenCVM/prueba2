package ec.ups.edu.Vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import ec.edu.ups.BD.EspecialidadDB;
import ec.edu.ups.BD.MedicoDB;
import ec.edu.ups.BD.TelefonoDB;
import ec.edu.ups.modelo.Medico;
import ec.edu.ups.modelo.ModelEspecialidad;
import ec.edu.ups.modelo.ModelTelefono;
import ec.edu.ups.modelo.Telefono;

public class Ventana1  extends JFrame implements ActionListener{

	private JTextField txtnombre;
	private JTextField txtcodigo;
	private JTextField txtcodig;
	private JComboBox txtespecialidad;
	private JComboBox txttipo;
	private JTextField txtnumero;
	private JButton btnagregar;
	private JButton sali;
	private JButton ingresar;
	private JButton guardar;
	private JButton limpiar;
    private JTable tabla;
	private JTextField txtcodigoo;
	private JTextField txtcm;
	
MedicoDB pe=new MedicoDB();
TelefonoDB te=new TelefonoDB();
	
	public Ventana1() {
		this.setSize(700, 700);
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
		
		txtcodig = new JTextField(20);
		GridBagConstraints gbc10 = new GridBagConstraints();
		gbc10.gridx = 1;
		gbc10.gridy = 1;
		gbc10.gridwidth = 2;
		gbc10.fill = GridBagConstraints.HORIZONTAL;
		panel1.add(txtcodig, gbc10);
		
		
		JLabel lblespecialidad = new JLabel("Especialidad:");
		GridBagConstraints gbc4 = new GridBagConstraints();
		gbc4.gridx = 0;
		gbc4.gridy = 2;
		panel1.add(lblespecialidad, gbc4);
		
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
		
		
		txtespecialidad = new JComboBox();
		txtespecialidad.addItem("1");
		txtespecialidad.addItem("2");
		txtespecialidad.addItem("3");
		txtespecialidad.addItem("4");
		txtespecialidad.addItem("5");
		txtespecialidad.addItem("6");
		txtespecialidad.addItem("7");
		txtespecialidad.addItem("8");
		txtespecialidad.addItem("9");
		GridBagConstraints gbc5 = new GridBagConstraints();
		gbc5.gridx = 1;
		gbc5.gridy = 2;
		gbc5.gridwidth = 2;
		gbc5.fill = GridBagConstraints.HORIZONTAL;
		panel1.add(txtespecialidad, gbc5);
		
		
		JPanel todo1=new JPanel();
		todo1.setLayout(new BorderLayout());
		Border borderpanel1=new TitledBorder(new EtchedBorder(),"Telefono");
		todo1.setBorder(borderpanel1);
		
		//segundo panel 
			JPanel panel2 = new JPanel();
		GridBagLayout la1 = new GridBagLayout();
		panel2.setLayout(la1);	
		
		JLabel lbltipo = new JLabel("Tipo:");
		GridBagConstraints gbc6 = new GridBagConstraints();
		gbc6.gridx = 0;
		gbc6.gridy = 0;
		panel2.add(lbltipo, gbc6);

		
		JLabel lblnumero = new JLabel("Numero:");
		GridBagConstraints gbc7 = new GridBagConstraints();
		gbc7.gridx = 3;
		gbc7.gridy = 0;
		panel2.add(lblnumero, gbc7);
		
		txttipo = new JComboBox();
		txttipo.addItem("MOVIL");
		txttipo.addItem("CONVENCIONAL");
		GridBagConstraints gbc8 = new GridBagConstraints();
		gbc8.gridx = 1;
		gbc8.gridy = 0;
		gbc8.gridwidth = 2;
		gbc8.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(txttipo, gbc8);
		
		txtnumero = new JTextField(20);
		GridBagConstraints gbc9 = new GridBagConstraints();
		gbc9.gridx = 4;
		gbc9.gridy = 0;
		gbc9.gridwidth = 2;
		gbc9.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(txtnumero, gbc9);
		
		btnagregar = new JButton("Agregar");
		btnagregar.addActionListener(this);
		btnagregar.setActionCommand("btnagregar");
		GridBagConstraints gbc12 = new GridBagConstraints();
		gbc12.gridx = 7;
		gbc12.gridy = 0;
		gbc12.gridwidth = 2;
		gbc12.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(btnagregar, gbc12);
		
		JLabel lblcodigoo = new JLabel("Codigo:");
		GridBagConstraints gbc11 = new GridBagConstraints();
		gbc11.gridx = 0;
		gbc11.gridy = 1;
		panel2.add(lblcodigoo, gbc11);
	
		txtcodigoo = new JTextField(10);
		GridBagConstraints gbc13 = new GridBagConstraints();
		gbc13.gridx = 1;
		gbc13.gridy = 1;
		gbc13.gridwidth = 2;
		gbc13.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(txtcodigoo, gbc13);
		
		
		JLabel lblcm = new JLabel("Codigomedico:");
		GridBagConstraints gbc14 = new GridBagConstraints();
		gbc14.gridx = 3;
		gbc14.gridy = 1;
		panel2.add(lblcm, gbc14);
	
		txtcm = new JTextField(10);
		GridBagConstraints gbc15 = new GridBagConstraints();
		gbc15.gridx = 4;
		gbc15.gridy = 1;
		gbc15.gridwidth = 2;
		gbc15.fill = GridBagConstraints.HORIZONTAL;
		panel2.add(txtcm, gbc15);
		
		JPanel todo2=new JPanel();
		todo2.add(panel1);
		
		
		
		
		
		
		JPanel panel3 = new JPanel();
		BorderLayout a = new BorderLayout();
		panel3.setLayout(new BorderLayout());
		panel3.setLayout(a);

		 tabla = new JTable();
	     tabla.setModel(new ModelTelefono());
	        
	    JScrollPane scrollPaneTabla = new JScrollPane(tabla);
	    panel3.add(scrollPaneTabla);
	    
	    
	    todo1.add(panel2,BorderLayout.CENTER);
	   todo1.add(panel3,BorderLayout.SOUTH);
	   
		
	   JPanel panel4=new JPanel();
		FlowLayout layout1=new FlowLayout();
		layout1.setAlignment(FlowLayout.RIGHT);
		layout1.setHgap(5);
		panel4.setLayout(layout1);
		
		 guardar =new JButton("Guardar");
		 guardar.addActionListener(this);
	     guardar.setActionCommand("Guardar");
		panel4.add(guardar);
		
		cp.add(todo1,BorderLayout.CENTER);
		
		cp.add(todo2,BorderLayout.NORTH);
		
		cp.add(panel4,BorderLayout.SOUTH);
		
		
		
		
		
		
		
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();

		switch (comando) {

		case "btnagregar":
			agregar();
			break;
		case "Guardar":
			break;
			default:
				break;
	}
		
	}
	
	
	public void agregar()
	{
    Telefono t=new Telefono();
    t.setCodigo(Integer.parseInt(txtcodigoo.getText()));
    t.setCodigo_medico(Integer.parseInt(txtcm.getText()));
    String tipo = (String) txttipo.getSelectedItem();
  	t.setTipo(tipo);
    t.setNumero(txtnumero.getText());
    te.insertar(t);
	tabla.setModel(new ModelTelefono(te.listar()));
	
	}
}