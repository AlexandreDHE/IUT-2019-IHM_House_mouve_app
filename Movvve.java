import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Movvve implements MouseListener{
	private Menu i;
	private Fenetre b;
	private CarreRond y;
	public Movvve(Menu a,CarreRond c){
		this.i=a;
		this.y=c;
	}   
	public void mouseEntered(MouseEvent e){
		this.y.surbrillance();
	}
	public void mouseExited(MouseEvent e){
		this.y.desurbrillance();
	}
	public void mouseClicked(MouseEvent e){
		this.i.carton();
	}
	public void mousePressed(MouseEvent e){}         
	public void mouseReleased(MouseEvent e){}  
}