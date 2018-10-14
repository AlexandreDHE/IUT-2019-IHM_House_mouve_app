import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Img extends JLabel{
	private Inventaire b;
	public Img(String a,Inventaire i){
		super(new ImageIcon(a));
		this.b = i;
		this.setPreferredSize(new Dimension(20,20));
	}
	public Img(String a){
		super(new ImageIcon(a));
		this.setPreferredSize(new Dimension(20,20));
	}
	public void retour(){
		this.setIcon(new ImageIcon("ret2.png"));
		this.repaint();
	}
	public void nretour(){
		this.setIcon(new ImageIcon("ret1.png"));
		this.repaint();
	}
}