import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Listen implements MouseListener{
	private Fenetre b;
	public Listen(Fenetre a){
		this.b=a;
	}  
	public void mouseEntered(MouseEvent e){
	}
	public void mouseExited(MouseEvent e){
	}
	public void mouseClicked(MouseEvent e){
		this.b.inventaire();
	}
	public void mousePressed(MouseEvent e){}         
	public void mouseReleased(MouseEvent e){}  
}