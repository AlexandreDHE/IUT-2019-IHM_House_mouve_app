import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Action implements ActionListener {
	private Inventaire a;
	public Action(Inventaire b){
		this.a=b;
	}
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("+")){
			this.a.plus();
		}else if(e.getActionCommand().equals("-")){
			this.a.moins();
		}
		else if(e.getActionCommand().equals("Ajouter")){
			this.a.ajout();
		}
	}
}