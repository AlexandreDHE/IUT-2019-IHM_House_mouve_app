import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JPanel{
	private Img retour;
	private Fenetre b;
	public Menu(Fenetre a){
		super();
		this.b=a;
		GridLayout grid = new GridLayout(5,1);
		grid.setVgap(75);
		this.setLayout(grid);
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(1,3));
		JLabel titre = new JLabel(new ImageIcon("mr.png"));
		titre.setHorizontalAlignment(JLabel.CENTER);
		JPanel e = new JPanel();
		pan.add(e);
		pan.add(titre);
		pan.add(new JPanel());
		this.add(pan,BorderLayout.CENTER);
		CarreRond inventaire = new CarreRond(this);
		inventaire.change(0);
		CarreRond cartons = new CarreRond(this);
		cartons.change(1);
		CarreRond devis = new CarreRond(this);
		devis.change(2);
		CarreRond dev = new CarreRond(this);
		dev.change(3);
		inventaire.addMouseListener(new Movve(inventaire));
		cartons.addMouseListener(new Movvve(this,cartons));
		devis.addMouseListener(new Movve(devis));
		dev.addMouseListener(new Movve(dev));
		this.add(inventaire);
		this.add(cartons);
		this.add(devis);
		this.add(dev);
	}
	public void inventaire(){
		this.b.next();
	}
	public void carton(){
		this.b.carton();
	}
}