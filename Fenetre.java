import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Fenetre extends JFrame{
	private Img retour;
	private Menu men;
	private Inventaire inv;
	private CardLayout card; 
	private JPanel pan;
	private NewMeuble bn;
	public Fenetre(){
		super();
		this.setSize(1024,942);
		this.card = new CardLayout();
		this.pan = new JPanel();
		this.pan.setLayout(this.card);
		this.men = new Menu(this);
		this.inv = new Inventaire(this);
		this.bn = new NewMeuble(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pan.add(this.men,"1");
		this.pan.add(this.inv,"2");
		this.pan.add(this.bn,"3");
		this.add(pan);
	}
	public void next(){
		this.card.next(this.pan);
	}
	public void previous(){
		this.card.previous(this.pan);
	}
}