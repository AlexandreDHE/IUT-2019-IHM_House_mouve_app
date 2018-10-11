import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Control{
	public static void main(String[] args){
		try{	
			try{
				try{
					try{
						UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
						Fenetre a = new Fenetre();
						a.setVisible(true);
					}catch(ClassNotFoundException e){}
				}catch(InstantiationException e){}
			}catch(IllegalAccessException e){}
		}catch(UnsupportedLookAndFeelException e){}
	}
}