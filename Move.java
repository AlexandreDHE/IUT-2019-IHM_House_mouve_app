import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Move implements MouseListener{
	private Inventaire i;
	private Fenetre b;
	public Move(Fenetre a){
		this.b=a;
	}     
	public void mouseEntered(MouseEvent e){
	}
	public void mouseExited(MouseEvent e){
	}
	public void mouseClicked(MouseEvent e){
		this.b.menu();
	}
	public void mousePressed(MouseEvent e){}         
	public void mouseReleased(MouseEvent e){}  
}