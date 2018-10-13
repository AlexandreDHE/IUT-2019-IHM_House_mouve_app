import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Mousse implements MouseListener{
	private Fenetre b;
	public Mousse(Fenetre a){
		this.b=a;
	}  
	public void mouseEntered(MouseEvent e){
	}
	public void mouseExited(MouseEvent e){
	}
	public void mouseClicked(MouseEvent e){
		this.b.carton();
	}
	public void mousePressed(MouseEvent e){}         
	public void mouseReleased(MouseEvent e){}  
}