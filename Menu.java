import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JPanel{
	private Img retour;
	private Fenetre b;
	public Menu(Fenetre a){
		super();
		this.b=a;
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx=1;
		c.gridy=0;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.insets = new Insets(15,15,15,15);
		c.weightx = 1.0f;
		c.weighty = 1.0f;
		c.fill = GridBagConstraints.BOTH;
		JLabel titre = new JLabel(new ImageIcon("mr.png"));
		this.add(titre,c);
		c.gridx=0;
		this.add(new JPanel(),c);
		c.gridx=2;
		this.add(new JPanel(),c);
		c.gridx=1;
		c.gridy=1;
		CarreRond inventaire = new CarreRond(this);
		inventaire.change(0);
		this.add(inventaire,c);
		c.gridy=2;
		CarreRond cartons = new CarreRond(this);
		cartons.change(1);
		this.add(cartons,c);
		c.gridy=3;
		CarreRond devis = new CarreRond(this);
		devis.change(2);
		this.add(devis,c);
		c.gridy=4;
		CarreRond dev = new CarreRond(this);
		dev.change(3);
		this.add(dev,c);
		inventaire.addMouseListener(new Movve(inventaire));
		cartons.addMouseListener(new Movvve(this,cartons));
		devis.addMouseListener(new Surbrillance(devis));
		dev.addMouseListener(new Surbrillance(dev));
	}
	public void inventaire(){
		this.b.inventaire();
	}
	public void carton(){
		this.b.carton();
	}
}