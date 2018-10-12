import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CarreRond extends JComponent{
	private String b;
	private int i=-1;
	private int cont=0;
	private Menu c;
	public CarreRond(Menu a){
		this.c = a;
	}
	public CarreRond(){}
	public void paintComponent(Graphics pinceau){
		Graphics secondPinceau = pinceau.create();
		if (this.isOpaque()) {
		  secondPinceau.setColor(this.getBackground());
		  secondPinceau.fillRect(0, 0, this.getWidth(), this.getHeight());
		}
		secondPinceau.fillRoundRect(150,0,this.getWidth()-270,this.getHeight()-10,10,10);
		if(this.cont!=1){
			secondPinceau.setColor(this.getBackground());
		}else{
			secondPinceau.setColor(new Color(220,220,220));
		}
		secondPinceau.fillRoundRect(160,10,this.getWidth()-290,this.getHeight()-30,10,10);
		if(i==0){
			secondPinceau.drawImage(Toolkit.getDefaultToolkit().getImage("inventaire.png"),2*this.getWidth()/5,this.getHeight()/5,this);
		}else if(i==1){
			secondPinceau.drawImage(Toolkit.getDefaultToolkit().getImage("cartons.png"),2*this.getWidth()/5,this.getHeight()/5,this);
		}else if(i==2){
			secondPinceau.drawImage(Toolkit.getDefaultToolkit().getImage("modalite.png"),2*this.getWidth()/5,this.getHeight()/5,this);
		}else if(i==3){
			secondPinceau.drawImage(Toolkit.getDefaultToolkit().getImage("devis.png"),2*this.getWidth()/5,this.getHeight()/5,this);
		}
	}
	public void change(int a){
		this.i=a;
		this.repaint();
	}
	public CarreRond getChange(int a){
		CarreRond v = new CarreRond();
		v.change(a);
		return v;
	}
	public void surbrillance(){
		this.cont = 1;
		this.repaint();
	}
	public void desurbrillance(){
		this.cont = 0;
		this.repaint();
	}
	public void inventaire(){
		this.c.inventaire();
	}
	public void carton(){
		this.c.carton();
	}
}