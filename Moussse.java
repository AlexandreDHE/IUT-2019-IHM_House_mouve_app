import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Moussse implements ActionListener{
	private Fenetre b;
	public Moussse(Fenetre a){
		this.b=a;
	}
	@Override
	public void actionPerformed(ActionEvent e){
		this.b.ncarton();
	}  
}