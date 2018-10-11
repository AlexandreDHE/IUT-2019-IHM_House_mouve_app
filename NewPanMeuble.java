import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class NewPanMeuble extends JPanel{
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
	public NewPanMeuble(Fenetre m){
		this.j=m;
		this.setLayout(new GridBagLayout());
		String[] chaines = new String[]{"Nom  :","Longueur (en cm) :","Largeur (en cm) :","Hauteur (en cm) :","Demontable :","Elements :","Longueur + (en cm) :","Largeur + (en cm) :","Hauteur + (en cm) :"};
		JLabel[] chaine = new JLabel[9];
		this.slide = new Slide[7];
		for(int i= 0;i<3;i++)slide[i]=new Slide(10,500,10);
		for(int i= 4;i<7;i++)slide[i]=new Slide(10,500,10);
		slide[3] = new Slide(1,10,1);
		for(int i=0;i<9;i++)chaine[i] = new JLabel(chaines[i]);
		for(int i=0;i<9;i++)chaine[i].setFont(new Font("Arial",Font.PLAIN,25));
		GridBagConstraints c = new GridBagConstraints();
		for(int i=0;i<9;i++){
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
		c.gridx = 1;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.ipadx =10;
		c.ipady = 10;
		this.pan = new JPanel[7];
		this.lab = new Labb[7][3];
		for(int i = 0;i<7;i++){
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
		JCheckBox box = new JCheckBox();
		c.gridx = 1;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.ipadx =10;
		c.ipady = 10;
		box.addItemListener(new JCheck(this));
		this.add(box,c);
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
		this.pan[3] = new JPanel();
		this.pan[3].setLayout(new GridLayout(2,3));
		this.pan[3].add(new JPanel());
		this.pan[3].add(this.lab[3][0]);
		this.pan[3].add(new JPanel());
		this.pan[3].add(this.lab[3][1]);
		this.pan[3].add(this.slide[3]);
		this.pan[3].add(this.lab[3][2]);
		this.pan[4] = new JPanel();
		this.pan[4].setLayout(new GridLayout(2,3));
		this.pan[4].add(new JPanel());
		this.pan[4].add(this.lab[4][0]);
		this.pan[4].add(new JPanel());
		this.pan[4].add(this.lab[4][1]);
		this.pan[4].add(this.slide[4]);
		this.pan[4].add(this.lab[4][2]);
		this.pan[5] = new JPanel();
		this.pan[5].setLayout(new GridLayout(2,3));
		this.pan[5].add(new JPanel());
		this.pan[5].add(this.lab[5][0]);
		this.pan[5].add(new JPanel());
		this.pan[5].add(this.lab[5][1]);
		this.pan[5].add(this.slide[5]);
		this.pan[5].add(this.lab[5][2]);
		this.pan[6] = new JPanel();
		this.pan[6].setLayout(new GridLayout(2,3));
		this.pan[6].add(new JPanel());
		this.pan[6].add(this.lab[6][0]);
		this.pan[6].add(new JPanel());
		this.pan[6].add(this.lab[6][1]);
		this.pan[6].add(this.slide[6]);
		this.pan[6].add(this.lab[6][2]);
		////////////////////////////////////////

		this.longu = this.slide[0].getValue();
		this.larg = this.slide[1].getValue();
		this.haut = this.slide[2].getValue();
		this.elt = this.slide[3].getValue();
		this.longg = this.slide[4].getValue();
		this.largg = this.slide[5].getValue();
		this.hautt = this.slide[6].getValue();
		c.gridx = 1;
		c.gridy = 9;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 0.2f;
		c.weighty = 0.2f;
		JButton bouton = new JButton("Ajouter le meuble");
		bouton.addActionListener(new Action(this,this.field));
		this.add(bouton,c);
		for(int i=0;i<7;i++)this.slide[i].addChangeListener(new Change(this));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
	}
	public void demont(){
		for(int i=3;i<7;i++)this.remove(this.pan[i]);
		this.revalidate();
		this.bool = false;
	}
	public void unmount(){
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 5;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.ipadx =10;
		c.ipady = 10;
		
		this.add(this.pan[3],c);
		c.gridx = 1;
		c.gridy = 6;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.ipadx =10;
		c.ipady = 10;
		
		this.add(this.pan[4],c);
		c.gridx = 1;
		c.gridy = 7;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.ipadx =10;
		c.ipady = 10;
		
		this.add(this.pan[5],c);
		c.gridx = 1;
		c.gridy = 8;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.ipadx =10;
		c.ipady = 10;
		
		this.add(this.pan[6],c);
		this.revalidate();
		this.bool=true;
	}
	public void ecrit(String nom){
		Meuble x = new Meuble();
		x.setNom(this.field.getText());
		x.setLong(this.slide[1].getValue());
		x.setLarg(this.slide[1].getValue());
		x.setHaut(this.slide[2].getValue());
		x.setDemont(this.bool);
		x.setElt(this.slide[3].getValue());
		x.setLongg(this.slide[4].getValue());
		x.setLargg(this.slide[5].getValue());
		x.setHautt(this.slide[6].getValue());
		Model v = new Model();
		v.Ecriture(x);
		this.j.next();
	}
	public void change(){
		for(int i = 0;i<7;i++){
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
		this.largg = this.slide[5].getValue();
		this.hautt = this.slide[6].getValue();
	}
}