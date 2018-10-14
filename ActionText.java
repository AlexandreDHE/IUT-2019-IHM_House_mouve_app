import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ActionText implements ActionListener {
	private JLabel a;
	private JTextField u;
	private AllCarton z;
	private int cur;
	private String n;
	public ActionText(String name,int curseur,AllCarton t,JTextField j,JLabel b){
		this.a=b;
		this.n = name;
		this.u = j;
		this.z=t;
		this.cur = curseur;
	}
	@Override
	public void actionPerformed(ActionEvent e){
		Model t=new Model();
		try{
			if(t.changeValCarton(this.n,this.z,this.cur,Integer.parseInt(e.getActionCommand()))){
				this.a.setText(e.getActionCommand());	
			}
		}catch(NumberFormatException ee){
			JOptionPane.showMessageDialog(this.z, "Veuillez entrer un nombre");
		}
		this.u.setText("");
	}
}