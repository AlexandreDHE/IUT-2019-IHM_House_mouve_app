import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Inventaire extends JPanel{
	private Img retour;
	private Meuble[] meub;
	private JButton plus = new JButton("+");
	private JButton moins = new JButton("-");
	private int curseur=0;
	private PanMeuble pan;
	private Model y;
	private Fenetre r;
	public Inventaire(Fenetre v){
		super();
		this.r = v;
		this.setLayout(new GridBagLayout());
		this.plus.addActionListener(new Action(this));
		this.moins.addActionListener(new Action(this));
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1.0f;
		c.weighty = 1.0f;
		c.fill=GridBagConstraints.BOTH;
		Img ret = new Img("<.png",this);
		ret.addMouseListener(new Movve(ret));
		ret.setHorizontalAlignment(JLabel.LEFT);
		this.add(ret,c);
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1.0f;
		c.weighty = 1.0f;
		Img inve = new Img("inventair.png");
		inve.setHorizontalAlignment(JLabel.RIGHT);
		this.add(inve,c);
		c.gridx = 2;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1.0f;
		c.weighty = 1.0f;
		this.add(new JPanel(),c);
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1.0f;
		c.weighty = 1.0f;
		this.y = new Model(this);
		this.add(this.y,c);
		this.meub = this.y.getMeuble();
		if(this.meub==null){
			this.y.setVal(0);
		}
		
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 0.4f;
		c.weighty = 0.2f;
		c.fill=GridBagConstraints.NONE;
		this.add(this.moins,c);

		c.gridx = 2;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 0.4f;
		c.weighty = 0.2f;
		this.add(this.plus,c);

		try{
			c.gridx = 1;
			c.gridy = 2;
			c.gridwidth = 1;
			c.gridheight = 1;
			c.weightx = 1.0f;
			c.weighty = 1.0f;
			c.fill=GridBagConstraints.BOTH;
			this.pan = new PanMeuble(this.meub[this.curseur]);
			this.add(this.pan,c);
		}catch(NullPointerException e){}
		
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1.0f;
		c.weighty = 1.0f;
		c.fill=GridBagConstraints.NONE;
		JButton but = new JButton("Ajouter");
		but.addActionListener(new Action(this));
		this.add(but,c);
	}
	public void plus(){
		if(this.curseur<this.meub.length-1){
			this.curseur++;
		}
		this.change();
	}
	public void change(){
		this.remove(this.pan);
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1.0f;
		c.weighty = 1.0f;
		c.fill=GridBagConstraints.BOTH;
		this.pan = new PanMeuble(this.meub[this.curseur]);
		this.add(this.pan,c);
		this.y.setVal(this.curseur+1);
		this.revalidate();
	}
	public void moins(){
		if(this.curseur>0){
			this.curseur--;
		}

		this.change();
	}
	public void menu(){
		this.r.previous();
	}
	public void supp(){
		this.y.delete(this.meub[this.curseur]);
		this.curseur--;
	}
	public void actu(){
		this.meub = this.y.getMeuble();
	}
	public void ajout(){
		this.r.next();
	}
}