import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Surbrillance implements MouseListener{
	private CarreRond j;
	private Img c;
	private Inventaire i;
	public Surbrillance(CarreRond a){
		this.j=a;
	}
	public Surbrillance(Img a){
		this.c=a;
	}       
	public void mouseEntered(MouseEvent e){
		if(e.getComponent().equals(this.j)){
			this.j.surbrillance();
		}else{
			this.c.retour();
		}
	}
	public void mouseExited(MouseEvent e){
		if(e.getComponent().equals(this.j)){
			this.j.desurbrillance();
		}else{
			this.c.nretour();
		}
	}
	public void mouseClicked(MouseEvent e){
	}
	public void mousePressed(MouseEvent e){}         
	public void mouseReleased(MouseEvent e){}  
}