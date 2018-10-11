import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Mouse implements MouseListener{
	private Fenetre b;
	public Mouse(Fenetre a){
		this.b=a;
	}  
	public void mouseEntered(MouseEvent e){
	}
	public void mouseExited(MouseEvent e){
	}
	public void mouseClicked(MouseEvent e){
		this.b.previous();
	}
	public void mousePressed(MouseEvent e){}         
	public void mouseReleased(MouseEvent e){}  
}