import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Cartons extends JPanel{
	private JPanel pan;
	private CardLayout cc;
	private String[] choix;
	private String name;
	public Cartons(String[] rooms,Fenetre i){
		super();
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		this.choix =rooms;
		this.cc = new CardLayout();
		this.name = this.choix[0];
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1.0f;
		c.weighty = 1.0f;
		c.fill=GridBagConstraints.BOTH;
		Img ret = new Img("ret1.png");
		ret.addMouseListener(new Movve(ret));
		ret.addMouseListener(new Move(i));
		ret.setHorizontalAlignment(JLabel.LEFT);
		this.add(ret,c);
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1.0f;
		c.weighty = 1.0f;
		c.fill=GridBagConstraints.BOTH;
		this.add(new Img("carto.png"),c);
		c.gridx = 2;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1.0f;
		c.weighty = 1.0f;
		c.fill=GridBagConstraints.BOTH;
		this.add(new JPanel(),c);
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1.0f;
		c.weighty = 1.0f;
		c.fill=GridBagConstraints.BOTH;
		this.add(new JPanel(),c);
		this.pan = new JPanel();
		this.pan.setLayout(this.cc);
		this.add(this.pan,c);
		c.gridx = 1;
		c.gridy = 2;
		for(int j=0;j<choix.length;j++){
			AllCarton u = new AllCarton(i,choix[j]);
			this.pan.add(u,""+choix[j]);		
		}
		this.add(this.pan,c);
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 0.0f;
		c.weighty = 1.0f;
		c.fill=GridBagConstraints.NONE;
		JPanel panu = new JPanel();
		panu.setLayout(new GridLayout(1,2));
		JButton add = new JButton("Ajouter un Carton");
		add.addActionListener(new Action(i));
		panu.add(add);
		this.add(panu,c);
		JButton[] boutons = new JButton[choix.length];
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 3;
		c.gridheight = 1;
		c.weightx = 1.0f;
		c.weighty = 0.2f;
		c.fill=GridBagConstraints.BOTH;
		JPanel yup = new JPanel();
		yup.setLayout(new GridLayout(1,choix.length));
		for(int j=0;j<choix.length;j++){
			boutons[j] = new JButton(""+choix[j]);
			boutons[j].addActionListener(new BoutListen(this));
			yup.add(boutons[j]);
		}
		this.add(yup,c);
	}
	public Cartons(Fenetre i){
		super();
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		Model yu = new Model();
		this.choix =yu.getRooms();
		this.name = this.choix[0];
		this.cc = new CardLayout();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1.0f;
		c.weighty = 1.0f;
		c.fill=GridBagConstraints.BOTH;
		Img ret = new Img("ret1.png");
		ret.addMouseListener(new Movve(ret));
		ret.addMouseListener(new Move(i));
		ret.setHorizontalAlignment(JLabel.LEFT);
		this.add(ret,c);
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1.0f;
		c.weighty = 1.0f;
		c.fill=GridBagConstraints.BOTH;
		this.add(new Img("carto.png"),c);
		c.gridx = 2;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1.0f;
		c.weighty = 1.0f;
		c.fill=GridBagConstraints.BOTH;
		this.add(new JPanel(),c);
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 1.0f;
		c.weighty = 1.0f;
		c.fill=GridBagConstraints.BOTH;
		this.add(new JPanel(),c);
		this.pan = new JPanel();
		this.pan.setLayout(this.cc);
		this.add(this.pan,c);
		c.gridx = 1;
		c.gridy = 2;
		for(int j=0;j<choix.length;j++){
			AllCarton u = new AllCarton(i,choix[j]);
			this.pan.add(u,""+choix[j]);		
		}
		this.add(this.pan,c);
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.weightx = 0.0f;
		c.weighty = 1.0f;
		c.fill=GridBagConstraints.NONE;
		JPanel panu = new JPanel();
		panu.setLayout(new GridLayout(1,2));
		JButton add = new JButton("Ajouter un Carton");
		add.addActionListener(new Action(i));
		panu.add(add);
		this.add(panu,c);
		JButton[] boutons = new JButton[choix.length];
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 3;
		c.gridheight = 1;
		c.weightx = 1.0f;
		c.weighty = 0.2f;
		c.fill=GridBagConstraints.BOTH;
		JPanel yup = new JPanel();
		yup.setLayout(new GridLayout(1,choix.length));
		for(int j=0;j<choix.length;j++){
			boutons[j] = new JButton(""+choix[j]);
			boutons[j].addActionListener(new BoutListen(this));
			yup.add(boutons[j]);
		}
		this.add(yup,c);
	}

	public void setRooms(String[] ame){
		this.choix =ame;
	}
	public void showCarton(String ame){
		this.name = ame;
		this.cc.show(this.pan,this.name);
	}
}