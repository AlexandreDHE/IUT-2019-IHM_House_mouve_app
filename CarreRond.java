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
		secondPinceau.fillRoundRect(0,0,this.getWidth(),this.getHeight(),10,10);
		if(this.cont!=1){
			secondPinceau.setColor(new Color(205, 192, 156));
		}else{
			secondPinceau.setColor(new Color(245,206,102));
		}
		secondPinceau.fillRoundRect(10,10,this.getWidth()-20,this.getHeight()-20,10,10);
		if(i==0){
			secondPinceau.drawImage(Toolkit.getDefaultToolkit().getImage("inventaire.png"),1*this.getWidth()/5,this.getHeight()/5,this);
		}else if(i==1){
			secondPinceau.drawImage(Toolkit.getDefaultToolkit().getImage("cartons.png"),1*this.getWidth()/5,this.getHeight()/5,this);
		}else if(i==2){
			secondPinceau.drawImage(Toolkit.getDefaultToolkit().getImage("modalite.png"),1*this.getWidth()/5,this.getHeight()/5,this);
		}else if(i==3){
			secondPinceau.drawImage(Toolkit.getDefaultToolkit().getImage("devis.png"),1*this.getWidth()/5,this.getHeight()/5,this);
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