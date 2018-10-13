import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Fenetre extends JFrame{
	private Img retour;
	private Menu men;
	private Inventaire inv;
	private CardLayout card;
	private Cartons b;
	private NewCarton u;
	private JPanel pan;
	private NewMeuble bn;
	private String[] arg;
	public Fenetre(){
		super();
		this.setSize(1024,942);
		this.card = new CardLayout();
		this.pan = new JPanel();
		this.b = new Cartons(this);
		this.pan.setLayout(this.card);
		this.men = new Menu(this);
		this.inv = new Inventaire(this);
		this.bn = new NewMeuble(this);
		this.u = new NewCarton(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pan.add(this.men,"1");
		this.pan.add(this.inv,"2");
		this.pan.add(this.bn,"3");
		this.pan.add(this.b,"4");
		this.pan.add(this.u,"5");
		this.setResizable(false);
		this.add(pan);
	}
	public void next(){
		this.inv.actu();
		this.card.next(this.pan);
	}
	public void previous(){
		this.inv.actu();
		this.card.previous(this.pan);
	}
	public void nCarton(String[] rooms){
		Cartons u = new Cartons(rooms,this);
		this.pan.remove(this.b);
		this.pan.add(u,"4");
		this.card.show(this.pan,"4");
	}
	public void carton(){
		this.card.show(this.pan,"4");
	}
	public void menu(){
		this.inv.revalidate();
		this.card.show(this.pan,"1");
	}
	public void inventaire(){
		this.card.show(this.pan,"2");
	}
	public void ncarton(){
		this.card.show(this.pan,"5");
	}
}