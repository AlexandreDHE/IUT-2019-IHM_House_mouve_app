import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Movve implements MouseListener{
	private CarreRond j;
	private Img c;
	private Inventaire i;
	public Movve(CarreRond a){
		this.j=a;
	}
	public Movve(Img a){
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
		CarreRond test = new CarreRond();
		if(e.getComponent().equals(test.getChange(0))){
			this.j.inventaire();
		}else if(e.getComponent().equals(test.getChange(1))){
			this.j.carton();
		}
	}
	public void mousePressed(MouseEvent e){}         
	public void mouseReleased(MouseEvent e){}  
}