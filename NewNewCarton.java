import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class NewNewCarton extends JPanel{
	private JLabel la;
	private Slide[] slide;
	private Labb[][] lab;
	private JPanel[] pan;
	private JTextField field;
	private int longu;
	private int larg;
	private int haut;
	private int elt;
	private int longg;
	private int largg;
	private int hautt;
	private boolean bool = false;
	private Fenetre j;
	public NewNewCarton(Fenetre m){
		this.j=m;
		this.setLayout(new GridBagLayout());
		String[] chaines = new String[]{"Chambre  :","<html>Petits<br>35x27x30cm</html>","<html>Moyens<br>55x35x30cm</html>","<html>Barrel<br>45x45x75cm</html>","<html>Penderie<br>120x50x50cm</html>","<html>Tableaux<br>100x15x90cm</html>"};
		JLabel[] chaine = new JLabel[9];
		this.slide = new Slide[5];
		for(int i= 0;i<5;i++)slide[i]=new Slide(0,20,0);
		for(int i=0;i<6;i++)chaine[i] = new JLabel(chaines[i]);
		for(int i=0;i<6;i++)chaine[i].setFont(new Font("Arial",Font.PLAIN,25));
		GridBagConstraints c = new GridBagConstraints();
		for(int i=0;i<6;i++){
			c.gridx = 0;
			c.gridy = i;
			c.gridheight = 1;
			c.gridwidth = 1;
			c.ipadx =10;
			c.ipady = 10;
			this.add(chaine[i],c);
		}
		this.field = new JTextField(20);
		c.gridx = 1;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.ipadx =10;
		c.ipady = 10;
		this.add(this.field,c);
		this.pan = new JPanel[5];
		this.lab = new Labb[5][3];
		for(int i = 0;i<5;i++){
			for(int j=0;j<3;j++){
				if(j==0){
					this.lab[i][j] = new Labb(""+this.slide[i].getValue());
				}else if(j==1){
					this.lab[i][j] = new Labb(""+this.slide[i].getMinimum());
				}else if(j==2){
					this.lab[i][j] = new Labb(""+this.slide[i].getMaximum());
				}
			}
		}
		c.gridx = 1;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.ipadx =10;
		c.ipady = 10;
		this.pan[0] = new JPanel();
		this.pan[0].setLayout(new GridLayout(2,3));
		this.pan[0].add(new JPanel());
		this.pan[0].add(this.lab[0][0]);
		this.pan[0].add(new JPanel());
		this.pan[0].add(this.lab[0][1]);
		this.pan[0].add(this.slide[0]);
		this.pan[0].add(this.lab[0][2]);
		this.add(this.pan[0],c);
		c.gridx = 1;
		c.gridy = 2;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.ipadx =10;
		c.ipady = 10;

		this.pan[1] = new JPanel();
		this.pan[1].setLayout(new GridLayout(2,3));
		this.pan[1].add(new JPanel());
		this.pan[1].add(this.lab[1][0]);
		this.pan[1].add(new JPanel());
		this.pan[1].add(this.lab[1][1]);
		this.pan[1].add(this.slide[1]);
		this.pan[1].add(this.lab[1][2]);
		this.add(this.pan[1],c);
		c.gridx = 1;
		c.gridy = 3;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.ipadx =10;
		c.ipady = 10;
		this.pan[2] = new JPanel();
		this.pan[2].setLayout(new GridLayout(2,3));
		this.pan[2].add(new JPanel());
		this.pan[2].add(this.lab[2][0]);
		this.pan[2].add(new JPanel());
		this.pan[2].add(this.lab[2][1]);
		this.pan[2].add(this.slide[2]);
		this.pan[2].add(this.lab[2][2]);
		this.add(this.pan[2],c);
		c.gridx = 1;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.ipadx =10;
		c.ipady = 10;
		this.pan[3] = new JPanel();
		this.pan[3].setLayout(new GridLayout(2,3));
		this.pan[3].add(new JPanel());
		this.pan[3].add(this.lab[3][0]);
		this.pan[3].add(new JPanel());
		this.pan[3].add(this.lab[3][1]);
		this.pan[3].add(this.slide[3]);
		this.pan[3].add(this.lab[3][2]);
		this.add(this.pan[3],c);
		c.gridx = 1;
		c.gridy = 5;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.ipadx =10;
		c.ipady = 10;
		this.pan[4] = new JPanel();
		this.pan[4].setLayout(new GridLayout(2,3));
		this.pan[4].add(new JPanel());
		this.pan[4].add(this.lab[4][0]);
		this.pan[4].add(new JPanel());
		this.pan[4].add(this.lab[4][1]);
		this.pan[4].add(this.slide[4]);
		this.pan[4].add(this.lab[4][2]);
		this.add(this.pan[4],c);
		////////////////////////////////////////

		this.longu = this.slide[0].getValue();
		this.larg = this.slide[1].getValue();
		this.haut = this.slide[2].getValue();
		this.elt = this.slide[3].getValue();
		this.longg = this.slide[4].getValue();
		

		this.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
		
		for(int i=0;i<5;i++)this.slide[i].addChangeListener(new ChangeCarton(this));
	}
	public JTextField getTextField(){
		return this.field;
	}
	public void ecrit(){
		ObCarton x = new ObCarton();
		x.setNom(this.field.getText());
		x.setPetit(this.slide[0].getValue());
		x.setMoyen(this.slide[1].getValue());
		x.setBarrel(this.slide[2].getValue());
		x.setPenderie(this.slide[3].getValue());
		x.setTableau(this.slide[4].getValue());
		Model v = new Model();
		v.Ecriture(this,x);
		this.j.nCarton(v.getRooms());
	}
	public void change(){
		for(int i = 0;i<5;i++){
			for(int j=0;j<3;j++){
				if(j==0){
					this.lab[i][j].changeText(""+this.slide[i].getValue());
					break;
				}
			}	
		}
		this.longu = this.slide[0].getValue();
		this.larg = this.slide[1].getValue();
		this.haut = this.slide[2].getValue();
		this.elt = this.slide[3].getValue();
		this.longg = this.slide[4].getValue();
	}
}