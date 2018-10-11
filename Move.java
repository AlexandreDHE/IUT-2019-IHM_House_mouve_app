import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Move implements MouseListener{
	private Inventaire i;
	public Move(Inventaire a){
		this.i=a;
	}     
	public void mouseEntered(MouseEvent e){
	}
	public void mouseExited(MouseEvent e){
	}
	public void mouseClicked(MouseEvent e){
		this.i.supp();
	}
	public void mousePressed(MouseEvent e){}         
	public void mouseReleased(MouseEvent e){}  
}